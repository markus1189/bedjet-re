package com.bedjet.bedjet.p001ui.main.p002v2;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MessageType.kt */
@Metadata(m942d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0016"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/MessageType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "MSG_CONNECT_FAIL", "MSG_READ_EXCEPTION", "MSG_WRITE_EXCEPTION", "MSG_CONNECT_SUCCESS", "MSG_READ_DATA", "MSG_CONNECT_CLIENT", "MSG_BOND_FAIL", "MSG_BOND_OK", "MSG_RE_FLASH", "MSG_UPDATE_ERR", "MSG_RESTART_CLIENT", "toString", "", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MessageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int id;
    public static final MessageType MSG_CONNECT_FAIL = new MessageType("MSG_CONNECT_FAIL", 0, -6);
    public static final MessageType MSG_READ_EXCEPTION = new MessageType("MSG_READ_EXCEPTION", 1, -3);
    public static final MessageType MSG_WRITE_EXCEPTION = new MessageType("MSG_WRITE_EXCEPTION", 2, -2);
    public static final MessageType MSG_CONNECT_SUCCESS = new MessageType("MSG_CONNECT_SUCCESS", 3, 1);
    public static final MessageType MSG_READ_DATA = new MessageType("MSG_READ_DATA", 4, 4);
    public static final MessageType MSG_CONNECT_CLIENT = new MessageType("MSG_CONNECT_CLIENT", 5, 15);
    public static final MessageType MSG_BOND_FAIL = new MessageType("MSG_BOND_FAIL", 6, 20);
    public static final MessageType MSG_BOND_OK = new MessageType("MSG_BOND_OK", 7, 21);
    public static final MessageType MSG_RE_FLASH = new MessageType("MSG_RE_FLASH", 8, 78);
    public static final MessageType MSG_UPDATE_ERR = new MessageType("MSG_UPDATE_ERR", 9, 79);
    public static final MessageType MSG_RESTART_CLIENT = new MessageType("MSG_RESTART_CLIENT", 10, 100);

    private static final /* synthetic */ MessageType[] $values() {
        return new MessageType[]{MSG_CONNECT_FAIL, MSG_READ_EXCEPTION, MSG_WRITE_EXCEPTION, MSG_CONNECT_SUCCESS, MSG_READ_DATA, MSG_CONNECT_CLIENT, MSG_BOND_FAIL, MSG_BOND_OK, MSG_RE_FLASH, MSG_UPDATE_ERR, MSG_RESTART_CLIENT};
    }

    public static EnumEntries<MessageType> getEntries() {
        return $ENTRIES;
    }

    private MessageType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        MessageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MessageType.kt */
    @Metadata(m942d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m943d2 = {"Lcom/bedjet/bedjet/ui/main/v2/MessageType$Companion;", "", "<init>", "()V", "fromId", "Lcom/bedjet/bedjet/ui/main/v2/MessageType;", "id", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageType fromId(int id) {
            for (MessageType messageType : MessageType.values()) {
                if (messageType.getId() == id) {
                    return messageType;
                }
            }
            return null;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MessageType(name=" + name() + ", id=" + this.id + ")";
    }

    public static MessageType valueOf(String str) {
        return (MessageType) Enum.valueOf(MessageType.class, str);
    }

    public static MessageType[] values() {
        return (MessageType[]) $VALUES.clone();
    }
}
