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
public class FragmentWifiPermissionBindingImpl extends FragmentWifiPermissionBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback17;
    private final View.OnClickListener mCallback18;
    private final View.OnClickListener mCallback19;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.ivLogo, 4);
        sparseIntArray.put(C0624R.id.progressBar, 5);
        sparseIntArray.put(C0624R.id.visibilityGroup, 6);
        sparseIntArray.put(C0624R.id.title, 7);
        sparseIntArray.put(C0624R.id.message, 8);
    }

    public FragmentWifiPermissionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentWifiPermissionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[3], (MaterialButton) objArr[2], (MaterialButton) objArr[1], (AppCompatImageView) objArr[4], (AppCompatTextView) objArr[8], (ProgressBar) objArr[5], (AppCompatTextView) objArr[7], (Group) objArr[6]);
        this.mDirtyFlags = -1L;
        this.btnCancel.setTag(null);
        this.btnOk.setTag(null);
        this.btnSkip.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback17 = new OnClickListener(this, 1);
        this.mCallback18 = new OnClickListener(this, 2);
        this.mCallback19 = new OnClickListener(this, 3);
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

    @Override // com.bedjet.bedjet.databinding.FragmentWifiPermissionBinding
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
            this.btnCancel.setOnClickListener(this.mCallback19);
            this.btnOk.setOnClickListener(this.mCallback18);
            this.btnSkip.setOnClickListener(this.mCallback17);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        View.OnClickListener onClickListener;
        if (i == 1) {
            View.OnClickListener onClickListener2 = this.mClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3 && (onClickListener = this.mClickListener) != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        View.OnClickListener onClickListener3 = this.mClickListener;
        if (onClickListener3 != null) {
            onClickListener3.onClick(view);
        }
    }
}
