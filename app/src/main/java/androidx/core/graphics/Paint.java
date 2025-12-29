package androidx.core.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Paint.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086\b¨\u0006\u0005"}, m943d2 = {"setBlendMode", "", "Landroid/graphics/Paint;", "blendModeCompat", "Landroidx/core/graphics/BlendModeCompat;", "core-ktx_release"}, m944k = 2, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.core.graphics.PaintKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Paint {
    public static final boolean setBlendMode(android.graphics.Paint paint, BlendModeCompat blendModeCompat) {
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
