package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FragmentStateVM.kt */
@Metadata(m942d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ai\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\n\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aj\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\n\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m943d2 = {"getStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "stateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FragmentStateVMKt {
    public static /* synthetic */ Lazy stateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0 state = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<Fragment>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentStateVMKt$stateViewModel$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        Function0 owner = function02;
        Function0 function04 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentStateVMKt$stateViewModel$2(fragment, qualifier2, state, owner, function04));
    }

    @Deprecated(message = "Use Fragment.viewModel() with extras: CreationExtras")
    public static final /* synthetic */ <T extends ViewModel> Lazy<T> stateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> state, Function0<? extends ViewModelStoreOwner> owner, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentStateVMKt$stateViewModel$2(fragment, qualifier, state, owner, function0));
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        ViewModel resolveViewModel;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Function0 state = (i & 2) != 0 ? ScopeExtKt.emptyState() : function0;
        Function0 owner = (i & 4) != 0 ? new Function0<Fragment>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentStateVMKt$getStateViewModel$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        } : function02;
        Function0 function04 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner.invoke()).getViewModelStore();
        CreationExtras extras = BundleExt.toExtras((Bundle) state.invoke(), fragment);
        if (extras == null) {
            extras = fragment.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "<get-defaultViewModelCreationExtras>(...)");
        }
        Scope koinScope = AndroidKoinScopeExt.getKoinScope(fragment);
        Intrinsics.reifiedOperationMarker(4, "T");
        resolveViewModel = GetViewModelKt.resolveViewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelStore, (r16 & 4) != 0 ? null : null, extras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function04);
        return resolveViewModel;
    }

    @Deprecated(message = "Use Fragment.getViewModel() with extras: CreationExtras")
    public static final /* synthetic */ <T extends ViewModel> T getStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> state, Function0<? extends ViewModelStoreOwner> owner, Function0<? extends ParametersHolder> function0) {
        ViewModel resolveViewModel;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModelStore viewModelStore = owner.invoke().getViewModelStore();
        CreationExtras extras = BundleExt.toExtras(state.invoke(), fragment);
        if (extras == null) {
            extras = fragment.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "<get-defaultViewModelCreationExtras>(...)");
        }
        Scope koinScope = AndroidKoinScopeExt.getKoinScope(fragment);
        Intrinsics.reifiedOperationMarker(4, "T");
        resolveViewModel = GetViewModelKt.resolveViewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelStore, (r16 & 4) != 0 ? null : null, extras, (r16 & 16) != 0 ? null : qualifier, koinScope, (r16 & 64) != 0 ? null : function0);
        return (T) resolveViewModel;
    }
}
