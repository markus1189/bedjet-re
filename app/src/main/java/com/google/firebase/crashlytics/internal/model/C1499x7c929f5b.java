package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal */
/* loaded from: classes2.dex */
final class C1499x7c929f5b extends CrashlyticsReport.Session.Event.Application.Execution.Signal {
    private final long address;
    private final String code;
    private final String name;

    private C1499x7c929f5b(String str, String str2, long j) {
        this.name = str;
        this.code = str2;
        this.address = j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public String getCode() {
        return this.code;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public long getAddress() {
        return this.address;
    }

    public String toString() {
        return "Signal{name=" + this.name + ", code=" + this.code + ", address=" + this.address + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        return this.name.equals(signal.getName()) && this.code.equals(signal.getCode()) && this.address == signal.getAddress();
    }

    public int hashCode() {
        int hashCode = (((this.name.hashCode() ^ 1000003) * 1000003) ^ this.code.hashCode()) * 1000003;
        long j = this.address;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder */
    /* loaded from: classes2.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {
        private long address;
        private String code;
        private String name;
        private byte set$0;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.name = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.code = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long j) {
            this.address = j;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal build() {
            String str;
            String str2;
            if (this.set$0 != 1 || (str = this.name) == null || (str2 = this.code) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.name == null) {
                    sb.append(" name");
                }
                if (this.code == null) {
                    sb.append(" code");
                }
                if ((1 & this.set$0) == 0) {
                    sb.append(" address");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new C1499x7c929f5b(str, str2, this.address);
        }
    }
}
