package com.bedjet.bedjet.p000di;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.helpers.AppReviewHelper;
import com.bedjet.bedjet.p001ui.CustomDialog;
import com.bedjet.bedjet.p001ui.main.p002v2.V2Manager;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.PreferenceStorage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.koin.ModuleExtKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSL;

/* compiled from: di.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m943d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.di.DiKt, reason: use source file name */
/* loaded from: classes.dex */
public final class di {
    private static final Module appModule = ModuleDSL.module$default(false, new Function1() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit appModule$lambda$9;
            appModule$lambda$9 = di.appModule$lambda$9((Module) obj);
            return appModule$lambda$9;
        }
    }, 1, null);

    public static final Module getAppModule() {
        return appModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreferenceStorage appModule$lambda$9$lambda$0(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PreferenceStorage(ModuleExtKt.androidApplication(single));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoredDeviceManager appModule$lambda$9$lambda$1(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StoredDeviceManager((PreferenceStorage) single.get(Reflection.getOrCreateKotlinClass(PreferenceStorage.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TempModeManager appModule$lambda$9$lambda$2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TempModeManager((PreferenceStorage) single.get(Reflection.getOrCreateKotlinClass(PreferenceStorage.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppReviewHelper appModule$lambda$9$lambda$3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AppReviewHelper((PreferenceStorage) single.get(Reflection.getOrCreateKotlinClass(PreferenceStorage.class), null, null), (FirebaseTracker) single.get(Reflection.getOrCreateKotlinClass(FirebaseTracker.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseTracker appModule$lambda$9$lambda$4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FirebaseTracker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStateManager appModule$lambda$9$lambda$5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConnectionStateManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V2Manager appModule$lambda$9$lambda$6(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new V2Manager((BluetoothSearchManager) single.get(Reflection.getOrCreateKotlinClass(BluetoothSearchManager.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BluetoothSearchManager appModule$lambda$9$lambda$7(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BluetoothSearchManager(ModuleExtKt.androidApplication(single));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomDialog appModule$lambda$9$lambda$8(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CustomDialog((FirebaseTracker) single.get(Reflection.getOrCreateKotlinClass(FirebaseTracker.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appModule$lambda$9(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                PreferenceStorage appModule$lambda$9$lambda$0;
                appModule$lambda$9$lambda$0 = di.appModule$lambda$9$lambda$0((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$0;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PreferenceStorage.class), null, function2, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function22 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                StoredDeviceManager appModule$lambda$9$lambda$1;
                appModule$lambda$9$lambda$1 = di.appModule$lambda$9$lambda$1((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$1;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), null, function22, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
        module.indexPrimaryType(singleInstanceFactory4);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function23 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                TempModeManager appModule$lambda$9$lambda$2;
                appModule$lambda$9$lambda$2 = di.appModule$lambda$9$lambda$2((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$2;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TempModeManager.class), null, function23, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
        module.indexPrimaryType(singleInstanceFactory6);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function24 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                AppReviewHelper appModule$lambda$9$lambda$3;
                appModule$lambda$9$lambda$3 = di.appModule$lambda$9$lambda$3((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$3;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AppReviewHelper.class), null, function24, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory8 = singleInstanceFactory7;
        module.indexPrimaryType(singleInstanceFactory8);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function25 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                FirebaseTracker appModule$lambda$9$lambda$4;
                appModule$lambda$9$lambda$4 = di.appModule$lambda$9$lambda$4((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$4;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory9 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FirebaseTracker.class), null, function25, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory10 = singleInstanceFactory9;
        module.indexPrimaryType(singleInstanceFactory10);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function26 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                ConnectionStateManager appModule$lambda$9$lambda$5;
                appModule$lambda$9$lambda$5 = di.appModule$lambda$9$lambda$5((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$5;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory11 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ConnectionStateManager.class), null, function26, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory12 = singleInstanceFactory11;
        module.indexPrimaryType(singleInstanceFactory12);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function27 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                V2Manager appModule$lambda$9$lambda$6;
                appModule$lambda$9$lambda$6 = di.appModule$lambda$9$lambda$6((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$6;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory13 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(V2Manager.class), null, function27, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory14 = singleInstanceFactory13;
        module.indexPrimaryType(singleInstanceFactory14);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function28 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                BluetoothSearchManager appModule$lambda$9$lambda$7;
                appModule$lambda$9$lambda$7 = di.appModule$lambda$9$lambda$7((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$7;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory15 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BluetoothSearchManager.class), null, function28, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory16 = singleInstanceFactory15;
        module.indexPrimaryType(singleInstanceFactory16);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2 function29 = new Function2() { // from class: com.bedjet.bedjet.di.DiKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                CustomDialog appModule$lambda$9$lambda$8;
                appModule$lambda$9$lambda$8 = di.appModule$lambda$9$lambda$8((Scope) obj, (ParametersHolder) obj2);
                return appModule$lambda$9$lambda$8;
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory17 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CustomDialog.class), null, function29, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory18 = singleInstanceFactory17;
        module.indexPrimaryType(singleInstanceFactory18);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory17);
        }
        new KoinDefinition(module, singleInstanceFactory18);
        return Unit.INSTANCE;
    }
}
