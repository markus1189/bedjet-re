package androidx.core.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Half.kt */
@Metadata(m942d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m943d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, m944k = 2, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.core.util.HalfKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Half {
    public static final android.util.Half toHalf(short s) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf(s);
        return valueOf;
    }

    public static final android.util.Half toHalf(float f) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf(f);
        return valueOf;
    }

    public static final android.util.Half toHalf(String str) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf(str);
        return valueOf;
    }

    public static final android.util.Half toHalf(double d) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf((float) d);
        return valueOf;
    }
}
