package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.C0624R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class FragmentSetupV3Binding extends ViewDataBinding {
    public final MaterialButton actionButton;
    public final TextInputLayout etLayoutName;
    public final TextInputEditText etName;

    @Bindable
    protected View.OnClickListener mClickListener;
    public final RadioButton radioButtonDualZoneNo;
    public final RadioButton radioButtonDualZoneYes;
    public final RadioButton radioButtonLightsOff;
    public final RadioButton radioButtonLightsOn;
    public final RadioButton radioButtonPowerNo;
    public final RadioButton radioButtonPowerYes;
    public final RadioButton radioButtonSoundsOff;
    public final RadioButton radioButtonSoundsOn;
    public final RadioGroup radioGroupDualZone;
    public final RadioGroup radioGroupLights;
    public final RadioGroup radioGroupPower;
    public final RadioGroup radioGroupSounds;
    public final LinearLayoutCompat topContainer;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSetupV3Binding(Object obj, View view, int i, MaterialButton materialButton, TextInputLayout textInputLayout, TextInputEditText textInputEditText, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, RadioGroup radioGroup4, LinearLayoutCompat linearLayoutCompat) {
        super(obj, view, i);
        this.actionButton = materialButton;
        this.etLayoutName = textInputLayout;
        this.etName = textInputEditText;
        this.radioButtonDualZoneNo = radioButton;
        this.radioButtonDualZoneYes = radioButton2;
        this.radioButtonLightsOff = radioButton3;
        this.radioButtonLightsOn = radioButton4;
        this.radioButtonPowerNo = radioButton5;
        this.radioButtonPowerYes = radioButton6;
        this.radioButtonSoundsOff = radioButton7;
        this.radioButtonSoundsOn = radioButton8;
        this.radioGroupDualZone = radioGroup;
        this.radioGroupLights = radioGroup2;
        this.radioGroupPower = radioGroup3;
        this.radioGroupSounds = radioGroup4;
        this.topContainer = linearLayoutCompat;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static FragmentSetupV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSetupV3Binding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_setup_v3, viewGroup, z, obj);
    }

    public static FragmentSetupV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSetupV3Binding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_setup_v3, null, false, obj);
    }

    public static FragmentSetupV3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSetupV3Binding bind(View view, Object obj) {
        return (FragmentSetupV3Binding) bind(obj, view, C0624R.layout.fragment_setup_v3);
    }
}
