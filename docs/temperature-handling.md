# Temperature Handling Architecture

## Overview

The BedJet Android application uses a dual-layer temperature system that separates internal storage (half-degrees Celsius) from user-facing display (Celsius or Fahrenheit based on preference).

## Internal Storage Format

- **Unit**: Half-degrees Celsius
- **Example**: `120` = 60°C
- **Range**: 60-160 (30-80°C or 86-176°F)
- **Rationale**: Device protocol uses half-degree Celsius precision

## Core Components

### 1. Temperature Unit Preference Management

**File**: `decompiled/app/src/main/java/com/bedjet/bedjet/p000di/TempModeManager.java`

The `TempModeManager` class manages user temperature unit preferences:

- **Storage Key**: `"usedegc"` (stored in SharedPreferences via `PreferenceStorage`)
- **Values**:
  - `false` = Fahrenheit (default)
  - `true` = Celsius
- **Methods**:
  - `getUseCelsius()` - Retrieve current preference
  - `setUseCelsius(boolean)` - Update preference and persist to storage
  - `loadUseCelsius()` - Load from persistent storage at app startup

### 2. Temperature Conversion Functions

**File**: `decompiled/app/src/main/java/com/bedjet/bedjet/utils/Utils.java`

#### Core Conversion Functions

```java
// Convert internal storage format to Fahrenheit
public static int toF(int i) {
    return ((i * 9) / 10) + 32;
}

// Convert Fahrenheit to internal storage format (Celsius-based)
public static int toC(int i) {
    return (int) Math.ceil(((i - 32.0d) * 10.0d) / 9.0d);
}

// Render temperature for display
public static String renderTemp(int i, boolean useCelsius) {
    if (useCelsius) {
        return "" + (i / 2) + " °C";  // Internal format: half-degrees Celsius
    }
    return "" + toF(i) + " °F";       // Convert to Fahrenheit
}
```

#### Temperature Adjustment Function

```java
// Find next distinct Fahrenheit value when incrementing/decrementing
public static int adjustTempF(int i, boolean isDecrement) {
    int c = toC(i);
    do {
        i = isDecrement ? i - 1 : i + 1;
    } while (toC(i) == c);
    return i;
}
```

This function ensures that when adjusting temperature in Fahrenheit mode, the internal value increments until the Fahrenheit conversion actually changes (avoiding duplicate values).

### 3. Data Model

**File**: `decompiled/app/src/main/java/com/bedjet/bedjet/models/CurrentStatus.java`

The `CurrentStatus` class stores temperature values as integers:

- `actualTemp` - Current device temperature
- `setPointTemp` - Target temperature
- `minimumTemp` - Minimum allowed temperature
- `maximumTemp` - Maximum allowed temperature

All values stored in half-degrees Celsius format.

## Display vs Storage

| Unit | Storage | Display Conversion |
|------|---------|-------------------|
| **Celsius** | Half-degrees (e.g., 120) | `i / 2` → "60 °C" |
| **Fahrenheit** | Half-degrees Celsius | `toF(i)` → "140 °F" |

## UI Components

### Main Temperature Display

**Files**:
- `MainFragment.java`
- `MainFragmentV2.java`

Display actual and setpoint temperatures using `Utils.renderTemp()`.

Example usage:
```java
String displayTemp = Utils.renderTemp(
    currentStatus.getActualTemp(),
    tempModeManager.getValue().getUseCelsius()
);
```

### Temperature Adjustment

When incrementing/decrementing temperature in UI:

**Celsius mode**:
```java
setPointTemp = (setPointTemp & (-2)) + 2;  // Add 2 (1°C)
```

**Fahrenheit mode**:
```java
int fahrenheit = Utils.toF(setPointTemp);
do {
    setPointTemp++;
} while (Utils.toF(setPointTemp) == fahrenheit);
```

### Temperature Picker Dialog

**File**: `decompiled/app/src/main/java/com/bedjet/bedjet/p001ui/custom/picker/PickerDialog.java` (lines 246-275)

The picker dialog generates temperature ranges based on user preference:

- **Celsius**: Increments by 2 (1°C steps) from min to max
- **Fahrenheit**: Uses `adjustTempF()` to find next distinct Fahrenheit value, removes duplicates

Temperature ranges are mode-dependent (Heat, Cool, Dry, etc.) and enforced using `Utils.getMinMaxTemp()`.

### Temperature Range Constraints

**Function**: `Utils.getMinMaxTemp(int modeId, boolean isMax)`

Different operating modes support different temperature ranges:
- Heat mode: ~38-86°C
- Cool mode: ~26-32°C
- Extended modes: Vary based on operation type

## Biorhythm Sequence Temperatures

**File**: `decompiled/app/src/main/java/com/bedjet/bedjet/models/BiorhythmSequence.java`

Temperature values in biorhythm sequences:
- Use same half-degrees Celsius storage format
- Conversion applied when displaying in UI via `BiorhythmAdapter.java`
- User preference (°C/°F) determines how values are shown and edited

## Data Flow

```
┌─────────────────────────────┐
│ Device Protocol (BLE)       │
└──────────┬──────────────────┘
           │
           ▼
┌─────────────────────────────┐
│ Internal Storage            │
│ Half-degrees Celsius (60-160)│
└──────────┬──────────────────┘
           │
           ▼
┌─────────────────────────────┐
│ TempModeManager             │
│ Check user preference       │
└──────────┬──────────────────┘
           │
      ┌────┴────┐
      ▼         ▼
  Celsius   Fahrenheit
  i / 2     toF(i)
      │         │
      └────┬────┘
           ▼
┌─────────────────────────────┐
│ UI Display                  │
│ Rendered with appropriate   │
│ unit symbol (°C or °F)      │
└──────────┬──────────────────┘
           │
           ▼
┌─────────────────────────────┐
│ User Adjusts Temperature    │
│ Converted back to half-°C   │
│ for device command          │
└─────────────────────────────┘
```

## Key Files Reference

| File | Purpose |
|------|---------|
| `TempModeManager.java` | User preference storage/retrieval |
| `Utils.java` | Conversion utilities (toF, toC, renderTemp, adjustTempF) |
| `CurrentStatus.java` | Data model with temperature fields |
| `MainFragmentV2.java` | Primary UI using temperature functions |
| `PickerDialog.java` | Temperature selection with unit-aware ranges |
| `BiorhythmAdapter.java` | Biorhythm temperature editing |
| `PreferenceStorage.java` | Persistent preference backend |

## Design Benefits

This architecture provides:

1. **Clean separation** between device protocol and UI
2. **Seamless switching** between temperature units without modifying device communication
3. **Consistent precision** - half-degree Celsius granularity maintained throughout
4. **User-friendly display** - Appropriate rounding and unit symbols for each preference
5. **Mode-aware constraints** - Temperature ranges enforced per operating mode
