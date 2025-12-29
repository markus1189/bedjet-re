package com.bedjet.bedjet.p001ui.main;

import android.R;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.arch.FragmentController;
import com.bedjet.bedjet.arch.FragmentNavigator;
import com.bedjet.bedjet.data.local.model.ConnectionState;
import com.bedjet.bedjet.data.local.model.CurrentStatus;
import com.bedjet.bedjet.data.local.model.legacy.ButtonDataPacketV2;
import com.bedjet.bedjet.data.local.model.legacy.RunningStatusV2;
import com.bedjet.bedjet.data.local.model.legacy.ScenePacketV2;
import com.bedjet.bedjet.data.local.model.legacy.SequenceStepV2;
import com.bedjet.bedjet.data.local.model.legacy.TimerPacketV2;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.ActivityMainBinding;
import com.bedjet.bedjet.ext.MainActivityExt;
import com.bedjet.bedjet.helpers.AppReviewHelper;
import com.bedjet.bedjet.p000di.BluetoothSearchManager;
import com.bedjet.bedjet.p000di.ConnectionStateManager;
import com.bedjet.bedjet.p000di.TempModeManager;
import com.bedjet.bedjet.p001ui.CustomDialog;
import com.bedjet.bedjet.p001ui.biorhythm.BiorhythmFragment;
import com.bedjet.bedjet.p001ui.bluetooth.BluetoothFragment;
import com.bedjet.bedjet.p001ui.bluetooth.device_list.DeviceListFragment;
import com.bedjet.bedjet.p001ui.bluetooth.stored_device_list.StoredDeviceFragment;
import com.bedjet.bedjet.p001ui.connection.ConnectionFragment;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.p001ui.main.p002v2.BondBroadcastReceiver;
import com.bedjet.bedjet.p001ui.main.p002v2.MessageType;
import com.bedjet.bedjet.p001ui.main.p002v2.V2Manager;
import com.bedjet.bedjet.p001ui.main.p003v3.V3SetupKt;
import com.bedjet.bedjet.p001ui.main.p003v3.V3SetupListener;
import com.bedjet.bedjet.p001ui.main.pair.PairBedJetManager;
import com.bedjet.bedjet.p001ui.mainscreen.MainFragment;
import com.bedjet.bedjet.p001ui.mainscreen.MainFragmentV2;
import com.bedjet.bedjet.p001ui.menu.MenuFragment;
import com.bedjet.bedjet.p001ui.prompt.PromptFragment;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import com.bedjet.bedjet.p001ui.setup.SetupV3Fragment;
import com.bedjet.bedjet.p001ui.temperature.TemperatureFragment;
import com.bedjet.bedjet.p001ui.wifi.WifiFragment;
import com.bedjet.bedjet.p001ui.wifi.WifiPermissionFragment;
import com.bedjet.bedjet.utils.FirebaseException;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.Utils;
import com.bedjet.bedjet.utils.ext;
import com.bedjet.bedjet.utils.permissions;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.koin.java.KoinJavaComponent;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements FragmentNavigator, FragmentController {
    private static final int BASE_SEQ_STEP = 128;
    private static final String BEDJET_BIODATA_UUID = "00002005-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_COMMAND_UUID = "00002004-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_NAME_UUID = "00002001-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_PASSWD_UUID = "00002003-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_SERVICE_UUID = "00001000-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_SSID_UUID = "00002002-bed0-0080-aa55-4265644a6574";
    private static final String BEDJET_STATUS_UUID = "00002000-bed0-0080-aa55-4265644a6574";
    public static final String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    private static final byte COMMAND_BUTTON = 1;
    private static final byte COMMAND_CLEARSEQ = 12;
    private static final byte COMMAND_DEBUGON = 10;
    private static final byte COMMAND_ENTERBL = 9;
    private static final byte COMMAND_FANTEST = 32;
    private static final byte COMMAND_GETPARAM = 6;
    private static final byte COMMAND_GETSTATIC = 11;
    private static final byte COMMAND_LOADMEM = 3;
    private static final byte COMMAND_PMODE = 33;
    private static final byte COMMAND_RUNSEQ = 13;
    private static final byte COMMAND_SAVEMEM = 2;
    private static final byte COMMAND_SETALARM = 4;
    private static final byte COMMAND_SETFLAG = 16;
    private static final byte COMMAND_SETMODE = 14;
    private static final byte COMMAND_SETMUTE = 17;
    private static final byte COMMAND_SETPARAM = 5;
    private static final byte COMMAND_SETTEMP = 7;
    private static final int MAX_NAME_LENGTH = 15;
    public static final String OLD_PACKAGE_NAME = "com.bedjet.bedjet";
    public static final int PPAGE_DEBUG = 4;
    public static final int PPAGE_HOME = 2;
    public static final int PPAGE_PARAM = 5;
    public static final int PPAGE_STATIC = 1;
    public static final int PPAGE_VET = 3;
    private static final int RETRY_DELAY_REPLY = 700;
    private static final int RETRY_DELAY_SEND = 400;
    private static final String TAG = "MainActivity";
    static final int endConditionStart = 20;
    private String SKUFromBootloader;
    private boolean alarmOn;
    private ActivityMainBinding binding;
    private Timer commsTimeout;
    private CurrentStatus currentStatus;
    int currentStepNum;
    private SequenceStepV2 currentStepV2;
    private ProgressDialog flashProgressDialog;
    private Timer flashTimer;
    private int flashid;
    private int flashtag;
    private boolean gotStatic;
    private boolean gotTag;
    private boolean inBootloader;
    private boolean isDisconnected;
    private boolean justConnected;
    private int lastUpdatePhase;
    private boolean ledBlank;
    private BluetoothGattCharacteristic mBedJetBiodataCharacteristic;
    private BluetoothGattCharacteristic mBedJetCommandCharacteristic;
    private BluetoothGattCharacteristic mBedJetNameCharacteristic;
    private BluetoothGattCharacteristic mBedJetPasswdCharacteristic;
    private BluetoothGattCharacteristic mBedJetSsidCharacteristic;
    private BluetoothGattCharacteristic mBedJetStatusCharacteristic;
    private boolean mBioPollFlag;
    private boolean mBioWriteFlag;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private boolean mGotCommand;
    private boolean mGotName;
    private boolean mGotPasswd;
    private boolean mGotSsid;
    private boolean mGotStatus;
    private int mSavedRequestCode;
    private int[] m_seqRandom;
    private boolean needSetupSticky;
    private boolean needUpdateSticky;
    private boolean newmute;
    private int newtemp;
    private PairBedJetManager pairBedJetManager;
    private byte[] partialPacket;
    private ProgressDialog progressDialog;
    private BluetoothGattCharacteristic readChar;
    private CountDownLatch readComplete;
    private ResumeFlag resumeFlag;
    private boolean stayGattConnected;
    private boolean tagDone;
    private boolean tagMatch;
    private AlertDialog updateDialog;
    private boolean updateNag;
    private boolean wait_for_end;
    private boolean wait_for_start;
    private BluetoothGattCharacteristic writeChar;
    private CountDownLatch writeComplete;
    static final String[] phaseNames = {"Idle", "Starting", "Connecting to AP", "Got IP address", "Checking connection", "Checking for update", "Updating", "Restarting BedJet", "Some other status"};
    static final String[] endConditionNames = {"No WiFi Config", "Unable to connect", "DHCP failure", "Unable to contact server", "Connection test OK", "Connection test failed", "No update needed", "Radio is disabled!", "Restarting BedJet", "Update failed", "Some other error"};
    private String mBedjetName = "";
    private String mMemoryName1 = "MEMORY 1";
    private String mMemoryName2 = "MEMORY 2";
    private String mMemoryName3 = "MEMORY 3";
    private boolean useBedJetV2Protocol = false;
    private boolean newSequenceMode = false;
    private boolean nowFlashing = false;
    private FlashStates flashstate = FlashStates.IDLE;
    private boolean recoveryWarn = false;
    private boolean stayConnected = false;
    private final RunningStatusV2 currentStatusV2 = new RunningStatusV2();
    private final TimerPacketV2 timerPacket = new TimerPacketV2();
    private final ScenePacketV2 scenePacket = new ScenePacketV2();
    private final ButtonDataPacketV2 buttonDataPacketV2 = new ButtonDataPacketV2();
    private boolean fix22_needed = false;
    private int fix22_savedtemp = 0;
    private boolean fix22_waitcool = false;
    private boolean fix22_wascool = false;
    private boolean cool12h = false;
    public byte mLastTag = -1;
    public byte mLastRequest = -1;
    private final Handler mHandler = new Handler();
    private final Lazy<StoredDeviceManager> storedDeviceManager = KoinJavaComponent.inject(StoredDeviceManager.class);
    private final Lazy<TempModeManager> tempModeManager = KoinJavaComponent.inject(TempModeManager.class);
    private final Lazy<AppReviewHelper> appReviewManager = KoinJavaComponent.inject(AppReviewHelper.class);
    private final Lazy<FirebaseTracker> firebaseTracker = KoinJavaComponent.inject(FirebaseTracker.class);
    private final Lazy<ConnectionStateManager> connectionStateManager = KoinJavaComponent.inject(ConnectionStateManager.class);
    private final Lazy<V2Manager> v2Manager = KoinJavaComponent.inject(V2Manager.class);
    private final Lazy<BluetoothSearchManager> bluetoothSearchManager = KoinJavaComponent.inject(BluetoothSearchManager.class);
    private final Lazy<CustomDialog> customDialog = KoinJavaComponent.inject(CustomDialog.class);
    private final Function0<Unit> listener = new Function0() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit lambda$new$1;
            lambda$new$1 = MainActivity.this.lambda$new$1();
            return lambda$new$1;
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.bedjet.bedjet.ui.main.MainActivity.4
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 != 0) {
                if (i2 != 2) {
                    return;
                }
                ((ConnectionStateManager) MainActivity.this.connectionStateManager.getValue()).setConnectionState(ConnectionState.ENUMERATING, ConnectionState.GATT_CONNECT);
                MainActivity.this.needSetupSticky = false;
                MainActivity.this.needUpdateSticky = false;
                MainActivity.this.mBluetoothGatt.discoverServices();
                return;
            }
            Log.d(MainActivity.TAG, "GATT sent disconnect message");
            MainActivity.this.getCurrentFragment().gattDisconnected();
            if (MainActivity.this.stayGattConnected) {
                Log.d(MainActivity.TAG, "Lost GATT connection");
                MainActivity.this.mBluetoothGatt.connect();
                ((ConnectionStateManager) MainActivity.this.connectionStateManager.getValue()).setConnectionState(ConnectionState.ENUMERATING);
            } else {
                ((ConnectionStateManager) MainActivity.this.connectionStateManager.getValue()).setConnectionState(ConnectionState.DISCONNECTED);
            }
            MainActivity.this.isDisconnected = true;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                Log.d(MainActivity.TAG, "Got services list!");
                MainActivity.this.mBedJetBiodataCharacteristic = null;
                List<BluetoothGattService> supportedGattServices = MainActivity.this.getSupportedGattServices();
                int i2 = C06409.$SwitchMap$com$bedjet$bedjet$ui$main$DeviceType[((StoredDeviceManager) MainActivity.this.storedDeviceManager.getValue()).getCurrentDeviceType().ordinal()];
                if (i2 == 1) {
                    MainActivity.this.checkBedFrameServices(supportedGattServices);
                    return;
                }
                if (i2 == 2) {
                    MainActivity.this.checkBedJetServices(supportedGattServices);
                } else if (i2 == 3) {
                    MainActivity.this.checkBedJet3Services(supportedGattServices);
                } else {
                    Log.d(MainActivity.TAG, "Device type not recognised!");
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            BaseFragment currentFragment;
            Log.d(MainActivity.TAG, "Write completed - UUID = " + bluetoothGattCharacteristic.getUuid().toString());
            Log.d(MainActivity.TAG, " status ".concat(i == 0 ? "OK" : "FAIL"));
            if (bluetoothGattCharacteristic.equals(MainActivity.this.mBedJetCommandCharacteristic) && MainActivity.this.mBioPollFlag) {
                Log.d(MainActivity.TAG, "Sending request for response data");
                MainActivity.this.mHandler.removeCallbacks(MainActivity.this.doReadRetry);
                MainActivity.this.mHandler.postDelayed(MainActivity.this.doReadRetry, 700L);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.readCharacteristic(mainActivity.mBedJetBiodataCharacteristic);
            }
            if (MainActivity.this.writeChar == null || !MainActivity.this.writeChar.getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
                return;
            }
            MainActivity.this.writeComplete.countDown();
            if (!MainActivity.this.mBioWriteFlag || (currentFragment = MainActivity.this.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.biodataWritten();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                if (bluetoothGattCharacteristic.getUuid().toString().equals(MainActivity.BEDJET_STATUS_UUID)) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    byte[] bArr = new byte[MainActivity.this.partialPacket.length + value.length];
                    System.arraycopy(MainActivity.this.partialPacket, 0, bArr, 0, MainActivity.this.partialPacket.length);
                    System.arraycopy(value, 0, bArr, MainActivity.this.partialPacket.length, value.length);
                    MainActivity.this.handleBedJetPacket(bArr);
                } else {
                    byte[] value2 = bluetoothGattCharacteristic.getValue();
                    BaseFragment currentFragment = MainActivity.this.getCurrentFragment();
                    if (currentFragment != null) {
                        currentFragment.readAvailable(bluetoothGattCharacteristic, value2);
                    }
                }
                if (bluetoothGattCharacteristic.getUuid().toString().equals(MainActivity.BEDJET_BIODATA_UUID)) {
                    byte[] value3 = bluetoothGattCharacteristic.getValue();
                    Log.d(MainActivity.TAG, "Got biodata response");
                    MainActivity.this.getCurrentFragment().biodataAvailable(value3);
                    MainActivity.this.processBioResponse(value3);
                }
                if (MainActivity.this.readChar == null || !MainActivity.this.readChar.getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
                    return;
                }
                MainActivity.this.readComplete.countDown();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getUuid().toString().equals(MainActivity.BEDJET_STATUS_UUID)) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (value[0] == 0) {
                    MainActivity.this.handleBedJetPacket(Arrays.copyOfRange(value, 1, value.length));
                    return;
                }
                MainActivity.this.partialPacket = Arrays.copyOfRange(value, 1, value.length);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.readCharacteristic(mainActivity.mBedJetStatusCharacteristic);
            }
        }
    };
    private final Runnable doReadRetry = new Runnable() { // from class: com.bedjet.bedjet.ui.main.MainActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.mBedJetCommandCharacteristic == null) {
                MainActivity.this.cancelReadRetry();
            } else {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.requestBioPacket(mainActivity.mSavedRequestCode, true);
            }
            MainActivity.this.mHandler.postDelayed(MainActivity.this.doReadRetry, 400L);
        }
    };

    int makeushort(byte b, byte b2) {
        return ((b & 255) * 256) + (b2 & 255);
    }

    public void setResumeFlag(ResumeFlag resumeFlag) {
        this.resumeFlag = resumeFlag;
    }

    public ResumeFlag getResumeFlag() {
        return this.resumeFlag;
    }

    public void setSendStep(SequenceStepV2 sequenceStepV2) {
        this.currentStepV2 = sequenceStepV2;
    }

    public void setStepNum(int i) {
        this.currentStepNum = i;
    }

    public boolean getNeedUpdate() {
        return this.needUpdateSticky;
    }

    public boolean getNeedSetup() {
        return this.needSetupSticky;
    }

    public boolean getNeedWifiSetup() {
        return this.currentStatus.getConnTestPassed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoggerKt.logTag(TAG, ".onCreate");
        adjustFontScale(getResources().getConfiguration());
        try {
            this.mBluetoothAdapter = this.bluetoothSearchManager.getValue().getBluetoothAdapter();
            checkOldAppInstalled();
            ActivityMainBinding activityMainBinding = (ActivityMainBinding) DataBindingUtil.setContentView(this, C0624R.layout.activity_main);
            this.binding = activityMainBinding;
            activityMainBinding.setPresenter(this);
            ViewCompat.setOnApplyWindowInsetsListener(this.binding.getRoot(), new OnApplyWindowInsetsListener() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda5
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return MainActivity.lambda$onCreate$0(view, windowInsetsCompat);
                }
            });
            this.binding.executePendingBindings();
            this.pairBedJetManager = new PairBedJetManager(this, new PairBedJetManager.PairBedJetListener() { // from class: com.bedjet.bedjet.ui.main.MainActivity.1
                @Override // com.bedjet.bedjet.ui.main.pair.PairBedJetManager.PairBedJetListener
                public void onCancel() {
                    MainActivity.this.disconnectDevice(0);
                    MainActivity.this.showStoredDeviceFragment(4);
                }

                @Override // com.bedjet.bedjet.ui.main.pair.PairBedJetManager.PairBedJetListener
                public void senData(String str) {
                    MainActivity.this.sendData(str);
                }
            });
            if (bundle == null) {
                this.needUpdateSticky = false;
                this.needSetupSticky = false;
            }
            this.storedDeviceManager.getValue().loadDevices();
            this.tempModeManager.getValue().loadUseCelsius();
            this.isDisconnected = true;
            this.mGotStatus = false;
            this.mGotName = false;
            this.mGotSsid = false;
            this.mGotPasswd = false;
            this.mGotCommand = false;
            this.currentStatus = new CurrentStatus();
            this.connectionStateManager.getValue().setConnectionState(ConnectionState.DISCONNECTED);
            if (permissions.hasPermissions(this)) {
                showBluetoothFragment(1);
            } else {
                addSpecifiedFragment(PromptFragment.INSTANCE.newInstance(PromptType.PROMPT_BLUET0OTH));
            }
            this.v2Manager.getValue().setListener(new C06332());
        } catch (Exception e) {
            this.customDialog.getValue().showFailedBleAdapterDialog(this);
            LoggerKt.exception(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bedjet.bedjet.ui.main.MainActivity$2 */
    /* loaded from: classes.dex */
    public class C06332 implements V2Manager.V2MangerListener {
        C06332() {
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showProgressDialog(String str) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.progressDialog = ProgressDialog.show(mainActivity, null, str);
            MainActivity.this.progressDialog.setIcon((Drawable) null);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showAlertDialog(String str, String str2) {
            new AlertDialog.Builder(MainActivity.this).setTitle(str).setMessage(str2).setNeutralButton(C0624R.string.btn_ok, (DialogInterface.OnClickListener) null).show();
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void connectClient() {
            MainActivity.this.gotStatic = false;
            MainActivity.this.justConnected = true;
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void connectSuccess() {
            showToast("Connect success!");
            MainActivity.this.recoveryWarn = false;
            MainActivity.this.justConnected = true;
            MainActivity.this.gotTag = false;
            MainActivity.this.tagMatch = false;
            BaseFragment currentFragment = MainActivity.this.getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.bedJetConnected();
            }
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showBluetoothFragment() {
            MainActivity.this.showBluetoothFragment(2);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void readData(byte[] bArr) {
            byte b = bArr[0];
            if (b == 5) {
                MainActivity.this.checkDebug(bArr);
                return;
            }
            if (b == 6) {
                MainActivity.this.checkVetData(bArr);
                return;
            }
            if (b == 83) {
                MainActivity.this.decodeBootloader(bArr);
            } else if (b == 89) {
                MainActivity.this.checkNewFormat(bArr);
            } else {
                MainActivity.this.checkHomeBedJetV1(bArr);
            }
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void updateFlash() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.updateFlash(mainActivity.flashid);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showIncompatibleDialog() {
            ((CustomDialog) MainActivity.this.customDialog.getValue()).showIncompatibleDialog(MainActivity.this);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void disableProgress() {
            MainActivity.this.disableProgressDialog();
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showDeviceListFragment() {
            MainActivity.this.showDeviceListFragment(3);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void registerBondReceiver(BluetoothDevice bluetoothDevice) {
            MainActivity.this.registerBondReceiver(bluetoothDevice);
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void showToast(final String str) {
            if (MainActivityExt.isNotResumed(MainActivity.this)) {
                return;
            }
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.main.MainActivity$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.C06332.this.lambda$showToast$0(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showToast$0(String str) {
            Toast.makeText(MainActivity.this, str, 0).show();
        }

        @Override // com.bedjet.bedjet.ui.main.v2.V2Manager.V2MangerListener
        public void setDisconnect(boolean z) {
            MainActivity.this.isDisconnected = z;
        }
    }

    private void checkOldAppInstalled() {
        LoggerKt.logTag(TAG, ".checkOldAppInstalled, current applicationId: com.bedjet");
        boolean isPackageInstalled = isPackageInstalled();
        LoggerKt.logTag(TAG, ".checkOldAppInstalled, packageInstalled: " + isPackageInstalled);
        if (isPackageInstalled) {
            this.customDialog.getValue().showOldAppInstalledDialog(this);
        }
    }

    private boolean isPackageInstalled() {
        try {
            getPackageManager().getPackageInfo(OLD_PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.cancel();
            this.progressDialog = null;
        }
    }

    public boolean getUseBedJetV2protocol() {
        return this.useBedJetV2Protocol;
    }

    public int getV2fwVer() {
        return this.currentStatusV2.firmware_ver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bedjet.bedjet.ui.main.MainActivity$3] */
    public void updateFlash(final int i) {
        LoggerKt.log("MainActivity.updateFlash, resid = " + i);
        if (this.nowFlashing) {
            Log.d("Flash", "Rejected attempt to start second flasher thread.");
            return;
        }
        this.nowFlashing = true;
        this.recoveryWarn = true;
        this.useBedJetV2Protocol = true;
        Log.d("Flash", "Flasher starting.");
        this.flashstate = FlashStates.IDLE;
        if (!this.v2Manager.getValue().getIsConnected()) {
            Toast.makeText(this, "Not Connected to BedJet", 0).show();
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.flashProgressDialog = progressDialog;
        progressDialog.setMessage("Updating firmware");
        this.flashProgressDialog.setProgressStyle(1);
        this.flashProgressDialog.setIndeterminate(false);
        this.flashProgressDialog.setMax(100);
        this.flashProgressDialog.setIcon((Drawable) null);
        this.flashProgressDialog.setCancelable(false);
        this.flashProgressDialog.show();
        new Thread() { // from class: com.bedjet.bedjet.ui.main.MainActivity.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i2;
                if (!MainActivity.this.inBootloader) {
                    int i3 = 0;
                    do {
                        MainActivity.this.startFlashTimer(0, FlashStates.ENTERBL);
                        MainActivity.this.sendData("enterbl");
                        i3++;
                        if (i3 > 5) {
                            MainActivity.this.flashProgressDialog.cancel();
                            Message obtain = Message.obtain();
                            obtain.obj = "Failed to enter bootloader";
                            obtain.what = MessageType.MSG_UPDATE_ERR.getId();
                            ((V2Manager) MainActivity.this.v2Manager.getValue()).getLinkDetectedHandler().sendMessage(obtain);
                            MainActivity.this.nowFlashing = false;
                            return;
                        }
                        do {
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException unused) {
                            }
                        } while (MainActivity.this.flashstate == FlashStates.ENTERBL);
                    } while (MainActivity.this.flashstate != FlashStates.f122OK);
                }
                int i4 = 0;
                do {
                    MainActivity.this.startFlashTimer(0, FlashStates.READSKU);
                    MainActivity.this.sendData("getsku");
                    i4++;
                    if (i4 > 5) {
                        MainActivity.this.flashProgressDialog.cancel();
                        Message obtain2 = Message.obtain();
                        obtain2.obj = "Unable to read product SKU";
                        obtain2.what = MessageType.MSG_UPDATE_ERR.getId();
                        ((V2Manager) MainActivity.this.v2Manager.getValue()).getLinkDetectedHandler().sendMessage(obtain2);
                        MainActivity.this.nowFlashing = false;
                        return;
                    }
                    do {
                        try {
                            Thread.sleep(50L);
                        } catch (InterruptedException unused2) {
                        }
                    } while (MainActivity.this.flashstate == FlashStates.READSKU);
                } while (MainActivity.this.flashstate != FlashStates.f122OK);
                int i5 = i;
                if (MainActivity.this.SKUFromBootloader.equals("6002NA")) {
                    i5 = C0624R.raw.sku6002;
                }
                if (MainActivity.this.SKUFromBootloader.equals("7002EU")) {
                    i5 = C0624R.raw.sku7002;
                }
                InputStream openRawResource = MainActivity.this.getResources().openRawResource(i5);
                byte[] bArr = new byte[32768];
                MainActivity.this.stayConnected = true;
                try {
                    i2 = openRawResource.read(bArr, 0, 32768);
                } catch (Exception e) {
                    Log.e("BJUP", "Error reading raw resource file");
                    e.printStackTrace();
                    i2 = 0;
                }
                Log.d("BJUP", "Read " + i2 + " bytes from stream");
                int makeushort = MainActivity.this.makeushort(bArr[1], bArr[0]);
                int makeushort2 = MainActivity.this.makeushort(bArr[3], bArr[2]);
                int makeushort3 = MainActivity.this.makeushort(bArr[5], bArr[4]);
                int makeushort4 = MainActivity.this.makeushort(bArr[7], bArr[6]);
                int makeushort5 = MainActivity.this.makeushort(bArr[9], bArr[8]);
                Log.d("BJUP", "Header: header_size=" + makeushort + "  num_frags=" + makeushort2);
                Log.d("BJUP", "frag_stored=" + makeushort3 + "  first_erase=" + makeushort4 + "  frags_erase=" + makeushort5);
                MainActivity.this.eraseFlashBlock(15);
                int i6 = makeushort4;
                int i7 = 0;
                while (true) {
                    int i8 = makeushort2 / makeushort5;
                    if (i6 < makeushort4 + i8) {
                        int i9 = makeushort5;
                        if (MainActivity.this.programFlashBlock(i6, (i6 - makeushort4) * makeushort5, makeushort5, makeushort, makeushort3, bArr) == 0) {
                            int i10 = i7 + 1;
                            if (i10 >= 20) {
                                if (MainActivity.this.flashProgressDialog != null) {
                                    MainActivity.this.flashProgressDialog.cancel();
                                }
                                MainActivity.this.nowFlashing = false;
                                MainActivity.this.recoveryWarn = false;
                                Message obtain3 = Message.obtain();
                                obtain3.obj = "Update process failed";
                                obtain3.what = MessageType.MSG_UPDATE_ERR.getId();
                                ((V2Manager) MainActivity.this.v2Manager.getValue()).getLinkDetectedHandler().sendMessage(obtain3);
                                Log.d("Flash", "Flash process ended with failure.");
                                MainActivity.this.stayConnected = false;
                                return;
                            }
                            i6--;
                            i7 = i10;
                        }
                        MainActivity.this.flashProgressDialog.setProgress(((i6 - 1) * 100) / i8);
                        i6++;
                        makeushort5 = i9;
                    } else {
                        if (MainActivity.this.flashProgressDialog != null) {
                            MainActivity.this.flashProgressDialog.cancel();
                        }
                        MainActivity.this.useBedJetV2Protocol = true;
                        MainActivity.this.sendData("reboot");
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        MainActivity.this.sendData("reboot");
                        MainActivity.this.nowFlashing = false;
                        MainActivity.this.recoveryWarn = false;
                        Log.d("Flash", "Flash thread ended with success.");
                        MainActivity.this.stayConnected = false;
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eraseFlashBlock(int i) {
        byte[] bArr = {66, 2, 2, 0, 0};
        int i2 = 0;
        do {
            bArr[3] = (byte) i;
            startFlashTimer(i, FlashStates.ERASING);
            fixChecksumAndSend(bArr, "eraseFlashBlock");
            do {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException unused) {
                }
            } while (this.flashstate == FlashStates.ERASING);
            stopFlashTimer();
            if (this.flashstate == FlashStates.f122OK) {
                return 1;
            }
            if (this.flashstate == FlashStates.FAILED) {
                Log.d("BJUP", "Error erasing flash block" + i);
                i2++;
            }
        } while (i2 < 20);
        return 0;
    }

    int programFlashBlock(int i, int i2, int i3, int i4, int i5, byte[] bArr) {
        byte[] bArr2 = new byte[i5 + 5];
        if (eraseFlashBlock(i) == 0) {
            return 0;
        }
        int i6 = i2;
        while (i6 < i3 + i2) {
            int i7 = (i6 * i5) + i4;
            for (int i8 = 0; i8 < i5; i8++) {
                bArr2[i8 + 4] = bArr[i7 + i8];
            }
            bArr2[0] = 66;
            bArr2[1] = (byte) (i5 + 2);
            bArr2[2] = 3;
            int i9 = i6 & 31;
            bArr2[3] = (byte) i9;
            startFlashTimer(i9, FlashStates.FLASHING);
            fixChecksumAndSend(bArr2, "programFlashBlock");
            do {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException unused) {
                }
            } while (this.flashstate == FlashStates.FLASHING);
            stopFlashTimer();
            if (this.flashstate == FlashStates.TIMEOUT) {
                i6--;
            }
            if (this.flashstate == FlashStates.FAILED) {
                return 0;
            }
            i6++;
        }
        return 1;
    }

    public void setConnectionFlag(boolean z) {
        this.stayGattConnected = z;
    }

    int getUpdateInt(int i) {
        String updateVer = getUpdateVer(i);
        if (updateVer.charAt(0) == 'V' && updateVer.charAt(2) == '.') {
            return (((updateVer.charAt(1) - '0') * 16) + updateVer.charAt(3)) - 48;
        }
        return 0;
    }

    String getUpdateVer(int i) {
        if (i == 0) {
            this.flashid = C0624R.raw.sku6002;
            this.useBedJetV2Protocol = true;
            return "Unknown";
        }
        InputStream openRawResource = getResources().openRawResource(i);
        byte[] bArr = new byte[5];
        try {
            openRawResource.skip(24L);
            if (openRawResource.read(bArr, 0, 4) != 4) {
                this.flashid = 0;
                return "Header bad";
            }
            bArr[4] = 0;
            return new String(bArr);
        } catch (Exception e) {
            Log.e("BJUP", "Error reading raw resource file");
            e.printStackTrace();
            this.flashid = 0;
            return "Invalid";
        }
    }

    public void setCurrentDevice(DeviceRecord deviceRecord) {
        this.storedDeviceManager.getValue().setCurrentDevice(deviceRecord.getDeviceAddress(), DeviceType.INSTANCE.toDeviceType(deviceRecord.getDeviceType()));
    }

    public byte[] getBiodata() {
        readCharacteristicBlocking(this.mBedJetBiodataCharacteristic);
        return this.mBedJetBiodataCharacteristic.getValue();
    }

    public String getBedjetName() {
        return this.mBedjetName;
    }

    public String getMemoryName1() {
        return this.mMemoryName1;
    }

    public String getMemoryName2() {
        return this.mMemoryName2;
    }

    public String getMemoryName3() {
        return this.mMemoryName3;
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void addSpecifiedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(C0624R.id.mainContainer, fragment).commitAllowingStateLoss();
    }

    public void showV3Fragment() {
        cancelReadRetry();
        addSpecifiedFragment(new MainFragment());
        this.appReviewManager.getValue().initStart(DeviceType.BEDJET3, this.listener);
    }

    public void showV2Fragment() {
        cancelReadRetry();
        addSpecifiedFragment(new MainFragmentV2());
        this.appReviewManager.getValue().initStart(DeviceType.BEDJET2, this.listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$1() {
        this.appReviewManager.getValue().showAppReviewDialog(this);
        return Unit.INSTANCE;
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showStoredDeviceFragment(int i) {
        LoggerKt.logTag(TAG, ".showStoredDeviceFragment path: " + i);
        cancelReadRetry();
        addSpecifiedFragment(new StoredDeviceFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showPromptFragment(PromptType promptType) {
        LoggerKt.logTag(TAG, ".showPromptFragment promptType: " + promptType);
        if (promptType != PromptType.PROMPT_SETUP) {
            cancelReadRetry();
        }
        addSpecifiedFragment(PromptFragment.INSTANCE.newInstance(promptType));
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showSetupV3Fragment() {
        LoggerKt.logTag(TAG, ".showSetupV3Fragment");
        addSpecifiedFragment(new SetupV3Fragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showBluetoothFragment(int i) {
        LoggerKt.logTag(TAG, ".showBluetoothFragment path: " + i);
        cancelReadRetry();
        addSpecifiedFragment(new BluetoothFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showConnectionFragment(int i) {
        LoggerKt.logTag(TAG, ".showConnectionFragment path:" + i);
        cancelReadRetry();
        this.pairBedJetManager.setStartedPhase();
        addSpecifiedFragment(new ConnectionFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showDeviceListFragment(int i) {
        LoggerKt.logTag(TAG, ".showDeviceListFragment path:" + i);
        addSpecifiedFragment(new DeviceListFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showTemperatureFragment() {
        LoggerKt.logTag(TAG, ".showTemperatureFragment");
        addSpecifiedFragment(new TemperatureFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showBiorhythmFragment() {
        LoggerKt.logTag(TAG, ".showBiorhythmFragment");
        addSpecifiedFragment(new BiorhythmFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showMenuFragment() {
        LoggerKt.logTag(TAG, ".showMenuFragment");
        addSpecifiedFragment(new MenuFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showWifiPermissionFragment() {
        LoggerKt.logTag(TAG, ".showWifiPermissionFragment");
        addSpecifiedFragment(new WifiPermissionFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showWifiFragment() {
        LoggerKt.logTag(TAG, ".showWifiFragment");
        addSpecifiedFragment(new WifiFragment());
    }

    @Override // com.bedjet.bedjet.arch.FragmentNavigator
    public void showConnectedFragment() {
        LoggerKt.logTag(TAG, ".showConnectedFragment");
        int i = C06409.$SwitchMap$com$bedjet$bedjet$ui$main$DeviceType[this.storedDeviceManager.getValue().getCurrentDeviceType().ordinal()];
        if (i == 2) {
            showV2Fragment();
        } else {
            if (i != 3) {
                return;
            }
            showV3Fragment();
        }
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void hideSystemUI() {
        getWindow().addFlags(1024);
        this.binding.mainActionBar.setVisibility(8);
        hideBackButton();
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void showActionBar(boolean z) {
        this.binding.mainActionBar.setVisibility(0);
        if (z) {
            showBackButton();
        } else {
            hideBackButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragment getCurrentFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C0624R.id.mainContainer);
        if (findFragmentById instanceof BaseFragment) {
            return (BaseFragment) findFragmentById;
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(C0624R.id.mainContainer);
        if (findFragmentById instanceof BaseFragment) {
            if (((BaseFragment) findFragmentById).isCanGoBack()) {
                super.onBackPressed();
                supportFragmentManager.popBackStack();
                return;
            }
            return;
        }
        super.onBackPressed();
        if (findFragmentById != null) {
            supportFragmentManager.popBackStack();
        }
    }

    void checkBedJetServices(List<BluetoothGattService> list) {
        Log.d(TAG, "Services read in V2 mode");
        Iterator<BluetoothGattService> it = list.iterator();
        while (it.hasNext()) {
            Iterator<BluetoothGattCharacteristic> it2 = it.next().getCharacteristics().iterator();
            while (it2.hasNext()) {
                Log.d(TAG, "Found characteristic " + it2.next().getUuid().toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0088, code lost:
    
        if (r4.equals(com.bedjet.bedjet.p001ui.main.MainActivity.BEDJET_PASSWD_UUID) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void checkBedJet3Services(java.util.List<android.bluetooth.BluetoothGattService> r8) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.p001ui.main.MainActivity.checkBedJet3Services(java.util.List):void");
    }

    public boolean getIsDisconnected() {
        Log.d(TAG, "Currently ".concat(this.isDisconnected ? "disconnected" : "connected"));
        return this.isDisconnected;
    }

    void checkBedFrameServices(List<BluetoothGattService> list) {
        Log.d(TAG, "Device type is BEDFRAME, but no implementation yet");
    }

    void showConnectStatus(String str) {
        AlertDialog alertDialog = this.updateDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.updateDialog = null;
        }
        AlertDialog create = new AlertDialog.Builder(this).setTitle("Firmware Update").setMessage(str).setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.lambda$showConnectStatus$2(dialogInterface, i);
            }
        }).create();
        this.updateDialog = create;
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConnectStatus$2(DialogInterface dialogInterface, int i) {
        this.updateDialog.dismiss();
        this.updateDialog = null;
    }

    private void updatePhaseTask(int i) {
        String str;
        if (this.updateDialog == null || this.lastUpdatePhase == i) {
            return;
        }
        this.lastUpdatePhase = i;
        if (this.wait_for_start && i != 21 && i != 24 && i != 26) {
            this.wait_for_start = false;
            this.wait_for_end = true;
        }
        if (this.wait_for_end) {
            if (i == 21) {
                showConnectStatus("The connection test has failed.");
                this.wait_for_end = false;
            }
            if (i == 24) {
                showConnectStatus("Connection test has completed OK.");
                this.wait_for_end = false;
            }
            if (i == 26) {
                showConnectStatus("Firmware update is not needed.");
                this.wait_for_end = false;
            }
        }
        if (i < 20) {
            String[] strArr = phaseNames;
            if (i >= strArr.length) {
                i = strArr.length - 1;
            }
            str = strArr[i];
        } else {
            int i2 = i - 20;
            String[] strArr2 = endConditionNames;
            if (i2 > strArr2.length) {
                i2 = strArr2.length - 1;
            }
            str = strArr2[i2];
        }
        this.updateDialog.setMessage(str);
    }

    public void doBedJetUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        setConnectionFlag(true);
        AlertDialog create = builder.setTitle("Firmware Update").setNeutralButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.lambda$doBedJetUpdate$3(dialogInterface, i);
            }
        }).setMessage("Waiting for reconnect").create();
        this.updateDialog = create;
        create.show();
        this.wait_for_start = true;
        this.wait_for_end = false;
        sendBedJetButton(67);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doBedJetUpdate$3(DialogInterface dialogInterface, int i) {
        setConnectionFlag(false);
        this.updateDialog = null;
    }

    public void requestWithRetry(int i) {
        this.mSavedRequestCode = i;
        this.mHandler.postDelayed(this.doReadRetry, 400L);
        Log.d(TAG, "Sending request " + i);
        requestBioPacket(i, false);
    }

    public void cancelReadRetry() {
        Log.d(TAG, "Cancelling read retry");
        this.mHandler.removeCallbacks(this.doReadRetry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestBioPacket(int i, boolean z) {
        if (!z) {
            byte b = (byte) (this.mLastTag + 1);
            this.mLastTag = b;
            if (b == 0) {
                this.mLastTag = (byte) 1;
            }
        }
        byte b2 = (byte) i;
        this.mLastRequest = b2;
        sendBedjetCommand(new byte[]{65, b2, this.mLastTag});
    }

    public void sendBioCommand(int i, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = SignedBytes.MAX_POWER_OF_TWO;
        bArr2[1] = (byte) i;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2 + 2] = bArr[i2];
        }
        sendBedjetCommand(bArr2);
    }

    void processBioResponse(byte[] bArr) {
        if (bArr.length >= 3 && bArr[0] == this.mLastRequest && bArr[1] == this.mLastTag) {
            String trim = new String(Arrays.copyOfRange(bArr, 2, bArr.length)).trim();
            byte b = this.mLastRequest;
            if (b == 0) {
                this.connectionStateManager.getValue().setConnectionState(ConnectionState.MEMORY_READ, ConnectionState.NAME_READ);
                cancelReadRetry();
                this.mBedjetName = new String(trim).trim();
                Log.d(TAG, "Got name from BedJet: " + this.mBedjetName);
                updateDeviceName(this.mBedjetName);
                requestWithRetry(1);
                return;
            }
            if (b != 1) {
                return;
            }
            byte b2 = bArr[2];
            if (b2 == 0) {
                this.mMemoryName1 = "M1";
            } else if (b2 == 1) {
                this.mMemoryName1 = "M1 EMPTY";
            } else {
                this.mMemoryName1 = new String(Arrays.copyOfRange(bArr, 2, 17)).trim();
            }
            byte b3 = bArr[18];
            if (b3 == 0) {
                this.mMemoryName2 = "M2";
            } else if (b3 == 1) {
                this.mMemoryName2 = "M2 EMPTY";
            } else {
                this.mMemoryName2 = new String(Arrays.copyOfRange(bArr, 18, 33)).trim();
            }
            byte b4 = bArr[34];
            if (b4 == 0) {
                this.mMemoryName3 = "M3";
            } else if (b4 == 1) {
                this.mMemoryName3 = "M3 EMPTY";
            } else {
                this.mMemoryName3 = new String(Arrays.copyOfRange(bArr, 34, 49)).trim();
            }
            Log.d(TAG, "got memory names: " + this.mMemoryName1 + " " + this.mMemoryName2 + " " + this.mMemoryName3);
            this.connectionStateManager.getValue().setConnectionState(ConnectionState.CONNECTED, ConnectionState.MEMORY_READ);
            cancelReadRetry();
            if (getCurrentFragment() != null) {
                getCurrentFragment().bedJetConnected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBedJetPacket(byte[] bArr) {
        LoggerKt.log("MainActivity.handleBedJetPacket, data = " + Arrays.toString(bArr) + ",  hexDump: " + LoggerKt.hexDump(bArr));
        if (bArr[0] == 86) {
            checkV3Format(bArr);
        }
    }

    void checkV3Format(byte[] bArr) {
        int i;
        if (bArr.length < 5) {
            return;
        }
        byte b = bArr[1];
        if (b == 0) {
            Log.d(TAG, "Packet with specified data length of zero");
            return;
        }
        if (b != bArr.length - 3) {
            Log.d(TAG, String.format("Length mismatch: specified=%d, actual=%d", Integer.valueOf(b), Integer.valueOf(bArr.length - 3)));
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = b + 2;
            if (i2 >= i) {
                break;
            }
            try {
                i3 += bArr[i2];
                i2++;
            } catch (Exception unused) {
                Log.d(TAG, "Packet was mangled");
                return;
            }
            Log.d(TAG, "Packet was mangled");
            return;
        }
        if (((i3 & 255) ^ 255) != (bArr[i] & 255)) {
            return;
        }
        byte b2 = bArr[2];
        if (b2 == 1) {
            decodeHome(bArr);
        } else if (b2 != 2) {
            Log.d(TAG, String.format("Bad packet type 0x%02x received.", Byte.valueOf(b2)));
        } else {
            decodeDebug(bArr);
        }
    }

    void decodeHome(byte[] bArr) {
        this.currentStatus.setRemainHours(bArr[3]);
        this.currentStatus.setRemainMinutes(bArr[4]);
        this.currentStatus.setRemainSeconds(bArr[5]);
        this.currentStatus.setActualTemp(bArr[6]);
        this.currentStatus.setSetPointTemp(bArr[7]);
        this.currentStatus.setOperatingMode(bArr[8]);
        this.currentStatus.setFanStep(bArr[9]);
        this.currentStatus.setMaximumHours(bArr[10]);
        this.currentStatus.setMaximumMinutes(bArr[11]);
        this.currentStatus.setMinimumTemp(bArr[12]);
        this.currentStatus.setMaximumTemp(bArr[13]);
        this.currentStatus.setTurboTime(Utils.makeUshort(bArr[14], bArr[15]));
        this.currentStatus.setAmbientTemp(bArr[16]);
        this.currentStatus.setShutdownReason(bArr[17]);
        this.currentStatus.setUpdatePhase(bArr[25]);
        this.currentStatus.setBeepsMuted((bArr[26] & 1) != 0);
        this.currentStatus.setLedsEnabled((16 & bArr[26]) != 0);
        this.currentStatus.setUnitSetup((4 & bArr[26]) != 0);
        this.currentStatus.setDualZone((bArr[21] & 2) != 0);
        if (!this.currentStatus.getUnitSetup()) {
            this.needSetupSticky = true;
        }
        this.currentStatus.setConnTestPassed((bArr[26] & 32) != 0);
        if (bArr.length > 28) {
            this.currentStatus.setSequenceStep(bArr[27]);
        } else {
            this.currentStatus.setSequenceStep(0);
        }
        if (bArr.length > 29) {
            this.currentStatus.setNotifyCode(bArr[28]);
        } else {
            this.currentStatus.setNotifyCode(0);
        }
        final BaseFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.lambda$decodeHome$4(currentFragment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeHome$4(BaseFragment baseFragment) {
        if (!this.storedDeviceManager.getValue().getBondedFlag(0)) {
            this.pairBedJetManager.linkBedjet(this.currentStatus.getDualZone(), true);
        } else {
            updatePhaseTask(this.currentStatus.getUpdatePhase());
            baseFragment.updateDisplay();
        }
    }

    public void sendBedjetCommand(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mBedJetCommandCharacteristic;
        if (bluetoothGattCharacteristic != null) {
            bluetoothGattCharacteristic.setValue(bArr);
            byte b = bArr[0];
            boolean z = b == 65;
            this.mBioPollFlag = z;
            this.mBioWriteFlag = b == 64;
            if (!z) {
                Log.d(TAG, "Command written to BedJet");
                writeCharacteristicBlocking(this.mBedJetCommandCharacteristic);
                return;
            }
            Log.d(TAG, "Polling BedJet for parameter " + ((int) bArr[1]) + " tag " + ((int) bArr[2]));
            writeCharacteristic(this.mBedJetCommandCharacteristic);
        }
    }

    public Handler getmHandler() {
        return this.mHandler;
    }

    public void sendBedJetButton(int i) {
        sendBedjetCommand(new byte[]{1, (byte) i});
    }

    public void sendBedJetTime(int i, int i2) {
        sendBedjetCommand(new byte[]{2, (byte) i, (byte) i2});
    }

    public void sendBedJetTemp(int i) {
        sendBedjetCommand(new byte[]{3, (byte) i});
    }

    public void sendBedJetFan(int i) {
        sendBedjetCommand(new byte[]{7, (byte) i});
    }

    public void sendBedJetClock(int i, int i2) {
        sendBedjetCommand(new byte[]{8, (byte) i, (byte) i2});
    }

    public boolean displaySetupWarnings() {
        if (this.currentStatus.getUnitSetup()) {
            return false;
        }
        showPromptFragment(PromptType.PROMPT_SETUP);
        return true;
    }

    public void sendBedJetV2Command(int i) {
        this.buttonDataPacketV2.command = (byte) i;
        sendData("command");
    }

    public void setV2MuteStatus(boolean z, boolean z2) {
        this.newmute = z;
        this.ledBlank = z2;
        sendData("setmute");
    }

    private void initSettingsPacket() {
        this.scenePacket.setupV2OperatingMode = (byte) this.currentStatusV2.operatingMode;
        this.scenePacket.timerHour = (byte) this.currentStatusV2.timerHour;
        this.scenePacket.timerMinute = (byte) this.currentStatusV2.timerMinute;
        this.scenePacket.timerSecond = (byte) this.currentStatusV2.timerSecond;
        this.scenePacket.wind = (byte) ((this.currentStatusV2.fanSpeed + 1) * 5);
        this.scenePacket.temp = (byte) this.currentStatusV2.customSetpoint;
        this.scenePacket.isQuiet = (byte) (this.currentStatusV2.muteFlag == 0 ? 0 : 1);
        this.scenePacket.isAlarm = (byte) 0;
        this.scenePacket.alarmHour = (byte) 0;
        this.scenePacket.alarmMinute = (byte) 0;
    }

    public void sendBedJetV2Fan(int i) {
        initSettingsPacket();
        this.scenePacket.wind = (byte) ((i + 1) * 5);
        sendData("scene");
    }

    public void setBedJetV2Temp(int i, boolean z) {
        if (z) {
            this.newtemp = i;
            sendData("customSetpoint");
        } else {
            initSettingsPacket();
            this.scenePacket.temp = (byte) i;
            sendData("scene");
        }
    }

    public void setBedJetV2Time(int i, int i2) {
        initSettingsPacket();
        this.scenePacket.timerHour = (byte) i;
        this.scenePacket.timerMinute = (byte) i2;
        this.scenePacket.timerSecond = (byte) 0;
        sendData("scene");
    }

    public void loadMemV2(int i) {
        if (this.useBedJetV2Protocol) {
            this.timerPacket.usedMemory = (byte) i;
            sendData("loadmem");
            return;
        }
        SharedPreferences preferences = getPreferences(0);
        int i2 = preferences.getInt("V1MemoryMode" + i, -1);
        if (i2 == -1) {
            Toast.makeText(this, "Selected memory empty", 1).show();
            return;
        }
        initSettingsPacket();
        this.scenePacket.setupV2OperatingMode = (byte) i2;
        this.scenePacket.timerHour = (byte) preferences.getInt("V1TimerHour" + i, 0);
        this.scenePacket.timerMinute = (byte) preferences.getInt("V1TimerMinute" + i, 1);
        this.scenePacket.timerSecond = (byte) preferences.getInt("V1TimerSecond" + i, 0);
        this.scenePacket.wind = (byte) ((preferences.getInt("V1FanStep" + i, 0) * 5) + 5);
        this.scenePacket.temp = (byte) preferences.getInt("V1SetPoint" + i, 80);
        this.scenePacket.isQuiet = (byte) preferences.getInt("V1MuteFlag" + i, 0);
        sendData("scene");
    }

    public void saveMemV2(int i) {
        if (this.useBedJetV2Protocol) {
            this.timerPacket.usedMemory = (byte) i;
            sendData("savemem");
            return;
        }
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putInt("V1MemoryMode" + i, this.currentStatusV2.operatingMode);
        edit.putInt("V1TimerHour" + i, this.currentStatusV2.timerHour);
        edit.putInt("V1TimerMinute" + i, this.currentStatusV2.timerMinute);
        edit.putInt("V1TimerSecond" + i, this.currentStatusV2.timerSecond);
        edit.putInt("V1FanStep" + i, this.currentStatusV2.fanSpeed);
        edit.putInt("V1SetPoint" + i, this.currentStatusV2.customSetpoint);
        edit.putInt("V1MuteFlag" + i, this.currentStatusV2.muteFlag);
        edit.apply();
    }

    public void setSeqRandom(int[] iArr) {
        this.m_seqRandom = iArr;
    }

    public void sendData(String str) {
        String str2;
        Calendar calendar = Calendar.getInstance(Locale.ROOT);
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        int i3 = calendar.get(13);
        Log.d(TAG, String.format("C=%s T=%s at %02d:%02d:%02d", str, this.useBedJetV2Protocol ? "new" : "old", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        if (this.useBedJetV2Protocol) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1591952094:
                    if (str.equals("enterbl")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1388841729:
                    if (str.equals("customSetpoint")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1249319417:
                    if (str.equals("getsku")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1249318780:
                    if (str.equals("gettag")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1147648275:
                    if (str.equals("addstep")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1081733595:
                    if (str.equals("fantest")) {
                        c = 5;
                        break;
                    }
                    break;
                case -934938715:
                    if (str.equals("reboot")) {
                        c = 6;
                        break;
                    }
                    break;
                case -919801356:
                    if (str.equals("runseq")) {
                        c = 7;
                        break;
                    }
                    break;
                case -905768968:
                    if (str.equals("settag")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -868097371:
                    if (str.equals("v30ena")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -74354975:
                    if (str.equals("getname")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -74187998:
                    if (str.equals("getstep")) {
                        c = 11;
                        break;
                    }
                    break;
                case 98246176:
                    if (str.equals("getbl")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 336654127:
                    if (str.equals("loadmem")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 547820092:
                    if (str.equals("debugoff")) {
                        c = 14;
                        break;
                    }
                    break;
                case 790316786:
                    if (str.equals("clearseq")) {
                        c = 15;
                        break;
                    }
                    break;
                case 950394699:
                    if (str.equals("command")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1417161519:
                    if (str.equals("setalarm")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1541692274:
                    if (str.equals("debugon")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1719665988:
                    if (str.equals("getstatic")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1872828216:
                    if (str.equals("savemem")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1985744251:
                    if (str.equals("setmute")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1985754605:
                    if (str.equals("setname")) {
                        c = 22;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    fixChecksumAndSend(new byte[]{88, 1, 9, 0}, str);
                    return;
                case 1:
                    Log.d(TAG, String.format("Customtemp = %d semidegrees", Integer.valueOf(this.currentStatusV2.customSetpoint)));
                    fixChecksumAndSend(new byte[]{88, 2, 7, (byte) this.currentStatusV2.customSetpoint, 0}, str);
                    return;
                case 2:
                    fixChecksumAndSend(new byte[]{66, 1, 5, 0}, str);
                    return;
                case 3:
                    this.tagMatch = false;
                    fixChecksumAndSend(new byte[]{88, 3, 6, 3, 10, 0}, str);
                    return;
                case 4:
                    if (this.newSequenceMode) {
                        byte[] bArr = {88, 10, 5, (byte) (this.currentStepNum + 128), 7, (byte) this.currentStepV2.operatingMode, (byte) this.currentStepV2.currentFan, (byte) this.currentStepV2.remain_hour, (byte) this.currentStepV2.remain_minute, 0, (byte) this.currentStepV2.heat_setpoint, 0, 0};
                        Log.d(TAG, String.format("Stored Step: %d - M:%d,  F:%d. T:%02d:%02d:%02d H:%d", Integer.valueOf(this.currentStepNum + 1), Integer.valueOf(this.currentStepV2.operatingMode), Integer.valueOf(this.currentStepV2.currentFan), Integer.valueOf(this.currentStepV2.remain_hour), Integer.valueOf(this.currentStepV2.remain_minute), Integer.valueOf(this.currentStepV2.remain_sec), Integer.valueOf(this.currentStepV2.heat_setpoint)));
                        fixChecksumAndSend(bArr, str);
                        return;
                    } else {
                        byte[] bArr2 = {88, 9, 5, (byte) (this.currentStepNum + 128), 6, (byte) this.currentStepV2.operatingMode, (byte) this.currentStepV2.currentFan, (byte) this.currentStepV2.remain_hour, (byte) this.currentStepV2.remain_minute, 0, (byte) this.currentStepV2.heat_setpoint, 0};
                        Log.d(TAG, String.format("Stored Step: %d - M:%d,  F:%d. T:%02d:%02d:%02d H:%d", Integer.valueOf(this.currentStepNum + 1), Integer.valueOf(this.currentStepV2.operatingMode), Integer.valueOf(this.currentStepV2.currentFan), Integer.valueOf(this.currentStepV2.remain_hour), Integer.valueOf(this.currentStepV2.remain_minute), Integer.valueOf(this.currentStepV2.remain_sec), Integer.valueOf(this.currentStepV2.heat_setpoint)));
                        fixChecksumAndSend(bArr2, str);
                        return;
                    }
                case 5:
                    fixChecksumAndSend(new byte[]{88, 2, 32, (byte) this.currentStatusV2.fantestmode, 0}, str);
                    return;
                case 6:
                    fixChecksumAndSend(new byte[]{66, 1, 1, 0}, str);
                    return;
                case 7:
                    if (this.newSequenceMode) {
                        fixChecksumAndSend(new byte[]{88, 4, 13, (byte) i, (byte) i2, (byte) i3, 0}, str);
                        return;
                    } else {
                        fixChecksumAndSend(new byte[]{88, 1, 13, 0}, str);
                        return;
                    }
                case '\b':
                    int[] iArr = this.m_seqRandom;
                    fixChecksumAndSend(new byte[]{88, 13, 5, 3, 10, (byte) iArr[0], (byte) iArr[1], (byte) iArr[2], (byte) iArr[3], (byte) iArr[4], (byte) iArr[5], (byte) iArr[6], (byte) iArr[7], (byte) iArr[8], (byte) iArr[9], 0}, str);
                    return;
                case '\t':
                    fixChecksumAndSend(new byte[]{88, 4, 16, 69, 125, 0, 0}, str);
                    return;
                case '\n':
                    fixChecksumAndSend(new byte[]{88, 3, 6, 2, 16, 0}, str);
                    return;
                case 11:
                    fixChecksumAndSend(new byte[]{88, 3, 6, (byte) (this.currentStepNum + 128), 6, 0}, str);
                    return;
                case '\f':
                    fixChecksumAndSend(new byte[]{66, 1, 4, 0}, str);
                    return;
                case '\r':
                    Log.d(TAG, String.format("Loading from memory: %d", Byte.valueOf(this.timerPacket.usedMemory)));
                    fixChecksumAndSend(new byte[]{88, 2, 3, this.timerPacket.usedMemory, 0}, str);
                    return;
                case 14:
                    fixChecksumAndSend(new byte[]{88, 2, 10, 0, 0}, str);
                    return;
                case 15:
                    fixChecksumAndSend(new byte[]{88, 1, 12, 0}, str);
                    return;
                case 16:
                    if (this.currentStatusV2.ShutdownReason != 0) {
                        int i4 = this.currentStatusV2.ShutdownReason;
                        String format = String.format(Locale.ROOT, "Diagnostic Fault #%d", Integer.valueOf(i4));
                        switch (i4) {
                            case 1:
                                str2 = "Bad sensor data.  Please turn BedJet power off for 10 seconds and restart. If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 2:
                                str2 = "Delta tracking error or air flow blockage.  Please inspect your BedJet for any air flow blockages including ensuring a clean air filter, no items falling inside air hose (socks!) and no obvious blockages on air nozzle outlet.   Please turn BedJet power off for 10 seconds and restart.  If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 3:
                                str2 = "Fast thermal sensor error.  Please inspect your BedJet for any air flow blockages including ensuring a clean air filter, no items falling inside air hose (socks!) and no obvious blockages at air nozzle outlet.   Please turn BedJet power off for 10 seconds and restart. This error may occur when running BedJet at very low air flows on heat mode with heavy bedding, try increasing air flow to see if problem is resolved.  If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 4:
                                str2 = "Slow thermal sensor error.  Please inspect your BedJet for any air flow blockages including ensuring a clean air filter, no items falling inside air hose (socks!) and no obvious blockages at air nozzle outlet.   Please turn BedJet power off for 10 seconds and restart. This error may occur when running BedJet at very low air flows on heat mode with heavy bedding – try increasing air flow to see if problem is resolved.  If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 5:
                                str2 = "Motor RPM control error.  Please turn BedJet power off for 10 seconds and restart. If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 6:
                                str2 = "Thermal controller error. Please turn BedJet power off for 10 seconds and restart. If problem continues, please contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            case 7:
                                str2 = "Cool mode thermal controller error.  Please power off and power back on your BedJet to recover, as this may be an isolated error.  If error code occurs again repeatedly, then do not continue use, unplug your machine and contact BedJet technical support at info@bedjet.com.  All North American BedJets are covered by a comprehensive 2-year warranty – we will take good care of you!";
                                break;
                            default:
                                str2 = "Unknown BedJet diagnostic code.  The code generated by your BedJet is outside the range that this app has additional information on.  Please update the app to the most recent version and reconnect.  If this message recurs, please contact us at info@bedjet.com";
                                break;
                        }
                        new AlertDialog.Builder(this).setTitle(format).setMessage(str2).setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
                    }
                    Log.d(TAG, String.format("Sending command: %d", Byte.valueOf(this.buttonDataPacketV2.command)));
                    fixChecksumAndSend(new byte[]{88, 2, 1, this.buttonDataPacketV2.command, 0}, str);
                    return;
                case 17:
                    Log.d(TAG, String.format("Alarm set: Mem=%d,  Alarm Time = %02d:%02d, Current Time = %02d:%02d:%02d", Integer.valueOf(this.timerPacket.usedMemory), Integer.valueOf(this.timerPacket.alarmHour), Integer.valueOf(this.timerPacket.alarmMinute), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
                    fixChecksumAndSend(new byte[]{88, 7, 4, this.timerPacket.usedMemory, this.timerPacket.alarmHour, this.timerPacket.alarmMinute, (byte) i, (byte) i2, (byte) i3, 0}, str);
                    return;
                case 18:
                    fixChecksumAndSend(new byte[]{88, 2, 10, 1, 0}, str);
                    return;
                case 19:
                    fixChecksumAndSend(new byte[]{88, 1, 11, 0}, str);
                    return;
                case 20:
                    Log.d(TAG, String.format("Saving in memory: %d", Byte.valueOf(this.timerPacket.usedMemory)));
                    fixChecksumAndSend(new byte[]{88, 2, 2, this.timerPacket.usedMemory, 0}, str);
                    return;
                case 21:
                    fixChecksumAndSend(new byte[]{88, 2, 17, (byte) ((this.newmute ? 1 : 0) + (this.ledBlank ? 2 : 0)), 0}, str);
                    return;
                case 22:
                    byte[] bytes = (getBedjetName() + "                ").substring(0, 16).getBytes(Charset.forName("UTF-8"));
                    byte[] bArr3 = new byte[22];
                    bArr3[0] = 88;
                    bArr3[1] = 19;
                    bArr3[2] = 5;
                    bArr3[3] = 2;
                    bArr3[4] = 16;
                    bArr3[5] = 0;
                    bArr3[6] = 0;
                    bArr3[7] = 0;
                    bArr3[8] = 0;
                    bArr3[9] = 0;
                    bArr3[10] = 0;
                    bArr3[11] = 0;
                    bArr3[12] = 0;
                    bArr3[13] = 0;
                    bArr3[14] = 0;
                    bArr3[15] = 0;
                    bArr3[16] = 0;
                    bArr3[17] = 0;
                    bArr3[18] = 0;
                    bArr3[19] = 0;
                    bArr3[20] = 0;
                    bArr3[21] = 0;
                    for (int i5 = 0; i5 < 16; i5++) {
                        bArr3[i5 + 5] = bytes[i5];
                    }
                    fixChecksumAndSend(bArr3, str);
                    return;
                default:
                    fixChecksumAndSend(new byte[]{88, 7, 14, this.scenePacket.setupV2OperatingMode, (byte) (this.scenePacket.wind / 5), (byte) (this.scenePacket.temp + (this.scenePacket.isQuiet == 0 ? (byte) 0 : (byte) 128)), this.scenePacket.timerHour, this.scenePacket.timerMinute, this.scenePacket.timerSecond, 0}, str);
                    return;
            }
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1388841729:
                if (str.equals("customSetpoint")) {
                    c2 = 0;
                    break;
                }
                break;
            case 92899669:
                if (str.equals("alerm")) {
                    c2 = 1;
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    c2 = 2;
                    break;
                }
                break;
            case 950394699:
                if (str.equals("command")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.v2Manager.getValue().sendMessageHandle(new byte[]{4, (byte) this.newtemp, 0, 0, 0, 0, 10}, 4, str, this.buttonDataPacketV2);
                return;
            case 1:
                if (this.alarmOn) {
                    return;
                }
                this.v2Manager.getValue().sendMessageHandle(new byte[]{this.timerPacket.START, this.timerPacket.usedMemory, this.timerPacket.alarmHour, this.timerPacket.alarmMinute, this.timerPacket.hour, this.timerPacket.minute, this.timerPacket.second, this.timerPacket.constValue}, 3, str, this.buttonDataPacketV2);
                return;
            case 2:
                this.v2Manager.getValue().sendMessageHandle(new byte[]{5, this.buttonDataPacketV2.command, this.buttonDataPacketV2.model, (byte) i, (byte) i2, (byte) i3, this.buttonDataPacketV2.constValue}, 2, str, this.buttonDataPacketV2);
                return;
            case 3:
                this.v2Manager.getValue().sendMessageHandle(new byte[]{this.buttonDataPacketV2.START, this.buttonDataPacketV2.command, this.buttonDataPacketV2.model, (byte) i, (byte) i2, (byte) i3, this.buttonDataPacketV2.constValue}, 1, str, this.buttonDataPacketV2);
                return;
            default:
                this.v2Manager.getValue().sendMessageHandle(new byte[]{this.scenePacket.START, this.scenePacket.setupV2OperatingMode, this.scenePacket.temp, this.scenePacket.wind, this.scenePacket.timerHour, this.scenePacket.timerMinute, this.scenePacket.timerSecond, this.scenePacket.alarmHour, this.scenePacket.alarmMinute, this.scenePacket.isAlarm, this.scenePacket.isQuiet, this.scenePacket.constValue}, 5, str, this.buttonDataPacketV2);
                return;
        }
    }

    void fixChecksumAndSend(byte[] bArr, String str) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length - 1; i2++) {
            i += bArr[i2];
        }
        bArr[bArr.length - 1] = (byte) ((i & 255) ^ 255);
        this.v2Manager.getValue().sendMessageHandle(bArr, 6, str, this.buttonDataPacketV2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerBondReceiver(BluetoothDevice bluetoothDevice) {
        registerReceiver(new BondBroadcastReceiver(bluetoothDevice, this.v2Manager.getValue().getLinkDetectedHandler(), new BondBroadcastReceiver.BondBroadcastReceiverListener() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda0
            @Override // com.bedjet.bedjet.ui.main.v2.BondBroadcastReceiver.BondBroadcastReceiverListener
            public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
                MainActivity.this.unregisterReceiver(broadcastReceiver);
            }
        }), new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
    }

    void checkDebug(byte[] bArr) {
        if (bArr.length == 22 && bArr[0] == 5 && bArr[21] == 10) {
            sendData("debugoff");
            Log.d(TAG, "Got debug packet in non-debug mode.  Disabling debug");
        }
    }

    void checkHomeBedJetV1(byte[] bArr) {
        LoggerKt.log("MainActivity.checkHomeBedJetV1, data = " + Arrays.toString(bArr) + ",  hexDump: " + LoggerKt.hexDump(bArr));
        if (bArr.length == 17 && bArr[0] == 4 && bArr[16] == 10) {
            this.inBootloader = false;
            this.useBedJetV2Protocol = false;
            this.currentStatusV2.operatingMode = bArr[1];
            this.currentStatusV2.currentTemp = bArr[2];
            this.currentStatusV2.fanSpeed = (bArr[3] / 5) - 1;
            this.currentStatusV2.timerHour = bArr[4];
            this.currentStatusV2.timerMinute = bArr[5];
            this.currentStatusV2.timerSecond = bArr[6];
            this.currentStatusV2.alarmHour = bArr[7];
            this.currentStatusV2.alarmMinute = bArr[8];
            this.currentStatusV2.alarmMemoryNumber = bArr[9];
            this.currentStatusV2.muteFlag = bArr[10];
            this.currentStatusV2.ShutdownReason = bArr[11];
            this.currentStatusV2.firmware_ver = bArr[13];
            this.currentStatusV2.customSetpoint = bArr[15];
            this.currentStatusV2.dualzone = bArr[14] == 1;
            if (this.alarmOn) {
                this.currentStatusV2.alarmHour = 0;
                this.currentStatusV2.alarmMinute = 1;
            } else {
                this.currentStatusV2.alarmHour = 1;
                this.currentStatusV2.alarmMinute = 0;
            }
            if (!this.storedDeviceManager.getValue().getBondedFlag(0)) {
                this.pairBedJetManager.linkBedjet(this.currentStatusV2.dualzone, false);
                return;
            }
            BaseFragment currentFragment = getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.renderNormal(this.currentStatusV2);
            }
        }
    }

    void decodeBootloader(byte[] bArr) {
        if (bArr.length >= 4 && bArr[1] + 3 == bArr.length) {
            int i = 0;
            for (int i2 = 0; i2 < bArr.length - 1; i2++) {
                i += bArr[i2];
            }
            if (((i ^ 255) & 255) != (bArr[bArr.length - 1] & 255)) {
                return;
            }
            this.inBootloader = true;
            if (bArr[2] == -126 && bArr[3] == ((byte) this.flashtag) && this.flashstate == FlashStates.ERASING) {
                this.flashstate = FlashStates.f122OK;
                stopFlashTimer();
            }
            if (bArr[2] == 66 && bArr[3] == ((byte) this.flashtag) && this.flashstate == FlashStates.ERASING) {
                this.flashstate = FlashStates.FAILED;
                stopFlashTimer();
            }
            if (bArr[2] == -125 && bArr[3] == ((byte) this.flashtag) && this.flashstate == FlashStates.FLASHING) {
                this.flashstate = FlashStates.f122OK;
                stopFlashTimer();
            }
            if (bArr[2] == 67 && bArr[3] == ((byte) this.flashtag) && this.flashstate == FlashStates.FLASHING) {
                this.flashstate = FlashStates.FAILED;
                stopFlashTimer();
            }
            byte b = bArr[2];
            if (b == -124 || b == -123 || b == -122) {
                Log.d("BJUP", "Returned " + Integer.toHexString(bArr[2]) + new String(bArr));
            }
            if (bArr[2] == -123 && this.flashstate == FlashStates.READSKU) {
                stopFlashTimer();
                this.SKUFromBootloader = new String(bArr).subSequence(3, 9).toString();
                this.flashstate = FlashStates.f122OK;
                Log.d(TAG, String.format("Bootloader SKU = %s", this.SKUFromBootloader));
            }
            if (bArr[2] == -124 && this.flashstate == FlashStates.READBL) {
                stopFlashTimer();
                this.SKUFromBootloader = new String(bArr).subSequence(3, 7).toString();
                this.flashstate = FlashStates.f122OK;
                Log.d(TAG, String.format("Bootloader Version = %s", this.SKUFromBootloader));
            }
            if (bArr[2] == Byte.MIN_VALUE && this.flashstate == FlashStates.ENTERBL) {
                this.flashstate = FlashStates.f122OK;
                stopFlashTimer();
            }
        }
    }

    void decodeStatic(byte[] bArr) {
        Log.d(TAG, "Got static data packet");
        this.currentStatusV2.protocol_ver = bArr[3];
        this.currentStatusV2.firmware_ver = bArr[4];
        this.currentStatusV2.build_flags = bArr[5];
        if ((bArr[10] & 1) != 0) {
            if (this.currentStatusV2.firmware_ver >= 53) {
                Log.d(TAG, "Using new sequence mode");
                this.newSequenceMode = true;
            } else {
                Log.d(TAG, "Using old sequence mode");
                this.newSequenceMode = false;
            }
        }
        this.gotStatic = true;
    }

    void checkVetData(byte[] bArr) {
        String str = "MainActivity.checkVetData, data = " + Arrays.toString(bArr) + ",  hexDump: " + LoggerKt.hexDump(bArr);
        LoggerKt.log(str);
        if (bArr.length == 17 && bArr[16] == 10) {
            this.inBootloader = false;
            this.v2Manager.getValue().cancelReconnectTimer(0);
            this.v2Manager.getValue().shutdownClient(4);
            FirebaseCrashlytics.getInstance().recordException(new FirebaseException(str));
            this.customDialog.getValue().showIncompatibleDialog(this);
        }
    }

    void checkNewFormat(byte[] bArr) {
        byte b;
        if (bArr.length >= 4 && (b = bArr[1]) != 0 && b == bArr.length - 3) {
            int i = 0;
            for (int i2 = 0; i2 < bArr.length - 1; i2++) {
                i += bArr[i2];
            }
            if (((i & 255) ^ 255) != (bArr[bArr.length - 1] & 255)) {
                return;
            }
            this.inBootloader = false;
            byte b2 = bArr[2];
            if (b2 == 1) {
                decodeStatic(bArr);
                return;
            }
            if (b2 == 2) {
                decodeHomeV2(bArr);
                return;
            }
            if (b2 == 3) {
                decodeVet(bArr);
                return;
            }
            if (b2 == 4) {
                decodeDebug(bArr);
            } else if (b2 == 5) {
                decodeParam(bArr);
            } else {
                Log.d(TAG, String.format("Bad packet type 0x%02x received.", Byte.valueOf(b2)));
            }
        }
    }

    void decodeHomeV2(byte[] bArr) {
        String str;
        this.useBedJetV2Protocol = true;
        this.cool12h = true;
        this.currentStatusV2.currentTemp = bArr[3] & Byte.MAX_VALUE;
        this.currentStatusV2.ledBlank = bArr[3] & 128;
        this.currentStatusV2.timerHour = (bArr[5] >> 4) & 15;
        this.currentStatusV2.timerMinute = ((bArr[5] << 2) & 60) | ((bArr[6] >> 6) & 3);
        this.currentStatusV2.timerSecond = bArr[6] & 63;
        this.currentStatusV2.operatingMode = (bArr[4] >> 5) & 7;
        this.currentStatusV2.fanSpeed = (bArr[4] & Ascii.f210US) - 1;
        this.currentStatusV2.customSetpoint = bArr[7] & Byte.MAX_VALUE;
        if (this.tempModeManager.getValue().getUseCelsius() && this.currentStatusV2.customSetpoint < 45) {
            this.currentStatusV2.customSetpoint = 45;
        }
        this.currentStatusV2.dualzone = (bArr[7] & 128) != 0;
        this.currentStatusV2.alarmHour = bArr[8] & Ascii.f210US;
        this.currentStatusV2.alarmMinute = bArr[9] & 63;
        this.timerPacket.alarmHour = (byte) this.currentStatusV2.alarmHour;
        this.timerPacket.alarmMinute = (byte) this.currentStatusV2.alarmMinute;
        this.timerPacket.usedMemory = (byte) ((bArr[9] >> 6) & 3);
        this.currentStatusV2.alarmMemoryNumber = this.timerPacket.usedMemory != 0 ? 1 : 0;
        this.currentStatusV2.muteFlag = (bArr[8] & 128) != 0 ? 1 : 0;
        this.currentStatusV2.currentStep = (bArr[10] >> 3) & 31;
        if (bArr[1] > 10) {
            this.currentStatusV2.ShutdownReason = bArr[12];
        } else {
            this.currentStatusV2.ShutdownReason = 0;
        }
        if (!this.storedDeviceManager.getValue().getBondedFlag(0)) {
            this.pairBedJetManager.linkBedjet(this.currentStatusV2.dualzone, false);
            return;
        }
        if (!this.gotStatic) {
            sendData("getstatic");
        } else if (!this.v2Manager.getValue().getNameReceived()) {
            sendData("getname");
        } else if (!this.gotTag) {
            if (this.currentStatusV2.currentStep == 0) {
                this.gotTag = true;
                this.tagDone = true;
            } else {
                this.tagDone = false;
                sendData("gettag");
            }
        }
        if (this.gotTag && !this.tagDone) {
            this.tagDone = true;
            if (!this.tagMatch) {
                new AlertDialog.Builder(this).setTitle("Sequence mismatch").setMessage("The BedJet to which you have connected is running a sequence that differs from the one stored in the app memory.  Learning functions are disabled and editing of the sequence will not be possible until the currently running sequence ends or is terminated.").setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
            }
        }
        if (this.justConnected) {
            this.justConnected = false;
            if ((bArr[7] & 128) != 0) {
                str = "Low power";
            } else {
                str = "High power";
            }
            Toast.makeText(this, String.format(Locale.ROOT, "Dual Zone: %s", str), 1).show();
            byte orNull = ext.getOrNull(bArr, 13);
            this.cool12h = orNull >= 35;
            if (orNull == 34 && ext.getOrNull(bArr, 15) != 0) {
                this.fix22_savedtemp = 0;
                this.fix22_waitcool = false;
                this.fix22_wascool = false;
            }
        }
        BaseFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.renderNormal(this.currentStatusV2);
        }
    }

    public RunningStatusV2 getV2Status() {
        return this.currentStatusV2;
    }

    private void armCommsTimer() {
        Timer timer = this.commsTimeout;
        if (timer != null) {
            timer.cancel();
            this.commsTimeout = null;
        }
        this.commsTimeout = new Timer();
        this.commsTimeout.schedule(new C06376(), 5000L);
    }

    /* renamed from: com.bedjet.bedjet.ui.main.MainActivity$6 */
    /* loaded from: classes.dex */
    class C06376 extends TimerTask {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$run$0() {
        }

        C06376() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.main.MainActivity$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.C06376.lambda$run$0();
                }
            });
            MainActivity.this.commsTimeout.cancel();
            MainActivity.this.commsTimeout = null;
        }
    }

    void decodeVet(byte[] bArr) {
        String str = "MainActivity.decodeVet, data = " + Arrays.toString(bArr) + ",  hexDump: " + LoggerKt.hexDump(bArr);
        LoggerKt.log(str);
        this.v2Manager.getValue().cancelReconnectTimer(1);
        this.v2Manager.getValue().shutdownClient(5);
        FirebaseCrashlytics.getInstance().recordException(new FirebaseException(str));
        this.customDialog.getValue().showIncompatibleDialog(this);
    }

    void decodeDebug(byte[] bArr) {
        sendData("debugoff");
        Log.d(TAG, "Got debug packet in non-debug mode.  Disabling debug");
    }

    void decodeParam(byte[] bArr) {
        byte b = bArr[3];
        if (b == 3) {
            byte b2 = bArr[1];
            return;
        }
        if (b == 2 && bArr[1] == 2) {
            Log.d(TAG, "Got <null> name response");
            this.v2Manager.getValue().setNameReceived(true);
            this.mBedjetName = "Unset";
            updateDeviceName("Unset");
        }
        if (bArr[1] <= 2 || (bArr[3] & 255) != 2) {
            return;
        }
        String trim = new String(Arrays.copyOfRange(bArr, 4, bArr.length - 1)).trim();
        this.v2Manager.getValue().setNameReceived(true);
        this.mBedjetName = trim;
        updateDeviceName(trim);
        Log.d(TAG, "Got name response");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFlashTimer(int i, FlashStates flashStates) {
        stopFlashTimer();
        this.flashtag = i;
        this.flashstate = flashStates;
        this.flashTimer = new Timer();
        this.flashTimer.schedule(new TimerTask() { // from class: com.bedjet.bedjet.ui.main.MainActivity.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MainActivity.this.flashstate == FlashStates.ERASING || MainActivity.this.flashstate == FlashStates.FLASHING || MainActivity.this.flashstate == FlashStates.ENTERBL || MainActivity.this.flashstate == FlashStates.READSKU || MainActivity.this.flashstate == FlashStates.REBOOT || MainActivity.this.flashstate == FlashStates.READBL) {
                    MainActivity.this.flashstate = FlashStates.TIMEOUT;
                }
                MainActivity.this.stopFlashTimer();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopFlashTimer() {
        Timer timer = this.flashTimer;
        if (timer != null) {
            timer.cancel();
            this.flashTimer = null;
        }
    }

    public void disconnectDevice(int i) {
        LoggerKt.logTag(TAG, ".disconnectDevice, path = " + i);
        this.isDisconnected = true;
        if (this.connectionStateManager.getValue().getConnectStateBt() != ConnectionState.DISCONNECTED) {
            btClose();
        }
        this.v2Manager.getValue().disconnectDevice();
    }

    public void connectDevice(DeviceRecord deviceRecord) {
        disconnectDevice(1);
        if (deviceRecord == null) {
            LoggerKt.log("MainActivity.connectDevice - deviceRecord is null, unable to connect");
        } else if (deviceRecord.isV2device()) {
            disconnectGatt();
            this.v2Manager.getValue().connectClassic(deviceRecord.getDeviceAddress());
        } else {
            this.v2Manager.getValue().shutdownClient(6);
            connectGatt(deviceRecord.getDeviceAddress());
        }
    }

    private boolean connectGatt(String str) {
        if (this.mBluetoothAdapter == null || str == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        if (this.connectionStateManager.getValue().getConnectStateBt() != ConnectionState.DISCONNECTED) {
            Log.d(TAG, "Attempt to connect when in connect state");
            return false;
        }
        String str2 = this.mBluetoothDeviceAddress;
        if (str2 != null && str.equals(str2) && this.mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (!this.mBluetoothGatt.connect()) {
                return false;
            }
            this.connectionStateManager.getValue().setConnectionState(ConnectionState.GATT_CONNECT);
            return true;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        this.mBluetoothDeviceAddress = str;
        this.mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        this.connectionStateManager.getValue().setConnectionState(ConnectionState.GATT_CONNECT);
        Log.d(TAG, "Trying to create a new connection.");
        return true;
    }

    public void disconnectGatt() {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.disconnect();
        }
    }

    public void btClose() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.connectionStateManager.getValue().setConnectionState(ConnectionState.DISCONNECTED);
        this.mBluetoothGatt = null;
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public void setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(CLIENT_CHARACTERISTIC_CONFIG));
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.writeDescriptor(descriptor);
        }
    }

    public void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            showConnectionFragment(4);
        } else {
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public boolean writeCharacteristicBlocking(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothGatt == null) {
            showConnectionFragment(5);
            return false;
        }
        int i = 0;
        do {
            i++;
            if (i > 5) {
                return false;
            }
            this.writeComplete = new CountDownLatch(1);
            this.writeChar = bluetoothGattCharacteristic;
            this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                this.writeComplete.await(100L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return false;
            }
        } while (this.writeComplete.getCount() != 0);
        return true;
    }

    public boolean readCharacteristicBlocking(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Log.d(TAG, "Blocking read for UUID" + bluetoothGattCharacteristic.getUuid().toString());
        int i = 0;
        do {
            i++;
            if (i > 3) {
                Log.d(TAG, "Timed out " + bluetoothGattCharacteristic.getUuid().toString());
                return false;
            }
            this.readComplete = new CountDownLatch(1);
            this.readChar = bluetoothGattCharacteristic;
            this.mBluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
            try {
                this.readComplete.await(1L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                Log.d(TAG, "Interrupted " + bluetoothGattCharacteristic.getUuid().toString());
                return false;
            }
        } while (this.readComplete.getCount() != 0);
        Log.d(TAG, "Succeeded " + bluetoothGattCharacteristic.getUuid().toString());
        return true;
    }

    public void writeSSID(String str) {
        this.mBedJetSsidCharacteristic.setValue(str);
        writeCharacteristicBlocking(this.mBedJetSsidCharacteristic);
    }

    public void writePassword(String str) {
        this.mBedJetPasswdCharacteristic.setValue(str);
        writeCharacteristicBlocking(this.mBedJetPasswdCharacteristic);
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void showBackButton() {
        this.binding.mainBack.setVisibility(0);
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void hideBackButton() {
        this.binding.mainBack.setVisibility(8);
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void setConnectedDevice(String str) {
        this.binding.mainConnectedDevice.setText(getString(C0624R.string.connected_device, new Object[]{str}));
    }

    @Override // com.bedjet.bedjet.arch.FragmentController
    public void showSystemUI() {
        getWindow().clearFlags(1024);
    }

    public void gotNewName(RenameType renameType, String str) {
        int length = str.length();
        Integer valueOf = Integer.valueOf(length);
        valueOf.getClass();
        if (length > 15) {
            valueOf = 15;
        }
        String substring = str.substring(0, valueOf.intValue());
        Log.d(TAG, "New string is " + substring);
        Log.d(TAG, "RenameType is " + renameType);
        int i = C06409.$SwitchMap$com$bedjet$bedjet$ui$main$RenameType[renameType.ordinal()];
        if (i == 1 || i == 2) {
            this.mBedjetName = substring;
        } else if (i == 3) {
            this.mMemoryName1 = substring;
        } else if (i == 4) {
            this.mMemoryName2 = substring;
        } else if (i == 5) {
            this.mMemoryName3 = substring;
        }
        if (renameType == RenameType.f123V2 || renameType == RenameType.f124V3) {
            setConnectedDevice(substring);
            updateDeviceName(substring);
        }
        if (getCurrentFragment() != null) {
            getCurrentFragment().nameSet(renameType, substring);
        }
        if (renameType == RenameType.f123V2) {
            sendData("setname");
        } else {
            setBedJetParam(renameType, substring);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bedjet.bedjet.ui.main.MainActivity$9 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C06409 {
        static final /* synthetic */ int[] $SwitchMap$com$bedjet$bedjet$ui$main$DeviceType;
        static final /* synthetic */ int[] $SwitchMap$com$bedjet$bedjet$ui$main$RenameType;

        static {
            int[] iArr = new int[RenameType.values().length];
            $SwitchMap$com$bedjet$bedjet$ui$main$RenameType = iArr;
            try {
                iArr[RenameType.f123V2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.f124V3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.BIORHYTHM1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.BIORHYTHM2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.BIORHYTHM3.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[DeviceType.values().length];
            $SwitchMap$com$bedjet$bedjet$ui$main$DeviceType = iArr2;
            try {
                iArr2[DeviceType.BEDFRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$DeviceType[DeviceType.BEDJET2.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$DeviceType[DeviceType.BEDJET3.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LoggerKt.logTag(TAG, ".onPause");
        disconnectDevice(2);
        super.onPause();
    }

    public void setBedJetParam(RenameType renameType, String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[19];
        int length = bytes.length;
        if (length > 15) {
            length = 15;
        }
        for (int i = 0; i < 19; i++) {
            bArr[i] = 0;
        }
        bArr[0] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[1] = (byte) renameType.getParam();
        bArr[2] = 16;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2 + 3] = bytes[i2];
        }
        sendBedjetCommand(bArr);
    }

    public void showRenameMenu(RenameType renameType) {
        showRenameMenu(renameType, "");
    }

    public void showRenameMenu(final RenameType renameType, String str) {
        switch (C06409.$SwitchMap$com$bedjet$bedjet$ui$main$RenameType[renameType.ordinal()]) {
            case 1:
            case 2:
                str = this.mBedjetName;
                break;
            case 3:
                str = this.mMemoryName1;
                if (str.equals("M1 EMPTY")) {
                    str = "M1";
                    break;
                }
                break;
            case 4:
                str = this.mMemoryName2;
                if (str.equals("M2 EMPTY")) {
                    str = "M2";
                    break;
                }
                break;
            case 5:
                str = this.mMemoryName3;
                if (str.equals("M3 EMPTY")) {
                    str = "M3";
                    break;
                }
                break;
            case 6:
            case 7:
            case 8:
                break;
            default:
                str = null;
                break;
        }
        this.customDialog.getValue().showRenameMenu(this, renameType, str, new Function1() { // from class: com.bedjet.bedjet.ui.main.MainActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$showRenameMenu$5;
                lambda$showRenameMenu$5 = MainActivity.this.lambda$showRenameMenu$5(renameType, (String) obj);
                return lambda$showRenameMenu$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showRenameMenu$5(RenameType renameType, String str) {
        gotNewName(renameType, str);
        return Unit.INSTANCE;
    }

    public void onBack() {
        onBackPressed();
    }

    public void onMenuPressed() {
        showMenuFragment();
    }

    private void updateDeviceName(String str) {
        BaseFragment currentFragment;
        this.storedDeviceManager.getValue().updateDeviceName(str);
        boolean isNotResumed = MainActivityExt.isNotResumed(this);
        LoggerKt.logTag(TAG, ".updateDeviceName newName: " + str + ", notResumed: " + isNotResumed);
        if (isNotResumed || (currentFragment = getCurrentFragment()) == null) {
            return;
        }
        currentFragment.deviceNameRead(str);
    }

    public CurrentStatus getCurrentStatus() {
        return this.currentStatus;
    }

    private void adjustFontScale(Configuration configuration) {
        float f = configuration.fontScale;
        this.firebaseTracker.getValue().setUserFontScale(configuration.fontScale);
        if (f <= 1.0f) {
            return;
        }
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        LoggerKt.logTag(TAG, ".onResume");
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        LoggerKt.logTag(TAG, ".onDestroy");
        this.customDialog.getValue().onDestroy();
        super.onDestroy();
    }

    public void setupInitialV3(String str, boolean z, boolean z2, boolean z3) {
        LoggerKt.logTag(TAG, ".setupInitialV3 name = " + str + ", sounds = " + z + ", lights = " + z2 + ", lowPower = " + z3);
        V3SetupKt.setupInitialV3(str, z, z2, z3, new C06398());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bedjet.bedjet.ui.main.MainActivity$8 */
    /* loaded from: classes.dex */
    public class C06398 implements V3SetupListener {
        C06398() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendName$0(String str) {
            MainActivity.this.gotNewName(RenameType.f124V3, str);
        }

        @Override // com.bedjet.bedjet.p001ui.main.p003v3.V3SetupListener
        public void sendName(final String str) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.main.MainActivity$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.C06398.this.lambda$sendName$0(str);
                }
            });
        }

        @Override // com.bedjet.bedjet.p001ui.main.p003v3.V3SetupListener
        public void senButtonCommand(int i) {
            MainActivity.this.sendBedJetButton(i);
        }

        @Override // com.bedjet.bedjet.p001ui.main.p003v3.V3SetupListener
        public void sendClock(int i, int i2) {
            MainActivity.this.sendBedJetClock(i, i2);
        }

        @Override // com.bedjet.bedjet.p001ui.main.p003v3.V3SetupListener
        public void finished() {
            BaseFragment currentFragment = MainActivity.this.getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.setupV3Finished();
            }
        }
    }
}
