package com.bedjet.bedjet.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.net.MailTo;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.BuildConfig;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.FirebaseConstants;
import com.bedjet.bedjet.databinding.DialogAppReviewBinding;
import com.bedjet.bedjet.databinding.DialogAppReviewNegativeBinding;
import com.bedjet.bedjet.databinding.DialogAppReviewPositiveBinding;
import com.bedjet.bedjet.ext.FirebaseExt;
import com.bedjet.bedjet.ext.IntentExt;
import com.bedjet.bedjet.ext.MainActivityExt;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.PreferenceStorage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AppReviewHelper.kt */
@Metadata(m942d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m943d2 = {"Lcom/bedjet/bedjet/helpers/AppReviewHelper;", "", "preferenceStorage", "Lcom/bedjet/bedjet/utils/PreferenceStorage;", "firebaseTracker", "Lcom/bedjet/bedjet/utils/FirebaseTracker;", "<init>", "(Lcom/bedjet/bedjet/utils/PreferenceStorage;Lcom/bedjet/bedjet/utils/FirebaseTracker;)V", "isFirstStart", "", "initStart", "", "deviceType", "Lcom/bedjet/bedjet/ui/main/DeviceType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "startFlow", "showAppReviewDialog", "activity", "Lcom/bedjet/bedjet/ui/main/MainActivity;", "dialogShowed", "showAppReviewPositiveDialog", "showAppReviewNegativeDialog", "openGooglePlay", "context", "Landroid/content/Context;", "openEmail", "email", "", "openCall", "phoneNumber", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AppReviewHelper {
    private static final String KEY_APP_REVIEW_FIRST_LAUNCH = "key_app_review_first_launch";
    private static final String KEY_APP_REVIEW_SHOWED = "key_app_review_showed";
    private static final String KEY_APP_REVIEW_TIMER_FINISHED = "key_app_review_timer_finished";
    private final FirebaseTracker firebaseTracker;
    private boolean isFirstStart;
    private final PreferenceStorage preferenceStorage;
    private static final long MILLIS_IN_FUTURE = 45000;
    private static final long COUNT_DOWN_INTERVAL = 45000;

    public AppReviewHelper(PreferenceStorage preferenceStorage, FirebaseTracker firebaseTracker) {
        Intrinsics.checkNotNullParameter(preferenceStorage, "preferenceStorage");
        Intrinsics.checkNotNullParameter(firebaseTracker, "firebaseTracker");
        this.preferenceStorage = preferenceStorage;
        this.firebaseTracker = firebaseTracker;
        this.isFirstStart = true;
    }

    public final void initStart(final DeviceType deviceType, final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        FirebaseExt.updateRemoteConfig(firebaseRemoteConfig, new Function0() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit initStart$lambda$0;
                initStart$lambda$0 = AppReviewHelper.initStart$lambda$0(DeviceType.this, this, listener);
                return initStart$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initStart$lambda$0(DeviceType deviceType, AppReviewHelper appReviewHelper, Function0 function0) {
        String string = FirebaseRemoteConfig.getInstance().getString(FirebaseConstants.FIREBASE_KEY_FEATURES);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() == 0) {
            return Unit.INSTANCE;
        }
        if (new JSONObject(string).optBoolean(FirebaseConstants.FIREBASE_KEY_IN_APP_REVIEW_V3) && deviceType == DeviceType.BEDJET3) {
            appReviewHelper.startFlow(function0);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bedjet.bedjet.helpers.AppReviewHelper$startFlow$1] */
    private final void startFlow(final Function0<Unit> listener) {
        if (!this.preferenceStorage.getBoolean(KEY_APP_REVIEW_SHOWED, false) && this.isFirstStart) {
            this.isFirstStart = false;
            if (!this.preferenceStorage.getBoolean(KEY_APP_REVIEW_FIRST_LAUNCH, false)) {
                this.preferenceStorage.saveBoolean(KEY_APP_REVIEW_FIRST_LAUNCH, true);
            } else {
                if (this.preferenceStorage.getBoolean(KEY_APP_REVIEW_TIMER_FINISHED, false)) {
                    listener.invoke();
                    return;
                }
                final long j = MILLIS_IN_FUTURE;
                final long j2 = COUNT_DOWN_INTERVAL;
                new CountDownTimer(j, j2) { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$startFlow$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        PreferenceStorage preferenceStorage;
                        preferenceStorage = AppReviewHelper.this.preferenceStorage;
                        preferenceStorage.saveBoolean("key_app_review_timer_finished", true);
                        listener.invoke();
                    }
                }.start();
            }
        }
    }

    public final void showAppReviewDialog(final MainActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (MainActivityExt.isNotResumed(activity)) {
            return;
        }
        dialogShowed();
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_app_review, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogAppReviewBinding dialogAppReviewBinding = (DialogAppReviewBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(activity).setView(dialogAppReviewBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppReviewHelper.showAppReviewDialog$lambda$1(AppReviewHelper.this, activity, create, view);
            }
        };
        dialogAppReviewBinding.dialogAppReviewButtonCancel.setOnClickListener(onClickListener);
        dialogAppReviewBinding.dialogAppReviewButtonSuccess.setOnClickListener(onClickListener);
        create.setCancelable(false);
        create.show();
        this.firebaseTracker.trackScreen("showAppReviewDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppReviewDialog$lambda$1(AppReviewHelper appReviewHelper, MainActivity mainActivity, AlertDialog alertDialog, View view) {
        int id = view.getId();
        if (id == C0624R.id.dialogAppReviewButtonCancel) {
            appReviewHelper.showAppReviewNegativeDialog(mainActivity);
        } else if (id == C0624R.id.dialogAppReviewButtonSuccess) {
            appReviewHelper.showAppReviewPositiveDialog(mainActivity);
        }
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private final void dialogShowed() {
        this.preferenceStorage.saveBoolean(KEY_APP_REVIEW_SHOWED, true);
    }

    private final void showAppReviewPositiveDialog(final MainActivity activity) {
        if (MainActivityExt.isNotResumed(activity)) {
            return;
        }
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_app_review_positive, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogAppReviewPositiveBinding dialogAppReviewPositiveBinding = (DialogAppReviewPositiveBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(activity).setView(dialogAppReviewPositiveBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppReviewHelper.showAppReviewPositiveDialog$lambda$2(AppReviewHelper.this, activity, create, view);
            }
        };
        dialogAppReviewPositiveBinding.dialogAppReviewPositiveButtonCancel.setOnClickListener(onClickListener);
        dialogAppReviewPositiveBinding.dialogAppReviewPositiveButtonSuccess.setOnClickListener(onClickListener);
        create.setCancelable(false);
        create.show();
        this.firebaseTracker.trackScreen("showAppReviewPositiveDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppReviewPositiveDialog$lambda$2(AppReviewHelper appReviewHelper, MainActivity mainActivity, AlertDialog alertDialog, View view) {
        if (view.getId() == C0624R.id.dialogAppReviewPositiveButtonSuccess) {
            appReviewHelper.openGooglePlay(mainActivity);
        }
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private final void showAppReviewNegativeDialog(final MainActivity activity) {
        if (MainActivityExt.isNotResumed(activity)) {
            return;
        }
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_app_review_negative, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogAppReviewNegativeBinding dialogAppReviewNegativeBinding = (DialogAppReviewNegativeBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(activity).setView(dialogAppReviewNegativeBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        final String string = activity.getString(C0624R.string.dialog_app_review_negative_email);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final String string2 = activity.getString(C0624R.string.dialog_app_review_negative_phone);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = activity.getString(C0624R.string.dialog_app_review_negative_description, new Object[]{string, string2});
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SpannableString valueOf = SpannableString.valueOf(string3);
        SpannableString spannableString = valueOf;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, string, 0, false, 6, (Object) null);
        IntRange intRange = new IntRange(indexOf$default, string.length() + indexOf$default);
        valueOf.setSpan(new ClickableSpan() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$showAppReviewNegativeDialog$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                AppReviewHelper.this.openEmail(activity, string);
                if (create.isShowing()) {
                    create.dismiss();
                }
            }
        }, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) spannableString, string2, 0, false, 6, (Object) null);
        IntRange intRange2 = new IntRange(indexOf$default2, string2.length() + indexOf$default2);
        valueOf.setSpan(new ClickableSpan() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$showAppReviewNegativeDialog$2
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                AppReviewHelper.this.openCall(activity, string2);
                if (create.isShowing()) {
                    create.dismiss();
                }
            }
        }, intRange2.getStart().intValue(), intRange2.getEndInclusive().intValue(), 17);
        dialogAppReviewNegativeBinding.dialogAppReviewNegativeDescription.setMovementMethod(LinkMovementMethod.getInstance());
        dialogAppReviewNegativeBinding.dialogAppReviewNegativeDescription.setText(spannableString);
        dialogAppReviewNegativeBinding.dialogAppReviewNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.helpers.AppReviewHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppReviewHelper.showAppReviewNegativeDialog$lambda$3(AlertDialog.this, view);
            }
        });
        create.setCancelable(false);
        create.show();
        this.firebaseTracker.trackScreen("showAppReviewNegativeDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppReviewNegativeDialog$lambda$3(AlertDialog alertDialog, View view) {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private final void openGooglePlay(Context context) {
        String replace$default = StringsKt.replace$default(BuildConfig.APPLICATION_ID, ".debug", "", false, 4, (Object) null);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + replace$default));
        try {
            if (IntentExt.isResolveIntent(intent, context)) {
                context.startActivity(intent);
            } else {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + replace$default)));
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openEmail(Context context, String email) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME + email));
        Intent createChooser = Intent.createChooser(intent, context.getString(C0624R.string.dialog_app_review_negative_email_chooser_title));
        try {
            Intrinsics.checkNotNull(createChooser);
            if (IntentExt.isResolveIntent(createChooser, context)) {
                context.startActivity(createChooser);
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCall(Context context, String phoneNumber) {
        Intent createChooser = Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + StringsKt.replace$default(phoneNumber, "–", "", false, 4, (Object) null))), context.getString(C0624R.string.dialog_app_review_negative_phone_chooser_title));
        try {
            Intrinsics.checkNotNull(createChooser);
            if (IntentExt.isResolveIntent(createChooser, context)) {
                context.startActivity(createChooser);
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
