package org.koin.androidx.viewmodel;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.androidx.viewmodel.factory.KoinViewModelFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: GetViewModel.kt */
@Metadata(m942d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0001\u001at\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH\u0007\u001am\u0010\u0014\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0015H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, m943d2 = {"getViewModelKey", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "scope", "Lorg/koin/core/scope/Scope;", "key", "lazyResolveViewModel", "Lkotlin/Lazy;", "T", "Landroidx/lifecycle/ViewModel;", "vmClass", "Lkotlin/reflect/KClass;", "viewModelStore", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "resolveViewModel", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/ViewModelStore;Ljava/lang/String;Landroidx/lifecycle/viewmodel/CreationExtras;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class GetViewModelKt {
    public static final <T extends ViewModel> T resolveViewModel(KClass<T> vmClass, ViewModelStore viewModelStore, String str, CreationExtras extras, Qualifier qualifier, Scope scope, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(vmClass, "vmClass");
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Class<T> javaClass = JvmClassMapping.getJavaClass((KClass) vmClass);
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, new KoinViewModelFactory(vmClass, scope, qualifier, function0), extras);
        String viewModelKey = getViewModelKey(qualifier, scope, str);
        if (viewModelKey != null) {
            return (T) viewModelProvider.get(viewModelKey, javaClass);
        }
        return (T) viewModelProvider.get(javaClass);
    }

    public static final String getViewModelKey(Qualifier qualifier, Scope scope, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (qualifier == null && str == null && scope.getIsRoot()) {
            return null;
        }
        if (qualifier == null || (str2 = qualifier.getValue()) == null) {
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        return str2 + str + (scope.getIsRoot() ? "" : scope.getId());
    }

    public static final <T extends ViewModel> Lazy<T> lazyResolveViewModel(final KClass<T> vmClass, final Function0<? extends ViewModelStore> viewModelStore, final String str, final Function0<? extends CreationExtras> extras, final Qualifier qualifier, final Scope scope, final Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(vmClass, "vmClass");
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: org.koin.androidx.viewmodel.GetViewModelKt$lazyResolveViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModel invoke() {
                return GetViewModelKt.resolveViewModel(vmClass, viewModelStore.invoke(), str, extras.invoke(), qualifier, scope, function0);
            }
        });
    }
}
