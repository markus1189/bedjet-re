package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
final class zzmt implements Runnable {
    private final /* synthetic */ zzmq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmt(zzmq zzmqVar) {
        this.zza = zzmqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzaq();
    }
}
