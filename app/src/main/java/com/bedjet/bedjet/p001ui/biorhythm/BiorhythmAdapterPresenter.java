package com.bedjet.bedjet.p001ui.biorhythm;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: BiorhythmAdapterPresenter.kt */
@Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, m943d2 = {"Lcom/bedjet/bedjet/ui/biorhythm/BiorhythmAdapterPresenter;", "", "showEditMenu", "", "position", "", "onModeClicked", "onTimerClicked", "onTempClicked", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface BiorhythmAdapterPresenter {
    void onModeClicked(int position);

    void onTempClicked(int position);

    void onTimerClicked(int position);

    void showEditMenu(int position);
}
