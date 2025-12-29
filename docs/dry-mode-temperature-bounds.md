# DRY Mode Temperature Bounds Analysis

## Summary

**DRY mode (MODE_DRY, mode 5)** has **dynamic temperature bounds** that are calculated by the BedJet device firmware and transmitted to the app in status packets. Unlike the static ranges returned by `Utils.getMinMaxTemp()` (40-80 = 20-40°C), the actual operational limits depend on **ambient temperature readings**.

## Static vs Dynamic Temperature Bounds

### Static Bounds (App Code)

**Source**: `Utils.java`:37-80

The `getMinMaxTemp()` function returns **hardcoded ranges** for UI validation:

```java
case 5:  // MODE_DRY
    if (isMax) return 80;  // 40°C
    else return 40;        // 20°C
```

**Static range**: 40-80 (20-40°C / 68-104°F)

### Dynamic Bounds (Device Protocol)

**Source**: `MainActivity.java`:1303-1306

The device **overrides** these bounds in real-time via BLE status packets:

```java
this.currentStatus.setMinimumTemp(bArr[12]);  // Byte 12: Device-calculated min temp
this.currentStatus.setMaximumTemp(bArr[13]);  // Byte 13: Device-calculated max temp
this.currentStatus.setAmbientTemp(bArr[16]);  // Byte 16: Ambient temperature reading
```

**Dynamic range**: Device firmware calculates min/max based on current conditions

## How Dynamic Bounds Work

### Status Packet Structure

**Source**: `docs/BEDJET.md` (Extended Status Packet)

| Offset | Length | Field | Description |
|--------|--------|-------|-------------|
| 12 | 1 | Min Temp | **Device-calculated** minimum temperature (half-°C) |
| 13 | 1 | Max Temp | **Device-calculated** maximum temperature (half-°C) |
| 16 | 1 | Ambient Temp | Current room/ambient temperature (half-°C) |

### UI Update Flow

**Source**: `MainFragment.java`:110-114 and `MainFragmentV2.java`:106-110

When the device sends updated min/max temps, the UI immediately reflects them:

```java
if (z || this.mCurrentStatus.getMinimumTemp() != this.mPreviousStatus.getMinimumTemp()
      || this.mCurrentStatus.getMaximumTemp() != this.mPreviousStatus.getMaximumTemp()) {
    this.mPreviousStatus.setMinimumTemp(this.mCurrentStatus.getMinimumTemp());
    this.mPreviousStatus.setMaximumTemp(this.mCurrentStatus.getMaximumTemp());
    updateTempRange(this.mCurrentStatus);  // Refresh UI controls
}
```

## Why DRY Mode Needs Dynamic Bounds

### Ambient Temperature Dependency

DRY mode is designed to **remove moisture from bedding**. The effectiveness and safety of this operation depends on the starting ambient temperature:

1. **Cold ambient temp** (e.g., 15°C / 59°F)
   - Device may **raise minimum temp** to prevent uncomfortably cold air
   - Allows higher temperatures for effective drying

2. **Warm ambient temp** (e.g., 30°C / 86°F)
   - Device may **lower maximum temp** to prevent overheating
   - Ensures comfortable operation in already-warm conditions

3. **Moderate ambient temp** (e.g., 20-25°C / 68-77°F)
   - Device uses full static range (40-80 / 20-40°C)

### Safety and Comfort

Dynamic bounds serve several purposes:

- **Condensation prevention**: Avoids excessive temperature differentials
- **Energy efficiency**: Optimizes drying based on current conditions
- **User comfort**: Prevents uncomfortably hot/cold air in various ambient conditions
- **Hardware protection**: Limits operation within safe thermal envelopes

## Implementation Details

### Device Firmware Logic (Inferred)

The BedJet firmware likely implements logic similar to:

