package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes.dex */
public final class zzhr implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzhl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(zzhl zzhlVar) {
        this.zza = zzhlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        zzgq zzc;
        int i = zzht.zza[zzsVar.ordinal()];
        if (i == 1) {
            zzc = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    zzc = this.zza.zzj().zzp();
                } else {
                    zzc = this.zza.zzj().zzo();
                }
            } else if (z) {
                zzc = this.zza.zzj().zzw();
            } else if (!z2) {
                zzc = this.zza.zzj().zzv();
            } else {
                zzc = this.zza.zzj().zzu();
            }
        } else if (z) {
            zzc = this.zza.zzj().zzn();
        } else if (!z2) {
            zzc = this.zza.zzj().zzm();
        } else {
            zzc = this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzc.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzc.zza(str, list.get(0), list.get(1));
        } else if (size == 3) {
            zzc.zza(str, list.get(0), list.get(1), list.get(2));
        } else {
            zzc.zza(str);
        }
    }
}
