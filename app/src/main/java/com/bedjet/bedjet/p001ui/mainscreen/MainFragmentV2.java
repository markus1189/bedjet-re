package com.bedjet.bedjet.p001ui.mainscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.Constants;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.CurrentStatus;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.legacy.RunningStatusV2;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentV2statusBindingImpl;
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
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Locale;
import kotlin.Lazy;
import org.koin.java.KoinJavaComponent;

/* loaded from: classes.dex */
public class MainFragmentV2 extends BaseFragment<FragmentV2statusBindingImpl> {
    private static final String TAG = "MainFragmentV2";
    private final Lazy<FirebaseTracker> firebaseTracker;
    private boolean isBedJetV1;
    private CurrentStatus mCurrentStatus;
    private CurrentStatus mPreviousStatus;
    private Button mSelectedButton;
    private final Lazy<StoredDeviceManager> storedDeviceManager;
    private final Lazy<TempModeManager> tempModeManager;
    private boolean wasPaused;

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void gattDisconnected() {
    }

    public MainFragmentV2() {
        super(C0624R.layout.fragment_v2status);
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
        this.mCurrentStatus = new CurrentStatus();
        this.mPreviousStatus = new CurrentStatus();
        this.mCurrentStatus.setUpdateAll(true);
        getController().setConnectedDevice(this.storedDeviceManager.getValue().getStoredDeviceName(0));
        getBinding().settingsFanController.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda5
            @Override // com.bedjet.bedjet.ui.custom.seekArc.SeekArc.OnSeekArcChangeListener
            public final void onProgressChanged(SeekArc seekArc, int i, boolean z) {
                MainFragmentV2.this.fanSpeedChanged(seekArc, i, z);
            }
        });
        getBinding().settingsTemperatureController.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda6
            @Override // com.bedjet.bedjet.ui.custom.seekArc.SeekArc.OnSeekArcChangeListener
            public final void onProgressChanged(SeekArc seekArc, int i, boolean z) {
                MainFragmentV2.this.fanTemperatureChanged(seekArc, i, z);
            }
        });
        getBinding().settingsFan.startAnimation(AnimationUtils.loadAnimation(getContext(), C0624R.anim.anim_rotation));
        getBinding().settingsFan.clearAnimation();
        this.mCurrentStatus.setUpdateAll(true);
        updateAllValues(new FunctionName("onViewCreated"));
        this.wasPaused = false;
        this.isBedJetV1 = false;
    }

    private void updateDisplayV2() {
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
        int sequenceStep = this.mCurrentStatus.getSequenceStep();
        if (sequenceStep == 0) {
            getBinding().settingsBiorhythm.setText(getString(C0624R.string.bio_button_norm));
        } else {
            getBinding().settingsBiorhythm.setText(getString(C0624R.string.bio_button_run, Integer.valueOf(sequenceStep)));
        }
        this.mCurrentStatus.setUpdateAll(false);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().showActionBar(false);
        getController().setConnectedDevice(getMainActivity().getBedjetName());
        if (this.wasPaused) {
            getNavigator().showConnectionFragment(7);
            return;
        }
        getController().setConnectedDevice(getMainActivity().getBedjetName());
        ((TextView) getMainActivity().findViewById(C0624R.id.settingsMem1)).setText(C0624R.string.btn_save_mem_1);
        ((TextView) getMainActivity().findViewById(C0624R.id.settingsMem2)).setText(C0624R.string.btn_save_mem_2);
        ((TextView) getMainActivity().findViewById(C0624R.id.settingsMem3)).setText(C0624R.string.btn_save_mem_3);
        this.mCurrentStatus.setUpdateAll(true);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.wasPaused = true;
        super.onPause();
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
            getMainActivity().setBedJetV2Time(parseInt, parseInt2);
        } catch (NumberFormatException e) {
            Logger.m517e(this, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTurboSetListener(String str) {
        try {
            getMainActivity().setBedJetV2Time(0, Integer.parseInt(str.replaceFirst(" .*", "")));
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
        } else if (currentStatus.getOperatingMode() == 1) {
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

    private void updateSetPointTemp(CurrentStatus currentStatus) {
        String renderTemp = Utils.renderTemp(currentStatus.getSetPointTemp(), this.tempModeManager.getValue().getUseCelsius());
        if (!Utils.isIdleMode(currentStatus) && currentStatus.getOperatingMode() != 3) {
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
        if (i == 0) {
            typeSelected(getBinding().settingsOffButton);
            return;
        }
        if (i == 1) {
            typeSelected(getBinding().settingsTurboButton);
        } else if (i == 2) {
            typeSelected(getBinding().settingsHeatButton);
        } else {
            if (i != 3) {
                return;
            }
            typeSelected(getBinding().settingsCoolButton);
        }
    }

    private void updateAllValues(FunctionName functionName) {
        CurrentStatus currentStatus = this.mCurrentStatus;
        if (currentStatus == null) {
            FirebaseCrashlytics.getInstance().recordException(new FirebaseException("MainFragmentV2 updateAllValues mCurrentStatus == null from " + functionName.getFunctionName()));
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
        getMainActivity().sendBedJetV2Fan(i2);
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
        getMainActivity().setBedJetV2Temp(i, this.isBedJetV1);
        this.mCurrentStatus.setSetPointTemp(i);
    }

    public void onOff() {
        LoggerKt.logPressed("Off");
        int operatingMode = this.mCurrentStatus.getOperatingMode();
        if (operatingMode == 1) {
            getMainActivity().sendBedJetV2Command(1);
        } else if (operatingMode == 2) {
            getMainActivity().sendBedJetV2Command(2);
        } else {
            if (operatingMode != 3) {
                return;
            }
            getMainActivity().sendBedJetV2Command(3);
        }
    }

    public void onTurbo() {
        LoggerKt.logPressed(Constants.MODENAME_TURBO);
        if (this.mCurrentStatus.getOperatingMode() != 1) {
            getMainActivity().sendBedJetV2Command(1);
        }
    }

    public void onHeat() {
        LoggerKt.logPressed("Heat");
        if (this.mCurrentStatus.getOperatingMode() != 2) {
            getMainActivity().sendBedJetV2Command(2);
        }
    }

    public void onCool() {
        LoggerKt.logPressed("Cool");
        if (this.mCurrentStatus.getOperatingMode() != 3) {
            getMainActivity().sendBedJetV2Command(3);
        }
    }

    public void onFanAdd() {
        LoggerKt.logPressed("onFanAdd");
        getMainActivity().sendBedJetV2Command(4);
    }

    public void onFanMinus() {
        LoggerKt.logPressed("onFanMinus");
        getMainActivity().sendBedJetV2Command(5);
    }

    public void onTemperatureAdd() {
        LoggerKt.logPressed("onTemperatureAdd");
        int setPointTemp = this.mCurrentStatus.getSetPointTemp();
        if (this.tempModeManager.getValue().getUseCelsius()) {
            setPointTemp = (setPointTemp & (-2)) + 2;
        } else {
            int f = Utils.toF(setPointTemp);
            do {
                setPointTemp++;
            } while (Utils.toF(setPointTemp) == f);
        }
        if (setPointTemp > this.mCurrentStatus.getMaximumTemp()) {
            setPointTemp = this.mCurrentStatus.getMaximumTemp();
        }
        getMainActivity().setBedJetV2Temp(setPointTemp, this.isBedJetV1);
    }

    public void onTemperatureMinus() {
        LoggerKt.logPressed("onTemperatureMinus");
        int setPointTemp = this.mCurrentStatus.getSetPointTemp();
        if (this.tempModeManager.getValue().getUseCelsius()) {
            setPointTemp = (setPointTemp & (-2)) - 2;
        } else {
            int f = Utils.toF(setPointTemp);
            do {
                setPointTemp--;
            } while (Utils.toF(setPointTemp) == f);
        }
        if (setPointTemp < this.mCurrentStatus.getMinimumTemp()) {
            setPointTemp = this.mCurrentStatus.getMinimumTemp();
        }
        getMainActivity().setBedJetV2Temp(setPointTemp, this.isBedJetV1);
    }

    public void showTimer() {
        Context context;
        LoggerKt.logPressed("showTimer");
        if (Utils.isIdleMode(this.mCurrentStatus) || (context = getContext()) == null) {
            return;
        }
        if (this.mCurrentStatus.getOperatingMode() == 1) {
            PickerDialog.INSTANCE.showTurboDialog(context, this.mCurrentStatus.getRemainMinutes(), new PickerListener.SinglePickerListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda0
                @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.SinglePickerListener
                public final void onPickerSet(String str) {
                    MainFragmentV2.this.onTurboSetListener(str);
                }
            });
            return;
        }
        SequenceStep sequenceStep = new SequenceStep();
        if (this.mCurrentStatus.getOperatingMode() == 2) {
            sequenceStep.setMode(1);
        } else {
            sequenceStep.setMode(4);
        }
        sequenceStep.setFanStep(this.mCurrentStatus.getFanStep());
        sequenceStep.setTemperature(this.mCurrentStatus.getSetPointTemp());
        LoggerKt.logTag(TAG, String.format(Locale.ROOT, "foobar temp = %d", Integer.valueOf(sequenceStep.getTemperature())));
        PickerDialog.INSTANCE.showTimerDialog(context, sequenceStep, this.mCurrentStatus.getRemainHours(), this.mCurrentStatus.getRemainMinutes(), new PickerListener.DoublePickerListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda1
            @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.DoublePickerListener
            public final void onPickerSet(String str, String str2) {
                MainFragmentV2.this.onTimeSetListener(str, str2);
            }
        });
    }

    public void navigateToTemperature() {
        getNavigator().showTemperatureFragment();
    }

    public void navigateToBiorhythmSettings() {
        LoggerKt.logPressed("navigateToBiorhythmSettings");
        getNavigator().showBiorhythmFragment();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void nameSet(RenameType renameType, String str) {
        if (renameType == RenameType.f123V2) {
            getController().setConnectedDevice(getMainActivity().getBedjetName());
        }
    }

    public void saveSettings() {
        LoggerKt.logPressed("saveSettings");
        AlertDialog.Builder builder = new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog);
        if (Utils.isIdleMode(this.mCurrentStatus)) {
            builder.setTitle(C0624R.string.save_title);
            builder.setMessage(C0624R.string.save_stopped);
            builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        } else {
            builder.setTitle(C0624R.string.save_title);
            builder.setCancelable(false);
            builder.setPositiveButton("Memory 1", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainFragmentV2.this.lambda$saveSettings$0(dialogInterface, i);
                }
            });
            builder.setNegativeButton("Memory 2", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainFragmentV2.this.lambda$saveSettings$1(dialogInterface, i);
                }
            });
            builder.setNeutralButton("Memory 3", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.mainscreen.MainFragmentV2$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainFragmentV2.this.lambda$saveSettings$2(dialogInterface, i);
                }
            });
        }
        this.firebaseTracker.getValue().trackScreen("saveSettings dialog");
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSettings$0(DialogInterface dialogInterface, int i) {
        getMainActivity().saveMemV2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSettings$1(DialogInterface dialogInterface, int i) {
        getMainActivity().saveMemV2(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSettings$2(DialogInterface dialogInterface, int i) {
        getMainActivity().saveMemV2(3);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void renderNormal(RunningStatusV2 runningStatusV2) {
        this.isBedJetV1 = runningStatusV2.firmware_ver < 48;
        getBinding().settingsBiorhythm.setEnabled(!this.isBedJetV1);
        getBinding().settingsTemperatureController.setEnabled(runningStatusV2.customSetpoint > 0);
        this.mCurrentStatus.setOperatingMode(runningStatusV2.operatingMode);
        int operatingMode = this.mCurrentStatus.getOperatingMode();
        if (operatingMode == 1) {
            this.mCurrentStatus.setMinimumTemp(86);
            this.mCurrentStatus.setMaximumTemp(86);
            this.mCurrentStatus.setSetPointTemp(86);
        } else if (operatingMode != 2) {
            if (operatingMode == 3) {
                this.mCurrentStatus.setMinimumTemp(44);
                this.mCurrentStatus.setMaximumTemp(44);
                this.mCurrentStatus.setSetPointTemp(44);
            }
        } else if (runningStatusV2.customSetpoint == 0) {
            this.mCurrentStatus.setMinimumTemp(80);
            this.mCurrentStatus.setMaximumTemp(80);
            this.mCurrentStatus.setSetPointTemp(80);
        } else {
            if (this.tempModeManager.getValue().getUseCelsius()) {
                this.mCurrentStatus.setMinimumTemp(44);
            } else {
                this.mCurrentStatus.setMinimumTemp(45);
            }
            this.mCurrentStatus.setMaximumTemp(80);
            this.mCurrentStatus.setSetPointTemp(runningStatusV2.customSetpoint);
        }
        this.mCurrentStatus.setRemainSeconds(runningStatusV2.timerSecond);
        this.mCurrentStatus.setRemainMinutes(runningStatusV2.timerMinute);
        this.mCurrentStatus.setRemainHours(runningStatusV2.timerHour);
        this.mCurrentStatus.setOperatingMode(runningStatusV2.operatingMode);
        this.mCurrentStatus.setFanStep(runningStatusV2.fanSpeed);
        this.mCurrentStatus.setActualTemp(runningStatusV2.currentTemp);
        this.mCurrentStatus.setSequenceStep(runningStatusV2.currentStep);
        this.mCurrentStatus.setSetPointTemp(runningStatusV2.customSetpoint);
        updateDisplayV2();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void deviceNameRead(String str) {
        getController().setConnectedDevice(str);
    }

    public void recallMem1() {
        LoggerKt.logPressed("recallMem1");
        getMainActivity().loadMemV2(1);
    }

    public void recallMem2() {
        LoggerKt.logPressed("recallMem2");
        getMainActivity().loadMemV2(2);
    }

    public void recallMem3() {
        LoggerKt.logPressed("recallMem3");
        getMainActivity().loadMemV2(3);
    }
}
