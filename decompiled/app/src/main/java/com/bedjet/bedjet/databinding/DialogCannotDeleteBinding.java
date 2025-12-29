package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogCannotDeleteBinding extends ViewDataBinding {
    public final MaterialButton dialogCantDeleteButtonOk;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCannotDeleteBinding(Object obj, View view, int i, MaterialButton materialButton) {
        super(obj, view, i);
        this.dialogCantDeleteButtonOk = materialButton;
    }

    public static DialogCannotDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCannotDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCannotDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_cannot_delete, viewGroup, z, obj);
    }

    public static DialogCannotDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCannotDeleteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCannotDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_cannot_delete, null, false, obj);
    }

    public static DialogCannotDeleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCannotDeleteBinding bind(View view, Object obj) {
        return (DialogCannotDeleteBinding) bind(obj, view, C0624R.layout.dialog_cannot_delete);
    }
}
