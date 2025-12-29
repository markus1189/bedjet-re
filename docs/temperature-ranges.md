# BedJet Temperature Ranges by Operating Mode

## Overview

The BedJet V3 implements **mode-specific temperature limits** to ensure safe and appropriate operation across different heating/cooling modes. Each operating mode enforces distinct minimum and maximum temperature values, validated at the UI, application, and protocol levels.

All temperature values in this document follow the BedJet internal storage format: **half-degrees Celsius** (e.g., value `120` = 60°C).

## Operating Modes

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/Constants.java`:86-96

| Mode ID | Constant Name | Mode Description |
|---------|---------------|------------------|
| 0 | MODE_STANDBY | Standby/Off mode |
| 1 | MODE_HEAT | Standard heating mode |
| 2 | MODE_TURBO | Turbo heating (time-limited) |
| 3 | MODE_EXTHT | Extended heating mode |
| 4 | MODE_COOL | Cooling mode |
| 5 | MODE_DRY | Dry mode (moisture removal) |
| 6 | MODE_WAIT | Wait state (transitional) |

## Temperature Ranges by Mode

### Implementation

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/utils/Utils.java`:37-80

The `Utils.getMinMaxTemp(int modeId, boolean isMax)` function returns mode-specific temperature boundaries:

```java
/**
 * Get minimum or maximum temperature for a given mode
 * @param modeId - Operating mode ID (0-6)
 * @param isMax - true for maximum, false for minimum
 * @return Temperature value in half-degrees Celsius
 */
public static int getMinMaxTemp(int modeId, boolean isMax)
```

### Temperature Limits Table

| Mode | Mode ID | Min (raw) | Max (raw) | Min (°C) | Max (°C) | Min (°F) | Max (°F) | Range (°C) |
|------|---------|-----------|-----------|----------|----------|----------|----------|------------|
| **Heat** | 1 | 45 | 80 | 22.5 | 40.0 | 72.5 | 104.0 | 17.5 |
| **Turbo** | 2 | 86 | 86 | 43.0 | 43.0 | 109.4 | 109.4 | 0 (fixed) |
| **Extended Heat** | 3 | 38 | 67 | 19.0 | 33.5 | 66.2 | 92.3 | 14.5 |
| **Cool** | 4 | 38 | 62 | 19.0 | 31.0 | 66.2 | 87.8 | 12.0 |
| **Dry** | 5 | 40 | 80 | 20.0 | 40.0 | 68.0 | 104.0 | 20.0 |
| **Standby/Wait** | 0, 6 | 80 | 80 | 40.0 | 40.0 | 104.0 | 104.0 | 0 (default) |

### Key Observations

1. **Cool mode has the narrowest usable range** (12°C spread) compared to other modes
2. **Cool mode starts lower** (19°C) than Heat mode (22.5°C) but tops out much earlier (31°C vs 40°C)
3. **Turbo mode operates at a fixed temperature** (43°C) with a maximum 10-minute duration limit
4. **Dry mode has the widest range** (20°C spread) from 20-40°C
5. **Extended Heat provides lower temperatures** than standard Heat mode (starts at 19°C vs 22.5°C)

## Temperature Range Enforcement

The BedJet application enforces temperature limits at three distinct layers:

### 1. UI Layer - Temperature Picker

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/p001ui/custom/picker/PickerDialog.java`:246-275

The `initTempPicker()` method constrains the temperature selection dialog:

```java
// Get mode-specific min/max temperatures
int minMaxTemp = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), false);  // Min
int minMaxTemp2 = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), true);  // Max

if (pickerMode.getUseCelsius()) {
    // Generate Celsius temperature list in 1°C increments
    for (int i = minMaxTemp & (-2); i <= minMaxTemp2; i += 2) {
        arrayList.add(Utils.renderTemp(i, true));
    }
} else {
    // Generate Fahrenheit temperature list with distinct values
    int fahrenheit = Utils.toF(minMaxTemp);
    arrayList.add(Utils.renderTemp(minMaxTemp, false));
    while (minMaxTemp < minMaxTemp2) {
        minMaxTemp = Utils.adjustTempF(fahrenheit, false);
        int fahrenheit2 = Utils.toF(minMaxTemp);
        if (fahrenheit2 != fahrenheit) {
            arrayList.add(Utils.renderTemp(minMaxTemp, false));
            fahrenheit = fahrenheit2;
        }
    }
}
```

**Effect**: Users cannot select temperatures outside the valid range for the current mode in the picker UI.

### 2. Application Layer - Biorhythm Validation

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/p001ui/biorhythm/BiorhythmAdapter.java`:297-303

Biorhythm sequences validate temperature values when configuring multi-step programs:

```java
int minMaxTemp = Utils.getMinMaxTemp(sequenceStep.getMode(), false);
int minMaxTemp2 = Utils.getMinMaxTemp(sequenceStep.getMode(), true);
validateTempTime(sequenceStep, minMaxTemp, minMaxTemp2, ...);
```

