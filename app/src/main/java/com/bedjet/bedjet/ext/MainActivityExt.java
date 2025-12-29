package com.bedjet.bedjet.ext;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivityExt.kt */
@Metadata(m942d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, m943d2 = {"isResumed", "", "Lcom/bedjet/bedjet/ui/main/MainActivity;", "isNotResumed", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.ext.MainActivityExtKt, reason: use source file name */
/* loaded from: classes.dex */
public final class MainActivityExt {
    public static final boolean isResumed(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "<this>");
        return mainActivity.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public static final boolean isNotResumed(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "<this>");
        return !isResumed(mainActivity);
    }
}
