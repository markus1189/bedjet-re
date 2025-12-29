package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogOldAppInstalledBinding extends ViewDataBinding {
    public final MaterialButton dialogOldAppInstalledButtonOk;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogOldAppInstalledBinding(Object obj, View view, int i, MaterialButton materialButton) {
        super(obj, view, i);
        this.dialogOldAppInstalledButtonOk = materialButton;
    }

    public static DialogOldAppInstalledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppInstalledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogOldAppInstalledBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_old_app_installed, viewGroup, z, obj);
    }

    public static DialogOldAppInstalledBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppInstalledBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogOldAppInstalledBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_old_app_installed, null, false, obj);
    }

    public static DialogOldAppInstalledBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOldAppInstalledBinding bind(View view, Object obj) {
        return (DialogOldAppInstalledBinding) bind(obj, view, C0624R.layout.dialog_old_app_installed);
    }
}
