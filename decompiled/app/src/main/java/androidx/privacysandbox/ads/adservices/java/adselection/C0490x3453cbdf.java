package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AdSelectionManagerFutures.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m943d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m944k = 3, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1", m963f = "AdSelectionManagerFutures.kt", m964i = {}, m965l = {LocationRequestCompat.QUALITY_LOW_POWER}, m966m = "invokeSuspend", m967n = {}, m968s = {})
/* renamed from: androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1 */
/* loaded from: classes.dex */
final class C0490x3453cbdf extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReportImpressionRequest $reportImpressionRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0490x3453cbdf(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, ReportImpressionRequest reportImpressionRequest, Continuation<? super C0490x3453cbdf> continuation) {
        super(2, continuation);
        this.this$0 = api33Ext4JavaImpl;
        this.$reportImpressionRequest = reportImpressionRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0490x3453cbdf(this.this$0, this.$reportImpressionRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0490x3453cbdf) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdSelectionManager adSelectionManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            adSelectionManager = this.this$0.mAdSelectionManager;
            Intrinsics.checkNotNull(adSelectionManager);
            this.label = 1;
            if (adSelectionManager.reportImpression(this.$reportImpressionRequest, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
