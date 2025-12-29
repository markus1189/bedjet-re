# BedJet V3 Biorhythm Protocol Documentation

## Overview

The BedJet Biorhythm system allows users to program automated sleep schedules with up to 32 steps per sequence. The device stores 3 independent sequences (Bio1, Bio2, Bio3) via Bluetooth Low Energy (BLE) GATT characteristics.

## Data Model

### SequenceStep (V3) Structure

**File:** `data/local/model/SequenceStep.java`

```java
public class SequenceStep {
    private int mode;         // Operating mode (0-6)
    private int fanStep;      // Fan speed (0-19, maps to 5-100%)
    private int hours;        // Hours component (0-23 for clocktime, 0-11 for duration)
    private int minutes;      // Minutes component (0-59)
    private int temperature;  // Temperature in half-degrees Celsius (e.g., 40 = 20°C)
    private boolean clocktime;// True = wall clock time, False = duration
    private boolean enabled;  // Step enabled flag
}
```

**Default Values:**
- mode: 6 (MODE_WAIT)
- fanStep: 19 (maximum, 100%)
- hours: 1
- minutes: 0
- temperature: 40 (20°C)
- clocktime: false

**Mode Constants** (`Constants.java:86-96`):
- `0` = STANDBY (off)
- `1` = HEAT
- `2` = TURBO (turbo heat)
- `3` = EXTHT (extended heat)
- `4` = COOL
- `5` = DRY
- `6` = WAIT (delay/pause)

**Fan Speed Encoding:**
- Range: 0-19
- Maps to: 5% - 100% (5% increments)
- Formula: `fanPercent = 5 + (fanStep * 5)`

**Temperature Encoding:**
- Unit: Half-degrees Celsius
- Example: `40` = 20.0°C, `41` = 20.5°C, `80` = 40.0°C
- Typical range: 33-100 (16.5°C - 50°C)

**Clocktime Flag:**
- `false`: hours/minutes represent **duration** (how long to run this step)
- `true`: hours/minutes represent **wall clock time** (when to end this step)

## BLE Protocol

### GATT Characteristics

**Service UUID:** `00001000-bed0-0080-aa55-4265644a6574`

**Key Characteristics:**
- **Status:** `00002000-bed0-0080-aa55-4265644a6574` (notifications)
- **Command:** `00002004-bed0-0080-aa55-4265644a6574` (write)
- **Biodata:** `00002005-bed0-0080-aa55-4265644a6574` (read/write with notifications)

### Command Structure

**Read Command** (`MainActivity.java:1169-1180`):
```
COMMAND_BIOREQUEST = 65 (0x41)
Packet: [65, fragmentID, tag]
```

**Write Command** (`MainActivity.java:1182-1190`):
```
COMMAND_BIOCOMMAND = 64 (0x40)
Packet: [64, fragmentID, ...payload (41 bytes)]
```

**Tag Field:**
- Increments with each request (1-255, wraps to 1)
- Used to match requests with responses
- Prevents processing stale packets

## Fragment Protocol

### Fragment ID Mapping

**Formula:** `fragmentID = (sequenceNum * 4) + 7`

**Sequence 0 (Bio1):** Fragments 7, 8, 9, 10
**Sequence 1 (Bio2):** Fragments 11, 12, 13, 14
**Sequence 2 (Bio3):** Fragments 15, 16, 17, 18

**Special Fragment IDs:**
- `4` = Biorhythm names (read all 3 names)
- `5` = Also returns biorhythm names
- `6` = Also returns biorhythm names

### Fragment to Step Mapping

Each sequence supports up to 32 steps, split across 4 fragments:

| Fragment | Step Range | Calculation |
|----------|------------|-------------|
| 0 (e.g., 7)  | 0-7   | `((fragID - 7) & 3) * 8 = 0 * 8 = 0` |
| 1 (e.g., 8)  | 8-15  | `((fragID - 7) & 3) * 8 = 1 * 8 = 8` |
| 2 (e.g., 9)  | 16-23 | `((fragID - 7) & 3) * 8 = 2 * 8 = 16` |
| 3 (e.g., 10) | 24-31 | `((fragID - 7) & 3) * 8 = 3 * 8 = 24` |

**Code Reference:** `BiorhythmFragment.java:1005`
```java
int stepOffset = ((fragmentID - 7) & 3) * 8;
```

## Packet Format

### Write Payload Structure

**Size:** 41 bytes total (`BiorhythmFragment.java:1003`)

