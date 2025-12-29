package com.bedjet.bedjet.arch;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bedjet.bedjet.data.local.model.legacy.RunningStatusV2;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.p001ui.main.RenameType;
import com.bedjet.bedjet.utils.FirebaseTracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: BaseFragment.kt */
@Metadata(m942d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010&\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020+H\u0016J\b\u00105\u001a\u00020+H\u0016J\b\u00106\u001a\u00020+H\u0016J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u0005H\u0004J\b\u00109\u001a\u00020+H\u0016J\b\u0010:\u001a\u00020+H\u0016J\b\u0010;\u001a\u00020+H\u0016J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020+H\u0016J\b\u0010C\u001a\u00020+H\u0016J\u001a\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010I\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010J\u001a\u00020+H\u0016J\u001c\u0010K\u001a\u00020+2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010N\u001a\u00020+H\u0016R\u001c\u0010\b\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006O"}, m943d2 = {"Lcom/bedjet/bedjet/arch/BaseFragment;", "ViewBinding", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "layoutId", "", "<init>", "(I)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "mainActivity", "Lcom/bedjet/bedjet/ui/main/MainActivity;", "getMainActivity", "()Lcom/bedjet/bedjet/ui/main/MainActivity;", "setMainActivity", "(Lcom/bedjet/bedjet/ui/main/MainActivity;)V", "navigator", "Lcom/bedjet/bedjet/arch/FragmentNavigator;", "getNavigator", "()Lcom/bedjet/bedjet/arch/FragmentNavigator;", "setNavigator", "(Lcom/bedjet/bedjet/arch/FragmentNavigator;)V", "controller", "Lcom/bedjet/bedjet/arch/FragmentController;", "getController", "()Lcom/bedjet/bedjet/arch/FragmentController;", "setController", "(Lcom/bedjet/bedjet/arch/FragmentController;)V", "firebaseTracker", "Lcom/bedjet/bedjet/utils/FirebaseTracker;", "getFirebaseTracker", "()Lcom/bedjet/bedjet/utils/FirebaseTracker;", "firebaseTracker$delegate", "Lkotlin/Lazy;", "getBindingVariable", "()Ljava/lang/Integer;", "isCanGoBack", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onAttach", "context", "Landroid/content/Context;", "onResume", "onPause", "onDestroy", "sendBedJetButton", "commandValue", "gattDisconnected", "bedJetConnected", "updateDisplay", "renderNormal", "newStatus", "Lcom/bedjet/bedjet/data/local/model/legacy/RunningStatusV2;", "biodataAvailable", "data", "", "biodataWritten", "noBiodata", "nameSet", "renameType", "Lcom/bedjet/bedjet/ui/main/RenameType;", "newName", "", "deviceNameRead", "setupV3Finished", "readAvailable", "fromCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "gattEnumerated", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class BaseFragment<ViewBinding extends ViewDataBinding> extends Fragment {
    protected ViewBinding binding;
    protected FragmentController controller;

    /* renamed from: firebaseTracker$delegate, reason: from kotlin metadata */
    private final Lazy firebaseTracker;
    protected MainActivity mainActivity;
    protected FragmentNavigator navigator;

    public void bedJetConnected() {
    }

    public void biodataAvailable(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void biodataWritten() {
    }

    public void deviceNameRead(String newName) {
    }

    public void gattEnumerated() {
    }

    protected Integer getBindingVariable() {
        return null;
    }

    public boolean isCanGoBack() {
        return true;
    }

    public void nameSet(RenameType renameType, String newName) {
        Intrinsics.checkNotNullParameter(renameType, "renameType");
    }

    public void noBiodata() {
    }

    public void readAvailable(BluetoothGattCharacteristic fromCharacteristic, byte[] data) {
    }

    public void renderNormal(RunningStatusV2 newStatus) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
    }

    public void setupV3Finished() {
    }

    public void updateDisplay() {
    }

    public BaseFragment(int i) {
        super(i);
        final BaseFragment<ViewBinding> baseFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.firebaseTracker = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FirebaseTracker>() { // from class: com.bedjet.bedjet.arch.BaseFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.utils.FirebaseTracker] */
            @Override // kotlin.jvm.functions.Function0
            public final FirebaseTracker invoke() {
                ComponentCallbacks componentCallbacks = baseFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FirebaseTracker.class), qualifier, b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewBinding getBinding() {
        ViewBinding viewbinding = this.binding;
        if (viewbinding != null) {
            return viewbinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    protected final void setBinding(ViewBinding viewbinding) {
        Intrinsics.checkNotNullParameter(viewbinding, "<set-?>");
        this.binding = viewbinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MainActivity getMainActivity() {
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            return mainActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        return null;
    }

    protected final void setMainActivity(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "<set-?>");
        this.mainActivity = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentNavigator getNavigator() {
        FragmentNavigator fragmentNavigator = this.navigator;
        if (fragmentNavigator != null) {
            return fragmentNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    protected final void setNavigator(FragmentNavigator fragmentNavigator) {
        Intrinsics.checkNotNullParameter(fragmentNavigator, "<set-?>");
        this.navigator = fragmentNavigator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentController getController() {
        FragmentController fragmentController = this.controller;
        if (fragmentController != null) {
            return fragmentController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        return null;
    }

    protected final void setController(FragmentController fragmentController) {
        Intrinsics.checkNotNullParameter(fragmentController, "<set-?>");
        this.controller = fragmentController;
    }

    private final FirebaseTracker getFirebaseTracker() {
        return (FirebaseTracker) this.firebaseTracker.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseTracker firebaseTracker = getFirebaseTracker();
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        firebaseTracker.trackScreen(simpleName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LoggerKt.log(getClass().getSimpleName() + ".onViewCreated called");
        ViewDataBinding bind = DataBindingUtil.bind(view);
        if (bind == null) {
            throw new IllegalStateException("Check xml for fragment: " + getClass());
        }
        setBinding(bind);
        getBinding().executePendingBindings();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.bedjet.bedjet.ui.main.MainActivity");
        setMainActivity((MainActivity) activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentNavigator fragmentNavigator = context instanceof FragmentNavigator ? (FragmentNavigator) context : null;
        if (fragmentNavigator == null) {
            throw new ClassCastException("Activity should implement fragment interface");
        }
        setNavigator(fragmentNavigator);
        FragmentController fragmentController = context instanceof FragmentController ? (FragmentController) context : null;
        if (fragmentController == null) {
            throw new ClassCastException("Activity should implement fragment interface");
        }
        setController(fragmentController);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LoggerKt.log(getClass().getSimpleName() + ".onResume called");
        Integer bindingVariable = getBindingVariable();
        if (bindingVariable != null) {
            getBinding().setVariable(bindingVariable.intValue(), this);
            getBinding().executePendingBindings();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LoggerKt.log(getClass().getSimpleName() + ".onPause called");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LoggerKt.log(getClass().getSimpleName() + ".onDestroy called");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sendBedJetButton(int commandValue) {
        getMainActivity().sendBedJetButton(commandValue);
    }

    public void gattDisconnected() {
        getNavigator().showStoredDeviceFragment(1);
    }
}
