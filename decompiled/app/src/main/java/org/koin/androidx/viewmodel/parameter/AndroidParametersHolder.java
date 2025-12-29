package org.koin.androidx.viewmodel.parameter;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;

/* compiled from: AndroidParametersHolder.kt */
@Metadata(m942d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J-\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0002¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0016¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0016¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, m943d2 = {"Lorg/koin/androidx/viewmodel/parameter/AndroidParametersHolder;", "Lorg/koin/core/parameter/ParametersHolder;", "initialValues", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/jvm/functions/Function0;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "getExtras", "()Landroidx/lifecycle/viewmodel/CreationExtras;", "createSavedStateHandleOrElse", "T", "clazz", "Lkotlin/reflect/KClass;", "block", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "elementAt", "i", "", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "getOrNull", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "koin-android_release"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AndroidParametersHolder extends ParametersHolder {
    private final CreationExtras extras;

    public /* synthetic */ AndroidParametersHolder(Function0 function0, CreationExtras creationExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0, creationExtras);
    }

    public final CreationExtras getExtras() {
        return this.extras;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidParametersHolder(kotlin.jvm.functions.Function0<? extends org.koin.core.parameter.ParametersHolder> r3, androidx.lifecycle.viewmodel.CreationExtras r4) {
        /*
            r2 = this;
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            if (r3 == 0) goto L1d
            java.lang.Object r3 = r3.invoke()
            org.koin.core.parameter.ParametersHolder r3 = (org.koin.core.parameter.ParametersHolder) r3
            if (r3 == 0) goto L1d
            java.util.List r3 = r3.getValues()
            if (r3 == 0) goto L1d
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.toMutableList(r3)
            if (r3 != 0) goto L24
        L1d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
        L24:
            r0 = 2
            r1 = 0
            r2.<init>(r3, r1, r0, r1)
            r2.extras = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.androidx.viewmodel.parameter.AndroidParametersHolder.<init>(kotlin.jvm.functions.Function0, androidx.lifecycle.viewmodel.CreationExtras):void");
    }

    @Override // org.koin.core.parameter.ParametersHolder
    public <T> T elementAt(final int i, final KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) createSavedStateHandleOrElse(clazz, new Function0<T>() { // from class: org.koin.androidx.viewmodel.parameter.AndroidParametersHolder$elementAt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object elementAt;
                elementAt = super/*org.koin.core.parameter.ParametersHolder*/.elementAt(i, clazz);
                return (T) elementAt;
            }
        });
    }

    @Override // org.koin.core.parameter.ParametersHolder
    public <T> T getOrNull(final KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) createSavedStateHandleOrElse(clazz, new Function0<T>() { // from class: org.koin.androidx.viewmodel.parameter.AndroidParametersHolder$getOrNull$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object orNull;
                orNull = super/*org.koin.core.parameter.ParametersHolder*/.getOrNull(clazz);
                return (T) orNull;
            }
        });
    }

    private final <T> T createSavedStateHandleOrElse(KClass<?> clazz, Function0<? extends T> block) {
        if (Intrinsics.areEqual(clazz, Reflection.getOrCreateKotlinClass(SavedStateHandle.class))) {
            return (T) SavedStateHandleSupport.createSavedStateHandle(this.extras);
        }
        return block.invoke();
    }
}
