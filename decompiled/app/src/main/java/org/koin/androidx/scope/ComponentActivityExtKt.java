package org.koin.androidx.scope;

import android.content.ComponentCallbacks;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeCallback;

/* compiled from: ComponentActivityExt.kt */
@Metadata(m942d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u001a\u0014\u0010\n\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0002*\u00020\u0003\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0000¨\u0006\u0012"}, m943d2 = {"activityRetainedScope", "Lkotlin/Lazy;", "Lorg/koin/core/scope/Scope;", "Landroidx/activity/ComponentActivity;", "activityScope", "createActivityRetainedScope", "createActivityScope", "createScope", FirebaseAnalytics.Param.SOURCE, "", "createScopeForCurrentLifecycle", "Landroid/content/ComponentCallbacks;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getScopeOrNull", "registerScopeForLifecycle", "", "scope", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ComponentActivityExtKt {
    public static final Lazy<Scope> activityScope(final ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return LazyKt.lazy(new Function0<Scope>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$activityScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Scope invoke() {
                return ComponentActivityExtKt.createActivityScope(ComponentActivity.this);
            }
        });
    }

    public static final Lazy<Scope> activityRetainedScope(final ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return LazyKt.lazy(new Function0<Scope>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$activityRetainedScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Scope invoke() {
                return ComponentActivityExtKt.createActivityRetainedScope(ComponentActivity.this);
            }
        });
    }

    public static final Scope createScope(ComponentActivity componentActivity, Object obj) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return ComponentCallbackExtKt.getKoin(componentActivity).createScope(KoinScopeComponentKt.getScopeId(componentActivity), KoinScopeComponentKt.getScopeName(componentActivity), obj);
    }

    public static /* synthetic */ Scope createScope$default(ComponentActivity componentActivity, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(componentActivity, obj);
    }

    public static final Scope getScopeOrNull(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return ComponentCallbackExtKt.getKoin(componentActivity).getScopeOrNull(KoinScopeComponentKt.getScopeId(componentActivity));
    }

    public static final Scope createActivityScope(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (!(componentActivity instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Activity should implement AndroidScopeComponent".toString());
        }
        ComponentActivity componentActivity2 = componentActivity;
        Scope scopeOrNull = ComponentCallbackExtKt.getKoin(componentActivity2).getScopeOrNull(KoinScopeComponentKt.getScopeId(componentActivity));
        return scopeOrNull == null ? createScopeForCurrentLifecycle(componentActivity2, componentActivity) : scopeOrNull;
    }

    public static final Scope createScopeForCurrentLifecycle(ComponentCallbacks componentCallbacks, final LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Scope createScope = ComponentCallbackExtKt.getKoin(componentCallbacks).createScope(KoinScopeComponentKt.getScopeId(componentCallbacks), KoinScopeComponentKt.getScopeName(componentCallbacks), componentCallbacks);
        createScope.registerCallback(new ScopeCallback() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createScopeForCurrentLifecycle$1
            @Override // org.koin.core.scope.ScopeCallback
            public void onScopeClose(Scope scope) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                LifecycleOwner lifecycleOwner = LifecycleOwner.this;
                Intrinsics.checkNotNull(lifecycleOwner, "null cannot be cast to non-null type org.koin.android.scope.AndroidScopeComponent");
                ((AndroidScopeComponent) lifecycleOwner).onCloseScope();
            }
        });
        registerScopeForLifecycle(owner, createScope);
        return createScope;
    }

    public static final void registerScopeForLifecycle(LifecycleOwner lifecycleOwner, final Scope scope) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$registerScopeForLifecycle$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Intrinsics.checkNotNullParameter(owner, "owner");
                Scope.this.close();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Scope createActivityRetainedScope(final ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (!(componentActivity instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Activity should implement AndroidScopeComponent".toString());
        }
        final Function0 function0 = null;
        ScopeHandlerViewModel scopeHandlerViewModel = (ScopeHandlerViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScopeHandlerViewModel.class), new Function0<ViewModelStore>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }).getValue();
        if (scopeHandlerViewModel.getScope() == null) {
            scopeHandlerViewModel.setScope(Koin.createScope$default(ComponentCallbackExtKt.getKoin(componentActivity), KoinScopeComponentKt.getScopeId(componentActivity), KoinScopeComponentKt.getScopeName(componentActivity), null, 4, null));
        }
        Scope scope = scopeHandlerViewModel.getScope();
        Intrinsics.checkNotNull(scope);
        return scope;
    }
}