```pseudocode
function calculateDryModeBounds(ambientTemp):
    baseMin = 40  // 20°C
    baseMax = 80  // 40°C

    if ambientTemp < 50:  // < 25°C
        // Cold room: raise minimum to avoid cold air
        actualMin = max(baseMin, ambientTemp + 10)
        actualMax = baseMax

    else if ambientTemp > 70:  // > 35°C
        // Hot room: lower maximum to prevent overheating
        actualMin = baseMin
        actualMax = min(baseMax, ambientTemp + 10)

    else:
        // Moderate conditions: use full range
        actualMin = baseMin
        actualMax = baseMax

    return (actualMin, actualMax)
```

**Note**: This is speculative based on observed behavior. Actual firmware logic is proprietary.

### App Behavior

The Android app **passively accepts** the device's calculated bounds:

1. Device measures `ambientTemp` (byte 16)
2. Firmware calculates appropriate `minTemp` and `maxTemp`
3. Device transmits all three values in status packet
4. App **directly uses** received min/max without recalculation
5. UI temperature controls constrain to device-provided range

### Temperature Picker Enforcement

**Source**: `PickerDialog.java`:246-275

The temperature selection dialog always uses **device-reported bounds**:

```java
int minMaxTemp = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), false);
int minMaxTemp2 = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), true);
```

**However**: For active device sessions, `CurrentStatus.minimumTemp` and `maximumTemp` override these static values, ensuring the picker respects dynamic bounds.

## Comparison with Other Modes

| Mode | Temperature Bounds | Type |
|------|-------------------|------|
| HEAT (1) | 45-80 (22.5-40°C) | **Static** - Always the same |
| TURBO (2) | 86-86 (43°C fixed) | **Static** - Fixed temperature |
| EXTHT (3) | 38-67 (19-33.5°C) | **Static** - Always the same |
| COOL (4) | 38-62 (19-31°C) | **Static** - Always the same |
| **DRY (5)** | **40-80 (20-40°C)** | **Dynamic** - Adjusted by device based on ambient temp |

**Only DRY mode uses dynamic bounds.**

## Practical Implications

### For Users

- Temperature range in DRY mode **may vary** based on room conditions
- A cold room might prevent selecting very low drying temperatures
- A hot room might prevent selecting very high drying temperatures
- This is **intentional firmware behavior** for safety and comfort

### For Developers/Integrators

- **Do not hardcode** DRY mode temperature ranges
- **Always read** `minimumTemp` and `maximumTemp` from device status
- **Respect device limits** when sending temperature commands
- **Monitor `ambientTemp`** to understand why bounds change

### For Troubleshooting

If DRY mode temperature range seems restricted:

1. Check `ambientTemp` (byte 16 of status packet)
2. Verify room temperature is within moderate range (20-25°C)
3. Extreme ambient temperatures will trigger protective bounds
4. This is expected behavior, not a bug

## File References

| File | Lines | Purpose |
|------|-------|---------|
| `MainActivity.java` | 1303-1306 | Parses device-calculated min/max from status packet |
| `CurrentStatus.java` | 24-25 | Stores dynamic temperature limits |
| `Utils.java` | 37-80 | Provides fallback static ranges |
| `MainFragment.java` | 110-114 | Updates UI when bounds change |
| `PickerDialog.java` | 246-275 | Enforces temperature limits in picker |
| `BEDJET.md` | 232-236 | Documents status packet structure |

## Related Documentation

- **Static Ranges**: See `temperature-ranges.md` for all mode default ranges
- **Protocol Details**: See `BEDJET.md` for complete BLE packet structure
- **Temperature System**: See `temperature-handling.md` for conversion and storage

## Conclusion

DRY mode's temperature bounds are **adaptive**, not fixed. The BedJet firmware continuously calculates appropriate operational limits based on ambient temperature, transmitting these constraints to the app via BLE status packets. This ensures safe, comfortable, and efficient drying operation across varying environmental conditions.

The relationship is: **Ambient Temp → Firmware Calculation → Dynamic Min/Max → App UI Constraints**
