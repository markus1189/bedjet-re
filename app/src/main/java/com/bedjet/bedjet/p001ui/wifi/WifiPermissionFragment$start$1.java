package com.bedjet.bedjet.p001ui.wifi;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WifiPermissionFragment.kt */
@Metadata(m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "com.bedjet.bedjet.ui.wifi.WifiPermissionFragment", m963f = "WifiPermissionFragment.kt", m964i = {0}, m965l = {56}, m966m = "start", m967n = {"this"}, m968s = {"L$0"})
/* loaded from: classes.dex */
public final class WifiPermissionFragment$start$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiPermissionFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiPermissionFragment$start$1(WifiPermissionFragment wifiPermissionFragment, Continuation<? super WifiPermissionFragment$start$1> continuation) {
        super(continuation);
        this.this$0 = wifiPermissionFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object start;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        start = this.this$0.start(this);
        return start;
    }
}
