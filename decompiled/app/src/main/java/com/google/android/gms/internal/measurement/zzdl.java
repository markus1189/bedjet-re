package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes.dex */
public final class zzdl extends zzbu implements zzdj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeLong(j);
        zzb(23, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, bundle);
        zzb(9, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeLong(j);
        zzb(43, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeLong(j);
        zzb(24, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void generateEventId(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(22, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getAppInstanceId(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(20, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getCachedAppInstanceId(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(19, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getConditionalUserProperties(String str, String str2, zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, zzdoVar);
        zzb(10, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getCurrentScreenClass(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(17, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getCurrentScreenName(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(16, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getGmpAppId(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(21, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getMaxUserProperties(String str, zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        zzbw.zza(m580a_, zzdoVar);
        zzb(6, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getSessionId(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(46, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getTestFlag(zzdo zzdoVar, int i) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        m580a_.writeInt(i);
        zzb(38, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void getUserProperties(String str, String str2, boolean z, zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, z);
        zzbw.zza(m580a_, zzdoVar);
        zzb(5, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void initForTests(Map map) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeMap(map);
        zzb(37, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void initialize(IObjectWrapper iObjectWrapper, zzdw zzdwVar, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        zzbw.zza(m580a_, zzdwVar);
        m580a_.writeLong(j);
        zzb(1, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void isDataCollectionEnabled(zzdo zzdoVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdoVar);
        zzb(40, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, bundle);
        zzbw.zza(m580a_, z);
        zzbw.zza(m580a_, z2);
        m580a_.writeLong(j);
        zzb(2, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzdo zzdoVar, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, bundle);
        zzbw.zza(m580a_, zzdoVar);
        m580a_.writeLong(j);
        zzb(3, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeInt(i);
        m580a_.writeString(str);
        zzbw.zza(m580a_, iObjectWrapper);
        zzbw.zza(m580a_, iObjectWrapper2);
        zzbw.zza(m580a_, iObjectWrapper3);
        zzb(33, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        zzbw.zza(m580a_, bundle);
        m580a_.writeLong(j);
        zzb(27, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeLong(j);
        zzb(28, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeLong(j);
        zzb(29, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeLong(j);
        zzb(30, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdo zzdoVar, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        zzbw.zza(m580a_, zzdoVar);
        m580a_.writeLong(j);
        zzb(31, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeLong(j);
        zzb(25, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeLong(j);
        zzb(26, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void performAction(Bundle bundle, zzdo zzdoVar, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, bundle);
        zzbw.zza(m580a_, zzdoVar);
        m580a_.writeLong(j);
        zzb(32, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void registerOnMeasurementEventListener(zzdp zzdpVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdpVar);
        zzb(35, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeLong(j);
        zzb(12, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, bundle);
        m580a_.writeLong(j);
        zzb(8, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, bundle);
        m580a_.writeLong(j);
        zzb(44, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, bundle);
        m580a_.writeLong(j);
        zzb(45, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, iObjectWrapper);
        m580a_.writeString(str);
        m580a_.writeString(str2);
        m580a_.writeLong(j);
        zzb(15, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, z);
        zzb(39, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, bundle);
        zzb(42, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setEventInterceptor(zzdp zzdpVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdpVar);
        zzb(34, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setInstanceIdProvider(zzdu zzduVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzduVar);
        zzb(18, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, z);
        m580a_.writeLong(j);
        zzb(11, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeLong(j);
        zzb(13, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeLong(j);
        zzb(14, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, intent);
        zzb(48, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeLong(j);
        zzb(7, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel m580a_ = m580a_();
        m580a_.writeString(str);
        m580a_.writeString(str2);
        zzbw.zza(m580a_, iObjectWrapper);
        zzbw.zza(m580a_, z);
        m580a_.writeLong(j);
        zzb(4, m580a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void unregisterOnMeasurementEventListener(zzdp zzdpVar) throws RemoteException {
        Parcel m580a_ = m580a_();
        zzbw.zza(m580a_, zzdpVar);
        zzb(36, m580a_);
    }
}
