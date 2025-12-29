package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter;

/* loaded from: classes.dex */
public abstract class LayoutItemBiorhythmBinding extends ViewDataBinding {
    public final AppCompatImageView itemEdit;
    public final LayoutItemBinding itemMode;
    public final LayoutItemBinding itemTemp;
    public final LayoutItemBinding itemTime;

    @Bindable
    protected Integer mPosition;

    @Bindable
    protected BiorhythmAdapterPresenter mPresenter;

    public abstract void setPosition(Integer num);

    public abstract void setPresenter(BiorhythmAdapterPresenter biorhythmAdapterPresenter);

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutItemBiorhythmBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, LayoutItemBinding layoutItemBinding, LayoutItemBinding layoutItemBinding2, LayoutItemBinding layoutItemBinding3) {
        super(obj, view, i);
        this.itemEdit = appCompatImageView;
        this.itemMode = layoutItemBinding;
        this.itemTemp = layoutItemBinding2;
        this.itemTime = layoutItemBinding3;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public BiorhythmAdapterPresenter getPresenter() {
        return this.mPresenter;
    }

    public static LayoutItemBiorhythmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBiorhythmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutItemBiorhythmBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_item_biorhythm, viewGroup, z, obj);
    }

    public static LayoutItemBiorhythmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBiorhythmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutItemBiorhythmBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.layout_item_biorhythm, null, false, obj);
    }

    public static LayoutItemBiorhythmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutItemBiorhythmBinding bind(View view, Object obj) {
        return (LayoutItemBiorhythmBinding) bind(obj, view, C0624R.layout.layout_item_biorhythm);
    }
}
