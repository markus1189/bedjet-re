package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class DialogRenameBinding extends ViewDataBinding {
    public final MaterialButton dialogRenameButtonCancel;
    public final MaterialButton dialogRenameButtonOk;
    public final TextInputEditText dialogRenameEditText;
    public final TextInputLayout dialogRenameInputLayout;
    public final AppCompatTextView dialogRenameTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRenameBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.dialogRenameButtonCancel = materialButton;
        this.dialogRenameButtonOk = materialButton2;
        this.dialogRenameEditText = textInputEditText;
        this.dialogRenameInputLayout = textInputLayout;
        this.dialogRenameTitle = appCompatTextView;
    }

    public static DialogRenameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRenameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRenameBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_rename, viewGroup, z, obj);
    }

    public static DialogRenameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRenameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRenameBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_rename, null, false, obj);
    }

    public static DialogRenameBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogRenameBinding bind(View view, Object obj) {
        return (DialogRenameBinding) bind(obj, view, C0624R.layout.dialog_rename);
    }
}
