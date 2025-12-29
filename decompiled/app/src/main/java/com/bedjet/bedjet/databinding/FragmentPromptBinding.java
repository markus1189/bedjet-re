package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentPromptBinding extends ViewDataBinding {
    public final AppCompatImageView bedjetLogo;

    @Bindable
    protected View.OnClickListener mClickListener;
    public final AppCompatTextView promptBody;
    public final MaterialButton promptButton;
    public final AppCompatTextView promptTitle;
    public final MaterialButton secondButton;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPromptBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, MaterialButton materialButton, AppCompatTextView appCompatTextView2, MaterialButton materialButton2) {
        super(obj, view, i);
        this.bedjetLogo = appCompatImageView;
        this.promptBody = appCompatTextView;
        this.promptButton = materialButton;
        this.promptTitle = appCompatTextView2;
        this.secondButton = materialButton2;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentPromptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPromptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPromptBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_prompt, viewGroup, z, obj);
    }

    public static FragmentPromptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPromptBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPromptBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_prompt, null, false, obj);
    }

    public static FragmentPromptBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPromptBinding bind(View view, Object obj) {
        return (FragmentPromptBinding) bind(obj, view, C0624R.layout.fragment_prompt);
    }
}
