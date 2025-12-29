package com.bedjet.bedjet.p001ui.main.p003v3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: V3Setup.kt */
@Metadata(m942d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m943d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m944k = 3, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m962c = "com.bedjet.bedjet.ui.main.v3.V3SetupKt$setupInitialV3$1", m963f = "V3Setup.kt", m964i = {}, m965l = {13, 15, 17, 19, 23, 25}, m966m = "invokeSuspend", m967n = {}, m968s = {})
/* loaded from: classes.dex */
public final class V3SetupKt$setupInitialV3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $lights;
    final /* synthetic */ V3SetupListener $listener;
    final /* synthetic */ boolean $lowPower;
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $sounds;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V3SetupKt$setupInitialV3$1(V3SetupListener v3SetupListener, String str, boolean z, boolean z2, boolean z3, Continuation<? super V3SetupKt$setupInitialV3$1> continuation) {
        super(2, continuation);
        this.$listener = v3SetupListener;
        this.$name = str;
        this.$sounds = z;
        this.$lights = z2;
        this.$lowPower = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new V3SetupKt$setupInitialV3$1(this.$listener, this.$name, this.$sounds, this.$lights, this.$lowPower, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((V3SetupKt$setupInitialV3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bedjet.bedjet.p001ui.main.p003v3.V3SetupKt$setupInitialV3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
