package org.koin.androidx.viewmodel.scope;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ScopeExt.kt */
@Metadata(m942d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003H\u0007*&\b\u0007\u0010\u0004\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001B\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¨\u0006\b"}, m943d2 = {"emptyState", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "BundleDefinition", "Lkotlin/Deprecated;", "message", "Replaced by CreationExtras API", "koin-android_release"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ScopeExtKt {
    @Deprecated(message = "Replaced by CreationExtras API")
    public static /* synthetic */ void BundleDefinition$annotations() {
    }

    @Deprecated(message = "Replaced by CreationExtras API")
    public static final Function0<Bundle> emptyState() {
        return new Function0<Bundle>() { // from class: org.koin.androidx.viewmodel.scope.ScopeExtKt$emptyState$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                return new Bundle();
            }
        };
    }
}
