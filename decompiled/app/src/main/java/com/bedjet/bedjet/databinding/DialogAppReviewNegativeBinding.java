package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogAppReviewNegativeBinding extends ViewDataBinding {
    public final MaterialButton dialogAppReviewNegativeButton;
    public final AppCompatTextView dialogAppReviewNegativeDescription;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogAppReviewNegativeBinding(Object obj, View view, int i, MaterialButton materialButton, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.dialogAppReviewNegativeButton = materialButton;
        this.dialogAppReviewNegativeDescription = appCompatTextView;
    }

    public static DialogAppReviewNegativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewNegativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAppReviewNegativeBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review_negative, viewGroup, z, obj);
    }

    public static DialogAppReviewNegativeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewNegativeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAppReviewNegativeBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_app_review_negative, null, false, obj);
    }

    public static DialogAppReviewNegativeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppReviewNegativeBinding bind(View view, Object obj) {
        return (DialogAppReviewNegativeBinding) bind(obj, view, C0624R.layout.dialog_app_review_negative);
    }
}
