package com.bedjet.bedjet.utils;

import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.location.LocationRequestCompat;
import com.bedjet.bedjet.data.local.model.CurrentStatus;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.legacy.SequenceStepV2;
import com.bedjet.bedjet.p001ui.biorhythm.HeatChartView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Utils {
    static int[] barpaints;
    static HeatChartView bioChartView;
    static int[] coolbars;
    static AppCompatTextView finishTime;
    static int[] heatbars;
    static int numBars;
    static final int[][] runtime_table = {new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 65}, new int[]{204, 204, 204, 204, 204, 204, 198, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 100, 68, 33}, new int[]{204, 204, 204, 204, 204, 204, 198, 100, 68, 68, 33}, new int[]{204, 204, 204, 204, 204, 204, 198, 100, 66, 34, 33}, new int[]{204, 204, 204, 204, 204, 204, 196, 68, 66, 34, 33}, new int[]{204, 204, 204, 204, 204, 204, 196, 68, 66, 17, 17}, new int[]{204, 204, 204, 204, 204, 196, 68, 68, 66, 17, 17}, new int[]{204, 204, 204, 204, 204, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 196, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 196, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}, new int[]{204, 204, 204, 204, 68, 68, 68, 66, 33, 17, 17}};
    private static int sequenceEndHours;
    private static int sequenceEndMinutes;
    private static boolean sequenceEndValid;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getMinMaxTemp(int r4, boolean r5) {
        /*
            r0 = 1
            r1 = 80
            if (r4 == r0) goto L28
            r0 = 2
            if (r4 == r0) goto L23
            r0 = 3
            r2 = 38
            if (r4 == r0) goto L1c
            r0 = 4
            r3 = 62
            if (r4 == r0) goto L19
            r0 = 5
            if (r4 == r0) goto L16
            goto L2c
        L16:
            r1 = 40
            goto L2e
        L19:
            r1 = 38
            goto L2e
        L1c:
            r1 = 67
            r1 = 38
            r3 = 67
            goto L2e
        L23:
            r1 = 86
            r3 = 86
            goto L2e
        L28:
            r4 = 45
            r1 = 45
        L2c:
            r3 = 80
        L2e:
            if (r5 == 0) goto L31
            r1 = r3
        L31:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.utils.Utils.getMinMaxTemp(int, boolean):int");
    }

    public static int makeUshort(byte b, byte b2) {
        return ((b & 255) * 256) + (b2 & 255);
    }

    public static Date getClockDate(int i, int i2) throws ParseException {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(i + ":" + i2);
    }

    public static Date getTimerDate(int i, int i2) throws ParseException {
        return new SimpleDateFormat("mm:ss", Locale.getDefault()).parse(i + ":" + i2);
    }

    public static String renderTemp(int i, boolean z) {
        if (z) {
            return "" + (i / 2) + " °C";
        }
        return "" + toF(i) + " °F";
    }

    public static int toF(int i) {
        return ((i * 9) / 10) + 32;
    }

    public static int toC(int i) {
        return (int) Math.ceil(((i - 32.0d) * 10.0d) / 9.0d);
    }

    public static boolean isIdleMode(CurrentStatus currentStatus) {
        return currentStatus.getOperatingMode() == 0 || currentStatus.getOperatingMode() == 6;
    }

    public static int getBioStepMaxTime(SequenceStep sequenceStep) {
        int i;
        if (sequenceStep.getMode() != 1 || sequenceStep.getTemperature() < 60) {
            return 12;
        }
        if (((sequenceStep.getTemperature() - 60) & 1) != 0) {
            i = runtime_table[sequenceStep.getFanStep()][(sequenceStep.getTemperature() - 60) >> 1];
        } else {
            i = runtime_table[sequenceStep.getFanStep()][(sequenceStep.getTemperature() - 60) >> 1] >> 4;
        }
        return i & 15;
    }

    public static int getMaxRunTime(int i, int i2, int i3) {
        int i4;
        if (i != 1 || i2 < 60) {
            return 12;
        }
        int i5 = i2 - 60;
        if ((i5 & 1) != 0) {
            i4 = runtime_table[i3][i5 >> 1];
        } else {
            i4 = runtime_table[i3][i5 >> 1] >> 4;
        }
        return i4 & 15;
    }

    public static int adjustTempF(int i, boolean z) {
        int c = toC(i);
        do {
            i = z ? i - 1 : i + 1;
        } while (toC(i) == c);
        return i;
    }

    public static void hexDump(String str, byte[] bArr) {
        Log.d(str, "Data length is " + bArr.length);
        int length = bArr.length;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        while (length != 0) {
            if (i == 0) {
                str2 = String.format("%04x", Integer.valueOf(i2));
            }
            str2 = str2 + " " + String.format("%02x", Byte.valueOf(bArr[i2]));
            i2++;
            i++;
            length--;
            if (i >= 16) {
                Log.d(str, str2);
                i = 0;
            }
        }
        if (i != 0) {
            Log.d(str, str2);
        }
    }

    public static void initChart(View view, AppCompatTextView appCompatTextView, List<SequenceStep> list) {
        HeatChartView heatChartView = (HeatChartView) view;
        bioChartView = heatChartView;
        finishTime = appCompatTextView;
        int nbars = heatChartView.getNbars();
        numBars = nbars;
        heatbars = new int[nbars];
        coolbars = new int[nbars];
        barpaints = new int[nbars];
        for (int i = 0; i < numBars; i++) {
            heatbars[i] = 0;
            coolbars[i] = 0;
            barpaints[i] = 0;
        }
        bioChartView.setChart(12, heatbars, coolbars, barpaints);
        setGraph(list);
    }

    public static void setGraphV2(List<SequenceStepV2> list) {
        int i;
        int i2;
        initEndTime();
        sequenceEndValid = calculateEndTimeV2(list);
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            SequenceStepV2 sequenceStepV2 = list.get(i4);
            if (sequenceStepV2.enabled) {
                i3 += sequenceStepV2.remain_minute + (sequenceStepV2.remain_hour * 60);
            }
        }
        int i5 = i3 > 180 ? 12 : 24;
        if (i3 > 360) {
            i5 = 8;
        }
        if (i3 > 540) {
            i5 = 6;
        }
        int i6 = 600 / i5;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 < size) {
            SequenceStepV2 sequenceStepV22 = list.get(i7);
            if (sequenceStepV22.enabled) {
                int i11 = sequenceStepV22.remain_minute + (sequenceStepV22.remain_hour * 60) + i9;
                int i12 = sequenceStepV22.operatingMode;
                int i13 = 1;
                if (i12 == 1) {
                    i = i5;
                    i2 = sequenceStepV22.currentFan + 80;
                } else if (i12 != 2) {
                    if (i12 != 3) {
                        i = i5;
                        i2 = 0;
                        i13 = 0;
                    } else {
                        i2 = ((int) (sequenceStepV22.currentFan * 4.73f)) + 10;
                        i = i5;
                        i13 = 3;
                    }
                } else if (sequenceStepV22.heat_setpoint >= 52) {
                    i = i5;
                    float f = (float) (((sequenceStepV22.currentFan * 1.58f) + 20.0f) * (((sequenceStepV22.heat_setpoint - 64) / 22.22d) + 1.0d));
                    if (f < 10.0f) {
                        f = 10.0f;
                    }
                    i2 = (int) f;
                    i13 = 2;
                } else {
                    i = i5;
                    i2 = ((int) (sequenceStepV22.currentFan * 4.73f)) + 10;
                    i13 = 0;
                }
                do {
                    if (i8 < numBars) {
                        heatbars[i8] = i2;
                        coolbars[i8] = 0;
                        barpaints[i8] = i13;
                    }
                    i8++;
                    i10 += i6;
                } while (i10 / 10 < i11);
                i9 = i11;
            } else {
                i = i5;
            }
            i7++;
            i5 = i;
        }
        int i14 = i5;
        while (i8 < numBars) {
            heatbars[i8] = 0;
            coolbars[i8] = 0;
            barpaints[i8] = 0;
            i8++;
        }
        bioChartView.setChart(i14, heatbars, coolbars, barpaints);
        updateEndTimeLabel();
    }

    public static String renderTime(String str, int i, int i2) {
        boolean z = i >= 12;
        if (z) {
            i -= 12;
        }
        return String.format(Locale.ROOT, "%s%02d:%02d%s", str, Integer.valueOf(i != 0 ? i : 12), Integer.valueOf(i2), z ? "PM" : "AM");
    }

    public static void updateEndTimeLabel() {
        if (getSequenceEndValid()) {
            finishTime.setText(renderTime("Ends at: ", getSequenceEndHours(), getSequenceEndMinutes()));
        } else {
            finishTime.setText("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setGraph(java.util.List<com.bedjet.bedjet.data.local.model.SequenceStep> r18) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.utils.Utils.setGraph(java.util.List):void");
    }

    private static boolean checkStepTime(int i, int i2) {
        int i3 = i - sequenceEndHours;
        if (i3 < 0) {
            i3 += 24;
        }
        return (i3 * 60) + (i2 - sequenceEndMinutes) < 720;
    }

    private static void addStepTime(int i, int i2) {
        int i3 = sequenceEndMinutes + i2;
        sequenceEndMinutes = i3;
        if (i3 >= 60) {
            sequenceEndMinutes = i3 - 60;
            sequenceEndHours++;
        }
        int i4 = sequenceEndHours + i;
        sequenceEndHours = i4;
        if (i4 > 23) {
            sequenceEndHours = i4 - 24;
        }
    }

    private static boolean calculateEndTimeV3(List<SequenceStep> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SequenceStep sequenceStep = list.get(i);
            if (sequenceStep.isClocktime()) {
                if (!checkStepTime(sequenceStep.getHours(), sequenceStep.getMinutes())) {
                    return false;
                }
                sequenceEndHours = sequenceStep.getHours();
                sequenceEndMinutes = sequenceStep.getMinutes();
            } else {
                addStepTime(sequenceStep.getHours(), sequenceStep.getMinutes());
            }
        }
        return true;
    }

    private static boolean calculateEndTimeV2(List<SequenceStepV2> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SequenceStepV2 sequenceStepV2 = list.get(i);
            if (sequenceStepV2.absolute) {
                if (!checkStepTime(sequenceStepV2.remain_hour, sequenceStepV2.remain_minute)) {
                    return false;
                }
                sequenceEndHours = sequenceStepV2.remain_hour;
                sequenceEndMinutes = sequenceStepV2.remain_minute;
            } else {
                addStepTime(sequenceStepV2.remain_hour, sequenceStepV2.remain_minute);
            }
        }
        return true;
    }

    private static void initEndTime() {
        Calendar calendar = Calendar.getInstance();
        sequenceEndHours = calendar.get(11);
        sequenceEndMinutes = calendar.get(12);
    }

    public static int getSequenceEndHours() {
        return sequenceEndHours;
    }

    public static int getSequenceEndMinutes() {
        return sequenceEndMinutes;
    }

    public static boolean getSequenceEndValid() {
        return sequenceEndValid;
    }
}
