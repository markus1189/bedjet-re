package com.bedjet.bedjet.p001ui.prompt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import com.bedjet.bedjet.BuildConfig;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.databinding.FragmentPromptBinding;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.ResumeFlag;
import com.bedjet.bedjet.utils.permissions;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromptFragment.kt */
@Metadata(m942d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014 \u0015*\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m943d2 = {"Lcom/bedjet/bedjet/ui/prompt/PromptFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentPromptBinding;", "<init>", "()V", "promptType", "Lcom/bedjet/bedjet/ui/prompt/PromptType;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onButton2Pressed", "onButtonPressed", "permissionForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "isCanGoBack", "", "clickListener", "Landroid/view/View$OnClickListener;", "showSettingsSnackBar", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PromptFragment extends BaseFragment<FragmentPromptBinding> {
    private static final String KEY_PROMPT_TYPE = "key_prompt_type";
    private final View.OnClickListener clickListener;
    private final ActivityResultLauncher<String[]> permissionForActivityResult;
    private PromptType promptType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String TAG = "PromptFragment";

    /* compiled from: PromptFragment.kt */
    @Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PromptType.values().length];
            try {
                iArr[PromptType.PROMPT_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PromptType.PROMPT_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PromptType.PROMPT_BLUET0OTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PromptType.PROMPT_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PromptType.PROMPT_NO_DEVICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PromptType.PROMPT_WIFI3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PromptType.PROMPT_SKIP_UPDATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PromptFragment() {
        super(C0624R.layout.fragment_prompt);
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bedjet.bedjet.ui.prompt.PromptFragment$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PromptFragment.permissionForActivityResult$lambda$2(PromptFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionForActivityResult = registerForActivityResult;
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.prompt.PromptFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromptFragment.clickListener$lambda$3(PromptFragment.this, view);
            }
        };
    }

    /* compiled from: PromptFragment.kt */
    @Metadata(m942d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m943d2 = {"Lcom/bedjet/bedjet/ui/prompt/PromptFragment$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "KEY_PROMPT_TYPE", "newInstance", "Lcom/bedjet/bedjet/ui/prompt/PromptFragment;", "promptType", "Lcom/bedjet/bedjet/ui/prompt/PromptType;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PromptFragment newInstance(PromptType promptType) {
            Intrinsics.checkNotNullParameter(promptType, "promptType");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.m950to(PromptFragment.KEY_PROMPT_TYPE, promptType));
            PromptFragment promptFragment = new PromptFragment();
            promptFragment.setArguments(bundleOf);
            return promptFragment;
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        PromptType promptType;
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (promptType = (PromptType) arguments.getParcelable(KEY_PROMPT_TYPE)) == null) {
            throw new IllegalArgumentException();
        }
        this.promptType = promptType;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        PromptType promptType2 = this.promptType;
        PromptType promptType3 = null;
        if (promptType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptType");
            promptType2 = null;
        }
        LoggerKt.logTag(TAG2, "promptType = " + promptType2);
        getBinding().setClickListener(this.clickListener);
        PromptType promptType4 = this.promptType;
        if (promptType4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptType");
        } else {
            promptType3 = promptType4;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[promptType3.ordinal()]) {
            case 1:
                getBinding().promptTitle.setText(C0624R.string.prompt_update_title);
                getBinding().promptBody.setText(C0624R.string.prompt_update_body);
                getBinding().secondButton.setVisibility(0);
                getBinding().promptButton.setText(C0624R.string.prompt_update_skip);
                return;
            case 2:
                getBinding().promptTitle.setText(C0624R.string.prompt_setup_title);
                getBinding().promptBody.setText(C0624R.string.prompt_setup_body);
                getBinding().promptButton.setText(C0624R.string.prompt_setup_button);
                return;
            case 3:
                getBinding().promptTitle.setText(C0624R.string.prompt_bluetooth_title);
                if (Build.VERSION.SDK_INT >= 31) {
                    i = C0624R.string.prompt_bluetooth_body_android_12;
                } else {
                    i = C0624R.string.prompt_bluetooth_body_android_11;
                }
                getBinding().promptBody.setText(i);
                getBinding().promptButton.setText(C0624R.string.prompt_bluetooth_button);
                return;
            case 4:
                getBinding().promptTitle.setText(C0624R.string.prompt_wifi_setup_title);
                getBinding().promptBody.setText(C0624R.string.prompt_wifi_setup_body);
                getBinding().promptButton.setText(C0624R.string.prompt_wifi_button);
                return;
            case 5:
                getBinding().promptTitle.setText(C0624R.string.prompt_no_device_title);
                getBinding().promptBody.setText(C0624R.string.prompt_no_device_body);
                getBinding().promptButton.setText(C0624R.string.prompt_wifi_button);
                return;
            case 6:
                getBinding().promptTitle.setText(C0624R.string.prompt_wifi_setup_3_title);
                getBinding().promptBody.setText(C0624R.string.prompt_wifi_setup_3_body);
                getBinding().promptButton.setText(C0624R.string.prompt_wifi_button);
                return;
            case 7:
                getBinding().promptTitle.setText(C0624R.string.prompt_skip_update_title);
                getBinding().promptBody.setText(C0624R.string.prompt_skip_update_body);
                getBinding().promptButton.setText(C0624R.string.prompt_skip_update_button);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
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

    private final void onButton2Pressed() {
        getNavigator().showPromptFragment(PromptType.PROMPT_WIFI);
    }

    private final void onButtonPressed() {
        PromptType promptType = this.promptType;
        if (promptType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptType");
            promptType = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[promptType.ordinal()]) {
            case 1:
                getNavigator().showPromptFragment(PromptType.PROMPT_SKIP_UPDATE);
                return;
            case 2:
                getNavigator().showSetupV3Fragment();
                return;
            case 3:
                Context context = getBinding().getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (permissions.hasPermissions(context)) {
                    getNavigator().showBluetoothFragment(3);
                    return;
                } else {
                    this.permissionForActivityResult.launch(permissions.getPermissionScope());
                    return;
                }
            case 4:
                getNavigator().showWifiPermissionFragment();
                return;
            case 5:
            case 7:
                getMainActivity().setResumeFlag(ResumeFlag.RESUME_EXIT);
                getNavigator().showStoredDeviceFragment(6);
                return;
            case 6:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionForActivityResult$lambda$2(PromptFragment promptFragment, Map map) {
        Intrinsics.checkNotNull(map);
        ArrayList arrayList = new ArrayList(map.size());
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Boolean bool = (Boolean) ((Map.Entry) it.next()).getValue();
            bool.booleanValue();
            arrayList.add(bool);
        }
        ArrayList arrayList2 = arrayList;
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (!((Boolean) it2.next()).booleanValue()) {
                    promptFragment.showSettingsSnackBar();
                    return;
                }
            }
        }
        promptFragment.getNavigator().showBluetoothFragment(4);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        PromptType promptType = this.promptType;
        if (promptType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptType");
            promptType = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[promptType.ordinal()];
        if (i == 3) {
            return true;
        }
        if (i != 4) {
            if (i == 7) {
                getNavigator().showPromptFragment(PromptType.PROMPT_UPDATE);
                return false;
            }
            getNavigator().showStoredDeviceFragment(8);
            return false;
        }
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "going back from WiFi prompt");
        if (getMainActivity().getNeedUpdate() || getMainActivity().getNeedSetup()) {
            getNavigator().showStoredDeviceFragment(7);
            return false;
        }
        getNavigator().showMenuFragment();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$3(PromptFragment promptFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C0624R.id.promptButton) {
            promptFragment.onButtonPressed();
        } else if (id == C0624R.id.secondButton) {
            promptFragment.onButton2Pressed();
        }
    }

    private final void showSettingsSnackBar() {
        Snackbar make = Snackbar.make(getBinding().getRoot(), C0624R.string.permissions_error, 0);
        make.setAction(C0624R.string.permissions_settings, new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.prompt.PromptFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromptFragment.showSettingsSnackBar$lambda$6$lambda$5(PromptFragment.this, view);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSettingsSnackBar$lambda$6$lambda$5(PromptFragment promptFragment, View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
        promptFragment.startActivity(intent);
    }
}
