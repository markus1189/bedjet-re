package org.koin.androidx.scope;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.scope.Scope;

/* compiled from: RetainedScopeActivity.kt */
@Metadata(m942d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m943d2 = {"Lorg/koin/androidx/scope/RetainedScopeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/koin/android/scope/AndroidScopeComponent;", "contentLayoutId", "", "(I)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class RetainedScopeActivity extends AppCompatActivity implements AndroidScopeComponent {

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    private final Lazy scope;

    public RetainedScopeActivity() {
        this(0, 1, null);
    }

    public /* synthetic */ RetainedScopeActivity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // org.koin.android.scope.AndroidScopeComponent
    public void onCloseScope() {
        AndroidScopeComponent.DefaultImpls.onCloseScope(this);
    }

    public RetainedScopeActivity(int i) {
        super(i);
        this.scope = ComponentActivityExtKt.activityRetainedScope(this);
    }

    @Override // org.koin.android.scope.AndroidScopeComponent
    public Scope getScope() {
        return (Scope) this.scope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getScope() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }
}
