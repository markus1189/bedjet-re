package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentDevicelistBinding extends ViewDataBinding {
    public final MaterialButton deviceListButtonRescan;
    public final ProgressBar deviceListProgressBar;
    public final RecyclerView deviceListRecyclerView;
    public final AppCompatTextView deviceListTitle;

    @Bindable
    protected View.OnClickListener mClickListener;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDevicelistBinding(Object obj, View view, int i, MaterialButton materialButton, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.deviceListButtonRescan = materialButton;
        this.deviceListProgressBar = progressBar;
        this.deviceListRecyclerView = recyclerView;
        this.deviceListTitle = appCompatTextView;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentDevicelistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDevicelistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDevicelistBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_devicelist, viewGroup, z, obj);
    }

    public static FragmentDevicelistBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDevicelistBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDevicelistBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_devicelist, null, false, obj);
    }

    public static FragmentDevicelistBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDevicelistBinding bind(View view, Object obj) {
        return (FragmentDevicelistBinding) bind(obj, view, C0624R.layout.fragment_devicelist);
    }
}
