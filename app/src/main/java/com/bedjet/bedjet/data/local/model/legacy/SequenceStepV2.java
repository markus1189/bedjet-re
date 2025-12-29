package com.bedjet.bedjet.data.local.model.legacy;

/* loaded from: classes.dex */
public class SequenceStepV2 {
    public boolean absolute;
    public int currentFan;
    public boolean enabled;
    public int fan_adjust;
    public int heat_adjust;
    public int heat_setpoint;
    public int operatingMode;
    public int remain_hour;
    public int remain_minute;
    public int remain_sec;
    public int stop_hour;
    public int stop_minute;

    public SequenceStepV2() {
        this.enabled = true;
        this.operatingMode = 3;
        this.currentFan = 20;
        this.remain_hour = 1;
        this.remain_minute = 0;
        this.remain_sec = 0;
        this.heat_setpoint = 40;
        this.fan_adjust = 20;
        this.heat_adjust = 40;
        this.absolute = false;
        this.stop_hour = 0;
        this.stop_minute = 0;
    }

    public SequenceStepV2(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10) {
        this.enabled = z;
        this.operatingMode = i;
        this.currentFan = i2;
        this.remain_hour = i3;
        this.remain_minute = i4;
        this.remain_sec = i5;
        this.heat_setpoint = i6;
        this.fan_adjust = i7;
        this.heat_adjust = i8;
        this.absolute = z2;
        this.stop_hour = i9;
        this.stop_minute = i10;
    }

    public SequenceStepV2(SequenceStepV2 sequenceStepV2) {
        this.enabled = sequenceStepV2.enabled;
        this.operatingMode = sequenceStepV2.operatingMode;
        this.currentFan = sequenceStepV2.currentFan;
        this.remain_hour = sequenceStepV2.remain_hour;
        this.remain_minute = sequenceStepV2.remain_minute;
        this.remain_sec = sequenceStepV2.remain_sec;
        this.heat_setpoint = sequenceStepV2.heat_setpoint;
        this.fan_adjust = sequenceStepV2.fan_adjust;
        this.heat_adjust = sequenceStepV2.heat_adjust;
        this.absolute = sequenceStepV2.absolute;
        this.stop_hour = sequenceStepV2.stop_hour;
        this.stop_minute = sequenceStepV2.stop_minute;
    }

    public String toString() {
        return "SequenceStepV2{enabled=" + this.enabled + ", operatingMode=" + this.operatingMode + ", currentFan=" + this.currentFan + ", remain_hour=" + this.remain_hour + ", remain_minute=" + this.remain_minute + ", remain_sec=" + this.remain_sec + ", heat_setpoint=" + this.heat_setpoint + ", fan_adjust=" + this.fan_adjust + ", heat_adjust=" + this.heat_adjust + ", absolute=" + this.absolute + ", stop_hour=" + this.stop_hour + ", stop_minute=" + this.stop_minute + '}';
    }
}
