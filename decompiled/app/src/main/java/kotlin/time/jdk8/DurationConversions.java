package kotlin.time.jdk8;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: DurationConversions.kt */
@Metadata(m942d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m943d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, m944k = 2, m945mv = {1, 9, 0}, m946pn = "kotlin.time", m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: kotlin.time.jdk8.DurationConversionsJDK8Kt, reason: use source file name */
/* loaded from: classes2.dex */
public final class DurationConversions {
    private static final long toKotlinDuration(Duration duration) {
        long seconds;
        int nano;
        Intrinsics.checkNotNullParameter(duration, "<this>");
        seconds = duration.getSeconds();
        long duration2 = DurationKt.toDuration(seconds, DurationUnit.SECONDS);
        nano = duration.getNano();
        return kotlin.time.Duration.m2791plusLRDsOJo(duration2, DurationKt.toDuration(nano, DurationUnit.NANOSECONDS));
    }

    /* renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m2917toJavaDurationLRDsOJo(long j) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m2776getInWholeSecondsimpl(j), kotlin.time.Duration.m2778getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toComponents-impl(...)");
        return ofSeconds;
    }
}
