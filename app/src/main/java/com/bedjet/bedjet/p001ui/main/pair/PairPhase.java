package com.bedjet.bedjet.p001ui.main.pair;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PairPhase.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/pair/PairPhase;", "", "<init>", "(Ljava/lang/String;I)V", "PAIR_STARTED", "PAIR_FLIP_SWITCH", "PAIR_FLIP_BACK", "PAIR_ZONE_INFO", "PAIR_INFO_READ", "PAIR_SET_NAME", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PairPhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PairPhase[] $VALUES;
    public static final PairPhase PAIR_STARTED = new PairPhase("PAIR_STARTED", 0);
    public static final PairPhase PAIR_FLIP_SWITCH = new PairPhase("PAIR_FLIP_SWITCH", 1);
    public static final PairPhase PAIR_FLIP_BACK = new PairPhase("PAIR_FLIP_BACK", 2);
    public static final PairPhase PAIR_ZONE_INFO = new PairPhase("PAIR_ZONE_INFO", 3);
    public static final PairPhase PAIR_INFO_READ = new PairPhase("PAIR_INFO_READ", 4);
    public static final PairPhase PAIR_SET_NAME = new PairPhase("PAIR_SET_NAME", 5);

    private static final /* synthetic */ PairPhase[] $values() {
        return new PairPhase[]{PAIR_STARTED, PAIR_FLIP_SWITCH, PAIR_FLIP_BACK, PAIR_ZONE_INFO, PAIR_INFO_READ, PAIR_SET_NAME};
    }

    public static EnumEntries<PairPhase> getEntries() {
        return $ENTRIES;
    }

    private PairPhase(String str, int i) {
    }

    static {
        PairPhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PairPhase valueOf(String str) {
        return (PairPhase) Enum.valueOf(PairPhase.class, str);
    }

    public static PairPhase[] values() {
        return (PairPhase[]) $VALUES.clone();
    }
}
