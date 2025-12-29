package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.utils.AdapterClickListener;

/* loaded from: classes.dex */
public abstract class ItemStoredDeviceListBinding extends ViewDataBinding {
    public final AppCompatImageView itemStoredDeviceButtonDelete;
    public final AppCompatTextView itemStoredDeviceListAddress;
    public final ConstraintLayout itemStoredDeviceListLayout;
    public final AppCompatTextView itemStoredDeviceListName;

    @Bindable
    protected AdapterClickListener mClickListener;

    @Bindable
    protected DeviceRecord mItem;

    @Bindable
    protected Integer mPosition;

    public abstract void setClickListener(AdapterClickListener adapterClickListener);

    public abstract void setItem(DeviceRecord deviceRecord);

    public abstract void setPosition(Integer num);

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemStoredDeviceListBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.itemStoredDeviceButtonDelete = appCompatImageView;
        this.itemStoredDeviceListAddress = appCompatTextView;
        this.itemStoredDeviceListLayout = constraintLayout;
        this.itemStoredDeviceListName = appCompatTextView2;
    }

    public AdapterClickListener getClickListener() {
        return this.mClickListener;
    }

    public DeviceRecord getItem() {
        return this.mItem;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemStoredDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStoredDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemStoredDeviceListBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.item_stored_device_list, viewGroup, z, obj);
    }

    public static ItemStoredDeviceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStoredDeviceListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemStoredDeviceListBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.item_stored_device_list, null, false, obj);
    }

    public static ItemStoredDeviceListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStoredDeviceListBinding bind(View view, Object obj) {
        return (ItemStoredDeviceListBinding) bind(obj, view, C0624R.layout.item_stored_device_list);
    }
}
