package com.google.firebase.sessions;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.bedjet.bedjet.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SessionFirelogPublisher.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m943d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m944k = 3, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", m963f = "SessionFirelogPublisher.kt", m964i = {2}, m965l = {HtmlCompat.FROM_HTML_MODE_COMPACT, 64, Constants.MAGIC_RINGON}, m966m = "invokeSuspend", m967n = {"installationId"}, m968s = {"L$0"})
/* loaded from: classes2.dex */
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = sessionDetails;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L45
            if (r1 == r4) goto L41
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r0 = r11.L$5
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r11.L$4
            com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
            java.lang.Object r2 = r11.L$3
            com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
            java.lang.Object r3 = r11.L$2
            com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
            java.lang.Object r4 = r11.L$1
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r11.L$0
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r4
            r9 = r3
            r3 = r0
            r0 = r9
            r10 = r2
            r2 = r1
            r1 = r10
            goto La8
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L72
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L56
        L45:
            kotlin.ResultKt.throwOnFailure(r12)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r12 = r11.this$0
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r4
            java.lang.Object r12 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(r12, r1)
            if (r12 != r0) goto L56
            return r0
        L56:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Lbb
            com.google.firebase.sessions.InstallationId$Companion r12 = com.google.firebase.sessions.InstallationId.INSTANCE
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r11.this$0
            com.google.firebase.installations.FirebaseInstallationsApi r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseInstallations$p(r1)
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r11.label = r3
            java.lang.Object r12 = r12.create(r1, r4)
            if (r12 != r0) goto L72
            return r0
        L72:
            r5 = r12
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r11.this$0
            com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.INSTANCE
            com.google.firebase.sessions.SessionFirelogPublisherImpl r12 = r11.this$0
            com.google.firebase.FirebaseApp r12 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseApp$p(r12)
            com.google.firebase.sessions.SessionDetails r1 = r11.$sessionDetails
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r11.this$0
            com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getSessionSettings$p(r6)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.L$3 = r12
            r11.L$4 = r1
            r11.L$5 = r6
            r11.label = r2
            java.lang.Object r2 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r8)
            if (r2 != r0) goto La1
            return r0
        La1:
            r0 = r3
            r7 = r4
            r3 = r6
            r9 = r1
            r1 = r12
            r12 = r2
            r2 = r9
        La8:
            r4 = r12
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r12 = r5.getFid()
            java.lang.String r6 = r5.getAuthToken()
            r5 = r12
            com.google.firebase.sessions.SessionEvent r12 = r0.buildSession(r1, r2, r3, r4, r5, r6)
            com.google.firebase.sessions.SessionFirelogPublisherImpl.access$attemptLoggingSessionEvent(r7, r12)
        Lbb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
