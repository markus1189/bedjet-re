package com.bedjet.bedjet.p001ui.main;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ResumeFlag.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/ResumeFlag;", "", "<init>", "(Ljava/lang/String;I)V", "RESUME_DEFAULT", "RESUME_MENU", "RESUME_V2", "RESUME_WIFI", "RESUME_EXIT", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ResumeFlag {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResumeFlag[] $VALUES;
    public static final ResumeFlag RESUME_DEFAULT = new ResumeFlag("RESUME_DEFAULT", 0);
    public static final ResumeFlag RESUME_MENU = new ResumeFlag("RESUME_MENU", 1);
    public static final ResumeFlag RESUME_V2 = new ResumeFlag("RESUME_V2", 2);
    public static final ResumeFlag RESUME_WIFI = new ResumeFlag("RESUME_WIFI", 3);
    public static final ResumeFlag RESUME_EXIT = new ResumeFlag("RESUME_EXIT", 4);

    private static final /* synthetic */ ResumeFlag[] $values() {
        return new ResumeFlag[]{RESUME_DEFAULT, RESUME_MENU, RESUME_V2, RESUME_WIFI, RESUME_EXIT};
    }

    public static EnumEntries<ResumeFlag> getEntries() {
        return $ENTRIES;
    }

    private ResumeFlag(String str, int i) {
    }

    static {
        ResumeFlag[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ResumeFlag valueOf(String str) {
        return (ResumeFlag) Enum.valueOf(ResumeFlag.class, str);
    }

    public static ResumeFlag[] values() {
        return (ResumeFlag[]) $VALUES.clone();
    }
}
