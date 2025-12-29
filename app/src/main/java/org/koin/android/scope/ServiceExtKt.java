package org.koin.android.scope;

import android.app.Service;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

/* compiled from: ServiceExt.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n*\u00020\u0002¨\u0006\u000b"}, m943d2 = {"createScope", "Lorg/koin/core/scope/Scope;", "Landroid/app/Service;", FirebaseAnalytics.Param.SOURCE, "", "createServiceScope", "destroyServiceScope", "", "getScopeOrNull", "serviceScope", "Lkotlin/Lazy;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ServiceExtKt {
    public static final Scope createServiceScope(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        if (!(service instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Service should implement AndroidScopeComponent".toString());
        }
        Koin koin = ComponentCallbackExtKt.getKoin(service);
        Scope scopeOrNull = koin.getScopeOrNull(KoinScopeComponentKt.getScopeId(service));
        return scopeOrNull == null ? koin.createScope(KoinScopeComponentKt.getScopeId(service), KoinScopeComponentKt.getScopeName(service), service) : scopeOrNull;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void destroyServiceScope(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        if (!(service instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Service should implement AndroidScopeComponent".toString());
        }
        ((AndroidScopeComponent) service).getScope().close();
    }

    public static final Lazy<Scope> serviceScope(final Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return LazyKt.lazy(new Function0<Scope>() { // from class: org.koin.android.scope.ServiceExtKt$serviceScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Scope invoke() {
                return ServiceExtKt.createServiceScope(service);
            }
        });
    }

    public static final Scope createScope(Service service, Object obj) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return ComponentCallbackExtKt.getKoin(service).createScope(KoinScopeComponentKt.getScopeId(service), KoinScopeComponentKt.getScopeName(service), obj);
    }

    public static /* synthetic */ Scope createScope$default(Service service, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(service, obj);
    }

    public static final Scope getScopeOrNull(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return ComponentCallbackExtKt.getKoin(service).getScopeOrNull(KoinScopeComponentKt.getScopeId(service));
    }
}
