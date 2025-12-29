package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewModelLazy.kt */
@Metadata(m942d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0080\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rj\u0004\u0018\u0001`\u0014H\u0007\u001a|\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rj\u0004\u0018\u0001`\u0014H\u0007\u001a\u0082\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00172\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rj\u0004\u0018\u0001`\u0014H\u0007¨\u0006\u0018"}, m943d2 = {"getLazyViewModelForClass", "Lkotlin/Lazy;", "T", "Landroidx/lifecycle/ViewModel;", "clazz", "Lkotlin/reflect/KClass;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "scope", "Lorg/koin/core/scope/Scope;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "key", "", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "viewModelForClass", "Landroidx/activity/ComponentActivity;", "Landroidx/fragment/app/Fragment;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ViewModelLazyKt {
    public static final <T extends ViewModel> Lazy<T> viewModelForClass(final ComponentActivity componentActivity, final KClass<T> clazz, final Qualifier qualifier, final ViewModelStoreOwner owner, final Function0<Bundle> function0, final String str, final Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(owner, "owner");
        final ViewModelStore viewModelStore = owner.getViewModelStore();
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: org.koin.androidx.viewmodel.ext.android.ViewModelLazyKt$viewModelForClass$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModel invoke() {
                CreationExtras.Empty empty;
                Bundle invoke;
                Function0<Bundle> function03 = function0;
                if (function03 == null || (invoke = function03.invoke()) == null || (empty = BundleExt.toExtras(invoke, owner)) == null) {
                    empty = CreationExtras.Empty.INSTANCE;
                }
                return GetViewModelKt.resolveViewModel(clazz, viewModelStore, str, empty, qualifier, AndroidKoinScopeExt.getKoinScope(componentActivity), function02);
            }
        });
    }

    public static final <T extends ViewModel> Lazy<T> viewModelForClass(final Fragment fragment, final KClass<T> clazz, final Qualifier qualifier, final Function0<? extends ViewModelStoreOwner> owner, final Function0<Bundle> function0, final String str, final Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(owner, "owner");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: org.koin.androidx.viewmodel.ext.android.ViewModelLazyKt$viewModelForClass$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModel invoke() {
                CreationExtras.Empty empty;
                Bundle invoke;
                ViewModelStoreOwner invoke2 = owner.invoke();
                ViewModelStore viewModelStore = invoke2.getViewModelStore();
                Function0<Bundle> function03 = function0;
                if (function03 == null || (invoke = function03.invoke()) == null || (empty = BundleExt.toExtras(invoke, invoke2)) == null) {
                    empty = CreationExtras.Empty.INSTANCE;
                }
                return GetViewModelKt.resolveViewModel(clazz, viewModelStore, str, empty, qualifier, AndroidKoinScopeExt.getKoinScope(fragment), function02);
            }
        });
    }

    public static /* synthetic */ Lazy getLazyViewModelForClass$default(KClass kClass, ViewModelStoreOwner viewModelStoreOwner, Scope scope, Qualifier qualifier, Function0 function0, String str, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            scope = GlobalContext.INSTANCE.get().getScopeRegistry().getRootScope();
        }
        return getLazyViewModelForClass(kClass, viewModelStoreOwner, scope, (i & 8) != 0 ? null : qualifier, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : function02);
    }

    public static final <T extends ViewModel> Lazy<T> getLazyViewModelForClass(final KClass<T> clazz, final ViewModelStoreOwner owner, final Scope scope, final Qualifier qualifier, final Function0<Bundle> function0, final String str, final Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final ViewModelStore viewModelStore = owner.getViewModelStore();
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: org.koin.androidx.viewmodel.ext.android.ViewModelLazyKt$getLazyViewModelForClass$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModel invoke() {
                CreationExtras.Empty empty;
                Bundle invoke;
                Function0<Bundle> function03 = function0;
                if (function03 == null || (invoke = function03.invoke()) == null || (empty = BundleExt.toExtras(invoke, owner)) == null) {
                    empty = CreationExtras.Empty.INSTANCE;
                }
                return GetViewModelKt.resolveViewModel(clazz, viewModelStore, str, empty, qualifier, scope, function02);
            }
        });
    }
}
