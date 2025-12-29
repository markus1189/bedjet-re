package com.bedjet.bedjet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.wifi.WifiFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class FragmentWifiBindingImpl extends FragmentWifiBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C0624R.id.iv_logo, 1);
        sparseIntArray.put(C0624R.id.auto_ssid_frame, 2);
        sparseIntArray.put(C0624R.id.cb_autoset, 3);
        sparseIntArray.put(C0624R.id.ssid_frame, 4);
        sparseIntArray.put(C0624R.id.ap_ssid_text, 5);
        sparseIntArray.put(C0624R.id.ap_ssid_edit, 6);
        sparseIntArray.put(C0624R.id.passwd_frame, 7);
        sparseIntArray.put(C0624R.id.ap_password_edit, 8);
        sparseIntArray.put(C0624R.id.status_frame, 9);
        sparseIntArray.put(C0624R.id.status_string, 10);
        sparseIntArray.put(C0624R.id.btn_setwifi, 11);
        sparseIntArray.put(C0624R.id.btn_cancel_setup, 12);
        sparseIntArray.put(C0624R.id.statusHistory, 13);
        sparseIntArray.put(C0624R.id.btn_goback, 14);
    }

    public FragmentWifiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragmentWifiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[8], (EditText) objArr[6], (AppCompatTextView) objArr[5], (LinearLayout) objArr[2], (MaterialButton) objArr[12], (MaterialButton) objArr[14], (MaterialButton) objArr[11], (CheckBox) objArr[3], (AppCompatImageView) objArr[1], (LinearLayout) objArr[7], (LinearLayout) objArr[4], (LinearLayout) objArr[9], (AppCompatTextView) objArr[13], (AppCompatTextView) objArr[10]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (6 != i) {
            return false;
        }
        setPresenter((WifiFragment) obj);
        return true;
    }

    @Override // com.bedjet.bedjet.databinding.FragmentWifiBinding
    public void setPresenter(WifiFragment wifiFragment) {
        this.mPresenter = wifiFragment;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
