package com.bedjet.bedjet.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FunctionName.kt */
@Metadata(m942d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m943d2 = {"Lcom/bedjet/bedjet/utils/FunctionName;", "", "functionName", "", "<init>", "(Ljava/lang/String;)V", "getFunctionName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class FunctionName {
    private final String functionName;

    public static /* synthetic */ FunctionName copy$default(FunctionName functionName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = functionName.functionName;
        }
        return functionName.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    public final FunctionName copy(String functionName) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return new FunctionName(functionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FunctionName) && Intrinsics.areEqual(this.functionName, ((FunctionName) other).functionName);
    }

    public int hashCode() {
        return this.functionName.hashCode();
    }

    public String toString() {
        return "FunctionName(functionName=" + this.functionName + ")";
    }

    public FunctionName(String functionName) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.functionName = functionName;
    }

    public final String getFunctionName() {
        return this.functionName;
    }
}
