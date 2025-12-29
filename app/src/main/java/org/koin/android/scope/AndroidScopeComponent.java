package org.koin.android.scope;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import org.koin.core.scope.Scope;

/* compiled from: AndroidScopeComponent.kt */
@Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m943d2 = {"Lorg/koin/android/scope/AndroidScopeComponent;", "", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "onCloseScope", "", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface AndroidScopeComponent {

    /* compiled from: AndroidScopeComponent.kt */
    @Metadata(m944k = 3, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void onCloseScope(AndroidScopeComponent androidScopeComponent) {
        }
    }

    Scope getScope();

    void onCloseScope();
}
