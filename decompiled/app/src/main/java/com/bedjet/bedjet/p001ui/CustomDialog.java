package com.bedjet.bedjet.p001ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.FirebaseConstants;
import com.bedjet.bedjet.databinding.DialogCannotDeleteBinding;
import com.bedjet.bedjet.databinding.DialogFactoryResetBinding;
import com.bedjet.bedjet.databinding.DialogOldAppBinding;
import com.bedjet.bedjet.databinding.DialogOldAppInstalledBinding;
import com.bedjet.bedjet.databinding.DialogRenameBinding;
import com.bedjet.bedjet.ext.FirebaseExt;
import com.bedjet.bedjet.ext.IntentExt;
import com.bedjet.bedjet.ext.MainActivityExt;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.p001ui.main.RenameType;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CustomDialog.kt */
@Metadata(m942d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJA\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0013J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m943d2 = {"Lcom/bedjet/bedjet/ui/CustomDialog;", "", "firebaseTracker", "Lcom/bedjet/bedjet/utils/FirebaseTracker;", "<init>", "(Lcom/bedjet/bedjet/utils/FirebaseTracker;)V", "dialogs", "", "Landroidx/appcompat/app/AlertDialog;", "onDestroy", "", "showRenameMenu", "activity", "Lcom/bedjet/bedjet/ui/main/MainActivity;", "renameType", "Lcom/bedjet/bedjet/ui/main/RenameType;", "currentName", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "newName", "showCantDeleteDialog", "context", "Landroid/content/Context;", "showIncompatibleDialog", "showOldAppDialog", "showFailedBleAdapterDialog", "showOldAppInstalledDialog", "showFactoryResetDialog", "messageRes", "", "successListener", "Lkotlin/Function0;", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CustomDialog {
    private static String TAG = "CustomDialog";
    private final List<AlertDialog> dialogs;
    private final FirebaseTracker firebaseTracker;

    public CustomDialog(FirebaseTracker firebaseTracker) {
        Intrinsics.checkNotNullParameter(firebaseTracker, "firebaseTracker");
        this.firebaseTracker = firebaseTracker;
        this.dialogs = new ArrayList();
    }

    public final void onDestroy() {
        for (AlertDialog alertDialog : this.dialogs) {
            try {
                if (alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
            } catch (Exception e) {
                LoggerKt.exception(e);
            }
        }
    }

    public final void showRenameMenu(final MainActivity activity, RenameType renameType, String currentName, final Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(renameType, "renameType");
        Intrinsics.checkNotNullParameter(currentName, "currentName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showRenameMenu called");
        if (MainActivityExt.isNotResumed(activity)) {
            return;
        }
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_rename, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        final DialogRenameBinding dialogRenameBinding = (DialogRenameBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(activity).setView(dialogRenameBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialog.showRenameMenu$lambda$1(DialogRenameBinding.this, activity, listener, create, view);
            }
        };
        dialogRenameBinding.dialogRenameTitle.setText(renameType.getTitle());
        dialogRenameBinding.dialogRenameEditText.setText(currentName);
        dialogRenameBinding.dialogRenameButtonCancel.setOnClickListener(onClickListener);
        dialogRenameBinding.dialogRenameButtonOk.setOnClickListener(onClickListener);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRenameMenu$lambda$1(DialogRenameBinding dialogRenameBinding, MainActivity mainActivity, Function1 function1, AlertDialog alertDialog, View view) {
        if (view.getId() == C0624R.id.dialogRenameButtonOk) {
            Editable text = dialogRenameBinding.dialogRenameEditText.getText();
            String obj = text != null ? text.toString() : null;
            String str = obj;
            if (str == null || str.length() == 0) {
                dialogRenameBinding.dialogRenameInputLayout.setError(mainActivity.getString(C0624R.string.rename_dialog_validation_error));
                return;
            }
            function1.invoke(obj);
        }
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    public final void showCantDeleteDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showCantDeleteDialog called");
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_cannot_delete, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogCannotDeleteBinding dialogCannotDeleteBinding = (DialogCannotDeleteBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(context).setView(dialogCannotDeleteBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        dialogCannotDeleteBinding.dialogCantDeleteButtonOk.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialog.showCantDeleteDialog$lambda$2(AlertDialog.this, view);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCantDeleteDialog$lambda$2(AlertDialog alertDialog, View view) {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    public final void showIncompatibleDialog(MainActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showIncompatibleDialog called");
        if (MainActivityExt.isNotResumed(activity)) {
            return;
        }
        new AlertDialog.Builder(activity).setTitle(C0624R.string.dialog_incompatible_app_title).setMessage(C0624R.string.dialog_incompatible_app_message).setNeutralButton(C0624R.string.btn_ok, (DialogInterface.OnClickListener) null).show();
        this.firebaseTracker.trackScreen("IncompatibleDialog");
    }

    public final void showOldAppDialog(final MainActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showOldAppDialog called");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        FirebaseExt.updateRemoteConfig(firebaseRemoteConfig, new Function0() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showOldAppDialog$lambda$5;
                showOldAppDialog$lambda$5 = CustomDialog.showOldAppDialog$lambda$5(MainActivity.this, this);
                return showOldAppDialog$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showOldAppDialog$lambda$5(final MainActivity mainActivity, final CustomDialog customDialog) {
        String string = FirebaseRemoteConfig.getInstance().getString(FirebaseConstants.FIREBASE_KEY_FEATURES);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() == 0) {
            return Unit.INSTANCE;
        }
        boolean optBoolean = new JSONObject(string).optBoolean(FirebaseConstants.FIREBASE_KEY_OLD_APP);
        final String optString = new JSONObject(string).optString(FirebaseConstants.FIREBASE_KEY_OLD_APP_PACKAGE_NAME);
        if (optBoolean) {
            Intrinsics.checkNotNull(optString);
            if (optString.length() != 0) {
                if (MainActivityExt.isNotResumed(mainActivity)) {
                    return Unit.INSTANCE;
                }
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                LoggerKt.logTag(TAG2, ".showOldAppDialog need show");
                Object systemService = mainActivity.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_old_app, null, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                DialogOldAppBinding dialogOldAppBinding = (DialogOldAppBinding) inflate;
                final AlertDialog create = new AlertDialog.Builder(mainActivity).setView(dialogOldAppBinding.getRoot()).create();
                Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CustomDialog.showOldAppDialog$lambda$5$lambda$4(CustomDialog.this, optString, mainActivity, create, view);
                    }
                };
                dialogOldAppBinding.dialogOldAppButtonCancel.setOnClickListener(onClickListener);
                dialogOldAppBinding.dialogOldAppButtonSuccess.setOnClickListener(onClickListener);
                create.setCancelable(false);
                create.show();
                customDialog.firebaseTracker.trackScreen("OldAppDialog");
                customDialog.firebaseTracker.eventOldAppDialogShowed();
                customDialog.dialogs.add(create);
                return Unit.INSTANCE;
            }
        }
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        LoggerKt.logTag(TAG3, ".showOldAppDialog no need show");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOldAppDialog$lambda$5$lambda$4(CustomDialog customDialog, String str, MainActivity mainActivity, AlertDialog alertDialog, View view) {
        int id = view.getId();
        if (id == C0624R.id.dialogOldAppButtonCancel) {
            customDialog.firebaseTracker.eventOldAppDialogButtonCancel();
        } else if (id == C0624R.id.dialogOldAppButtonSuccess) {
            customDialog.firebaseTracker.eventOldAppDialogButtonInstall();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            MainActivity mainActivity2 = mainActivity;
            if (IntentExt.isResolveIntent(intent, mainActivity2)) {
                mainActivity.startActivity(intent);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
                if (IntentExt.isResolveIntent(intent2, mainActivity2)) {
                    mainActivity.startActivity(intent2);
                }
            }
        }
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
            customDialog.dialogs.remove(alertDialog);
        }
    }

    public final void showFailedBleAdapterDialog(MainActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showFailedBleAdapterDialog called");
        new AlertDialog.Builder(activity).setTitle(C0624R.string.dialog_ble_failed_title).setMessage(C0624R.string.dialog_ble_failed_message).setCancelable(false).setPositiveButton(C0624R.string.btn_ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CustomDialog.showFailedBleAdapterDialog$lambda$6(dialogInterface, i);
            }
        }).show();
        this.firebaseTracker.trackScreen("FailedBleAdapterDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFailedBleAdapterDialog$lambda$6(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final void showOldAppInstalledDialog(final MainActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showOldAppInstalledDialog called");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        FirebaseExt.updateRemoteConfig(firebaseRemoteConfig, new Function0() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showOldAppInstalledDialog$lambda$8;
                showOldAppInstalledDialog$lambda$8 = CustomDialog.showOldAppInstalledDialog$lambda$8(MainActivity.this, this);
                return showOldAppInstalledDialog$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showOldAppInstalledDialog$lambda$8(MainActivity mainActivity, CustomDialog customDialog) {
        String string = FirebaseRemoteConfig.getInstance().getString(FirebaseConstants.FIREBASE_KEY_FEATURES);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() == 0) {
            return Unit.INSTANCE;
        }
        if (!new JSONObject(string).optBoolean(FirebaseConstants.FIREBASE_KEY_OLD_APP_INSTALLED_DIALOG)) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LoggerKt.logTag(TAG2, ".showOldAppInstalledDialog no need show");
            return Unit.INSTANCE;
        }
        if (MainActivityExt.isNotResumed(mainActivity)) {
            return Unit.INSTANCE;
        }
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        LoggerKt.logTag(TAG3, ".showOldAppInstalledDialog need show");
        Object systemService = mainActivity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_old_app_installed, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogOldAppInstalledBinding dialogOldAppInstalledBinding = (DialogOldAppInstalledBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(mainActivity).setView(dialogOldAppInstalledBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        dialogOldAppInstalledBinding.dialogOldAppInstalledButtonOk.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialog.showOldAppInstalledDialog$lambda$8$lambda$7(AlertDialog.this, view);
            }
        });
        create.show();
        customDialog.firebaseTracker.trackScreen("OldAppInstalledDialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOldAppInstalledDialog$lambda$8$lambda$7(AlertDialog alertDialog, View view) {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    public final void showFactoryResetDialog(Context context, int messageRes, final Function0<Unit> successListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(successListener, "successListener");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".showFactoryResetDialog called, messageRes: " + messageRes);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ViewDataBinding inflate = DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_factory_reset, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DialogFactoryResetBinding dialogFactoryResetBinding = (DialogFactoryResetBinding) inflate;
        final AlertDialog create = new AlertDialog.Builder(context).setView(dialogFactoryResetBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.CustomDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialog.showFactoryResetDialog$lambda$9(Function0.this, create, view);
            }
        };
        dialogFactoryResetBinding.dialogFactoryResetMessage.setText(messageRes);
        dialogFactoryResetBinding.dialogFactoryResetButtonNo.setOnClickListener(onClickListener);
        dialogFactoryResetBinding.dialogFactoryResetButtonYes.setOnClickListener(onClickListener);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFactoryResetDialog$lambda$9(Function0 function0, AlertDialog alertDialog, View view) {
        if (view.getId() == C0624R.id.dialogFactoryResetButtonYes) {
            function0.invoke();
        }
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}
