package com.bedjet.bedjet.p001ui.custom.picker;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: PickerListener.kt */
@Metadata(m942d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerListener;", "", "SinglePickerListener", "DoublePickerListener", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$DoublePickerListener;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$SinglePickerListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface PickerListener {

    /* compiled from: PickerListener.kt */
    @Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$DoublePickerListener;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener;", "onPickerSet", "", "leftValue", "", "rightValue", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface DoublePickerListener extends PickerListener {
        void onPickerSet(String leftValue, String rightValue);
    }

    /* compiled from: PickerListener.kt */
    @Metadata(m942d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m943d2 = {"Lcom/bedjet/bedjet/ui/custom/picker/PickerListener$SinglePickerListener;", "Lcom/bedjet/bedjet/ui/custom/picker/PickerListener;", "onPickerSet", "", "value", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface SinglePickerListener extends PickerListener {
        void onPickerSet(String value);
    }
}
