package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(m942d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m943d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "kotlinx-coroutines-core"}, m944k = 5, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m948xs = "kotlinx/coroutines/ThreadPoolDispatcherKt")
/* renamed from: kotlinx.coroutines.ThreadPoolDispatcherKt__ThreadPoolDispatcherKt, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ThreadPoolDispatcher {
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int i, final String str) {
        if (i < 1) {
            throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i, new ThreadFactory() { // from class: kotlinx.coroutines.ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m1139x1146da6d;
                m1139x1146da6d = ThreadPoolDispatcher.m1139x1146da6d(i, str, atomicInteger, runnable);
                return m1139x1146da6d;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt */
    public static final Thread m1139x1146da6d(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
