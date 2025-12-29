package com.bedjet.bedjet.data.local.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectionState.kt */
@Metadata(m942d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m943d2 = {"Lcom/bedjet/bedjet/data/local/model/ConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "DISCONNECTED", "GATT_CONNECT", "ENUMERATING", "NAME_READ", "MEMORY_READ", "CONNECTED", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ConnectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectionState[] $VALUES;
    public static final ConnectionState DISCONNECTED = new ConnectionState("DISCONNECTED", 0);
    public static final ConnectionState GATT_CONNECT = new ConnectionState("GATT_CONNECT", 1);
    public static final ConnectionState ENUMERATING = new ConnectionState("ENUMERATING", 2);
    public static final ConnectionState NAME_READ = new ConnectionState("NAME_READ", 3);
    public static final ConnectionState MEMORY_READ = new ConnectionState("MEMORY_READ", 4);
    public static final ConnectionState CONNECTED = new ConnectionState("CONNECTED", 5);

    private static final /* synthetic */ ConnectionState[] $values() {
        return new ConnectionState[]{DISCONNECTED, GATT_CONNECT, ENUMERATING, NAME_READ, MEMORY_READ, CONNECTED};
    }

    public static EnumEntries<ConnectionState> getEntries() {
        return $ENTRIES;
    }

    private ConnectionState(String str, int i) {
    }

    static {
        ConnectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ConnectionState valueOf(String str) {
        return (ConnectionState) Enum.valueOf(ConnectionState.class, str);
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }
}
