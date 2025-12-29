package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.p001ui.main.MainActivity;

/* loaded from: classes.dex */
public class ActivityMainBindingImpl extends ActivityMainBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private final View.OnClickListener mCallback2;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.mainActionBar, 3);
        sparseIntArray.put(C0624R.id.mainLogo, 4);
        sparseIntArray.put(C0624R.id.actionBarDivider, 5);
        sparseIntArray.put(C0624R.id.mainConnectedDevice, 6);
        sparseIntArray.put(C0624R.id.mainContainer, 7);
    }

    public ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[5], (Group) objArr[3], (AppCompatImageView) objArr[1], (AppCompatTextView) objArr[6], (FrameLayout) objArr[7], (ConstraintLayout) objArr[0], (AppCompatImageView) objArr[4], (AppCompatImageView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.mainBack.setTag(null);
        this.mainLayout.setTag(null);
        this.mainMenu.setTag(null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
        this.mCallback2 = new OnClickListener(this, 2);
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
        setPresenter((MainActivity) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.ActivityMainBinding
    public void setPresenter(MainActivity mainActivity) {
        this.mPresenter = mainActivity;
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
        MainActivity mainActivity = this.mPresenter;
        if ((j & 2) != 0) {
            this.mainBack.setOnClickListener(this.mCallback1);
            this.mainMenu.setOnClickListener(this.mCallback2);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        MainActivity mainActivity;
        if (i != 1) {
            if (i == 2 && (mainActivity = this.mPresenter) != null) {
                mainActivity.onMenuPressed();
                return;
            }
            return;
        }
        MainActivity mainActivity2 = this.mPresenter;
        if (mainActivity2 != null) {
            mainActivity2.onBack();
        }
    }
}
