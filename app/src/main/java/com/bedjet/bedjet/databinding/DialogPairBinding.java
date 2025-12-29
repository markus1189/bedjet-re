package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class DialogPairBinding extends ViewDataBinding {
    public final MaterialButton buttonCancelDialogPair;
    public final LinearLayoutCompat contentContainerDialogPair;
    public final AppCompatTextView descriptionDialogPair;
    public final AppCompatImageView imageDialogPair;
    public final AppCompatTextView promptDialogPair;
    public final AppCompatTextView titleDialogPair;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPairBinding(Object obj, View view, int i, MaterialButton materialButton, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.buttonCancelDialogPair = materialButton;
        this.contentContainerDialogPair = linearLayoutCompat;
        this.descriptionDialogPair = appCompatTextView;
        this.imageDialogPair = appCompatImageView;
        this.promptDialogPair = appCompatTextView2;
        this.titleDialogPair = appCompatTextView3;
    }

    public static DialogPairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPairBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_pair, viewGroup, z, obj);
    }

    public static DialogPairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPairBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPairBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.dialog_pair, null, false, obj);
    }

    public static DialogPairBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPairBinding bind(View view, Object obj) {
        return (DialogPairBinding) bind(obj, view, C0624R.layout.dialog_pair);
    }
}
