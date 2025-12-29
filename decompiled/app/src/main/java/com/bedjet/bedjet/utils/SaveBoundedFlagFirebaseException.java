package com.bedjet.bedjet.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m943d2 = {"Lcom/bedjet/bedjet/utils/SaveBoundedFlagFirebaseException;", "Lcom/bedjet/bedjet/utils/FirebaseException;", "exceptionMessage", "", "<init>", "(Ljava/lang/String;)V", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SaveBoundedFlagFirebaseException extends FirebaseException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveBoundedFlagFirebaseException(String exceptionMessage) {
        super(exceptionMessage);
        Intrinsics.checkNotNullParameter(exceptionMessage, "exceptionMessage");
    }
}
