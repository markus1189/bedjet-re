package com.bedjet.bedjet.p001ui.temperature;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;

/* loaded from: classes.dex */
public class TemperatureAdapter extends RecyclerView.Adapter<TemperatureViewHolder> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TemperatureViewHolder temperatureViewHolder, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TemperatureViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TemperatureViewHolder(this, DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C0624R.layout.layout_auto_item, viewGroup, false).getRoot());
    }

    /* loaded from: classes.dex */
    public class TemperatureViewHolder extends RecyclerView.ViewHolder {
        public TemperatureViewHolder(TemperatureAdapter temperatureAdapter, View view) {
            super(view);
        }
    }
}
