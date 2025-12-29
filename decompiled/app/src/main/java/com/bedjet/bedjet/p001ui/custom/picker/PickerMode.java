package com.bedjet.bedjet.p001ui.custom.picker;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.Constants;
import com.bedjet.bedjet.data.local.model.CurrentStatus$$ExternalSyntheticBackport0;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickerMode.kt */
@Metadata(m942d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "", Constants.MODENAME_TURBO, "Timer", "Temp", "WorkMode", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Temp;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Timer;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Turbo;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$WorkMode;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface PickerMode {

    /* compiled from: PickerMode.kt */
    @Metadata(m942d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Turbo;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "startPosition", "", "<init>", "(I)V", "getStartPosition", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class Turbo implements PickerMode {
        private final int startPosition;

        public static /* synthetic */ Turbo copy$default(Turbo turbo, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = turbo.startPosition;
            }
            return turbo.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartPosition() {
            return this.startPosition;
        }

        public final Turbo copy(int startPosition) {
            return new Turbo(startPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Turbo) && this.startPosition == ((Turbo) other).startPosition;
        }

        public int hashCode() {
            return this.startPosition;
        }

        public String toString() {
            return "Turbo(startPosition=" + this.startPosition + ")";
        }

        public Turbo(int i) {
            this.startPosition = i;
        }

        public final int getStartPosition() {
            return this.startPosition;
        }
    }

    /* compiled from: PickerMode.kt */
    @Metadata(m942d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Timer;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "sequenceStep", "Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "leftStartPosition", "", "rightStartPosition", "<init>", "(Lcom/bedjet/bedjet/data/local/model/SequenceStep;II)V", "getSequenceStep", "()Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "getLeftStartPosition", "()I", "getRightStartPosition", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class Timer implements PickerMode {
        private final int leftStartPosition;
        private final int rightStartPosition;
        private final SequenceStep sequenceStep;

        public static /* synthetic */ Timer copy$default(Timer timer, SequenceStep sequenceStep, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                sequenceStep = timer.sequenceStep;
            }
            if ((i3 & 2) != 0) {
                i = timer.leftStartPosition;
            }
            if ((i3 & 4) != 0) {
                i2 = timer.rightStartPosition;
            }
            return timer.copy(sequenceStep, i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final SequenceStep getSequenceStep() {
            return this.sequenceStep;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLeftStartPosition() {
            return this.leftStartPosition;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRightStartPosition() {
            return this.rightStartPosition;
        }

        public final Timer copy(SequenceStep sequenceStep, int leftStartPosition, int rightStartPosition) {
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            return new Timer(sequenceStep, leftStartPosition, rightStartPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Timer)) {
                return false;
            }
            Timer timer = (Timer) other;
            return Intrinsics.areEqual(this.sequenceStep, timer.sequenceStep) && this.leftStartPosition == timer.leftStartPosition && this.rightStartPosition == timer.rightStartPosition;
        }

        public int hashCode() {
            return (((this.sequenceStep.hashCode() * 31) + this.leftStartPosition) * 31) + this.rightStartPosition;
        }

        public String toString() {
            return "Timer(sequenceStep=" + this.sequenceStep + ", leftStartPosition=" + this.leftStartPosition + ", rightStartPosition=" + this.rightStartPosition + ")";
        }

        public Timer(SequenceStep sequenceStep, int i, int i2) {
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            this.sequenceStep = sequenceStep;
            this.leftStartPosition = i;
            this.rightStartPosition = i2;
        }

        public final int getLeftStartPosition() {
            return this.leftStartPosition;
        }

        public final int getRightStartPosition() {
            return this.rightStartPosition;
        }

        public final SequenceStep getSequenceStep() {
            return this.sequenceStep;
        }
    }

    /* compiled from: PickerMode.kt */
    @Metadata(m942d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$Temp;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "sequenceStep", "Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "useCelsius", "", "startValue", "", "<init>", "(Lcom/bedjet/bedjet/data/local/model/SequenceStep;ZLjava/lang/String;)V", "getSequenceStep", "()Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "getUseCelsius", "()Z", "getStartValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class Temp implements PickerMode {
        private final SequenceStep sequenceStep;
        private final String startValue;
        private final boolean useCelsius;

        public static /* synthetic */ Temp copy$default(Temp temp, SequenceStep sequenceStep, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                sequenceStep = temp.sequenceStep;
            }
            if ((i & 2) != 0) {
                z = temp.useCelsius;
            }
            if ((i & 4) != 0) {
                str = temp.startValue;
            }
            return temp.copy(sequenceStep, z, str);
        }

        /* renamed from: component1, reason: from getter */
        public final SequenceStep getSequenceStep() {
            return this.sequenceStep;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getUseCelsius() {
            return this.useCelsius;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStartValue() {
            return this.startValue;
        }

        public final Temp copy(SequenceStep sequenceStep, boolean useCelsius, String startValue) {
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            Intrinsics.checkNotNullParameter(startValue, "startValue");
            return new Temp(sequenceStep, useCelsius, startValue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Temp)) {
                return false;
            }
            Temp temp = (Temp) other;
            return Intrinsics.areEqual(this.sequenceStep, temp.sequenceStep) && this.useCelsius == temp.useCelsius && Intrinsics.areEqual(this.startValue, temp.startValue);
        }

        public int hashCode() {
            return (((this.sequenceStep.hashCode() * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.useCelsius)) * 31) + this.startValue.hashCode();
        }

        public String toString() {
            return "Temp(sequenceStep=" + this.sequenceStep + ", useCelsius=" + this.useCelsius + ", startValue=" + this.startValue + ")";
        }

        public Temp(SequenceStep sequenceStep, boolean z, String startValue) {
            Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
            Intrinsics.checkNotNullParameter(startValue, "startValue");
            this.sequenceStep = sequenceStep;
            this.useCelsius = z;
            this.startValue = startValue;
        }

        public final SequenceStep getSequenceStep() {
            return this.sequenceStep;
        }

        public final String getStartValue() {
            return this.startValue;
        }

        public final boolean getUseCelsius() {
            return this.useCelsius;
        }
    }

    /* compiled from: PickerMode.kt */
    @Metadata(m942d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerMode$WorkMode;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerMode;", "leftData", "", "", "rightData", "leftStartValue", "rightStartValue", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getLeftData", "()Ljava/util/List;", "getRightData", "getLeftStartValue", "()Ljava/lang/String;", "getRightStartValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class WorkMode implements PickerMode {
        private final List<String> leftData;
        private final String leftStartValue;
        private final List<String> rightData;
        private final String rightStartValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkMode copy$default(WorkMode workMode, List list, List list2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = workMode.leftData;
            }
            if ((i & 2) != 0) {
                list2 = workMode.rightData;
            }
            if ((i & 4) != 0) {
                str = workMode.leftStartValue;
            }
            if ((i & 8) != 0) {
                str2 = workMode.rightStartValue;
            }
            return workMode.copy(list, list2, str, str2);
        }

        public final List<String> component1() {
            return this.leftData;
        }

        public final List<String> component2() {
            return this.rightData;
        }

        /* renamed from: component3, reason: from getter */
        public final String getLeftStartValue() {
            return this.leftStartValue;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRightStartValue() {
            return this.rightStartValue;
        }

        public final WorkMode copy(List<String> leftData, List<String> rightData, String leftStartValue, String rightStartValue) {
            Intrinsics.checkNotNullParameter(leftData, "leftData");
            Intrinsics.checkNotNullParameter(rightData, "rightData");
            Intrinsics.checkNotNullParameter(leftStartValue, "leftStartValue");
            Intrinsics.checkNotNullParameter(rightStartValue, "rightStartValue");
            return new WorkMode(leftData, rightData, leftStartValue, rightStartValue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkMode)) {
                return false;
            }
            WorkMode workMode = (WorkMode) other;
            return Intrinsics.areEqual(this.leftData, workMode.leftData) && Intrinsics.areEqual(this.rightData, workMode.rightData) && Intrinsics.areEqual(this.leftStartValue, workMode.leftStartValue) && Intrinsics.areEqual(this.rightStartValue, workMode.rightStartValue);
        }

        public int hashCode() {
            return (((((this.leftData.hashCode() * 31) + this.rightData.hashCode()) * 31) + this.leftStartValue.hashCode()) * 31) + this.rightStartValue.hashCode();
        }

        public String toString() {
            return "WorkMode(leftData=" + this.leftData + ", rightData=" + this.rightData + ", leftStartValue=" + this.leftStartValue + ", rightStartValue=" + this.rightStartValue + ")";
        }

        public WorkMode(List<String> leftData, List<String> rightData, String leftStartValue, String rightStartValue) {
            Intrinsics.checkNotNullParameter(leftData, "leftData");
            Intrinsics.checkNotNullParameter(rightData, "rightData");
            Intrinsics.checkNotNullParameter(leftStartValue, "leftStartValue");
            Intrinsics.checkNotNullParameter(rightStartValue, "rightStartValue");
            this.leftData = leftData;
            this.rightData = rightData;
            this.leftStartValue = leftStartValue;
            this.rightStartValue = rightStartValue;
        }

        public final List<String> getLeftData() {
            return this.leftData;
        }

        public final String getLeftStartValue() {
            return this.leftStartValue;
        }

        public final List<String> getRightData() {
            return this.rightData;
        }

        public final String getRightStartValue() {
            return this.rightStartValue;
        }
    }
}
