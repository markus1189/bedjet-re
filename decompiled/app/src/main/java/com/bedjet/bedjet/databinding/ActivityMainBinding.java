package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.main.MainActivity;

/* loaded from: classes.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final View actionBarDivider;

    @Bindable
    protected MainActivity mPresenter;
    public final Group mainActionBar;
    public final AppCompatImageView mainBack;
    public final AppCompatTextView mainConnectedDevice;
    public final FrameLayout mainContainer;
    public final ConstraintLayout mainLayout;
    public final AppCompatImageView mainLogo;
    public final AppCompatImageView mainMenu;

    public abstract void setPresenter(MainActivity mainActivity);

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMainBinding(Object obj, View view, int i, View view2, Group group, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, FrameLayout frameLayout, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3) {
        super(obj, view, i);
        this.actionBarDivider = view2;
        this.mainActionBar = group;
        this.mainBack = appCompatImageView;
        this.mainConnectedDevice = appCompatTextView;
        this.mainContainer = frameLayout;
        this.mainLayout = constraintLayout;
        this.mainLogo = appCompatImageView2;
        this.mainMenu = appCompatImageView3;
    }

    public MainActivity getPresenter() {
        return this.mPresenter;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, C0624R.layout.activity_main);
    }
}
