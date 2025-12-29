package com.bedjet.bedjet.ext;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentExt.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m943d2 = {"isResolveIntent", "", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.ext.IntentExtKt, reason: use source file name */
/* loaded from: classes.dex */
public final class IntentExt {
    public static final boolean isResolveIntent(Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return intent.resolveActivity(context.getPackageManager()) != null;
    }
}
