package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes.dex */
public final class zzt extends zznr {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzv> zzc;
    private Long zzd;
    private Long zze;

    private final zzv zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzv zzvVar = new zzv(this, this.zza);
        this.zzc.put(num, zzvVar);
        return zzvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2, boolean z) {
        boolean z2;
        Map<Integer, zzfy.zzm> map;
        List<zzfo.zzb> list3;
        Iterator it;
        Iterator<zzfy.zzn> it2;
        Map<Integer, zzfy.zzm> map2;
        Map<Integer, List<Integer>> map3;
        Iterator<Integer> it3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfy.zzf> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it4.next().zzg())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = com.google.android.gms.internal.measurement.zzoe.zza() && zze().zzf(this.zza, zzbh.zzbp);
        boolean z4 = com.google.android.gms.internal.measurement.zzoe.zza() && zze().zzf(this.zza, zzbh.zzbo);
        if (z2) {
            zzal zzh = zzh();
            String str2 = this.zza;
            zzh.zzal();
            zzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzh.m584e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzgo.zza(str2), e);
            }
        }
        Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
        if (z4 && z3) {
            emptyMap = zzh().zzn(this.zza);
        }
        Map<Integer, zzfy.zzm> zzm = zzh().zzm(this.zza);
        if (!zzm.isEmpty()) {
            HashSet hashSet = new HashSet(zzm.keySet());
            if (z2) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> zzo = zzh().zzo(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(zzm);
                ArrayMap arrayMap = new ArrayMap();
                if (!zzm.isEmpty()) {
                    Iterator<Integer> it5 = zzm.keySet().iterator();
                    while (it5.hasNext()) {
                        Integer next = it5.next();
                        next.intValue();
                        zzfy.zzm zzmVar = zzm.get(next);
                        List<Integer> list4 = zzo.get(next);
                        if (list4 == null || list4.isEmpty()) {
                            map3 = zzo;
                            it3 = it5;
                            arrayMap.put(next, zzmVar);
                        } else {
                            List<Long> zza = mo586g_().zza(zzmVar.zzi(), list4);
                            if (!zza.isEmpty()) {
                                zzfy.zzm.zza zzb = zzmVar.zzcd().zzb().zzb(zza);
                                zzb.zzd().zzd(mo586g_().zza(zzmVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzfy.zze zzeVar : zzmVar.zzh()) {
                                    Map<Integer, List<Integer>> map4 = zzo;
                                    Iterator<Integer> it6 = it5;
                                    if (!list4.contains(Integer.valueOf(zzeVar.zza()))) {
                                        arrayList.add(zzeVar);
                                    }
                                    zzo = map4;
                                    it5 = it6;
                                }
                                map3 = zzo;
                                it3 = it5;
                                zzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfy.zzn zznVar : zzmVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zznVar.zzb()))) {
                                        arrayList2.add(zznVar);
                                    }
                                }
                                zzb.zzc().zzc(arrayList2);
                                arrayMap.put(next, (zzfy.zzm) ((com.google.android.gms.internal.measurement.zzjt) zzb.zzai()));
                            }
                        }
                        zzo = map3;
                        it5 = it3;
                    }
                }
                map = arrayMap;
            } else {
                map = zzm;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                Integer num = (Integer) it7.next();
                num.intValue();
                zzfy.zzm zzmVar2 = map.get(num);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap2 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zza() != 0) {
                    for (zzfy.zze zzeVar2 : zzmVar2.zzh()) {
                        if (zzeVar2.zzf()) {
                            arrayMap2.put(Integer.valueOf(zzeVar2.zza()), zzeVar2.zze() ? Long.valueOf(zzeVar2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zzc() != 0) {
                    Iterator<zzfy.zzn> it8 = zzmVar2.zzj().iterator();
                    while (it8.hasNext()) {
                        zzfy.zzn next2 = it8.next();
                        if (!next2.zzf() || next2.zza() <= 0) {
                            it2 = it8;
                            map2 = map;
                        } else {
                            it2 = it8;
                            map2 = map;
                            arrayMap3.put(Integer.valueOf(next2.zzb()), Long.valueOf(next2.zza(next2.zza() - 1)));
                        }
                        it8 = it2;
                        map = map2;
                    }
                }
                Map<Integer, zzfy.zzm> map5 = map;
                if (zzmVar2 != null) {
                    int i = 0;
                    while (i < (zzmVar2.zzd() << 6)) {
                        if (zzoo.zza(zzmVar2.zzk(), i)) {
                            it = it7;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", num, Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zzoo.zza(zzmVar2.zzi(), i)) {
                                bitSet.set(i);
                                i++;
                                it7 = it;
                            }
                        } else {
                            it = it7;
                        }
                        arrayMap2.remove(Integer.valueOf(i));
                        i++;
                        it7 = it;
                    }
                }
                Iterator it9 = it7;
                zzfy.zzm zzmVar3 = zzm.get(num);
                if (z4 && z3 && (list3 = emptyMap.get(num)) != null && this.zze != null && this.zzd != null) {
                    for (zzfo.zzb zzbVar : list3) {
                        int zzb2 = zzbVar.zzb();
                        long longValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            longValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(zzb2))) {
                            arrayMap2.put(Integer.valueOf(zzb2), Long.valueOf(longValue));
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(zzb2))) {
                            arrayMap3.put(Integer.valueOf(zzb2), Long.valueOf(longValue));
                        }
                    }
                }
                this.zzc.put(num, new zzv(this, this.zza, zzmVar3, bitSet, bitSet2, arrayMap2, arrayMap3));
                it7 = it9;
                zzm = zzm;
                map = map5;
                emptyMap = emptyMap;
            }
        }
        if (com.google.android.gms.internal.measurement.zznm.zza() && zze().zzf(null, zzbh.zzcy)) {
            zza(list, z);
            if (z) {
                return new ArrayList();
            }
            zza(list2);
            return zzu();
        }
        zza(list, true);
        zza(list2);
        return zzu();
    }

    private final List<zzfy.zzd> zzu() {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = this.zzc.keySet();
        keySet.removeAll(this.zzb);
        for (Integer num : keySet) {
            int intValue = num.intValue();
            zzv zzvVar = this.zzc.get(num);
            Preconditions.checkNotNull(zzvVar);
            zzfy.zzd zza = zzvVar.zza(intValue);
            arrayList.add(zza);
            zzal zzh = zzh();
            String str = this.zza;
            zzfy.zzm zzd = zza.zzd();
            zzh.zzal();
            zzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzd);
            byte[] zzca = zzd.zzca();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", zzca);
            try {
                if (zzh.m584e_().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzgo.zza(str));
                }
            } catch (SQLiteException e) {
                zzh.zzj().zzg().zza("Error storing filter results. appId", zzgo.zza(str), e);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zznv zznvVar) {
        super(zznvVar);
    }

    private final void zza(List<zzfy.zzf> list, boolean z) {
        zzbb zzbbVar;
        zzy zzyVar;
        Integer num;
        Map<Integer, List<zzfo.zzb>> map;
        long j;
        if (list.isEmpty()) {
            return;
        }
        String str = null;
        zzy zzyVar2 = new zzy(this);
        ArrayMap arrayMap = new ArrayMap();
        for (zzfy.zzf zzfVar : list) {
            zzfy.zzf zza = zzyVar2.zza(this.zza, zzfVar);
            if (zza != null) {
                zzal zzh = zzh();
                String str2 = this.zza;
                String zzg = zza.zzg();
                zzbb zzd = zzh.zzd(str2, zzfVar.zzg());
                if (zzd == null) {
                    zzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzgo.zza(str2), zzh.zzi().zza(zzg));
                    zzbbVar = new zzbb(str2, zzfVar.zzg(), 1L, 1L, 1L, zzfVar.zzd(), 0L, null, null, null, null);
                } else {
                    zzbbVar = new zzbb(zzd.zza, zzd.zzb, zzd.zzc + 1, zzd.zzd + 1, zzd.zze + 1, zzd.zzf, zzd.zzg, zzd.zzh, zzd.zzi, zzd.zzj, zzd.zzk);
                }
                zzbb zzbbVar2 = zzbbVar;
                zzh().zza(zzbbVar2);
                if (!com.google.android.gms.internal.measurement.zznm.zza() || !zze().zzf(str, zzbh.zzcy) || !z) {
                    long j2 = zzbbVar2.zzc;
                    String zzg2 = zza.zzg();
                    Map<Integer, List<zzfo.zzb>> map2 = (Map) arrayMap.get(zzg2);
                    if (map2 == null) {
                        map2 = zzh().zzf(this.zza, zzg2);
                        arrayMap.put(zzg2, map2);
                    }
                    Map<Integer, List<zzfo.zzb>> map3 = map2;
                    Iterator<Integer> it = map3.keySet().iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        int intValue = next.intValue();
                        if (this.zzb.contains(next)) {
                            zzj().zzp().zza("Skipping failed audience ID", next);
                        } else {
                            Iterator<zzfo.zzb> it2 = map3.get(next).iterator();
                            boolean z2 = true;
                            while (true) {
                                if (!it2.hasNext()) {
                                    zzyVar = zzyVar2;
                                    num = next;
                                    map = map3;
                                    j = j2;
                                    break;
                                }
                                zzfo.zzb next2 = it2.next();
                                zzx zzxVar = new zzx(this, this.zza, intValue, next2);
                                zzyVar = zzyVar2;
                                num = next;
                                int i = intValue;
                                map = map3;
                                j = j2;
                                z2 = zzxVar.zza(this.zzd, this.zze, zza, j2, zzbbVar2, zza(intValue, next2.zzb()));
                                if (z2) {
                                    zza(num).zza(zzxVar);
                                    next = num;
                                    zzyVar2 = zzyVar;
                                    intValue = i;
                                    map3 = map;
                                    j2 = j;
                                } else {
                                    this.zzb.add(num);
                                    break;
                                }
                            }
                            if (!z2) {
                                this.zzb.add(num);
                            }
                            zzyVar2 = zzyVar;
                            map3 = map;
                            j2 = j;
                            str = null;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fb, code lost:
    
        r5 = zzj().zzu();
        r6 = com.google.android.gms.measurement.internal.zzgo.zza(r13.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
    
        if (r7.zzi() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010f, code lost:
    
        r9 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        r5.zza("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r9));
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zza(java.util.List<com.google.android.gms.internal.measurement.zzfy.zzo> r14) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.util.List):void");
    }

    private final boolean zza(int i, int i2) {
        zzv zzvVar = this.zzc.get(Integer.valueOf(i));
        if (zzvVar == null) {
            return false;
        }
        return zzv.zza(zzvVar).get(i2);
    }
}
