package org.koin.androidx.viewmodel;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.StateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.androidx.viewmodel.factory.DefaultViewModelFactory;
import org.koin.core.scope.Scope;

/* compiled from: ViewModelResolver.kt */
@Metadata(m942d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001a)\u0010\u0007\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, m943d2 = {"pickFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "resolveInstance", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: org.koin.androidx.viewmodel.ViewModelResolverKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewModelResolver {
    @Deprecated(message = "Deprecated API in favor of KoinViewModelFactory")
    public static final <T extends ViewModel> T resolveInstance(ViewModelProvider viewModelProvider, ViewModelParameter<T> viewModelParameters) {
        Intrinsics.checkNotNullParameter(viewModelProvider, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameters, "viewModelParameters");
        Class<T> javaClass = JvmClassMapping.getJavaClass((KClass) viewModelParameters.getClazz());
        if (viewModelParameters.getQualifier() != null) {
            return (T) viewModelProvider.get(viewModelParameters.getQualifier().toString(), javaClass);
        }
        return (T) viewModelProvider.get(javaClass);
    }

    @Deprecated(message = "Deprecated API in favor of KoinViewModelFactory")
    public static final <T extends ViewModel> ViewModelProvider.Factory pickFactory(Scope scope, ViewModelParameter<T> viewModelParameters) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameters, "viewModelParameters");
        return (viewModelParameters.getRegistryOwner() == null || viewModelParameters.getState() == null) ? new DefaultViewModelFactory(scope, viewModelParameters) : new StateViewModelFactory(scope, viewModelParameters);
    }
}
