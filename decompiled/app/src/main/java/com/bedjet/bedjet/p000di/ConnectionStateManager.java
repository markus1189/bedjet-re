package com.bedjet.bedjet.p000di;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.data.local.model.ConnectionState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionStateManager.kt */
@Metadata(m942d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m943d2 = {"Lcom/bedjet/bedjet/di/ConnectionStateManager;", "", "<init>", "()V", "value", "Lcom/bedjet/bedjet/data/local/model/ConnectionState;", "connectStateBt", "getConnectStateBt", "()Lcom/bedjet/bedjet/data/local/model/ConnectionState;", "setConnectionState", "", "newConnectionState", "currentConnectionState", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ConnectionStateManager {
    private ConnectionState connectStateBt = ConnectionState.DISCONNECTED;

    public final void setConnectionState(ConnectionState newConnectionState) {
        Intrinsics.checkNotNullParameter(newConnectionState, "newConnectionState");
        setConnectionState$default(this, newConnectionState, null, 2, null);
    }

    public final ConnectionState getConnectStateBt() {
        return this.connectStateBt;
    }

    public static /* synthetic */ void setConnectionState$default(ConnectionStateManager connectionStateManager, ConnectionState connectionState, ConnectionState connectionState2, int i, Object obj) {
        if ((i & 2) != 0) {
            connectionState2 = null;
        }
        connectionStateManager.setConnectionState(connectionState, connectionState2);
    }

    public final void setConnectionState(ConnectionState newConnectionState, ConnectionState currentConnectionState) {
        Intrinsics.checkNotNullParameter(newConnectionState, "newConnectionState");
        if (currentConnectionState == null) {
            this.connectStateBt = newConnectionState;
        } else if (this.connectStateBt == currentConnectionState) {
            this.connectStateBt = newConnectionState;
        }
    }
}
