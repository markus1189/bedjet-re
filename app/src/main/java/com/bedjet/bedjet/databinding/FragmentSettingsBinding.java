package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.custom.seekArc.SeekArc;
import com.bedjet.bedjet.p001ui.mainscreen.MainFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentSettingsBinding extends ViewDataBinding {
    public final TextView fanLabel;

    @Bindable
    protected MainFragment mPresenter;
    public final MaterialButton settingsBiorhythm;
    public final AppCompatButton settingsCoolButton;
    public final AppCompatButton settingsDryButton;
    public final AppCompatButton settingsExtHeatButton;
    public final AppCompatImageView settingsFan;
    public final AppCompatImageView settingsFanAdd;
    public final SeekArc settingsFanController;
    public final AppCompatImageView settingsFanMinus;
    public final AppCompatTextView settingsFanValue;
    public final AppCompatButton settingsHeatButton;
    public final ConstraintLayout settingsLayout;
    public final MaterialButton settingsMem1;
    public final MaterialButton settingsMem2;
    public final MaterialButton settingsMem3;
    public final AppCompatButton settingsOffButton;
    public final MaterialButton settingsSave;
    public final MaterialButton settingsShutoffTimer;
    public final AppCompatTextView settingsTemperatureActualTitle;
    public final AppCompatTextView settingsTemperatureActualValue;
    public final AppCompatImageView settingsTemperatureAdd;
    public final SeekArc settingsTemperatureController;
    public final AppCompatImageView settingsTemperatureMinus;
    public final AppCompatTextView settingsTemperatureSetTitle;
    public final AppCompatTextView settingsTemperatureSetValue;
    public final AppCompatImageView settingsThermometer;
    public final AppCompatButton settingsTurboButton;
    public final TextView tempLabel;
    public final View view;

    public abstract void setPresenter(MainFragment mainFragment);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSettingsBinding(Object obj, View view, int i, TextView textView, MaterialButton materialButton, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, SeekArc seekArc, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton4, ConstraintLayout constraintLayout, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, AppCompatButton appCompatButton5, MaterialButton materialButton5, MaterialButton materialButton6, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView4, SeekArc seekArc2, AppCompatImageView appCompatImageView5, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatImageView appCompatImageView6, AppCompatButton appCompatButton6, TextView textView2, View view2) {
        super(obj, view, i);
        this.fanLabel = textView;
        this.settingsBiorhythm = materialButton;
        this.settingsCoolButton = appCompatButton;
        this.settingsDryButton = appCompatButton2;
        this.settingsExtHeatButton = appCompatButton3;
        this.settingsFan = appCompatImageView;
        this.settingsFanAdd = appCompatImageView2;
        this.settingsFanController = seekArc;
        this.settingsFanMinus = appCompatImageView3;
        this.settingsFanValue = appCompatTextView;
        this.settingsHeatButton = appCompatButton4;
        this.settingsLayout = constraintLayout;
        this.settingsMem1 = materialButton2;
        this.settingsMem2 = materialButton3;
        this.settingsMem3 = materialButton4;
        this.settingsOffButton = appCompatButton5;
        this.settingsSave = materialButton5;
        this.settingsShutoffTimer = materialButton6;
        this.settingsTemperatureActualTitle = appCompatTextView2;
        this.settingsTemperatureActualValue = appCompatTextView3;
        this.settingsTemperatureAdd = appCompatImageView4;
        this.settingsTemperatureController = seekArc2;
        this.settingsTemperatureMinus = appCompatImageView5;
        this.settingsTemperatureSetTitle = appCompatTextView4;
        this.settingsTemperatureSetValue = appCompatTextView5;
        this.settingsThermometer = appCompatImageView6;
        this.settingsTurboButton = appCompatButton6;
        this.tempLabel = textView2;
        this.view = view2;
    }

    public MainFragment getPresenter() {
        return this.mPresenter;
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_settings, viewGroup, z, obj);
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_settings, null, false, obj);
    }

    public static FragmentSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding bind(View view, Object obj) {
        return (FragmentSettingsBinding) bind(obj, view, C0624R.layout.fragment_settings);
    }
}
