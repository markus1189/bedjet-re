package com.bedjet.bedjet.p001ui.main.p003v3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: V3Setup.kt */
@Metadata(m942d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v3/V3SetupListener;", "", "sendName", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "senButtonCommand", "command", "", "sendClock", "hour", "minute", "finished", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface V3SetupListener {
    void finished();

    void senButtonCommand(int command);

    void sendClock(int hour, int minute);

    void sendName(String name);
}
