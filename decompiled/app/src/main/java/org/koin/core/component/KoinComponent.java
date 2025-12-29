package org.koin.core.component;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import org.koin.core.Koin;
import org.koin.mp.KoinPlatformTools;

/* compiled from: KoinComponent.kt */
@Metadata(m942d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m943d2 = {"Lorg/koin/core/component/KoinComponent;", "", "getKoin", "Lorg/koin/core/Koin;", "koin-core"}, m944k = 1, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface KoinComponent {
    Koin getKoin();

    /* compiled from: KoinComponent.kt */
    @Metadata(m944k = 3, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static Koin getKoin(KoinComponent koinComponent) {
            return KoinPlatformTools.INSTANCE.defaultContext().get();
        }
    }
}
