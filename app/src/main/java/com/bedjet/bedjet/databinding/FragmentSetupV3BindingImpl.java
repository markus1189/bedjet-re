package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public class FragmentSetupV3BindingImpl extends FragmentSetupV3Binding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback68;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.topContainer, 2);
        sparseIntArray.put(C0624R.id.etLayoutName, 3);
        sparseIntArray.put(C0624R.id.etName, 4);
        sparseIntArray.put(C0624R.id.radioGroupSounds, 5);
        sparseIntArray.put(C0624R.id.radioButtonSoundsOn, 6);
        sparseIntArray.put(C0624R.id.radioButtonSoundsOff, 7);
        sparseIntArray.put(C0624R.id.radioGroupLights, 8);
        sparseIntArray.put(C0624R.id.radioButtonLightsOn, 9);
        sparseIntArray.put(C0624R.id.radioButtonLightsOff, 10);
        sparseIntArray.put(C0624R.id.radioGroupDualZone, 11);
        sparseIntArray.put(C0624R.id.radioButtonDualZoneNo, 12);
        sparseIntArray.put(C0624R.id.radioButtonDualZoneYes, 13);
        sparseIntArray.put(C0624R.id.radioGroupPower, 14);
        sparseIntArray.put(C0624R.id.radioButtonPowerYes, 15);
        sparseIntArray.put(C0624R.id.radioButtonPowerNo, 16);
    }

    public FragmentSetupV3BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private FragmentSetupV3BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[1], (TextInputLayout) objArr[3], (TextInputEditText) objArr[4], (RadioButton) objArr[12], (RadioButton) objArr[13], (RadioButton) objArr[10], (RadioButton) objArr[9], (RadioButton) objArr[16], (RadioButton) objArr[15], (RadioButton) objArr[7], (RadioButton) objArr[6], (RadioGroup) objArr[11], (RadioGroup) objArr[8], (RadioGroup) objArr[14], (RadioGroup) objArr[5], (LinearLayoutCompat) objArr[2]);
        this.mDirtyFlags = -1L;
        this.actionButton.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(view);
        this.mCallback68 = new OnClickListener(this, 1);
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

    @Override // com.bedjet.bedjet.databinding.FragmentSetupV3Binding
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
            this.actionButton.setOnClickListener(this.mCallback68);
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
