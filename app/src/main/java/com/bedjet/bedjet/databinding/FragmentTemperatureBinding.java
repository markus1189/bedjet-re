package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.custom.thermometer.Thermometer;
import com.bedjet.bedjet.p001ui.temperature.TemperatureFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentTemperatureBinding extends ViewDataBinding {
    public final AppCompatTextView autoAir;
    public final AppCompatTextView autoHRS;
    public final View autoHorizontalDivider;
    public final View autoHorizontalDividerBottom;
    public final ConstraintLayout autoLayout;
    public final AppCompatTextView autoMaxTime;
    public final RecyclerView autoRecyclerView;
    public final AppCompatTextView autoShuttoff;
    public final View autoVerticalDivider;

    @Bindable
    protected TemperatureFragment mPresenter;
    public final MaterialButton temperatureDesert;
    public final MaterialButton temperatureGentle;
    public final ConstraintLayout temperatureLayout;
    public final MaterialButton temperatureNight;
    public final AppCompatTextView temperatureTitle;
    public final Thermometer thermometer;

    public abstract void setPresenter(TemperatureFragment temperatureFragment);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTemperatureBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view2, View view3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView3, RecyclerView recyclerView, AppCompatTextView appCompatTextView4, View view4, MaterialButton materialButton, MaterialButton materialButton2, ConstraintLayout constraintLayout2, MaterialButton materialButton3, AppCompatTextView appCompatTextView5, Thermometer thermometer) {
        super(obj, view, i);
        this.autoAir = appCompatTextView;
        this.autoHRS = appCompatTextView2;
        this.autoHorizontalDivider = view2;
        this.autoHorizontalDividerBottom = view3;
        this.autoLayout = constraintLayout;
        this.autoMaxTime = appCompatTextView3;
        this.autoRecyclerView = recyclerView;
        this.autoShuttoff = appCompatTextView4;
        this.autoVerticalDivider = view4;
        this.temperatureDesert = materialButton;
        this.temperatureGentle = materialButton2;
        this.temperatureLayout = constraintLayout2;
        this.temperatureNight = materialButton3;
        this.temperatureTitle = appCompatTextView5;
        this.thermometer = thermometer;
    }

    public TemperatureFragment getPresenter() {
        return this.mPresenter;
    }

    public static FragmentTemperatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTemperatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTemperatureBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_temperature, viewGroup, z, obj);
    }

    public static FragmentTemperatureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTemperatureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTemperatureBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_temperature, null, false, obj);
    }

    public static FragmentTemperatureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTemperatureBinding bind(View view, Object obj) {
        return (FragmentTemperatureBinding) bind(obj, view, C0624R.layout.fragment_temperature);
    }
}
