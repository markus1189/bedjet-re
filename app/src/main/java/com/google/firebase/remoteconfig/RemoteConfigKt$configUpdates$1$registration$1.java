package com.google.firebase.remoteconfig;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: RemoteConfig.kt */
@Metadata(m942d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m943d2 = {"com/google/firebase/remoteconfig/RemoteConfigKt$configUpdates$1$registration$1", "Lcom/google/firebase/remoteconfig/ConfigUpdateListener;", "onError", "", "error", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigException;", "onUpdate", "configUpdate", "Lcom/google/firebase/remoteconfig/ConfigUpdate;", "com.google.firebase-firebase-config"}, m944k = 1, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class RemoteConfigKt$configUpdates$1$registration$1 implements ConfigUpdateListener {
    final /* synthetic */ ProducerScope<ConfigUpdate> $$this$callbackFlow;
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public RemoteConfigKt$configUpdates$1$registration$1(FirebaseRemoteConfig firebaseRemoteConfig, ProducerScope<? super ConfigUpdate> producerScope) {
        this.$this_configUpdates = firebaseRemoteConfig;
        this.$$this$callbackFlow = producerScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$0(ProducerScope $this$callbackFlow, ConfigUpdate configUpdate) {
        Intrinsics.checkNotNullParameter($this$callbackFlow, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(configUpdate, "$configUpdate");
        ChannelsKt.trySendBlocking($this$callbackFlow, configUpdate);
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onUpdate(final ConfigUpdate configUpdate) {
        Intrinsics.checkNotNullParameter(configUpdate, "configUpdate");
        FirebaseRemoteConfig firebaseRemoteConfig = this.$this_configUpdates;
        final ProducerScope<ConfigUpdate> producerScope = this.$$this$callbackFlow;
        firebaseRemoteConfig.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1$registration$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConfigKt$configUpdates$1$registration$1.onUpdate$lambda$0(ProducerScope.this, configUpdate);
            }
        });
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onError(FirebaseRemoteConfigException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        CoroutineScopeKt.cancel(this.$$this$callbackFlow, "Error listening for config updates.", error);
    }
}
