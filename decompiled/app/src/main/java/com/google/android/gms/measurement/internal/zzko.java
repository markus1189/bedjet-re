package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzko implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzjq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzjq zzjqVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjq.zzb(this.zzb, this.zza);
    }
}
