package com.bedjet.bedjet.p001ui.main.p003v3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: V3Setup.kt */
@Metadata(m942d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m943d2 = {"setupInitialV3", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "sounds", "", "lights", "lowPower", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bedjet/bedjet/ui/main/v3/V3SetupListener;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class V3SetupKt {
    public static final void setupInitialV3(String name, boolean z, boolean z2, boolean z3, V3SetupListener listener) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new V3SetupKt$setupInitialV3$1(listener, name, z, z2, z3, null), 3, null);
    }
}
