package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public interface InstallIdProvider {
    InstallIds getInstallIds();

    /* loaded from: classes2.dex */
    public static abstract class InstallIds {
        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseAuthenticationToken();

        public abstract String getFirebaseInstallationId();

        public static InstallIds createWithoutFid(String str) {
            return new AutoValue_InstallIdProvider_InstallIds(str, null, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static InstallIds create(String str, FirebaseInstallationId firebaseInstallationId) {
            return new AutoValue_InstallIdProvider_InstallIds(str, firebaseInstallationId.getFid(), firebaseInstallationId.getAuthToken());
        }
    }
}
