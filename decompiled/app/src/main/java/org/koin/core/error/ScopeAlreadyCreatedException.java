package org.koin.core.error;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeAlreadyCreatedException.kt */
@Metadata(m942d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m943d2 = {"Lorg/koin/core/error/ScopeAlreadyCreatedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "s", "", "(Ljava/lang/String;)V", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ScopeAlreadyCreatedException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopeAlreadyCreatedException(String s) {
        super(s);
        Intrinsics.checkNotNullParameter(s, "s");
    }
}
