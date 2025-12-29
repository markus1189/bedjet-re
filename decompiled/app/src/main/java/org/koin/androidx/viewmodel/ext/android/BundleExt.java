package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BundleExt.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m943d2 = {"toExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroid/os/Bundle;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: org.koin.androidx.viewmodel.ext.android.BundleExtKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class BundleExt {
    public static final CreationExtras toExtras(Bundle bundle, ViewModelStoreOwner viewModelStoreOwner) {
        Object m1423constructorimpl;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        if (bundle.keySet().isEmpty()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(null, 1, null);
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, bundle);
            mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, viewModelStoreOwner);
            mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, (SavedStateRegistryOwner) viewModelStoreOwner);
            m1423constructorimpl = Result.m1423constructorimpl(mutableCreationExtras);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m1423constructorimpl = Result.m1423constructorimpl(ResultKt.createFailure(th));
        }
        return (CreationExtras) (Result.m1429isFailureimpl(m1423constructorimpl) ? null : m1423constructorimpl);
    }
}
