package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.instance.InstanceBuilderKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ModuleExt.kt */
@Metadata(m942d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m943d2 = {"<anonymous>", "T", "Landroidx/fragment/app/Fragment;", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Landroidx/fragment/app/Fragment;"}, m944k = 3, m945mv = {1, 9, 0}, m947xi = 176)
/* loaded from: classes2.dex */
public final class ModuleExtKt$fragment$1<T> extends Lambda implements Function2<Scope, ParametersHolder, T> {
    public static final ModuleExtKt$fragment$1 INSTANCE;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new ModuleExtKt$fragment$1();
    }

    public ModuleExtKt$fragment$1() {
        super(2);
    }

    /* JADX WARN: Incorrect return type in method signature: (Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)TT; */
    @Override // kotlin.jvm.functions.Function2
    public final Fragment invoke(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (Fragment) InstanceBuilderKt.newInstance(factory, Reflection.getOrCreateKotlinClass(Object.class), it);
    }
}
