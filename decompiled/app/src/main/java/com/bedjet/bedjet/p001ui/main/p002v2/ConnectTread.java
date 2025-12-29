package com.bedjet.bedjet.p001ui.main.p002v2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.java.KoinJavaComponent;

/* compiled from: ConnectTread.kt */
@Metadata(m942d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/ConnectTread;", "Ljava/lang/Thread;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "linkDetectedHandler", "Landroid/os/Handler;", "connectTreadListener", "Lcom/bedjet/bedjet/ui/main/v2/ConnectTread$ConnectTreadListener;", "<init>", "(Landroid/bluetooth/BluetoothAdapter;Landroid/os/Handler;Lcom/bedjet/bedjet/ui/main/v2/ConnectTread$ConnectTreadListener;)V", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "run", "", "Companion", "ConnectTreadListener", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ConnectTread extends Thread {
    private static String TAG = "ConnectTread";
    private final BluetoothAdapter bluetoothAdapter;
    private final ConnectTreadListener connectTreadListener;
    private final Handler linkDetectedHandler;
    private final StoredDeviceManager storedDeviceManager;

    /* compiled from: ConnectTread.kt */
    @Metadata(m942d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH&¨\u0006\u0012"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/ConnectTread$ConnectTreadListener;", "", "closeSocket", "", "createBluetoothValues", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "bluetoothSocket", "Landroid/bluetooth/BluetoothSocket;", "outputStream", "Ljava/io/OutputStream;", "cancelTimer", "startTimer", "setConnecting", "connecting", "", "setConnected", "connected", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface ConnectTreadListener {
        void cancelTimer();

        void closeSocket();

        void createBluetoothValues(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, OutputStream outputStream);

        void setConnected(boolean connected);

        void setConnecting(boolean connecting);

        void startTimer();
    }

    public ConnectTread(BluetoothAdapter bluetoothAdapter, Handler linkDetectedHandler, ConnectTreadListener connectTreadListener) {
        Intrinsics.checkNotNullParameter(bluetoothAdapter, "bluetoothAdapter");
        Intrinsics.checkNotNullParameter(linkDetectedHandler, "linkDetectedHandler");
        Intrinsics.checkNotNullParameter(connectTreadListener, "connectTreadListener");
        this.bluetoothAdapter = bluetoothAdapter;
        this.linkDetectedHandler = linkDetectedHandler;
        this.connectTreadListener = connectTreadListener;
        this.storedDeviceManager = (StoredDeviceManager) KoinJavaComponent.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), null, null);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "connectThread running");
        try {
            this.connectTreadListener.closeSocket();
            String deviceAddress = this.storedDeviceManager.getDeviceAddress(0);
            BluetoothDevice remoteDevice = this.bluetoothAdapter.getRemoteDevice(deviceAddress);
            BluetoothSocket createInsecureRfcommSocketToServiceRecord = remoteDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            OutputStream outputStream = createInsecureRfcommSocketToServiceRecord.getOutputStream();
            ConnectTreadListener connectTreadListener = this.connectTreadListener;
            Intrinsics.checkNotNull(remoteDevice);
            Intrinsics.checkNotNull(createInsecureRfcommSocketToServiceRecord);
            Intrinsics.checkNotNull(outputStream);
            connectTreadListener.createBluetoothValues(remoteDevice, createInsecureRfcommSocketToServiceRecord, outputStream);
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LoggerKt.logTag(TAG3, "Connected to: " + deviceAddress);
            this.connectTreadListener.startTimer();
            this.connectTreadListener.setConnecting(true);
            createInsecureRfcommSocketToServiceRecord.connect();
            this.connectTreadListener.setConnecting(false);
            z = true;
        } catch (Exception e) {
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            LoggerKt.logTag(TAG4, "IO exception in connect, exception: " + e.getLocalizedMessage());
            LoggerKt.exception(e);
            this.connectTreadListener.setConnecting(false);
            z = false;
        }
        this.connectTreadListener.cancelTimer();
        if (z) {
            this.connectTreadListener.setConnected(true);
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            LoggerKt.logTag(TAG5, "Connect completed OK");
            Message obtain = Message.obtain();
            obtain.what = MessageType.MSG_CONNECT_SUCCESS.getId();
            this.linkDetectedHandler.sendMessage(obtain);
            return;
        }
        this.connectTreadListener.setConnected(false);
        String TAG6 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        LoggerKt.logTag(TAG6, "Connect failed");
        Message obtain2 = Message.obtain();
        obtain2.what = MessageType.MSG_CONNECT_FAIL.getId();
        this.linkDetectedHandler.sendMessage(obtain2);
    }
}
