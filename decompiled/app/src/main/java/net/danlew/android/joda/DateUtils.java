package net.danlew.android.joda;

import android.content.Context;
import android.content.res.Resources;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;

/* loaded from: classes2.dex */
public class DateUtils {
    private static final DateTime EPOCH = new DateTime(0, DateTimeZone.UTC);
    public static final int FORMAT_ABBREV_ALL = 524288;
    public static final int FORMAT_ABBREV_MONTH = 65536;
    public static final int FORMAT_ABBREV_RELATIVE = 262144;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 32768;
    public static final int FORMAT_NO_MIDNIGHT = 2048;
    public static final int FORMAT_NO_MONTH_DAY = 32;
    public static final int FORMAT_NO_NOON = 512;
    public static final int FORMAT_NO_YEAR = 8;
    public static final int FORMAT_NUMERIC_DATE = 131072;
    public static final int FORMAT_SHOW_DATE = 16;
    public static final int FORMAT_SHOW_TIME = 1;
    public static final int FORMAT_SHOW_WEEKDAY = 2;
    public static final int FORMAT_SHOW_YEAR = 4;
    private static final int FORMAT_UTC = 8192;

    public static String formatDateTime(Context context, ReadablePartial time, int flags) {
        return android.text.format.DateUtils.formatDateTime(context, toMillis(time), flags | 8192);
    }

    public static String formatDateTime(Context context, ReadableInstant time, int flags) {
        return android.text.format.DateUtils.formatDateTime(context, toMillis(time), flags | 8192);
    }

    public static String formatDateRange(Context context, ReadablePartial start, ReadablePartial end, int flags) {
        return formatDateRange(context, toMillis(start), toMillis(end), flags);
    }

    public static String formatDateRange(Context context, ReadableInstant start, ReadableInstant end, int flags) {
        return formatDateRange(context, toMillis(start), toMillis(end), flags);
    }

    private static String formatDateRange(Context context, long startMillis, long endMillis, int flags) {
        if (startMillis != endMillis) {
            endMillis += 1000;
        }
        return android.text.format.DateUtils.formatDateRange(context, startMillis, endMillis, flags | 8192);
    }

    private static long toMillis(ReadablePartial time) {
        return time.toDateTime(EPOCH).getMillis();
    }

    private static long toMillis(ReadableInstant time) {
        return (time instanceof DateTime ? (DateTime) time : new DateTime(time)).withZoneRetainFields(DateTimeZone.UTC).getMillis();
    }

    public static String formatElapsedTime(ReadableDuration elapsedDuration) {
        return formatElapsedTime(null, elapsedDuration);
    }

    public static String formatElapsedTime(StringBuilder recycle, ReadableDuration elapsedDuration) {
        return android.text.format.DateUtils.formatElapsedTime(recycle, elapsedDuration.toDuration().toStandardSeconds().getSeconds());
    }

    public static boolean isToday(ReadablePartial time) {
        if (time.isSupported(DateTimeFieldType.dayOfMonth()) && time.isSupported(DateTimeFieldType.monthOfYear()) && time.isSupported(DateTimeFieldType.year())) {
            return LocalDate.now().compareTo((ReadablePartial) (time instanceof LocalDate ? (LocalDate) time : new LocalDate(time))) == 0;
        }
        throw new IllegalArgumentException("isToday() must be passed a ReadablePartial that supports day of month, month of year and year.");
    }

    public static boolean isToday(ReadableInstant time) {
        return LocalDate.now().compareTo((ReadablePartial) new LocalDate(time)) == 0;
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadablePartial time) {
        return getRelativeTimeSpanString(context, time.toDateTime(DateTime.now()));
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadableInstant time) {
        return getRelativeTimeSpanString(context, time, 65556);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadablePartial time, int flags) {
        return getRelativeTimeSpanString(context, time.toDateTime(DateTime.now()), flags);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadableInstant time, int flags) {
        long days;
        int i;
        boolean z = (786432 & flags) != 0;
        DateTime withMillisOfSecond = DateTime.now(time.getZone()).withMillisOfSecond(0);
        DateTime withMillisOfSecond2 = new DateTime(time).withMillisOfSecond(0);
        boolean isBefore = withMillisOfSecond.isBefore(withMillisOfSecond2);
        Interval interval = !isBefore ? new Interval(withMillisOfSecond2, withMillisOfSecond) : new Interval(withMillisOfSecond, withMillisOfSecond2);
        if (Minutes.minutesIn(interval).isLessThan(Minutes.ONE)) {
            days = Seconds.secondsIn(interval).getSeconds();
            if (isBefore) {
                if (z) {
                    i = C1646R.plurals.joda_time_android_abbrev_in_num_seconds;
                } else {
                    i = C1646R.plurals.joda_time_android_in_num_seconds;
                }
            } else if (z) {
                i = C1646R.plurals.joda_time_android_abbrev_num_seconds_ago;
            } else {
                i = C1646R.plurals.joda_time_android_num_seconds_ago;
            }
        } else if (Hours.hoursIn(interval).isLessThan(Hours.ONE)) {
            days = Minutes.minutesIn(interval).getMinutes();
            if (isBefore) {
                if (z) {
                    i = C1646R.plurals.joda_time_android_abbrev_in_num_minutes;
                } else {
                    i = C1646R.plurals.joda_time_android_in_num_minutes;
                }
            } else if (z) {
                i = C1646R.plurals.joda_time_android_abbrev_num_minutes_ago;
            } else {
                i = C1646R.plurals.joda_time_android_num_minutes_ago;
            }
        } else if (Days.daysIn(interval).isLessThan(Days.ONE)) {
            days = Hours.hoursIn(interval).getHours();
            if (isBefore) {
                if (z) {
                    i = C1646R.plurals.joda_time_android_abbrev_in_num_hours;
                } else {
                    i = C1646R.plurals.joda_time_android_in_num_hours;
                }
            } else if (z) {
                i = C1646R.plurals.joda_time_android_abbrev_num_hours_ago;
            } else {
                i = C1646R.plurals.joda_time_android_num_hours_ago;
            }
        } else if (Weeks.weeksIn(interval).isLessThan(Weeks.ONE)) {
            days = Days.daysIn(interval).getDays();
            if (isBefore) {
                if (z) {
                    i = C1646R.plurals.joda_time_android_abbrev_in_num_days;
                } else {
                    i = C1646R.plurals.joda_time_android_in_num_days;
                }
            } else if (z) {
                i = C1646R.plurals.joda_time_android_abbrev_num_days_ago;
            } else {
                i = C1646R.plurals.joda_time_android_num_days_ago;
            }
        } else {
            return formatDateRange(context, time, time, flags);
        }
        return String.format(context.getResources().getQuantityString(i, (int) days), Long.valueOf(days));
    }

