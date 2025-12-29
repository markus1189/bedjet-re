package org.koin.androidx.scope;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

/* compiled from: FragmentExt.kt */
@Metadata(m942d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0001\u001a\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\u001e\u0010\u000f\u001a\u0002H\u0010\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0004\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, m943d2 = {"scopeActivity", "Lorg/koin/androidx/scope/ScopeActivity;", "Landroidx/fragment/app/Fragment;", "getScopeActivity", "(Landroidx/fragment/app/Fragment;)Lorg/koin/androidx/scope/ScopeActivity;", "createFragmentScope", "Lorg/koin/core/scope/Scope;", "useParentActivityScope", "", "createScope", FirebaseAnalytics.Param.SOURCE, "", "fragmentScope", "Lkotlin/Lazy;", "getScopeOrNull", "requireScopeActivity", "T", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FragmentExtKt {
    public static /* synthetic */ Scope createFragmentScope$default(Fragment fragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return createFragmentScope(fragment, z);
    }

    public static final Scope createFragmentScope(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (!(fragment instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Fragment should implement AndroidScopeComponent".toString());
        }
        Fragment fragment2 = fragment;
        Scope scopeOrNull = ComponentCallbackExtKt.getKoin(fragment2).getScopeOrNull(KoinScopeComponentKt.getScopeId(fragment));
        if (scopeOrNull == null) {
            scopeOrNull = ComponentActivityExtKt.createScopeForCurrentLifecycle(fragment2, fragment);
        }
        if (z) {
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            Scope scopeOrNull2 = ComponentActivityExtKt.getScopeOrNull(requireActivity);
            if (scopeOrNull2 != null) {
                scopeOrNull.linkTo(scopeOrNull2);
            } else {
                scopeOrNull.getLogger().debug("Fragment '" + fragment + "' can't be linked to parent activity scope");
            }
        }
        return scopeOrNull;
    }

    public static final Lazy<Scope> fragmentScope(final Fragment fragment, final boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return LazyKt.lazy(new Function0<Scope>() { // from class: org.koin.androidx.scope.FragmentExtKt$fragmentScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Scope invoke() {
                return FragmentExtKt.createFragmentScope(Fragment.this, z);
            }
        });
    }

    public static /* synthetic */ Lazy fragmentScope$default(Fragment fragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return fragmentScope(fragment, z);
    }

    @Deprecated(message = "Unused Internal API")
    public static final Scope createScope(Fragment fragment, Object obj) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return ComponentCallbackExtKt.getKoin(fragment).createScope(KoinScopeComponentKt.getScopeId(fragment), KoinScopeComponentKt.getScopeName(fragment), obj);
    }

    public static /* synthetic */ Scope createScope$default(Fragment fragment, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(fragment, obj);
    }

    public static final Scope getScopeOrNull(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return ComponentCallbackExtKt.getKoin(fragment).getScopeOrNull(KoinScopeComponentKt.getScopeId(fragment));
    }

    public static final ScopeActivity getScopeActivity(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        if (activity instanceof ScopeActivity) {
            return (ScopeActivity) activity;
        }
        return null;
    }

    public static final /* synthetic */ <T extends ScopeActivity> T requireScopeActivity(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        Intrinsics.reifiedOperationMarker(2, "T");
        T t = (T) activity;
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder("can't get ScopeActivity for class ");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(Reflection.getOrCreateKotlinClass(ScopeActivity.class));
        throw new IllegalStateException(sb.toString().toString());
    }
}
