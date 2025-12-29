package com.bedjet.bedjet.p001ui.main.p002v2;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BondBroadcastReceiver.kt */
@Metadata(m942d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/BondBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "bedjet2Device", "Landroid/bluetooth/BluetoothDevice;", "linkDetectedHandler", "Landroid/os/Handler;", "bondBroadcastReceiverListener", "Lcom/bedjet/bedjet/ui/main/v2/BondBroadcastReceiver$BondBroadcastReceiverListener;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Landroid/os/Handler;Lcom/bedjet/bedjet/ui/main/v2/BondBroadcastReceiver$BondBroadcastReceiverListener;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "BondBroadcastReceiverListener", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BondBroadcastReceiver extends BroadcastReceiver {
    private static String TAG = "BondBroadcastReceiver";
    private final BluetoothDevice bedjet2Device;
    private final BondBroadcastReceiverListener bondBroadcastReceiverListener;
    private final Handler linkDetectedHandler;

    /* compiled from: BondBroadcastReceiver.kt */
    @Metadata(m942d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/BondBroadcastReceiver$BondBroadcastReceiverListener;", "", "unregisterReceiver", "", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface BondBroadcastReceiverListener {
        void unregisterReceiver(BroadcastReceiver broadcastReceiver);
    }

    public BondBroadcastReceiver(BluetoothDevice bedjet2Device, Handler linkDetectedHandler, BondBroadcastReceiverListener bondBroadcastReceiverListener) {
        Intrinsics.checkNotNullParameter(bedjet2Device, "bedjet2Device");
        Intrinsics.checkNotNullParameter(linkDetectedHandler, "linkDetectedHandler");
        Intrinsics.checkNotNullParameter(bondBroadcastReceiverListener, "bondBroadcastReceiverListener");
        this.bedjet2Device = bedjet2Device;
        this.linkDetectedHandler = linkDetectedHandler;
        this.bondBroadcastReceiverListener = bondBroadcastReceiverListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".onReceive context = " + context + ", intent = " + intent);
        if (Intrinsics.areEqual("android.bluetooth.device.action.BOND_STATE_CHANGED", intent.getAction())) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LoggerKt.logTag(TAG3, "BluetoothDevice target = " + bluetoothDevice);
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            LoggerKt.logTag(TAG4, "BluetoothDevice bedjet2Device = " + this.bedjet2Device);
            if (Intrinsics.areEqual(bluetoothDevice, this.bedjet2Device)) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                LoggerKt.logTag(TAG5, "state = " + intExtra + ", prevState = " + intExtra2);
                if (intExtra == 12 && intExtra2 == 11) {
                    String TAG6 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    LoggerKt.logTag(TAG6, this.bedjet2Device.getAddress() + " bonded");
                    Message obtain = Message.obtain();
                    obtain.what = MessageType.MSG_BOND_OK.getId();
                    this.linkDetectedHandler.sendMessage(obtain);
                    this.bondBroadcastReceiverListener.unregisterReceiver(this);
                    return;
                }
                if (intExtra == 10 && intExtra2 == 11) {
                    String TAG7 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                    LoggerKt.logTag(TAG7, this.bedjet2Device.getAddress() + " bond fail");
                    Message obtain2 = Message.obtain();
                    obtain2.what = MessageType.MSG_BOND_FAIL.getId();
                    this.linkDetectedHandler.sendMessage(obtain2);
                    this.bondBroadcastReceiverListener.unregisterReceiver(this);
                }
            }
        }
    }
}
