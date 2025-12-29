package com.bedjet.bedjet.p001ui.main;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RenameType.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/RenameType;", "", "param", "", "title", "<init>", "(Ljava/lang/String;III)V", "getParam", "()I", "getTitle", "V2", "V3", "MEMORY1", "MEMORY2", "MEMORY3", "BIORHYTHM1", "BIORHYTHM2", "BIORHYTHM3", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RenameType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RenameType[] $VALUES;
    private final int param;
    private final int title;

    /* renamed from: V2 */
    public static final RenameType f123V2 = new RenameType("V2", 0, 96, C0624R.string.rename_dialog_title_rename);

    /* renamed from: V3 */
    public static final RenameType f124V3 = new RenameType("V3", 1, 0, C0624R.string.rename_dialog_title_rename);
    public static final RenameType MEMORY1 = new RenameType("MEMORY1", 2, 1, C0624R.string.rename_dialog_title_memory_1);
    public static final RenameType MEMORY2 = new RenameType("MEMORY2", 3, 2, C0624R.string.rename_dialog_title_memory_2);
    public static final RenameType MEMORY3 = new RenameType("MEMORY3", 4, 3, C0624R.string.rename_dialog_title_memory_3);
    public static final RenameType BIORHYTHM1 = new RenameType("BIORHYTHM1", 5, 4, C0624R.string.rename_dialog_title_biorhythm);
    public static final RenameType BIORHYTHM2 = new RenameType("BIORHYTHM2", 6, 5, C0624R.string.rename_dialog_title_biorhythm);
    public static final RenameType BIORHYTHM3 = new RenameType("BIORHYTHM3", 7, 6, C0624R.string.rename_dialog_title_biorhythm);

    private static final /* synthetic */ RenameType[] $values() {
        return new RenameType[]{f123V2, f124V3, MEMORY1, MEMORY2, MEMORY3, BIORHYTHM1, BIORHYTHM2, BIORHYTHM3};
    }

    public static EnumEntries<RenameType> getEntries() {
        return $ENTRIES;
    }

    private RenameType(String str, int i, int i2, int i3) {
        this.param = i2;
        this.title = i3;
    }

    public final int getParam() {
        return this.param;
    }

    public final int getTitle() {
        return this.title;
    }

    static {
        RenameType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RenameType valueOf(String str) {
        return (RenameType) Enum.valueOf(RenameType.class, str);
    }

    public static RenameType[] values() {
        return (RenameType[]) $VALUES.clone();
    }
}
