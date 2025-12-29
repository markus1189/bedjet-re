package org.koin.core.context;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;

/* compiled from: KoinContext.kt */
@Metadata(m942d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J \u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J%\u0010\r\u001a\u00020\u000e2\u001b\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u0012¢\u0006\u0002\b\u0013H&J\b\u0010\u0014\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH&¨\u0006\u0016"}, m943d2 = {"Lorg/koin/core/context/KoinContext;", "", "get", "Lorg/koin/core/Koin;", "getOrNull", "loadKoinModules", "", "modules", "", "Lorg/koin/core/module/Module;", "createEagerInstances", "", "module", "startKoin", "Lorg/koin/core/KoinApplication;", "koinApplication", "appDeclaration", "Lkotlin/Function1;", "Lorg/koin/dsl/KoinAppDeclaration;", "Lkotlin/ExtensionFunctionType;", "stopKoin", "unloadKoinModules", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface KoinContext {
    Koin get();

    Koin getOrNull();

    void loadKoinModules(List<Module> modules, boolean createEagerInstances);

    void loadKoinModules(Module module, boolean createEagerInstances);

    KoinApplication startKoin(Function1<? super KoinApplication, Unit> appDeclaration);

    KoinApplication startKoin(KoinApplication koinApplication);

    void stopKoin();

    void unloadKoinModules(List<Module> modules);

    void unloadKoinModules(Module module);

    /* compiled from: KoinContext.kt */
    @Metadata(m944k = 3, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void loadKoinModules$default(KoinContext koinContext, Module module, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadKoinModules");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            koinContext.loadKoinModules(module, z);
        }

        public static /* synthetic */ void loadKoinModules$default(KoinContext koinContext, List list, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadKoinModules");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            koinContext.loadKoinModules((List<Module>) list, z);
        }
    }
}
