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
public abstract class DialogFactoryResetBinding extends ViewDataBinding {
    public final MaterialButton dialogFactoryResetButtonNo;
    public final MaterialButton dialogFactoryResetButtonYes;
    public final AppCompatTextView dialogFactoryResetMessage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFactoryResetBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.dialogFactoryResetButtonNo = materialButton;
        this.dialogFactoryResetButtonYes = materialButton2;
        this.dialogFactoryResetMessage = appCompatTextView;
    }

    public static DialogFactoryResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFactoryResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFactoryResetBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_factory_reset, viewGroup, z, obj);
    }

    public static DialogFactoryResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFactoryResetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFactoryResetBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_factory_reset, null, false, obj);
    }

    public static DialogFactoryResetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFactoryResetBinding bind(View view, Object obj) {
        return (DialogFactoryResetBinding) bind(obj, view, C0624R.layout.dialog_factory_reset);
    }
}
