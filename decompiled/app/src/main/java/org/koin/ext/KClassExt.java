package org.koin.ext;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.mp.KoinPlatformTools;

/* compiled from: KClassExt.kt */
@Metadata(m942d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002\"\u001e\u0010\u0000\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m943d2 = {"classNames", "", "Lkotlin/reflect/KClass;", "", "getFullName", "saveCache", "koin-core"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: org.koin.ext.KClassExtKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class KClassExt {
    private static final Map<KClass<?>, String> classNames = KoinPlatformTools.INSTANCE.safeHashMap();

    public static final String getFullName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String str = classNames.get(kClass);
        return str == null ? saveCache(kClass) : str;
    }

    public static final String saveCache(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String className = KoinPlatformTools.INSTANCE.getClassName(kClass);
        classNames.put(kClass, className);
        return className;
    }
}
