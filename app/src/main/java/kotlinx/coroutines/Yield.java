package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Yield.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m943d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: kotlinx.coroutines.YieldKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class Yield {
    public static final Object yield(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        CoroutineContext context = continuation.getContext();
        JobKt.ensureActive(context);
        Continuation intercepted = IntrinsicsKt.intercepted(continuation);
        DispatchedContinuation dispatchedContinuation = intercepted instanceof DispatchedContinuation ? (DispatchedContinuation) intercepted : null;
        if (dispatchedContinuation == null) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, Unit.INSTANCE);
            } else {
                YieldContext yieldContext = new YieldContext();
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context.plus(yieldContext), Unit.INSTANCE);
                if (yieldContext.dispatcherWasUnconfined) {
                    coroutine_suspended = DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation) ? IntrinsicsKt.getCOROUTINE_SUSPENDED() : Unit.INSTANCE;
                }
            }
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
