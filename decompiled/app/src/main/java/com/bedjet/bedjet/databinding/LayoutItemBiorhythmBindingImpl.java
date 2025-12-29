package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter;

/* loaded from: classes.dex */
public class LayoutItemBiorhythmBindingImpl extends LayoutItemBiorhythmBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback36;
    private final View.OnClickListener mCallback37;
    private final View.OnClickListener mCallback38;
    private final View.OnClickListener mCallback39;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;
    private final AppCompatTextView mboundView1;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_item", "layout_item", "layout_item"}, new int[]{3, 4, 5}, new int[]{C0624R.layout.layout_item, C0624R.layout.layout_item, C0624R.layout.layout_item});
        sViewsWithIds = null;
    }

    public LayoutItemBiorhythmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private LayoutItemBiorhythmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (AppCompatImageView) objArr[2], (LayoutItemBinding) objArr[3], (LayoutItemBinding) objArr[4], (LayoutItemBinding) objArr[5]);
        this.mDirtyFlags = -1L;
        this.itemEdit.setTag(null);
        setContainedBinding(this.itemMode);
        setContainedBinding(this.itemTemp);
        setContainedBinding(this.itemTime);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) objArr[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        setRootTag(view);
        this.mCallback38 = new OnClickListener(this, 3);
        this.mCallback39 = new OnClickListener(this, 4);
        this.mCallback36 = new OnClickListener(this, 1);
        this.mCallback37 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
        }
        this.itemMode.invalidateAll();
        this.itemTemp.invalidateAll();
        this.itemTime.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.itemMode.hasPendingBindings() || this.itemTemp.hasPendingBindings() || this.itemTime.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (5 == i) {
            setPosition((Integer) obj);
        } else {
            if (6 != i) {
                return false;
            }
            setPresenter((BiorhythmAdapterPresenter) obj);
        }
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.LayoutItemBiorhythmBinding
    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.bedjet.bedjet.databinding.LayoutItemBiorhythmBinding
    public void setPresenter(BiorhythmAdapterPresenter biorhythmAdapterPresenter) {
        this.mPresenter = biorhythmAdapterPresenter;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.itemMode.setLifecycleOwner(lifecycleOwner);
        this.itemTemp.setLifecycleOwner(lifecycleOwner);
        this.itemTime.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeItemTemp((LayoutItemBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeItemMode((LayoutItemBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeItemTime((LayoutItemBinding) obj, i2);
    }

    private boolean onChangeItemTemp(LayoutItemBinding layoutItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeItemMode(LayoutItemBinding layoutItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemTime(LayoutItemBinding layoutItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Integer num = this.mPosition;
        BiorhythmAdapterPresenter biorhythmAdapterPresenter = this.mPresenter;
        long j2 = 40 & j;
        String valueOf = j2 != 0 ? String.valueOf(ViewDataBinding.safeUnbox(num) + 1) : null;
        if ((j & 32) != 0) {
            this.itemEdit.setOnClickListener(this.mCallback39);
            this.itemMode.getRoot().setOnClickListener(this.mCallback36);
            this.itemTemp.getRoot().setOnClickListener(this.mCallback37);
            this.itemTime.getRoot().setOnClickListener(this.mCallback38);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, valueOf);
        }
        executeBindingsOn(this.itemMode);
        executeBindingsOn(this.itemTemp);
        executeBindingsOn(this.itemTime);
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            BiorhythmAdapterPresenter biorhythmAdapterPresenter = this.mPresenter;
            Integer num = this.mPosition;
            if (biorhythmAdapterPresenter != null) {
                biorhythmAdapterPresenter.onModeClicked(num.intValue());
                return;
            }
            return;
        }
        if (i == 2) {
            BiorhythmAdapterPresenter biorhythmAdapterPresenter2 = this.mPresenter;
            Integer num2 = this.mPosition;
            if (biorhythmAdapterPresenter2 != null) {
                biorhythmAdapterPresenter2.onTempClicked(num2.intValue());
                return;
            }
            return;
        }
        if (i == 3) {
            BiorhythmAdapterPresenter biorhythmAdapterPresenter3 = this.mPresenter;
            Integer num3 = this.mPosition;
            if (biorhythmAdapterPresenter3 != null) {
                biorhythmAdapterPresenter3.onTimerClicked(num3.intValue());
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        BiorhythmAdapterPresenter biorhythmAdapterPresenter4 = this.mPresenter;
        Integer num4 = this.mPosition;
        if (biorhythmAdapterPresenter4 != null) {
            biorhythmAdapterPresenter4.showEditMenu(num4.intValue());
        }
    }
}
