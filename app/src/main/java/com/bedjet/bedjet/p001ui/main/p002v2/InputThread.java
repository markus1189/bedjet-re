package com.bedjet.bedjet.p001ui.main.p002v2;

import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputThread.kt */
@Metadata(m942d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/InputThread;", "Ljava/lang/Thread;", "bedJet2Socket", "Landroid/bluetooth/BluetoothSocket;", "linkDetectedHandler", "Landroid/os/Handler;", "inputThreadListener", "Lcom/bedjet/bedjet/ui/main/v2/InputThread$InputThreadListener;", "<init>", "(Landroid/bluetooth/BluetoothSocket;Landroid/os/Handler;Lcom/bedjet/bedjet/ui/main/v2/InputThread$InputThreadListener;)V", "run", "", "Companion", "InputThreadListener", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InputThread extends Thread {
    private static String TAG = "InputThread";
    private final BluetoothSocket bedJet2Socket;
    private final InputThreadListener inputThreadListener;
    private final Handler linkDetectedHandler;

    /* compiled from: InputThread.kt */
    @Metadata(m942d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/InputThread$InputThreadListener;", "", "shutdown", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface InputThreadListener {
        void shutdown();
    }

    public InputThread(BluetoothSocket bluetoothSocket, Handler handler, InputThreadListener inputThreadListener) {
        Intrinsics.checkNotNullParameter(inputThreadListener, "inputThreadListener");
        this.bedJet2Socket = bluetoothSocket;
        this.linkDetectedHandler = handler;
        this.inputThreadListener = inputThreadListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        BluetoothSocket bluetoothSocket = this.bedJet2Socket;
        if (bluetoothSocket == null) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LoggerKt.logTag(TAG2, "Socket is null at point read thread starts");
            return;
        }
        try {
            InputStream inputStream = bluetoothSocket.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        byte[] bArr2 = new byte[read];
                        for (int i = 0; i < read; i++) {
                            bArr2[i] = bArr[i];
                        }
                        Message message = new Message();
                        message.obj = bArr2;
                        message.what = MessageType.MSG_READ_DATA.getId();
                        Handler handler = this.linkDetectedHandler;
                        if (handler != null) {
                            handler.sendMessage(message);
                        }
                    }
                } catch (Exception e) {
                    this.inputThreadListener.shutdown();
                    String TAG3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    LoggerKt.logTag(TAG3, "IO exception in read, exception: " + e.getLocalizedMessage());
                    LoggerKt.exception(e);
                    Message obtain = Message.obtain();
                    obtain.what = MessageType.MSG_RESTART_CLIENT.getId();
                    Handler handler2 = this.linkDetectedHandler;
                    if (handler2 != null) {
                        handler2.sendMessage(obtain);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e2) {
            LoggerKt.exception(e2);
        }
    }
}
