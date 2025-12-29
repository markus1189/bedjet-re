package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FragmentStateVM.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m943d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, m944k = 3, m945mv = {1, 9, 0}, m947xi = 176)
/* loaded from: classes2.dex */
public final class FragmentStateVMKt$stateViewModel$2<T> extends Lambda implements Function0<T> {
    final /* synthetic */ Function0<ViewModelStoreOwner> $owner;
    final /* synthetic */ Function0<ParametersHolder> $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ Fragment $this_stateViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentStateVMKt$stateViewModel$2(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        super(0);
        this.$this_stateViewModel = fragment;
        this.$qualifier = qualifier;
        this.$state = function0;
        this.$owner = function02;
        this.$parameters = function03;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModel invoke() {
        ViewModel resolveViewModel;
        Fragment fragment = this.$this_stateViewModel;
        Qualifier qualifier = this.$qualifier;
        Function0<Bundle> function0 = this.$state;
        Function0<ViewModelStoreOwner> function02 = this.$owner;
        Function0<ParametersHolder> function03 = this.$parameters;
        ViewModelStore viewModelStore = function02.invoke().getViewModelStore();
        CreationExtras extras = BundleExt.toExtras(function0.invoke(), fragment);
        if (extras == null) {
            extras = fragment.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "<get-defaultViewModelCreationExtras>(...)");
        }
        Scope koinScope = AndroidKoinScopeExt.getKoinScope(fragment);
        Intrinsics.reifiedOperationMarker(4, "T");
        resolveViewModel = GetViewModelKt.resolveViewModel(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelStore, (r16 & 4) != 0 ? null : null, extras, (r16 & 16) != 0 ? null : qualifier, koinScope, (r16 & 64) != 0 ? null : function03);
        return resolveViewModel;
    }
}
