package kotlin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    /* renamed from: m */
    public static /* synthetic */ int m951m(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    /* renamed from: m */
    public static /* synthetic */ int m952m(int i, int i2) {
        return (int) ((i & 4294967295L) / (i2 & 4294967295L));
    }

    /* renamed from: m */
    public static /* synthetic */ int m953m(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: m */
    public static /* synthetic */ int m955m(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: m */
    public static /* synthetic */ long m956m(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2) ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if ((j3 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2)) {
            j2 = 0;
        }
        return j3 - j2;
    }

    /* renamed from: m */
    public static /* synthetic */ List m959m(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m960m(Object obj) {
        return obj == null;
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        return (int) ((i & 4294967295L) % (i2 & 4294967295L));
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1);
    }
}
