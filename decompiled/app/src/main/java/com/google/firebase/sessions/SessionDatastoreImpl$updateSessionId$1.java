package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.firebase.sessions.SessionDatastoreImpl;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SessionDatastore.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m943d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m944k = 3, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", m963f = "SessionDatastore.kt", m964i = {}, m965l = {89}, m966m = "invokeSuspend", m967n = {}, m968s = {})
/* loaded from: classes2.dex */
final class SessionDatastoreImpl$updateSessionId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ SessionDatastoreImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDatastoreImpl$updateSessionId$1(SessionDatastoreImpl sessionDatastoreImpl, String str, Continuation<? super SessionDatastoreImpl$updateSessionId$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionDatastoreImpl;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionDatastoreImpl$updateSessionId$1(this.this$0, this.$sessionId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionDatastoreImpl$updateSessionId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SessionDatastoreImpl.Companion companion;
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                companion = SessionDatastoreImpl.Companion;
                context = this.this$0.context;
                this.label = 1;
                if (PreferencesKt.edit(companion.getDataStore(context), new C15541(this.$sessionId, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (IOException e) {
            Log.w("FirebaseSessionsRepo", "Failed to update session Id: " + e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionDatastore.kt */
    @Metadata(m942d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m943d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m944k = 3, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m962c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", m963f = "SessionDatastore.kt", m964i = {}, m965l = {}, m966m = "invokeSuspend", m967n = {}, m968s = {})
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1 */
    /* loaded from: classes2.dex */
    public static final class C15541 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sessionId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15541(String str, Continuation<? super C15541> continuation) {
            super(2, continuation);
            this.$sessionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15541 c15541 = new C15541(this.$sessionId, continuation);
            c15541.L$0 = obj;
            return c15541;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C15541) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(SessionDatastoreImpl.FirebaseSessionDataKeys.INSTANCE.getSESSION_ID(), this.$sessionId);
            return Unit.INSTANCE;
        }
    }
}
