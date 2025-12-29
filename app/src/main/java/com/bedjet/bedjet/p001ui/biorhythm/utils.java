package com.bedjet.bedjet.p001ui.biorhythm;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.Constants;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.legacy.SequenceStepV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m943d2 = {"getModeName", "", "operatingMode", "", "getModeCode", "modeName", "isV2Mode", "", "convertV2step", "Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "original", "Lcom/bedjet/bedjet/data/local/model/legacy/SequenceStepV2;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.ui.biorhythm.UtilsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class utils {
    public static final String getModeName(int i) {
        switch (i) {
            case 0:
                return "Standby";
            case 1:
                return "Heat";
            case 2:
                return Constants.MODENAME_TURBO;
            case 3:
                return Constants.MODENAME_EXTHT;
            case 4:
                return "Cool";
            case 5:
                return "Dry";
            case 6:
                return "Wait";
            default:
                return "ERROR";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int getModeCode(java.lang.String r8, boolean r9) {
        /*
            java.lang.String r0 = "modeName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 3
            r1 = 2
            r2 = 1
            java.lang.String r3 = "Turbo Heat"
            java.lang.String r4 = "Heat"
            java.lang.String r5 = "Cool"
            r6 = 0
            if (r9 == 0) goto L3a
            int r9 = r8.hashCode()
            r7 = 2106217(0x202369, float:2.951439E-39)
            if (r9 == r7) goto L33
            r0 = 2245136(0x224210, float:3.146106E-39)
            if (r9 == r0) goto L2c
            r0 = 756523762(0x2d17a2f2, float:8.619537E-12)
            if (r9 == r0) goto L25
            goto L39
        L25:
            boolean r8 = r8.equals(r3)
            if (r8 != 0) goto L66
            goto L39
        L2c:
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L52
            goto L39
        L33:
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L83
        L39:
            goto L82
        L3a:
            int r9 = r8.hashCode()
            switch(r9) {
                case -232666483: goto L7c;
                case 69003: goto L71;
                case 2106217: goto L68;
                case 2245136: goto L5f;
                case 2688405: goto L54;
                case 756523762: goto L4b;
                case 1881672953: goto L42;
                default: goto L41;
            }
        L41:
            goto L82
        L42:
            java.lang.String r9 = "Extnd. Heat"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L83
            goto L82
        L4b:
            boolean r8 = r8.equals(r3)
            if (r8 != 0) goto L52
            goto L82
        L52:
            r0 = 2
            goto L83
        L54:
            java.lang.String r9 = "Wait"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L5d
            goto L82
        L5d:
            r0 = 6
            goto L83
        L5f:
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L66
            goto L82
        L66:
            r0 = 1
            goto L83
        L68:
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L6f
            goto L82
        L6f:
            r0 = 4
            goto L83
        L71:
            java.lang.String r9 = "Dry"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L7a
            goto L82
        L7a:
            r0 = 5
            goto L83
        L7c:
            java.lang.String r9 = "Standby"
            boolean r8 = r8.equals(r9)
        L82:
            r0 = 0
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.p001ui.biorhythm.utils.getModeCode(java.lang.String, boolean):int");
    }

    public static final SequenceStep convertV2step(SequenceStepV2 original) {
        int i;
        Intrinsics.checkNotNullParameter(original, "original");
        SequenceStep sequenceStep = new SequenceStep();
        int i2 = original.operatingMode;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                i = i2 != 2 ? i2 != 3 ? 0 : 4 : 1;
            }
        } else {
            i = 6;
        }
        sequenceStep.setMode(i);
        sequenceStep.setFanStep(original.currentFan - 1);
        sequenceStep.setTemperature(original.heat_setpoint);
        sequenceStep.setHours(original.remain_hour);
        sequenceStep.setMinutes(original.remain_minute);
        sequenceStep.setClocktime(original.absolute);
        return sequenceStep;
    }
}
