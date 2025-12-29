package com.bedjet.bedjet.p001ui.wifi;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.CurrentStatus;
import com.bedjet.bedjet.databinding.FragmentWifiBinding;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class WifiFragment extends BaseFragment<FragmentWifiBinding> {
    private static final String WIFI_PASSWORD_PREFS = "WifiPassword";
    private static final String WIFI_SSID_AUTO = "WiFiAuto";
    private static final String WIFI_SSID_AUTO_PREFS = "WifiSSIDAuto";
    private static final String WIFI_SSID_MANUAL_PREFS = "WifiSSIDManual";
    static final int endConditionStart = 20;
    private MainActivity mActivity;
    private EditText mApPasswordET;
    private EditText mApSsidET;
    private TextView mApSsidTV;
    private CheckBox mAutoSSIDCB;
    private Button mConfirmBtn;
    private CurrentStatus mCurrentStatus;
    private TextView mMessageTV;
    private SharedPreferences mPrefs;
    private final BroadcastReceiver mReceiver;
    private boolean mReceiverRegistered;
    private String mSavedPassword;
    private String mSavedSSIDAuto;
    private String mSavedSSIDManual;
    private boolean mSsidAuto;
    private AppCompatTextView mStatusHistoryTV;
    private Context myContext;
    private AlertDialog passwordDialog;
    private int update_phase;
    private Boolean wait_for_finish;
    private Boolean wait_for_start;
    static final String[] phaseNames = {"Idle", "Starting", "Connecting to AP", "Got IP address", "Checking connection", "Checking for update", "Updating", "Restarting BedJet", "Some other status"};
    static final String[] endConditionNames = {"No WiFi Config", "Unable to connect", "DHCP failure", "Unable to contact server", "Connection test OK", "Connection test failed", "No update needed", "Radio is disabled!", "Restarting BedJet", "Update failed", "Some other error"};

    public WifiFragment() {
        super(C0624R.layout.fragment_wifi);
        this.mReceiverRegistered = false;
        this.mReceiver = new BroadcastReceiver() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                WifiInfo connectionInfo;
                String action = intent.getAction();
                if (action == null) {
                    return;
                }
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if ("android.net.wifi.STATE_CHANGE".equals(action)) {
                    if (intent.hasExtra("wifiInfo")) {
                        connectionInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
                    } else {
                        connectionInfo = wifiManager.getConnectionInfo();
                    }
                    WifiFragment.this.onWifiChanged(connectionInfo);
                    return;
                }
                if ("android.location.PROVIDERS_CHANGED".equals(action)) {
                    WifiFragment.this.onWifiChanged(wifiManager.getConnectionInfo());
                    WifiFragment.this.onLocationChanged();
                }
            }
        };
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.myContext);
        this.mPrefs = defaultSharedPreferences;
        this.mSavedSSIDAuto = defaultSharedPreferences.getString(WIFI_SSID_AUTO_PREFS, "");
        this.mSavedSSIDManual = this.mPrefs.getString(WIFI_SSID_MANUAL_PREFS, "");
        this.mSavedPassword = this.mPrefs.getString(WIFI_PASSWORD_PREFS, "");
        this.mSsidAuto = this.mPrefs.getBoolean(WIFI_SSID_AUTO, true);
        this.mApSsidTV = (TextView) getMainActivity().findViewById(C0624R.id.ap_ssid_text);
        this.mApSsidET = (EditText) getMainActivity().findViewById(C0624R.id.ap_ssid_edit);
        this.mApPasswordET = (EditText) getMainActivity().findViewById(C0624R.id.ap_password_edit);
        this.mMessageTV = (TextView) getMainActivity().findViewById(C0624R.id.status_string);
        this.mConfirmBtn = (Button) getMainActivity().findViewById(C0624R.id.btn_setwifi);
        Button button = (Button) getMainActivity().findViewById(C0624R.id.btn_cancel_setup);
        this.mConfirmBtn.setEnabled(false);
        this.mAutoSSIDCB = (CheckBox) getMainActivity().findViewById(C0624R.id.cb_autoset);
        this.mStatusHistoryTV = (AppCompatTextView) getMainActivity().findViewById(C0624R.id.statusHistory);
        MainActivity mainActivity = getMainActivity();
        this.mActivity = mainActivity;
        this.mCurrentStatus = mainActivity.getCurrentStatus();
        this.wait_for_start = false;
        this.wait_for_finish = false;
        getBinding().btnSetwifi.setText(C0624R.string.connect_wifi);
        getBinding().btnGoback.setVisibility(this.mActivity.getNeedUpdate() ? 4 : 0);
        getBinding().btnCancelSetup.setVisibility(this.mActivity.getNeedUpdate() ? 4 : 0);
        this.mApSsidET.setText(this.mSavedSSIDManual);
        setAutoManualSSID(this.mSsidAuto);
        this.mAutoSSIDCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda11
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WifiFragment.this.lambda$onViewCreated$0(compoundButton, z);
            }
        });
        this.mActivity.cancelReadRetry();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WifiFragment.this.lambda$onViewCreated$2(view2);
            }
        });
        this.mConfirmBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WifiFragment.this.lambda$onViewCreated$3(view2);
            }
        });
        getMainActivity().findViewById(C0624R.id.btn_goback).setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WifiFragment.this.lambda$onViewCreated$4(view2);
            }
        });
        new Thread(new Runnable() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WifiFragment.this.lambda$onViewCreated$5();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(CompoundButton compoundButton, boolean z) {
        this.mSsidAuto = z;
        setAutoManualSSID(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        new AlertDialog.Builder(this.myContext, C0624R.style.AppDialog).setTitle("Skip Setup").setMessage("Please confirm you want to skip WiFi setup.  Skipping this will prevent you from obtaining valuable firmware updates for your BedJet.  Skipping setup is not recommended.").setNeutralButton("Confirm", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiFragment.this.lambda$onViewCreated$1(dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(DialogInterface dialogInterface, int i) {
        getMainActivity().showConnectionFragment(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        if (this.mApPasswordET.getText().toString().length() < 8) {
            showPasswordAlert();
            return;
        }
        this.wait_for_start = false;
        this.wait_for_finish = false;
        showConnectProcess();
        this.mStatusHistoryTV.setText("");
        if (this.mSsidAuto) {
            getMainActivity().writeSSID(this.mApSsidTV.getText().toString());
        } else {
            getMainActivity().writeSSID(this.mApSsidET.getText().toString());
        }
        getMainActivity().writePassword(this.mApPasswordET.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(View view) {
        getMainActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5() {
        String str;
        int i = -1;
        while (true) {
            try {
                int i2 = this.update_phase;
                if (i2 == i) {
                    Thread.sleep(100L);
                } else {
                    if (this.wait_for_start.booleanValue() && i2 != 21 && i2 != 24) {
                        this.wait_for_start = false;
                        this.wait_for_finish = true;
                    }
                    if (this.wait_for_finish.booleanValue()) {
                        if (i2 == 21) {
                            getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WifiFragment.this.showConnectFail();
                                }
                            });
                            this.wait_for_finish = false;
                        }
                        if (i2 == 24) {
                            getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda8
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WifiFragment.this.showConnectOK();
                                }
                            });
                            this.wait_for_finish = false;
                        }
                    }
                    TextView textView = this.mMessageTV;
                    if (textView != null) {
                        if (i2 < 20) {
                            String[] strArr = phaseNames;
                            str = strArr[i2 >= strArr.length ? strArr.length - 1 : i2];
                        } else {
                            int i3 = i2 - 20;
                            String[] strArr2 = endConditionNames;
                            if (i3 > strArr2.length) {
                                i3 = strArr2.length - 1;
                            }
                            str = strArr2[i3];
                        }
                        updateUpdateProgress(textView, str);
                    }
                    i = i2;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    void setAutoManualSSID(boolean z) {
        this.mAutoSSIDCB.setChecked(z);
        this.mApSsidTV.setVisibility(z ? 0 : 8);
        this.mApSsidET.setVisibility(z ? 8 : 0);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    protected Integer getBindingVariable() {
        return 6;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().hideSystemUI();
        registerBroadcastReceiver();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getController().showSystemUI();
        unregisterBroadcastReceiver();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.myContext = context;
    }

    void updateUpdateProgress(final TextView textView, final String str) {
        getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                WifiFragment.this.lambda$updateUpdateProgress$6(textView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUpdateProgress$6(TextView textView, String str) {
        textView.setText(str);
        this.mStatusHistoryTV.append(str + "\n");
    }

    private void registerBroadcastReceiver() {
        getMainActivity().registerReceiver(this.mReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        this.mReceiverRegistered = true;
    }

    private void unregisterBroadcastReceiver() {
        if (this.mReceiverRegistered) {
            getMainActivity().unregisterReceiver(this.mReceiver);
            this.mReceiverRegistered = false;
        }
    }

    void saveWifiData() {
        this.mSavedSSIDAuto = this.mApSsidTV.getText().toString();
        this.mSavedSSIDManual = this.mApSsidET.getText().toString();
        this.mSavedPassword = this.mApPasswordET.getText().toString();
        this.mPrefs.edit().putString(WIFI_SSID_AUTO_PREFS, this.mSavedSSIDAuto).putString(WIFI_SSID_MANUAL_PREFS, this.mSavedSSIDManual).putString(WIFI_PASSWORD_PREFS, this.mSavedPassword).putBoolean(WIFI_SSID_AUTO, this.mSsidAuto).apply();
    }

    void showPasswordAlert() {
        new AlertDialog.Builder(this.myContext, C0624R.style.AppDialog).setTitle("Password length").setMessage("The minimum length of a WiFi passphrase is 8 characters.  Please check the password and retry.").setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWifiChanged(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            this.mApSsidTV.setText("");
            this.mApSsidTV.setTag(null);
            this.mMessageTV.setText("");
            this.mConfirmBtn.setEnabled(false);
            return;
        }
        String ssid = wifiInfo.getSSID();
        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        this.mApSsidTV.setText(ssid);
        this.mApSsidTV.setTag(ssid.getBytes());
        this.mApSsidTV.setTag(getOriginalSsidBytes(wifiInfo));
        this.mConfirmBtn.setEnabled(true);
        if (this.mSsidAuto) {
            if (!ssid.equals(this.mSavedSSIDAuto)) {
                this.mApPasswordET.setText("");
                return;
            } else {
                this.mApPasswordET.setText(this.mSavedPassword);
                return;
            }
        }
        this.mApPasswordET.setText(this.mSavedPassword);
    }

    public static byte[] getOriginalSsidBytes(WifiInfo wifiInfo) {
        try {
            Method method = wifiInfo.getClass().getMethod("getWifiSsid", null);
            method.setAccessible(true);
            Object invoke = method.invoke(wifiInfo, null);
            Method method2 = invoke.getClass().getMethod("getOctets", null);
            method2.setAccessible(true);
            return (byte[]) method2.invoke(invoke, null);
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationChanged() {
        LocationManager locationManager = (LocationManager) getMainActivity().getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (locationManager == null) {
            return;
        }
        locationManager.isProviderEnabled("gps");
        locationManager.isProviderEnabled("network");
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void updateDisplay() {
        LoggerKt.log("WifiFragment.updateDisplay called");
        this.update_phase = this.mCurrentStatus.getUpdatePhase();
    }

    void showConnectProcess() {
        AlertDialog create = new AlertDialog.Builder(this.myContext, C0624R.style.AppDialog).setTitle("Please Wait").setMessage("The values supplied have been written to the BedJet and a connection test is being run").setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiFragment.this.lambda$showConnectProcess$7(dialogInterface, i);
            }
        }).create();
        this.passwordDialog = create;
        create.show();
        this.wait_for_finish = false;
        this.wait_for_start = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConnectProcess$7(DialogInterface dialogInterface, int i) {
        this.passwordDialog.dismiss();
        this.passwordDialog = null;
    }

    void showConnectConfirm() {
        AlertDialog create = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("WiFi Setup").setMessage("Please re-confirm you have selected DONE on the remote control setup STEP 6.  App will return to Wifi Setup if you have not clicked DONE on the remote control setup STEP 6.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiFragment.this.lambda$showConnectConfirm$8(dialogInterface, i);
            }
        }).create();
        this.passwordDialog = create;
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConnectConfirm$8(DialogInterface dialogInterface, int i) {
        this.mActivity.disconnectDevice(4);
        getNavigator().showConnectionFragment(11);
        this.passwordDialog.dismiss();
        this.passwordDialog = null;
    }

    void showUpdateConfirm() {
        AlertDialog create = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("WiFi Setup").setMessage("Please re-confirm you have selected DONE on the remote control setup STEP 6 or manually initiated a firmware update from remote control menu.  App will return to Wifi Setup if you have not initiated firmware update.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiFragment.this.lambda$showUpdateConfirm$9(dialogInterface, i);
            }
        }).create();
        this.passwordDialog = create;
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdateConfirm$9(DialogInterface dialogInterface, int i) {
        this.mActivity.disconnectDevice(5);
        getNavigator().showConnectionFragment(12);
        this.passwordDialog.dismiss();
        this.passwordDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showConnectOK() {
        int i;
        if (this.mActivity.getNeedUpdate()) {
            i = C0624R.string.connect_ok2;
        } else if (this.mActivity.getNeedSetup()) {
            i = C0624R.string.connect_ok3;
        } else {
            i = C0624R.string.connect_ok1;
        }
        String string = getString(i);
        AlertDialog alertDialog = this.passwordDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.passwordDialog = null;
        }
        AlertDialog create = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("BedJet WiFi Setup Successful").setMessage(string).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                WifiFragment.this.lambda$showConnectOK$10(dialogInterface, i2);
            }
        }).create();
        this.passwordDialog = create;
        create.show();
        saveWifiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConnectOK$10(DialogInterface dialogInterface, int i) {
        this.passwordDialog.dismiss();
        if (getMainActivity().getNeedUpdate()) {
            showUpdateConfirm();
            return;
        }
        if (getMainActivity().getNeedSetup()) {
            showConnectConfirm();
            return;
        }
        this.mActivity.disconnectDevice(6);
        getNavigator().showConnectionFragment(13);
        this.passwordDialog.dismiss();
        this.passwordDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showConnectFail() {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Connection Failed").setMessage("Connection unsuccessful.  Password not correct or WiFi network is not a 2.4GHz network.  Make sure this device is connected to a 2.4GHz WiFi network.  BedJet 3 cannot connect to 5GHz WiFi networks, 5GHz network names will commonly end in '-5'").setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WifiFragment.this.lambda$showConnectFail$11(dialogInterface, i);
            }
        });
        AlertDialog alertDialog = this.passwordDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.passwordDialog = null;
        }
        AlertDialog create = positiveButton.create();
        this.passwordDialog = create;
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConnectFail$11(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.passwordDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.passwordDialog = null;
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void gattDisconnected() {
        if (getMainActivity().getNeedSetup()) {
            return;
        }
        this.mActivity.showConnectionFragment(14);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        getNavigator().showPromptFragment(PromptType.PROMPT_WIFI);
        return false;
    }
}
