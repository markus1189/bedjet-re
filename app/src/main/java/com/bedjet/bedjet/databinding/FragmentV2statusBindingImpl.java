package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.generated.callback.OnClickListener;
import com.bedjet.bedjet.p001ui.custom.seekArc.SeekArc;
import com.bedjet.bedjet.p001ui.mainscreen.MainFragmentV2;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentV2statusBindingImpl extends FragmentV2statusBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback42;
    private final View.OnClickListener mCallback43;
    private final View.OnClickListener mCallback44;
    private final View.OnClickListener mCallback45;
    private final View.OnClickListener mCallback46;
    private final View.OnClickListener mCallback47;
    private final View.OnClickListener mCallback48;
    private final View.OnClickListener mCallback49;
    private final View.OnClickListener mCallback50;
    private final View.OnClickListener mCallback51;
    private final View.OnClickListener mCallback52;
    private final View.OnClickListener mCallback53;
    private final View.OnClickListener mCallback54;
    private final View.OnClickListener mCallback55;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.settingsFanController, 15);
        sparseIntArray.put(C0624R.id.settingsFan, 16);
        sparseIntArray.put(C0624R.id.settingsFanValue, 17);
        sparseIntArray.put(C0624R.id.settingsTemperatureController, 18);
        sparseIntArray.put(C0624R.id.settingsThermometer, 19);
        sparseIntArray.put(C0624R.id.settingsTemperatureSetTitle, 20);
        sparseIntArray.put(C0624R.id.settingsTemperatureSetValue, 21);
        sparseIntArray.put(C0624R.id.settingsTemperatureActualTitle, 22);
        sparseIntArray.put(C0624R.id.settingsTemperatureActualValue, 23);
        sparseIntArray.put(C0624R.id.fanLabel, 24);
        sparseIntArray.put(C0624R.id.tempLabel, 25);
        sparseIntArray.put(C0624R.id.view, 26);
    }

    public FragmentV2statusBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private FragmentV2statusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[24], (MaterialButton) objArr[6], (AppCompatButton) objArr[4], (AppCompatImageView) objArr[16], (AppCompatImageView) objArr[7], (SeekArc) objArr[15], (AppCompatImageView) objArr[8], (AppCompatTextView) objArr[17], (AppCompatButton) objArr[3], (ConstraintLayout) objArr[0], (MaterialButton) objArr[12], (MaterialButton) objArr[13], (MaterialButton) objArr[14], (AppCompatButton) objArr[1], (MaterialButton) objArr[11], (MaterialButton) objArr[5], (AppCompatTextView) objArr[22], (AppCompatTextView) objArr[23], (AppCompatImageView) objArr[9], (SeekArc) objArr[18], (AppCompatImageView) objArr[10], (AppCompatTextView) objArr[20], (AppCompatTextView) objArr[21], (AppCompatImageView) objArr[19], (AppCompatButton) objArr[2], (TextView) objArr[25], (View) objArr[26]);
        this.mDirtyFlags = -1L;
        this.settingsBiorhythm.setTag(null);
        this.settingsCoolButton.setTag(null);
        this.settingsFanAdd.setTag(null);
        this.settingsFanMinus.setTag(null);
        this.settingsHeatButton.setTag(null);
        this.settingsLayout.setTag(null);
        this.settingsMem1.setTag(null);
        this.settingsMem2.setTag(null);
        this.settingsMem3.setTag(null);
        this.settingsOffButton.setTag(null);
        this.settingsSave.setTag(null);
        this.settingsShutoffTimer.setTag(null);
        this.settingsTemperatureAdd.setTag(null);
        this.settingsTemperatureMinus.setTag(null);
        this.settingsTurboButton.setTag(null);
        setRootTag(view);
        this.mCallback49 = new OnClickListener(this, 8);
        this.mCallback47 = new OnClickListener(this, 6);
        this.mCallback45 = new OnClickListener(this, 4);
        this.mCallback43 = new OnClickListener(this, 2);
        this.mCallback55 = new OnClickListener(this, 14);
        this.mCallback52 = new OnClickListener(this, 11);
        this.mCallback42 = new OnClickListener(this, 1);
        this.mCallback50 = new OnClickListener(this, 9);
        this.mCallback48 = new OnClickListener(this, 7);
        this.mCallback46 = new OnClickListener(this, 5);
        this.mCallback54 = new OnClickListener(this, 13);
        this.mCallback44 = new OnClickListener(this, 3);
        this.mCallback53 = new OnClickListener(this, 12);
        this.mCallback51 = new OnClickListener(this, 10);
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
        setPresenter((MainFragmentV2) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentV2statusBinding
    public void setPresenter(MainFragmentV2 mainFragmentV2) {
        this.mPresenter = mainFragmentV2;
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
        MainFragmentV2 mainFragmentV2 = this.mPresenter;
        if ((j & 2) != 0) {
            this.settingsBiorhythm.setOnClickListener(this.mCallback47);
            this.settingsCoolButton.setOnClickListener(this.mCallback45);
            this.settingsFanAdd.setOnClickListener(this.mCallback48);
            this.settingsFanMinus.setOnClickListener(this.mCallback49);
            this.settingsHeatButton.setOnClickListener(this.mCallback44);
            this.settingsMem1.setOnClickListener(this.mCallback53);
            this.settingsMem2.setOnClickListener(this.mCallback54);
            this.settingsMem3.setOnClickListener(this.mCallback55);
            this.settingsOffButton.setOnClickListener(this.mCallback42);
            this.settingsSave.setOnClickListener(this.mCallback52);
            this.settingsShutoffTimer.setOnClickListener(this.mCallback46);
            this.settingsTemperatureAdd.setOnClickListener(this.mCallback50);
            this.settingsTemperatureMinus.setOnClickListener(this.mCallback51);
            this.settingsTurboButton.setOnClickListener(this.mCallback43);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                MainFragmentV2 mainFragmentV2 = this.mPresenter;
                if (mainFragmentV2 != null) {
                    mainFragmentV2.onOff();
                    return;
                }
                return;
            case 2:
                MainFragmentV2 mainFragmentV22 = this.mPresenter;
                if (mainFragmentV22 != null) {
                    mainFragmentV22.onTurbo();
                    return;
                }
                return;
            case 3:
                MainFragmentV2 mainFragmentV23 = this.mPresenter;
                if (mainFragmentV23 != null) {
                    mainFragmentV23.onHeat();
                    return;
                }
                return;
            case 4:
                MainFragmentV2 mainFragmentV24 = this.mPresenter;
                if (mainFragmentV24 != null) {
                    mainFragmentV24.onCool();
                    return;
                }
                return;
            case 5:
                MainFragmentV2 mainFragmentV25 = this.mPresenter;
                if (mainFragmentV25 != null) {
                    mainFragmentV25.showTimer();
                    return;
                }
                return;
            case 6:
                MainFragmentV2 mainFragmentV26 = this.mPresenter;
                if (mainFragmentV26 != null) {
                    mainFragmentV26.navigateToBiorhythmSettings();
                    return;
                }
                return;
            case 7:
                MainFragmentV2 mainFragmentV27 = this.mPresenter;
                if (mainFragmentV27 != null) {
                    mainFragmentV27.onFanAdd();
                    return;
                }
                return;
            case 8:
                MainFragmentV2 mainFragmentV28 = this.mPresenter;
                if (mainFragmentV28 != null) {
                    mainFragmentV28.onFanMinus();
                    return;
                }
                return;
            case 9:
                MainFragmentV2 mainFragmentV29 = this.mPresenter;
                if (mainFragmentV29 != null) {
                    mainFragmentV29.onTemperatureAdd();
                    return;
                }
                return;
            case 10:
                MainFragmentV2 mainFragmentV210 = this.mPresenter;
                if (mainFragmentV210 != null) {
                    mainFragmentV210.onTemperatureMinus();
                    return;
                }
                return;
            case 11:
                MainFragmentV2 mainFragmentV211 = this.mPresenter;
                if (mainFragmentV211 != null) {
                    mainFragmentV211.saveSettings();
                    return;
                }
                return;
            case 12:
                MainFragmentV2 mainFragmentV212 = this.mPresenter;
                if (mainFragmentV212 != null) {
                    mainFragmentV212.recallMem1();
                    return;
                }
                return;
            case 13:
                MainFragmentV2 mainFragmentV213 = this.mPresenter;
                if (mainFragmentV213 != null) {
                    mainFragmentV213.recallMem2();
                    return;
                }
                return;
            case 14:
                MainFragmentV2 mainFragmentV214 = this.mPresenter;
                if (mainFragmentV214 != null) {
                    mainFragmentV214.recallMem3();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
