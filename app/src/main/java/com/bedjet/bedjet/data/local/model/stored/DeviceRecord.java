package com.bedjet.bedjet.data.local.model.stored;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.data.local.model.CurrentStatus$$ExternalSyntheticBackport0;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceRecord.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, m943d2 = {"Lcom/bedjet/bedjet/data/local/model/stored/DeviceRecord;", "", "deviceAddress", "", "deviceType", "deviceName", "bondedFlag", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDeviceAddress", "()Ljava/lang/String;", "getDeviceType", "getDeviceName", "setDeviceName", "(Ljava/lang/String;)V", "getBondedFlag", "()Z", "setBondedFlag", "(Z)V", "getStoredListTitle", "getStoredListDescription", "isV2device", "isRealDevice", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class DeviceRecord {
    private boolean bondedFlag;
    private final String deviceAddress;
    private String deviceName;
    private final String deviceType;

    public static /* synthetic */ DeviceRecord copy$default(DeviceRecord deviceRecord, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceRecord.deviceAddress;
        }
        if ((i & 2) != 0) {
            str2 = deviceRecord.deviceType;
        }
        if ((i & 4) != 0) {
            str3 = deviceRecord.deviceName;
        }
        if ((i & 8) != 0) {
            z = deviceRecord.bondedFlag;
        }
        return deviceRecord.copy(str, str2, str3, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getBondedFlag() {
        return this.bondedFlag;
    }

    public final DeviceRecord copy(String deviceAddress, String deviceType, String deviceName, boolean bondedFlag) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        return new DeviceRecord(deviceAddress, deviceType, deviceName, bondedFlag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceRecord)) {
            return false;
        }
        DeviceRecord deviceRecord = (DeviceRecord) other;
        return Intrinsics.areEqual(this.deviceAddress, deviceRecord.deviceAddress) && Intrinsics.areEqual(this.deviceType, deviceRecord.deviceType) && Intrinsics.areEqual(this.deviceName, deviceRecord.deviceName) && this.bondedFlag == deviceRecord.bondedFlag;
    }

    public int hashCode() {
        return (((((this.deviceAddress.hashCode() * 31) + this.deviceType.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.bondedFlag);
    }

    public String toString() {
        return "DeviceRecord(deviceAddress=" + this.deviceAddress + ", deviceType=" + this.deviceType + ", deviceName=" + this.deviceName + ", bondedFlag=" + this.bondedFlag + ")";
    }

    public DeviceRecord(String deviceAddress, String deviceType, String deviceName, boolean z) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.deviceAddress = deviceAddress;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.bondedFlag = z;
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceName = str;
    }

    public final boolean getBondedFlag() {
        return this.bondedFlag;
    }

    public final void setBondedFlag(boolean z) {
        this.bondedFlag = z;
    }

    public final String getStoredListTitle() {
        if (this.deviceName.length() == 0) {
            return "No Name";
        }
        return this.deviceName;
    }

    public final String getStoredListDescription() {
        String adjustNameByType = DeviceType.INSTANCE.getAdjustNameByType(this.deviceType);
        String str = adjustNameByType;
        if (str == null || str.length() == 0) {
            adjustNameByType = this.deviceType;
        }
        return adjustNameByType + " - " + this.deviceAddress;
    }

    public final boolean isV2device() {
        return DeviceType.INSTANCE.toDeviceType(this.deviceType) == DeviceType.BEDJET2;
    }

    public final boolean isRealDevice() {
        return !(this.deviceAddress.length() == 0);
    }
}
