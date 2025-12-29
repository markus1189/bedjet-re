package org.koin.androidx.scope;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.scope.Scope;

/* compiled from: ScopeFragment.kt */
@Metadata(m942d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, m943d2 = {"Lorg/koin/androidx/scope/ScopeFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/android/scope/AndroidScopeComponent;", "contentLayoutId", "", "(I)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class ScopeFragment extends Fragment implements AndroidScopeComponent {

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    private final Lazy scope;

    public ScopeFragment() {
        this(0, 1, null);
    }

    public /* synthetic */ ScopeFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // org.koin.android.scope.AndroidScopeComponent
    public void onCloseScope() {
        AndroidScopeComponent.DefaultImpls.onCloseScope(this);
    }

    public ScopeFragment(int i) {
        super(i);
        this.scope = FragmentExtKt.fragmentScope$default(this, false, 1, null);
    }

    @Override // org.koin.android.scope.AndroidScopeComponent
    public Scope getScope() {
        return (Scope) this.scope.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getScope() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }
}
