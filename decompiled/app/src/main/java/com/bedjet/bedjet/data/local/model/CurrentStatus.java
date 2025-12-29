package com.bedjet.bedjet.data.local.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrentStatus.kt */
@Metadata(m942d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\bU\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010O\u001a\u00020\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0015HÆ\u0003J\t\u0010b\u001a\u00020\u0015HÆ\u0003J\t\u0010c\u001a\u00020\u0015HÆ\u0003J\t\u0010d\u001a\u00020\u0015HÆ\u0003J\t\u0010e\u001a\u00020\u0015HÆ\u0003J\t\u0010f\u001a\u00020\u0015HÆ\u0003Jï\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0015HÆ\u0001J\u0006\u0010h\u001a\u00020\u0003J\u0013\u0010i\u001a\u00020\u00152\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\u0003HÖ\u0001J\t\u0010m\u001a\u00020nHÖ\u0001J\u0016\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR\u001a\u0010\u0017\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR\u001a\u0010\u0018\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\u001a\u0010\u0019\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010B\"\u0004\bL\u0010DR\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010B\"\u0004\bN\u0010D¨\u0006t"}, m943d2 = {"Lcom/bedjet/bedjet/data/local/model/CurrentStatus;", "Landroid/os/Parcelable;", "operatingMode", "", "fanStep", "setPointTemp", "minimumTemp", "maximumTemp", "remainHours", "remainMinutes", "remainSeconds", "maximumHours", "maximumMinutes", "actualTemp", "ambientTemp", "shutdownReason", "turboTime", "updatePhase", "sequenceStep", "notifyCode", "unitSetup", "", "connTestPassed", "beepsMuted", "ledsEnabled", "dualZone", "updateAll", "<init>", "(IIIIIIIIIIIIIIIIIZZZZZZ)V", "getOperatingMode", "()I", "setOperatingMode", "(I)V", "getFanStep", "setFanStep", "getSetPointTemp", "setSetPointTemp", "getMinimumTemp", "setMinimumTemp", "getMaximumTemp", "setMaximumTemp", "getRemainHours", "setRemainHours", "getRemainMinutes", "setRemainMinutes", "getRemainSeconds", "setRemainSeconds", "getMaximumHours", "setMaximumHours", "getMaximumMinutes", "setMaximumMinutes", "getActualTemp", "setActualTemp", "getAmbientTemp", "setAmbientTemp", "getShutdownReason", "setShutdownReason", "getTurboTime", "setTurboTime", "getUpdatePhase", "setUpdatePhase", "getSequenceStep", "setSequenceStep", "getNotifyCode", "setNotifyCode", "getUnitSetup", "()Z", "setUnitSetup", "(Z)V", "getConnTestPassed", "setConnTestPassed", "getBeepsMuted", "setBeepsMuted", "getLedsEnabled", "setLedsEnabled", "getDualZone", "setDualZone", "getUpdateAll", "setUpdateAll", "getFanStepScaled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class CurrentStatus implements Parcelable {
    public static final Parcelable.Creator<CurrentStatus> CREATOR = new Creator();
    private int actualTemp;
    private int ambientTemp;
    private boolean beepsMuted;
    private boolean connTestPassed;
    private boolean dualZone;
    private int fanStep;
    private boolean ledsEnabled;
    private int maximumHours;
    private int maximumMinutes;
    private int maximumTemp;
    private int minimumTemp;
    private int notifyCode;
    private int operatingMode;
    private int remainHours;
    private int remainMinutes;
    private int remainSeconds;
    private int sequenceStep;
    private int setPointTemp;
    private int shutdownReason;
    private int turboTime;
    private boolean unitSetup;
    private boolean updateAll;
    private int updatePhase;

    /* compiled from: CurrentStatus.kt */
    @Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<CurrentStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentStatus createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CurrentStatus(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentStatus[] newArray(int i) {
            return new CurrentStatus[i];
        }
    }

    public CurrentStatus() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, false, false, false, 8388607, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getOperatingMode() {
        return this.operatingMode;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMaximumMinutes() {
        return this.maximumMinutes;
    }

    /* renamed from: component11, reason: from getter */
    public final int getActualTemp() {
        return this.actualTemp;
    }

    /* renamed from: component12, reason: from getter */
    public final int getAmbientTemp() {
        return this.ambientTemp;
    }

    /* renamed from: component13, reason: from getter */
    public final int getShutdownReason() {
        return this.shutdownReason;
    }

    /* renamed from: component14, reason: from getter */
    public final int getTurboTime() {
        return this.turboTime;
    }

    /* renamed from: component15, reason: from getter */
    public final int getUpdatePhase() {
        return this.updatePhase;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSequenceStep() {
        return this.sequenceStep;
    }

    /* renamed from: component17, reason: from getter */
    public final int getNotifyCode() {
        return this.notifyCode;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getUnitSetup() {
        return this.unitSetup;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getConnTestPassed() {
        return this.connTestPassed;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFanStep() {
        return this.fanStep;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getBeepsMuted() {
        return this.beepsMuted;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getLedsEnabled() {
        return this.ledsEnabled;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getDualZone() {
        return this.dualZone;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getUpdateAll() {
        return this.updateAll;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSetPointTemp() {
        return this.setPointTemp;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMinimumTemp() {
        return this.minimumTemp;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaximumTemp() {
        return this.maximumTemp;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRemainHours() {
        return this.remainHours;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRemainMinutes() {
        return this.remainMinutes;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRemainSeconds() {
        return this.remainSeconds;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMaximumHours() {
        return this.maximumHours;
    }

    public final CurrentStatus copy(int operatingMode, int fanStep, int setPointTemp, int minimumTemp, int maximumTemp, int remainHours, int remainMinutes, int remainSeconds, int maximumHours, int maximumMinutes, int actualTemp, int ambientTemp, int shutdownReason, int turboTime, int updatePhase, int sequenceStep, int notifyCode, boolean unitSetup, boolean connTestPassed, boolean beepsMuted, boolean ledsEnabled, boolean dualZone, boolean updateAll) {
        return new CurrentStatus(operatingMode, fanStep, setPointTemp, minimumTemp, maximumTemp, remainHours, remainMinutes, remainSeconds, maximumHours, maximumMinutes, actualTemp, ambientTemp, shutdownReason, turboTime, updatePhase, sequenceStep, notifyCode, unitSetup, connTestPassed, beepsMuted, ledsEnabled, dualZone, updateAll);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentStatus)) {
            return false;
        }
        CurrentStatus currentStatus = (CurrentStatus) other;
        return this.operatingMode == currentStatus.operatingMode && this.fanStep == currentStatus.fanStep && this.setPointTemp == currentStatus.setPointTemp && this.minimumTemp == currentStatus.minimumTemp && this.maximumTemp == currentStatus.maximumTemp && this.remainHours == currentStatus.remainHours && this.remainMinutes == currentStatus.remainMinutes && this.remainSeconds == currentStatus.remainSeconds && this.maximumHours == currentStatus.maximumHours && this.maximumMinutes == currentStatus.maximumMinutes && this.actualTemp == currentStatus.actualTemp && this.ambientTemp == currentStatus.ambientTemp && this.shutdownReason == currentStatus.shutdownReason && this.turboTime == currentStatus.turboTime && this.updatePhase == currentStatus.updatePhase && this.sequenceStep == currentStatus.sequenceStep && this.notifyCode == currentStatus.notifyCode && this.unitSetup == currentStatus.unitSetup && this.connTestPassed == currentStatus.connTestPassed && this.beepsMuted == currentStatus.beepsMuted && this.ledsEnabled == currentStatus.ledsEnabled && this.dualZone == currentStatus.dualZone && this.updateAll == currentStatus.updateAll;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.operatingMode * 31) + this.fanStep) * 31) + this.setPointTemp) * 31) + this.minimumTemp) * 31) + this.maximumTemp) * 31) + this.remainHours) * 31) + this.remainMinutes) * 31) + this.remainSeconds) * 31) + this.maximumHours) * 31) + this.maximumMinutes) * 31) + this.actualTemp) * 31) + this.ambientTemp) * 31) + this.shutdownReason) * 31) + this.turboTime) * 31) + this.updatePhase) * 31) + this.sequenceStep) * 31) + this.notifyCode) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.unitSetup)) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.connTestPassed)) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.beepsMuted)) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.ledsEnabled)) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.dualZone)) * 31) + CurrentStatus$$ExternalSyntheticBackport0.m515m(this.updateAll);
    }

    public String toString() {
        return "CurrentStatus(operatingMode=" + this.operatingMode + ", fanStep=" + this.fanStep + ", setPointTemp=" + this.setPointTemp + ", minimumTemp=" + this.minimumTemp + ", maximumTemp=" + this.maximumTemp + ", remainHours=" + this.remainHours + ", remainMinutes=" + this.remainMinutes + ", remainSeconds=" + this.remainSeconds + ", maximumHours=" + this.maximumHours + ", maximumMinutes=" + this.maximumMinutes + ", actualTemp=" + this.actualTemp + ", ambientTemp=" + this.ambientTemp + ", shutdownReason=" + this.shutdownReason + ", turboTime=" + this.turboTime + ", updatePhase=" + this.updatePhase + ", sequenceStep=" + this.sequenceStep + ", notifyCode=" + this.notifyCode + ", unitSetup=" + this.unitSetup + ", connTestPassed=" + this.connTestPassed + ", beepsMuted=" + this.beepsMuted + ", ledsEnabled=" + this.ledsEnabled + ", dualZone=" + this.dualZone + ", updateAll=" + this.updateAll + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.operatingMode);
        dest.writeInt(this.fanStep);
        dest.writeInt(this.setPointTemp);
        dest.writeInt(this.minimumTemp);
        dest.writeInt(this.maximumTemp);
        dest.writeInt(this.remainHours);
        dest.writeInt(this.remainMinutes);
        dest.writeInt(this.remainSeconds);
        dest.writeInt(this.maximumHours);
        dest.writeInt(this.maximumMinutes);
        dest.writeInt(this.actualTemp);
        dest.writeInt(this.ambientTemp);
        dest.writeInt(this.shutdownReason);
        dest.writeInt(this.turboTime);
        dest.writeInt(this.updatePhase);
        dest.writeInt(this.sequenceStep);
        dest.writeInt(this.notifyCode);
        dest.writeInt(this.unitSetup ? 1 : 0);
        dest.writeInt(this.connTestPassed ? 1 : 0);
        dest.writeInt(this.beepsMuted ? 1 : 0);
        dest.writeInt(this.ledsEnabled ? 1 : 0);
        dest.writeInt(this.dualZone ? 1 : 0);
        dest.writeInt(this.updateAll ? 1 : 0);
    }

    public CurrentStatus(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.operatingMode = i;
        this.fanStep = i2;
        this.setPointTemp = i3;
        this.minimumTemp = i4;
        this.maximumTemp = i5;
        this.remainHours = i6;
        this.remainMinutes = i7;
        this.remainSeconds = i8;
        this.maximumHours = i9;
        this.maximumMinutes = i10;
        this.actualTemp = i11;
        this.ambientTemp = i12;
        this.shutdownReason = i13;
        this.turboTime = i14;
        this.updatePhase = i15;
        this.sequenceStep = i16;
        this.notifyCode = i17;
        this.unitSetup = z;
        this.connTestPassed = z2;
        this.beepsMuted = z3;
        this.ledsEnabled = z4;
        this.dualZone = z5;
        this.updateAll = z6;
    }

    public /* synthetic */ CurrentStatus(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i, (i18 & 2) != 0 ? 0 : i2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i4, (i18 & 16) != 0 ? 0 : i5, (i18 & 32) != 0 ? 0 : i6, (i18 & 64) != 0 ? 0 : i7, (i18 & 128) != 0 ? 0 : i8, (i18 & 256) != 0 ? 0 : i9, (i18 & 512) != 0 ? 0 : i10, (i18 & 1024) != 0 ? 0 : i11, (i18 & 2048) != 0 ? 0 : i12, (i18 & 4096) != 0 ? 0 : i13, (i18 & 8192) != 0 ? 0 : i14, (i18 & 16384) != 0 ? 0 : i15, (i18 & 32768) != 0 ? 0 : i16, (i18 & 65536) != 0 ? 0 : i17, (i18 & 131072) != 0 ? false : z, (i18 & 262144) != 0 ? false : z2, (i18 & 524288) != 0 ? false : z3, (i18 & 1048576) != 0 ? false : z4, (i18 & 2097152) != 0 ? false : z5, (i18 & 4194304) != 0 ? false : z6);
    }

    public final int getOperatingMode() {
        return this.operatingMode;
    }

    public final void setOperatingMode(int i) {
        this.operatingMode = i;
    }

    public final int getFanStep() {
        return this.fanStep;
    }

    public final void setFanStep(int i) {
        this.fanStep = i;
    }

    public final int getSetPointTemp() {
        return this.setPointTemp;
    }

    public final void setSetPointTemp(int i) {
        this.setPointTemp = i;
    }

    public final int getMinimumTemp() {
        return this.minimumTemp;
    }

    public final void setMinimumTemp(int i) {
        this.minimumTemp = i;
    }

    public final int getMaximumTemp() {
        return this.maximumTemp;
    }

    public final void setMaximumTemp(int i) {
        this.maximumTemp = i;
    }

    public final int getRemainHours() {
        return this.remainHours;
    }

    public final void setRemainHours(int i) {
        this.remainHours = i;
    }

    public final int getRemainMinutes() {
        return this.remainMinutes;
    }

    public final void setRemainMinutes(int i) {
        this.remainMinutes = i;
    }

    public final int getRemainSeconds() {
        return this.remainSeconds;
    }

    public final void setRemainSeconds(int i) {
        this.remainSeconds = i;
    }

    public final int getMaximumHours() {
        return this.maximumHours;
    }

    public final void setMaximumHours(int i) {
        this.maximumHours = i;
    }

    public final int getMaximumMinutes() {
        return this.maximumMinutes;
    }

    public final void setMaximumMinutes(int i) {
        this.maximumMinutes = i;
    }

    public final int getActualTemp() {
        return this.actualTemp;
    }

    public final void setActualTemp(int i) {
        this.actualTemp = i;
    }

    public final int getAmbientTemp() {
        return this.ambientTemp;
    }

    public final void setAmbientTemp(int i) {
        this.ambientTemp = i;
    }

    public final int getShutdownReason() {
        return this.shutdownReason;
    }

    public final void setShutdownReason(int i) {
        this.shutdownReason = i;
    }

    public final int getTurboTime() {
        return this.turboTime;
    }

    public final void setTurboTime(int i) {
        this.turboTime = i;
    }

    public final int getUpdatePhase() {
        return this.updatePhase;
    }

    public final void setUpdatePhase(int i) {
        this.updatePhase = i;
    }

    public final int getSequenceStep() {
        return this.sequenceStep;
    }

    public final void setSequenceStep(int i) {
        this.sequenceStep = i;
    }

    public final int getNotifyCode() {
        return this.notifyCode;
    }

    public final void setNotifyCode(int i) {
        this.notifyCode = i;
    }

    public final boolean getUnitSetup() {
        return this.unitSetup;
    }

    public final void setUnitSetup(boolean z) {
        this.unitSetup = z;
    }

    public final boolean getConnTestPassed() {
        return this.connTestPassed;
    }

    public final void setConnTestPassed(boolean z) {
        this.connTestPassed = z;
    }

    public final boolean getBeepsMuted() {
        return this.beepsMuted;
    }

    public final void setBeepsMuted(boolean z) {
        this.beepsMuted = z;
    }

    public final boolean getLedsEnabled() {
        return this.ledsEnabled;
    }

    public final void setLedsEnabled(boolean z) {
        this.ledsEnabled = z;
    }

    public final boolean getDualZone() {
        return this.dualZone;
    }

    public final void setDualZone(boolean z) {
        this.dualZone = z;
    }

    public final boolean getUpdateAll() {
        return this.updateAll;
    }

    public final void setUpdateAll(boolean z) {
        this.updateAll = z;
    }

    public final int getFanStepScaled() {
        return (this.fanStep * 5) + 5;
    }
}
