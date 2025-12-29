package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.wifi.WifiFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentWifiBinding extends ViewDataBinding {
    public final EditText apPasswordEdit;
    public final EditText apSsidEdit;
    public final AppCompatTextView apSsidText;
    public final LinearLayout autoSsidFrame;
    public final MaterialButton btnCancelSetup;
    public final MaterialButton btnGoback;
    public final MaterialButton btnSetwifi;
    public final CheckBox cbAutoset;
    public final AppCompatImageView ivLogo;

    @Bindable
    protected WifiFragment mPresenter;
    public final LinearLayout passwdFrame;
    public final LinearLayout ssidFrame;
    public final LinearLayout statusFrame;
    public final AppCompatTextView statusHistory;
    public final AppCompatTextView statusString;

    public abstract void setPresenter(WifiFragment wifiFragment);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWifiBinding(Object obj, View view, int i, EditText editText, EditText editText2, AppCompatTextView appCompatTextView, LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, CheckBox checkBox, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.apPasswordEdit = editText;
        this.apSsidEdit = editText2;
        this.apSsidText = appCompatTextView;
        this.autoSsidFrame = linearLayout;
        this.btnCancelSetup = materialButton;
        this.btnGoback = materialButton2;
        this.btnSetwifi = materialButton3;
        this.cbAutoset = checkBox;
        this.ivLogo = appCompatImageView;
        this.passwdFrame = linearLayout2;
        this.ssidFrame = linearLayout3;
        this.statusFrame = linearLayout4;
        this.statusHistory = appCompatTextView2;
        this.statusString = appCompatTextView3;
    }

    public WifiFragment getPresenter() {
        return this.mPresenter;
    }

    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_wifi, viewGroup, z, obj);
    }

    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_wifi, null, false, obj);
    }

    public static FragmentWifiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiBinding bind(View view, Object obj) {
        return (FragmentWifiBinding) bind(obj, view, C0624R.layout.fragment_wifi);
    }
}
