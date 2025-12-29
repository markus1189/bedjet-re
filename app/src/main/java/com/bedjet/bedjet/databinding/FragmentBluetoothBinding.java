package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentBluetoothBinding extends ViewDataBinding {
    public final MaterialButton bluetoothConnectButton;
    public final AppCompatImageView bluetoothLogo;
    public final AppCompatTextView bluetoothTitle;
    public final ConstraintLayout connectionLayout;

    @Bindable
    protected View.OnClickListener mClickListener;

    @Bindable
    protected Boolean mHasPairings;

    @Bindable
    protected String mVersion;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    public abstract void setHasPairings(Boolean bool);

    public abstract void setVersion(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentBluetoothBinding(Object obj, View view, int i, MaterialButton materialButton, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.bluetoothConnectButton = materialButton;
        this.bluetoothLogo = appCompatImageView;
        this.bluetoothTitle = appCompatTextView;
        this.connectionLayout = constraintLayout;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public Boolean getHasPairings() {
        return this.mHasPairings;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public static FragmentBluetoothBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBluetoothBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_bluetooth, viewGroup, z, obj);
    }

    public static FragmentBluetoothBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBluetoothBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_bluetooth, null, false, obj);
    }

    public static FragmentBluetoothBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothBinding bind(View view, Object obj) {
        return (FragmentBluetoothBinding) bind(obj, view, C0624R.layout.fragment_bluetooth);
    }
}
