# Biorhythm Step Display Logic

**Analysis Date:** 2025-12-30
**App Version:** 1.0.6 (build 18)
**Purpose:** Document how the Android app determines when to show "Biorhythm Step X" in the UI

---

## Overview

The BedJet Android app displays "Biorhythm Step X" in the main screen button when a biorhythm sequence is actively running. This document explains the complete data flow from device communication to UI display.

---

## Data Flow

```
┌──────────────────────────────────────────────────────┐
│ BedJet Device Firmware                               │
│   - Running biorhythm sequence                       │
│   - Byte 27 of status packet = current step (0-32)   │
└────────────────────┬─────────────────────────────────┘
                     │ BLE Status Notification
                     ▼
┌──────────────────────────────────────────────────────┐
│ MainActivity.java:1318-1320                          │
│   - Decode status packet                             │
│   - Extract sequenceStep from byte 27                │
│   - Store in CurrentStatus object                    │
└────────────────────┬─────────────────────────────────┘
                     │ Status update
                     ▼
┌──────────────────────────────────────────────────────┐
│ MainFragment.java:123-134 (V3)                       │
│ MainFragmentV2.java:119-123 (V2)                     │
│   - Compare sequenceStep to previous value           │
│   - Update button text based on step value           │
│   - 0 = "Biorhythm Settings"                         │
│   - 1-32 = "Biorhythm On\nStep X"                   │
└──────────────────────────────────────────────────────┘
```

---

## Device Communication

### Status Packet - Byte 27 (sequenceStep)

**Location in packet:** Byte 27 (0-indexed byte 27)
**Data type:** uint8
**Range:** 0-32

**Values:**
- `0` = No biorhythm sequence running (or inactive)
- `1-32` = Currently executing step number

### Extraction Code

**File:** `MainActivity.java:1318-1320`

```java
if (bArr.length > 28) {
    this.currentStatus.setSequenceStep(bArr[27]);
} else {
    this.currentStatus.setSequenceStep(0);  // Default if packet too short
}
```

**Storage:** `CurrentStatus.java`
```java
private int sequenceStep;  // Field storing current step

public int getSequenceStep() {
    return this.sequenceStep;
}

public void setSequenceStep(int sequenceStep) {
    this.sequenceStep = sequenceStep;
}
```

---

## UI Display Logic

### String Resources

**File:** `decompiled/app/src/main/res/values/strings.xml`

```xml
<string name="bio_button_norm">Biorhythm Settings</string>
<string name="bio_button_run">Biorhythm On\nStep %d</string>
```

**Format specifier:** `%d` - decimal integer (the step number)

### MainFragment (V3 Devices)

**File:** `MainFragment.java:123-134`

```java
if (z || this.mCurrentStatus.getSequenceStep() != this.mPreviousStatus.getSequenceStep()) {
    int sequenceStep = this.mCurrentStatus.getSequenceStep();
    Context context = getBinding().getRoot().getContext();

    if (context != null) {
        if (sequenceStep == 0) {
            // No sequence running - show "Biorhythm Settings"
            getBinding().settingsBiorhythm.setText(
                context.getString(C0624R.string.bio_button_norm)
            );
        } else {
            // Sequence running - show "Biorhythm On\nStep X"
            getBinding().settingsBiorhythm.setText(
                context.getString(C0624R.string.bio_button_run,
                                 Integer.valueOf(sequenceStep))
            );
        }
    }

    // Update previous status to detect future changes
    this.mPreviousStatus.setSequenceStep(this.mCurrentStatus.getSequenceStep());
}
```

### MainFragmentV2 (V2 Devices)

**File:** `MainFragmentV2.java:119-123`

```java
if (this.mCurrentStatus.getSequenceStep() != this.mPreviousStatus.getSequenceStep()) {
    Context context2 = getBinding().getRoot().getContext();
    if (context2 != null) {
        // Identical logic to V3
        getBinding().settingsBiorhythm.setText(
            this.mCurrentStatus.getSequenceStep() == 0
                ? context2.getString(C0624R.string.bio_button_norm)
                : context2.getString(C0624R.string.bio_button_run,
                                    Integer.valueOf(this.mCurrentStatus.getSequenceStep()))
        );
    }
    this.mPreviousStatus.setSequenceStep(this.mCurrentStatus.getSequenceStep());
}
```

---

