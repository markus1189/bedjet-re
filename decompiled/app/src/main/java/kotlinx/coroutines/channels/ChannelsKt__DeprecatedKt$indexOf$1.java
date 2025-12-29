package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m963f = "Deprecated.kt", m964i = {0, 0, 0}, m965l = {514}, m966m = "indexOf", m967n = {"element", FirebaseAnalytics.Param.INDEX, "$this$consume$iv$iv"}, m968s = {"L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$indexOf$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$indexOf$1(Continuation<? super ChannelsKt__DeprecatedKt$indexOf$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object indexOf;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        indexOf = ChannelsKt__DeprecatedKt.indexOf(null, null, this);
        return indexOf;
    }
}
