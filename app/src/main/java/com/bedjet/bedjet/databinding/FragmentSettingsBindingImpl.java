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
import com.bedjet.bedjet.p001ui.mainscreen.MainFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentSettingsBindingImpl extends FragmentSettingsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private final View.OnClickListener mCallback26;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback30;
    private final View.OnClickListener mCallback31;
    private final View.OnClickListener mCallback32;
    private final View.OnClickListener mCallback33;
    private final View.OnClickListener mCallback34;
    private final View.OnClickListener mCallback35;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.settingsFanController, 17);
        sparseIntArray.put(C0624R.id.settingsFan, 18);
        sparseIntArray.put(C0624R.id.settingsFanValue, 19);
        sparseIntArray.put(C0624R.id.settingsTemperatureController, 20);
        sparseIntArray.put(C0624R.id.settingsThermometer, 21);
        sparseIntArray.put(C0624R.id.settingsTemperatureSetTitle, 22);
        sparseIntArray.put(C0624R.id.settingsTemperatureSetValue, 23);
        sparseIntArray.put(C0624R.id.settingsTemperatureActualTitle, 24);
        sparseIntArray.put(C0624R.id.settingsTemperatureActualValue, 25);
        sparseIntArray.put(C0624R.id.fanLabel, 26);
        sparseIntArray.put(C0624R.id.tempLabel, 27);
        sparseIntArray.put(C0624R.id.view, 28);
    }

    public FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 29, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[26], (MaterialButton) objArr[8], (AppCompatButton) objArr[4], (AppCompatButton) objArr[5], (AppCompatButton) objArr[6], (AppCompatImageView) objArr[18], (AppCompatImageView) objArr[9], (SeekArc) objArr[17], (AppCompatImageView) objArr[10], (AppCompatTextView) objArr[19], (AppCompatButton) objArr[3], (ConstraintLayout) objArr[0], (MaterialButton) objArr[14], (MaterialButton) objArr[15], (MaterialButton) objArr[16], (AppCompatButton) objArr[1], (MaterialButton) objArr[13], (MaterialButton) objArr[7], (AppCompatTextView) objArr[24], (AppCompatTextView) objArr[25], (AppCompatImageView) objArr[11], (SeekArc) objArr[20], (AppCompatImageView) objArr[12], (AppCompatTextView) objArr[22], (AppCompatTextView) objArr[23], (AppCompatImageView) objArr[21], (AppCompatButton) objArr[2], (TextView) objArr[27], (View) objArr[28]);
        this.mDirtyFlags = -1L;
        this.settingsBiorhythm.setTag(null);
        this.settingsCoolButton.setTag(null);
        this.settingsDryButton.setTag(null);
        this.settingsExtHeatButton.setTag(null);
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
        this.mCallback27 = new OnClickListener(this, 8);
        this.mCallback25 = new OnClickListener(this, 6);
        this.mCallback23 = new OnClickListener(this, 4);
        this.mCallback35 = new OnClickListener(this, 16);
        this.mCallback21 = new OnClickListener(this, 2);
        this.mCallback33 = new OnClickListener(this, 14);
        this.mCallback29 = new OnClickListener(this, 10);
        this.mCallback30 = new OnClickListener(this, 11);
        this.mCallback20 = new OnClickListener(this, 1);
        this.mCallback28 = new OnClickListener(this, 9);
        this.mCallback26 = new OnClickListener(this, 7);
        this.mCallback34 = new OnClickListener(this, 15);
        this.mCallback24 = new OnClickListener(this, 5);
        this.mCallback32 = new OnClickListener(this, 13);
        this.mCallback22 = new OnClickListener(this, 3);
        this.mCallback31 = new OnClickListener(this, 12);
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
        setPresenter((MainFragment) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentSettingsBinding
    public void setPresenter(MainFragment mainFragment) {
        this.mPresenter = mainFragment;
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
        MainFragment mainFragment = this.mPresenter;
        if ((j & 2) != 0) {
            this.settingsBiorhythm.setOnClickListener(this.mCallback27);
            this.settingsCoolButton.setOnClickListener(this.mCallback23);
            this.settingsDryButton.setOnClickListener(this.mCallback24);
            this.settingsExtHeatButton.setOnClickListener(this.mCallback25);
            this.settingsFanAdd.setOnClickListener(this.mCallback28);
            this.settingsFanMinus.setOnClickListener(this.mCallback29);
            this.settingsHeatButton.setOnClickListener(this.mCallback22);
            this.settingsMem1.setOnClickListener(this.mCallback33);
            this.settingsMem2.setOnClickListener(this.mCallback34);
            this.settingsMem3.setOnClickListener(this.mCallback35);
            this.settingsOffButton.setOnClickListener(this.mCallback20);
            this.settingsSave.setOnClickListener(this.mCallback32);
            this.settingsShutoffTimer.setOnClickListener(this.mCallback26);
            this.settingsTemperatureAdd.setOnClickListener(this.mCallback30);
            this.settingsTemperatureMinus.setOnClickListener(this.mCallback31);
            this.settingsTurboButton.setOnClickListener(this.mCallback21);
        }
    }

    @Override // com.bedjet.bedjet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                MainFragment mainFragment = this.mPresenter;
                if (mainFragment != null) {
                    mainFragment.onOff();
                    return;
                }
                return;
            case 2:
                MainFragment mainFragment2 = this.mPresenter;
                if (mainFragment2 != null) {
                    mainFragment2.onTurbo();
                    return;
                }
                return;
            case 3:
                MainFragment mainFragment3 = this.mPresenter;
                if (mainFragment3 != null) {
                    mainFragment3.onHeat();
                    return;
                }
                return;
            case 4:
                MainFragment mainFragment4 = this.mPresenter;
                if (mainFragment4 != null) {
                    mainFragment4.onCool();
                    return;
                }
                return;
            case 5:
                MainFragment mainFragment5 = this.mPresenter;
                if (mainFragment5 != null) {
                    mainFragment5.onDry();
                    return;
                }
                return;
            case 6:
                MainFragment mainFragment6 = this.mPresenter;
                if (mainFragment6 != null) {
                    mainFragment6.onExtHeat();
                    return;
                }
                return;
            case 7:
                MainFragment mainFragment7 = this.mPresenter;
                if (mainFragment7 != null) {
                    mainFragment7.showTimer();
                    return;
                }
                return;
            case 8:
                MainFragment mainFragment8 = this.mPresenter;
                if (mainFragment8 != null) {
                    mainFragment8.navigateToBiorhythmSettings();
                    return;
                }
                return;
            case 9:
                MainFragment mainFragment9 = this.mPresenter;
                if (mainFragment9 != null) {
                    mainFragment9.onFanAdd();
                    return;
                }
                return;
            case 10:
                MainFragment mainFragment10 = this.mPresenter;
                if (mainFragment10 != null) {
                    mainFragment10.onFanMinus();
                    return;
                }
                return;
            case 11:
                MainFragment mainFragment11 = this.mPresenter;
                if (mainFragment11 != null) {
                    mainFragment11.onTemperatureAdd();
                    return;
                }
                return;
            case 12:
                MainFragment mainFragment12 = this.mPresenter;
                if (mainFragment12 != null) {
                    mainFragment12.onTemperatureMinus();
                    return;
                }
                return;
            case 13:
                MainFragment mainFragment13 = this.mPresenter;
                if (mainFragment13 != null) {
                    mainFragment13.saveSettings();
                    return;
                }
                return;
            case 14:
                MainFragment mainFragment14 = this.mPresenter;
                if (mainFragment14 != null) {
                    mainFragment14.recallMem1();
                    return;
                }
                return;
            case 15:
                MainFragment mainFragment15 = this.mPresenter;
                if (mainFragment15 != null) {
                    mainFragment15.recallMem2();
                    return;
                }
                return;
            case 16:
                MainFragment mainFragment16 = this.mPresenter;
                if (mainFragment16 != null) {
                    mainFragment16.recallMem3();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
