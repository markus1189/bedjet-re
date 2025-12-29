package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleProcessDataStore.kt */
@Metadata(m944k = 3, m945mv = {1, 5, 1}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "androidx.datastore.core.SingleProcessDataStore", m963f = "SingleProcessDataStore.kt", m964i = {0, 1, 2, 2}, m965l = {359, 362, 365}, m966m = "readDataOrHandleCorruption", m967n = {"this", "ex", "ex", "newData"}, m968s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readDataOrHandleCorruption$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readDataOrHandleCorruption$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readDataOrHandleCorruption$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readDataOrHandleCorruption;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readDataOrHandleCorruption = this.this$0.readDataOrHandleCorruption(this);
        return readDataOrHandleCorruption;
    }
}
