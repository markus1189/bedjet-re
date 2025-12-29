package com.bedjet.bedjet.p001ui.connection;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.arch.FragmentNavigator;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.MainActivity;
import java.util.TimerTask;
import kotlin.Metadata;

/* compiled from: ConnectionFragment.kt */
@Metadata(m942d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m943d2 = {"com/bedjet/bedjet/ui/connection/ConnectionFragment$startConnectTimer$task$1", "Ljava/util/TimerTask;", "run", "", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ConnectionFragment$startConnectTimer$task$1 extends TimerTask {
    final /* synthetic */ ConnectionFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionFragment$startConnectTimer$task$1(ConnectionFragment connectionFragment) {
        this.this$0 = connectionFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        MainActivity mainActivity;
        LoggerKt.logTag("ConnectionFragment", "Connection Timer schedule finished");
        mainActivity = this.this$0.getMainActivity();
        final ConnectionFragment connectionFragment = this.this$0;
        mainActivity.runOnUiThread(new Runnable() { // from class: com.bedjet.bedjet.ui.connection.ConnectionFragment$startConnectTimer$task$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConnectionFragment$startConnectTimer$task$1.run$lambda$0(ConnectionFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$0(ConnectionFragment connectionFragment) {
        MainActivity mainActivity;
        FragmentNavigator navigator;
        mainActivity = connectionFragment.getMainActivity();
        mainActivity.cancelReadRetry();
        navigator = connectionFragment.getNavigator();
        navigator.showStoredDeviceFragment(2);
    }
}
