package com.bedjet.bedjet;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bedjet.bedjet.ext.FirebaseExt;
import com.bedjet.bedjet.p000di.di;
import com.bedjet.bedjet.utils.EnvironmentConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExt;
import org.koin.core.logger.Level;

/* compiled from: BedJetApplication.kt */
@Metadata(m942d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, m943d2 = {"Lcom/bedjet/bedjet/BedJetApplication;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "setupFirebaseRemoteConfig", "com.bedjet_1.0.6(18)_release"}, m944k = 1, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BedJetApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        DefaultContextExt.startKoin((Function1<? super KoinApplication, Unit>) new Function1() { // from class: com.bedjet.bedjet.BedJetApplication$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = BedJetApplication.onCreate$lambda$0(BedJetApplication.this, (KoinApplication) obj);
                return onCreate$lambda$0;
            }
        });
        setupFirebaseRemoteConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(BedJetApplication bedJetApplication, KoinApplication startKoin) {
        Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
        KoinExtKt.androidLogger(startKoin, Level.NONE);
        KoinExtKt.androidContext(startKoin, bedJetApplication);
        startKoin.modules(di.getAppModule());
        return Unit.INSTANCE;
    }

    private final void setupFirebaseRemoteConfig() {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setConfigSettingsAsync(RemoteConfigKt.remoteConfigSettings(new Function1() { // from class: com.bedjet.bedjet.BedJetApplication$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = BedJetApplication.setupFirebaseRemoteConfig$lambda$2$lambda$1((FirebaseRemoteConfigSettings.Builder) obj);
                return unit;
            }
        }));
        Intrinsics.checkNotNull(firebaseRemoteConfig);
        FirebaseExt.updateRemoteConfig$default(firebaseRemoteConfig, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFirebaseRemoteConfig$lambda$2$lambda$1(FirebaseRemoteConfigSettings.Builder remoteConfigSettings) {
        Intrinsics.checkNotNullParameter(remoteConfigSettings, "$this$remoteConfigSettings");
        remoteConfigSettings.setMinimumFetchIntervalInSeconds(EnvironmentConstants.FIREBASE_REMOTE_CONFIG_MINIMUM_FETCH_INTERVAL);
        return Unit.INSTANCE;
    }
}
