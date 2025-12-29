package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogOldAppBinding extends ViewDataBinding {
    public final MaterialButton dialogOldAppButtonCancel;
    public final MaterialButton dialogOldAppButtonSuccess;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogOldAppBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2) {
        super(obj, view, i);
        this.dialogOldAppButtonCancel = materialButton;
        this.dialogOldAppButtonSuccess = materialButton2;
    }

    public static DialogOldAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogOldAppBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_old_app, viewGroup, z, obj);
    }

    public static DialogOldAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogOldAppBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_old_app, null, false, obj);
    }

    public static DialogOldAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppBinding bind(View view, Object obj) {
        return (DialogOldAppBinding) bind(obj, view, C0624R.layout.dialog_old_app);
    }
}
