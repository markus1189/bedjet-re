package com.bedjet.bedjet.ext;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.p001ui.main.LoggerKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseExt.kt */
@Metadata(m942d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\"\u0018\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\t"}, m943d2 = {"TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "updateRemoteConfig", "", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "updateListener", "Lkotlin/Function0;", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: com.bedjet.bedjet.ext.FirebaseExtKt, reason: use source file name */
/* loaded from: classes.dex */
public final class FirebaseExt {
    private static String TAG = FirebaseRemoteConfig.TAG;

    public static /* synthetic */ void updateRemoteConfig$default(FirebaseRemoteConfig firebaseRemoteConfig, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        updateRemoteConfig(firebaseRemoteConfig, function0);
    }

    public static final void updateRemoteConfig(FirebaseRemoteConfig firebaseRemoteConfig, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "<this>");
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener() { // from class: com.bedjet.bedjet.ext.FirebaseExtKt$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseExt.updateRemoteConfig$lambda$1(Function0.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRemoteConfig$lambda$1(Function0 function0, Task taskUpdate) {
        Intrinsics.checkNotNullParameter(taskUpdate, "taskUpdate");
        if (taskUpdate.isSuccessful()) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LoggerKt.logTag(TAG2, "Firebase remote config updated successfully.");
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        LoggerKt.logTag(TAG3, "Firebase remote config update failure.");
    }
}
