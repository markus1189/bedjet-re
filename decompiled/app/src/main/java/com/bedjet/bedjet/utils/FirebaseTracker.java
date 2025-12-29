package com.bedjet.bedjet.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.analytics.ktx.ParametersBuilder;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseTracker.kt */
@Metadata(m942d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ2\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m943d2 = {"Lcom/bedjet/bedjet/utils/FirebaseTracker;", "", "<init>", "()V", "instance", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "setUserFontScale", "", "fontScale", "", "trackScreen", "screenName", "", "trackEvent", "eventName", FirebaseTracker.EVENT_KEY, FirebaseTracker.LABEL, "value", "eventOldAppDialogShowed", "eventOldAppDialogButtonCancel", "eventOldAppDialogButtonInstall", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FirebaseTracker {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String EVENT_KEY = "eventKey";

    @Deprecated
    public static final String EVENT_OLD_APP_BUTTON_CANCEL = "event_old_app_button_cancel";

    @Deprecated
    public static final String EVENT_OLD_APP_BUTTON_INSTALL = "event_old_app_button_install";

    @Deprecated
    public static final String EVENT_OLD_APP_DIALOG_SHOWED = "event_old_app_dialog_showed";

    @Deprecated
    public static final String LABEL = "label";

    @Deprecated
    public static final String PROPERTY_FONT_SCALE = "font_scale";

    @Deprecated
    public static final String VALUE = "value";
    private final FirebaseAnalytics instance = AnalyticsKt.getAnalytics(Firebase.INSTANCE);

    /* compiled from: FirebaseTracker.kt */
    @Metadata(m942d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m943d2 = {"Lcom/bedjet/bedjet/utils/FirebaseTracker$Companion;", "", "<init>", "()V", "PROPERTY_FONT_SCALE", "", "EVENT_KEY", "LABEL", "VALUE", "EVENT_OLD_APP_DIALOG_SHOWED", "EVENT_OLD_APP_BUTTON_CANCEL", "EVENT_OLD_APP_BUTTON_INSTALL", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setUserFontScale(float fontScale) {
        this.instance.setUserProperty(PROPERTY_FONT_SCALE, String.valueOf(fontScale));
    }

    public final void trackScreen(String screenName) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        FirebaseAnalytics firebaseAnalytics = this.instance;
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        parametersBuilder.param(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, parametersBuilder.getZza());
    }

    public static /* synthetic */ void trackEvent$default(FirebaseTracker firebaseTracker, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        firebaseTracker.trackEvent(str, str2, str3, str4);
    }

    public final void trackEvent(String eventName, String eventKey, String label, String value) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        FirebaseAnalytics firebaseAnalytics = this.instance;
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        if (eventKey != null) {
            parametersBuilder.param(EVENT_KEY, eventKey);
        }
        if (label != null) {
            parametersBuilder.param(LABEL, label);
        }
        if (value != null) {
            parametersBuilder.param("value", value);
        }
        firebaseAnalytics.logEvent(eventName, parametersBuilder.getZza());
    }

    public final void eventOldAppDialogShowed() {
        trackEvent$default(this, EVENT_OLD_APP_DIALOG_SHOWED, null, null, null, 14, null);
    }

    public final void eventOldAppDialogButtonCancel() {
        trackEvent$default(this, EVENT_OLD_APP_BUTTON_CANCEL, null, null, null, 14, null);
    }

    public final void eventOldAppDialogButtonInstall() {
        trackEvent$default(this, EVENT_OLD_APP_BUTTON_INSTALL, null, null, null, 14, null);
    }
}
