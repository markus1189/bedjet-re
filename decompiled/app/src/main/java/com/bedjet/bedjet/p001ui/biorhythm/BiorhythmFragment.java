package com.bedjet.bedjet.p001ui.biorhythm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.SequenceStep;
import com.bedjet.bedjet.data.local.model.legacy.SequenceStepV2;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentBiorhythmBinding;
import com.bedjet.bedjet.p000di.TempModeManager;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import com.bedjet.bedjet.p001ui.main.RenameType;
import com.bedjet.bedjet.utils.Utils;
import com.bedjet.bedjet.utils.ext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import org.joda.time.Duration;
import org.koin.java.KoinJavaComponent;
import timber.log.Timber;

/* loaded from: classes.dex */
public class BiorhythmFragment extends BaseFragment<FragmentBiorhythmBinding> {
    private static final String DEFAULT_BIONAME1 = "NEWBIO1";
    private static final String DEFAULT_BIONAME2 = "NEWBIO2";
    private static final String DEFAULT_BIONAME3 = "NEWBIO3";
    private static final String DEFAULT_V2BIONAME1 = "BIO1";
    private static final String DEFAULT_V2BIONAME2 = "BIO2";
    private static final String DEFAULT_V2BIONAME3 = "BIO3";
    public static final int MAX_DURATION_IN_MINUTES = 720;
    private static final String TAG = "BiorhythmFragment";
    private static final String UNUSED_MEMORY = "EMPTY";
    private boolean autoRun;
    private Dialog bioMenuDialog;
    private String bioname1;
    private String bioname2;
    private String bioname3;
    private Button btn_sleeponly;
    private Button btn_sleepwake;
    private boolean buttons_enabled;
    private int currentSequenceNum;
    private SequenceStepV2 currentStep;
    private final ArrayList<SequenceStepV2> legacySequenceV2;
    private BiorhythmAdapter mAdapter;
    private int mCurrentFragment;
    private int mStartFragment;
    private MainActivity myActivity;
    private RadioGroup rg_age;
    private RadioGroup rg_heat;
    private RadioGroup rg_sex;
    private RadioGroup rg_sheet;
    private ProgressDialog sendProgressDialog;
    private int[] seqRandom;
    private boolean sequenceChanged;
    private final Lazy<StoredDeviceManager> storedDeviceManager;
    private final Lazy<TempModeManager> tempModeManager;
    private boolean useV2mode;
    private boolean writingBio;
    private boolean writingName;

    public BiorhythmFragment() {
        super(C0624R.layout.fragment_biorhythm);
        this.bioname1 = null;
        this.bioname2 = null;
        this.bioname3 = null;
        this.autoRun = false;
        this.bioMenuDialog = null;
        this.writingBio = false;
        this.writingName = false;
        this.buttons_enabled = false;
        this.legacySequenceV2 = new ArrayList<>();
        this.useV2mode = false;
        this.storedDeviceManager = KoinJavaComponent.inject(StoredDeviceManager.class);
        this.tempModeManager = KoinJavaComponent.inject(TempModeManager.class);
        this.sequenceChanged = false;
    }

