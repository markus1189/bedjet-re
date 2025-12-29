# Task: Reverse Engineer BedJet Biorhythm Protocol

## Context

You're analyzing a decompiled Android app (BedJet v1.0.6) that controls smart bed climate devices via Bluetooth. The app is located in `/tmp/bedjet-source/`.

The app supports two device types:
- **BedJet V2**: Classic Bluetooth (SPP)
- **BedJet V3**: Bluetooth Low Energy (BLE GATT)

## Your Mission

**Focus exclusively on the "Biorhythm" feature** - a sleep schedule system that allows users to program up to 32 automated steps per sequence with 3 sequences stored on the device.

## What to Investigate

### 1. Data Structures
Find and document:
- How biorhythm steps are stored (`SequenceStep` class)
- What fields define a step (mode, temperature, fan, duration, etc.)
- V2 vs V3 differences (`SequenceStepV2` vs `SequenceStep`)

### 2. Transmission Protocol (V3 BLE)
Understand how sequences are transferred:
- Which GATT characteristic is used (likely UUID ending in 2005)
- How data is fragmented (sequences > 8 steps split across packets)
- Packet structure: fragment IDs, payload format, encoding
- Commands: COMMAND_BIOCOMMAND (write) vs COMMAND_BIOREQUEST (read)

### 3. Step Encoding
Document the byte-level format:
- How many bytes per step?
- Field order and data types
- Special encodings (e.g., "clocktime" vs "duration" modes)
- Temperature representation (likely half-degrees Celsius)
- Fan speed encoding (0-19 range mapped to 5-100%)

### 4. Fragment Protocol
Explain the fragmentation system:
- How many fragments per sequence?
- Fragment ID mapping (which IDs = which sequence?)
- How the app chains fragment reads/writes
- Fragment payload structure (step count + step data)

### 5. UI Flow
Trace the user workflow:
- Creating/editing sequences (`BiorhythmFragment`, `BiorhythmAdapter`)
- Saving to device (write flow)
- Loading from device (read flow)
- Running/deleting sequences (button commands)

## Key Files to Examine

```
/tmp/bedjet-source/app/src/main/java/com/bedjet/bedjet/
├── p001ui/biorhythm/
│   ├── BiorhythmFragment.java     # Main logic
│   └── BiorhythmAdapter.java      # Step list management
├── p001ui/main/
│   └── MainActivity.java          # BLE commands (sendBioCommand, requestBioPacket)
├── data/local/model/
│   ├── SequenceStep.java          # V3 step structure
│   └── legacy/
│       └── SequenceStepV2.java    # V2 step structure
└── Constants.java                 # Command constants (COMMAND_BIOCOMMAND, etc.)
```

## Deliverables

Create a markdown document with:

1. **Data Model** - Complete SequenceStep class breakdown
2. **Packet Format** - Byte-by-byte structure with examples
3. **Fragment Protocol** - How 32 steps are split into transmissions
4. **Encoding Details** - Clocktime flag, temperature units, mode values
5. **Command Flow** - Read/write sequences with code snippets
6. **Complete Example** - Real packet hex dump with decoding

## Important Details to Find

- Maximum steps per sequence (hint: likely 32)
- Maximum sequences per device (hint: likely 3)
- Fragment size (hint: 8 steps per fragment = 4 fragments max)
- Step size in bytes (hint: 5 bytes)
- Fragment payload size (hint: 41 bytes total)
- Clocktime encoding (hint: bit 7 of hours byte)
- Fragment ID range (hint: 7-19 for read/write operations)

## Approach

1. Start with `BiorhythmFragment.java` to understand the UI flow
2. Find `sendBioCommand()` and `requestBioPacket()` methods in MainActivity
3. Examine `writeBioFragment()` to see how packets are constructed
4. Look at `biodataAvailable()` to see how responses are parsed
5. Map out the complete read/write cycle
6. Document with real code examples and hex dumps

## Success Criteria

Your documentation should enable someone to:
- Build a custom biorhythm client from scratch
- Decode captured BLE packets
- Understand the complete data flow from UI → BLE → device
- Create/modify biorhythm sequences programmatically

Be meticulous. Include line numbers, byte offsets, and working code examples.
