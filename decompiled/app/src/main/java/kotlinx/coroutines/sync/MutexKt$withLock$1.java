package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mutex.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = 176)
@DebugMetadata(m962c = "kotlinx.coroutines.sync.MutexKt", m963f = "Mutex.kt", m964i = {0, 0, 0}, m965l = {121}, m966m = "withLock", m967n = {"$this$withLock", "owner", "action"}, m968s = {"L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.withLock(null, null, null, this);
    }
}
