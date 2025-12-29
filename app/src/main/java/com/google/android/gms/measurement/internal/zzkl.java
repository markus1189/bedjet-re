package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzkl implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkl(zzjq zzjqVar, long j) {
        this.zza = j;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
        this.zzb.zzo().zza(new AtomicReference<>());
    }
}
