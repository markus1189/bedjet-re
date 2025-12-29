package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentStoredDeviceBinding extends ViewDataBinding {

    @Bindable
    protected View.OnClickListener mClickListener;
    public final MaterialButton storedDeviceButtonRescan;
    public final RecyclerView storedDeviceRecyclerView;
    public final AppCompatTextView storedDeviceTitle;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentStoredDeviceBinding(Object obj, View view, int i, MaterialButton materialButton, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.storedDeviceButtonRescan = materialButton;
        this.storedDeviceRecyclerView = recyclerView;
        this.storedDeviceTitle = appCompatTextView;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentStoredDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoredDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentStoredDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_stored_device, viewGroup, z, obj);
    }

    public static FragmentStoredDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoredDeviceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentStoredDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_stored_device, null, false, obj);
    }

    public static FragmentStoredDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoredDeviceBinding bind(View view, Object obj) {
        return (FragmentStoredDeviceBinding) bind(obj, view, C0624R.layout.fragment_stored_device);
    }
}
