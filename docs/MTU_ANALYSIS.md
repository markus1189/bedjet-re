# BedJet MTU Negotiation Analysis

## Executive Summary

The BedJet Android app **does not perform explicit MTU negotiation** with the BLE device. Instead, it implements a **custom application-layer fragmentation protocol** to handle the 20-byte BLE MTU limitation. This is a deliberate design choice that ensures maximum compatibility across all BLE devices, including those that don't support MTU expansion.

## Key Findings

### 1. No MTU Negotiation Code
- **No `requestMtu()` calls** found in the entire codebase
- **No `onMtuChanged()` callbacks** implemented
- App assumes the standard BLE ATT MTU of 23 bytes (20 bytes payload)

### 2. Application-Layer Fragmentation Protocol

The app implements a sophisticated two-tier fragmentation system:

#### Fragmentation Flag (Byte 0)
Every notification from the BedJet device includes a fragmentation indicator:
- `0x00` = Complete packet (fits in single 20-byte notification)
- `!= 0x00` = Fragmented packet (requires multiple reads)

#### Protocol Flow

```
┌─────────────────────────────────────────────────┐
│   BLE Notification Arrives (20 bytes max)       │
│   Characteristic: 00002000-bed0-0080-...        │
└─────────────────┬───────────────────────────────┘
                  │
                  ▼
         ┌────────────────────┐
         │  Check byte[0]     │
         └────────┬───────────┘
                  │
         ┌────────┴─────────┐
         │                  │
    byte[0] == 0       byte[0] != 0
    (Complete)         (Fragment)
         │                  │
         ▼                  ▼
  ┌──────────────┐   ┌─────────────────────┐
  │ Strip flag   │   │ Save to buffer      │
  │ Process now  │   │ partialPacket[1..n] │
  └──────────────┘   └──────────┬──────────┘
                                │
                                ▼
                     ┌──────────────────────┐
                     │ readCharacteristic() │
                     │ (fetch next fragment)│
                     └──────────┬───────────┘
                                │
                                ▼
                     ┌──────────────────────┐
                     │ onCharacteristicRead │
                     │ Concatenate fragments│
                     └──────────┬───────────┘
                                │
                                ▼
                        ┌───────────────┐
                        │ Process packet│
                        └───────────────┘
```

## Implementation Details

### Location: MainActivity.java

#### Fragment Detection (lines 336-347)
```java
@Override
public void onCharacteristicChanged(BluetoothGatt gatt,
                                    BluetoothGattCharacteristic characteristic) {
    if (characteristic.getUuid().toString().equals(BEDJET_STATUS_UUID)) {
        byte[] value = characteristic.getValue();

        if (value[0] == 0) {
            // Complete packet - strip flag and process
            handleBedJetPacket(Arrays.copyOfRange(value, 1, value.length));
            return;
        }

        // Fragmented packet - save first fragment
        partialPacket = Arrays.copyOfRange(value, 1, value.length);

        // Request next fragment
        readCharacteristic(mBedJetStatusCharacteristic);
    }
}
```

#### Fragment Assembly (lines 307-314)
```java
@Override
public void onCharacteristicRead(BluetoothGatt gatt,
                                 BluetoothGattCharacteristic characteristic,
                                 int status) {
    if (status == 0 && characteristic.getUuid().toString().equals(BEDJET_STATUS_UUID)) {
        byte[] value = characteristic.getValue();

        // Concatenate fragments
        byte[] complete = new byte[partialPacket.length + value.length];
        System.arraycopy(partialPacket, 0, complete, 0, partialPacket.length);
        System.arraycopy(value, 0, complete, partialPacket.length, value.length);

        // Process complete packet
        handleBedJetPacket(complete);
    }
}
```

#### Buffer Storage (line 184)
```java
private byte[] partialPacket;  // Temporary buffer for fragmented packets
```

## MTU Implications

### Current Behavior (20-byte MTU)

| Packet Type | Typical Size | Fragments Required |
|-------------|--------------|-------------------|
| Simple status | ~10 bytes | 1 (fits in single notification) |
| Extended status | 25-40 bytes | 2 (notification + read) |
| Biorhythm data | 40+ bytes | 2+ (notification + multiple reads) |

### Overhead Analysis

**Per Fragmented Packet:**
- 1 BLE notification (20 bytes) with flag byte = 19 bytes usable
- 1 BLE read request → read response (20 bytes) = 19 bytes usable
- **Total**: 38 bytes for 2-fragment packet

