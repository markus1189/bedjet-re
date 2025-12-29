package com.bedjet.bedjet.p001ui.bluetooth.stored_device_list;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.bedjet.bedjet.C0624R;
import com.bedjet.bedjet.arch.BaseFragment;
import com.bedjet.bedjet.data.local.model.stored.DeviceRecord;
import com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager;
import com.bedjet.bedjet.databinding.FragmentStoredDeviceBinding;
import com.bedjet.bedjet.p001ui.CustomDialog;
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

/* compiled from: StoredDeviceFragment.kt */
@Metadata(m942d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0010\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0017J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR&\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m943d2 = {"Lcom/bedjet/bedjet/ui/bluetooth/stored_device_list/StoredDeviceFragment;", "Lcom/bedjet/bedjet/arch/BaseFragment;", "Lcom/bedjet/bedjet/databinding/FragmentStoredDeviceBinding;", "<init>", "()V", "storedDeviceManager", "Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "getStoredDeviceManager", "()Lcom/bedjet/bedjet/data/local/model/stored/StoredDeviceManager;", "storedDeviceManager$delegate", "Lkotlin/Lazy;", "customDialog", "Lcom/bedjet/bedjet/ui/CustomDialog;", "getCustomDialog", "()Lcom/bedjet/bedjet/ui/CustomDialog;", "customDialog$delegate", "getBindingVariable", "", "()Ljava/lang/Integer;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "isCanGoBack", "", "adapterClickListener", "Lkotlin/Function3;", "Lcom/bedjet/bedjet/data/local/model/stored/DeviceRecord;", "clickListener", "Landroid/view/View$OnClickListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StoredDeviceFragment extends BaseFragment<FragmentStoredDeviceBinding> {
    private final Function3<View, DeviceRecord, Integer, Unit> adapterClickListener;
    private final View.OnClickListener clickListener;

    /* renamed from: customDialog$delegate, reason: from kotlin metadata */
    private final Lazy customDialog;

    /* renamed from: storedDeviceManager$delegate, reason: from kotlin metadata */
    private final Lazy storedDeviceManager;

    public StoredDeviceFragment() {
        super(C0624R.layout.fragment_stored_device);
        final StoredDeviceFragment storedDeviceFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storedDeviceManager = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoredDeviceManager>() { // from class: com.bedjet.bedjet.ui.bluetooth.stored_device_list.StoredDeviceFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.bedjet.bedjet.data.local.model.stored.StoredDeviceManager] */
            @Override // kotlin.jvm.functions.Function0
            public final StoredDeviceManager invoke() {
                ComponentCallbacks componentCallbacks = storedDeviceFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoredDeviceManager.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.customDialog = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CustomDialog>() { // from class: com.bedjet.bedjet.ui.bluetooth.stored_device_list.StoredDeviceFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.bedjet.bedjet.ui.CustomDialog, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CustomDialog invoke() {
                ComponentCallbacks componentCallbacks = storedDeviceFragment;
                return AndroidKoinScopeExt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CustomDialog.class), b2, b3);
            }
        });
        this.adapterClickListener = new Function3() { // from class: com.bedjet.bedjet.ui.bluetooth.stored_device_list.StoredDeviceFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit adapterClickListener$lambda$3;
                adapterClickListener$lambda$3 = StoredDeviceFragment.adapterClickListener$lambda$3(StoredDeviceFragment.this, (View) obj, (DeviceRecord) obj2, ((Integer) obj3).intValue());
                return adapterClickListener$lambda$3;
            }
        };
        this.clickListener = new View.OnClickListener() { // from class: com.bedjet.bedjet.ui.bluetooth.stored_device_list.StoredDeviceFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoredDeviceFragment.clickListener$lambda$4(StoredDeviceFragment.this, view);
            }
        };
    }

    private final StoredDeviceManager getStoredDeviceManager() {
        return (StoredDeviceManager) this.storedDeviceManager.getValue();
    }

    private final CustomDialog getCustomDialog() {
        return (CustomDialog) this.customDialog.getValue();
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment
    protected Integer getBindingVariable() {
        return 6;
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setClickListener(this.clickListener);
        RecyclerView recyclerView = getBinding().storedDeviceRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        ext.addOverscroll(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), 1));
        recyclerView.setAdapter(new StoredDeviceListAdapter(new C0630x1eacc225(this.adapterClickListener)));
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getController().hideSystemUI();
        RecyclerView.Adapter adapter = getBinding().storedDeviceRecyclerView.getAdapter();
        StoredDeviceListAdapter storedDeviceListAdapter = adapter instanceof StoredDeviceListAdapter ? (StoredDeviceListAdapter) adapter : null;
        if (storedDeviceListAdapter != null) {
            storedDeviceListAdapter.clear();
            for (DeviceRecord deviceRecord : getStoredDeviceManager().getStoredDevices()) {
                if (deviceRecord.getDeviceAddress().length() > 0) {
                    storedDeviceListAdapter.addDevice(deviceRecord);
                }
            }
        }
    }

    @Override // com.bedjet.bedjet.arch.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getController().showSystemUI();
        RecyclerView.Adapter adapter = getBinding().storedDeviceRecyclerView.getAdapter();
        StoredDeviceListAdapter storedDeviceListAdapter = adapter instanceof StoredDeviceListAdapter ? (StoredDeviceListAdapter) adapter : null;
        if (storedDeviceListAdapter != null) {
            storedDeviceListAdapter.clear();
        }
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
    public static final Unit adapterClickListener$lambda$3(StoredDeviceFragment storedDeviceFragment, View view, DeviceRecord item, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        int id = view.getId();
        if (id == C0624R.id.itemStoredDeviceButtonDelete) {
            if (i == 0 && !storedDeviceFragment.getMainActivity().getIsDisconnected()) {
                CustomDialog customDialog = storedDeviceFragment.getCustomDialog();
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                customDialog.showCantDeleteDialog(context);
            } else {
                RecyclerView.Adapter adapter = storedDeviceFragment.getBinding().storedDeviceRecyclerView.getAdapter();
                StoredDeviceListAdapter storedDeviceListAdapter = adapter instanceof StoredDeviceListAdapter ? (StoredDeviceListAdapter) adapter : null;
                if (storedDeviceListAdapter != null) {
                    storedDeviceListAdapter.delete(item);
                }
                storedDeviceFragment.getStoredDeviceManager().delete(item);
            }
        } else if (id == C0624R.id.itemStoredDeviceListLayout) {
            storedDeviceFragment.getMainActivity().setCurrentDevice(item);
            storedDeviceFragment.getNavigator().showConnectionFragment(3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickListener$lambda$4(StoredDeviceFragment storedDeviceFragment, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == C0624R.id.storedDeviceButtonRescan) {
            storedDeviceFragment.getNavigator().showDeviceListFragment(2);
        }
    }
}
