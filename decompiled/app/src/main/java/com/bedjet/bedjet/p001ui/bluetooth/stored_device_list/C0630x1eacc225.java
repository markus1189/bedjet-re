package com.bedjet.bedjet.p001ui.bluetooth.stored_device_list;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.utils.AdapterClickListener;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoredDeviceFragment.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.ui.bluetooth.stored_device_list.StoredDeviceFragment$sam$com_bedjet_bedjet_utils_AdapterClickListener$0 */
/* loaded from: classes.dex */
final class C0630x1eacc225 implements AdapterClickListener, FunctionAdapter {
    private final /* synthetic */ Function3 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0630x1eacc225(Function3 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof AdapterClickListener) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.bedjet.bedjet.utils.AdapterClickListener
    public final /* synthetic */ void onClick(View view, Object obj, int i) {
        this.function.invoke(view, obj, Integer.valueOf(i));
    }
}
