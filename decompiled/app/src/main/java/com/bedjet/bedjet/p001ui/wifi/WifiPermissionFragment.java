package com.bedjet.bedjet.p001ui.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bedjet.bedjet.BuildConfig;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: WifiPermissionFragment.kt */
@Metadata(m942d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u000b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m943d2 = {"Lcom/bedjet/bedjet/ui/wifi/WifiPermissionFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentWifiPermissionBinding;", "<init>", "()V", "permissions", "", "", "[Ljava/lang/String;", "permissionForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasPermissions", "", "context", "Landroid/content/Context;", "onResume", "onPause", "showSettingsSnackBar", "clickListener", "Landroid/view/View$OnClickListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WifiPermissionFragment extends BaseFragment<FragmentWifiPermissionBinding> {
    private final View.OnClickListener clickListener;
    private final ActivityResultLauncher<String[]> permissionForActivityResult;
    private final String[] permissions;

    public WifiPermissionFragment() {
        super(C0624R.layout.fragment_wifi_permission);
        this.permissions = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                WifiPermissionFragment.permissionForActivityResult$lambda$2(WifiPermissionFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionForActivityResult = registerForActivityResult;
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiPermissionFragment.clickListener$lambda$6(WifiPermissionFragment.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionForActivityResult$lambda$2(WifiPermissionFragment wifiPermissionFragment, Map map) {
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
                    wifiPermissionFragment.showSettingsSnackBar();
                    wifiPermissionFragment.getBinding().btnOk.setVisibility(8);
                    wifiPermissionFragment.getBinding().btnSkip.setVisibility(0);
                    return;
                }
            }
        }
        wifiPermissionFragment.getNavigator().showWifiFragment();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setClickListener(this.clickListener);
        getBinding().executePendingBindings();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new WifiPermissionFragment$onViewCreated$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.bedjet.bedjet.p001ui.wifi.WifiPermissionFragment$start$1
            if (r0 == 0) goto L14
            r0 = r7
            com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$start$1 r0 = (com.bedjet.bedjet.p001ui.wifi.WifiPermissionFragment$start$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$start$1 r0 = new com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$start$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 8
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.L$0
            com.bedjet.bedjet.ui.wifi.WifiPermissionFragment r0 = (com.bedjet.bedjet.p001ui.wifi.WifiPermissionFragment) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L76
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.databinding.ViewDataBinding r7 = r6.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            android.widget.ProgressBar r7 = r7.progressBar
            r7.setVisibility(r4)
            androidx.databinding.ViewDataBinding r7 = r6.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            androidx.constraintlayout.widget.Group r7 = r7.visibilityGroup
            r7.setVisibility(r5)
            androidx.databinding.ViewDataBinding r7 = r6.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            com.google.android.material.button.MaterialButton r7 = r7.btnOk
            r7.setVisibility(r5)
            androidx.databinding.ViewDataBinding r7 = r6.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            com.google.android.material.button.MaterialButton r7 = r7.btnSkip
            r7.setVisibility(r5)
            r0.L$0 = r6
            r0.label = r3
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r7 != r1) goto L75
            return r1
        L75:
            r0 = r6
        L76:
            android.content.Context r7 = r0.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            boolean r7 = r0.hasPermissions(r7)
            if (r7 == 0) goto L8f
            com.bedjet.bedjet.ui.main.MainActivity r7 = r0.getMainActivity()
            r7.showWifiFragment()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L8f:
            androidx.databinding.ViewDataBinding r7 = r0.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            android.widget.ProgressBar r7 = r7.progressBar
            r7.setVisibility(r5)
            androidx.databinding.ViewDataBinding r7 = r0.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            androidx.constraintlayout.widget.Group r7 = r7.visibilityGroup
            r7.setVisibility(r4)
            androidx.databinding.ViewDataBinding r7 = r0.getBinding()
            com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding r7 = (com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding) r7
            com.google.android.material.button.MaterialButton r7 = r7.btnOk
            r7.setVisibility(r4)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.p001ui.wifi.WifiPermissionFragment.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean hasPermissions(Context context) {
        for (String str : this.permissions) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
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

    private final void showSettingsSnackBar() {
        Snackbar make = Snackbar.make(getBinding().getRoot(), C0624R.string.permissions_error, 0);
        make.setAction(C0624R.string.permissions_settings, new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.wifi.WifiPermissionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiPermissionFragment.showSettingsSnackBar$lambda$5$lambda$4(WifiPermissionFragment.this, view);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSettingsSnackBar$lambda$5$lambda$4(WifiPermissionFragment wifiPermissionFragment, View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
        wifiPermissionFragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$6(WifiPermissionFragment wifiPermissionFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == C0624R.id.btnSkip) {
            wifiPermissionFragment.getMainActivity().showWifiFragment();
        } else if (id == C0624R.id.btnCancel) {
            wifiPermissionFragment.getMainActivity().showConnectionFragment(16);
        } else if (id == C0624R.id.btnOk) {
            wifiPermissionFragment.permissionForActivityResult.launch(wifiPermissionFragment.permissions);
        }
    }
}
