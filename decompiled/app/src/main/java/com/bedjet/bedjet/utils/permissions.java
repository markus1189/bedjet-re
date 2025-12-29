package com.bedjet.bedjet.utils;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: permissions.kt */
@Metadata(m942d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, m943d2 = {"permissionScope", "", "", "getPermissionScope", "()[Ljava/lang/String;", "[Ljava/lang/String;", "hasPermissions", "", "context", "Landroid/content/Context;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.utils.PermissionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class permissions {
    private static final String[] permissionScope;

    static {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 31) {
            strArr = new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
        } else {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        }
        permissionScope = strArr;
    }

    public static final String[] getPermissionScope() {
        return permissionScope;
    }

    public static final boolean hasPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (String str : permissionScope) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
