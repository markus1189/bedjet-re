package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzkm extends zzav {
    private final /* synthetic */ zzjq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkm(zzjq zzjqVar, zzjc zzjcVar) {
        super(zzjcVar);
        this.zza = zzjqVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        zzav zzavVar;
        if (this.zza.zzu.zzah()) {
            zzavVar = this.zza.zzq;
            zzavVar.zza(2000L);
        }
    }
}
