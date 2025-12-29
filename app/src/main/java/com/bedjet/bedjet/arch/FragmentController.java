package com.bedjet.bedjet.arch;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: FragmentController.kt */
@Metadata(m942d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, m943d2 = {"Lcom/bedjet/bedjet/arch/FragmentController;", "", "showSystemUI", "", "hideSystemUI", "showActionBar", "isShowBackButton", "", "showBackButton", "hideBackButton", "setConnectedDevice", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface FragmentController {
    void hideBackButton();

    void hideSystemUI();

    void setConnectedDevice(String name);

    void showActionBar(boolean isShowBackButton);

    void showBackButton();

    void showSystemUI();
}
