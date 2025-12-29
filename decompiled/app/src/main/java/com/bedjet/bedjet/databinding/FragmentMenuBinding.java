package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentMenuBinding extends ViewDataBinding {
    public final MaterialButton btnAddNewDevice;
    public final MaterialButton btnAudioAndLights;
    public final MaterialButton btnClockSet;
    public final MaterialButton btnExitFromMenu;
    public final MaterialButton btnFactoryReset;
    public final MaterialButton btnRenameDevice;
    public final MaterialButton btnShowDeviceList;
    public final MaterialButton btnTempUnit;
    public final MaterialButton btnUpdateFirmware;
    public final MaterialButton btnWifiSetup;
    public final Group groupRemoteVersion;

    @Bindable
    protected View.OnClickListener mClickListener;
    public final ShimmerFrameLayout shimmerBedJetVersionValue;
    public final ShimmerFrameLayout shimmerRemoteVersionValue;
    public final LinearLayoutCompat topContainer;
    public final AppCompatTextView tvAppVersionTitle;
    public final AppCompatTextView tvAppVersionValue;
    public final AppCompatTextView tvBedJetVersionTitle;
    public final AppCompatTextView tvBedJetVersionValue;
    public final AppCompatTextView tvRemoteVersionTitle;
    public final AppCompatTextView tvRemoteVersionValue;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentMenuBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, MaterialButton materialButton5, MaterialButton materialButton6, MaterialButton materialButton7, MaterialButton materialButton8, MaterialButton materialButton9, MaterialButton materialButton10, Group group, ShimmerFrameLayout shimmerFrameLayout, ShimmerFrameLayout shimmerFrameLayout2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        super(obj, view, i);
        this.btnAddNewDevice = materialButton;
        this.btnAudioAndLights = materialButton2;
        this.btnClockSet = materialButton3;
        this.btnExitFromMenu = materialButton4;
        this.btnFactoryReset = materialButton5;
        this.btnRenameDevice = materialButton6;
        this.btnShowDeviceList = materialButton7;
        this.btnTempUnit = materialButton8;
        this.btnUpdateFirmware = materialButton9;
        this.btnWifiSetup = materialButton10;
        this.groupRemoteVersion = group;
        this.shimmerBedJetVersionValue = shimmerFrameLayout;
        this.shimmerRemoteVersionValue = shimmerFrameLayout2;
        this.topContainer = linearLayoutCompat;
        this.tvAppVersionTitle = appCompatTextView;
        this.tvAppVersionValue = appCompatTextView2;
        this.tvBedJetVersionTitle = appCompatTextView3;
        this.tvBedJetVersionValue = appCompatTextView4;
        this.tvRemoteVersionTitle = appCompatTextView5;
        this.tvRemoteVersionValue = appCompatTextView6;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_menu, viewGroup, z, obj);
    }

    public static FragmentMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_menu, null, false, obj);
    }

    public static FragmentMenuBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMenuBinding bind(View view, Object obj) {
        return (FragmentMenuBinding) bind(obj, view, C0624R.layout.fragment_menu);
    }
}
