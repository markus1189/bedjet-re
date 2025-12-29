package com.bedjet.bedjet.p001ui.main.pair;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.DialogPairBinding;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.p002v2.V2Manager;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.SaveBoundedFlagFirebaseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.java.KoinJavaComponent;

/* compiled from: PairBedJetManager.kt */
@Metadata(m942d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/pair/PairBedJetManager;", "", "context", "Landroid/content/Context;", "linkingBedJetListener", "Lcom/bedjet/bedjet/ui/main/pair/PairBedJetManager$PairBedJetListener;", "<init>", "(Landroid/content/Context;Lcom/bedjet/bedjet/ui/main/pair/PairBedJetManager$PairBedJetListener;)V", "pairPhase", "Lcom/bedjet/bedjet/ui/main/pair/PairPhase;", "dualZoneState", "", "pairDialog", "Landroid/app/Dialog;", "bindingDialog", "Lcom/bedjet/bedjet/databinding/DialogPairBinding;", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "v2Manager", "Lcom/bedjet/bedjet/ui/main/v2/V2Manager;", "firebaseTracker", "Lcom/bedjet/bedjet/utils/FirebaseTracker;", "setStartedPhase", "", "linkBedjet", "dualZone", "isV3", "makeLinkingDialog", "Companion", "PairBedJetListener", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PairBedJetManager {
    private static String TAG = "PairBedJetManager";
    private DialogPairBinding bindingDialog;
    private final Context context;
    private boolean dualZoneState;
    private final FirebaseTracker firebaseTracker;
    private final PairBedJetListener linkingBedJetListener;
    private Dialog pairDialog;
    private PairPhase pairPhase;
    private final StoredDeviceManager storedDeviceManager;
    private final V2Manager v2Manager;

    /* compiled from: PairBedJetManager.kt */
    @Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/pair/PairBedJetManager$PairBedJetListener;", "", "onCancel", "", "senData", "command", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface PairBedJetListener {
        void onCancel();

        void senData(String command);
    }

    /* compiled from: PairBedJetManager.kt */
    @Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PairPhase.values().length];
            try {
                iArr[PairPhase.PAIR_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PairPhase.PAIR_FLIP_SWITCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PairPhase.PAIR_FLIP_BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PairPhase.PAIR_INFO_READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PairPhase.PAIR_SET_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PairBedJetManager(Context context, PairBedJetListener linkingBedJetListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(linkingBedJetListener, "linkingBedJetListener");
        this.context = context;
        this.linkingBedJetListener = linkingBedJetListener;
        this.storedDeviceManager = (StoredDeviceManager) KoinJavaComponent.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), null, null);
        this.v2Manager = (V2Manager) KoinJavaComponent.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(V2Manager.class), null, null);
        this.firebaseTracker = (FirebaseTracker) KoinJavaComponent.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FirebaseTracker.class), null, null);
    }

    public final void setStartedPhase() {
        this.pairPhase = PairPhase.PAIR_STARTED;
    }

    public final void linkBedjet(boolean dualZone, boolean isV3) {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".linkBedjet dualZone: " + dualZone + ", isV3: " + isV3 + ", pairPhase: " + this.pairPhase);
        if (this.pairPhase != PairPhase.PAIR_STARTED && this.pairDialog == null) {
            this.linkingBedJetListener.onCancel();
            this.pairPhase = PairPhase.PAIR_STARTED;
            return;
        }
        PairPhase pairPhase = this.pairPhase;
        int i = pairPhase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[pairPhase.ordinal()];
        if (i == 1) {
            this.dualZoneState = dualZone;
            this.pairPhase = PairPhase.PAIR_FLIP_SWITCH;
            makeLinkingDialog(this.dualZoneState, isV3);
            return;
        }
        if (i == 2) {
            if (this.dualZoneState != dualZone) {
                this.pairPhase = PairPhase.PAIR_FLIP_BACK;
                makeLinkingDialog(!this.dualZoneState, isV3);
                return;
            }
            return;
        }
        if (i == 3) {
            if (this.dualZoneState == dualZone) {
                this.pairPhase = PairPhase.PAIR_ZONE_INFO;
                makeLinkingDialog(false, isV3);
                return;
            }
            return;
        }
        if (i == 4) {
            Dialog dialog = this.pairDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (isV3) {
                this.storedDeviceManager.setBondedFlag(0);
                return;
            } else {
                this.linkingBedJetListener.senData("getname");
                this.pairPhase = PairPhase.PAIR_SET_NAME;
                return;
            }
        }
        if (i != 5) {
            return;
        }
        boolean nameReceived = this.v2Manager.getNameReceived();
        LoggerKt.m516e(new SaveBoundedFlagFirebaseException("nameReceived " + nameReceived));
        if (nameReceived) {
            this.storedDeviceManager.setBondedFlag(0);
        }
    }

    private final void makeLinkingDialog(boolean dualZoneState, boolean isV3) {
        Window window;
        View decorView;
        int i;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".makeLinkingDialog dualZoneState: " + dualZoneState + ", isV3: " + isV3 + ", pairPhase: " + this.pairPhase);
        if (this.pairDialog == null) {
            Dialog dialog = new Dialog(this.context, C0624R.style.AppTheme);
            Object systemService = dialog.getContext().getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            DialogPairBinding dialogPairBinding = (DialogPairBinding) DataBindingUtil.inflate((LayoutInflater) systemService, C0624R.layout.dialog_pair, null, false);
            dialog.setContentView(dialogPairBinding.getRoot());
            this.bindingDialog = dialogPairBinding;
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bedjet.bedjet.ui.main.pair.PairBedJetManager$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    PairBedJetManager.makeLinkingDialog$lambda$2$lambda$1(PairBedJetManager.this, dialogInterface);
                }
            });
            this.pairDialog = dialog;
        }
        DialogPairBinding dialogPairBinding2 = this.bindingDialog;
        if (dialogPairBinding2 != null) {
            dialogPairBinding2.buttonCancelDialogPair.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.main.pair.PairBedJetManager$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PairBedJetManager.makeLinkingDialog$lambda$4$lambda$3(PairBedJetManager.this, view);
                }
            });
            dialogPairBinding2.imageDialogPair.setImageResource(isV3 ? C0624R.drawable.image_pair_dialog_v3 : C0624R.drawable.image_pair_dialog_v2);
            if (this.pairPhase == PairPhase.PAIR_ZONE_INFO) {
                dialogPairBinding2.titleDialogPair.setText(isV3 ? C0624R.string.dialog_pair_title_finished_V3 : C0624R.string.dialog_pair_title_finished_V2);
                dialogPairBinding2.descriptionDialogPair.setText(isV3 ? C0624R.string.dialog_pair_description_finished_V3 : C0624R.string.dialog_pair_description_finished_V2);
                dialogPairBinding2.promptDialogPair.setVisibility(4);
                dialogPairBinding2.buttonCancelDialogPair.setText(C0624R.string.dialog_pair_prompt_button_ok);
            } else {
                dialogPairBinding2.descriptionDialogPair.setText(isV3 ? C0624R.string.dialog_pair_description_V3 : C0624R.string.dialog_pair_description_V2);
                dialogPairBinding2.promptDialogPair.setVisibility(0);
                if (isV3) {
                    i = this.pairPhase == PairPhase.PAIR_FLIP_SWITCH ? C0624R.string.dialog_pair_prompt_V3_first : C0624R.string.dialog_pair_prompt_V3_second;
                } else {
                    i = dualZoneState ? C0624R.string.dialog_pair_prompt_V2_high : C0624R.string.dialog_pair_prompt_V2_low;
                }
                dialogPairBinding2.promptDialogPair.setText(i);
                dialogPairBinding2.buttonCancelDialogPair.setText(C0624R.string.dialog_pair_prompt_button_cancel);
            }
        }
        Dialog dialog2 = this.pairDialog;
        if (dialog2 != null && (window = dialog2.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.bedjet.bedjet.ui.main.pair.PairBedJetManager$$ExternalSyntheticLambda2
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat makeLinkingDialog$lambda$6$lambda$5;
                    makeLinkingDialog$lambda$6$lambda$5 = PairBedJetManager.makeLinkingDialog$lambda$6$lambda$5(view, windowInsetsCompat);
                    return makeLinkingDialog$lambda$6$lambda$5;
                }
            });
        }
        Dialog dialog3 = this.pairDialog;
        if (dialog3 != null) {
            dialog3.show();
        }
        this.firebaseTracker.trackScreen("PairDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeLinkingDialog$lambda$2$lambda$1(PairBedJetManager pairBedJetManager, DialogInterface dialogInterface) {
        pairBedJetManager.linkingBedJetListener.onCancel();
        pairBedJetManager.pairPhase = PairPhase.PAIR_STARTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeLinkingDialog$lambda$4$lambda$3(PairBedJetManager pairBedJetManager, View view) {
        if (pairBedJetManager.pairPhase == PairPhase.PAIR_ZONE_INFO) {
            pairBedJetManager.pairPhase = PairPhase.PAIR_INFO_READ;
            return;
        }
        pairBedJetManager.linkingBedJetListener.onCancel();
        pairBedJetManager.pairPhase = PairPhase.PAIR_STARTED;
        Dialog dialog = pairBedJetManager.pairDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        pairBedJetManager.pairDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat makeLinkingDialog$lambda$6$lambda$5(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }
}
