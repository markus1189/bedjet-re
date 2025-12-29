package com.bedjet.bedjet.p001ui.bluetooth.stored_device_list;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.databinding.ItemStoredDeviceListBinding;
import com.bedjet.bedjet.utils.AdapterClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoredDeviceListViewHolder.kt */
@Metadata(m942d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/stored_device_list/StoredDeviceListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bedjet/bedjet/databinding/ItemStoredDeviceListBinding;", "clickListener", "Lcom/bedjet/bedjet/utils/AdapterClickListener;", "Lcom/bedjet/bedjet/data/local/model/stored/DeviceRecord;", "<init>", "(Lcom/bedjet/bedjet/databinding/ItemStoredDeviceListBinding;Lcom/bedjet/bedjet/utils/AdapterClickListener;)V", "update", "", "item", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StoredDeviceListViewHolder extends RecyclerView.ViewHolder {
    private final ItemStoredDeviceListBinding binding;
    private final AdapterClickListener<DeviceRecord> clickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoredDeviceListViewHolder(ItemStoredDeviceListBinding binding, AdapterClickListener<DeviceRecord> clickListener) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.binding = binding;
        this.clickListener = clickListener;
    }

    public final void update(DeviceRecord item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.binding.setItem(item);
        this.binding.setClickListener(this.clickListener);
        this.binding.setPosition(Integer.valueOf(getAdapterPosition()));
        this.binding.executePendingBindings();
    }
}
