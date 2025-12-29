package androidx.core.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Runnable.kt */
@Metadata(m942d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, m943d2 = {"asRunnable", "Ljava/lang/Runnable;", "Lkotlin/coroutines/Continuation;", "", "core-ktx_release"}, m944k = 2, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(Continuation<? super Unit> continuation) {
        return new ContinuationRunnable(continuation);
    }
}
