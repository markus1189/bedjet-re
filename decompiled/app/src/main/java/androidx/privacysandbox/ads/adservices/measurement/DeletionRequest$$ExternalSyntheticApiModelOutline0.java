package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.adservices.topics.TopicsManager;
import android.net.Uri;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DeletionRequest$$ExternalSyntheticApiModelOutline0 {
    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AdId m339m(Object obj) {
        return (AdId) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AdIdManager m340m(Object obj) {
        return (AdIdManager) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ AdSelectionConfig.Builder m341m() {
        return new AdSelectionConfig.Builder();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AdSelectionManager m348m(Object obj) {
        return (AdSelectionManager) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AdSelectionOutcome m349m(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ ReportImpressionRequest m350m(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AppSetId m351m(Object obj) {
        return (AppSetId) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AppSetIdManager m352m(Object obj) {
        return (AppSetIdManager) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ AdData.Builder m353m() {
        return new AdData.Builder();
    }

    /* renamed from: m */
    public static /* synthetic */ CustomAudience.Builder m359m() {
        return new CustomAudience.Builder();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ CustomAudienceManager m368m(Object obj) {
        return (CustomAudienceManager) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m369m() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* renamed from: m */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m372m() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* renamed from: m */
    public static /* synthetic */ TrustedBiddingData.Builder m376m() {
        return new TrustedBiddingData.Builder();
    }

    /* renamed from: m */
    public static /* synthetic */ DeletionRequest.Builder m380m() {
        return new DeletionRequest.Builder();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ android.adservices.measurement.MeasurementManager m385m(Object obj) {
        return (android.adservices.measurement.MeasurementManager) obj;
    }

    /* renamed from: m */
    public static /* synthetic */ WebSourceParams.Builder m387m(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    /* renamed from: m */
    public static /* synthetic */ WebSourceRegistrationRequest.Builder m391m(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m */
    public static /* synthetic */ WebTriggerParams.Builder m394m(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    /* renamed from: m */
    public static /* synthetic */ WebTriggerRegistrationRequest.Builder m396m(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ TopicsManager m399m(Object obj) {
        return (TopicsManager) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ Class m401m() {
        return AdIdManager.class;
    }

    /* renamed from: m */
    public static /* synthetic */ void m404m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return AdSelectionManager.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m1283m$1() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return AppSetIdManager.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m1284m$2() {
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return CustomAudienceManager.class;
    }

    /* renamed from: m$3, reason: collision with other method in class */
    public static /* synthetic */ void m1285m$3() {
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return android.adservices.measurement.MeasurementManager.class;
    }

    /* renamed from: m$4, reason: collision with other method in class */
    public static /* synthetic */ void m1286m$4() {
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return TopicsManager.class;
    }
}