## Update Trigger Conditions

The UI text updates when **either** condition is met:

1. **Status changed:** `mCurrentStatus.getSequenceStep() != mPreviousStatus.getSequenceStep()`
   - Step number changed (e.g., 1 → 2, or 0 → 1)
   - Sequence started (0 → N)
   - Sequence stopped (N → 0)

2. **Force update flag:** `z` (in MainFragment only)
   - Set during initial UI setup
   - Forces refresh even if value unchanged

**Why track previous value?**
- Prevents unnecessary UI updates on every status packet
- Status packets arrive frequently (notifications)
- Only update when step actually changes
- Reduces UI flicker and improves performance

---

## Biorhythm Editor Display

In the biorhythm sequence editor, step numbers are displayed differently.

### Layout

**File:** `layout_item_biorhythm.xml`

```xml
<AppCompatTextView
    android:layout_weight="30"
    android:textSize="22sp"
    android:textStyle="bold"
    android:textColor="#FFFFFF"
    ... />
```

**Purpose:** First column showing step number in editor

### Data Binding

**File:** `LayoutItemBiorhythmBindingImpl.java:173-184`

```java
int position = ViewDataBinding.safeUnbox(num);
String valueOf = j2 != 0 ? String.valueOf(position + 1) : null;
```

**Calculation:** `stepNumber = adapterPosition + 1`

**Examples:**
- Position 0 → Display "1"
- Position 1 → Display "2"
- Position 31 → Display "32"

### View Holder

**File:** `BiorhythmViewHolder.java:41`

```java
layoutItemBiorhythmBinding.setPosition(Integer.valueOf(getAdapterPosition()));
```

**Note:** The editor displays step numbers starting from 1 (user-friendly), while internal arrays are 0-indexed (code convention).

---

## Display Examples

### Scenario 1: No Biorhythm Running

**Device state:**
- No biorhythm sequence active
- Status packet byte 27 = `0x00`

**UI Display:**
```
┌─────────────────────────┐
│  Biorhythm Settings     │
└─────────────────────────┘
```

**Button behavior:** Tapping opens biorhythm sequence selection

---

### Scenario 2: Running Step 1

**Device state:**
- Biorhythm sequence 1 running
- Currently on step 1
- Status packet byte 27 = `0x01`

**UI Display:**
```
┌─────────────────────────┐
│  Biorhythm On           │
│  Step 1                 │
└─────────────────────────┘
```

**Note:** Newline character (`\n`) in string causes two-line display

---

### Scenario 3: Running Step 15

**Device state:**
- Biorhythm sequence 2 running
- Currently on step 15
- Status packet byte 27 = `0x0F`

**UI Display:**
```
┌─────────────────────────┐
│  Biorhythm On           │
│  Step 15                │
└─────────────────────────┘
```

---

### Scenario 4: Editor View

**Context:** User editing a 5-step sequence

**UI Display:**
```
Step | Mode      | Temp  | Fan  | Duration
-----|-----------|-------|------|----------
1    | Heat      | 72°F  | 100% | 0h 15m
2    | Cool      | 66°F  | 50%  | 7h 0m
3    | Extended  | 68°F  | 30%  | Until 6:30 AM
4    | Wait      | --    | --   | 0h 30m
5    | Cool      | 64°F  | 20%  | 2h 0m
```

**Step numbers:** Displayed in first column, calculated as `position + 1`

---

## Edge Cases

### Case 1: Packet Too Short

**Condition:** Status packet length ≤ 28 bytes

**Behavior:**
```java
if (bArr.length > 28) {
    this.currentStatus.setSequenceStep(bArr[27]);
} else {
    this.currentStatus.setSequenceStep(0);  // Default to "not running"
}
```

**Result:** UI shows "Biorhythm Settings" (safe fallback)

---

### Case 2: Invalid Step Number

**Condition:** Byte 27 contains value > 32

**Current behavior:** No validation in app code
- Device firmware presumably prevents this
- App would display "Biorhythm On\nStep 255" if device sent 0xFF
- No upper bound checking in UI code

**Risk:** Low (trust device firmware)

---

### Case 3: Mid-Sequence Status Change

**Scenario:** Device switches from step 5 to step 6

