package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.utils.AdapterClickListener;

/* loaded from: classes.dex */
public class ItemStoredDeviceListBindingImpl extends ItemStoredDeviceListBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback15;
    private final View.OnClickListener mCallback16;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemStoredDeviceListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemStoredDeviceListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageView) objArr[3], (AppCompatTextView) objArr[2], (ConstraintLayout) objArr[0], (AppCompatTextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.itemStoredDeviceButtonDelete.setTag(null);
        this.itemStoredDeviceListAddress.setTag(null);
        this.itemStoredDeviceListLayout.setTag(null);
        this.itemStoredDeviceListName.setTag(null);
        setRootTag(view);
        this.mCallback16 = new OnClickListener(this, 2);
        this.mCallback15 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClickListener((AdapterClickListener) obj);
        } else if (4 == i) {
            setItem((DeviceRecord) obj);
        } else {
            if (5 != i) {
                return false;
            }
            setPosition((Integer) obj);
        }
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.ItemStoredDeviceListBinding
    public void setClickListener(AdapterClickListener adapterClickListener) {
        this.mClickListener = adapterClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.bedjet.bedjet.databinding.ItemStoredDeviceListBinding
    public void setItem(DeviceRecord deviceRecord) {
        this.mItem = deviceRecord;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.bedjet.bedjet.databinding.ItemStoredDeviceListBinding
    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AdapterClickListener adapterClickListener = this.mClickListener;
        DeviceRecord deviceRecord = this.mItem;
        Integer num = this.mPosition;
        long j2 = 10 & j;
        if (j2 == 0 || deviceRecord == null) {
            str = null;
            str2 = null;
        } else {
            str = deviceRecord.getStoredListTitle();
            str2 = deviceRecord.getStoredListDescription();
        }
        if ((j & 8) != 0) {
            this.itemStoredDeviceButtonDelete.setOnClickListener(this.mCallback16);
            this.itemStoredDeviceListLayout.setOnClickListener(this.mCallback15);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.itemStoredDeviceListAddress, str2);
            TextViewBindingAdapter.setText(this.itemStoredDeviceListName, str);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            AdapterClickListener adapterClickListener = this.mClickListener;
            DeviceRecord deviceRecord = this.mItem;
            Integer num = this.mPosition;
            if (adapterClickListener != null) {
                adapterClickListener.onClick(view, deviceRecord, num.intValue());
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        AdapterClickListener adapterClickListener2 = this.mClickListener;
        DeviceRecord deviceRecord2 = this.mItem;
        Integer num2 = this.mPosition;
        if (adapterClickListener2 != null) {
            adapterClickListener2.onClick(view, deviceRecord2, num2.intValue());
        }
    }
}
