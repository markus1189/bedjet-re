package com.bedjet.bedjet.p001ui.setup;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.databinding.FragmentSetupV3Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SetupV3Fragment.kt */
@Metadata(m942d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m943d2 = {"Lcom/bedjet/bedjet/ui/setup/SetupV3Fragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentSetupV3Binding;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "clickListener", "Landroid/view/View$OnClickListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SetupV3Fragment extends BaseFragment<FragmentSetupV3Binding> {
    private final View.OnClickListener clickListener;

    public SetupV3Fragment() {
        super(C0624R.layout.fragment_setup_v3);
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.setup.SetupV3Fragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetupV3Fragment.clickListener$lambda$1(SetupV3Fragment.this, view);
            }
        };
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setClickListener(this.clickListener);
        getBinding().etName.setText(getMainActivity().getBedjetName());
        getBinding().radioGroupDualZone.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.setup.SetupV3Fragment$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                SetupV3Fragment.onViewCreated$lambda$0(SetupV3Fragment.this, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SetupV3Fragment setupV3Fragment, RadioGroup radioGroup, int i) {
        setupV3Fragment.getBinding().radioButtonPowerYes.setEnabled(i == C0624R.id.radioButtonDualZoneNo);
        setupV3Fragment.getBinding().radioButtonPowerNo.setEnabled(i == C0624R.id.radioButtonDualZoneNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$1(SetupV3Fragment setupV3Fragment, View v) {
        String obj;
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == C0624R.id.actionButton) {
            Editable text = setupV3Fragment.getBinding().etName.getText();
            String obj2 = (text == null || (obj = text.toString()) == null) ? null : StringsKt.trim((CharSequence) obj).toString();
            setupV3Fragment.getBinding().etLayoutName.setErrorEnabled(false);
            String str = obj2;
            if (str == null || str.length() == 0) {
                setupV3Fragment.getBinding().etLayoutName.setError(v.getContext().getString(C0624R.string.fragment_setup_v3_empty_error));
                setupV3Fragment.getBinding().etLayoutName.setErrorEnabled(true);
                return;
            }
            boolean z = setupV3Fragment.getBinding().radioGroupSounds.getCheckedRadioButtonId() == C0624R.id.radioButtonSoundsOn;
            boolean z2 = setupV3Fragment.getBinding().radioGroupLights.getCheckedRadioButtonId() == C0624R.id.radioButtonLightsOn;
            boolean z3 = setupV3Fragment.getBinding().radioGroupDualZone.getCheckedRadioButtonId() == C0624R.id.radioButtonDualZoneYes || setupV3Fragment.getBinding().radioGroupPower.getCheckedRadioButtonId() == C0624R.id.radioButtonPowerYes;
            setupV3Fragment.getNavigator().addSpecifiedFragment(new SetupV3LoadingFragment());
            setupV3Fragment.getMainActivity().setupInitialV3(obj2, z, z2, z3);
        }
    }
}
