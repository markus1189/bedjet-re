package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentSetupV3LoadingBindingImpl extends FragmentSetupV3LoadingBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback67;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.ivLogo, 2);
        sparseIntArray.put(C0624R.id.progressBar, 3);
        sparseIntArray.put(C0624R.id.groupContinue, 4);
        sparseIntArray.put(C0624R.id.tvTitle, 5);
        sparseIntArray.put(C0624R.id.tvMessage, 6);
    }

    public FragmentSetupV3LoadingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentSetupV3LoadingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[1], (Group) objArr[4], (AppCompatImageView) objArr[2], (ProgressBar) objArr[3], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.btnContinue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback67 = new OnClickListener(this, 1);
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

    @Override // com.bedjet.bedjet.databinding.FragmentSetupV3LoadingBinding
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
            this.btnContinue.setOnClickListener(this.mCallback67);
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