    private void saveSequence(int i) {
        SharedPreferences.Editor edit = getMainActivity().getSharedPreferences("sequence", 0).edit();
        edit.putInt(String.format(Locale.ROOT, "seq%02dsteps", Integer.valueOf(i)), this.legacySequenceV2.size());
        for (int i2 = 0; i2 < this.legacySequenceV2.size(); i2++) {
            edit.putBoolean(String.format(Locale.ROOT, "seq%02dstep%02denab", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).enabled);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dmode", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).operatingMode);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dfan", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).currentFan);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dhour", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).remain_hour);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dmin", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).remain_minute);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dsec", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).remain_sec);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dheat", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).heat_setpoint);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dfana", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).fan_adjust);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dheata", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).heat_adjust);
            edit.putBoolean(String.format(Locale.ROOT, "seq%02dstep%02dabs", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).absolute);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dstoph", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).stop_hour);
            edit.putInt(String.format(Locale.ROOT, "seq%02dstep%02dstopm", Integer.valueOf(i), Integer.valueOf(i2)), this.legacySequenceV2.get(i2).stop_minute);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            edit.putInt(String.format(Locale.ROOT, "seq%02drand%d", Integer.valueOf(i), Integer.valueOf(i3)), this.seqRandom[i3]);
        }
        edit.apply();
        this.sequenceChanged = false;
        if (i != 0) {
            Toast.makeText(getMainActivity(), String.format(Locale.ROOT, "Sequence %d Saved", Integer.valueOf(i)), 0).show();
        }
    }

    private void loadSequence(int i) {
        SharedPreferences sharedPreferences = getMainActivity().getSharedPreferences("sequence", 0);
        int i2 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dsteps", Integer.valueOf(i)), 0);
        this.legacySequenceV2.clear();
        if (i2 != 0) {
            int i3 = 0;
            while (i3 < i2) {
                boolean z = sharedPreferences.getBoolean(String.format(Locale.ROOT, "seq%02dstep%02denab", Integer.valueOf(i), Integer.valueOf(i3)), false);
                int i4 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dmode", Integer.valueOf(i), Integer.valueOf(i3)), 0);
                int i5 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dfan", Integer.valueOf(i), Integer.valueOf(i3)), 20);
                int i6 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dhour", Integer.valueOf(i), Integer.valueOf(i3)), 0);
                int i7 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dmin", Integer.valueOf(i), Integer.valueOf(i3)), 1);
                int i8 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dsec", Integer.valueOf(i), Integer.valueOf(i3)), 0);
                int i9 = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dheat", Integer.valueOf(i), Integer.valueOf(i3)), 80);
                this.legacySequenceV2.add(new SequenceStepV2(z, i4, i5, i6, i7, i8, i9, sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dfana", Integer.valueOf(i), Integer.valueOf(i3)), i5), sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dheata", Integer.valueOf(i), Integer.valueOf(i3)), i9), sharedPreferences.getBoolean(String.format(Locale.ROOT, "seq%02dstep%02dabs", Integer.valueOf(i), Integer.valueOf(i3)), false), sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dstoph", Integer.valueOf(i), Integer.valueOf(i3)), 0), sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02dstep%02dstopm", Integer.valueOf(i), Integer.valueOf(i3)), 0)));
                i3++;
                i2 = i2;
            }
        }
        for (int i10 = 0; i10 < 10; i10++) {
            this.seqRandom[i10] = sharedPreferences.getInt(String.format(Locale.ROOT, "seq%02drand%d", Integer.valueOf(i), Integer.valueOf(i10)), 0);
        }
        this.sequenceChanged = false;
        if (i != 0) {
            Toast.makeText(getMainActivity(), String.format(Locale.ROOT, "Sequence %d Loaded", Integer.valueOf(i)), 0).show();
        }
        if (this.legacySequenceV2.isEmpty()) {
            this.legacySequenceV2.add(0, new SequenceStepV2());
        }
    }

    private void sendAndRunSequence() {
        Object obj;
        int i;
        Calendar calendar = Calendar.getInstance();
        Object obj2 = null;
        ProgressDialog show = ProgressDialog.show(getMainActivity(), null, "Sending Sequence");
        this.sendProgressDialog = show;
        show.setIcon((Drawable) null);
        Random random = new Random();
        for (int i2 = 0; i2 < 8; i2++) {
            this.seqRandom[i2] = random.nextInt(256);
        }
        int i3 = 11;
        this.seqRandom[8] = calendar.get(11);
        this.seqRandom[9] = calendar.get(12);
        getMainActivity().setSeqRandom(this.seqRandom);
        saveSequence(0);
        final ArrayList arrayList = new ArrayList();
        Iterator<SequenceStepV2> it = this.legacySequenceV2.iterator();
        while (it.hasNext()) {
            arrayList.add(new SequenceStepV2(it.next()));
        }
        Calendar calendar2 = Calendar.getInstance();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            SequenceStepV2 sequenceStepV2 = (SequenceStepV2) arrayList.get(i4);
            if (sequenceStepV2.enabled) {
                if (sequenceStepV2.absolute) {
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.set(i3, sequenceStepV2.remain_hour);
                    calendar3.set(12, sequenceStepV2.remain_minute);
                    if (calendar2.getTimeInMillis() > calendar3.getTimeInMillis()) {
                        i = size;
                        calendar3.add(5, ((int) new Duration(calendar3.getTimeInMillis(), calendar2.getTimeInMillis()).getStandardDays()) + 1);
                    } else {
                        i = size;
                    }
                    int standardMinutes = (int) new Duration(calendar2.getTimeInMillis(), calendar3.getTimeInMillis()).getStandardMinutes();
                    if (standardMinutes > 720) {
                        new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Bad Sequence").setMessage(String.format(Locale.ROOT, "The calculated duration of step %d exceeds the 12h maximum at the current start time.  Sequence cannot be run at this time.", Integer.valueOf(i4 + 1))).setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
                        this.sendProgressDialog.dismiss();
                        return;
                    } else {
                        obj = null;
                        sequenceStepV2.remain_hour = standardMinutes / 60;
                        sequenceStepV2.remain_minute = standardMinutes % 60;
                    }
                } else {
                    obj = obj2;
                    i = size;
                }
                calendar2.add(11, sequenceStepV2.remain_hour);
                calendar2.add(12, sequenceStepV2.remain_minute);
            } else {
                obj = obj2;
                i = size;
            }
            i4++;
            obj2 = obj;
            size = i;
            i3 = 11;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment.1
            int sendMode = 0;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int i5 = this.sendMode;
                if (i5 == 0) {
                    BiorhythmFragment.this.getMainActivity().sendData("clearseq");
                    this.sendMode = 1;
                    return;
                }
                if (i5 <= arrayList.size()) {
                    if (((SequenceStepV2) arrayList.get(this.sendMode - 1)).enabled) {
                        BiorhythmFragment.this.currentStep = (SequenceStepV2) arrayList.get(this.sendMode - 1);
                        BiorhythmFragment.this.getMainActivity().setStepNum(this.sendMode - 1);
                        BiorhythmFragment.this.getMainActivity().setSendStep(BiorhythmFragment.this.currentStep);
                        BiorhythmFragment.this.getMainActivity().sendData("addstep");
                    }
                    this.sendMode++;
                    return;
                }
                if (this.sendMode == arrayList.size() + 1) {
                    BiorhythmFragment.this.getMainActivity().sendData("settag");
                    this.sendMode++;
                } else {
                    BiorhythmFragment.this.getMainActivity().sendData("runseq");
                    timer.cancel();
                    BiorhythmFragment.this.sendProgressDialog.dismiss();
                    BiorhythmFragment.this.getNavigator().showConnectedFragment();
                }
            }
        }, 200L, 200L);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    protected Integer getBindingVariable() {
        return 6;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ext.addOverscroll(getBinding().biorhythmItems);
        this.seqRandom = new int[10];
        try {
            this.myActivity = (MainActivity) getActivity();
            this.mAdapter = new BiorhythmAdapter(getContext(), Boolean.valueOf(this.tempModeManager.getValue().getUseCelsius()), new BiorhythmAdapterSequenceChangeListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda7
                @Override // com.bedjet.bedjet.p001ui.biorhythm.BiorhythmAdapterSequenceChangeListener
                public final void onChange() {
                    BiorhythmFragment.this.lambda$onViewCreated$0();
                }
            });
            this.useV2mode = this.storedDeviceManager.getValue().getCurrentDeviceType().equals(DeviceType.BEDJET2);
            getBinding().biorhythmItems.setLayoutManager(new LinearLayoutManager(getContext()));
            getBinding().biorhythmItems.setAdapter(this.mAdapter);
            if (getBinding().biorhythmItems.getItemAnimator() != null) {
                getBinding().biorhythmItems.getItemAnimator().setChangeDuration(0L);
            }
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(), 1);
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), C0624R.drawable.shape_divider_horizontal);
            if (drawable != null) {
                dividerItemDecoration.setDrawable(drawable);
            }
            getBinding().biorhythmItems.addItemDecoration(dividerItemDecoration);
            this.mAdapter.clearItems();
            this.writingName = false;
            if (this.useV2mode) {
                this.bioname1 = DEFAULT_V2BIONAME1;
                this.bioname2 = DEFAULT_V2BIONAME2;
                this.bioname3 = DEFAULT_V2BIONAME3;
                setBioNames();
                loadSequence(0);
                if (this.legacySequenceV2.isEmpty()) {
                    this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 5, 0, 80, 0, 0, false, 0, 0));
                    saveSequence(0);
                }
                this.mAdapter.setV2Mode(this.legacySequenceV2);
            } else {
                getBioNamesFromBedJet();
                this.mAdapter.setV3Mode();
            }
            Utils.initChart(this.myActivity.findViewById(C0624R.id.biorhythmSequence), (AppCompatTextView) this.myActivity.findViewById(C0624R.id.bioEndTime), this.mAdapter.getStepList());
            updateGraph();
        } catch (ClassCastException unused) {
            throw new ClassCastException("Activity must be castable to MainActivity!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        this.sequenceChanged = true;
    }

    public void requestBioNames() {
        this.myActivity.requestWithRetry(4);
    }

    private void getBioNamesFromBedJet() {
        showSpinner();
        requestBioNames();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void biodataAvailable(final byte[] bArr) {
        LoggerKt.logTag(TAG, "biodata available hook called");
        getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                BiorhythmFragment.this.lambda$biodataAvailable$1(bArr);
            }
        });
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void biodataWritten() {
        if (this.writingBio) {
            writeNextBioDataBlock();
        }
        if (this.writingName) {
            requestBioNames();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processBiodata, reason: merged with bridge method [inline-methods] */
    public void lambda$biodataAvailable$1(byte[] bArr) {
        if (bArr.length < 3) {
            Timber.tag(TAG).mo1173e("Incoming biodata packet is too short!", new Object[0]);
            return;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 2, bArr.length);
        if (bArr[0] == this.myActivity.mLastRequest && bArr[1] == this.myActivity.mLastTag) {
            LoggerKt.logTag(TAG, "Got response packet from BedJet = request ID = " + ((int) this.myActivity.mLastRequest));
            byte b = bArr[0];
            switch (b) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return;
                case 4:
                case 5:
                case 6:
                    if (copyOfRange[0] == 1) {
                        this.bioname1 = null;
                    } else {
                        this.bioname1 = new String(Arrays.copyOfRange(copyOfRange, 0, 15)).trim();
                    }
                    if (copyOfRange[16] == 1) {
                        this.bioname2 = null;
                    } else {
                        this.bioname2 = new String(Arrays.copyOfRange(copyOfRange, 16, 31)).trim();
                    }
                    if (copyOfRange[32] == 1) {
                        this.bioname3 = null;
                    } else {
                        this.bioname3 = new String(Arrays.copyOfRange(copyOfRange, 32, 47)).trim();
                    }
                    LoggerKt.logTag(TAG, "got bionames: " + this.bioname1 + " " + this.bioname2 + " " + this.bioname3);
                    getMainActivity().cancelReadRetry();
                    processBionames(this.writingName);
                    return;
                default:
                    if (b < 7 || b > 19) {
                        return;
                    }
                    int i = b - 7;
                    int i2 = i & 3;
                    LoggerKt.logTag(TAG, "Got sequence fragment - seq " + (i / 4) + " frag " + i2);
                    byte b2 = copyOfRange[0];
                    int i3 = (i2 + 1) * 8;
                    int i4 = b2 < i3 ? b2 % 8 : 8;
                    LoggerKt.logTag(TAG, "Overall length of sequence is " + ((int) b2));
                    if (i2 == 0) {
                        this.mAdapter.clearItems();
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        BiorhythmAdapter biorhythmAdapter = this.mAdapter;
                        int i6 = i5 * 5;
                        byte b3 = copyOfRange[i6 + 1];
                        byte b4 = copyOfRange[i6 + 2];
                        byte b5 = copyOfRange[i6 + 4];
                        biorhythmAdapter.addItem(new SequenceStep(b3, b4, b5 & Byte.MAX_VALUE, copyOfRange[i6 + 5], copyOfRange[i6 + 3], (b5 & 128) != 0));
                    }
                    if (b2 > i3) {
                        MainActivity mainActivity = this.myActivity;
                        int i7 = this.mCurrentFragment + 1;
                        this.mCurrentFragment = i7;
                        mainActivity.requestWithRetry(i7);
                        return;
                    }
                    this.myActivity.cancelReadRetry();
                    closeBioMenu();
                    updateGraph();
                    return;
            }
        }
    }

    private void setPresetSequence(boolean z) {
        char c;
        char c2;
        this.rg_sex.getCheckedRadioButtonId();
        int i = C0624R.id.btn_man;
        if (this.rg_age.getCheckedRadioButtonId() == C0624R.id.btn_age1) {
            c = 0;
        } else {
            c = this.rg_age.getCheckedRadioButtonId() == C0624R.id.btn_age2 ? (char) 1 : (char) 2;
        }
        if (this.rg_heat.getCheckedRadioButtonId() == C0624R.id.btn_cold) {
            c2 = 0;
        } else {
            c2 = this.rg_heat.getCheckedRadioButtonId() == C0624R.id.btn_neutral ? (char) 1 : (char) 2;
        }
        boolean z2 = this.rg_sheet.getCheckedRadioButtonId() == C0624R.id.btn_sheetyes;
        this.legacySequenceV2.clear();
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 == 2) {
                    if (c == 0) {
                        this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 3, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 1, 6, 0, 3, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 3, 10, 0, 20, 0, 40, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 3, 7, 6, 30, 0, 40, 0, 0, false, 0, 0));
                    } else {
                        this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 3, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 1, 6, 0, 3, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 3, 9, 0, 20, 0, 40, 0, 0, false, 0, 0));
                        this.legacySequenceV2.add(new SequenceStepV2(true, 3, 6, 6, 0, 0, 40, 0, 0, false, 0, 0));
                    }
                }
            } else if (c == 0) {
                this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 5, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 1, 10, 0, 4, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 3, 8, 0, 20, 0, 40, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 3, 5, 6, 30, 0, 40, 0, 0, false, 0, 0));
            } else {
                this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 5, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 1, 10, 0, 3, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 3, 6, 0, 20, 0, 40, 0, 0, false, 0, 0));
                this.legacySequenceV2.add(new SequenceStepV2(true, 3, 4, 6, 0, 0, 40, 0, 0, false, 0, 0));
            }
        } else if (c == 0) {
            this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 5, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 1, 10, 0, 5, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 3, 6, 0, 10, 0, 40, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 2, 6, 6, 30, 0, 47, 0, 0, false, 0, 0));
        } else {
            this.legacySequenceV2.add(new SequenceStepV2(true, 1, 20, 0, 5, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 1, 10, 0, 3, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 0, 10, 0, 10, 0, 80, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 3, 6, 0, 10, 0, 40, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 2, 6, 6, 0, 0, 49, 0, 0, false, 0, 0));
        }
        if (!z) {
            this.legacySequenceV2.add(new SequenceStepV2(true, 2, 7, 0, 10, 0, 70, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 2, 8, 0, 10, 0, 76, 0, 0, false, 0, 0));
            this.legacySequenceV2.add(new SequenceStepV2(true, 2, 9, 0, 10, 0, 80, 0, 0, false, 0, 0));
        }
        if (z2) {
            for (int i2 = 0; i2 < this.legacySequenceV2.size(); i2++) {
                int i3 = this.legacySequenceV2.get(i2).currentFan + 2;
                if (i3 > 20) {
                    i3 = 20;
                }
                this.legacySequenceV2.get(i2).currentFan = i3;
            }
        }
        new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Please Note").setMessage("Biorhythm sleep cycles are ONLY suggested starting points to assist you in your BedJet journey.  Every sleeper is different and sleep cycle suggestions will never be perfect for all sleepers.  Please do experiment over a few nights to adjust air settings, temperatures and times to best suit your individual needs.").setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
        this.sequenceChanged = false;
        if (!this.useV2mode) {
            migrateSequenceV2(this.legacySequenceV2);
            updateGraph();
        } else {
            saveSequence(0);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private void migrateSequenceV2(List<SequenceStepV2> list) {
        int i;
        this.mAdapter.clearItems();
        for (SequenceStepV2 sequenceStepV2 : list) {
            SequenceStep sequenceStep = new SequenceStep();
            int i2 = sequenceStepV2.operatingMode;
            if (i2 != 0) {
                i = 2;
                if (i2 != 1) {
                    i = i2 != 2 ? i2 != 3 ? 0 : 4 : 1;
                }
            } else {
                i = 6;
            }
            sequenceStep.setMode(i);
            sequenceStep.setFanStep(sequenceStepV2.currentFan - 1);
            sequenceStep.setTemperature(sequenceStepV2.heat_setpoint);
            sequenceStep.setHours(sequenceStepV2.remain_hour);
            sequenceStep.setMinutes(sequenceStepV2.remain_minute);
            sequenceStep.setClocktime(false);
            this.mAdapter.addItem(sequenceStep);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().showActionBar(false);
    }

    private void setBioName(int i, String str) {
        if (str == null) {
            str = UNUSED_MEMORY;
        }
        ((TextView) this.myActivity.findViewById(i)).setText(str);
    }

    private void setBioNames() {
        setBioName(C0624R.id.biorhythmMem1, this.bioname1);
        setBioName(C0624R.id.biorhythmMem2, this.bioname2);
        setBioName(C0624R.id.biorhythmMem3, this.bioname3);
    }

    private void processBionames(boolean z) {
        setBioNames();
        if (z) {
            return;
        }
        showBioSelectMenu(false, false);
    }

    private void updateGraph() {
        if (this.useV2mode) {
            Utils.setGraphV2(this.legacySequenceV2);
        } else {
            Utils.setGraph(this.mAdapter.getStepList());
        }
    }

    private void showSpinner() {
        closeBioMenu();
        Dialog dialog = new Dialog(getMainActivity(), C0624R.style.AppDialog);
        this.bioMenuDialog = dialog;
        dialog.setContentView(C0624R.layout.spinner_layout);
        this.bioMenuDialog.setCanceledOnTouchOutside(false);
        this.bioMenuDialog.show();
    }

    private void closeBioMenu() {
        Dialog dialog = this.bioMenuDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.bioMenuDialog = null;
        }
    }

    private void showBioSuggest() {
        final Dialog dialog = new Dialog(getMainActivity(), C0624R.style.AppDialog);
        dialog.setContentView(C0624R.layout.layout_biosuggest);
        dialog.setCanceledOnTouchOutside(false);
        this.rg_sex = (RadioGroup) dialog.findViewById(C0624R.id.rg_sex);
        this.rg_age = (RadioGroup) dialog.findViewById(C0624R.id.rg_age);
        this.rg_heat = (RadioGroup) dialog.findViewById(C0624R.id.rg_heat);
        this.rg_sheet = (RadioGroup) dialog.findViewById(C0624R.id.rg_sheet);
        this.btn_sleeponly = (Button) dialog.findViewById(C0624R.id.btn_sleep);
        this.btn_sleepwake = (Button) dialog.findViewById(C0624R.id.btn_sleepwake);
        this.rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda19
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BiorhythmFragment.this.lambda$showBioSuggest$2(radioGroup, i);
            }
        });
        this.rg_age.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda20
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BiorhythmFragment.this.lambda$showBioSuggest$3(radioGroup, i);
            }
        });
        this.rg_heat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda21
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BiorhythmFragment.this.lambda$showBioSuggest$4(radioGroup, i);
            }
        });
        this.rg_sheet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda22
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BiorhythmFragment.this.lambda$showBioSuggest$5(radioGroup, i);
            }
        });
        dialog.findViewById(C0624R.id.btn_exit).setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        this.btn_sleeponly.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSuggest$7(dialog, view);
            }
        });
        this.btn_sleepwake.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSuggest$8(dialog, view);
            }
        });
        this.rg_sex.clearCheck();
        this.rg_age.clearCheck();
        this.rg_heat.clearCheck();
        this.rg_sheet.clearCheck();
        this.buttons_enabled = false;
        this.btn_sleeponly.setTextColor(-7829368);
        this.btn_sleepwake.setTextColor(-7829368);
        this.btn_sleeponly.setEnabled(false);
        this.btn_sleepwake.setEnabled(false);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$2(RadioGroup radioGroup, int i) {
        testEnableButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$3(RadioGroup radioGroup, int i) {
        testEnableButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$4(RadioGroup radioGroup, int i) {
        testEnableButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$5(RadioGroup radioGroup, int i) {
        testEnableButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$7(Dialog dialog, View view) {
        if (this.buttons_enabled) {
            setPresetSequence(true);
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSuggest$8(Dialog dialog, View view) {
        if (this.buttons_enabled) {
            setPresetSequence(false);
            dialog.dismiss();
        }
    }

    private void testEnableButtons() {
        if (this.buttons_enabled || this.rg_sex.getCheckedRadioButtonId() == -1 || this.rg_age.getCheckedRadioButtonId() == -1 || this.rg_heat.getCheckedRadioButtonId() == -1 || this.rg_sheet.getCheckedRadioButtonId() == -1) {
            return;
        }
        this.btn_sleeponly.setTextColor(-1);
        this.btn_sleepwake.setTextColor(-1);
        this.btn_sleeponly.setEnabled(true);
        this.btn_sleepwake.setEnabled(true);
        this.buttons_enabled = true;
    }

    private void handleBioButton(boolean z, boolean z2, int i) {
        if (!z) {
            showSpinner();
            this.currentSequenceNum = i + 1;
            loadBioSequence(i);
            this.sequenceChanged = false;
            return;
        }
        if (z2) {
            saveSequence(i + 1);
            closeBioMenu();
        } else {
            loadSequence(i + 1);
            this.mAdapter.notifyDataSetChanged();
            closeBioMenu();
            updateGraph();
        }
    }

    private boolean setButtonLabel(Button button, String str) {
        if (str != null) {
            button.setText(str);
            button.setVisibility(0);
            return true;
        }
        button.setVisibility(8);
        return false;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [boolean, int] */
    private void showBioSelectMenu(final boolean z, final boolean z2) {
        if (!z) {
            closeBioMenu();
        }
        Dialog dialog = new Dialog(this.myActivity, C0624R.style.AppDialog);
        this.bioMenuDialog = dialog;
        final boolean z3 = false;
        dialog.setCanceledOnTouchOutside(false);
        this.bioMenuDialog.setContentView(C0624R.layout.bioselect_dialog);
        Button button = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_newbio);
        Button button2 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_delbio);
        Button button3 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio1);
        Button button4 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio2);
        Button button5 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio3);
        TextView textView = (TextView) this.bioMenuDialog.findViewById(C0624R.id.existing_header);
        TextView textView2 = (TextView) this.bioMenuDialog.findViewById(C0624R.id.name_title);
        if (z) {
            button3.setText(DEFAULT_V2BIONAME1);
            button3.setVisibility(0);
            button4.setText(DEFAULT_V2BIONAME2);
            button4.setVisibility(0);
            button5.setText(DEFAULT_V2BIONAME3);
            button5.setVisibility(0);
            button.setVisibility(8);
            button2.setVisibility(8);
            textView.setVisibility(8);
            textView2.setText(z2 ? "Save Biorhythm" : "Load Biorhythm");
        } else {
            textView2.setText("Biorhythm Menu");
            ?? buttonLabel = setButtonLabel(button3, this.bioname1);
            int i = buttonLabel;
            if (setButtonLabel(button4, this.bioname2)) {
                i = buttonLabel + 1;
            }
            int i2 = i;
            if (setButtonLabel(button5, this.bioname3)) {
                i2 = i + 1;
            }
            boolean z4 = i2 != 0;
            r9 = i2 >= 3;
            textView.setVisibility(z4 ? 0 : 8);
            this.bioMenuDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    BiorhythmFragment.this.lambda$showBioSelectMenu$9(dialogInterface);
                }
            });
            z3 = r9;
            r9 = z4;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSelectMenu$10(z, z3, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSelectMenu$11(r2, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSelectMenu$12(z, z2, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSelectMenu$13(z, z2, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioSelectMenu$14(z, z2, view);
            }
        });
        this.bioMenuDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$9(DialogInterface dialogInterface) {
        this.bioMenuDialog.cancel();
        getMainActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$10(boolean z, boolean z2, View view) {
        if (z) {
            return;
        }
        if (z2) {
            new AlertDialog.Builder(this.myActivity).setTitle("All Sequences Full").setMessage("All 3 sequences are already in use - please delete one or more of the existing sequences before creating a new one.").setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
            return;
        }
        this.mAdapter.clearItems();
        this.mAdapter.addItem(new SequenceStep());
        this.currentSequenceNum = 0;
        this.sequenceChanged = false;
        closeBioMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$11(boolean z, View view) {
        if (!z) {
            new AlertDialog.Builder(this.myActivity).setTitle("No Sequences").setMessage("There are no saved sequences to delete.").setNeutralButton("OK", (DialogInterface.OnClickListener) null).show();
        } else {
            this.bioMenuDialog.dismiss();
            showBioDeleteMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$12(boolean z, boolean z2, View view) {
        handleBioButton(z, z2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$13(boolean z, boolean z2, View view) {
        handleBioButton(z, z2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioSelectMenu$14(boolean z, boolean z2, View view) {
        handleBioButton(z, z2, 2);
    }

    void deleteSequence(int i) {
        showSpinner();
        getMainActivity().sendBedJetButton(i + 131);
        getMainActivity().getmHandler().postDelayed(new Runnable() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                BiorhythmFragment.this.requestBioNames();
            }
        }, 100L);
    }

    private void showBioDeleteMenu() {
        Dialog dialog = new Dialog(this.myActivity, C0624R.style.AppDialog);
        this.bioMenuDialog = dialog;
        dialog.setCanceledOnTouchOutside(false);
        this.bioMenuDialog.setContentView(C0624R.layout.layout_biodelete);
        Button button = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio1);
        Button button2 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio2);
        Button button3 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_bio3);
        Button button4 = (Button) this.bioMenuDialog.findViewById(C0624R.id.btn_cancel);
        setButtonLabel(button, this.bioname1);
        setButtonLabel(button2, this.bioname2);
        setButtonLabel(button3, this.bioname3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioDeleteMenu$15(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioDeleteMenu$16(view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioDeleteMenu$17(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiorhythmFragment.this.lambda$showBioDeleteMenu$18(view);
            }
        });
        this.bioMenuDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                BiorhythmFragment.this.lambda$showBioDeleteMenu$19(dialogInterface);
            }
        });
        this.bioMenuDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioDeleteMenu$15(View view) {
        deleteSequence(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioDeleteMenu$16(View view) {
        deleteSequence(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioDeleteMenu$17(View view) {
        deleteSequence(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioDeleteMenu$18(View view) {
        this.bioMenuDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBioDeleteMenu$19(DialogInterface dialogInterface) {
        showBioSelectMenu(false, false);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void writeNextBioDataBlock() {
        int itemCount = (this.mAdapter.getItemCount() - 1) / 8;
        int i = this.mCurrentFragment;
        if (i - this.mStartFragment < itemCount) {
            int i2 = i + 1;
            this.mCurrentFragment = i2;
            writeBioFragment(i2);
        } else {
            this.writingBio = false;
            getMainActivity().runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    BiorhythmFragment.this.lambda$writeNextBioDataBlock$20();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeNextBioDataBlock$20() {
        String str;
        RenameType renameType;
        int i = this.currentSequenceNum;
        if (i == 1) {
            str = this.bioname1;
            renameType = RenameType.BIORHYTHM1;
        } else if (i == 2) {
            str = this.bioname2;
            renameType = RenameType.BIORHYTHM2;
        } else if (i != 3) {
            str = "ERROR!";
            renameType = null;
        } else {
            str = this.bioname3;
            renameType = RenameType.BIORHYTHM3;
        }
        this.writingName = true;
        if (renameType != null) {
            getMainActivity().showRenameMenu(renameType, str);
        }
        if (this.autoRun) {
            this.myActivity.sendBedJetButton(this.currentSequenceNum + 127);
        }
    }

    private void loadBioSequence(int i) {
        int i2 = (i * 4) + 7;
        this.mStartFragment = i2;
        this.mCurrentFragment = i2;
        this.myActivity.requestWithRetry(i2);
    }

    private void saveBioSequence(int i) {
        int i2 = (i * 4) + 7;
        this.mStartFragment = i2;
        this.mCurrentFragment = i2;
        this.writingBio = true;
        writeBioFragment(i2);
    }

    private void writeBioFragment(int i) {
        byte[] bArr = new byte[41];
        int itemCount = this.mAdapter.getItemCount();
        int i2 = ((i - 7) & 3) * 8;
        int i3 = 0;
        bArr[0] = (byte) itemCount;
        while (true) {
            int i4 = i2 + i3;
            if (i4 >= itemCount || i3 >= 8) {
                break;
            }
            SequenceStep itemAtIndex = this.mAdapter.getItemAtIndex(i4);
            int i5 = i3 * 5;
            bArr[i5 + 1] = (byte) itemAtIndex.getMode();
            bArr[i5 + 2] = (byte) itemAtIndex.getFanStep();
            bArr[i5 + 3] = (byte) itemAtIndex.getTemperature();
            int i6 = i5 + 4;
            bArr[i6] = (byte) itemAtIndex.getHours();
            bArr[i5 + 5] = (byte) itemAtIndex.getMinutes();
            if (itemAtIndex.isClocktime()) {
                bArr[i6] = (byte) (bArr[i6] | 128);
            }
            i3++;
        }
        this.myActivity.sendBioCommand(i, bArr);
    }

    private int getFreeBioSlot() {
        if (this.bioname1 == null) {
            return 1;
        }
        if (this.bioname2 == null) {
            return 2;
        }
        return this.bioname3 == null ? 3 : 0;
    }

    private void showLoadConfirmDialog() {
        new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Confirm Revert").setMessage("Are you sure you want to revert to the original version of this sequence?").setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BiorhythmFragment.this.lambda$showLoadConfirmDialog$21(dialogInterface, i);
            }
        }).setNegativeButton("CANCEL", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadConfirmDialog$21(DialogInterface dialogInterface, int i) {
        loadBioSequence(this.currentSequenceNum - 1);
        this.sequenceChanged = false;
    }

    public void onSave() {
        if (this.useV2mode) {
            onSave_BedJetV2();
        } else {
            onSave_BedJetV3(false);
        }
    }

    private void onSave_BedJetV2() {
        showBioSelectMenu(true, true);
    }

    private void onSave_BedJetV3(boolean z) {
        if (this.currentSequenceNum == 0) {
            int freeBioSlot = getFreeBioSlot();
            this.currentSequenceNum = freeBioSlot;
            if (freeBioSlot == 1) {
                this.bioname1 = DEFAULT_BIONAME1;
            } else if (freeBioSlot == 2) {
                this.bioname2 = DEFAULT_BIONAME2;
            } else if (freeBioSlot == 3) {
                this.bioname3 = DEFAULT_BIONAME3;
            }
        }
        int i = this.currentSequenceNum;
        if (i != 0) {
            saveBioSequence(i - 1);
            this.autoRun = z;
            this.sequenceChanged = false;
        }
    }

    public void onLoad() {
        if (this.useV2mode) {
            onLoad_BedJetV2();
        } else {
            onLoad_BedJetV3();
        }
    }

    private void onLoad_BedJetV2() {
        showBioSelectMenu(true, false);
    }

    private void onLoad_BedJetV3() {
        int i = this.currentSequenceNum;
        if (i == 0) {
            new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Confirm Clear").setMessage("Since this sequence has never been saved, reloading will result in the deletion of all current steps.  Do you want to do this?").setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    BiorhythmFragment.this.lambda$onLoad_BedJetV3$22(dialogInterface, i2);
                }
            }).setNegativeButton("CANCEL", (DialogInterface.OnClickListener) null).show();
        } else if (this.sequenceChanged) {
            showLoadConfirmDialog();
        } else {
            loadBioSequence(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoad_BedJetV3$22(DialogInterface dialogInterface, int i) {
        this.mAdapter.clearItems();
        this.sequenceChanged = false;
    }

    public void onStartPressed() {
        if (this.useV2mode) {
            sendAndRunSequence();
            return;
        }
        int i = this.currentSequenceNum;
        if (i != 0) {
            runBio(i - 1);
        } else {
            onSave_BedJetV3(true);
        }
    }

    public void onSuggest() {
        showBioSuggest();
    }

    private void runBio(int i) {
        if (this.useV2mode) {
            loadSequence(i + 1);
            if (this.legacySequenceV2.size() == 0) {
                new AlertDialog.Builder(getMainActivity(), C0624R.style.AppDialog).setTitle("Memory Empty").setMessage("The selected memory is empty.  No Biorhythm sequence to run").setNeutralButton("OK", new DialogInterface.OnClickListener() { // from class: com.bedjet.bedjet.ui.biorhythm.BiorhythmFragment$$ExternalSyntheticLambda16
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                    }
                }).show();
                return;
            } else {
                sendAndRunSequence();
                return;
            }
        }
        this.myActivity.sendBedJetButton(i + 128);
        getNavigator().showConnectedFragment();
    }

    public void onRunBio1() {
        runBio(0);
    }

    public void onRunBio2() {
        runBio(1);
    }

    public void onRunBio3() {
        runBio(2);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        getNavigator().showConnectedFragment();
        return false;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void gattDisconnected() {
        closeBioMenu();
        super.gattDisconnected();
    }
}
