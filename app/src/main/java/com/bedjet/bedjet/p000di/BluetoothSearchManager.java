package com.bedjet.bedjet.p000di;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bedjet.bedjet.p000di.BluetoothSearchManager;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.utils.permissions;
import com.google.firebase.FirebaseException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothSearchManager.kt */
@Metadata(m942d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006 "}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "actionDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "getActionDataLiveData", "()Landroidx/lifecycle/MutableLiveData;", "bluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "isScanning", "", "handler", "Landroid/os/Handler;", "scanCallback", "com/bedjet/bedjet/di/BluetoothSearchManager$scanCallback$1", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$scanCallback$1;", "initBluetoothScanner", "", "startScan", "stopScan", "senActionData", "actionData", "Companion", "ActionData", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BluetoothSearchManager {
    private static final long SCAN_PERIOD = 10000;
    private final MutableLiveData<ActionData> actionDataLiveData;
    private final BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private final Context context;
    private final Handler handler;
    private boolean isScanning;
    private final BluetoothSearchManager$scanCallback$1 scanCallback;
    private static String TAG = "BluetoothSearchManager";

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bedjet.bedjet.di.BluetoothSearchManager$scanCallback$1] */
    public BluetoothSearchManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        Intrinsics.checkNotNullExpressionValue(adapter, "getAdapter(...)");
        this.bluetoothAdapter = adapter;
        this.actionDataLiveData = new MutableLiveData<>();
        this.handler = new Handler(Looper.getMainLooper());
        this.scanCallback = new ScanCallback() { // from class: com.bedjet.bedjet.di.BluetoothSearchManager$scanCallback$1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                BluetoothDevice device;
                if (result == null || (device = result.getDevice()) == null) {
                    return;
                }
                BluetoothSearchManager bluetoothSearchManager = BluetoothSearchManager.this;
                if (DeviceType.INSTANCE.isBedJetDevice(device)) {
                    bluetoothSearchManager.senActionData(new BluetoothSearchManager.ActionData.Result(device));
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                String str;
                str = BluetoothSearchManager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".onScanFailed errorCode = [" + errorCode + "]");
            }
        };
    }

    public final BluetoothAdapter getBluetoothAdapter() {
        return this.bluetoothAdapter;
    }

    public final MutableLiveData<ActionData> getActionDataLiveData() {
        return this.actionDataLiveData;
    }

    private final void initBluetoothScanner() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".initBluetoothScanner called");
        BluetoothLeScanner bluetoothLeScanner = this.bluetoothAdapter.getBluetoothLeScanner();
        this.bluetoothLeScanner = bluetoothLeScanner;
        if (bluetoothLeScanner == null) {
            LoggerKt.exception(new FirebaseException("bluetoothLeScanner is null, hasPermissions(context): " + permissions.hasPermissions(this.context) + ", bluetoothAdapter.isEnabled: " + this.bluetoothAdapter.isEnabled()));
        }
    }

    public final void startScan() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Start scan, isScanning = " + this.isScanning);
        if (this.isScanning) {
            return;
        }
        this.isScanning = true;
        if (this.bluetoothLeScanner == null) {
            initBluetoothScanner();
        }
        BluetoothLeScanner bluetoothLeScanner = this.bluetoothLeScanner;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.startScan(this.scanCallback);
        }
        senActionData(ActionData.Start.INSTANCE);
        this.handler.postDelayed(new Runnable() { // from class: com.bedjet.bedjet.di.BluetoothSearchManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothSearchManager.startScan$lambda$0(BluetoothSearchManager.this);
            }
        }, SCAN_PERIOD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$0(BluetoothSearchManager bluetoothSearchManager) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".scanLeDevice, Stops scanning after a pre-defined scan period, isScanning = " + bluetoothSearchManager.isScanning);
        bluetoothSearchManager.stopScan();
        bluetoothSearchManager.senActionData(ActionData.HandlerStop.INSTANCE);
    }

    public final void stopScan() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Stop scan, isScanning = " + this.isScanning);
        if (this.isScanning) {
            this.isScanning = false;
            BluetoothLeScanner bluetoothLeScanner = this.bluetoothLeScanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.scanCallback);
            }
            senActionData(ActionData.Stop.INSTANCE);
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void senActionData(ActionData actionData) {
        ActionData value = this.actionDataLiveData.getValue();
        if (actionData instanceof ActionData.Result) {
            if (Intrinsics.areEqual(value, ActionData.Stop.INSTANCE) || Intrinsics.areEqual(value, ActionData.HandlerStop.INSTANCE)) {
                return;
            }
            if ((value instanceof ActionData.Result) && Intrinsics.areEqual(((ActionData.Result) value).getDevice().getAddress(), ((ActionData.Result) actionData).getDevice().getAddress())) {
                return;
            }
        }
        if (Intrinsics.areEqual(value, actionData)) {
            return;
        }
        this.actionDataLiveData.setValue(actionData);
    }

    /* compiled from: BluetoothSearchManager.kt */
    @Metadata(m942d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "", "<init>", "()V", "Result", "Start", "Stop", "HandlerStop", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$HandlerStop;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Result;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Start;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Stop;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static abstract class ActionData {
        public /* synthetic */ ActionData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: BluetoothSearchManager.kt */
        @Metadata(m942d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Result;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "device", "Landroid/bluetooth/BluetoothDevice;", "<init>", "(Landroid/bluetooth/BluetoothDevice;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final /* data */ class Result extends ActionData {
            private final BluetoothDevice device;

            public static /* synthetic */ Result copy$default(Result result, BluetoothDevice bluetoothDevice, int i, Object obj) {
                if ((i & 1) != 0) {
                    bluetoothDevice = result.device;
                }
                return result.copy(bluetoothDevice);
            }

            /* renamed from: component1, reason: from getter */
            public final BluetoothDevice getDevice() {
                return this.device;
            }

            public final Result copy(BluetoothDevice device) {
                Intrinsics.checkNotNullParameter(device, "device");
                return new Result(device);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Result) && Intrinsics.areEqual(this.device, ((Result) other).device);
            }

            public int hashCode() {
                return this.device.hashCode();
            }

            public String toString() {
                return "Result(device=" + this.device + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Result(BluetoothDevice device) {
                super(null);
                Intrinsics.checkNotNullParameter(device, "device");
                this.device = device;
            }

            public final BluetoothDevice getDevice() {
                return this.device;
            }
        }

        private ActionData() {
        }

        /* compiled from: BluetoothSearchManager.kt */
        @Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Start;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "<init>", "()V", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class Start extends ActionData {
            public static final Start INSTANCE = new Start();

            private Start() {
                super(null);
            }
        }

        /* compiled from: BluetoothSearchManager.kt */
        @Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$Stop;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "<init>", "()V", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class Stop extends ActionData {
            public static final Stop INSTANCE = new Stop();

            private Stop() {
                super(null);
            }
        }

        /* compiled from: BluetoothSearchManager.kt */
        @Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m943d2 = {"Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData$HandlerStop;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "<init>", "()V", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class HandlerStop extends ActionData {
            public static final HandlerStop INSTANCE = new HandlerStop();

            private HandlerStop() {
                super(null);
            }
        }
    }
}
