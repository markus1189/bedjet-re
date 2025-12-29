package com.bedjet.bedjet.p001ui.biorhythm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.Constants;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.legacy.SequenceStepV2;
import com.bedjet.bedjet.p001ui.custom.picker.PickerDialog;
import com.bedjet.bedjet.p001ui.custom.picker.PickerListener;
import com.bedjet.bedjet.utils.Logger;
import com.bedjet.bedjet.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BiorhythmAdapter extends RecyclerView.Adapter<BiorhythmViewHolder> implements BiorhythmAdapterPresenter {
    private List<SequenceStepV2> V2StepList;
    private Dialog editDialog;
    private final Context mContext;
    private final BiorhythmAdapterSequenceChangeListener sequenceChangeListener;
    private final Boolean useCelsius;
    private final List<SequenceStep> mSequenceStepList = new ArrayList();
    private final ArrayList<String> mPowerInPercentage = new ArrayList<>();
    private boolean isV2Mode = false;
    private ArrayList<String> mFanMode = new ArrayList<String>() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter.1
        {
            add("INVAL");
        }
    };

    public BiorhythmAdapter(Context context, Boolean bool, BiorhythmAdapterSequenceChangeListener biorhythmAdapterSequenceChangeListener) {
        this.mContext = context;
        this.useCelsius = bool;
        this.sequenceChangeListener = biorhythmAdapterSequenceChangeListener;
        initArray();
    }

    private void initArray() {
        for (int i = 5; i <= 100; i += 5) {
            this.mPowerInPercentage.add(i + "%");
        }
    }

    public void setV2Mode(List<SequenceStepV2> list) {
        this.isV2Mode = true;
        this.V2StepList = list;
        this.mFanMode = new ArrayList<String>() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter.2
            {
                add(Constants.LONG_MODENAME_TURBO);
                add("Heat");
                add("Cool");
                add("Wait");
            }
        };
    }

    public void setV3Mode() {
        this.isV2Mode = false;
        this.mFanMode = new ArrayList<String>() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter.3
            {
                add(Constants.LONG_MODENAME_TURBO);
                add("Heat");
                add(Constants.LONG_MODENAME_EXTHT);
                add("Cool");
                add("Dry");
                add("Wait");
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BiorhythmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BiorhythmViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0624R.layout.layout_item_biorhythm, viewGroup, false), this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BiorhythmViewHolder biorhythmViewHolder, int i) {
        SequenceStep sequenceStep;
        if (this.isV2Mode) {
            sequenceStep = utils.convertV2step(this.V2StepList.get(i));
        } else {
            sequenceStep = this.mSequenceStepList.get(i);
        }
        biorhythmViewHolder.bind(sequenceStep, this.isV2Mode, this.useCelsius.booleanValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isV2Mode) {
            List<SequenceStepV2> list = this.V2StepList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return this.mSequenceStepList.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addItem(SequenceStep sequenceStep) {
        this.mSequenceStepList.add(sequenceStep);
        notifyItemInserted(this.mSequenceStepList.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearItems() {
        this.mSequenceStepList.clear();
        notifyDataSetChanged();
    }

    private void deleteItem(int i) {
        if (this.isV2Mode) {
            this.V2StepList.remove(i);
        } else {
            this.mSequenceStepList.remove(i);
        }
        notifyDataSetChanged();
    }

    private void insertItemAt(int i) {
        if (this.isV2Mode) {
            this.V2StepList.add(i, new SequenceStepV2(true, 3, 20, 1, 0, 0, 80, 0, 0, false, 0, 0));
        } else {
            this.mSequenceStepList.add(i, new SequenceStep(6, 19, 1, 0, 80, false));
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SequenceStep> getStepList() {
        return this.mSequenceStepList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequenceStep getItemAtIndex(int i) {
        return this.mSequenceStepList.get(i);
    }

    @Override // com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter
    public void onModeClicked(final int i) {
        SequenceStep sequenceStep;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.isV2Mode) {
            sequenceStep = utils.convertV2step(this.V2StepList.get(i));
        } else {
            sequenceStep = this.mSequenceStepList.get(i);
        }
        PickerDialog.INSTANCE.showWorkModeDialog(context, this.mFanMode, this.mPowerInPercentage, utils.getModeName(sequenceStep.getMode()), ((sequenceStep.getFanStep() * 5) + 5) + "%", new PickerListener.DoublePickerListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda3
            @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.DoublePickerListener
            public final void onPickerSet(String str, String str2) {
                BiorhythmAdapter.this.lambda$onModeClicked$0(i, str, str2);
            }
        });
    }

    @Override // com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter
    public void onTimerClicked(final int i) {
        SequenceStep sequenceStep;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.isV2Mode) {
            sequenceStep = utils.convertV2step(this.V2StepList.get(i));
        } else {
            sequenceStep = this.mSequenceStepList.get(i);
        }
        SequenceStep sequenceStep2 = sequenceStep;
        if (sequenceStep2.getMode() == 2) {
            PickerDialog.INSTANCE.showTurboDialog(context, sequenceStep2.getMinutes() - 1, new PickerListener.SinglePickerListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda0
                @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.SinglePickerListener
                public final void onPickerSet(String str) {
                    BiorhythmAdapter.this.lambda$onTimerClicked$1(i, str);
                }
            });
        } else {
            PickerDialog.INSTANCE.showTimerDialog(context, sequenceStep2, sequenceStep2.getHours(), sequenceStep2.getMinutes(), new PickerListener.DoublePickerListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda2
                @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.DoublePickerListener
                public final void onPickerSet(String str, String str2) {
                    BiorhythmAdapter.this.lambda$onTimerClicked$2(i, str, str2);
                }
            });
        }
    }

    @Override // com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter
    public void onTempClicked(final int i) {
        SequenceStep sequenceStep;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.isV2Mode) {
            sequenceStep = utils.convertV2step(this.V2StepList.get(i));
            if (sequenceStep.getMode() == 4) {
                return;
            }
        } else {
            sequenceStep = this.mSequenceStepList.get(i);
        }
        SequenceStep sequenceStep2 = sequenceStep;
        if (sequenceStep2.getMode() == 6 || sequenceStep2.getMode() == 2) {
            return;
        }
        PickerDialog.INSTANCE.showTempDialog(context, sequenceStep2, this.useCelsius.booleanValue(), Utils.renderTemp(sequenceStep2.getTemperature(), this.useCelsius.booleanValue()), new PickerListener.SinglePickerListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda4
            @Override // com.bedjet.bedjet.ui.custom.picker.PickerListener.SinglePickerListener
            public final void onPickerSet(String str) {
                BiorhythmAdapter.this.lambda$onTempClicked$3(i, str);
            }
        });
    }

    private void validateTempTime(SequenceStep sequenceStep, int i, int i2, int i3) {
        if (sequenceStep.getTemperature() > i2 || sequenceStep.getTemperature() < i) {
            sequenceStep.setTemperature(i3);
        }
        int bioStepMaxTime = sequenceStep.isClocktime() ? 23 : Utils.getBioStepMaxTime(sequenceStep);
        if (sequenceStep.getHours() > bioStepMaxTime) {
            sequenceStep.setHours(bioStepMaxTime);
        }
        if (sequenceStep.getHours() == bioStepMaxTime && !sequenceStep.isClocktime()) {
            sequenceStep.setMinutes(0);
        }
        if (sequenceStep.getMinutes() > 59) {
            sequenceStep.setMinutes(59);
        }
        if (sequenceStep.getMinutes() < 0) {
            sequenceStep.setMinutes(0);
        }
    }

    private void validateSpecifiedStep(int i) {
        if (this.isV2Mode) {
            SequenceStepV2 sequenceStepV2 = this.V2StepList.get(i);
            int i2 = sequenceStepV2.operatingMode;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (sequenceStepV2.remain_hour != 0) {
                        sequenceStepV2.remain_hour = 0;
                        sequenceStepV2.remain_minute = 10;
                    }
                    if (sequenceStepV2.remain_minute > 10) {
                        sequenceStepV2.remain_minute = 10;
                    }
                    if (sequenceStepV2.remain_minute < 1) {
                        sequenceStepV2.remain_minute = 1;
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (sequenceStepV2.heat_setpoint > 80) {
                        sequenceStepV2.heat_setpoint = 80;
                    }
                    if (sequenceStepV2.heat_setpoint < 44) {
                        sequenceStepV2.heat_setpoint = 44;
                    }
                } else if (i2 != 3) {
                    sequenceStepV2.operatingMode = 3;
                    sequenceStepV2.remain_minute = 0;
                    sequenceStepV2.remain_hour = 1;
                    sequenceStepV2.heat_setpoint = 80;
                    return;
                }
            }
            int bioStepMaxTime = Utils.getBioStepMaxTime(utils.convertV2step(sequenceStepV2));
            if (sequenceStepV2.remain_hour > bioStepMaxTime) {
                sequenceStepV2.remain_hour = bioStepMaxTime;
            }
            if (sequenceStepV2.remain_hour == bioStepMaxTime) {
                sequenceStepV2.remain_minute = 0;
            }
            if (sequenceStepV2.remain_minute > 59) {
                sequenceStepV2.remain_minute = 59;
            }
            if (sequenceStepV2.remain_minute < 0) {
                sequenceStepV2.remain_minute = 0;
                return;
            }
            return;
        }
        SequenceStep sequenceStep = this.mSequenceStepList.get(i);
        switch (sequenceStep.getMode()) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                int minMaxTemp = Utils.getMinMaxTemp(sequenceStep.getMode(), false);
                int minMaxTemp2 = Utils.getMinMaxTemp(sequenceStep.getMode(), true);
                validateTempTime(sequenceStep, minMaxTemp, minMaxTemp2, sequenceStep.getMode() == 1 ? minMaxTemp2 : minMaxTemp);
                return;
            case 2:
                if (sequenceStep.getHours() > 0) {
                    sequenceStep.setHours(0);
                    sequenceStep.setMinutes(10);
                }
                if (sequenceStep.getMinutes() > 10) {
                    sequenceStep.setMinutes(10);
                }
                if (sequenceStep.getMinutes() == 0) {
                    sequenceStep.setMinutes(1);
                    return;
                }
                return;
            default:
                sequenceStep.setMode(1);
                sequenceStep.setTemperature(44);
                sequenceStep.setHours(0);
                sequenceStep.setMinutes(20);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onModePickerListener, reason: merged with bridge method [inline-methods] */
    public void lambda$onModeClicked$0(String str, String str2, int i) {
        if (this.isV2Mode) {
            SequenceStepV2 sequenceStepV2 = this.V2StepList.get(i);
            sequenceStepV2.operatingMode = utils.getModeCode(str, true);
            try {
                sequenceStepV2.currentFan = Integer.parseInt(str2.replaceAll("\\D+", "")) / 5;
            } catch (NumberFormatException e) {
                sequenceStepV2.currentFan = 20;
                Logger.m517e(this, e.getMessage());
            }
            validateSpecifiedStep(i);
            Utils.setGraphV2(this.V2StepList);
        } else {
            SequenceStep sequenceStep = this.mSequenceStepList.get(i);
            int modeCode = utils.getModeCode(str, false);
            sequenceStep.setMode(modeCode);
            if (modeCode != 4 && modeCode != 3 && modeCode != 6) {
                sequenceStep.setClocktime(false);
            }
            try {
                sequenceStep.setFanStep((Integer.parseInt(str2.replaceAll("\\D+", "")) / 5) - 1);
            } catch (NumberFormatException e2) {
                sequenceStep.setFanStep(0);
                Logger.m517e(this, e2.getMessage());
            }
            validateSpecifiedStep(i);
            updateGraph();
        }
        this.sequenceChangeListener.onChange();
        notifyItemChanged(i);
    }

    private void updateGraph() {
        this.sequenceChangeListener.onChange();
        if (this.isV2Mode) {
            Utils.setGraphV2(this.V2StepList);
        } else {
            Utils.setGraph(this.mSequenceStepList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTimerListener, reason: merged with bridge method [inline-methods] */
    public void lambda$onTimerClicked$2(String str, String str2, int i) {
        int i2;
        int i3;
        try {
            i2 = Integer.parseInt(str);
            i3 = Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            Logger.m517e(this, e.getMessage());
            i2 = 1;
            i3 = 0;
        }
        if (this.isV2Mode) {
            SequenceStepV2 sequenceStepV2 = this.V2StepList.get(i);
            sequenceStepV2.remain_hour = i2;
            sequenceStepV2.remain_minute = i3;
            Utils.setGraphV2(this.V2StepList);
        } else {
            SequenceStep sequenceStep = this.mSequenceStepList.get(i);
            sequenceStep.setHours(i2);
            sequenceStep.setMinutes(i3);
            Utils.setGraph(this.mSequenceStepList);
        }
        validateSpecifiedStep(i);
        this.sequenceChangeListener.onChange();
        notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTurboListener, reason: merged with bridge method [inline-methods] */
    public void lambda$onTimerClicked$1(String str, int i) {
        int i2;
        try {
            i2 = Integer.parseInt(str.replaceFirst(" .*", ""));
        } catch (NumberFormatException e) {
            Logger.m517e(this, e.getMessage());
            i2 = 0;
        }
        if (i2 > 10) {
            i2 = 10;
        }
        if (this.isV2Mode) {
            SequenceStepV2 sequenceStepV2 = this.V2StepList.get(i);
            sequenceStepV2.remain_hour = 0;
            sequenceStepV2.remain_minute = i2;
        } else {
            SequenceStep sequenceStep = this.mSequenceStepList.get(i);
            sequenceStep.setHours(0);
            sequenceStep.setMinutes(i2);
        }
        validateSpecifiedStep(i);
        this.sequenceChangeListener.onChange();
        updateGraph();
        notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTempListener, reason: merged with bridge method [inline-methods] */
    public void lambda$onTempClicked$3(String str, int i) {
        int i2;
        try {
            i2 = Integer.parseInt(str.replaceFirst(" .*", ""));
        } catch (NullPointerException e) {
            Logger.m517e(this, e.getMessage());
            i2 = 80;
        }
        int c = this.useCelsius.booleanValue() ? i2 * 2 : Utils.toC(i2);
        if (this.isV2Mode) {
            this.V2StepList.get(i).heat_setpoint = c;
        } else {
            this.mSequenceStepList.get(i).setTemperature(c);
        }
        validateSpecifiedStep(i);
        updateGraph();
        notifyItemChanged(i);
    }

    boolean hasTimeMode(int i) {
        if (this.isV2Mode) {
            int i2 = this.V2StepList.get(i).operatingMode;
            if (i2 != 0 && i2 != 3) {
                return false;
            }
        } else {
            int mode = this.mSequenceStepList.get(i).getMode();
            if (mode != 6 && mode != 3 && mode != 4) {
                return false;
            }
        }
        return true;
    }

    private void showTimeModePopup(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        String[] strArr = {"Run Until"};
        final boolean[] zArr = new boolean[1];
        if (this.isV2Mode) {
            zArr[0] = this.V2StepList.get(i).absolute;
        } else {
            zArr[0] = this.mSequenceStepList.get(i).isClocktime();
        }
        builder.setTitle("Time Mode").setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                BiorhythmAdapter.lambda$showTimeModePopup$4(zArr, dialogInterface, i2, z);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                BiorhythmAdapter.this.lambda$showTimeModePopup$5(i, zArr, dialogInterface, i2);
            }
        }).show();
        this.editDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showTimeModePopup$4(boolean[] zArr, DialogInterface dialogInterface, int i, boolean z) {
        zArr[i] = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTimeModePopup$5(int i, boolean[] zArr, DialogInterface dialogInterface, int i2) {
        if (this.isV2Mode) {
            this.V2StepList.get(i).absolute = zArr[0];
        } else {
            this.mSequenceStepList.get(i).setClocktime(zArr[0]);
        }
        validateSpecifiedStep(i);
        updateGraph();
        notifyDataSetChanged();
        this.sequenceChangeListener.onChange();
    }

    @Override // com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterPresenter
    public void showEditMenu(final int i) {
        Dialog dialog = new Dialog(this.mContext, C0624R.style.AppDialog);
        this.editDialog = dialog;
        dialog.setCanceledOnTouchOutside(false);
        this.editDialog.setContentView(C0624R.layout.bioedit_options);
        Button button = (Button) this.editDialog.findViewById(C0624R.id.btn_insbefore);
        Button button2 = (Button) this.editDialog.findViewById(C0624R.id.btn_insafter);
        Button button3 = (Button) this.editDialog.findViewById(C0624R.id.btn_delstep);
        Button button4 = (Button) this.editDialog.findViewById(C0624R.id.btn_timemode);
        Button button5 = (Button) this.editDialog.findViewById(C0624R.id.btn_cancel);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmAdapter.this.lambda$showEditMenu$6(i, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmAdapter.this.lambda$showEditMenu$7(i, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmAdapter.this.lambda$showEditMenu$8(i, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmAdapter.this.lambda$showEditMenu$9(i, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmAdapter.this.lambda$showEditMenu$10(view);
            }
        });
        int itemCount = getItemCount();
        button3.setEnabled(itemCount != 1);
        button.setEnabled(itemCount != 32);
        button.setEnabled(itemCount != 32);
        button4.setEnabled(hasTimeMode(i));
        this.editDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEditMenu$6(int i, View view) {
        deleteItem(i);
        this.editDialog.cancel();
        updateGraph();
        this.sequenceChangeListener.onChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEditMenu$7(int i, View view) {
        insertItemAt(i);
        this.editDialog.cancel();
        updateGraph();
        this.sequenceChangeListener.onChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEditMenu$8(int i, View view) {
        insertItemAt(i + 1);
        this.editDialog.cancel();
        updateGraph();
        this.sequenceChangeListener.onChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEditMenu$9(int i, View view) {
        showTimeModePopup(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEditMenu$10(View view) {
        this.editDialog.cancel();
    }
}
