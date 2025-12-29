package org.koin.androidx.fragment.koin;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.androidx.fragment.android.KoinFragmentFactory;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSL;

/* compiled from: KoinApplicationExt.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m943d2 = {"fragmentFactoryModule", "Lorg/koin/core/module/Module;", "fragmentFactory", "", "Lorg/koin/core/KoinApplication;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class KoinApplicationExtKt {
    private static final Module fragmentFactoryModule = ModuleDSL.module$default(false, new Function1<Module, Unit>() { // from class: org.koin.androidx.fragment.koin.KoinApplicationExtKt$fragmentFactoryModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C16681 c16681 = new Function2<Scope, ParametersHolder, FragmentFactory>() { // from class: org.koin.androidx.fragment.koin.KoinApplicationExtKt$fragmentFactoryModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final FragmentFactory invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new KoinFragmentFactory(null, 1, 0 == true ? 1 : 0);
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FragmentFactory.class), null, c16681, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }
    }, 1, null);

    public static final void fragmentFactory(KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt.listOf(fragmentFactoryModule), false, false, 6, null);
    }
}
