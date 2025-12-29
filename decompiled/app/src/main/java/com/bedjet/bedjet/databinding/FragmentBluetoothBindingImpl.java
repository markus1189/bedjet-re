package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentBluetoothBindingImpl extends FragmentBluetoothBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final AppCompatTextView mboundView1;
    private final AppCompatTextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.bluetoothLogo, 4);
        sparseIntArray.put(C0624R.id.bluetoothTitle, 5);
    }

    public FragmentBluetoothBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentBluetoothBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[3], (AppCompatImageView) objArr[4], (AppCompatTextView) objArr[5], (ConstraintLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.bluetoothConnectButton.setTag(null);
        this.connectionLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) objArr[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) objArr[2];
        this.mboundView2 = appCompatTextView2;
        appCompatTextView2.setTag(null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
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
        if (7 == i) {
            setVersion((String) obj);
        } else if (3 == i) {
            setHasPairings((Boolean) obj);
        } else {
            if (2 != i) {
                return false;
            }
            setClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentBluetoothBinding
    public void setVersion(String str) {
        this.mVersion = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.bedjet.bedjet.databinding.FragmentBluetoothBinding
    public void setHasPairings(Boolean bool) {
        this.mHasPairings = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.bedjet.bedjet.databinding.FragmentBluetoothBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mVersion;
        Boolean bool = this.mHasPairings;
        View.OnClickListener onClickListener = this.mClickListener;
        long j2 = j & 10;
        if (j2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j |= safeUnbox ? 160L : 80L;
            }
            int i2 = safeUnbox ? 8 : 0;
            i = safeUnbox ? 0 : 8;
            r10 = i2;
        } else {
            i = 0;
        }
        if ((8 & j) != 0) {
            this.bluetoothConnectButton.setOnClickListener(this.mCallback3);
        }
        if ((10 & j) != 0) {
            this.bluetoothConnectButton.setVisibility(r10);
            this.mboundView1.setVisibility(i);
        }
        if ((j & 9) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
