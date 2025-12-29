package com.bedjet.bedjet.p001ui.main;

import android.os.Message;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.bedjet.bedjet.p001ui.main.p002v2.MessageType;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import timber.log.Timber;

/* compiled from: Logger.kt */
@Metadata(m942d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u00012\n\u0010\f\u001a\u00060\rj\u0002`\u000e\u001a\u0012\u0010\f\u001a\u00020\u00012\n\u0010\f\u001a\u00060\rj\u0002`\u000e\u001a\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, m943d2 = {"logMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "log", "message", "", "logTag", "tag", "logPressed", "where", "e", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "hexDump", "data", "", "com.bedjet_1.0.6(18)_release"}, m944k = 2, m945mv = {2, 0, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LoggerKt {
    public static final void logMessage(Message msg) {
        Object obj;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.obj instanceof byte[]) {
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr = (byte[]) obj2;
            String arrays = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            obj = arrays + ",  hexDump: " + hexDump(bArr);
        } else {
            obj = msg.obj;
        }
        log("MainActivity.handleMessage, msg.what = " + MessageType.INSTANCE.fromId(msg.what) + ", msg.obj = " + obj);
    }

    public static final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Timber.INSTANCE.mo1170d(message, new Object[0]);
        FirebaseCrashlytics.getInstance().log(message);
    }

    public static final void logTag(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(tag + ", " + message);
    }

    public static final void logPressed(String where) {
        Intrinsics.checkNotNullParameter(where, "where");
        log("Pressed: " + where);
    }

    /* renamed from: e */
    public static final void m516e(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Exception exc = exception;
        Timber.INSTANCE.mo1174e(exc);
        FirebaseCrashlytics.getInstance().recordException(exc);
    }

    public static final void exception(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        FirebaseCrashlytics.getInstance().recordException(exception);
    }

    public static final String hexDump(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int length = data.length;
        StringBuilder sb = new StringBuilder("length: ");
        sb.append(length);
        sb.append("; body:");
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - 1;
            if (length != 0) {
                int i4 = i + 1;
                if (i == 0) {
                    sb.append(" ");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%04x", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    sb.append(format);
                }
                sb.append(" ");
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                int i5 = i2 + 1;
                String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(data[i2])}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                sb.append(format2);
                if (i4 >= 16) {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                    return sb2;
                }
                i2 = i5;
                i = i4;
                length = i3;
            } else {
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                return sb3;
            }
        }
    }
}
