package org.koin.androidx.viewmodel.dsl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.dsl.ScopeDSL;

/* compiled from: ScopeSetExt.kt */
@Metadata(m942d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062)\b\b\u0010\u0007\u001a#\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\bj\b\u0012\u0004\u0012\u0002H\u0002`\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, m943d2 = {"viewModel", "Lorg/koin/core/definition/KoinDefinition;", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/dsl/ScopeDSL;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ScopeSetExtKt {
    public static /* synthetic */ KoinDefinition viewModel$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 definition, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    public static /* synthetic */ KoinDefinition viewModel$default(ScopeDSL scopeDSL, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$viewModel$1 scopeSetExtKt$viewModel$1 = ScopeSetExtKt$viewModel$1.INSTANCE;
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, scopeSetExtKt$viewModel$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    @KoinReflectAPI
    public static final /* synthetic */ <T extends ViewModel> KoinDefinition<T> viewModel(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$viewModel$1 scopeSetExtKt$viewModel$1 = ScopeSetExtKt$viewModel$1.INSTANCE;
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scopeSetExtKt$viewModel$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <T extends ViewModel> KoinDefinition<T> viewModel(ScopeDSL scopeDSL, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(module, factoryInstanceFactory);
    }
}
