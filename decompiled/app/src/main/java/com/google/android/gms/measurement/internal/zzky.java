package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzky implements Runnable {
    private final /* synthetic */ zzax zza;
    private final /* synthetic */ zzjq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(zzjq zzjqVar, zzax zzaxVar) {
        this.zza = zzaxVar;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzp().zza("Setting DMA consent(FE)", this.zza);
            if (this.zzb.zzo().zzao()) {
                this.zzb.zzo().zzaj();
                return;
            } else {
                this.zzb.zzo().zza(false);
                return;
            }
        }
        this.zzb.zzj().zzo().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
    }
}
