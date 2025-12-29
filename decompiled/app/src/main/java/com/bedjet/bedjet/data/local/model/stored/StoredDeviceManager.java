package com.bedjet.bedjet.data.local.model.stored;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.utils.PreferenceStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* compiled from: StoredDeviceManager.kt */
@Metadata(m942d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006$"}, m943d2 = {"Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "", "preferenceStorage", "Lcom/bedjet/bedjet/utils/PreferenceStorage;", "<init>", "(Lcom/bedjet/bedjet/utils/PreferenceStorage;)V", "storedDevices", "", "Lcom/bedjet/bedjet/data/local/model/stored/DeviceRecord;", "getStoredDevices", "()Ljava/util/List;", "loadDevices", "", "saveDevices", "dumpDevices", "functionName", "", "updateDeviceName", "newName", "setCurrentDevice", "deviceAddress", "newDevice", "Lcom/bedjet/bedjet/ui/main/DeviceType;", "getDeviceRecord", "which", "", "getCurrentDeviceType", "getCurrentDevice", "getDeviceAddress", "getStoredDeviceName", "getBondedFlag", "", "setBondedFlag", "delete", "item", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StoredDeviceManager {
    private static final int MAX_STORED_DEVICES = 4;
    private static final String PREFS_ADDRESS = "address";
    private static final String PREFS_BONDED = "bonded";
    private static final String PREFS_DEVICE = "device";
    private static final String PREFS_NAME = "named";
    private final PreferenceStorage preferenceStorage;
    private final List<DeviceRecord> storedDevices;
    private static String TAG = "StoredDeviceManager";

    private final void dumpDevices(String functionName) {
    }

    public StoredDeviceManager(PreferenceStorage preferenceStorage) {
        Intrinsics.checkNotNullParameter(preferenceStorage, "preferenceStorage");
        this.preferenceStorage = preferenceStorage;
        this.storedDevices = new ArrayList();
    }

    public final List<DeviceRecord> getStoredDevices() {
        return this.storedDevices;
    }

    public final void loadDevices() {
        DeviceRecord deviceRecord;
        Object obj;
        this.storedDevices.clear();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".loadDevices preferenceStorage.getAll(): " + this.preferenceStorage.getAll());
        for (int i = 0; i < 4; i++) {
            String string = this.preferenceStorage.getString(PREFS_ADDRESS + i, "");
            String string2 = this.preferenceStorage.getString(PREFS_DEVICE + i, DeviceType.BEDJET3.toString());
            String string3 = this.preferenceStorage.getString(PREFS_NAME + i, "");
            boolean z = this.preferenceStorage.getBoolean(PREFS_BONDED + i, true);
            if (string.length() > 0) {
                Iterator<T> it = this.storedDevices.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((DeviceRecord) obj).getDeviceAddress(), string)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    deviceRecord = new DeviceRecord("", DeviceType.BEDJET3.toString(), "", true);
                    this.storedDevices.add(deviceRecord);
                }
            }
            deviceRecord = new DeviceRecord(string, string2, string3, z);
            this.storedDevices.add(deviceRecord);
        }
        dumpDevices("loadDevices");
    }

    private final void saveDevices() {
        for (int i = 0; i < 4; i++) {
            DeviceRecord deviceRecord = (DeviceRecord) CollectionsKt.getOrNull(this.storedDevices, i);
            Boolean bool = null;
            this.preferenceStorage.saveString(PREFS_ADDRESS + i, deviceRecord != null ? deviceRecord.getDeviceAddress() : null);
            this.preferenceStorage.saveString(PREFS_DEVICE + i, deviceRecord != null ? deviceRecord.getDeviceType() : null);
            this.preferenceStorage.saveString(PREFS_NAME + i, deviceRecord != null ? deviceRecord.getDeviceName() : null);
            PreferenceStorage preferenceStorage = this.preferenceStorage;
            String str = PREFS_BONDED + i;
            if (deviceRecord != null) {
                bool = Boolean.valueOf(deviceRecord.getBondedFlag());
            }
            preferenceStorage.saveBoolean(str, bool);
        }
        dumpDevices("saveDevices");
    }

    public final void updateDeviceName(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        DeviceRecord deviceRecord = (DeviceRecord) CollectionsKt.firstOrNull((List) this.storedDevices);
        if (StringsKt.equals$default(deviceRecord != null ? deviceRecord.getDeviceType() : null, newName, false, 2, null)) {
            return;
        }
        DeviceRecord deviceRecord2 = (DeviceRecord) CollectionsKt.firstOrNull((List) this.storedDevices);
        if (deviceRecord2 != null) {
            deviceRecord2.setDeviceName(newName);
        }
        saveDevices();
    }

    public final void setCurrentDevice(String deviceAddress, DeviceType newDevice) {
        Object obj;
        DeviceRecord deviceRecord;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(newDevice, "newDevice");
        Iterator<T> it = this.storedDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((DeviceRecord) obj).getDeviceAddress(), deviceAddress)) {
                    break;
                }
            }
        }
        DeviceRecord deviceRecord2 = (DeviceRecord) obj;
        if (deviceRecord2 == null) {
            deviceRecord = new DeviceRecord(deviceAddress, newDevice.toString(), "", false);
        } else {
            deviceRecord = new DeviceRecord(deviceAddress, newDevice.toString(), deviceRecord2.getDeviceName(), deviceRecord2.getBondedFlag());
        }
        TypeIntrinsics.asMutableCollection(this.storedDevices).remove(deviceRecord2);
        this.storedDevices.add(0, deviceRecord);
        saveDevices();
    }

    public final DeviceRecord getDeviceRecord(int which) {
        return this.storedDevices.get(which);
    }

    public final DeviceType getCurrentDeviceType() {
        return DeviceType.INSTANCE.toDeviceType(this.storedDevices.get(0).getDeviceType());
    }

    public final DeviceRecord getCurrentDevice() {
        return (DeviceRecord) CollectionsKt.getOrNull(this.storedDevices, 0);
    }

    public final String getDeviceAddress(int which) {
        return this.storedDevices.get(which).getDeviceAddress();
    }

    public final String getStoredDeviceName(int which) {
        return this.storedDevices.get(which).getDeviceName();
    }

    public final boolean getBondedFlag(int which) {
        boolean bondedFlag = this.storedDevices.get(which).getBondedFlag();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".getBondedFlag bondedFlag: " + bondedFlag);
        return bondedFlag;
    }

    public final void setBondedFlag(int which) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".setBondedFlag");
        this.storedDevices.get(which).setBondedFlag(true);
        saveDevices();
    }

    public final void delete(DeviceRecord item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.storedDevices.remove(item);
        saveDevices();
    }
}
