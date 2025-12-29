package com.bedjet.bedjet.p001ui.main;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FlashStates.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/FlashStates;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ERASING", "FLASHING", "OK", "FAILED", "TIMEOUT", "ENTERBL", "READSKU", "REBOOT", "READBL", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FlashStates {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FlashStates[] $VALUES;
    public static final FlashStates IDLE = new FlashStates("IDLE", 0);
    public static final FlashStates ERASING = new FlashStates("ERASING", 1);
    public static final FlashStates FLASHING = new FlashStates("FLASHING", 2);

    /* renamed from: OK */
    public static final FlashStates f122OK = new FlashStates("OK", 3);
    public static final FlashStates FAILED = new FlashStates("FAILED", 4);
    public static final FlashStates TIMEOUT = new FlashStates("TIMEOUT", 5);
    public static final FlashStates ENTERBL = new FlashStates("ENTERBL", 6);
    public static final FlashStates READSKU = new FlashStates("READSKU", 7);
    public static final FlashStates REBOOT = new FlashStates("REBOOT", 8);
    public static final FlashStates READBL = new FlashStates("READBL", 9);

    private static final /* synthetic */ FlashStates[] $values() {
        return new FlashStates[]{IDLE, ERASING, FLASHING, f122OK, FAILED, TIMEOUT, ENTERBL, READSKU, REBOOT, READBL};
    }

    public static EnumEntries<FlashStates> getEntries() {
        return $ENTRIES;
    }

    private FlashStates(String str, int i) {
    }

    static {
        FlashStates[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FlashStates valueOf(String str) {
        return (FlashStates) Enum.valueOf(FlashStates.class, str);
    }

    public static FlashStates[] values() {
        return (FlashStates[]) $VALUES.clone();
    }
}
