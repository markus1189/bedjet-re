package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.p001ui.biorhythm.BiorhythmFragment;
import com.bedjet.bedjet.p001ui.biorhythm.HeatChartView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentBiorhythmBindingImpl extends FragmentBiorhythmBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback57;
    private final View.OnClickListener mCallback58;
    private final View.OnClickListener mCallback59;
    private final View.OnClickListener mCallback60;
    private final View.OnClickListener mCallback61;
    private final View.OnClickListener mCallback62;
    private final View.OnClickListener mCallback63;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.biorhythmTitle, 8);
        sparseIntArray.put(C0624R.id.biorhythmSequence, 9);
        sparseIntArray.put(C0624R.id.bioEndTime, 10);
        sparseIntArray.put(C0624R.id.biorhythmItems, 11);
    }

    public FragmentBiorhythmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private FragmentBiorhythmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[10], (RecyclerView) objArr[11], (ConstraintLayout) objArr[0], (MaterialButton) objArr[3], (MaterialButton) objArr[5], (MaterialButton) objArr[6], (MaterialButton) objArr[7], (MaterialButton) objArr[4], (HeatChartView) objArr[9], (MaterialButton) objArr[1], (MaterialButton) objArr[2], (AppCompatTextView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.biorhythmLayout.setTag(null);
        this.biorhythmLoad.setTag(null);
        this.biorhythmMem1.setTag(null);
        this.biorhythmMem2.setTag(null);
        this.biorhythmMem3.setTag(null);
        this.biorhythmSave.setTag(null);
        this.biorhythmStart.setTag(null);
        this.biorhythmSuggest.setTag(null);
        setRootTag(view);
        this.mCallback58 = new OnClickListener(this, 2);
        this.mCallback59 = new OnClickListener(this, 3);
        this.mCallback57 = new OnClickListener(this, 1);
        this.mCallback63 = new OnClickListener(this, 7);
        this.mCallback61 = new OnClickListener(this, 5);
        this.mCallback62 = new OnClickListener(this, 6);
        this.mCallback60 = new OnClickListener(this, 4);
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
        setPresenter((BiorhythmFragment) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentBiorhythmBinding
    public void setPresenter(BiorhythmFragment biorhythmFragment) {
        this.mPresenter = biorhythmFragment;
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
        BiorhythmFragment biorhythmFragment = this.mPresenter;
        if ((j & 2) != 0) {
            this.biorhythmLoad.setOnClickListener(this.mCallback59);
            this.biorhythmMem1.setOnClickListener(this.mCallback61);
            this.biorhythmMem2.setOnClickListener(this.mCallback62);
            this.biorhythmMem3.setOnClickListener(this.mCallback63);
            this.biorhythmSave.setOnClickListener(this.mCallback60);
            this.biorhythmStart.setOnClickListener(this.mCallback57);
            this.biorhythmSuggest.setOnClickListener(this.mCallback58);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                BiorhythmFragment biorhythmFragment = this.mPresenter;
                if (biorhythmFragment != null) {
                    biorhythmFragment.onStartPressed();
                    return;
                }
                return;
            case 2:
                BiorhythmFragment biorhythmFragment2 = this.mPresenter;
                if (biorhythmFragment2 != null) {
                    biorhythmFragment2.onSuggest();
                    return;
                }
                return;
            case 3:
                BiorhythmFragment biorhythmFragment3 = this.mPresenter;
                if (biorhythmFragment3 != null) {
                    biorhythmFragment3.onLoad();
                    return;
                }
                return;
            case 4:
                BiorhythmFragment biorhythmFragment4 = this.mPresenter;
                if (biorhythmFragment4 != null) {
                    biorhythmFragment4.onSave();
                    return;
                }
                return;
            case 5:
                BiorhythmFragment biorhythmFragment5 = this.mPresenter;
                if (biorhythmFragment5 != null) {
                    biorhythmFragment5.onRunBio1();
                    return;
                }
                return;
            case 6:
                BiorhythmFragment biorhythmFragment6 = this.mPresenter;
                if (biorhythmFragment6 != null) {
                    biorhythmFragment6.onRunBio2();
                    return;
                }
                return;
            case 7:
                BiorhythmFragment biorhythmFragment7 = this.mPresenter;
                if (biorhythmFragment7 != null) {
                    biorhythmFragment7.onRunBio3();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
