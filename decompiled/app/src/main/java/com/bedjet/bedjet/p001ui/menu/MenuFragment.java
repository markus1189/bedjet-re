package com.bedjet.bedjet.p001ui.menu;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.legacy.RunningStatusV2;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentMenuBinding;
import com.bedjet.bedjet.p000di.TempModeManager;
import com.bedjet.bedjet.p001ui.CustomDialog;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.RenameType;
import com.bedjet.bedjet.p001ui.main.ResumeFlag;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import com.bedjet.bedjet.utils.app;
import com.bedjet.bedjet.utils.ext;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.core.qualifier.Qualifier;
import timber.log.Timber;

/* compiled from: MenuFragment.kt */
@Metadata(m942d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010/\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\b\u00101\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, m943d2 = {"Lcom/bedjet/bedjet/ui/menu/MenuFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentMenuBinding;", "<init>", "()V", "isV2", "", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "getStoredDeviceManager", "()Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "storedDeviceManager$delegate", "Lkotlin/Lazy;", "tempModeManager", "Lcom/bedjet/bedjet/di/TempModeManager;", "getTempModeManager", "()Lcom/bedjet/bedjet/di/TempModeManager;", "tempModeManager$delegate", "customDialog", "Lcom/bedjet/bedjet/ui/CustomDialog;", "getCustomDialog", "()Lcom/bedjet/bedjet/ui/CustomDialog;", "customDialog$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "stopShimmer", "onResume", "onPause", "biodataAvailable", "data", "", "processBiodata", "isCanGoBack", "clickListener", "Landroid/view/View$OnClickListener;", "addNewDevice", "showDeviceList", "showRenameMenu", "showLightsDialog", "context", "Landroid/content/Context;", "setBedJetClock", "showTempDialog", "showFactoryResetDialog", "showSecondFactoryResetDialog", "onExitPressed", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MenuFragment extends BaseFragment<FragmentMenuBinding> {
    private static String TAG = "MenuFragment";
    private final View.OnClickListener clickListener;

    /* renamed from: customDialog$delegate, reason: from kotlin metadata */
    private final Lazy customDialog;
    private boolean isV2;

    /* renamed from: storedDeviceManager$delegate, reason: from kotlin metadata */
    private final Lazy storedDeviceManager;

    /* renamed from: tempModeManager$delegate, reason: from kotlin metadata */
    private final Lazy tempModeManager;

    public MenuFragment() {
        super(C0624R.layout.fragment_menu);
        final MenuFragment menuFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storedDeviceManager = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoredDeviceManager>() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager] */
            @Override // kotlin.jvm.functions.Function0
            public final StoredDeviceManager invoke() {
                ComponentCallbacks componentCallbacks = menuFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.tempModeManager = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<TempModeManager>() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.bedjet.bedjet.di.TempModeManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TempModeManager invoke() {
                ComponentCallbacks componentCallbacks = menuFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TempModeManager.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.customDialog = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<CustomDialog>() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.bedjet.bedjet.ui.CustomDialog, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CustomDialog invoke() {
                ComponentCallbacks componentCallbacks = menuFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CustomDialog.class), b4, b5);
            }
        });
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuFragment.clickListener$lambda$1(MenuFragment.this, view);
            }
        };
    }

    private final StoredDeviceManager getStoredDeviceManager() {
        return (StoredDeviceManager) this.storedDeviceManager.getValue();
    }

    private final TempModeManager getTempModeManager() {
        return (TempModeManager) this.tempModeManager.getValue();
    }

    private final CustomDialog getCustomDialog() {
        return (CustomDialog) this.customDialog.getValue();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setClickListener(this.clickListener);
        getBinding().tvAppVersionValue.setText(app.getVersions());
        boolean areEqual = Intrinsics.areEqual(getStoredDeviceManager().getDeviceRecord(0).getDeviceType(), DeviceType.BEDJET2.toString());
        this.isV2 = areEqual;
        if (areEqual) {
            getBinding().btnClockSet.setVisibility(8);
            getBinding().btnWifiSetup.setVisibility(8);
            getBinding().btnUpdateFirmware.setVisibility(8);
            getBinding().btnFactoryReset.setVisibility(8);
            getBinding().groupRemoteVersion.setVisibility(8);
        }
        if (this.isV2) {
            getBinding().tvBedJetVersionTitle.setText(getMainActivity().getUseBedJetV2protocol() ? C0624R.string.title_bedjet_v2 : C0624R.string.title_bedjet_v1);
            int v2fwVer = getMainActivity().getV2fwVer();
            String string = view.getContext().getString(C0624R.string.fragment_menu_bedjet_2_version, Integer.valueOf(v2fwVer / 16), Integer.valueOf(v2fwVer & 15));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            getBinding().tvBedJetVersionValue.setText(string);
            stopShimmer();
            return;
        }
        getBinding().tvBedJetVersionTitle.setText(C0624R.string.title_bedjet_v3);
        getMainActivity().requestWithRetry(32);
    }

    private final void stopShimmer() {
        ShimmerFrameLayout shimmerBedJetVersionValue = getBinding().shimmerBedJetVersionValue;
        Intrinsics.checkNotNullExpressionValue(shimmerBedJetVersionValue, "shimmerBedJetVersionValue");
        ext.stop(shimmerBedJetVersionValue);
        ShimmerFrameLayout shimmerRemoteVersionValue = getBinding().shimmerRemoteVersionValue;
        Intrinsics.checkNotNullExpressionValue(shimmerRemoteVersionValue, "shimmerRemoteVersionValue");
        ext.stop(shimmerRemoteVersionValue);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().hideSystemUI();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getController().showSystemUI();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void biodataAvailable(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getMainActivity().cancelReadRetry();
        processBiodata(data);
    }

    private final void processBiodata(byte[] data) {
        if (data.length < 3) {
            Timber.Companion companion = Timber.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            companion.tag(TAG2).mo1173e("Incoming biodata packet is too short!", new Object[0]);
            return;
        }
        final byte[] copyOfRange = ArraysKt.copyOfRange(data, 2, data.length);
        if (data[0] == getMainActivity().mLastRequest && data[0] == 32) {
            getMainActivity().cancelReadRetry();
            getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    MenuFragment.processBiodata$lambda$0(MenuFragment.this, copyOfRange);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processBiodata$lambda$0(MenuFragment menuFragment, byte[] bArr) {
        menuFragment.getBinding().tvBedJetVersionValue.setText(StringsKt.trim((CharSequence) new String(ArraysKt.copyOfRange(bArr, 0, 15), Charsets.UTF_8)).toString());
        menuFragment.getBinding().tvRemoteVersionValue.setText(StringsKt.trim((CharSequence) new String(ArraysKt.copyOfRange(bArr, 32, 47), Charsets.UTF_8)).toString());
        menuFragment.stopShimmer();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "isCanGoBack called");
        if (getMainActivity().getIsDisconnected()) {
            getNavigator().showConnectionFragment(9);
            return false;
        }
        getNavigator().showConnectedFragment();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$1(MenuFragment menuFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Context context = v.getContext();
        if (context == null) {
            return;
        }
        int id = v.getId();
        if (id == C0624R.id.btnAddNewDevice) {
            menuFragment.addNewDevice();
            return;
        }
        if (id == C0624R.id.btnShowDeviceList) {
            menuFragment.showDeviceList();
            return;
        }
        if (id == C0624R.id.btnRenameDevice) {
            menuFragment.showRenameMenu();
            return;
        }
        if (id == C0624R.id.btnAudioAndLights) {
            menuFragment.showLightsDialog(context);
            return;
        }
        if (id == C0624R.id.btnClockSet) {
            menuFragment.setBedJetClock(context);
            return;
        }
        if (id == C0624R.id.btnUpdateFirmware) {
            menuFragment.getMainActivity().doBedJetUpdate();
            return;
        }
        if (id == C0624R.id.btnWifiSetup) {
            menuFragment.getNavigator().showPromptFragment(PromptType.PROMPT_WIFI);
            return;
        }
        if (id == C0624R.id.btnTempUnit) {
            menuFragment.showTempDialog(context);
        } else if (id == C0624R.id.btnFactoryReset) {
            menuFragment.showFactoryResetDialog(context);
        } else if (id == C0624R.id.btnExitFromMenu) {
            menuFragment.onExitPressed();
        }
    }

    private final void addNewDevice() {
        getMainActivity().disconnectDevice(3);
        getMainActivity().setResumeFlag(ResumeFlag.RESUME_MENU);
        getNavigator().showDeviceListFragment(4);
    }

    private final void showDeviceList() {
        getMainActivity().setResumeFlag(ResumeFlag.RESUME_MENU);
        getNavigator().showStoredDeviceFragment(5);
    }

    private final void showRenameMenu() {
        getMainActivity().showRenameMenu(this.isV2 ? RenameType.f123V2 : RenameType.f124V3);
    }

    private final void showLightsDialog(Context context) {
        boolean[] zArr;
        if (this.isV2) {
            RunningStatusV2 v2Status = getMainActivity().getV2Status();
            zArr = new boolean[]{v2Status.muteFlag != 0, v2Status.ledBlank != 0};
        } else {
            zArr = new boolean[]{getMainActivity().getCurrentStatus().getBeepsMuted(), !r0.getLedsEnabled()};
        }
        final boolean[] zArr2 = zArr;
        final boolean[] copyOf = Arrays.copyOf(zArr2, zArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        final int i = 0;
        final int i2 = 1;
        new AlertDialog.Builder(context).setTitle(C0624R.string.fragment_menu_lights_dialog_title).setMultiChoiceItems(new String[]{context.getString(C0624R.string.fragment_menu_lights_dialog_audio_title), context.getString(C0624R.string.fragment_menu_lights_dialog_led_title)}, zArr2, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i3, boolean z) {
                MenuFragment.showLightsDialog$lambda$2(zArr2, dialogInterface, i3, z);
            }
        }).setNegativeButton(C0624R.string.fragment_menu_lights_dialog_btn_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(C0624R.string.fragment_menu_lights_dialog_btn_ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MenuFragment.showLightsDialog$lambda$3(MenuFragment.this, zArr2, i, i2, copyOf, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLightsDialog$lambda$2(boolean[] zArr, DialogInterface dialogInterface, int i, boolean z) {
        zArr[i] = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLightsDialog$lambda$3(MenuFragment menuFragment, boolean[] zArr, int i, int i2, boolean[] zArr2, DialogInterface dialogInterface, int i3) {
        if (menuFragment.isV2) {
            menuFragment.getMainActivity().setV2MuteStatus(zArr[i], zArr[i2]);
            return;
        }
        if (zArr[i] != zArr2[i]) {
            menuFragment.getMainActivity().sendBedJetButton(zArr[i] ? 72 : 73);
        }
        if (zArr[i2] != zArr2[i2]) {
            menuFragment.getMainActivity().sendBedJetButton(zArr[i2] ? 71 : 70);
        }
    }

    private final void setBedJetClock(Context context) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        getMainActivity().sendBedJetClock(i, i2);
        String string = context.getString(C0624R.string.fragment_menu_clock_toast, Integer.valueOf(i), Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast.makeText(context, string, 1).show();
    }

    private final void showTempDialog(Context context) {
        String[] strArr = {context.getString(C0624R.string.fragment_menu_temp_dialog_item)};
        final boolean[] zArr = {getTempModeManager().getUseCelsius()};
        new AlertDialog.Builder(context).setTitle(C0624R.string.fragment_menu_temp_dialog_title).setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                MenuFragment.showTempDialog$lambda$4(zArr, dialogInterface, i, z);
            }
        }).setNegativeButton(C0624R.string.fragment_menu_temp_dialog_btn_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(C0624R.string.fragment_menu_temp_dialog_btn_ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MenuFragment.showTempDialog$lambda$5(MenuFragment.this, zArr, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTempDialog$lambda$4(boolean[] zArr, DialogInterface dialogInterface, int i, boolean z) {
        zArr[i] = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTempDialog$lambda$5(MenuFragment menuFragment, boolean[] zArr, DialogInterface dialogInterface, int i) {
        menuFragment.getTempModeManager().setUseCelsius(zArr[0]);
    }

    private final void showFactoryResetDialog(final Context context) {
        getCustomDialog().showFactoryResetDialog(context, C0624R.string.dialog_factory_reset_app_message_first, new Function0() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showFactoryResetDialog$lambda$6;
                showFactoryResetDialog$lambda$6 = MenuFragment.showFactoryResetDialog$lambda$6(MenuFragment.this, context);
                return showFactoryResetDialog$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showFactoryResetDialog$lambda$6(MenuFragment menuFragment, Context context) {
        menuFragment.showSecondFactoryResetDialog(context);
        return Unit.INSTANCE;
    }

    private final void showSecondFactoryResetDialog(Context context) {
        getCustomDialog().showFactoryResetDialog(context, C0624R.string.dialog_factory_reset_app_message_second, new Function0() { // from class: com.bedjet.bedjet.ui.menu.MenuFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showSecondFactoryResetDialog$lambda$7;
                showSecondFactoryResetDialog$lambda$7 = MenuFragment.showSecondFactoryResetDialog$lambda$7(MenuFragment.this);
                return showSecondFactoryResetDialog$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showSecondFactoryResetDialog$lambda$7(MenuFragment menuFragment) {
        menuFragment.isCanGoBack();
        menuFragment.getMainActivity().sendBedJetButton(76);
        return Unit.INSTANCE;
    }

    private final void onExitPressed() {
        if (getMainActivity().getIsDisconnected()) {
            getNavigator().showConnectionFragment(8);
        } else {
            getNavigator().showConnectedFragment();
        }
    }
}
