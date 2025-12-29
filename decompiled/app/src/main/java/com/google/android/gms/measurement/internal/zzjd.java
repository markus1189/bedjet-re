package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public abstract class zzjd extends zzja {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzhy zzhyVar) {
        super(zzhyVar);
        this.zzu.zzaa();
    }

    protected void zzaa() {
    }

    protected abstract boolean zzh();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzac() {
        if (!zzaf()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzh()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzu.zzz();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaf() {
        return this.zza;
    }
}
