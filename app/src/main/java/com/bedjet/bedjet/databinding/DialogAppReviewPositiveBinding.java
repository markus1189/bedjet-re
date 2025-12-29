package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogAppReviewPositiveBinding extends ViewDataBinding {
    public final MaterialButton dialogAppReviewPositiveButtonCancel;
    public final MaterialButton dialogAppReviewPositiveButtonSuccess;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogAppReviewPositiveBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2) {
        super(obj, view, i);
        this.dialogAppReviewPositiveButtonCancel = materialButton;
        this.dialogAppReviewPositiveButtonSuccess = materialButton2;
    }

    public static DialogAppReviewPositiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewPositiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAppReviewPositiveBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review_positive, viewGroup, z, obj);
    }

    public static DialogAppReviewPositiveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewPositiveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAppReviewPositiveBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review_positive, null, false, obj);
    }

    public static DialogAppReviewPositiveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewPositiveBinding bind(View view, Object obj) {
        return (DialogAppReviewPositiveBinding) bind(obj, view, C0624R.layout.dialog_app_review_positive);
    }
}
