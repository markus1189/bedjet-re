package org.koin.androidx.scope;

import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

/* compiled from: LifecycleViewModelScopeDelegate.kt */
@Metadata(m942d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m943d2 = {"Lorg/koin/androidx/scope/LifecycleViewModelScopeDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/lifecycle/LifecycleOwner;", "Lorg/koin/core/scope/Scope;", "lifecycleOwner", "Landroidx/activity/ComponentActivity;", "koin", "Lorg/koin/core/Koin;", "createScope", "Lkotlin/Function1;", "(Landroidx/activity/ComponentActivity;Lorg/koin/core/Koin;Lkotlin/jvm/functions/Function1;)V", "_scope", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "isActive", "", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class LifecycleViewModelScopeDelegate implements ReadOnlyProperty<LifecycleOwner, Scope> {
    private Scope _scope;
    private final Function1<Koin, Scope> createScope;
    private final Koin koin;
    private final ComponentActivity lifecycleOwner;

    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleViewModelScopeDelegate(final ComponentActivity lifecycleOwner, Koin koin, Function1<? super Koin, Scope> createScope) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(koin, "koin");
        Intrinsics.checkNotNullParameter(createScope, "createScope");
        this.lifecycleOwner = lifecycleOwner;
        this.koin = koin;
        this.createScope = createScope;
        final Function0 function0 = null;
        final ScopeHandlerViewModel scopeHandlerViewModel = (ScopeHandlerViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScopeHandlerViewModel.class), new Function0<ViewModelStore>() { // from class: org.koin.androidx.scope.LifecycleViewModelScopeDelegate$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: org.koin.androidx.scope.LifecycleViewModelScopeDelegate$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: org.koin.androidx.scope.LifecycleViewModelScopeDelegate$special$$inlined$viewModels$default$3
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
                CreationExtras defaultViewModelCreationExtras = lifecycleOwner.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }).getValue();
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: org.koin.androidx.scope.LifecycleViewModelScopeDelegate.2
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner2) {
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
            public void onCreate(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                if (ScopeHandlerViewModel.this.getScope() == null) {
                    ScopeHandlerViewModel.this.setScope((Scope) this.createScope.invoke(this.koin));
                }
                this._scope = ScopeHandlerViewModel.this.getScope();
            }
        });
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Scope getValue(LifecycleOwner lifecycleOwner, KProperty kProperty) {
        return getValue2(lifecycleOwner, (KProperty<?>) kProperty);
    }

    public /* synthetic */ LifecycleViewModelScopeDelegate(final ComponentActivity componentActivity, Koin koin, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, koin, (i & 4) != 0 ? new Function1<Koin, Scope>() { // from class: org.koin.androidx.scope.LifecycleViewModelScopeDelegate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Scope invoke(Koin k) {
                Intrinsics.checkNotNullParameter(k, "k");
                return Koin.createScope$default(k, KoinScopeComponentKt.getScopeName(ComponentActivity.this).getValue(), KoinScopeComponentKt.getScopeName(ComponentActivity.this), null, 4, null);
            }
        } : function1);
    }

    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Scope getValue2(LifecycleOwner thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        Scope scope = this._scope;
        if (scope != null) {
            Intrinsics.checkNotNull(scope);
            return scope;
        }
        if (!isActive(thisRef)) {
            throw new IllegalStateException(("can't get Scope for " + this.lifecycleOwner + " - LifecycleOwner is not Active").toString());
        }
        Scope scopeOrNull = this.koin.getScopeOrNull(KoinScopeComponentKt.getScopeName(this.lifecycleOwner).getValue());
        if (scopeOrNull == null) {
            scopeOrNull = this.createScope.invoke(this.koin);
        }
        this._scope = scopeOrNull;
        this.koin.getLogger().debug("got scope: " + this._scope + " for " + this.lifecycleOwner);
        Scope scope2 = this._scope;
        Intrinsics.checkNotNull(scope2);
        return scope2;
    }

    private final boolean isActive(LifecycleOwner lifecycleOwner) {
        return lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED);
    }
}
