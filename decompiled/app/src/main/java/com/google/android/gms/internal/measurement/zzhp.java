package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes.dex */
public final class zzhp extends zzhj<Double> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhj
    @Nullable
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Double zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        Log.e("PhenotypeFlag", "Invalid double value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhp(zzhr zzhrVar, String str, Double d, boolean z) {
        super(zzhrVar, str, d);
    }
}
