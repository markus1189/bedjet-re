package com.bedjet.bedjet.p001ui.bluetooth.device_list;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceListViewHolder.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/device_list/DeviceListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "deviceLayout", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getDeviceLayout", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "setDeviceLayout", "(Landroidx/appcompat/widget/LinearLayoutCompat;)V", "deviceName", "Landroidx/appcompat/widget/AppCompatTextView;", "getDeviceName", "()Landroidx/appcompat/widget/AppCompatTextView;", "setDeviceName", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "deviceAddress", "getDeviceAddress", "setDeviceAddress", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeviceListViewHolder extends RecyclerView.ViewHolder {
    private AppCompatTextView deviceAddress;
    private LinearLayoutCompat deviceLayout;
    private AppCompatTextView deviceName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceListViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(C0624R.id.itemDeviceListLayout);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        this.deviceLayout = (LinearLayoutCompat) findViewById;
        View findViewById2 = view.findViewById(C0624R.id.itemDeviceListName);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        this.deviceName = (AppCompatTextView) findViewById2;
        View findViewById3 = view.findViewById(C0624R.id.itemDeviceListAddress);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        this.deviceAddress = (AppCompatTextView) findViewById3;
    }

    public final LinearLayoutCompat getDeviceLayout() {
        return this.deviceLayout;
    }

    public final void setDeviceLayout(LinearLayoutCompat linearLayoutCompat) {
        Intrinsics.checkNotNullParameter(linearLayoutCompat, "<set-?>");
        this.deviceLayout = linearLayoutCompat;
    }

    public final AppCompatTextView getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(AppCompatTextView appCompatTextView) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<set-?>");
        this.deviceName = appCompatTextView;
    }

    public final AppCompatTextView getDeviceAddress() {
        return this.deviceAddress;
    }

    public final void setDeviceAddress(AppCompatTextView appCompatTextView) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<set-?>");
        this.deviceAddress = appCompatTextView;
    }
}
