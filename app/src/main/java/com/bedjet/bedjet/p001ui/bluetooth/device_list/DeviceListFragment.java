package com.bedjet.bedjet.p001ui.bluetooth.device_list;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentDevicelistBinding;
import com.bedjet.bedjet.p000di.BluetoothSearchManager;
import com.bedjet.bedjet.p001ui.main.DeviceType;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.bedjet.bedjet.p001ui.main.ResumeFlag;
import com.bedjet.bedjet.utils.ext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: DeviceListFragment.kt */
@Metadata(m942d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00110\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/device_list/DeviceListFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentDevicelistBinding;", "<init>", "()V", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "getStoredDeviceManager", "()Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "storedDeviceManager$delegate", "Lkotlin/Lazy;", "bluetoothSearchManager", "Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "getBluetoothSearchManager", "()Lcom/bedjet/bedjet/di/BluetoothSearchManager;", "bluetoothSearchManager$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onRescan", "isCanGoBack", "", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bedjet/bedjet/di/BluetoothSearchManager$ActionData;", "adapterClickListener", "Lkotlin/Function3;", "Landroid/bluetooth/BluetoothDevice;", "", "clickListener", "Landroid/view/View$OnClickListener;", "Companion", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeviceListFragment extends BaseFragment<FragmentDevicelistBinding> {
    private static String TAG = "DeviceListFragment";
    private final Function3<View, BluetoothDevice, Integer, Unit> adapterClickListener;

    /* renamed from: bluetoothSearchManager$delegate, reason: from kotlin metadata */
    private final Lazy bluetoothSearchManager;
    private final View.OnClickListener clickListener;
    private final Observer<BluetoothSearchManager.ActionData> observer;

    /* renamed from: storedDeviceManager$delegate, reason: from kotlin metadata */
    private final Lazy storedDeviceManager;

    public DeviceListFragment() {
        super(C0624R.layout.fragment_devicelist);
        final DeviceListFragment deviceListFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storedDeviceManager = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoredDeviceManager>() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager] */
            @Override // kotlin.jvm.functions.Function0
            public final StoredDeviceManager invoke() {
                ComponentCallbacks componentCallbacks = deviceListFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.bluetoothSearchManager = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<BluetoothSearchManager>() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.di.BluetoothSearchManager] */
            @Override // kotlin.jvm.functions.Function0
            public final BluetoothSearchManager invoke() {
                ComponentCallbacks componentCallbacks = deviceListFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BluetoothSearchManager.class), b2, b3);
            }
        });
        this.observer = new Observer() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DeviceListFragment.observer$lambda$1(DeviceListFragment.this, (BluetoothSearchManager.ActionData) obj);
            }
        };
        this.adapterClickListener = new Function3() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit adapterClickListener$lambda$2;
                adapterClickListener$lambda$2 = DeviceListFragment.adapterClickListener$lambda$2(DeviceListFragment.this, (View) obj, (BluetoothDevice) obj2, ((Integer) obj3).intValue());
                return adapterClickListener$lambda$2;
            }
        };
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceListFragment.clickListener$lambda$3(DeviceListFragment.this, view);
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
        getBinding().setClickListener(this.clickListener);
        RecyclerView recyclerView = getBinding().deviceListRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        ext.addOverscroll(recyclerView);
        recyclerView.setAdapter(new DeviceListAdapter(new C0629x588a990a(this.adapterClickListener)));
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), 1));
        getBluetoothSearchManager().getActionDataLiveData().observe(getViewLifecycleOwner(), this.observer);
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().hideSystemUI();
        getBluetoothSearchManager().startScan();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBluetoothSearchManager().stopScan();
        RecyclerView.Adapter adapter = getBinding().deviceListRecyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListAdapter");
        ((DeviceListAdapter) adapter).clear();
    }

    private final void onRescan() {
        LoggerKt.log(TAG + ".onRescan Manual rescan initiated");
        RecyclerView.Adapter adapter = getBinding().deviceListRecyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListAdapter");
        ((DeviceListAdapter) adapter).clear();
        getBluetoothSearchManager().stopScan();
        getBluetoothSearchManager().startScan();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    public boolean isCanGoBack() {
        ResumeFlag resumeFlag = getMainActivity().getResumeFlag();
        getMainActivity().setResumeFlag(ResumeFlag.RESUME_DEFAULT);
        if (resumeFlag == ResumeFlag.RESUME_EXIT) {
            getMainActivity().finish();
            return false;
        }
        if (resumeFlag == ResumeFlag.RESUME_MENU) {
            getNavigator().showMenuFragment();
            return false;
        }
        if (getMainActivity().getIsDisconnected()) {
            return false;
        }
        getNavigator().showConnectedFragment();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$1(DeviceListFragment deviceListFragment, BluetoothSearchManager.ActionData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "observer call, data is " + it);
        if (it instanceof BluetoothSearchManager.ActionData.Result) {
            RecyclerView.Adapter adapter = deviceListFragment.getBinding().deviceListRecyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.bedjet.bedjet.ui.bluetooth.device_list.DeviceListAdapter");
            ((DeviceListAdapter) adapter).addDevice(((BluetoothSearchManager.ActionData.Result) it).getDevice());
            deviceListFragment.getBinding().deviceListProgressBar.setVisibility(8);
            return;
        }
        if (Intrinsics.areEqual(it, BluetoothSearchManager.ActionData.Start.INSTANCE)) {
            deviceListFragment.getBinding().deviceListProgressBar.setVisibility(0);
        } else if (Intrinsics.areEqual(it, BluetoothSearchManager.ActionData.Stop.INSTANCE)) {
            deviceListFragment.getBinding().deviceListProgressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapterClickListener$lambda$2(DeviceListFragment deviceListFragment, View view, BluetoothDevice device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LoggerKt.logTag(TAG2, "Click detected on device " + device);
        deviceListFragment.getBluetoothSearchManager().stopScan();
        StoredDeviceManager storedDeviceManager = deviceListFragment.getStoredDeviceManager();
        String address = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        storedDeviceManager.setCurrentDevice(address, DeviceType.INSTANCE.getDeviceTypeFromName(device));
        deviceListFragment.getNavigator().showConnectionFragment(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$3(DeviceListFragment deviceListFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == C0624R.id.deviceListButtonRescan) {
            deviceListFragment.onRescan();
        }
    }
}
