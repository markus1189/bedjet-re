package org.koin.dsl;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.koin.core.KoinApplication;
import org.koin.core.module.KoinApplicationDslMarker;

/* compiled from: KoinApplication.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032!\b\u0002\u0010\u0004\u001a\u001b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\b\bH\u0007*,\u0010\t\"\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\b2\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\b¨\u0006\n"}, m943d2 = {"koinApplication", "Lorg/koin/core/KoinApplication;", "createEagerInstances", "", "appDeclaration", "Lkotlin/Function1;", "", "Lorg/koin/dsl/KoinAppDeclaration;", "Lkotlin/ExtensionFunctionType;", "KoinAppDeclaration", "koin-core"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class KoinApplicationKt {
    public static /* synthetic */ KoinApplication koinApplication$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return koinApplication(z, function1);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication koinApplication(boolean z, Function1<? super KoinApplication, Unit> function1) {
        KoinApplication init = KoinApplication.INSTANCE.init();
        if (function1 != null) {
            function1.invoke(init);
        }
        if (z) {
            init.createEagerInstances();
        }
        return init;
    }
}
