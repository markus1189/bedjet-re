package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;

/* loaded from: classes.dex */
public abstract class FragmentConnectionBinding extends ViewDataBinding {
    public final AppCompatImageView bluetoothLogo;
    public final ConstraintLayout connectionLayout;

    @Bindable
    protected String mAppVersions;
    public final ProgressBar progressBar;
    public final AppCompatTextView textView;

    public abstract void setAppVersions(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentConnectionBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, ProgressBar progressBar, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.bluetoothLogo = appCompatImageView;
        this.connectionLayout = constraintLayout;
        this.progressBar = progressBar;
        this.textView = appCompatTextView;
    }

    public String getAppVersions() {
        return this.mAppVersions;
    }

    public static FragmentConnectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentConnectionBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_connection, viewGroup, z, obj);
    }

    public static FragmentConnectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentConnectionBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_connection, null, false, obj);
    }

    public static FragmentConnectionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectionBinding bind(View view, Object obj) {
        return (FragmentConnectionBinding) bind(obj, view, C0624R.layout.fragment_connection);
    }
}
