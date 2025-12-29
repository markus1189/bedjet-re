package org.koin.android.ext.android;

import android.content.ComponentCallbacks;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

/* compiled from: AndroidKoinScopeExt.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m943d2 = {"getKoinScope", "Lorg/koin/core/scope/Scope;", "Landroid/content/ComponentCallbacks;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: org.koin.android.ext.android.AndroidKoinScopeExtKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AndroidKoinScopeExt {
    public static final Scope getKoinScope(ComponentCallbacks componentCallbacks) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "<this>");
        return componentCallbacks instanceof AndroidScopeComponent ? ((AndroidScopeComponent) componentCallbacks).getScope() : componentCallbacks instanceof KoinScopeComponent ? ((KoinScopeComponent) componentCallbacks).getScope() : componentCallbacks instanceof KoinComponent ? ((KoinComponent) componentCallbacks).getKoin().getScopeRegistry().getRootScope() : GlobalContext.INSTANCE.get().getScopeRegistry().getRootScope();
    }
}
