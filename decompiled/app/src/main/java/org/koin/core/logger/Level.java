package org.koin.core.logger;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Logger.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m943d2 = {"Lorg/koin/core/logger/Level;", "", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARNING", "ERROR", "NONE", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Level {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Level[] $VALUES;
    public static final Level DEBUG = new Level("DEBUG", 0);
    public static final Level INFO = new Level("INFO", 1);
    public static final Level WARNING = new Level("WARNING", 2);
    public static final Level ERROR = new Level("ERROR", 3);
    public static final Level NONE = new Level("NONE", 4);

    private static final /* synthetic */ Level[] $values() {
        return new Level[]{DEBUG, INFO, WARNING, ERROR, NONE};
    }

    public static EnumEntries<Level> getEntries() {
        return $ENTRIES;
    }

    public static Level valueOf(String str) {
        return (Level) Enum.valueOf(Level.class, str);
    }

    public static Level[] values() {
        return (Level[]) $VALUES.clone();
    }

    private Level(String str, int i) {
    }

    static {
        Level[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
