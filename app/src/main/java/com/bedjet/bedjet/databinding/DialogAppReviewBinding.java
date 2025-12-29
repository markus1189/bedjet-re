package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogAppReviewBinding extends ViewDataBinding {
    public final MaterialButton dialogAppReviewButtonCancel;
    public final MaterialButton dialogAppReviewButtonSuccess;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogAppReviewBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2) {
        super(obj, view, i);
        this.dialogAppReviewButtonCancel = materialButton;
        this.dialogAppReviewButtonSuccess = materialButton2;
    }

    public static DialogAppReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAppReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review, viewGroup, z, obj);
    }

    public static DialogAppReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAppReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review, null, false, obj);
    }

    public static DialogAppReviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewBinding bind(View view, Object obj) {
        return (DialogAppReviewBinding) bind(obj, view, C0624R.layout.dialog_app_review);
    }
}
