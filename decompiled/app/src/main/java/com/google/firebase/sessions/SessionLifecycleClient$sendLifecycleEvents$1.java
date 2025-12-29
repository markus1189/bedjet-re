package com.google.firebase.sessions;

import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionLifecycleClient.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m943d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m944k = 3, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", m963f = "SessionLifecycleClient.kt", m964i = {}, m965l = {151}, m966m = "invokeSuspend", m967n = {}, m968s = {})
/* loaded from: classes2.dex */
public final class SessionLifecycleClient$sendLifecycleEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $messages;
    int label;
    final /* synthetic */ SessionLifecycleClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$sendLifecycleEvents$1(SessionLifecycleClient sessionLifecycleClient, List<Message> list, Continuation<? super SessionLifecycleClient$sendLifecycleEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionLifecycleClient;
        this.$messages = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.this$0, this.$messages, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Message latestByCode;
        Message latestByCode2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            Log.d(SessionLifecycleClient.TAG, "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
        } else {
            Collection values = map.values();
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (it.hasNext()) {
                    if (((SessionSubscriber) it.next()).isDataCollectionEnabled()) {
                        latestByCode = this.this$0.getLatestByCode(this.$messages, 2);
                        latestByCode2 = this.this$0.getLatestByCode(this.$messages, 1);
                        List sortedWith = CollectionsKt.sortedWith(CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(latestByCode, latestByCode2)), new Comparator() { // from class: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Long.valueOf(((Message) t).getWhen()), Long.valueOf(((Message) t2).getWhen()));
                            }
                        });
                        SessionLifecycleClient sessionLifecycleClient = this.this$0;
                        Iterator it2 = sortedWith.iterator();
                        while (it2.hasNext()) {
                            sessionLifecycleClient.sendMessageToServer((Message) it2.next());
                        }
                    }
                }
            }
            Log.d(SessionLifecycleClient.TAG, "Data Collection is disabled for all subscribers. Skipping this Event");
        }
        return Unit.INSTANCE;
    }
}