**Byte Layout:**
```
Offset | Size | Description
-------|------|-------------
0      | 1    | Total step count in sequence (0-32)
1-5    | 5    | Step 0 data
6-10   | 5    | Step 1 data
11-15  | 5    | Step 2 data
16-20  | 5    | Step 3 data
21-25  | 5    | Step 4 data
26-30  | 5    | Step 5 data
31-35  | 5    | Step 6 data
36-40  | 5    | Step 7 data
```

### Step Encoding (5 bytes per step)

**Code Reference:** `BiorhythmFragment.java:1015-1023`

```java
bArr[i5 + 1] = (byte) step.getMode();
bArr[i5 + 2] = (byte) step.getFanStep();
bArr[i5 + 3] = (byte) step.getTemperature();
bArr[i5 + 4] = (byte) step.getHours();
bArr[i5 + 5] = (byte) step.getMinutes();
if (step.isClocktime()) {
    bArr[i5 + 4] |= 0x80;  // Set bit 7 of hours byte
}
```

**Step Byte Layout:**
```
Offset | Field       | Type  | Description
-------|-------------|-------|----------------------------------
0      | mode        | uint8 | Operating mode (0-6)
1      | fanStep     | uint8 | Fan speed (0-19)
2      | temperature | uint8 | Temp in half-degrees C (33-100)
3      | hours       | uint8 | Hours (bits 0-6) + clocktime flag (bit 7)
4      | minutes     | uint8 | Minutes (0-59)
```

**Hours Byte Encoding:**
- Bits 0-6: Hour value (0-23 for clocktime, 0-11 for duration)
- Bit 7: Clocktime flag (0 = duration, 1 = wall clock time)
- Decode: `hours = hoursByte & 0x7F`, `clocktime = (hoursByte & 0x80) != 0`

### Read Response Structure

**Code Reference:** `BiorhythmFragment.java:354-421`

**Response Format:**
```
[requestID, tag, ...payload]
```

**For Fragment Reads (IDs 7-19):**

```java
byte[] response = {
    requestID,      // Echo of requested fragment ID
    tag,            // Echo of request tag
    stepCount,      // Total steps in sequence (0-32)
    // Step data (5 bytes × up to 8 steps)
    mode0, fan0, temp0, hours0, mins0,
    mode1, fan1, temp1, hours1, mins1,
    // ... up to 8 steps
};
```

**Decoding Steps** (`BiorhythmFragment.java:400-407`):
```java
for (int i = 0; i < stepsInFragment; i++) {
    int offset = i * 5;
    byte mode = payload[offset + 1];
    byte fan = payload[offset + 2];
    byte temp = payload[offset + 3];
    byte hours = payload[offset + 4];
    byte mins = payload[offset + 5];

    SequenceStep step = new SequenceStep(
        mode,
        fan,
        hours & 0x7F,           // Mask off clocktime bit
        mins,
        temp,
        (hours & 0x80) != 0     // Extract clocktime flag
    );
}
```

### Biorhythm Names Response

**Request ID:** 4 (or 5, 6)

**Code Reference:** `BiorhythmFragment.java:364-385`

**Payload Structure:** 48 bytes total (3 names × 16 bytes)

```
Offset | Size | Description
-------|------|------------------
0-15   | 16   | Bio1 name (15 chars + status byte)
16-31  | 16   | Bio2 name (15 chars + status byte)
32-47  | 16   | Bio3 name (15 chars + status byte)
```

**Name Encoding:**
- If first byte = `0x01`: Slot is empty (no sequence saved)
- Otherwise: ASCII string (up to 15 characters), typically null-terminated

**Decoding:**
```java
if (payload[0] == 1) {
    bioname1 = null;  // Empty slot
} else {
    bioname1 = new String(payload, 0, 15).trim();
}
```

## Command Flow

### Writing a Sequence

**Code Reference:** `BiorhythmFragment.java:994-1027`

1. **Calculate starting fragment ID:**
   ```java
   int startFragment = (sequenceNum * 4) + 7;
   // sequenceNum: 0=Bio1, 1=Bio2, 2=Bio3
   ```

2. **Write first fragment:**
   ```java
   sendBioCommand(fragmentID, payload);  // 64, fragmentID, 41-byte payload
   ```

3. **Wait for `biodataWritten()` callback** (`BiorhythmFragment.java:338-345`)

4. **Write next fragment if needed:**
   ```java
   int fragmentsNeeded = (stepCount - 1) / 8;  // 0-3 fragments
   if (currentFragment - startFragment < fragmentsNeeded) {
       writeBioFragment(currentFragment + 1);
   }
   ```

5. **After all fragments written, prompt for sequence name**

**Example for 20-step sequence in Bio1:**
- Fragment 7: Steps 0-7 (payload[0] = 20)
- Fragment 8: Steps 8-15 (payload[0] = 20)
- Fragment 9: Steps 16-19 (payload[0] = 20, only 4 steps encoded)

