package com.bedjet.bedjet.p001ui.mainscreen;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.Constants;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.CurrentStatus;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentSettingsBinding;
import com.bedjet.bedjet.p000di.TempModeManager;
import com.bedjet.bedjet.p001ui.custom.picker.PickerDialog;
import com.bedjet.bedjet.p001ui.custom.picker.PickerListener;
import com.bedjet.bedjet.p001ui.custom.seekArc.SeekArc;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.RenameType;
import com.bedjet.bedjet.utils.FirebaseException;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.FunctionName;
import com.bedjet.bedjet.utils.Logger;
import com.bedjet.bedjet.utils.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Locale;
import kotlin.Lazy;
import org.koin.java.KoinJavaComponent;

/* loaded from: classes.dex */
public class MainFragment extends BaseFragment<FragmentSettingsBinding> {
    private final Lazy<FirebaseTracker> firebaseTracker;
    private int lastNotified;
    private CurrentStatus mCurrentStatus;
    private CurrentStatus mPreviousStatus;
    private Button mSelectedButton;
    private Dialog memDialog;
    private boolean showingNotification;
    private final Lazy<StoredDeviceManager> storedDeviceManager;
    private final Lazy<TempModeManager> tempModeManager;
    private boolean wasPaused;

    public MainFragment() {
        super(C0624R.layout.fragment_settings);
        this.storedDeviceManager = KoinJavaComponent.inject(StoredDeviceManager.class);
        this.tempModeManager = KoinJavaComponent.inject(TempModeManager.class);
        this.firebaseTracker = KoinJavaComponent.inject(FirebaseTracker.class);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    protected Integer getBindingVariable() {
        return 6;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mCurrentStatus = getMainActivity().getCurrentStatus();
        this.mPreviousStatus = new CurrentStatus();
        this.mCurrentStatus.setUpdateAll(true);
        getBinding().settingsFanController.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda7
            @Override // com.bedjet.bedjet.ui.custom.seekArc.SeekArc.OnSeekArcChangeListener
            public final void onProgressChanged(SeekArc seekArc, int i, boolean z) {
                MainFragment.this.fanSpeedChanged(seekArc, i, z);
            }
        });
        getBinding().settingsTemperatureController.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda8
            @Override // com.bedjet.bedjet.ui.custom.seekArc.SeekArc.OnSeekArcChangeListener
            public final void onProgressChanged(SeekArc seekArc, int i, boolean z) {
                MainFragment.this.fanTemperatureChanged(seekArc, i, z);
            }
        });
        getBinding().settingsFan.startAnimation(AnimationUtils.loadAnimation(getContext(), C0624R.anim.anim_rotation));
        getBinding().settingsFan.clearAnimation();
        this.mCurrentStatus.setUpdateAll(true);
        updateAllValues(new FunctionName("onViewCreated"));
        this.wasPaused = false;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void updateDisplay() {
        getMainActivity().displaySetupWarnings();
        if (this.mCurrentStatus.getNotifyCode() == 0) {
            this.lastNotified = 0;
        } else if (this.mCurrentStatus.getNotifyCode() != this.lastNotified && !this.showingNotification) {
            this.lastNotified = this.mCurrentStatus.getNotifyCode();
            this.showingNotification = true;
            showNotification(this.mCurrentStatus.getNotifyCode());
        }
        boolean z = this.mCurrentStatus.getUpdateAll() || this.mCurrentStatus.getOperatingMode() != this.mPreviousStatus.getOperatingMode();
        if (z) {
            this.mPreviousStatus.setOperatingMode(this.mCurrentStatus.getOperatingMode());
            updateSelectedButton(this.mCurrentStatus.getOperatingMode());
        }
        if (z || this.mCurrentStatus.getRemainHours() != this.mPreviousStatus.getRemainHours() || this.mCurrentStatus.getRemainMinutes() != this.mPreviousStatus.getRemainSeconds() || this.mCurrentStatus.getRemainSeconds() != this.mPreviousStatus.getRemainSeconds()) {
            this.mPreviousStatus.setRemainHours(this.mCurrentStatus.getRemainHours());
            this.mPreviousStatus.setRemainMinutes(this.mCurrentStatus.getRemainMinutes());
            this.mPreviousStatus.setRemainSeconds(this.mCurrentStatus.getRemainSeconds());
            updateRemainTime(this.mCurrentStatus);
        }
        if (z || this.mCurrentStatus.getActualTemp() != this.mPreviousStatus.getActualTemp()) {
            this.mPreviousStatus.setActualTemp(this.mCurrentStatus.getActualTemp());
            updateActualTemp(this.mCurrentStatus);
        }
        if (z || this.mCurrentStatus.getMinimumTemp() != this.mPreviousStatus.getMinimumTemp() || this.mCurrentStatus.getMaximumTemp() != this.mPreviousStatus.getMaximumTemp()) {
            this.mPreviousStatus.setMinimumTemp(this.mCurrentStatus.getMinimumTemp());
            this.mPreviousStatus.setMaximumTemp(this.mCurrentStatus.getMaximumTemp());
            updateTempRange(this.mCurrentStatus);
        }
        if (z || this.mCurrentStatus.getSetPointTemp() != this.mPreviousStatus.getSetPointTemp()) {
            this.mPreviousStatus.setSetPointTemp(this.mCurrentStatus.getSetPointTemp());
            updateSetPointTemp(this.mCurrentStatus);
        }
        if (z || this.mCurrentStatus.getFanStep() != this.mPreviousStatus.getFanStep()) {
            this.mPreviousStatus.setFanStep(this.mCurrentStatus.getFanStep());
            updateFanStep(this.mCurrentStatus);
        }
        if (z || this.mCurrentStatus.getSequenceStep() != this.mPreviousStatus.getSequenceStep()) {
            int sequenceStep = this.mCurrentStatus.getSequenceStep();
            Context context = getBinding().getRoot().getContext();
            if (context != null) {
                if (sequenceStep == 0) {
                    getBinding().settingsBiorhythm.setText(context.getString(C0624R.string.bio_button_norm));
                } else {
                    getBinding().settingsBiorhythm.setText(context.getString(C0624R.string.bio_button_run, Integer.valueOf(sequenceStep)));
                }
            }
            this.mPreviousStatus.setSequenceStep(this.mCurrentStatus.getSequenceStep());
        }
        this.mCurrentStatus.setUpdateAll(false);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().showActionBar(false);
        getController().setConnectedDevice(getMainActivity().getBedjetName());
        if (this.wasPaused) {
            getNavigator().showConnectionFragment(6);
            return;
        }
        getController().setConnectedDevice(this.storedDeviceManager.getValue().getStoredDeviceName(0));
        updateMemoryNames();
        this.mCurrentStatus.setUpdateAll(true);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.wasPaused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Constants.STATUS_PARCELABLE, this.mCurrentStatus);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.mCurrentStatus = (CurrentStatus) bundle.getParcelable(Constants.STATUS_PARCELABLE);
            updateAllValues(new FunctionName("onViewStateRestored"));
        }
    }

    private void typeSelected(Button button) {
        Button button2 = this.mSelectedButton;
        if (button2 != null) {
            button2.setSelected(false);
        }
        this.mSelectedButton = button;
        button.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeSetListener(String str, String str2) {
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int maxRunTime = Utils.getMaxRunTime(this.mCurrentStatus.getOperatingMode(), this.mCurrentStatus.getSetPointTemp(), this.mCurrentStatus.getFanStep());
            if (parseInt > maxRunTime) {
                parseInt = maxRunTime;
            }
            if (parseInt == maxRunTime) {
                parseInt2 = 0;
            }
            getMainActivity().sendBedJetTime(parseInt, parseInt2);
        } catch (NumberFormatException e) {
            Logger.m517e(this, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTurboSetListener(String str) {
        try {
            getMainActivity().sendBedJetTime(0, Integer.parseInt(str.replaceFirst(" .*", "")));
        } catch (NumberFormatException e) {
            Logger.m517e(this, e.getMessage());
        }
    }

    private void updateRemainTime(CurrentStatus currentStatus) {
        int remainHours = currentStatus.getRemainHours();
        int remainMinutes = currentStatus.getRemainMinutes();
        int remainSeconds = currentStatus.getRemainSeconds();
        if (Utils.isIdleMode(currentStatus)) {
            getBinding().settingsShutoffTimer.setText("Auto-Shutoff\nTimer\n--:--:--");
        } else if (currentStatus.getOperatingMode() == 2) {
            getBinding().settingsShutoffTimer.setText(String.format(Locale.ROOT, "Auto-Shutoff\nTimer\n%02d:%02d", Integer.valueOf(remainMinutes), Integer.valueOf(remainSeconds)));
        } else {
            getBinding().settingsShutoffTimer.setText(String.format(Locale.ROOT, "Auto-Shutoff\nTimer\n%02d:%02d:%02d", Integer.valueOf(remainHours), Integer.valueOf(remainMinutes), Integer.valueOf(remainSeconds)));
        }
    }

    private void updateFanStep(CurrentStatus currentStatus) {
        String str = ((currentStatus.getFanStep() * 5) + 5) + "%";
        getBinding().settingsFanValue.setText(str);
        if (Utils.isIdleMode(currentStatus)) {
            getBinding().settingsFanValue.setText("");
            getBinding().settingsFan.clearAnimation();
            getBinding().settingsFanController.setVisibilty(false);
        } else {
            if (getBinding().getRoot().getContext() == null) {
                return;
            }
            getBinding().settingsFanValue.setText(str);
            getBinding().settingsFan.setVisibility(0);
            getBinding().settingsFan.startAnimation(AnimationUtils.loadAnimation(getContext(), C0624R.anim.anim_rotation));
            getBinding().settingsFanController.setVisibilty(true);
            getBinding().settingsFanController.setProgress(currentStatus.getFanStepScaled());
        }
    }

    private void updateActualTemp(CurrentStatus currentStatus) {
        String renderTemp = Utils.renderTemp(currentStatus.getActualTemp(), this.tempModeManager.getValue().getUseCelsius());
        if (!Utils.isIdleMode(currentStatus)) {
            getBinding().settingsTemperatureActualValue.setText(renderTemp);
        } else {
            getBinding().settingsTemperatureActualValue.setText("");
        }
    }

    private void updateMemoryNames() {
        updateMemoryName(((FragmentSettingsBinding) this.binding).settingsMem1, getMainActivity().getMemoryName1());
        updateMemoryName(((FragmentSettingsBinding) this.binding).settingsMem2, getMainActivity().getMemoryName2());
        updateMemoryName(((FragmentSettingsBinding) this.binding).settingsMem3, getMainActivity().getMemoryName3());
    }

    private void updateMemoryName(MaterialButton materialButton, String str) {
        if (materialButton == null) {
            return;
        }
        if (str.length() >= 10) {
            materialButton.setTextSize(12.0f);
        } else {
            materialButton.setTextSize(16.0f);
        }
        materialButton.setText(str);
    }

    private void updateSetPointTemp(CurrentStatus currentStatus) {
        String renderTemp = Utils.renderTemp(currentStatus.getSetPointTemp(), this.tempModeManager.getValue().getUseCelsius());
        if (!Utils.isIdleMode(currentStatus)) {
            getBinding().settingsTemperatureSetValue.setText(renderTemp);
            getBinding().settingsTemperatureController.setVisibilty(true);
            getBinding().settingsTemperatureController.setProgress(currentStatus.getSetPointTemp());
        } else {
            getBinding().settingsTemperatureSetValue.setText("");
            getBinding().settingsTemperatureController.setVisibilty(false);
        }
    }

    private void updateTempRange(CurrentStatus currentStatus) {
        getBinding().settingsTemperatureController.setMin(currentStatus.getMinimumTemp());
        getBinding().settingsTemperatureController.setMax(currentStatus.getMaximumTemp());
    }

    private void updateSelectedButton(int i) {
        switch (i) {
            case 0:
            case 6:
                typeSelected(getBinding().settingsOffButton);
                return;
            case 1:
                typeSelected(getBinding().settingsHeatButton);
                return;
            case 2:
                typeSelected(getBinding().settingsTurboButton);
                return;
            case 3:
                typeSelected(getBinding().settingsExtHeatButton);
                return;
            case 4:
                typeSelected(getBinding().settingsCoolButton);
                return;
            case 5:
                typeSelected(getBinding().settingsDryButton);
                return;
            default:
                return;
        }
    }

    private void updateAllValues(FunctionName functionName) {
        CurrentStatus currentStatus = this.mCurrentStatus;
        if (currentStatus == null) {
            FirebaseCrashlytics.getInstance().recordException(new FirebaseException("MainFragment updateAllValues mCurrentStatus == null from " + functionName.getFunctionName()));
            return;
        }
        updateRemainTime(currentStatus);
        updateFanStep(this.mCurrentStatus);
        updateActualTemp(this.mCurrentStatus);
        updateTempRange(this.mCurrentStatus);
        updateSetPointTemp(this.mCurrentStatus);
        updateSelectedButton(this.mCurrentStatus.getOperatingMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fanSpeedChanged(SeekArc seekArc, int i, boolean z) {
        int i2 = (i / 5) - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 19) {
            i2 = 19;
        }
        String str = ((i2 + 1) * 5) + "%";
        LoggerKt.log("fanSpeedChanged: seekArc = " + seekArc + ", progress = " + i + ", indicateOnly = " + z + ", fanStep = " + str);
        getBinding().settingsFanValue.setText(str);
        if (z || Utils.isIdleMode(this.mCurrentStatus)) {
            return;
        }
        getMainActivity().sendBedJetFan(i2);
        this.mCurrentStatus.setFanStep(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fanTemperatureChanged(SeekArc seekArc, int i, boolean z) {
        String renderTemp = Utils.renderTemp(i, this.tempModeManager.getValue().getUseCelsius());
        LoggerKt.log("fanTemperatureChanged: seekArc = " + seekArc + ", progress = " + i + ", indicateOnly = " + z + ", temperature = " + renderTemp);
        getBinding().settingsTemperatureSetValue.setText(renderTemp);
        if (z || Utils.isIdleMode(this.mCurrentStatus)) {
            return;
        }
        getMainActivity().sendBedJetTemp(i);
        this.mCurrentStatus.setSetPointTemp(i);
    }

    private void showNotificationDialog(String str, String str2) {
        new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle(str).setMessage(str2).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.this.lambda$showNotificationDialog$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNotificationDialog$0(DialogInterface dialogInterface, int i) {
        this.showingNotification = false;
    }

    private void showNotification(int i) {
        if (i != 0) {
            if (i == 1) {
                showNotificationDialog("Clean Filter", "Please check BedJet air filter and clean if necessary.");
            } else if (i == 2) {
                showNotificationDialog("Firmware Update", "A newer version of firmware is available.");
            } else if (i == 3) {
                showNotificationDialog("Firmware Update", "Unable to connect to the firmware update server.");
            } else if (i == 4) {
                showNotificationDialog("Biorhythm", "The specified sequence cannot be run because the clock is not set");
            } else if (i == 5) {
                showNotificationDialog("Biorhythm", "The specified sequence cannot be run because it contains steps that would be too long running from the current time.");
            } else {
                showNotificationDialog("Notify", "Unknown notification code received from BedJet - please check for app updates");
            }
            getMainActivity().sendBedJetButton(82);
        }
    }

    public void onOff() {
        LoggerKt.logPressed("Off");
        sendBedJetButton(1);
    }

    public void onTurbo() {
        LoggerKt.logPressed(Constants.MODENAME_TURBO);
        sendBedJetButton(4);
    }

    public void onHeat() {
        LoggerKt.logPressed("Heat");
        sendBedJetButton(3);
    }

    public void onCool() {
        LoggerKt.logPressed("Cool");
        sendBedJetButton(2);
    }

    public void onDry() {
        LoggerKt.logPressed("Dry");
        sendBedJetButton(5);
    }

    public void onExtHeat() {
        LoggerKt.logPressed(Constants.MODENAME_EXTHT);
        sendBedJetButton(6);
    }

    public void onFanAdd() {
        LoggerKt.logPressed("onFanAdd");
        sendBedJetButton(16);
    }

    public void onFanMinus() {
        LoggerKt.logPressed("onFanMinus");
        sendBedJetButton(17);
    }

    public void onTemperatureAdd() {
        LoggerKt.logPressed("onTemperatureAdd");
        sendBedJetButton(this.tempModeManager.getValue().getUseCelsius() ? 18 : 20);
    }

    public void onTemperatureMinus() {
        LoggerKt.logPressed("onTemperatureMinus");
        sendBedJetButton(this.tempModeManager.getValue().getUseCelsius() ? 19 : 21);
    }

    public void showTimer() {
        Context context;
        LoggerKt.logPressed("showTimer");
        if (Utils.isIdleMode(this.mCurrentStatus) || (context = getContext()) == null) {
            return;
        }
        if (this.mCurrentStatus.getOperatingMode() == 2) {
            PickerDialog.INSTANCE.showTurboDialog(context, this.mCurrentStatus.getRemainMinutes(), new PickerListener.SinglePickerListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda5
                @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.SinglePickerListener
                public final void onPickerSet(String str) {
                    MainFragment.this.onTurboSetListener(str);
                }
            });
            return;
        }
        SequenceStep sequenceStep = new SequenceStep();
        sequenceStep.setMode(this.mCurrentStatus.getOperatingMode());
        sequenceStep.setFanStep(this.mCurrentStatus.getFanStep());
        sequenceStep.setTemperature(this.mCurrentStatus.getSetPointTemp());
        PickerDialog.INSTANCE.showTimerDialog(context, sequenceStep, this.mCurrentStatus.getRemainHours(), this.mCurrentStatus.getRemainMinutes(), new PickerListener.DoublePickerListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda6
            @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.DoublePickerListener
            public final void onPickerSet(String str, String str2) {
                MainFragment.this.onTimeSetListener(str, str2);
            }
        });
    }

    public void navigateToBiorhythmSettings() {
        LoggerKt.logPressed("navigateToBiorhythmSettings");
        getNavigator().showBiorhythmFragment();
    }

    /* renamed from: com.bedjet.bedjet.ui.mainscreen.MainFragment$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C06411 {
        static final /* synthetic */ int[] $SwitchMap$com$bedjet$bedjet$ui$main$RenameType;

        static {
            int[] iArr = new int[RenameType.values().length];
            $SwitchMap$com$bedjet$bedjet$ui$main$RenameType = iArr;
            try {
                iArr[RenameType.f124V3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bedjet$bedjet$ui$main$RenameType[RenameType.MEMORY3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void nameSet(RenameType renameType, String str) {
        int i = C06411.$SwitchMap$com$bedjet$bedjet$ui$main$RenameType[renameType.ordinal()];
        if (i == 1) {
            getController().setConnectedDevice(getMainActivity().getBedjetName());
        } else if (i == 2 || i == 3 || i == 4) {
            updateMemoryNames();
        }
    }

    private void showMemSelectMenu() {
        Dialog dialog = new Dialog(getContext(), C0624R.style.AppDialog);
        this.memDialog = dialog;
        dialog.setCanceledOnTouchOutside(false);
        this.memDialog.setContentView(C0624R.layout.layout_savemem);
        Button button = (Button) this.memDialog.findViewById(C0624R.id.btn_mem1);
        Button button2 = (Button) this.memDialog.findViewById(C0624R.id.btn_mem2);
        Button button3 = (Button) this.memDialog.findViewById(C0624R.id.btn_mem3);
        Button button4 = (Button) this.memDialog.findViewById(C0624R.id.btn_cancel);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.this.lambda$showMemSelectMenu$1(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.this.lambda$showMemSelectMenu$2(view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.this.lambda$showMemSelectMenu$3(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.this.lambda$showMemSelectMenu$4(view);
            }
        });
        this.memDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMemSelectMenu$1(View view) {
        getMainActivity().showRenameMenu(RenameType.MEMORY1);
        updateMemoryNames();
        sendBedJetButton(40);
        this.memDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMemSelectMenu$2(View view) {
        getMainActivity().showRenameMenu(RenameType.MEMORY2);
        updateMemoryNames();
        sendBedJetButton(41);
        this.memDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMemSelectMenu$3(View view) {
        getMainActivity().showRenameMenu(RenameType.MEMORY3);
        updateMemoryNames();
        sendBedJetButton(42);
        this.memDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMemSelectMenu$4(View view) {
        this.memDialog.cancel();
    }

    public void saveSettings() {
        LoggerKt.logPressed("saveSettings");
        this.firebaseTracker.getValue().trackScreen("saveSettings dialog");
        if (Utils.isIdleMode(this.mCurrentStatus)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog);
            builder.setTitle(C0624R.string.save_title);
            builder.setMessage(C0624R.string.save_stopped);
            builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
            builder.create().show();
            return;
        }
        showMemSelectMenu();
    }

    public void recallMem1() {
        LoggerKt.logPressed("recallMem1");
        sendBedJetButton(32);
    }

    public void recallMem2() {
        LoggerKt.logPressed("recallMem2");
        sendBedJetButton(33);
    }

    public void recallMem3() {
        LoggerKt.logPressed("recallMem3");
        sendBedJetButton(34);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void biodataAvailable(byte[] bArr) {
        getMainActivity().cancelReadRetry();
    }
}
