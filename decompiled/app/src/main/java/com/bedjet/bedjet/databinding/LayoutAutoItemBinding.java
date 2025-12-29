package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;

/* loaded from: classes.dex */
public abstract class LayoutAutoItemBinding extends ViewDataBinding {
    public final AppCompatTextView autoAirValue;
    public final AppCompatTextView autoHrsValue;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutAutoItemBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.autoAirValue = appCompatTextView;
        this.autoHrsValue = appCompatTextView2;
    }

    public static LayoutAutoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAutoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutAutoItemBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_auto_item, viewGroup, z, obj);
    }

    public static LayoutAutoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAutoItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutAutoItemBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_auto_item, null, false, obj);
    }

    public static LayoutAutoItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAutoItemBinding bind(View view, Object obj) {
        return (LayoutAutoItemBinding) bind(obj, view, C0624R.layout.layout_auto_item);
    }
}