**Effect**: Biorhythm steps cannot be saved with out-of-range temperatures for their assigned mode.

### 3. Protocol Layer - Device Status

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/data/local/model/CurrentStatus.java`:24-25

The `CurrentStatus` model stores device-reported temperature limits:

```java
private int maximumTemp;  // Maximum allowed temperature from device
private int minimumTemp;  // Minimum allowed temperature from device
```

These values are populated from BLE status packets as documented in `docs/BEDJET.md`:232-236:

| Offset | Length | Field | Description |
|--------|--------|-------|-------------|
| 12 | 1 | Min Temp | Minimum temperature (half-degrees Celsius) |
| 13 | 1 | Max Temp | Maximum temperature (half-degrees Celsius) |

**Effect**: The device itself broadcasts valid temperature range via Bluetooth, providing authoritative limits.

## Temperature Conversion

### Formulas

**Source**: `decompiled/app/src/main/java/com/bedjet/bedjet/utils/Utils.java`:37-80

```java
// Internal format to Fahrenheit
toF(temp) = ((temp * 9) / 10) + 32

// Fahrenheit to internal format
toC(tempF) = ceil(((tempF - 32) * 10) / 9)

// Display rendering (Celsius)
renderTemp(temp, true) = (temp / 2) + " °C"

// Display rendering (Fahrenheit)
renderTemp(temp, false) = toF(temp) + " °F"
```

### Conversion Examples

| Raw Value | Celsius | Fahrenheit |
|-----------|---------|------------|
| 38 | 19°C | 66°F |
| 45 | 22.5°C | 72.5°F |
| 62 | 31°C | 87.8°F |
| 67 | 33.5°C | 92.3°F |
| 80 | 40°C | 104°F |
| 86 | 43°C | 109.4°F |

## Mode-Specific Use Cases

### Heat Mode (MODE_HEAT)
- **Purpose**: General bed warming
- **Range**: 22.5-40°C (72.5-104°F)
- **Use case**: Cold nights, maintaining comfortable sleep temperature
- **Duration**: Unlimited runtime

### Turbo Mode (MODE_TURBO)
- **Purpose**: Rapid bed warming
- **Range**: Fixed 43°C (109.4°F)
- **Use case**: Quickly warming a cold bed before getting in
- **Duration**: Maximum 10 minutes (enforced by device)

### Extended Heat Mode (MODE_EXTHT)
- **Purpose**: Long-duration gentle warming
- **Range**: 19-33.5°C (66.2-92.3°F)
- **Use case**: All-night warming at lower temperatures
- **Duration**: Extended runtime support

### Cool Mode (MODE_COOL)
- **Purpose**: Active bed cooling
- **Range**: 19-31°C (66.2-87.8°F)
- **Use case**: Hot nights, temperature regulation
- **Duration**: Unlimited runtime
- **Note**: Narrowest range to prevent excessive cooling

### Dry Mode (MODE_DRY)
- **Purpose**: Moisture removal from bedding
- **Range**: 20-40°C (68-104°F)
- **Use case**: Drying sheets, removing humidity
- **Duration**: Variable based on moisture levels

## Design Rationale

### Why Different Ranges?

1. **Safety**: Prevents thermal discomfort or burns from excessive heat
2. **Efficiency**: Cooling systems operate less efficiently at extreme temperature differentials
3. **Use Case Optimization**: Each mode targets specific comfort scenarios with appropriate thermal bounds
4. **Hardware Limitations**: Physical device capabilities constrain achievable temperatures per mode
5. **User Experience**: Narrower ranges in cooling modes prevent uncomfortable cold conditions

### Cool Mode Constraints

Cool mode's narrower range (19-31°C) serves several purposes:

- **Prevents overcooling**: Lower limit of 19°C avoids uncomfortably cold conditions
- **Energy efficiency**: Upper limit of 31°C maximizes cooling system effectiveness
- **Condensation prevention**: Limits extreme temperature differentials that could cause moisture issues
- **Comfort optimization**: Most users require cooling within this moderate range

## Related Documentation

- **Temperature Architecture**: See `temperature-handling.md` for internal storage format and conversion utilities
- **Protocol Details**: See `BEDJET.md` for BLE packet structure including temperature fields
- **Biorhythm Programming**: See `BIORHYTHM_PROTOCOL.md` for multi-step temperature sequences

## File References

| File | Lines | Purpose |
|------|-------|---------|
| `Constants.java` | 86-96 | Mode ID definitions |
| `Utils.java` | 37-80 | `getMinMaxTemp()` implementation and conversion functions |
| `CurrentStatus.java` | 24-25 | Temperature limit storage from device |
| `PickerDialog.java` | 246-275 | UI enforcement of temperature ranges |
| `BiorhythmAdapter.java` | 297-303 | Biorhythm sequence validation |
