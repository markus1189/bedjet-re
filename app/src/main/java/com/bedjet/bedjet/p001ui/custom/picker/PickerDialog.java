package com.bedjet.bedjet.p001ui.custom.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.p001ui.custom.picker.PickerListener;
import com.bedjet.bedjet.p001ui.custom.picker.PickerMode;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.utils.FirebaseTracker;
import com.bedjet.bedjet.utils.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.koin.java.KoinJavaComponent;

/* compiled from: PickerDialog.kt */
@Metadata(m942d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u001cH\u0002J\"\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0002J\"\u0010\"\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\tH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerDialog;", "", "context", "Landroid/content/Context;", "doublePicker", "", "pickerMode", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "leftLabel", "", "rightLabel", "wrapSelectorWheel", "pickerListener", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener;", "<init>", "(Landroid/content/Context;ZLcom/bedjet/bedjet/ui/custom/picker/PickerMode;ILjava/lang/Integer;ZLcom/bedjet/bedjet/ui/custom/picker/PickerListener;)V", "firebaseTracker", "Lcom/bedjet/bedjet/utils/FirebaseTracker;", "initTurboPicker", "", "numberPicker", "Landroid/widget/NumberPicker;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Turbo;", "initTimerPicker", "numberPickerLeft", "numberPickerRight", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Timer;", "initTempPicker", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Temp;", "initWorkModePicker", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$WorkMode;", "parseTime", "", "time", "stateRightPickerForWait", "position", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PickerDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PickerDialog";
    private final FirebaseTracker firebaseTracker;

    public PickerDialog(Context context, final boolean z, PickerMode pickerMode, int i, Integer num, boolean z2, final PickerListener pickerListener) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pickerMode, "pickerMode");
        Intrinsics.checkNotNullParameter(pickerListener, "pickerListener");
        FirebaseTracker firebaseTracker = (FirebaseTracker) KoinJavaComponent.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FirebaseTracker.class), null, null);
        this.firebaseTracker = firebaseTracker;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = View.inflate(context, z ? C0624R.layout.dialog_picker_double : C0624R.layout.dialog_picker_single, null);
        ((AppCompatTextView) inflate.findViewById(C0624R.id.leftLabel)).setText(i);
        if (z) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(C0624R.id.rightLabel);
            if (num == null) {
                throw new IllegalStateException();
            }
            appCompatTextView.setText(num.intValue());
        }
        View findViewById = inflate.findViewById(C0624R.id.leftPicker);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final NumberPicker numberPicker = (NumberPicker) findViewById;
        final NumberPicker numberPicker2 = z ? (NumberPicker) inflate.findViewById(C0624R.id.rightPicker) : null;
        numberPicker.setWrapSelectorWheel(z2);
        if (numberPicker2 != null) {
            numberPicker2.setWrapSelectorWheel(z2);
        }
        numberPicker.setDescendantFocusability(393216);
        if (numberPicker2 != null) {
            numberPicker2.setDescendantFocusability(393216);
        }
        boolean z3 = pickerMode instanceof PickerMode.Turbo;
        if (z3) {
            initTurboPicker(numberPicker, (PickerMode.Turbo) pickerMode);
        } else if (pickerMode instanceof PickerMode.Timer) {
            initTimerPicker(numberPicker, numberPicker2, (PickerMode.Timer) pickerMode);
        } else if (pickerMode instanceof PickerMode.Temp) {
            initTempPicker(numberPicker, (PickerMode.Temp) pickerMode);
        } else {
            if (!(pickerMode instanceof PickerMode.WorkMode)) {
                throw new NoWhenBranchMatchedException();
            }
            initWorkModePicker(numberPicker, numberPicker2, (PickerMode.WorkMode) pickerMode);
        }
        builder.setPositiveButton(C0624R.string.btn_ok, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.custom.picker.PickerDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PickerDialog._init_$lambda$0(numberPicker, z, numberPicker2, pickerListener, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(C0624R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.custom.picker.PickerDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.setView(inflate);
        builder.create().show();
        if (pickerMode instanceof PickerMode.Temp) {
            str = "TempDialog";
        } else if (pickerMode instanceof PickerMode.Timer) {
            str = "TimerDialog";
        } else if (z3) {
            str = "TurboDialog";
        } else {
            if (!(pickerMode instanceof PickerMode.WorkMode)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "WorkModeDialog";
        }
        firebaseTracker.trackScreen(str);
    }

    public /* synthetic */ PickerDialog(Context context, boolean z, PickerMode pickerMode, int i, Integer num, boolean z2, PickerListener pickerListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, pickerMode, i, (i2 & 16) != 0 ? null : num, z2, pickerListener);
    }

    /* compiled from: PickerDialog.kt */
    @Metadata(m942d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJB\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerDialog$Companion;", "", "<init>", "()V", "TAG", "", "showTurboDialog", "", "context", "Landroid/content/Context;", "startPosition", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$SinglePickerListener;", "showTimerDialog", "sequenceStep", "Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "leftStartPosition", "rightStartPosition", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$DoublePickerListener;", "showTempDialog", "useCelsius", "", "startValue", "showWorkModeDialog", "leftData", "", "rightData", "leftStartValue", "rightStartValue", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showTurboDialog(Context context, int startPosition, PickerListener.SinglePickerListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listener, "listener");
            boolean z = false;
            new PickerDialog(context, z, new PickerMode.Turbo(startPosition), C0624R.string.picker_title_time, null, false, listener, 16, null);
        }

        public final void showTimerDialog(Context context, SequenceStep sequenceStep, int leftStartPosition, int rightStartPosition, PickerListener.DoublePickerListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            Intrinsics.checkNotNullParameter(listener, "listener");
            new PickerDialog(context, true, new PickerMode.Timer(sequenceStep, leftStartPosition, rightStartPosition), C0624R.string.picker_title_hours, Integer.valueOf(C0624R.string.picker_title_minutes), false, listener);
        }

        public final void showTempDialog(Context context, SequenceStep sequenceStep, boolean useCelsius, String startValue, PickerListener.SinglePickerListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            Intrinsics.checkNotNullParameter(startValue, "startValue");
            Intrinsics.checkNotNullParameter(listener, "listener");
            boolean z = false;
            new PickerDialog(context, z, new PickerMode.Temp(sequenceStep, useCelsius, startValue), C0624R.string.picker_title_temperature, null, true, listener, 16, null);
        }

        public final void showWorkModeDialog(Context context, List<String> leftData, List<String> rightData, String leftStartValue, String rightStartValue, PickerListener.DoublePickerListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(leftData, "leftData");
            Intrinsics.checkNotNullParameter(rightData, "rightData");
            Intrinsics.checkNotNullParameter(leftStartValue, "leftStartValue");
            Intrinsics.checkNotNullParameter(rightStartValue, "rightStartValue");
            Intrinsics.checkNotNullParameter(listener, "listener");
            new PickerDialog(context, true, new PickerMode.WorkMode(leftData, rightData, leftStartValue, rightStartValue), C0624R.string.picker_title_mode, Integer.valueOf(C0624R.string.picker_title_fan), false, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(NumberPicker numberPicker, boolean z, NumberPicker numberPicker2, PickerListener pickerListener, DialogInterface dialogInterface, int i) {
        String[] displayedValues;
        String str;
        String str2 = numberPicker.getDisplayedValues()[numberPicker.getValue()];
        if (!z) {
            Intrinsics.checkNotNull(pickerListener, "null cannot be cast to non-null type com.bedjet.bedjet.ui.custom.picker.PickerListener.SinglePickerListener");
            Intrinsics.checkNotNull(str2);
            ((PickerListener.SinglePickerListener) pickerListener).onPickerSet(str2);
        } else {
            if (numberPicker2 == null || (displayedValues = numberPicker2.getDisplayedValues()) == null || (str = displayedValues[numberPicker2.getValue()]) == null) {
                throw new IllegalStateException();
            }
            Intrinsics.checkNotNull(pickerListener, "null cannot be cast to non-null type com.bedjet.bedjet.ui.custom.picker.PickerListener.DoublePickerListener");
            Intrinsics.checkNotNull(str2);
            ((PickerListener.DoublePickerListener) pickerListener).onPickerSet(str2, str);
        }
        dialogInterface.dismiss();
    }

    private final void initTurboPicker(NumberPicker numberPicker, PickerMode.Turbo pickerMode) {
        LoggerKt.log("PickerDialog.initTurboPicker pickerMode = [" + pickerMode + "]");
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < 11) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "%d min%s", Arrays.copyOf(new Object[]{Integer.valueOf(i), i == 1 ? "" : "s"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            arrayList.add(format);
            i++;
        }
        int size = arrayList.size() - 1;
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(size);
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        int startPosition = pickerMode.getStartPosition();
        if (startPosition < 0 || startPosition > size) {
            return;
        }
        numberPicker.setValue(pickerMode.getStartPosition());
    }

    private final void initTimerPicker(NumberPicker numberPickerLeft, NumberPicker numberPickerRight, PickerMode.Timer pickerMode) {
        LoggerKt.log("PickerDialog.initTimerPicker pickerMode = [" + pickerMode + "]");
        SequenceStep sequenceStep = pickerMode.getSequenceStep();
        int maxRunTime = sequenceStep.isClocktime() ? 23 : Utils.getMaxRunTime(sequenceStep.getMode(), sequenceStep.getTemperature(), sequenceStep.getFanStep());
        LoggerKt.log("PickerDialog initTimerPicker, isClocktime = " + sequenceStep.isClocktime() + ", Fan = " + sequenceStep.getFanStep() + ", Temp = " + sequenceStep.getTemperature() + ", Mode = " + sequenceStep.getMode() + ", maxHours is " + maxRunTime);
        ArrayList arrayList = new ArrayList();
        if (maxRunTime >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(parseTime(i));
                if (i == maxRunTime) {
                    break;
                } else {
                    i++;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 60; i2++) {
            arrayList2.add(parseTime(i2));
        }
        int size = arrayList.size() - 1;
        numberPickerLeft.setMinValue(0);
        numberPickerLeft.setMaxValue(size);
        numberPickerLeft.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        int leftStartPosition = pickerMode.getLeftStartPosition();
        if (leftStartPosition >= 0 && leftStartPosition <= size) {
            numberPickerLeft.setValue(pickerMode.getLeftStartPosition());
        }
        if (numberPickerRight != null) {
            int size2 = arrayList2.size() - 1;
            numberPickerRight.setMinValue(0);
            numberPickerRight.setMaxValue(size2);
            numberPickerRight.setDisplayedValues((String[]) arrayList2.toArray(new String[0]));
            int rightStartPosition = pickerMode.getRightStartPosition();
            if (rightStartPosition < 0 || rightStartPosition > size2) {
                return;
            }
            numberPickerRight.setValue(pickerMode.getRightStartPosition());
        }
    }

    private final void initTempPicker(NumberPicker numberPickerLeft, PickerMode.Temp pickerMode) {
        LoggerKt.log("PickerDialog.initTempPicker pickerMode = [" + pickerMode + "]");
        ArrayList arrayList = new ArrayList();
        int minMaxTemp = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), false);
        int minMaxTemp2 = Utils.getMinMaxTemp(pickerMode.getSequenceStep().getMode(), true);
        if (pickerMode.getUseCelsius()) {
            for (int i = minMaxTemp & (-2); i <= minMaxTemp2; i += 2) {
                String renderTemp = Utils.renderTemp(i, true);
                Intrinsics.checkNotNullExpressionValue(renderTemp, "renderTemp(...)");
                arrayList.add(renderTemp);
            }
        } else {
            while (minMaxTemp <= minMaxTemp2) {
                String renderTemp2 = Utils.renderTemp(minMaxTemp, false);
                Intrinsics.checkNotNullExpressionValue(renderTemp2, "renderTemp(...)");
                arrayList.add(renderTemp2);
                minMaxTemp = Utils.adjustTempF(minMaxTemp, false);
            }
            arrayList = CollectionsKt.toMutableList((Collection) CollectionsKt.distinct(arrayList));
        }
        int size = arrayList.size() - 1;
        numberPickerLeft.setMinValue(0);
        numberPickerLeft.setMaxValue(size);
        numberPickerLeft.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
        int indexOf = arrayList.indexOf(pickerMode.getStartValue());
        if (indexOf < 0 || indexOf > size) {
            return;
        }
        numberPickerLeft.setValue(indexOf);
    }

    private final void initWorkModePicker(NumberPicker numberPickerLeft, final NumberPicker numberPickerRight, PickerMode.WorkMode pickerMode) {
        LoggerKt.log("PickerDialog.initWorkModePicker pickerMode = [" + pickerMode + "]");
        int size = pickerMode.getLeftData().size() + (-1);
        numberPickerLeft.setMinValue(0);
        numberPickerLeft.setMaxValue(size);
        numberPickerLeft.setDisplayedValues((String[]) pickerMode.getLeftData().toArray(new String[0]));
        int indexOf = pickerMode.getLeftData().indexOf(pickerMode.getLeftStartValue());
        if (indexOf >= 0 && indexOf <= size) {
            numberPickerLeft.setValue(indexOf);
            stateRightPickerForWait(numberPickerLeft, numberPickerRight, indexOf);
        }
        if (numberPickerRight != null) {
            int size2 = pickerMode.getRightData().size() - 1;
            numberPickerRight.setMinValue(0);
            numberPickerRight.setMaxValue(size2);
            numberPickerRight.setDisplayedValues((String[]) pickerMode.getRightData().toArray(new String[0]));
            int indexOf2 = pickerMode.getRightData().indexOf(pickerMode.getRightStartValue());
            if (indexOf2 >= 0 && indexOf2 <= size2) {
                numberPickerRight.setValue(indexOf2);
            }
        }
        numberPickerLeft.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.bedjet.bedjet.ui.custom.picker.PickerDialog$$ExternalSyntheticLambda0
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                PickerDialog.initWorkModePicker$lambda$8(PickerDialog.this, numberPickerRight, numberPicker, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWorkModePicker$lambda$8(PickerDialog pickerDialog, NumberPicker numberPicker, NumberPicker numberPicker2, int i, int i2) {
        Intrinsics.checkNotNull(numberPicker2);
        pickerDialog.stateRightPickerForWait(numberPicker2, numberPicker, i2);
    }

    private final String parseTime(int time) {
        if (time >= 10) {
            return String.valueOf(time);
        }
        return "0" + time;
    }

    private final void stateRightPickerForWait(NumberPicker numberPickerLeft, NumberPicker numberPickerRight, int position) {
        if (numberPickerRight != null) {
            numberPickerRight.setEnabled(!Intrinsics.areEqual(numberPickerLeft.getDisplayedValues()[position], "Wait"));
        }
    }
}