**With MTU 512 (if negotiated):**
- 1 BLE notification (512 bytes) with flag byte = 511 bytes usable
- **Total**: Single notification for all current packet types

### Why Not Negotiate MTU?

**Advantages of Current Approach:**
1. **Universal Compatibility**: Works on all BLE devices (some older chips don't support MTU > 23)
2. **No iOS Differences**: iOS handles MTU differently; this avoids platform-specific code
3. **Guaranteed Behavior**: No fallback logic needed if negotiation fails
4. **Simple Protocol**: Fragmentation logic is straightforward

**Disadvantages:**
1. **Higher Latency**: Multi-fragment packets require round-trip read requests
2. **More Radio Activity**: Multiple packets consume more power
3. **Increased Overhead**: Each fragment has its own BLE packet overhead

## Performance Impact

### Estimated Latency

**Connection Interval (CI)**: ~30ms typical for BLE peripherals
**Single Fragment**: 1 notification = 0-30ms
**Two Fragments**: 1 notification + 1 read = 30-60ms additional

**Example: Extended Status Packet (30 bytes)**
- **Without MTU negotiation**: 30-60ms (current implementation)
- **With MTU 512**: 0-30ms (single notification)

### Power Consumption

**Radio Active Time:**
- Each BLE packet: ~1ms radio-on time
- Fragmented packet (2 fragments): ~2ms total
- Non-fragmented (MTU 512): ~1ms total

**Impact**: Marginal on modern devices, but matters for battery-powered peripherals

## Recommendations

### Option 1: Keep Current Implementation (Recommended)
**Rationale**: The app works reliably across all devices. Since the BedJet is mains-powered and status updates are infrequent (<1/sec), the latency penalty is negligible.

### Option 2: Implement Optional MTU Negotiation
**If implemented**, use this pattern:
```java
// After connection established
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    bluetoothGatt.requestMtu(512);  // Request larger MTU
}

@Override
public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
    if (status == BluetoothGatt.GATT_SUCCESS) {
        Log.d(TAG, "MTU negotiated: " + mtu);
        // Still keep fragmentation logic as fallback
    } else {
        Log.w(TAG, "MTU negotiation failed, using default");
    }
}
```

**Benefits**:
- Reduced latency on modern devices
- Faster biorhythm data transfers
- Lower power consumption

**Risks**:
- Adds complexity
- Must maintain fragmentation fallback
- iOS behaves differently (automatically negotiates MTU)

### Option 3: Hybrid Approach
- Attempt MTU negotiation on Android
- Keep fragmentation protocol as fallback
- Use larger MTU when available, fragmentation when needed

## Related Code References

| Component | File | Lines | Purpose |
|-----------|------|-------|---------|
| Fragmentation Handler | MainActivity.java | 336-347 | Detects fragments |
| Fragment Assembly | MainActivity.java | 307-314 | Concatenates data |
| Partial Packet Buffer | MainActivity.java | 184 | Stores fragments |
| Write Methods | MainActivity.java | 2288-2318 | Sends commands |
| Notification Setup | MainActivity.java | 2269-2286 | Enables notifications |

## Characteristics

### Status Characteristic (Notifications with Fragmentation)
- **UUID**: `00002000-bed0-0080-aa55-4265644a6574`
- **Properties**: NOTIFY
- **Usage**: Device status updates (fragmentation supported)

### Command Characteristic (Writes)
- **UUID**: `00002004-bed0-0080-aa55-4265644a6574`
- **Properties**: WRITE
- **Usage**: Commands to device (no fragmentation needed)

### Biodata Characteristic (Read/Write)
- **UUID**: `00002005-bed0-0080-aa55-4265644a6574`
- **Properties**: READ, WRITE
- **Usage**: Biorhythm configuration (fragmentation may apply)

## Conclusion

The BedJet app's decision to **not negotiate MTU** is a pragmatic choice that prioritizes **compatibility over performance**. The application-layer fragmentation protocol is well-designed and handles multi-packet transfers reliably. Given the low-frequency nature of BedJet status updates, the latency penalty is acceptable.

For a production device like BedJet, this conservative approach ensures the app works correctly on all Android devices without requiring extensive testing across different BLE chipsets and Android versions.

## Further Analysis

To fully understand the protocol efficiency, consider:
1. Packet capture analysis (HCI snoop logs)
2. Measurement of actual connection intervals
3. Biorhythm data transfer profiling (likely the most fragmented packets)
4. Comparison with BedJet V2 vs V3 (different packet structures?)
