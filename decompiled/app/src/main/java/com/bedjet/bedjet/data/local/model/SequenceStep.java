package com.bedjet.bedjet.data.local.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SequenceStep implements Serializable {
    private boolean clocktime;
    private boolean enabled;
    private int fanStep;
    private int hours;
    private int minutes;
    private int mode;
    private int temperature;

    public SequenceStep() {
        this.mode = 6;
        this.fanStep = 19;
        this.hours = 1;
        this.minutes = 0;
        this.temperature = 40;
        this.clocktime = false;
    }

    public SequenceStep(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.mode = i;
        this.fanStep = i2;
        this.hours = i3;
        this.minutes = i4;
        this.temperature = i5;
        this.clocktime = z;
        this.enabled = true;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getFanStep() {
        return this.fanStep;
    }

    public void setFanStep(int i) {
        this.fanStep = i;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int i) {
        this.hours = i;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int i) {
        this.minutes = i;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int i) {
        this.temperature = i;
    }

    public boolean isClocktime() {
        return this.clocktime;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setClocktime(boolean z) {
        this.clocktime = z;
    }

    public String toString() {
        return "SequenceStep{mode=" + this.mode + ", fanStep=" + this.fanStep + ", hours=" + this.hours + ", minutes=" + this.minutes + ", temperature=" + this.temperature + ", clocktime=" + this.clocktime + ", enabled=" + this.enabled + '}';
    }
}
