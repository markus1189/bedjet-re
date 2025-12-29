package com.bedjet.bedjet.p001ui.temperature;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.databinding.FragmentTemperatureBinding;

/* loaded from: classes.dex */
public class TemperatureFragment extends BaseFragment<FragmentTemperatureBinding> {
    public void onDesertMode() {
    }

    public void onGentleMode() {
    }

    public void onNightMode() {
    }

    public TemperatureFragment() {
        super(C0624R.layout.fragment_temperature);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    protected Integer getBindingVariable() {
        return 6;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().showActionBar(true);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getController().setConnectedDevice(getMainActivity().getBedjetName());
        getController().showActionBar(true);
        getBinding().autoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getBinding().autoRecyclerView.setAdapter(new TemperatureAdapter());
    }
}
