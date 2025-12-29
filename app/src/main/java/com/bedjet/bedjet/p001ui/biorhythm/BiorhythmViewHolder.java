package com.bedjet.bedjet.p001ui.biorhythm;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.databinding.LayoutItemBinding;
import com.bedjet.bedjet.databinding.LayoutItemBiorhythmBinding;
import com.bedjet.bedjet.utils.Utils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: BiorhythmViewHolder.kt */
@Metadata(m942d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m943d2 = {"Lcom/bedjet/bedjet/ui/biorhythm/BiorhythmViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presenter", "Lcom/bedjet/bedjet/ui/biorhythm/BiorhythmAdapterPresenter;", "<init>", "(Landroid/view/View;Lcom/bedjet/bedjet/ui/biorhythm/BiorhythmAdapterPresenter;)V", "mBinding", "Lcom/bedjet/bedjet/databinding/LayoutItemBiorhythmBinding;", "bind", "", "sequenceStep", "Lcom/bedjet/bedjet/data/local/model/SequenceStep;", "isV2Mode", "", "useCelsius", "setMode", "getColor", "", "context", "Landroid/content/Context;", "mode", "setTemperature", "setClockTime", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BiorhythmViewHolder extends RecyclerView.ViewHolder {
    private final LayoutItemBiorhythmBinding mBinding;
    private final BiorhythmAdapterPresenter presenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiorhythmViewHolder(View view, BiorhythmAdapterPresenter presenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
        this.mBinding = (LayoutItemBiorhythmBinding) DataBindingUtil.bind(view);
    }

    public final void bind(SequenceStep sequenceStep, boolean isV2Mode, boolean useCelsius) {
        Intrinsics.checkNotNullParameter(sequenceStep, "sequenceStep");
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding = this.mBinding;
        if (layoutItemBiorhythmBinding != null) {
            layoutItemBiorhythmBinding.setPosition(Integer.valueOf(getAdapterPosition()));
        }
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding2 = this.mBinding;
        if (layoutItemBiorhythmBinding2 != null) {
            layoutItemBiorhythmBinding2.setPresenter(this.presenter);
        }
        setMode(sequenceStep);
        setTemperature(sequenceStep, isV2Mode, useCelsius);
        setClockTime(sequenceStep);
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding3 = this.mBinding;
        if (layoutItemBiorhythmBinding3 != null) {
            layoutItemBiorhythmBinding3.executePendingBindings();
        }
    }

    private final void setMode(SequenceStep sequenceStep) {
        LayoutItemBinding layoutItemBinding;
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding = this.mBinding;
        if (layoutItemBiorhythmBinding == null || (layoutItemBinding = layoutItemBiorhythmBinding.itemMode) == null) {
            return;
        }
        layoutItemBinding.itemTitle.setText(utils.getModeName(sequenceStep.getMode()));
        if (sequenceStep.getMode() == 6) {
            layoutItemBinding.itemValue.setText("----");
        } else {
            layoutItemBinding.itemValue.setText(layoutItemBinding.getRoot().getContext().getString(C0624R.string.item_fan_step, Integer.valueOf((sequenceStep.getFanStep() * 5) + 5)));
        }
        ConstraintLayout constraintLayout = layoutItemBinding.itemLayout;
        Context context = layoutItemBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        constraintLayout.setBackgroundColor(getColor(context, sequenceStep.getMode()));
    }

    private final int getColor(Context context, int mode) {
        if (mode == 1) {
            return ContextCompat.getColor(context, C0624R.color.colorHeatButton);
        }
        if (mode == 2) {
            return ContextCompat.getColor(context, C0624R.color.colorTurboButton);
        }
        if (mode == 3) {
            return ContextCompat.getColor(context, C0624R.color.colorExtHeatButton);
        }
        if (mode == 4) {
            return ContextCompat.getColor(context, C0624R.color.colorCoolButton);
        }
        if (mode == 5) {
            return ContextCompat.getColor(context, C0624R.color.colorDryButton);
        }
        return ContextCompat.getColor(context, C0624R.color.colorOffButton);
    }

    private final void setTemperature(SequenceStep sequenceStep, boolean isV2Mode, boolean useCelsius) {
        LayoutItemBinding layoutItemBinding;
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding = this.mBinding;
        if (layoutItemBiorhythmBinding == null || (layoutItemBinding = layoutItemBiorhythmBinding.itemTemp) == null) {
            return;
        }
        layoutItemBinding.itemTitle.setText(C0624R.string.item_temp);
        if (sequenceStep.getMode() == 2) {
            layoutItemBinding.itemValue.setText(Utils.renderTemp(86, useCelsius));
        } else if (sequenceStep.getMode() == 6 || (sequenceStep.getMode() == 4 && isV2Mode)) {
            layoutItemBinding.itemValue.setText("----");
        } else {
            layoutItemBinding.itemValue.setText(Utils.renderTemp(sequenceStep.getTemperature(), useCelsius));
        }
    }

    private final void setClockTime(SequenceStep sequenceStep) {
        String format;
        LayoutItemBinding layoutItemBinding;
        AppCompatTextView appCompatTextView;
        LayoutItemBinding layoutItemBinding2;
        AppCompatTextView appCompatTextView2;
        LayoutItemBinding layoutItemBinding3;
        AppCompatTextView appCompatTextView3;
        int hours = sequenceStep.getHours();
        int minutes = sequenceStep.getMinutes();
        if (sequenceStep.isClocktime()) {
            LayoutItemBiorhythmBinding layoutItemBiorhythmBinding = this.mBinding;
            if (layoutItemBiorhythmBinding != null && (layoutItemBinding3 = layoutItemBiorhythmBinding.itemTime) != null && (appCompatTextView3 = layoutItemBinding3.itemTitle) != null) {
                appCompatTextView3.setText(C0624R.string.bio_stopat);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(hours), Integer.valueOf(minutes)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        } else {
            LayoutItemBiorhythmBinding layoutItemBiorhythmBinding2 = this.mBinding;
            if (layoutItemBiorhythmBinding2 != null && (layoutItemBinding = layoutItemBiorhythmBinding2.itemTime) != null && (appCompatTextView = layoutItemBinding.itemTitle) != null) {
                appCompatTextView.setText(C0624R.string.bio_runfor);
            }
            if (sequenceStep.getMode() == 2) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                format = String.format(Locale.getDefault(), "%02dm", Arrays.copyOf(new Object[]{Integer.valueOf(minutes)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                format = String.format(Locale.getDefault(), "%02dh %02dm", Arrays.copyOf(new Object[]{Integer.valueOf(hours), Integer.valueOf(minutes)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            }
        }
        LayoutItemBiorhythmBinding layoutItemBiorhythmBinding3 = this.mBinding;
        if (layoutItemBiorhythmBinding3 == null || (layoutItemBinding2 = layoutItemBiorhythmBinding3.itemTime) == null || (appCompatTextView2 = layoutItemBinding2.itemValue) == null) {
            return;
        }
        appCompatTextView2.setText(format);
    }
}
