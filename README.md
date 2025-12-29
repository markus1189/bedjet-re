# BedJet Reverse Engineering

Reverse-engineered protocol documentation and decompiled source code for the BedJet Android application (v1.0.6).

## Overview

BedJet is a climate control system for beds that uses Bluetooth (Classic and BLE) to communicate with mobile devices. This repository contains:

- **Complete protocol documentation** for the Biorhythm feature (automated sleep schedules)
- **Decompiled Android application source code** for analysis

**All reverse engineering, documentation, and analysis performed by [Claude Code](https://github.com/anthropics/claude-code).**

## Repository Structure

```
bedjet-re/
├── docs/                          # Documentation and analysis
│   ├── BIORHYTHM_PROTOCOL.md     # Complete BLE protocol specification
│   ├── BIORHYTHM_REVERSE_ENGINEERING_PROMPT.md
│   └── BEDJET.md                  # General BedJet information
│
└── decompiled/                    # Decompiled Android app (v1.0.6)
    ├── app/                       # Application source
    ├── build.gradle
    └── settings.gradle
```

## Key Documentation

### [Biorhythm Protocol Specification](docs/BIORHYTHM_PROTOCOL.md)

Comprehensive reverse-engineered documentation of the BedJet V3 Biorhythm BLE protocol, including:

- **Data structures** - SequenceStep format (V2 and V3)
- **BLE protocol** - GATT characteristics and command structure
- **Fragment protocol** - How 32-step sequences are split across BLE packets
- **Byte-level encoding** - Complete packet format with examples
- **Working examples** - Three complete sequences with hex dumps

**Protocol Highlights:**
- 3 sequences per device (Bio1, Bio2, Bio3)
- Up to 32 steps per sequence
- 5 bytes per step: mode, fan, temp, hours, minutes
- Fragment-based transfer via BLE GATT characteristic `2005`
- Clocktime bit encoding in hour byte for duration vs wall-clock modes

### Verified Accuracy

All protocol claims have been independently verified against the decompiled source code with 100% accuracy.

## Device Support

- **BedJet V2** - Classic Bluetooth (Serial Port Profile)
- **BedJet V3** - Bluetooth Low Energy (BLE GATT)

This documentation focuses on **BedJet V3** and its BLE implementation.

## Use Cases

This documentation enables:

- Building custom BedJet clients and integrations
- Decoding BLE packet captures
- Understanding the complete data flow from UI to device
- Creating/modifying biorhythm sequences programmatically
- Home automation integration (Home Assistant, etc.)

## Decompiled Source

The `decompiled/` directory contains the full decompiled Android application. Key files:

- `app/src/main/java/com/bedjet/bedjet/p001ui/biorhythm/BiorhythmFragment.java` - Main biorhythm logic
- `app/src/main/java/com/bedjet/bedjet/p001ui/main/MainActivity.java` - BLE command handling
- `app/src/main/java/com/bedjet/bedjet/data/local/model/SequenceStep.java` - V3 data model
- `app/src/main/java/com/bedjet/bedjet/Constants.java` - Protocol constants

## Security Notes

⚠️ **No Encryption:** The BLE protocol uses no application-layer encryption or authentication beyond standard BLE pairing.

## Legal

This repository is for **educational and research purposes only**. The decompiled code is analyzed to understand the BLE protocol for interoperability purposes.

## Contributing

Found an error in the protocol documentation? Have additional insights? Pull requests welcome.

## License

Documentation: CC0 1.0 Universal (Public Domain)

Decompiled code: Original copyright belongs to BedJet (analysis for interoperability research)

---

*"Because sometimes you need to reverse engineer your bed."*
