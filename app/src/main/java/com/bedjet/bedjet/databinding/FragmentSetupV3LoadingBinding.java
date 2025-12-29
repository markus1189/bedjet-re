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
public abstract class FragmentSetupV3LoadingBinding extends ViewDataBinding {
    public final MaterialButton btnContinue;
    public final Group groupContinue;
    public final AppCompatImageView ivLogo;

    @Bindable
    protected View.OnClickListener mClickListener;
    public final ProgressBar progressBar;
    public final AppCompatTextView tvMessage;
    public final AppCompatTextView tvTitle;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSetupV3LoadingBinding(Object obj, View view, int i, MaterialButton materialButton, Group group, AppCompatImageView appCompatImageView, ProgressBar progressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.btnContinue = materialButton;
        this.groupContinue = group;
        this.ivLogo = appCompatImageView;
        this.progressBar = progressBar;
        this.tvMessage = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentSetupV3LoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3LoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSetupV3LoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_setup_v3_loading, viewGroup, z, obj);
    }

    public static FragmentSetupV3LoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3LoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSetupV3LoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_setup_v3_loading, null, false, obj);
    }

    public static FragmentSetupV3LoadingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3LoadingBinding bind(View view, Object obj) {
        return (FragmentSetupV3LoadingBinding) bind(obj, view, C0624R.layout.fragment_setup_v3_loading);
    }
}
