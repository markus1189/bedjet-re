package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m963f = "Deprecated.kt", m964i = {0, 0, 1, 1}, m965l = {166, 169}, m966m = "single", m967n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, m968s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$single$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$single$1(Continuation<? super ChannelsKt__DeprecatedKt$single$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object single;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        single = ChannelsKt__DeprecatedKt.single(null, this);
        return single;
    }
}