**Packet sequence:**
1. Notification arrives with byte 27 = `0x06`
2. `MainActivity.decodeHome()` calls `setSequenceStep(6)`
3. `MainFragment.updateDisplay()` detects change (5 → 6)
4. Button text updates to "Biorhythm On\nStep 6"
5. `mPreviousStatus.setSequenceStep(6)` prevents re-update

**Latency:** Near-instant (BLE notification → UI update < 100ms typically)

---

### Case 4: Sequence Completion

**Scenario:** Last step finishes

**Expected behavior:**
1. Step 32 completes
2. Device sends status with byte 27 = `0x00`
3. UI reverts to "Biorhythm Settings"

**Implementation note:** App relies on device to set byte 27 to 0 when sequence finishes

---

## Button UI Element Details

### View Binding

**Field:** `settingsBiorhythm` (TextView)

**Location:** Accessed via data binding
```java
getBinding().settingsBiorhythm.setText(...)
```

**Properties:**
- Multi-line capable (handles `\n` in string)
- Dynamic text content
- Clickable (opens biorhythm interface)

### Click Behavior

**When showing "Biorhythm Settings":**
- Opens biorhythm sequence selection screen
- User can choose Bio1, Bio2, or Bio3
- Can create new sequences or edit existing

**When showing "Biorhythm On\nStep X":**
- Shows currently running sequence details
- Allows stopping the sequence
- Displays progress through steps

---

## Performance Considerations

### Update Frequency Optimization

**Problem:** BLE status notifications arrive frequently (often 1-2 Hz)

**Solution:** Change detection via `mPreviousStatus`
```java
if (this.mCurrentStatus.getSequenceStep() != this.mPreviousStatus.getSequenceStep()) {
    // Only update UI when value actually changes
}
```

**Benefit:**
- Prevents unnecessary string formatting
- Reduces UI redraws
- Improves battery life
- Eliminates text flickering

### String Resource Caching

**Implementation:** Android automatically caches string resources
```java
context.getString(C0624R.string.bio_button_run, Integer.valueOf(sequenceStep))
```

**Efficiency:**
- Resource lookup cached by system
- String formatting only when value changes
- No memory allocation when displaying same step repeatedly

---

## Testing Observations

### Test Case: Step Progression

**Setup:** Create 3-step sequence and run

**Expected observations:**
1. Before start: "Biorhythm Settings"
2. After start: "Biorhythm On\nStep 1"
3. After step 1 duration: "Biorhythm On\nStep 2"
4. After step 2 duration: "Biorhythm On\nStep 3"
5. After step 3 finishes: "Biorhythm Settings"

**Verification:** Monitor byte 27 in status packets and UI updates

---

## Related Code Locations

### Key Files

| File | Lines | Purpose |
|------|-------|---------|
| `MainActivity.java` | 1318-1320 | Extract sequenceStep from packet |
| `MainFragment.java` | 123-134 | V3 UI update logic |
| `MainFragmentV2.java` | 119-123 | V2 UI update logic |
| `CurrentStatus.java` | 31, 97 | sequenceStep field storage |
| `strings.xml` | - | String resources |
| `LayoutItemBiorhythmBindingImpl.java` | 173-184 | Editor step number binding |
| `BiorhythmViewHolder.java` | 41 | Editor position setting |

### String Resource IDs

| Resource | ID | Value |
|----------|----|----|
| `bio_button_norm` | `C0624R.string.bio_button_norm` | "Biorhythm Settings" |
| `bio_button_run` | `C0624R.string.bio_button_run` | "Biorhythm On\nStep %d" |

---

## Protocol Reference

For details on:
- **Biorhythm sequence storage:** See `BIORHYTHM_PROTOCOL.md`
- **Status packet format:** See `BEDJET.md` section "Status Packet Format"
- **Device communication:** See `BEDJET.md` section "BLE Protocol"

---

## Summary

The "Biorhythm Step X" display is determined by:

1. **Source:** Device firmware sets byte 27 in status packets (0-32)
2. **Transport:** BLE status notifications deliver value to app
3. **Storage:** `CurrentStatus.sequenceStep` field (via setter)
4. **Logic:** `if (sequenceStep == 0)` determines which string to show
5. **Display:** TextView updated via data binding
6. **Optimization:** Change detection prevents unnecessary updates

**Key insight:** The step number comes directly from device firmware's current execution state, not from app-side tracking. The app is purely displaying what the device reports.

---

**END OF DOCUMENTATION**
