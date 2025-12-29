package com.bedjet.bedjet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.p001ui.biorhythm.BiorhythmFragment;
import com.bedjet.bedjet.p001ui.biorhythm.HeatChartView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class FragmentBiorhythmBinding extends ViewDataBinding {
    public final TextView bioEndTime;
    public final RecyclerView biorhythmItems;
    public final ConstraintLayout biorhythmLayout;
    public final MaterialButton biorhythmLoad;
    public final MaterialButton biorhythmMem1;
    public final MaterialButton biorhythmMem2;
    public final MaterialButton biorhythmMem3;
    public final MaterialButton biorhythmSave;
    public final HeatChartView biorhythmSequence;
    public final MaterialButton biorhythmStart;
    public final MaterialButton biorhythmSuggest;
    public final AppCompatTextView biorhythmTitle;

    @Bindable
    protected BiorhythmFragment mPresenter;

    public abstract void setPresenter(BiorhythmFragment biorhythmFragment);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentBiorhythmBinding(Object obj, View view, int i, TextView textView, RecyclerView recyclerView, ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, MaterialButton materialButton5, HeatChartView heatChartView, MaterialButton materialButton6, MaterialButton materialButton7, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.bioEndTime = textView;
        this.biorhythmItems = recyclerView;
        this.biorhythmLayout = constraintLayout;
        this.biorhythmLoad = materialButton;
        this.biorhythmMem1 = materialButton2;
        this.biorhythmMem2 = materialButton3;
        this.biorhythmMem3 = materialButton4;
        this.biorhythmSave = materialButton5;
        this.biorhythmSequence = heatChartView;
        this.biorhythmStart = materialButton6;
        this.biorhythmSuggest = materialButton7;
        this.biorhythmTitle = appCompatTextView;
    }

    public BiorhythmFragment getPresenter() {
        return this.mPresenter;
    }

    public static FragmentBiorhythmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBiorhythmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBiorhythmBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_biorhythm, viewGroup, z, obj);
    }

    public static FragmentBiorhythmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBiorhythmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBiorhythmBinding) ViewDataBinding.inflateInternal(layoutInflater, C0624R.layout.fragment_biorhythm, null, false, obj);
    }

    public static FragmentBiorhythmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBiorhythmBinding bind(View view, Object obj) {
        return (FragmentBiorhythmBinding) bind(obj, view, C0624R.layout.fragment_biorhythm);
    }
}
