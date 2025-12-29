package com.bedjet.bedjet.arch;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import kotlin.Metadata;

/* compiled from: FragmentNavigator.kt */
@Metadata(m942d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, m943d2 = {"Lcom/bedjet/bedjet/arch/FragmentNavigator;", "", "showBluetoothFragment", "", "path", "", "showConnectionFragment", "showDeviceListFragment", "showStoredDeviceFragment", "showTemperatureFragment", "showBiorhythmFragment", "showConnectedFragment", "showMenuFragment", "showWifiPermissionFragment", "showWifiFragment", "showPromptFragment", "promptType", "Lcom/bedjet/bedjet/ui/prompt/PromptType;", "showSetupV3Fragment", "addSpecifiedFragment", "fragment", "Landroidx/fragment/app/Fragment;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface FragmentNavigator {
    void addSpecifiedFragment(Fragment fragment);

    void showBiorhythmFragment();

    void showBluetoothFragment(int path);

    void showConnectedFragment();

    void showConnectionFragment(int path);

    void showDeviceListFragment(int path);

    void showMenuFragment();

    void showPromptFragment(PromptType promptType);

    void showSetupV3Fragment();

    void showStoredDeviceFragment(int path);

    void showTemperatureFragment();

    void showWifiFragment();

    void showWifiPermissionFragment();
}
