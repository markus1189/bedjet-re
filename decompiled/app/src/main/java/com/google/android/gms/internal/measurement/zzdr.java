package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes.dex */
public final class zzdr extends zzbu implements zzdp {
    @Override // com.google.android.gms.internal.measurement.zzdp
    public final int zza() throws RemoteException {
        Parcel zza = zza(2, m580a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdp
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, bundle);
        m580a_.writeLong(j);
        zzb(1, m580a_);
    }
}
