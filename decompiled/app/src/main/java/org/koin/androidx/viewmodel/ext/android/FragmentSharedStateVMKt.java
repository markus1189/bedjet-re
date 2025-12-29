package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FragmentSharedStateVM.kt */
@Metadata(m942d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aq\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001ai\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\n\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0016\b\n\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001ar\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010H\u0007\u001aj\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0014\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u000e\b\n\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0016\b\n\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, m943d2 = {"getSharedStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "clazz", "Lkotlin/reflect/KClass;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "sharedStateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FragmentSharedStateVMKt {
    public static /* synthetic */ Lazy sharedStateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0 state = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentSharedStateVMKt$sharedStateViewModel$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FragmentActivity invoke() {
                    FragmentActivity requireActivity = Fragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                    return requireActivity;
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
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentSharedStateVMKt$sharedStateViewModel$2(fragment, qualifier2, state, owner, function04));
    }

    @Deprecated(message = "Use Fragment.activityViewModel() with extras: CreationExtras")
    public static final /* synthetic */ <T extends ViewModel> Lazy<T> sharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> state, Function0<? extends ViewModelStoreOwner> owner, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentSharedStateVMKt$sharedStateViewModel$2(fragment, qualifier, state, owner, function0));
    }

    public static /* synthetic */ Lazy sharedStateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, KClass kClass, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0 function04 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentSharedStateVMKt$sharedStateViewModel$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FragmentActivity invoke() {
                    FragmentActivity requireActivity = Fragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                    return requireActivity;
                }
            };
        }
        return sharedStateViewModel(fragment, qualifier2, function04, function02, kClass, (i & 16) != 0 ? null : function03);
    }

    @Deprecated(message = "Use Fragment.activityViewModel() with extras: CreationExtras")
    public static final <T extends ViewModel> Lazy<T> sharedStateViewModel(final Fragment fragment, final Qualifier qualifier, final Function0<Bundle> state, final Function0<? extends ViewModelStoreOwner> owner, final KClass<T> clazz, final Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentSharedStateVMKt$sharedStateViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModel invoke() {
                return FragmentSharedStateVMKt.getSharedStateViewModel(Fragment.this, qualifier, state, owner, clazz, function0);
            }
        });
    }

    public static /* synthetic */ ViewModel getSharedStateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        ViewModel resolveViewModel;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Function0 state = (i & 2) != 0 ? ScopeExtKt.emptyState() : function0;
        Function0 owner = (i & 4) != 0 ? new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentSharedStateVMKt$getSharedStateViewModel$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentActivity invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                return requireActivity;
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

    @Deprecated(message = "Use Fragment.getActivityViewModel() with extras: CreationExtras")
    public static final /* synthetic */ <T extends ViewModel> T getSharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> state, Function0<? extends ViewModelStoreOwner> owner, Function0<? extends ParametersHolder> function0) {
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

    public static /* synthetic */ ViewModel getSharedStateViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, KClass kClass, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0 function04 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentSharedStateVMKt$getSharedStateViewModel$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FragmentActivity invoke() {
                    FragmentActivity requireActivity = Fragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                    return requireActivity;
                }
            };
        }
        return getSharedStateViewModel(fragment, qualifier2, function04, function02, kClass, (i & 16) != 0 ? null : function03);
    }

    @Deprecated(message = "Use Fragment.getActivityViewModel() with extras: CreationExtras")
    public static final <T extends ViewModel> T getSharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> state, Function0<? extends ViewModelStoreOwner> owner, KClass<T> clazz, Function0<? extends ParametersHolder> function0) {
        ViewModel resolveViewModel;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ViewModelStore viewModelStore = owner.invoke().getViewModelStore();
        CreationExtras extras = BundleExt.toExtras(state.invoke(), fragment);
        if (extras == null) {
            extras = fragment.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "<get-defaultViewModelCreationExtras>(...)");
        }
        resolveViewModel = GetViewModelKt.resolveViewModel(clazz, viewModelStore, (r16 & 4) != 0 ? null : null, extras, (r16 & 16) != 0 ? null : qualifier, AndroidKoinScopeExt.getKoinScope(fragment), (r16 & 64) != 0 ? null : function0);
        return (T) resolveViewModel;
    }
}
