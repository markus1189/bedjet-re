package org.koin.androidx.viewmodel.ext.android;

import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FragmentActivityVM.kt */
@Metadata(m942d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ab\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\n\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aa\u0010\u000e\u001a\u0002H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\n\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m943d2 = {"activityViewModel", "Lkotlin/Lazy;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "ownerProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "getActivityViewModel", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FragmentActivityVMKt {
    public static /* synthetic */ Lazy activityViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentActivityVMKt$activityViewModel$1
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
        Function0 ownerProducer = function0;
        Function0 function04 = (i & 4) != 0 ? null : function02;
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentActivityVMKt$activityViewModel$2(fragment, qualifier2, ownerProducer, function04, function05));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> activityViewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new FragmentActivityVMKt$activityViewModel$2(fragment, qualifier, ownerProducer, function0, function02));
    }

    public static /* synthetic */ ViewModel getActivityViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        CreationExtras creationExtras;
        ViewModel resolveViewModel;
        CreationExtras creationExtras2;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Function0 ownerProducer = (i & 2) != 0 ? new Function0<FragmentActivity>() { // from class: org.koin.androidx.viewmodel.ext.android.FragmentActivityVMKt$getActivityViewModel$1
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
        } : function0;
        Function0 function04 = (i & 4) != 0 ? null : function02;
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) ownerProducer.invoke();
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        if (function04 == null || (creationExtras2 = (CreationExtras) function04.invoke()) == null) {
            ComponentActivity componentActivity = viewModelStoreOwner instanceof ComponentActivity ? (ComponentActivity) viewModelStoreOwner : null;
            CreationExtras defaultViewModelCreationExtras = componentActivity != null ? componentActivity.getDefaultViewModelCreationExtras() : null;
            if (defaultViewModelCreationExtras == null) {
                CreationExtras defaultViewModelCreationExtras2 = fragment.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras2, "<get-defaultViewModelCreationExtras>(...)");
                creationExtras = defaultViewModelCreationExtras2;
            } else {
                creationExtras = defaultViewModelCreationExtras;
            }
        } else {
            creationExtras = creationExtras2;
        }
        Scope koinScope = AndroidKoinScopeExt.getKoinScope(fragment);
        Intrinsics.reifiedOperationMarker(4, "T");
        resolveViewModel = GetViewModelKt.resolveViewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function05);
        return resolveViewModel;
    }

    public static final /* synthetic */ <T extends ViewModel> T getActivityViewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function02) {
        CreationExtras creationExtras;
        CreationExtras invoke;
        ViewModel resolveViewModel;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        ViewModelStoreOwner invoke2 = ownerProducer.invoke();
        ViewModelStore viewModelStore = invoke2.getViewModelStore();
        if (function0 == null || (invoke = function0.invoke()) == null) {
            ComponentActivity componentActivity = invoke2 instanceof ComponentActivity ? (ComponentActivity) invoke2 : null;
            CreationExtras defaultViewModelCreationExtras = componentActivity != null ? componentActivity.getDefaultViewModelCreationExtras() : null;
            if (defaultViewModelCreationExtras == null) {
                CreationExtras defaultViewModelCreationExtras2 = fragment.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras2, "<get-defaultViewModelCreationExtras>(...)");
                creationExtras = defaultViewModelCreationExtras2;
            } else {
                creationExtras = defaultViewModelCreationExtras;
            }
        } else {
            creationExtras = invoke;
        }
        Scope koinScope = AndroidKoinScopeExt.getKoinScope(fragment);
        Intrinsics.reifiedOperationMarker(4, "T");
        resolveViewModel = GetViewModelKt.resolveViewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier, koinScope, (r16 & 64) != 0 ? null : function02);
        return (T) resolveViewModel;
    }
}
