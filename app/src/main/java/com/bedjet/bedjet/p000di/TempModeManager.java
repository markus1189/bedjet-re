package com.bedjet.bedjet.p000di;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.utils.PreferenceStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TempModeManager.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m943d2 = {"Lcom/bedjet/bedjet/di/TempModeManager;", "", "preferenceStorage", "Lcom/bedjet/bedjet/utils/PreferenceStorage;", "<init>", "(Lcom/bedjet/bedjet/utils/PreferenceStorage;)V", "value", "", "useCelsius", "getUseCelsius", "()Z", "setUseCelsius", "(Z)V", "loadUseCelsius", "", "saveUseCelsius", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TempModeManager {
    private static final String PREFS_TEMP = "usedegc";
    private final PreferenceStorage preferenceStorage;
    private boolean useCelsius;

    public TempModeManager(PreferenceStorage preferenceStorage) {
        Intrinsics.checkNotNullParameter(preferenceStorage, "preferenceStorage");
        this.preferenceStorage = preferenceStorage;
    }

    public final boolean getUseCelsius() {
        return this.useCelsius;
    }

    public final void setUseCelsius(boolean z) {
        this.useCelsius = z;
        saveUseCelsius();
    }

    public final void loadUseCelsius() {
        setUseCelsius(this.preferenceStorage.getBoolean(PREFS_TEMP, false));
    }

    private final void saveUseCelsius() {
        this.preferenceStorage.saveBoolean(PREFS_TEMP, Boolean.valueOf(this.useCelsius));
    }
}