    public static CharSequence getRelativeTimeSpanString(Context ctx, ReadablePartial time, boolean withPreposition) {
        return getRelativeTimeSpanString(ctx, time.toDateTime(DateTime.now()), withPreposition);
    }

    public static CharSequence getRelativeTimeSpanString(Context ctx, ReadableInstant time, boolean withPreposition) {
        String formatDateRange;
        int i;
        LocalDate now = LocalDate.now();
        LocalDate localDate = new LocalDate(time);
        if (Days.daysBetween(now, localDate).getDays() == 0) {
            formatDateRange = formatDateRange(ctx, time, time, 1);
            i = C1646R.string.joda_time_android_preposition_for_time;
        } else if (Years.yearsBetween(now, localDate).getYears() != 0) {
            formatDateRange = formatDateRange(ctx, time, time, 131092);
            i = C1646R.string.joda_time_android_preposition_for_date;
        } else {
            formatDateRange = formatDateRange(ctx, time, time, 65552);
            i = C1646R.string.joda_time_android_preposition_for_date;
        }
        return withPreposition ? ctx.getString(i, formatDateRange) : formatDateRange;
    }

    public static CharSequence getRelativeDateTimeString(Context context, ReadablePartial time, ReadablePeriod transitionResolution, int flags) {
        if (!time.isSupported(DateTimeFieldType.hourOfDay()) || !time.isSupported(DateTimeFieldType.minuteOfHour())) {
            throw new IllegalArgumentException("getRelativeDateTimeString() must be passed a ReadablePartial that supports time, otherwise it makes no sense");
        }
        return getRelativeDateTimeString(context, time.toDateTime(DateTime.now()), transitionResolution, flags);
    }

    public static CharSequence getRelativeDateTimeString(Context context, ReadableInstant time, ReadablePeriod transitionResolution, int flags) {
        Duration durationFrom;
        Resources resources = context.getResources();
        DateTime withMillisOfSecond = DateTime.now(time.getZone()).withMillisOfSecond(0);
        DateTime withMillisOfSecond2 = new DateTime(time).withMillisOfSecond(0);
        boolean isBefore = withMillisOfSecond.isBefore(withMillisOfSecond2);
        Duration duration = !isBefore ? new Duration(withMillisOfSecond2, withMillisOfSecond) : new Duration(withMillisOfSecond, withMillisOfSecond2);
        Duration durationTo = Days.ONE.toPeriod().toDurationTo(withMillisOfSecond2);
        if (transitionResolution != null) {
            if (!isBefore) {
                durationFrom = transitionResolution.toPeriod().toDurationTo(withMillisOfSecond);
            } else {
                durationFrom = transitionResolution.toPeriod().toDurationFrom(withMillisOfSecond);
            }
            Duration durationTo2 = Weeks.ONE.toPeriod().toDurationTo(withMillisOfSecond2);
            if (durationFrom.isLongerThan(durationTo2)) {
                durationTo = durationTo2;
            } else if (!durationFrom.isShorterThan(durationTo)) {
                durationTo = durationFrom;
            }
        }
        String formatDateRange = formatDateRange(context, time, time, 1);
        if (duration.isLongerThan(durationTo)) {
            return resources.getString(C1646R.string.joda_time_android_date_time, getRelativeTimeSpanString(context, time, false), formatDateRange);
        }
        return resources.getString(C1646R.string.joda_time_android_relative_time, getRelativeTimeSpanString(context, time, flags), formatDateRange);
    }

    public static CharSequence formatDuration(Context context, ReadableDuration readableDuration) {
        Resources resources = context.getResources();
        Duration duration = readableDuration.toDuration();
        int standardHours = (int) duration.getStandardHours();
        if (standardHours != 0) {
            return resources.getQuantityString(C1646R.plurals.joda_time_android_duration_hours, standardHours, Integer.valueOf(standardHours));
        }
        int standardMinutes = (int) duration.getStandardMinutes();
        if (standardMinutes != 0) {
            return resources.getQuantityString(C1646R.plurals.joda_time_android_duration_minutes, standardMinutes, Integer.valueOf(standardMinutes));
        }
        int standardSeconds = (int) duration.getStandardSeconds();
        return resources.getQuantityString(C1646R.plurals.joda_time_android_duration_seconds, standardSeconds, Integer.valueOf(standardSeconds));
    }
}
