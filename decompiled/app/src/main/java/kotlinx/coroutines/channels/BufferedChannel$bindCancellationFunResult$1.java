package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: BufferedChannel.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public /* synthetic */ class BufferedChannel$bindCancellationFunResult$1<E> extends FunctionReferenceImpl implements Function3<Throwable, ChannelResult<? extends E>, CoroutineContext, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferedChannel$bindCancellationFunResult$1(Object obj) {
        super(3, obj, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Object obj, CoroutineContext coroutineContext) {
        m2944invoke5_sEAP8(th, ((ChannelResult) obj).getHolder(), coroutineContext);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-5_sEAP8, reason: not valid java name */
    public final void m2944invoke5_sEAP8(Throwable th, Object obj, CoroutineContext coroutineContext) {
        ((BufferedChannel) this.receiver).m2938onCancellationChannelResultImplDoNotCall5_sEAP8(th, obj, coroutineContext);
    }
}
