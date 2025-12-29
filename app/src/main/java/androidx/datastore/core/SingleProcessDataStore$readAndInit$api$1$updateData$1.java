package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleProcessDataStore.kt */
@Metadata(m944k = 3, m945mv = {1, 5, 1}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", m963f = "SingleProcessDataStore.kt", m964i = {0, 0, 1, 2, 2}, m965l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH, 337, 339}, m966m = "updateData", m967n = {"transform", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newData"}, m968s = {"L$0", "L$1", "L$0", "L$0", "L$2"})
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, Continuation<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore$readAndInit$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateData(null, this);
    }
}
