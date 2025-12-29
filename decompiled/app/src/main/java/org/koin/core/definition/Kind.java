package org.koin.core.definition;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BeanDefinition.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m943d2 = {"Lorg/koin/core/definition/Kind;", "", "(Ljava/lang/String;I)V", "Singleton", "Factory", "Scoped", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class Kind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Kind[] $VALUES;
    public static final Kind Singleton = new Kind("Singleton", 0);
    public static final Kind Factory = new Kind("Factory", 1);
    public static final Kind Scoped = new Kind("Scoped", 2);

    private static final /* synthetic */ Kind[] $values() {
        return new Kind[]{Singleton, Factory, Scoped};
    }

    public static EnumEntries<Kind> getEntries() {
        return $ENTRIES;
    }

    public static Kind valueOf(String str) {
        return (Kind) Enum.valueOf(Kind.class, str);
    }

    public static Kind[] values() {
        return (Kind[]) $VALUES.clone();
    }

    private Kind(String str, int i) {
    }

    static {
        Kind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
