package com.bedjet.bedjet.utils;

import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ext.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\t¨\u0006\n"}, m943d2 = {"getOrNull", "", "", FirebaseAnalytics.Param.INDEX, "", "addOverscroll", "", "Landroidx/recyclerview/widget/RecyclerView;", "stop", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.utils.ExtKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ext {
    public static final byte getOrNull(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i < 0 || i > bArr.length - 1) {
            return (byte) 0;
        }
        return bArr[i];
    }

    public static final void addOverscroll(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.setOverScrollMode(Build.VERSION.SDK_INT > 30 ? 0 : 2);
    }

    public static final void stop(ShimmerFrameLayout shimmerFrameLayout) {
        Intrinsics.checkNotNullParameter(shimmerFrameLayout, "<this>");
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(8);
    }
}