### Reading a Sequence

**Code Reference:** `BiorhythmFragment.java:987-992`

1. **Request first fragment:**
   ```java
   int startFragment = (sequenceNum * 4) + 7;
   requestWithRetry(startFragment);  // Sends [65, fragmentID, tag]
   ```

2. **Parse response in `biodataAvailable()`** (`BiorhythmFragment.java:327-421`)

3. **Check if more fragments needed:**
   ```java
   int totalSteps = payload[0];
   int nextFragmentFirstStep = (fragmentNum + 1) * 8;
   if (totalSteps > nextFragmentFirstStep) {
       requestWithRetry(++currentFragment);
   }
   ```

4. **Repeat until all steps received**

### Reading Biorhythm Names

**Code Reference:** `BiorhythmFragment.java:317-319`

```java
requestWithRetry(4);  // Request bionames
```

Response contains all 3 names (48 bytes).

## Complete Examples

### Example 1: Simple 3-Step Sleep Sequence

**Steps:**
1. Heat @ 72°F (22.2°C), fan 100%, for 15 minutes (fall asleep)
2. Cool @ 66°F (18.9°C), fan 50%, for 7 hours (sleep)
3. Wait mode for 30 minutes (wake gradually)

**Encoding:**

```
Step 0: mode=1 (HEAT), fan=19 (100%), temp=44 (22°C), hours=0, mins=15, clocktime=0
  Bytes: 01 13 2C 00 0F

Step 1: mode=4 (COOL), fan=9 (50%), temp=38 (19°C), hours=7, mins=0, clocktime=0
  Bytes: 04 09 26 07 00

Step 2: mode=6 (WAIT), fan=0, temp=40, hours=0, mins=30, clocktime=0
  Bytes: 06 00 28 00 1E
```

**Fragment 7 Payload (41 bytes):**
```
Hex:
03 01 13 2C 00 0F 04 09 26 07 00 06 00 28 00 1E
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
00 00 00 00 00 00 00 00 00

Breakdown:
03          - Total step count = 3
01 13 2C 00 0F - Step 0
04 09 26 07 00 - Step 1
06 00 28 00 1E - Step 2
00 00 00 00 00 - Step 3 (unused)
00 00 00 00 00 - Step 4 (unused)
00 00 00 00 00 - Step 5 (unused)
00 00 00 00 00 - Step 6 (unused)
00 00 00 00 00 - Step 7 (unused)
```

**Complete BLE Write Command:**
```
[0x40, 0x07, 0x03, 0x01, 0x13, 0x2C, 0x00, 0x0F, ...]
  |     |     |     |---- Step data starts here
  |     |     |---------- Total step count
  |     |---------------- Fragment ID (7 = Bio1, fragment 0)
  |---------------------- Command (0x40 = BIOCOMMAND)
```

### Example 2: Sequence with Clocktime

**Scenario:** Cool until 6:30 AM

**Step:**
- mode=4 (COOL), fan=14 (75%), temp=36 (18°C), until 6:30 AM

**Encoding:**
```
mode=4, fan=14, temp=36, hours=6, mins=30, clocktime=1

Bytes: 04 0E 24 86 1E
                  |
                  +-- 0x86 = 0b10000110 = bit7 set + 6
```

**Fragment 7 Payload:**
```
01 04 0E 24 86 1E 00 00 00 00 00 ... (rest zeros)
|  |  |  |  |  |
|  |  |  |  |  +-- Minutes: 30 (0x1E)
|  |  |  |  +----- Hours: 6 with clocktime bit (0x86 = 0b10000110)
|  |  |  +-------- Temperature: 36 (18°C)
|  |  +----------- Fan: 14 (75%)
|  +-------------- Mode: 4 (COOL)
+----------------- Step count: 1
```

### Example 3: Reading Bio2 (10 steps)

**Request Sequence:**

```
Step 1: Send [0x41, 0x0B, 0x01]  // Request fragment 11 (Bio2, frag 0)
        Receive: [0x0B, 0x01, 0x0A, ...step 0-7 data...]
                         |     |
                         |     +-- 10 total steps
                         +-------- Tag match

Step 2: Send [0x41, 0x0C, 0x02]  // Request fragment 12 (Bio2, frag 1)
        Receive: [0x0C, 0x02, 0x0A, ...step 8-9 data...]
                                |
                                +-- Still 10 total, only 2 steps in this fragment
```

**Fragment 11 Response (43 bytes):**
```
[0x0B, 0x01, 0x0A, <40 bytes of step data>]
   |     |     |
   |     |     +-- Total steps = 10
   |     +-------- Tag = 1
   +-------------- Fragment ID = 11
```

