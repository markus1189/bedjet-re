package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;

/* loaded from: classes.dex */
public abstract class LayoutItemBinding extends ViewDataBinding {
    public final ConstraintLayout itemLayout;
    public final AppCompatTextView itemTitle;
    public final AppCompatTextView itemValue;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.itemLayout = constraintLayout;
        this.itemTitle = appCompatTextView;
        this.itemValue = appCompatTextView2;
    }

    public static LayoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutItemBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_item, viewGroup, z, obj);
    }

    public static LayoutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutItemBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_item, null, false, obj);
    }

    public static LayoutItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBinding bind(View view, Object obj) {
        return (LayoutItemBinding) bind(obj, view, C0624R.layout.layout_item);
    }
}
