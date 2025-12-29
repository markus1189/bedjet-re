package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final CrashlyticsNativeComponent nativeComponent;
    private final SettingsProvider settingsProvider;

    /* loaded from: classes2.dex */
    interface CrashListener {
        void onUncaughtException(SettingsProvider settingsProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsProvider settingsProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.crashListener = crashListener;
        this.settingsProvider = settingsProvider;
        this.defaultHandler = uncaughtExceptionHandler;
        this.nativeComponent = crashlyticsNativeComponent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        r7.isHandlingException.set(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().m891d("Completed exception processing. Invoking default exception handler.");
        r7.defaultHandler.uncaughtException(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r7.defaultHandler == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r7.defaultHandler != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0044, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().m891d("Completed exception processing, but no default exception handler.");
        java.lang.System.exit(1);
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Completed exception processing. Invoking default exception handler."
            java.lang.String r1 = "Completed exception processing, but no default exception handler."
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.isHandlingException
            r3 = 1
            r2.set(r3)
            r2 = 0
            boolean r4 = r7.shouldRecordUncaughtException(r8, r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r4 == 0) goto L19
            com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler$CrashListener r4 = r7.crashListener     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            com.google.firebase.crashlytics.internal.settings.SettingsProvider r5 = r7.settingsProvider     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r4.onUncaughtException(r5, r8, r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            goto L22
        L19:
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r5 = "Uncaught exception will not be recorded by Crashlytics."
            r4.m891d(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L22:
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.defaultHandler
            if (r4 == 0) goto L44
            goto L37
        L27:
            r4 = move-exception
            goto L54
        L29:
            r4 = move-exception
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L27
            java.lang.String r6 = "An error occurred in the uncaught exception handler"
            r5.m894e(r6, r4)     // Catch: java.lang.Throwable -> L27
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.defaultHandler
            if (r4 == 0) goto L44
        L37:
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            r1.m891d(r0)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.defaultHandler
            r0.uncaughtException(r8, r9)
            goto L4e
        L44:
            com.google.firebase.crashlytics.internal.Logger r8 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            r8.m891d(r1)
            java.lang.System.exit(r3)
        L4e:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.isHandlingException
            r8.set(r2)
            return
        L54:
            java.lang.Thread$UncaughtExceptionHandler r5 = r7.defaultHandler
            if (r5 == 0) goto L65
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            r1.m891d(r0)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.defaultHandler
            r0.uncaughtException(r8, r9)
            goto L6f
        L65:
            com.google.firebase.crashlytics.internal.Logger r8 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            r8.m891d(r1)
            java.lang.System.exit(r3)
        L6f:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.isHandlingException
            r8.set(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    private boolean shouldRecordUncaughtException(Thread thread, Throwable th) {
        if (thread == null) {
            Logger.getLogger().m893e("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            Logger.getLogger().m893e("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.nativeComponent.hasCrashDataForCurrentSession()) {
            return true;
        }
        Logger.getLogger().m891d("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }
}
