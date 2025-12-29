package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.p001ui.custom.thermometer.Thermometer;
import com.bedjet.bedjet.p001ui.temperature.TemperatureFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentTemperatureBindingImpl extends FragmentTemperatureBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback64;
    private final View.OnClickListener mCallback65;
    private final View.OnClickListener mCallback66;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.temperatureTitle, 4);
        sparseIntArray.put(C0624R.id.thermometer, 5);
        sparseIntArray.put(C0624R.id.autoLayout, 6);
        sparseIntArray.put(C0624R.id.autoShuttoff, 7);
        sparseIntArray.put(C0624R.id.autoMaxTime, 8);
        sparseIntArray.put(C0624R.id.autoHorizontalDivider, 9);
        sparseIntArray.put(C0624R.id.autoHorizontalDividerBottom, 10);
        sparseIntArray.put(C0624R.id.autoVerticalDivider, 11);
        sparseIntArray.put(C0624R.id.autoAir, 12);
        sparseIntArray.put(C0624R.id.autoHRS, 13);
        sparseIntArray.put(C0624R.id.autoRecyclerView, 14);
    }

    public FragmentTemperatureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragmentTemperatureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[13], (View) objArr[9], (View) objArr[10], (ConstraintLayout) objArr[6], (AppCompatTextView) objArr[8], (RecyclerView) objArr[14], (AppCompatTextView) objArr[7], (View) objArr[11], (MaterialButton) objArr[2], (MaterialButton) objArr[1], (ConstraintLayout) objArr[0], (MaterialButton) objArr[3], (AppCompatTextView) objArr[4], (Thermometer) objArr[5]);
        this.mDirtyFlags = -1L;
        this.temperatureDesert.setTag(null);
        this.temperatureGentle.setTag(null);
        this.temperatureLayout.setTag(null);
        this.temperatureNight.setTag(null);
        setRootTag(view);
        this.mCallback65 = new OnClickListener(this, 2);
        this.mCallback66 = new OnClickListener(this, 3);
        this.mCallback64 = new OnClickListener(this, 1);
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
        if (6 != i) {
            return false;
        }
        setPresenter((TemperatureFragment) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentTemperatureBinding
    public void setPresenter(TemperatureFragment temperatureFragment) {
        this.mPresenter = temperatureFragment;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TemperatureFragment temperatureFragment = this.mPresenter;
        if ((j & 2) != 0) {
            this.temperatureDesert.setOnClickListener(this.mCallback65);
            this.temperatureGentle.setOnClickListener(this.mCallback64);
            this.temperatureNight.setOnClickListener(this.mCallback66);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        TemperatureFragment temperatureFragment;
        if (i == 1) {
            TemperatureFragment temperatureFragment2 = this.mPresenter;
            if (temperatureFragment2 != null) {
                temperatureFragment2.onGentleMode();
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3 && (temperatureFragment = this.mPresenter) != null) {
                temperatureFragment.onNightMode();
                return;
            }
            return;
        }
        TemperatureFragment temperatureFragment3 = this.mPresenter;
        if (temperatureFragment3 != null) {
            temperatureFragment3.onDesertMode();
        }
    }
}
