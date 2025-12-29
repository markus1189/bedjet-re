package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: SessionLifecycleServiceBinder.kt */
@Metadata(m942d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m943d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "", "bindToService", "", "callback", "Landroid/os/Messenger;", "serviceConnection", "Landroid/content/ServiceConnection;", "com.google.firebase-firebase-sessions"}, m944k = 1, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public interface SessionLifecycleServiceBinder {
    void bindToService(Messenger callback, ServiceConnection serviceConnection);
}
