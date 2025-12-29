package com.bedjet.bedjet.p001ui.bluetooth.stored_device_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.databinding.ItemStoredDeviceListBinding;
import com.bedjet.bedjet.utils.AdapterClickListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoredDeviceListAdapter.kt */
@Metadata(m942d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/stored_device_list/StoredDeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bedjet/bedjet/ui/bluetooth/stored_device_list/StoredDeviceListViewHolder;", "clickListener", "Lcom/bedjet/bedjet/utils/AdapterClickListener;", "Lcom/bedjet/bedjet/data/local/model/stored/DeviceRecord;", "<init>", "(Lcom/bedjet/bedjet/utils/AdapterClickListener;)V", FirebaseAnalytics.Param.ITEMS, "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "clear", "addDevice", "device", "delete", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StoredDeviceListAdapter extends RecyclerView.Adapter<StoredDeviceListViewHolder> {
    private final AdapterClickListener<DeviceRecord> clickListener;
    private final List<DeviceRecord> items;

    public StoredDeviceListAdapter(AdapterClickListener<DeviceRecord> clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        this.items = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StoredDeviceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), C0624R.layout.item_stored_device_list, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new StoredDeviceListViewHolder((ItemStoredDeviceListBinding) inflate, this.clickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(StoredDeviceListViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.update(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public final void addDevice(DeviceRecord device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (!this.items.contains(device)) {
            this.items.add(device);
        }
        notifyDataSetChanged();
    }

    public final void delete(DeviceRecord device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.items.remove(device);
        notifyDataSetChanged();
    }
}
