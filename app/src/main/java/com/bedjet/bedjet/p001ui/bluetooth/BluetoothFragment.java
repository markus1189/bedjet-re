package com.bedjet.bedjet.p001ui.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentBluetoothBinding;
import com.bedjet.bedjet.p000di.BluetoothSearchManager;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.prompt.PromptType;
import com.bedjet.bedjet.utils.app;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: BluetoothFragment.kt */
@Metadata(m942d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010#0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/BluetoothFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentBluetoothBinding;", "<init>", "()V", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "getStoredDeviceManager", "()Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "storedDeviceManager$delegate", "Lkotlin/Lazy;", "bluetoothSearchManager", "Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "getBluetoothSearchManager", "()Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "bluetoothSearchManager$delegate", "hasPairings", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "startScanIfNeed", "onResume", "onPause", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "checkDevice", "device", "Landroid/bluetooth/BluetoothDevice;", "intentActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "clickListener", "Landroid/view/View$OnClickListener;", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BluetoothFragment extends BaseFragment<FragmentBluetoothBinding> {
    private static String TAG = "BluetoothFragment";

    /* renamed from: bluetoothSearchManager$delegate, reason: from kotlin metadata */
    private final Lazy bluetoothSearchManager;
    private final View.OnClickListener clickListener;
    private boolean hasPairings;
    private final ActivityResultLauncher<Intent> intentActivityResultLauncher;
    private final Observer<BluetoothSearchManager.ActionData> observer;

    /* renamed from: storedDeviceManager$delegate, reason: from kotlin metadata */
    private final Lazy storedDeviceManager;

    public BluetoothFragment() {
        super(C0624R.layout.fragment_bluetooth);
        final BluetoothFragment bluetoothFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storedDeviceManager = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoredDeviceManager>() { // from class: com.bedjet.bedjet.ui.bluetooth.BluetoothFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager] */
            @Override // kotlin.jvm.functions.Function0
            public final StoredDeviceManager invoke() {
                ComponentCallbacks componentCallbacks = bluetoothFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.bluetoothSearchManager = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<BluetoothSearchManager>() { // from class: com.bedjet.bedjet.ui.bluetooth.BluetoothFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.di.BluetoothSearchManager] */
            @Override // kotlin.jvm.functions.Function0
            public final BluetoothSearchManager invoke() {
                ComponentCallbacks componentCallbacks = bluetoothFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BluetoothSearchManager.class), b2, b3);
            }
        });
        this.observer = new Observer() { // from class: com.bedjet.bedjet.ui.bluetooth.BluetoothFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BluetoothFragment.observer$lambda$0(BluetoothFragment.this, (BluetoothSearchManager.ActionData) obj);
            }
        };
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bedjet.bedjet.ui.bluetooth.BluetoothFragment$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BluetoothFragment.intentActivityResultLauncher$lambda$1(BluetoothFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.intentActivityResultLauncher = registerForActivityResult;
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.bluetooth.BluetoothFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluetoothFragment.clickListener$lambda$2(BluetoothFragment.this, view);
            }
        };
    }

    private final StoredDeviceManager getStoredDeviceManager() {
        return (StoredDeviceManager) this.storedDeviceManager.getValue();
    }

    private final BluetoothSearchManager getBluetoothSearchManager() {
        return (BluetoothSearchManager) this.bluetoothSearchManager.getValue();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DeviceRecord currentDevice = getStoredDeviceManager().getCurrentDevice();
        this.hasPairings = currentDevice != null ? currentDevice.isRealDevice() : false;
        getBinding().setVersion(app.getVersions());
        getBinding().setHasPairings(Boolean.valueOf(this.hasPairings));
        getBinding().setClickListener(this.clickListener);
        getBinding().executePendingBindings();
        getBluetoothSearchManager().getActionDataLiveData().observe(getViewLifecycleOwner(), this.observer);
        if (!getBluetoothSearchManager().getBluetoothAdapter().isEnabled()) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LoggerKt.logTag(TAG2, "Bluetooth is disabled.");
            this.intentActivityResultLauncher.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
            return;
        }
        startScanIfNeed();
    }

    private final void startScanIfNeed() {
        if (this.hasPairings) {
            getBluetoothSearchManager().startScan();
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().hideSystemUI();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getController().showSystemUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(BluetoothFragment bluetoothFragment, BluetoothSearchManager.ActionData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "observer call, data is " + it);
        if (it instanceof BluetoothSearchManager.ActionData.Result) {
            bluetoothFragment.checkDevice(((BluetoothSearchManager.ActionData.Result) it).getDevice());
        } else if (Intrinsics.areEqual(it, BluetoothSearchManager.ActionData.HandlerStop.INSTANCE)) {
            bluetoothFragment.getMainActivity().showPromptFragment(PromptType.PROMPT_NO_DEVICE);
        }
    }

    private final void checkDevice(BluetoothDevice device) {
        String deviceAddress;
        DeviceRecord currentDevice = getStoredDeviceManager().getCurrentDevice();
        if (currentDevice == null || (deviceAddress = currentDevice.getDeviceAddress()) == null || !Intrinsics.areEqual(deviceAddress, device.getAddress())) {
            return;
        }
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Device found!, device = " + device);
        getBluetoothSearchManager().stopScan();
        getMainActivity().showConnectionFragment(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intentActivityResultLauncher$lambda$1(BluetoothFragment bluetoothFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, ".onActivityResult, request for bluetooth enable result = " + result);
        if (result.getResultCode() == 0) {
            FragmentActivity activity = bluetoothFragment.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        bluetoothFragment.startScanIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$2(BluetoothFragment bluetoothFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == C0624R.id.bluetoothConnectButton) {
            bluetoothFragment.getNavigator().showDeviceListFragment(1);
        }
    }
}
