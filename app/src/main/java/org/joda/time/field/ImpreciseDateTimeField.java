package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public abstract class ImpreciseDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 7190739608550251860L;
    private final DurationField iDurationField;
    final long iUnitMillis;

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract long add(long j, int i);

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract long add(long j, long j2);

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract int get(long j);

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract DurationField getRangeDurationField();

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract long roundFloor(long j);

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public abstract long set(long j, int i);

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j) {
        super(dateTimeFieldType);
        this.iUnitMillis = j;
        this.iDurationField = new LinkedDurationField(dateTimeFieldType.getDurationType());
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int getDifference(long j, long j2) {
        return FieldUtils.safeToInt(getDifferenceAsLong(j, j2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (add(r12, r0) > r10) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (add(r12, r0) > r10) goto L19;
     */
    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getDifferenceAsLong(long r10, long r12) {
        /*
            r9 = this;
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 >= 0) goto La
            long r10 = r9.getDifferenceAsLong(r12, r10)
            long r10 = -r10
            return r10
        La:
            long r0 = r10 - r12
            long r2 = r9.iUnitMillis
            long r0 = r0 / r2
            long r2 = r9.add(r12, r0)
            r4 = 1
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 >= 0) goto L26
        L19:
            long r2 = r0 + r4
            long r6 = r9.add(r12, r2)
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 <= 0) goto L24
            goto L37
        L24:
            r0 = r2
            goto L19
        L26:
            long r2 = r9.add(r12, r0)
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 <= 0) goto L37
        L2e:
            long r0 = r0 - r4
            long r2 = r9.add(r12, r0)
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 > 0) goto L2e
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.field.ImpreciseDateTimeField.getDifferenceAsLong(long, long):long");
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public final DurationField getDurationField() {
        return this.iDurationField;
    }

    protected final long getDurationUnitMillis() {
        return this.iUnitMillis;
    }

    /* loaded from: classes2.dex */
    private final class LinkedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -203813474600094134L;

        @Override // org.joda.time.DurationField
        public boolean isPrecise() {
            return false;
        }

        LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        @Override // org.joda.time.DurationField
        public long getUnitMillis() {
            return ImpreciseDateTimeField.this.iUnitMillis;
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.DurationField
        public int getValue(long j, long j2) {
            return ImpreciseDateTimeField.this.getDifference(j + j2, j2);
        }

        @Override // org.joda.time.DurationField
        public long getValueAsLong(long j, long j2) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j + j2, j2);
        }

        @Override // org.joda.time.DurationField
        public long getMillis(int i, long j) {
            return ImpreciseDateTimeField.this.add(j, i) - j;
        }

        @Override // org.joda.time.DurationField
        public long getMillis(long j, long j2) {
            return ImpreciseDateTimeField.this.add(j2, j) - j2;
        }

        @Override // org.joda.time.DurationField
        public long add(long j, int i) {
            return ImpreciseDateTimeField.this.add(j, i);
        }

        @Override // org.joda.time.DurationField
        public long add(long j, long j2) {
            return ImpreciseDateTimeField.this.add(j, j2);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.DurationField
        public int getDifference(long j, long j2) {
            return ImpreciseDateTimeField.this.getDifference(j, j2);
        }

        @Override // org.joda.time.DurationField
        public long getDifferenceAsLong(long j, long j2) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j, j2);
        }
    }
}
