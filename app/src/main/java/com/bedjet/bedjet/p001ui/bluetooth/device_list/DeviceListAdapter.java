package com.bedjet.bedjet.p001ui.bluetooth.device_list;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.utils.AdapterClickListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceListAdapter.kt */
@Metadata(m942d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/device_list/DeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bedjet/bedjet/ui/bluetooth/device_list/DeviceListViewHolder;", "clickListener", "Lcom/bedjet/bedjet/utils/AdapterClickListener;", "Landroid/bluetooth/BluetoothDevice;", "<init>", "(Lcom/bedjet/bedjet/utils/AdapterClickListener;)V", "devices", "", "addDevice", "", "device", "clear", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeviceListAdapter extends RecyclerView.Adapter<DeviceListViewHolder> {
    private final AdapterClickListener<BluetoothDevice> clickListener;
    private final List<BluetoothDevice> devices;

    public DeviceListAdapter(AdapterClickListener<BluetoothDevice> clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        this.devices = new ArrayList();
    }

    public final void addDevice(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (!this.devices.contains(device)) {
            this.devices.add(device);
        }
        notifyDataSetChanged();
    }

    public final void clear() {
        this.devices.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeviceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0624R.layout.item_device_list, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DeviceListViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DeviceListViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final BluetoothDevice bluetoothDevice = this.devices.get(position);
        String name = bluetoothDevice.getName();
        DeviceType.Companion companion = DeviceType.INSTANCE;
        Intrinsics.checkNotNull(name);
        String adjustNameByName = companion.getAdjustNameByName(name);
        if (adjustNameByName != null) {
            name = adjustNameByName;
        }
        if (name != null) {
            String str = name;
            if (str.length() > 0) {
                holder.getDeviceName().setText(str);
                holder.getDeviceAddress().setText(bluetoothDevice.getAddress());
                holder.getDeviceLayout().setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceListAdapter.onBindViewHolder$lambda$0(DeviceListAdapter.this, bluetoothDevice, position, view);
                    }
                });
            }
        }
        holder.getDeviceName().setText(C0624R.string.unknown_device);
        holder.getDeviceAddress().setText(bluetoothDevice.getAddress());
        holder.getDeviceLayout().setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceListAdapter.onBindViewHolder$lambda$0(DeviceListAdapter.this, bluetoothDevice, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceListAdapter deviceListAdapter, BluetoothDevice bluetoothDevice, int i, View view) {
        AdapterClickListener<BluetoothDevice> adapterClickListener = deviceListAdapter.clickListener;
        Intrinsics.checkNotNull(view);
        adapterClickListener.onClick(view, bluetoothDevice, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.devices.size();
    }
}
