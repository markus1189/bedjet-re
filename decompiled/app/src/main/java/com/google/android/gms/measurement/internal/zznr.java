package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes.dex */
public abstract class zznr extends zzns {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznr(zznv zznvVar) {
        super(zznvVar);
        this.zzg.zzu();
    }

    protected abstract boolean zzc();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzal() {
        if (!zzan()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzam() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzg.zzt();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzan() {
        return this.zza;
    }
}
