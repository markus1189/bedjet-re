package com.bedjet.bedjet.p001ui.connection;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentConnectionBinding;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import com.bedjet.bedjet.utils.app;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: ConnectionFragment.kt */
@Metadata(m942d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, m943d2 = {"Lcom/bedjet/bedjet/ui/connection/ConnectionFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentConnectionBinding;", "<init>", "()V", "connectionTimer", "Ljava/util/Timer;", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "getStoredDeviceManager", "()Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "storedDeviceManager$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "startConnectTimer", "bedJetConnected", "isCanGoBack", "", "noBiodata", "updateDisplay", "connectionTimerCancel", "path", "", "onDestroy", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ConnectionFragment extends BaseFragment<FragmentConnectionBinding> {
    private static final long CONNECTION_TIMEOUT = 15000;
    private static final String TAG = "ConnectionFragment";
    private Timer connectionTimer;

    /* renamed from: storedDeviceManager$delegate, reason: from kotlin metadata */
    private final Lazy storedDeviceManager;

    public ConnectionFragment() {
        super(C0624R.layout.fragment_connection);
        final ConnectionFragment connectionFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storedDeviceManager = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoredDeviceManager>() { // from class: com.bedjet.bedjet.ui.connection.ConnectionFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager] */
            @Override // kotlin.jvm.functions.Function0
            public final StoredDeviceManager invoke() {
                ComponentCallbacks componentCallbacks = connectionFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), qualifier, b);
            }
        });
    }

    private final StoredDeviceManager getStoredDeviceManager() {
        return (StoredDeviceManager) this.storedDeviceManager.getValue();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setAppVersions(app.getVersions());
        DeviceRecord currentDevice = getStoredDeviceManager().getCurrentDevice();
        LoggerKt.logTag(TAG, ".onViewCreated, deviceRecord = " + currentDevice);
        getMainActivity().connectDevice(currentDevice);
        startConnectTimer();
    }

    private final void startConnectTimer() {
        LoggerKt.logTag(TAG, "Connection timer started");
        ConnectionFragment$startConnectTimer$task$1 connectionFragment$startConnectTimer$task$1 = new ConnectionFragment$startConnectTimer$task$1(this);
        Timer timer = new Timer();
        this.connectionTimer = timer;
        timer.schedule(connectionFragment$startConnectTimer$task$1, CONNECTION_TIMEOUT);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void bedJetConnected() {
        LoggerKt.logTag(TAG, ".bedJetConnected called");
        connectionTimerCancel(2);
        getNavigator().showConnectedFragment();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        LoggerKt.logTag(TAG, ".bedJetConnected called");
        getNavigator().showStoredDeviceFragment(3);
        return false;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void noBiodata() {
        connectionTimerCancel(3);
        getNavigator().showPromptFragment(PromptType.PROMPT_UPDATE);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public void updateDisplay() {
        LoggerKt.logTag(TAG, ".updateDisplay called");
        if (getStoredDeviceManager().getCurrentDeviceType() == DeviceType.BEDJET3) {
            connectionTimerCancel(4);
            getMainActivity().displaySetupWarnings();
        }
    }

    private final void connectionTimerCancel(int path) {
        LoggerKt.logTag(TAG, ".connectionTimerCancel path: " + path);
        Timer timer = this.connectionTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        connectionTimerCancel(1);
        super.onDestroy();
    }
}
