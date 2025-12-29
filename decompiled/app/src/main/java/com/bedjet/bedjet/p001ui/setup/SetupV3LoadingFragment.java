package com.bedjet.bedjet.p001ui.setup;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.databinding.FragmentSetupV3LoadingBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetupV3LoadingFragment.kt */
@Metadata(m942d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/setup/SetupV3LoadingFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentSetupV3LoadingBinding;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupV3Finished", "clickListener", "Landroid/view/View$OnClickListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SetupV3LoadingFragment extends BaseFragment<FragmentSetupV3LoadingBinding> {
    private final View.OnClickListener clickListener;

    public SetupV3LoadingFragment() {
        super(C0624R.layout.fragment_setup_v3_loading);
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.setup.SetupV3LoadingFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetupV3LoadingFragment.clickListener$lambda$1(SetupV3LoadingFragment.this, view);
            }
        };
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setClickListener(this.clickListener);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void setupV3Finished() {
        super.setupV3Finished();
        getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.setup.SetupV3LoadingFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SetupV3LoadingFragment.setupV3Finished$lambda$0(SetupV3LoadingFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupV3Finished$lambda$0(SetupV3LoadingFragment setupV3LoadingFragment) {
        setupV3LoadingFragment.getBinding().progressBar.setVisibility(8);
        setupV3LoadingFragment.getBinding().groupContinue.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$1(SetupV3LoadingFragment setupV3LoadingFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == C0624R.id.btnContinue) {
            setupV3LoadingFragment.getNavigator().showConnectionFragment(15);
        }
    }
}
