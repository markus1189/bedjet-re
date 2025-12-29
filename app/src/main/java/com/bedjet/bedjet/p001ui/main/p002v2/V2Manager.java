package com.bedjet.bedjet.p001ui.main.p002v2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.data.local.model.legacy.ButtonDataPacketV2;
import com.bedjet.bedjet.p000di.BluetoothSearchManager;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.p002v2.ConnectTread;
import com.bedjet.bedjet.p001ui.main.p002v2.InputThread;
import com.bedjet.bedjet.p001ui.main.p002v2.V2Manager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.FirebaseException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: V2Manager.kt */
@Metadata(m942d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0002=>B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020*H\u0002J\u000e\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\b\u00102\u001a\u00020*H\u0002J&\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\u0006\u0010.\u001a\u00020/2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u00020*R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006?"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/V2Manager;", "", "bluetoothSearchManager", "Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "<init>", "(Lcom/bedjet/bedjet/di/BluetoothSearchManager;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bedjet/bedjet/ui/main/v2/V2Manager$V2MangerListener;", "getListener", "()Lcom/bedjet/bedjet/ui/main/v2/V2Manager$V2MangerListener;", "setListener", "(Lcom/bedjet/bedjet/ui/main/v2/V2Manager$V2MangerListener;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "nameReceived", "", "getNameReceived", "()Z", "setNameReceived", "(Z)V", "connectTimer", "Ljava/util/Timer;", "reconnectTimer", "value", "isConnected", "isConnecting", "isAutoConnect", "bedjet2Device", "Landroid/bluetooth/BluetoothDevice;", "bedJet2Socket", "Landroid/bluetooth/BluetoothSocket;", "bedJet2InputThread", "Lcom/bedjet/bedjet/ui/main/v2/InputThread;", "bedjet2OutputStream", "Ljava/io/OutputStream;", "bedJet2ConnectThread", "Lcom/bedjet/bedjet/ui/main/v2/ConnectTread;", "linkDetectedHandler", "Landroid/os/Handler;", "getLinkDetectedHandler", "()Landroid/os/Handler;", "startConnectTimer", "", "cancelConnectTimer", "startReconnectTimer", "cancelReconnectTimer", "path", "", "startV2ConnectTread", "shutdownClient", "closeV2Socket", "sendMessageHandle", "data", "", "type", "", "buttonDataPacketV2", "Lcom/bedjet/bedjet/data/local/model/legacy/ButtonDataPacketV2;", "connectClassic", "address", "disconnectDevice", "Companion", "V2MangerListener", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class V2Manager {
    private static final long CONNECT_TIMEOUT = 40000;
    private static final long RECONNECT_TIMEOUT = 5000;
    private ConnectTread bedJet2ConnectThread;
    private InputThread bedJet2InputThread;
    private BluetoothSocket bedJet2Socket;
    private BluetoothDevice bedjet2Device;
    private OutputStream bedjet2OutputStream;
    private final BluetoothAdapter bluetoothAdapter;
    private Timer connectTimer;
    private boolean isAutoConnect;
    private boolean isConnected;
    private boolean isConnecting;
    private final Handler linkDetectedHandler;
    private V2MangerListener listener;
    private boolean nameReceived;
    private Timer reconnectTimer;
    private static String TAG = "V2Manager";

    /* compiled from: V2Manager.kt */
    @Metadata(m942d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0019"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/V2Manager$V2MangerListener;", "", "disableProgress", "", "showDeviceListFragment", "showBluetoothFragment", "registerBondReceiver", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "showToast", "message", "", "setDisconnect", RemoteConfigConstants.ResponseFieldKey.STATE, "", "showIncompatibleDialog", "updateFlash", "readData", "data", "", "connectSuccess", "connectClient", "showAlertDialog", "title", "showProgressDialog", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface V2MangerListener {
        void connectClient();

        void connectSuccess();

        void disableProgress();

        void readData(byte[] data);

        void registerBondReceiver(BluetoothDevice bluetoothDevice);

        void setDisconnect(boolean state);

        void showAlertDialog(String title, String message);

        void showBluetoothFragment();

        void showDeviceListFragment();

        void showIncompatibleDialog();

        void showProgressDialog(String message);

        void showToast(String message);

        void updateFlash();
    }

    public V2Manager(BluetoothSearchManager bluetoothSearchManager) {
        Intrinsics.checkNotNullParameter(bluetoothSearchManager, "bluetoothSearchManager");
        this.bluetoothAdapter = bluetoothSearchManager.getBluetoothAdapter();
        final Looper mainLooper = Looper.getMainLooper();
        this.linkDetectedHandler = new Handler(mainLooper) { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$linkDetectedHandler$1

            /* compiled from: V2Manager.kt */
            @Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MessageType.values().length];
                    try {
                        iArr[MessageType.MSG_CONNECT_SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MessageType.MSG_CONNECT_FAIL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MessageType.MSG_BOND_FAIL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MessageType.MSG_BOND_OK.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[MessageType.MSG_WRITE_EXCEPTION.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[MessageType.MSG_READ_DATA.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[MessageType.MSG_RESTART_CLIENT.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[MessageType.MSG_CONNECT_CLIENT.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[MessageType.MSG_UPDATE_ERR.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[MessageType.MSG_RE_FLASH.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                String str;
                BluetoothSocket bluetoothSocket;
                InputThread inputThread;
                String str2;
                boolean z;
                V2Manager.V2MangerListener listener;
                BluetoothSocket bluetoothSocket2;
                String str3;
                boolean z2;
                V2Manager.V2MangerListener listener2;
                String str4;
                BluetoothAdapter bluetoothAdapter;
                String str5;
                String str6;
                String str7;
                Intrinsics.checkNotNullParameter(msg, "msg");
                LoggerKt.logMessage(msg);
                MessageType fromId = MessageType.INSTANCE.fromId(msg.what);
                switch (fromId == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fromId.ordinal()]) {
                    case 1:
                        str = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str, "Got socket connect message");
                        V2Manager.V2MangerListener listener3 = V2Manager.this.getListener();
                        if (listener3 != null) {
                            listener3.disableProgress();
                        }
                        V2Manager.this.cancelConnectTimer();
                        V2Manager.this.cancelReconnectTimer(2);
                        V2Manager.this.isConnected = true;
                        V2Manager.this.isAutoConnect = false;
                        V2Manager v2Manager = V2Manager.this;
                        bluetoothSocket = V2Manager.this.bedJet2Socket;
                        final V2Manager v2Manager2 = V2Manager.this;
                        v2Manager.bedJet2InputThread = new InputThread(bluetoothSocket, this, new InputThread.InputThreadListener() { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$linkDetectedHandler$1$handleMessage$1
                            @Override // com.bedjet.bedjet.ui.main.v2.InputThread.InputThreadListener
                            public void shutdown() {
                                V2Manager.this.shutdownClient(0);
                            }
                        });
                        inputThread = V2Manager.this.bedJet2InputThread;
                        if (inputThread != null) {
                            inputThread.start();
                        }
                        V2Manager.V2MangerListener listener4 = V2Manager.this.getListener();
                        if (listener4 != null) {
                            listener4.connectSuccess();
                            return;
                        }
                        return;
                    case 2:
                        V2Manager.V2MangerListener listener5 = V2Manager.this.getListener();
                        if (listener5 != null) {
                            listener5.disableProgress();
                        }
                        V2Manager.this.isConnected = false;
                        try {
                            bluetoothSocket2 = V2Manager.this.bedJet2Socket;
                            if (bluetoothSocket2 != null) {
                                bluetoothSocket2.close();
                            }
                        } catch (Exception e) {
                            str2 = V2Manager.TAG;
                            LoggerKt.m516e(new FirebaseException(str2 + ", Error on closing socket, " + e.getLocalizedMessage()));
                        }
                        V2Manager.this.bedJet2Socket = null;
                        V2Manager.this.cancelConnectTimer();
                        V2Manager.this.cancelReconnectTimer(3);
                        z = V2Manager.this.isAutoConnect;
                        if (z || (listener = V2Manager.this.getListener()) == null) {
                            return;
                        }
                        listener.showToast("Connect failed!");
                        return;
                    case 3:
                        str3 = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str3, "Bonding failed");
                        V2Manager.V2MangerListener listener6 = V2Manager.this.getListener();
                        if (listener6 != null) {
                            listener6.disableProgress();
                        }
                        V2Manager.this.isConnected = false;
                        V2Manager.this.cancelConnectTimer();
                        V2Manager.this.cancelReconnectTimer(4);
                        z2 = V2Manager.this.isAutoConnect;
                        if (z2 || (listener2 = V2Manager.this.getListener()) == null) {
                            return;
                        }
                        listener2.showToast("Pairing failed!");
                        return;
                    case 4:
                        str4 = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str4, "Bonding completed");
                        V2Manager.V2MangerListener listener7 = V2Manager.this.getListener();
                        if (listener7 != null) {
                            listener7.disableProgress();
                        }
                        V2Manager.V2MangerListener listener8 = V2Manager.this.getListener();
                        if (listener8 != null) {
                            listener8.showToast("Paired OK");
                        }
                        V2Manager.this.cancelConnectTimer();
                        V2Manager.this.startConnectTimer();
                        V2Manager.V2MangerListener listener9 = V2Manager.this.getListener();
                        if (listener9 != null) {
                            listener9.showProgressDialog("Connecting");
                        }
                        V2Manager.this.startV2ConnectTread();
                        return;
                    case 5:
                        V2Manager.V2MangerListener listener10 = V2Manager.this.getListener();
                        if (listener10 != null) {
                            listener10.disableProgress();
                        }
                        V2Manager.this.isConnected = false;
                        V2Manager.this.cancelConnectTimer();
                        V2Manager.V2MangerListener listener11 = V2Manager.this.getListener();
                        if (listener11 != null) {
                            listener11.showToast("Send Failed！");
                            return;
                        }
                        return;
                    case 6:
                        Object obj = msg.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                        byte[] bArr = (byte[]) obj;
                        V2Manager.V2MangerListener listener12 = V2Manager.this.getListener();
                        if (listener12 != null) {
                            listener12.readData(bArr);
                            return;
                        }
                        return;
                    case 7:
                        bluetoothAdapter = V2Manager.this.bluetoothAdapter;
                        boolean isEnabled = bluetoothAdapter.isEnabled();
                        str5 = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str5, "Bluetooth adapter enabled = " + isEnabled);
                        if (isEnabled) {
                            V2Manager.this.startReconnectTimer();
                            V2Manager.this.isAutoConnect = true;
                            return;
                        } else {
                            V2Manager.V2MangerListener listener13 = V2Manager.this.getListener();
                            if (listener13 != null) {
                                listener13.showBluetoothFragment();
                                return;
                            }
                            return;
                        }
                    case 8:
                        str6 = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str6, "Got connect client MSG");
                        V2Manager.this.setNameReceived(false);
                        V2Manager.this.isConnected = true;
                        V2Manager.V2MangerListener listener14 = V2Manager.this.getListener();
                        if (listener14 != null) {
                            listener14.connectClient();
                        }
                        V2Manager.this.startV2ConnectTread();
                        return;
                    case 9:
                        String str8 = "This app was unable to update the firmware in your BedJet.\nThe exact failure cause returned by the update code was:\n\n" + msg.obj + "\n\nPlease restart both your BedJet and this app and then retry the the firmware update operation.\nIn the event that this failure recurs, please contact BedJet technical support for assistance.";
                        V2Manager.V2MangerListener listener15 = V2Manager.this.getListener();
                        if (listener15 != null) {
                            listener15.showAlertDialog("Firmware update failed", str8);
                            return;
                        }
                        return;
                    case 10:
                        V2Manager.V2MangerListener listener16 = V2Manager.this.getListener();
                        if (listener16 != null) {
                            listener16.updateFlash();
                            return;
                        }
                        return;
                    default:
                        str7 = V2Manager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                        LoggerKt.logTag(str7, "Got unknown message (" + msg.what + ")");
                        return;
                }
            }
        };
    }

    public final V2MangerListener getListener() {
        return this.listener;
    }

    public final void setListener(V2MangerListener v2MangerListener) {
        this.listener = v2MangerListener;
    }

    public final boolean getNameReceived() {
        return this.nameReceived;
    }

    public final void setNameReceived(boolean z) {
        this.nameReceived = z;
    }

    /* renamed from: isConnected, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    public final Handler getLinkDetectedHandler() {
        return this.linkDetectedHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConnectTimer() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Connect timer started");
        cancelConnectTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$startConnectTimer$task$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, "Connect timer expired");
                Message obtain = Message.obtain();
                obtain.what = MessageType.MSG_CONNECT_FAIL.getId();
                V2Manager.this.getLinkDetectedHandler().sendMessage(obtain);
            }
        };
        Timer timer = new Timer();
        this.connectTimer = timer;
        timer.schedule(timerTask, CONNECT_TIMEOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelConnectTimer() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Connect timer cancel, connectTimer is null: " + (this.connectTimer == null));
        Timer timer = this.connectTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.connectTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startReconnectTimer() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Reconnect timer started");
        cancelReconnectTimer(5);
        TimerTask timerTask = new TimerTask() { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$startReconnectTimer$task$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
            
                r0 = r5.this$0.bedJet2Socket;
             */
            @Override // java.util.TimerTask, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    java.lang.String r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$getTAG$cp()
                    java.lang.String r1 = "access$getTAG$cp(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    com.bedjet.bedjet.ui.main.v2.V2Manager r2 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    boolean r2 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$isConnecting$p(r2)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "startReconnectTimer called, isConnecting: "
                    r3.<init>(r4)
                    r3.append(r2)
                    java.lang.String r2 = r3.toString()
                    com.bedjet.bedjet.p001ui.main.LoggerKt.logTag(r0, r2)
                    com.bedjet.bedjet.ui.main.v2.V2Manager r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    boolean r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$isConnecting$p(r0)
                    if (r0 == 0) goto L29
                    return
                L29:
                    com.bedjet.bedjet.ui.main.v2.V2Manager r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    android.bluetooth.BluetoothSocket r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$getBedJet2Socket$p(r0)
                    if (r0 == 0) goto L3f
                    com.bedjet.bedjet.ui.main.v2.V2Manager r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    android.bluetooth.BluetoothSocket r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$getBedJet2Socket$p(r0)
                    if (r0 == 0) goto L56
                    boolean r0 = r0.isConnected()
                    if (r0 != 0) goto L56
                L3f:
                    java.lang.String r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$getTAG$cp()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    java.lang.String r1 = "Restarting connectThread"
                    com.bedjet.bedjet.p001ui.main.LoggerKt.logTag(r0, r1)
                    com.bedjet.bedjet.ui.main.v2.V2Manager r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    r1 = 1
                    r0.shutdownClient(r1)
                    com.bedjet.bedjet.ui.main.v2.V2Manager r0 = com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.this
                    com.bedjet.bedjet.p001ui.main.p002v2.V2Manager.access$startV2ConnectTread(r0)
                L56:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.p001ui.main.p002v2.V2Manager$startReconnectTimer$task$1.run():void");
            }
        };
        Timer timer = new Timer();
        this.reconnectTimer = timer;
        timer.schedule(timerTask, RECONNECT_TIMEOUT);
    }

    public final void cancelReconnectTimer(int path) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Reconnect timer cancel, path: " + path);
        Timer timer = this.reconnectTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.reconnectTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startV2ConnectTread() {
        ConnectTread connectTread = new ConnectTread(this.bluetoothAdapter, this.linkDetectedHandler, new ConnectTread.ConnectTreadListener() { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$startV2ConnectTread$1
            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void closeSocket() {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".closeSocket");
                V2Manager.this.closeV2Socket();
            }

            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void createBluetoothValues(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, OutputStream outputStream) {
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
                Intrinsics.checkNotNullParameter(bluetoothSocket, "bluetoothSocket");
                Intrinsics.checkNotNullParameter(outputStream, "outputStream");
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".createBluetoothValues");
                str2 = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LoggerKt.logTag(str2, "bedJet2Socket: " + bluetoothSocket);
                V2Manager.this.bedjet2Device = bluetoothDevice;
                V2Manager.this.bedJet2Socket = bluetoothSocket;
                V2Manager.this.bedjet2OutputStream = outputStream;
            }

            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void cancelTimer() {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".cancelConnectTimer");
                V2Manager.this.cancelConnectTimer();
            }

            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void startTimer() {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".startConnectTimer");
                V2Manager.this.startConnectTimer();
            }

            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void setConnecting(boolean connecting) {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".setConnecting, connecting = " + connecting);
                V2Manager.this.isConnecting = connecting;
            }

            @Override // com.bedjet.bedjet.ui.main.v2.ConnectTread.ConnectTreadListener
            public void setConnected(boolean connected) {
                String str;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, ".setConnecting, setConnected = " + connected);
                V2Manager.V2MangerListener listener = V2Manager.this.getListener();
                if (listener != null) {
                    listener.setDisconnect(!connected);
                }
                V2Manager.this.isConnected = connected;
            }
        });
        connectTread.start();
        this.bedJet2ConnectThread = connectTread;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.bedjet.bedjet.ui.main.v2.V2Manager$shutdownClient$1] */
    public final void shutdownClient(int path) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".shutdownClient, path: " + path);
        this.isConnecting = true;
        V2MangerListener v2MangerListener = this.listener;
        if (v2MangerListener != null) {
            v2MangerListener.setDisconnect(true);
        }
        cancelConnectTimer();
        new Thread() { // from class: com.bedjet.bedjet.ui.main.v2.V2Manager$shutdownClient$1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                ConnectTread connectTread;
                InputThread inputThread;
                str = V2Manager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LoggerKt.logTag(str, "shutdownClient called");
                connectTread = V2Manager.this.bedJet2ConnectThread;
                if (connectTread != null) {
                    connectTread.interrupt();
                }
                V2Manager.this.bedJet2ConnectThread = null;
                inputThread = V2Manager.this.bedJet2InputThread;
                if (inputThread != null) {
                    inputThread.interrupt();
                }
                V2Manager.this.bedJet2InputThread = null;
                V2Manager.this.closeV2Socket();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeV2Socket() {
        InputStream inputStream;
        OutputStream outputStream;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".closeV2Socket called");
        this.isConnected = false;
        try {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LoggerKt.logTag(TAG3, "bedJet2Socket: " + this.bedJet2Socket);
            BluetoothSocket bluetoothSocket = this.bedJet2Socket;
            if (bluetoothSocket != null && (outputStream = bluetoothSocket.getOutputStream()) != null) {
                outputStream.close();
            }
            BluetoothSocket bluetoothSocket2 = this.bedJet2Socket;
            if (bluetoothSocket2 != null && (inputStream = bluetoothSocket2.getInputStream()) != null) {
                inputStream.close();
            }
            this.bedJet2Socket = null;
        } catch (Exception e) {
            LoggerKt.exception(e);
        }
        String TAG4 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        LoggerKt.logTag(TAG4, ".closeV2Socket finised");
    }

    public final void sendMessageHandle(byte[] data, int path, String type, ButtonDataPacketV2 buttonDataPacketV2) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(buttonDataPacketV2, "buttonDataPacketV2");
        try {
            String arrays = Arrays.toString(data);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            byte b = buttonDataPacketV2.command;
            boolean z = this.bedJet2Socket == null;
            str = "sendMessageHandle data = " + arrays + ", path = " + path + ", type = " + type + ", command value = " + ((int) b) + ", bedJet2Socket == null = " + z + ", isConnected = " + this.isConnected + ", bluetoothAdapter.isEnabled() = " + this.bluetoothAdapter.isEnabled();
        } catch (Exception e) {
            LoggerKt.exception(e);
            str = "";
        }
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, str);
        if (this.bedJet2Socket == null) {
            LoggerKt.m516e(new FirebaseException(TAG + ", " + str));
            V2MangerListener v2MangerListener = this.listener;
            if (v2MangerListener != null) {
                v2MangerListener.showToast("BedJet not connected!");
                return;
            }
            return;
        }
        if (!this.isConnected) {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LoggerKt.logTag(TAG3, "Socket is showing as disconnected");
            return;
        }
        try {
            OutputStream outputStream = this.bedjet2OutputStream;
            if (outputStream != null) {
                outputStream.write(data);
            }
            OutputStream outputStream2 = this.bedjet2OutputStream;
            if (outputStream2 != null) {
                outputStream2.flush();
            }
        } catch (Exception e2) {
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            LoggerKt.logTag(TAG4, "Write exception");
            LoggerKt.exception(e2);
            shutdownClient(2);
            Message obtain = Message.obtain();
            obtain.what = MessageType.MSG_WRITE_EXCEPTION.getId();
            this.linkDetectedHandler.sendMessage(obtain);
        }
    }

    public final void connectClassic(String address) {
        V2MangerListener v2MangerListener;
        Intrinsics.checkNotNullParameter(address, "address");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".connectClassic address = " + address);
        BluetoothDevice remoteDevice = this.bluetoothAdapter.getRemoteDevice(address);
        if (remoteDevice == null) {
            V2MangerListener v2MangerListener2 = this.listener;
            if (v2MangerListener2 != null) {
                v2MangerListener2.showDeviceListFragment();
                return;
            }
            return;
        }
        this.bedjet2Device = remoteDevice;
        if (remoteDevice.getBondState() == 12) {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LoggerKt.logTag(TAG3, "Device is already paired, creating connection");
            try {
                Message obtain = Message.obtain();
                obtain.what = MessageType.MSG_CONNECT_CLIENT.getId();
                Boolean.valueOf(this.linkDetectedHandler.sendMessage(obtain));
                return;
            } catch (Exception e) {
                LoggerKt.exception(e);
                V2MangerListener v2MangerListener3 = this.listener;
                if (v2MangerListener3 != null) {
                    v2MangerListener3.showDeviceListFragment();
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            }
        }
        String TAG4 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        LoggerKt.logTag(TAG4, "Device is not paired, creating bond");
        if (!remoteDevice.createBond() || (v2MangerListener = this.listener) == null) {
            return;
        }
        v2MangerListener.registerBondReceiver(remoteDevice);
    }

    public final void disconnectDevice() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".disconnectDevice, isConnected = " + this.isConnected);
        if (this.isConnected) {
            shutdownClient(3);
        }
    }
}
