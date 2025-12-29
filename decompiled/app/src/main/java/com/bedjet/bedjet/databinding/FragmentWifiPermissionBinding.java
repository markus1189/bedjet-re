package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentWifiPermissionBinding extends ViewDataBinding {
    public final MaterialButton btnCancel;
    public final MaterialButton btnOk;
    public final MaterialButton btnSkip;
    public final AppCompatImageView ivLogo;

    @Bindable
    protected View.OnClickListener mClickListener;
    public final AppCompatTextView message;
    public final ProgressBar progressBar;
    public final AppCompatTextView title;
    public final Group visibilityGroup;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWifiPermissionBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ProgressBar progressBar, AppCompatTextView appCompatTextView2, Group group) {
        super(obj, view, i);
        this.btnCancel = materialButton;
        this.btnOk = materialButton2;
        this.btnSkip = materialButton3;
        this.ivLogo = appCompatImageView;
        this.message = appCompatTextView;
        this.progressBar = progressBar;
        this.title = appCompatTextView2;
        this.visibilityGroup = group;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentWifiPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWifiPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_wifi_permission, viewGroup, z, obj);
    }

    public static FragmentWifiPermissionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPermissionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWifiPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_wifi_permission, null, false, obj);
    }

    public static FragmentWifiPermissionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPermissionBinding bind(View view, Object obj) {
        return (FragmentWifiPermissionBinding) bind(obj, view, C0624R.layout.fragment_wifi_permission);
    }
}
