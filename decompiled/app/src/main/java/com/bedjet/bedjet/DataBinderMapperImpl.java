package com.bedjet.bedjet;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bedjet.bedjet.databinding.ActivityMainBindingImpl;
import com.bedjet.bedjet.databinding.DialogAppReviewBindingImpl;
import com.bedjet.bedjet.databinding.DialogAppReviewNegativeBindingImpl;
import com.bedjet.bedjet.databinding.DialogAppReviewPositiveBindingImpl;
import com.bedjet.bedjet.databinding.DialogCannotDeleteBindingImpl;
import com.bedjet.bedjet.databinding.DialogFactoryResetBindingImpl;
import com.bedjet.bedjet.databinding.DialogOldAppBindingImpl;
import com.bedjet.bedjet.databinding.DialogOldAppInstalledBindingImpl;
import com.bedjet.bedjet.databinding.DialogPairBindingImpl;
import com.bedjet.bedjet.databinding.DialogRenameBindingImpl;
import com.bedjet.bedjet.databinding.FragmentBiorhythmBindingImpl;
import com.bedjet.bedjet.databinding.FragmentBluetoothBindingImpl;
import com.bedjet.bedjet.databinding.FragmentConnectionBindingImpl;
import com.bedjet.bedjet.databinding.FragmentDevicelistBindingImpl;
import com.bedjet.bedjet.databinding.FragmentMenuBindingImpl;
import com.bedjet.bedjet.databinding.FragmentPromptBindingImpl;
import com.bedjet.bedjet.databinding.FragmentSettingsBindingImpl;
import com.bedjet.bedjet.databinding.FragmentSetupV3BindingImpl;
import com.bedjet.bedjet.databinding.FragmentSetupV3LoadingBindingImpl;
import com.bedjet.bedjet.databinding.FragmentStoredDeviceBindingImpl;
import com.bedjet.bedjet.databinding.FragmentTemperatureBindingImpl;
import com.bedjet.bedjet.databinding.FragmentV2statusBindingImpl;
import com.bedjet.bedjet.databinding.FragmentWifiBindingImpl;
import com.bedjet.bedjet.databinding.FragmentWifiPermissionBindingImpl;
import com.bedjet.bedjet.databinding.ItemStoredDeviceListBindingImpl;
import com.bedjet.bedjet.databinding.LayoutAutoItemBindingImpl;
import com.bedjet.bedjet.databinding.LayoutItemBindingImpl;
import com.bedjet.bedjet.databinding.LayoutItemBiorhythmBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYMAIN = 1;
    private static final int LAYOUT_DIALOGAPPREVIEW = 2;
    private static final int LAYOUT_DIALOGAPPREVIEWNEGATIVE = 3;
    private static final int LAYOUT_DIALOGAPPREVIEWPOSITIVE = 4;
    private static final int LAYOUT_DIALOGCANNOTDELETE = 5;
    private static final int LAYOUT_DIALOGFACTORYRESET = 6;
    private static final int LAYOUT_DIALOGOLDAPP = 7;
    private static final int LAYOUT_DIALOGOLDAPPINSTALLED = 8;
    private static final int LAYOUT_DIALOGPAIR = 9;
    private static final int LAYOUT_DIALOGRENAME = 10;
    private static final int LAYOUT_FRAGMENTBIORHYTHM = 11;
    private static final int LAYOUT_FRAGMENTBLUETOOTH = 12;
    private static final int LAYOUT_FRAGMENTCONNECTION = 13;
    private static final int LAYOUT_FRAGMENTDEVICELIST = 14;
    private static final int LAYOUT_FRAGMENTMENU = 15;
    private static final int LAYOUT_FRAGMENTPROMPT = 16;
    private static final int LAYOUT_FRAGMENTSETTINGS = 17;
    private static final int LAYOUT_FRAGMENTSETUPV3 = 18;
    private static final int LAYOUT_FRAGMENTSETUPV3LOADING = 19;
    private static final int LAYOUT_FRAGMENTSTOREDDEVICE = 20;
    private static final int LAYOUT_FRAGMENTTEMPERATURE = 21;
    private static final int LAYOUT_FRAGMENTV2STATUS = 22;
    private static final int LAYOUT_FRAGMENTWIFI = 23;
    private static final int LAYOUT_FRAGMENTWIFIPERMISSION = 24;
    private static final int LAYOUT_ITEMSTOREDDEVICELIST = 25;
    private static final int LAYOUT_LAYOUTAUTOITEM = 26;
    private static final int LAYOUT_LAYOUTITEM = 27;
    private static final int LAYOUT_LAYOUTITEMBIORHYTHM = 28;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(28);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(C0624R.layout.activity_main, 1);
        sparseIntArray.put(C0624R.layout.dialog_app_review, 2);
        sparseIntArray.put(C0624R.layout.dialog_app_review_negative, 3);
        sparseIntArray.put(C0624R.layout.dialog_app_review_positive, 4);
        sparseIntArray.put(C0624R.layout.dialog_cannot_delete, 5);
        sparseIntArray.put(C0624R.layout.dialog_factory_reset, 6);
        sparseIntArray.put(C0624R.layout.dialog_old_app, 7);
        sparseIntArray.put(C0624R.layout.dialog_old_app_installed, 8);
        sparseIntArray.put(C0624R.layout.dialog_pair, 9);
        sparseIntArray.put(C0624R.layout.dialog_rename, 10);
        sparseIntArray.put(C0624R.layout.fragment_biorhythm, 11);
        sparseIntArray.put(C0624R.layout.fragment_bluetooth, 12);
        sparseIntArray.put(C0624R.layout.fragment_connection, 13);
        sparseIntArray.put(C0624R.layout.fragment_devicelist, 14);
        sparseIntArray.put(C0624R.layout.fragment_menu, 15);
        sparseIntArray.put(C0624R.layout.fragment_prompt, 16);
        sparseIntArray.put(C0624R.layout.fragment_settings, 17);
        sparseIntArray.put(C0624R.layout.fragment_setup_v3, 18);
        sparseIntArray.put(C0624R.layout.fragment_setup_v3_loading, 19);
        sparseIntArray.put(C0624R.layout.fragment_stored_device, 20);
        sparseIntArray.put(C0624R.layout.fragment_temperature, 21);
        sparseIntArray.put(C0624R.layout.fragment_v2status, 22);
        sparseIntArray.put(C0624R.layout.fragment_wifi, 23);
        sparseIntArray.put(C0624R.layout.fragment_wifi_permission, 24);
        sparseIntArray.put(C0624R.layout.item_stored_device_list, 25);
        sparseIntArray.put(C0624R.layout.layout_auto_item, 26);
        sparseIntArray.put(C0624R.layout.layout_item, 27);
        sparseIntArray.put(C0624R.layout.layout_item_biorhythm, 28);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_main_0".equals(tag)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
            case 2:
                if ("layout/dialog_app_review_0".equals(tag)) {
                    return new DialogAppReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_review is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_app_review_negative_0".equals(tag)) {
                    return new DialogAppReviewNegativeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_review_negative is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_app_review_positive_0".equals(tag)) {
                    return new DialogAppReviewPositiveBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_review_positive is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_cannot_delete_0".equals(tag)) {
                    return new DialogCannotDeleteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_cannot_delete is invalid. Received: " + tag);
            case 6:
                if ("layout/dialog_factory_reset_0".equals(tag)) {
                    return new DialogFactoryResetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_factory_reset is invalid. Received: " + tag);
            case 7:
                if ("layout/dialog_old_app_0".equals(tag)) {
                    return new DialogOldAppBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_old_app is invalid. Received: " + tag);
            case 8:
                if ("layout/dialog_old_app_installed_0".equals(tag)) {
                    return new DialogOldAppInstalledBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_old_app_installed is invalid. Received: " + tag);
            case 9:
                if ("layout/dialog_pair_0".equals(tag)) {
                    return new DialogPairBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_pair is invalid. Received: " + tag);
            case 10:
                if ("layout/dialog_rename_0".equals(tag)) {
                    return new DialogRenameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_rename is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_biorhythm_0".equals(tag)) {
                    return new FragmentBiorhythmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_biorhythm is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_bluetooth_0".equals(tag)) {
                    return new FragmentBluetoothBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bluetooth is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_connection_0".equals(tag)) {
                    return new FragmentConnectionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_connection is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_devicelist_0".equals(tag)) {
                    return new FragmentDevicelistBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_devicelist is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_menu_0".equals(tag)) {
                    return new FragmentMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_menu is invalid. Received: " + tag);
            case 16:
                if ("layout/fragment_prompt_0".equals(tag)) {
                    return new FragmentPromptBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_prompt is invalid. Received: " + tag);
            case 17:
                if ("layout/fragment_settings_0".equals(tag)) {
                    return new FragmentSettingsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_settings is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_setup_v3_0".equals(tag)) {
                    return new FragmentSetupV3BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_setup_v3 is invalid. Received: " + tag);
            case 19:
                if ("layout/fragment_setup_v3_loading_0".equals(tag)) {
                    return new FragmentSetupV3LoadingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_setup_v3_loading is invalid. Received: " + tag);
            case 20:
                if ("layout/fragment_stored_device_0".equals(tag)) {
                    return new FragmentStoredDeviceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_stored_device is invalid. Received: " + tag);
            case 21:
                if ("layout/fragment_temperature_0".equals(tag)) {
                    return new FragmentTemperatureBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_temperature is invalid. Received: " + tag);
            case 22:
                if ("layout/fragment_v2status_0".equals(tag)) {
                    return new FragmentV2statusBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_v2status is invalid. Received: " + tag);
            case 23:
                if ("layout/fragment_wifi_0".equals(tag)) {
                    return new FragmentWifiBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_wifi is invalid. Received: " + tag);
            case 24:
                if ("layout/fragment_wifi_permission_0".equals(tag)) {
                    return new FragmentWifiPermissionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_wifi_permission is invalid. Received: " + tag);
            case 25:
                if ("layout/item_stored_device_list_0".equals(tag)) {
                    return new ItemStoredDeviceListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_stored_device_list is invalid. Received: " + tag);
            case 26:
                if ("layout/layout_auto_item_0".equals(tag)) {
                    return new LayoutAutoItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_auto_item is invalid. Received: " + tag);
            case 27:
                if ("layout/layout_item_0".equals(tag)) {
                    return new LayoutItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_item is invalid. Received: " + tag);
            case 28:
                if ("layout/layout_item_biorhythm_0".equals(tag)) {
                    return new LayoutItemBiorhythmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_item_biorhythm is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    /* loaded from: classes.dex */
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "appVersions");
            sparseArray.put(2, "clickListener");
            sparseArray.put(3, "hasPairings");
            sparseArray.put(4, "item");
            sparseArray.put(5, "position");
            sparseArray.put(6, "presenter");
            sparseArray.put(7, "version");
        }
    }

    /* loaded from: classes.dex */
    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(28);
            sKeys = hashMap;
            hashMap.put("layout/activity_main_0", Integer.valueOf(C0624R.layout.activity_main));
            hashMap.put("layout/dialog_app_review_0", Integer.valueOf(C0624R.layout.dialog_app_review));
            hashMap.put("layout/dialog_app_review_negative_0", Integer.valueOf(C0624R.layout.dialog_app_review_negative));
            hashMap.put("layout/dialog_app_review_positive_0", Integer.valueOf(C0624R.layout.dialog_app_review_positive));
            hashMap.put("layout/dialog_cannot_delete_0", Integer.valueOf(C0624R.layout.dialog_cannot_delete));
            hashMap.put("layout/dialog_factory_reset_0", Integer.valueOf(C0624R.layout.dialog_factory_reset));
            hashMap.put("layout/dialog_old_app_0", Integer.valueOf(C0624R.layout.dialog_old_app));
            hashMap.put("layout/dialog_old_app_installed_0", Integer.valueOf(C0624R.layout.dialog_old_app_installed));
            hashMap.put("layout/dialog_pair_0", Integer.valueOf(C0624R.layout.dialog_pair));
            hashMap.put("layout/dialog_rename_0", Integer.valueOf(C0624R.layout.dialog_rename));
            hashMap.put("layout/fragment_biorhythm_0", Integer.valueOf(C0624R.layout.fragment_biorhythm));
            hashMap.put("layout/fragment_bluetooth_0", Integer.valueOf(C0624R.layout.fragment_bluetooth));
            hashMap.put("layout/fragment_connection_0", Integer.valueOf(C0624R.layout.fragment_connection));
            hashMap.put("layout/fragment_devicelist_0", Integer.valueOf(C0624R.layout.fragment_devicelist));
            hashMap.put("layout/fragment_menu_0", Integer.valueOf(C0624R.layout.fragment_menu));
            hashMap.put("layout/fragment_prompt_0", Integer.valueOf(C0624R.layout.fragment_prompt));
            hashMap.put("layout/fragment_settings_0", Integer.valueOf(C0624R.layout.fragment_settings));
            hashMap.put("layout/fragment_setup_v3_0", Integer.valueOf(C0624R.layout.fragment_setup_v3));
            hashMap.put("layout/fragment_setup_v3_loading_0", Integer.valueOf(C0624R.layout.fragment_setup_v3_loading));
            hashMap.put("layout/fragment_stored_device_0", Integer.valueOf(C0624R.layout.fragment_stored_device));
            hashMap.put("layout/fragment_temperature_0", Integer.valueOf(C0624R.layout.fragment_temperature));
            hashMap.put("layout/fragment_v2status_0", Integer.valueOf(C0624R.layout.fragment_v2status));
            hashMap.put("layout/fragment_wifi_0", Integer.valueOf(C0624R.layout.fragment_wifi));
            hashMap.put("layout/fragment_wifi_permission_0", Integer.valueOf(C0624R.layout.fragment_wifi_permission));
            hashMap.put("layout/item_stored_device_list_0", Integer.valueOf(C0624R.layout.item_stored_device_list));
            hashMap.put("layout/layout_auto_item_0", Integer.valueOf(C0624R.layout.layout_auto_item));
            hashMap.put("layout/layout_item_0", Integer.valueOf(C0624R.layout.layout_item));
            hashMap.put("layout/layout_item_biorhythm_0", Integer.valueOf(C0624R.layout.layout_item_biorhythm));
        }
    }
}
