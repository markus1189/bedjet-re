package com.bedjet.bedjet.p001ui.main;

import android.bluetooth.BluetoothDevice;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceType.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/DeviceType;", "", "deviceType", "", "bluetoothName", "adjustName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getBluetoothName", "getAdjustName", "BEDJET2", "BEDJET3", "BEDFRAME", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeviceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String adjustName;
    private final String bluetoothName;
    private final String deviceType;
    public static final DeviceType BEDJET2 = new DeviceType("BEDJET2", 0, "BEDJET2", "BEDJET", "BedJet V2");
    public static final DeviceType BEDJET3 = new DeviceType("BEDJET3", 1, "BEDJET3", "BEDJET_V3", "BedJet 3");
    public static final DeviceType BEDFRAME = new DeviceType("BEDFRAME", 2, "BEDFRAME", "", "");

    private static final /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{BEDJET2, BEDJET3, BEDFRAME};
    }

    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    private DeviceType(String str, int i, String str2, String str3, String str4) {
        this.deviceType = str2;
        this.bluetoothName = str3;
        this.adjustName = str4;
    }

    public final String getAdjustName() {
        return this.adjustName;
    }

    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    static {
        DeviceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: DeviceType.kt */
    @Metadata(m942d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0010"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/DeviceType$Companion;", "", "<init>", "()V", "toDeviceType", "Lcom/bedjet/bedjet/ui/main/DeviceType;", "deviceType", "", "getAdjustNameByName", "bluetoothName", "getAdjustNameByType", "getDeviceTypeFromName", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "isBedJetDevice", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceType toDeviceType(String deviceType) {
            DeviceType deviceType2;
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            DeviceType[] values = DeviceType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceType2 = null;
                    break;
                }
                deviceType2 = values[i];
                if (Intrinsics.areEqual(deviceType2.getDeviceType(), deviceType)) {
                    break;
                }
                i++;
            }
            return deviceType2 == null ? DeviceType.BEDJET3 : deviceType2;
        }

        public final String getAdjustNameByName(String bluetoothName) {
            DeviceType deviceType;
            Intrinsics.checkNotNullParameter(bluetoothName, "bluetoothName");
            DeviceType[] values = DeviceType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceType = null;
                    break;
                }
                deviceType = values[i];
                if (Intrinsics.areEqual(deviceType.getBluetoothName(), bluetoothName)) {
                    break;
                }
                i++;
            }
            if (deviceType != null) {
                return deviceType.getAdjustName();
            }
            return null;
        }

        public final String getAdjustNameByType(String deviceType) {
            DeviceType deviceType2;
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            DeviceType[] values = DeviceType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceType2 = null;
                    break;
                }
                deviceType2 = values[i];
                if (Intrinsics.areEqual(deviceType2.getDeviceType(), deviceType)) {
                    break;
                }
                i++;
            }
            if (deviceType2 != null) {
                return deviceType2.getAdjustName();
            }
            return null;
        }

        public final DeviceType getDeviceTypeFromName(BluetoothDevice bluetoothDevice) {
            DeviceType deviceType;
            Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
            DeviceType[] values = DeviceType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceType = null;
                    break;
                }
                deviceType = values[i];
                if (Intrinsics.areEqual(deviceType.getBluetoothName(), bluetoothDevice.getName())) {
                    break;
                }
                i++;
            }
            return deviceType == null ? DeviceType.BEDJET3 : deviceType;
        }

        public final boolean isBedJetDevice(BluetoothDevice bluetoothDevice) {
            Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
            String name = bluetoothDevice.getName();
            if (name == null) {
                return false;
            }
            return Intrinsics.areEqual(DeviceType.BEDJET2.getBluetoothName(), name) || Intrinsics.areEqual(DeviceType.BEDJET3.getBluetoothName(), name);
        }
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }
}
