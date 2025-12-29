package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentMenuBindingImpl extends FragmentMenuBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback4;
    private final View.OnClickListener mCallback5;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.topContainer, 11);
        sparseIntArray.put(C0624R.id.tvAppVersionTitle, 12);
        sparseIntArray.put(C0624R.id.tvAppVersionValue, 13);
        sparseIntArray.put(C0624R.id.tvBedJetVersionTitle, 14);
        sparseIntArray.put(C0624R.id.tvBedJetVersionValue, 15);
        sparseIntArray.put(C0624R.id.shimmerBedJetVersionValue, 16);
        sparseIntArray.put(C0624R.id.groupRemoteVersion, 17);
        sparseIntArray.put(C0624R.id.tvRemoteVersionTitle, 18);
        sparseIntArray.put(C0624R.id.tvRemoteVersionValue, 19);
        sparseIntArray.put(C0624R.id.shimmerRemoteVersionValue, 20);
    }

    public FragmentMenuBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private FragmentMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[1], (MaterialButton) objArr[4], (MaterialButton) objArr[5], (MaterialButton) objArr[10], (MaterialButton) objArr[9], (MaterialButton) objArr[3], (MaterialButton) objArr[2], (MaterialButton) objArr[8], (MaterialButton) objArr[6], (MaterialButton) objArr[7], (Group) objArr[17], (ShimmerFrameLayout) objArr[16], (ShimmerFrameLayout) objArr[20], (LinearLayoutCompat) objArr[11], (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[13], (AppCompatTextView) objArr[14], (AppCompatTextView) objArr[15], (AppCompatTextView) objArr[18], (AppCompatTextView) objArr[19]);
        this.mDirtyFlags = -1L;
        this.btnAddNewDevice.setTag(null);
        this.btnAudioAndLights.setTag(null);
        this.btnClockSet.setTag(null);
        this.btnExitFromMenu.setTag(null);
        this.btnFactoryReset.setTag(null);
        this.btnRenameDevice.setTag(null);
        this.btnShowDeviceList.setTag(null);
        this.btnTempUnit.setTag(null);
        this.btnUpdateFirmware.setTag(null);
        this.btnWifiSetup.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(view);
        this.mCallback13 = new OnClickListener(this, 10);
        this.mCallback11 = new OnClickListener(this, 8);
        this.mCallback8 = new OnClickListener(this, 5);
        this.mCallback6 = new OnClickListener(this, 3);
        this.mCallback4 = new OnClickListener(this, 1);
        this.mCallback12 = new OnClickListener(this, 9);
        this.mCallback10 = new OnClickListener(this, 7);
        this.mCallback9 = new OnClickListener(this, 6);
        this.mCallback7 = new OnClickListener(this, 4);
        this.mCallback5 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
        if (2 != i) {
            return false;
        }
        setClickListener((View.OnClickListener) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentMenuBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClickListener;
        if ((j & 2) != 0) {
            this.btnAddNewDevice.setOnClickListener(this.mCallback4);
            this.btnAudioAndLights.setOnClickListener(this.mCallback7);
            this.btnClockSet.setOnClickListener(this.mCallback8);
            this.btnExitFromMenu.setOnClickListener(this.mCallback13);
            this.btnFactoryReset.setOnClickListener(this.mCallback12);
            this.btnRenameDevice.setOnClickListener(this.mCallback6);
            this.btnShowDeviceList.setOnClickListener(this.mCallback5);
            this.btnTempUnit.setOnClickListener(this.mCallback11);
            this.btnUpdateFirmware.setOnClickListener(this.mCallback9);
            this.btnWifiSetup.setOnClickListener(this.mCallback10);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                View.OnClickListener onClickListener = this.mClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                View.OnClickListener onClickListener2 = this.mClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case 3:
                View.OnClickListener onClickListener3 = this.mClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case 4:
                View.OnClickListener onClickListener4 = this.mClickListener;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case 5:
                View.OnClickListener onClickListener5 = this.mClickListener;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case 6:
                View.OnClickListener onClickListener6 = this.mClickListener;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            case 7:
                View.OnClickListener onClickListener7 = this.mClickListener;
                if (onClickListener7 != null) {
                    onClickListener7.onClick(view);
                    return;
                }
                return;
            case 8:
                View.OnClickListener onClickListener8 = this.mClickListener;
                if (onClickListener8 != null) {
                    onClickListener8.onClick(view);
                    return;
                }
                return;
            case 9:
                View.OnClickListener onClickListener9 = this.mClickListener;
                if (onClickListener9 != null) {
                    onClickListener9.onClick(view);
                    return;
                }
                return;
            case 10:
                View.OnClickListener onClickListener10 = this.mClickListener;
                if (onClickListener10 != null) {
                    onClickListener10.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