**Fragment 12 Response (43 bytes):**
```
[0x0C, 0x02, 0x0A, <10 bytes for steps 8-9>, <30 bytes unused>]
```

## Implementation Notes

### Key Constants

From `MainActivity.java:105`:
- `BASE_SEQ_STEP = 128` (not directly used in encoding)

From `BiorhythmFragment.java:53`:
- `MAX_DURATION_IN_MINUTES = 720` (12 hours max per step)

### Fragment Calculation Details

**Determining which fragment to write:**
```java
int fragmentNum = (fragmentID - 7) & 3;  // 0-3
int stepOffset = fragmentNum * 8;        // 0, 8, 16, or 24
```

**Determining steps in current fragment:**
```java
int stepsInFragment = Math.min(8, stepCount - stepOffset);
```

**Example:** 20-step sequence, fragment 9 (fragmentNum=2):
- stepOffset = 2 * 8 = 16
- stepsInFragment = min(8, 20 - 16) = 4
- Encode steps 16, 17, 18, 19

### Retry Logic

The app uses retry mechanisms for reliability:
- `requestWithRetry(fragmentID)` - Retries reads with 700ms timeout
- `cancelReadRetry()` - Called when response received
- Tag increments prevent processing duplicate responses

**Code Reference:** `MainActivity.java:138-139`
```java
RETRY_DELAY_SEND = 400ms
RETRY_DELAY_REPLY = 700ms
```

### Error Handling

**Short packet check** (`BiorhythmFragment.java:350-352`):
```java
if (response.length < 3) {
    Timber.e("Incoming biodata packet is too short!");
    return;
}
```

**Tag mismatch check** (`BiorhythmFragment.java:355`):
```java
if (response[0] == lastRequest && response[1] == lastTag) {
    // Process response
}
```

## Security Considerations

### No Encryption
- BLE communication is **not encrypted** at the application layer
- Relies on BLE link-layer security (pairing/bonding)

### No Authentication
- No message authentication codes (MACs)
- Vulnerable to replay attacks if BLE link compromised

### Input Validation
- App validates step ranges (hours, minutes, etc.)
- Device presumably validates received data

## Appendix: File Reference

### Key Files and Line Numbers

**Data Models:**
- `SequenceStep.java` - V3 step structure
- `SequenceStepV2.java` - V2 legacy structure (classic Bluetooth)
- `Constants.java:42-43` - Command constants (64, 65)
- `Constants.java:86-96` - Mode constants

**BLE Protocol:**
- `MainActivity.java:106` - Biodata UUID (`2005`)
- `MainActivity.java:1169-1180` - `requestBioPacket()` - Read command
- `MainActivity.java:1182-1190` - `sendBioCommand()` - Write command
- `MainActivity.java:1192-1239` - `processBioResponse()` - Name parsing

**Biorhythm Fragment Handling:**
- `BiorhythmFragment.java:987-992` - `loadBioSequence()` - Read sequence
- `BiorhythmFragment.java:994-1000` - `saveBioSequence()` - Write sequence
- `BiorhythmFragment.java:1002-1027` - `writeBioFragment()` - Encode and send
- `BiorhythmFragment.java:942-957` - `writeNextBioDataBlock()` - Fragment chaining
- `BiorhythmFragment.java:327-335` - `biodataAvailable()` - Response callback
- `BiorhythmFragment.java:349-421` - `processBiodata()` - Decode responses
- `BiorhythmFragment.java:317-319` - `requestBioNames()` - Name request

### Mode Name Mappings

**Long Names** (`Constants.java:52-58`):
```
STANDBY -> "Standby"
HEAT    -> "Heat"
TURBO   -> "Turbo Heat"
EXTHT   -> "Extnd. Heat"
COOL    -> "Cool"
DRY     -> "Dry"
WAIT    -> "Wait"
```

## Summary

The BedJet V3 Biorhythm protocol is a straightforward binary protocol for storing sleep automation sequences:

- **3 sequences** per device (Bio1, Bio2, Bio3)
- **Up to 32 steps** per sequence
- **5 bytes per step** (mode, fan, temp, hours, minutes)
- **4 fragments per sequence** (8 steps each)
- **41-byte payloads** (1 count byte + 40 bytes for 8 steps)
- **BLE GATT characteristic 2005** for all bio data transfers
- **Simple request/response** protocol with tag-based matching

The protocol prioritizes simplicity over security, with no encryption or authentication beyond BLE pairing. Fragment IDs are deterministic, making it straightforward to implement custom clients.

---

*Documentation reverse-engineered from BedJet Android app v1.0.6*
