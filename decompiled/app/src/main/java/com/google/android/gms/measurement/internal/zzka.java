package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzka implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzjq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzka(zzjq zzjqVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Boolean.valueOf(this.zzb.zze().zzi(this.zzb.zzg().zzad())));
            } finally {
                this.zza.notify();
            }
        }
    }
}
