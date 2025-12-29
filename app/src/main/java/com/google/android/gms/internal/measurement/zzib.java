package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzid;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes.dex */
public abstract class zzib<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zzid<MessageType, BuilderType>> implements zzlc {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzby() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zza(zzlu zzluVar) {
        int zzby = zzby();
        if (zzby != -1) {
            return zzby;
        }
        int zza = zzluVar.zza(this);
        zzc(zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final zzik zzbz() {
        try {
            zzit zzc = zzik.zzc(zzcb());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzid.zza(iterable, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzca() {
        try {
            byte[] bArr = new byte[zzcb()];
            zzjc zzb = zzjc.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
