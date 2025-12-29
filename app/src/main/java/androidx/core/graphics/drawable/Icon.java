package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Icon.kt */
@Metadata(m942d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m943d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, m944k = 2, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.core.graphics.drawable.IconKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Icon {
    public static final android.graphics.drawable.Icon toAdaptiveIcon(Bitmap bitmap) {
        android.graphics.drawable.Icon createWithAdaptiveBitmap;
        createWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(bitmap);
        return createWithAdaptiveBitmap;
    }

    public static final android.graphics.drawable.Icon toIcon(Bitmap bitmap) {
        android.graphics.drawable.Icon createWithBitmap;
        createWithBitmap = android.graphics.drawable.Icon.createWithBitmap(bitmap);
        return createWithBitmap;
    }

    public static final android.graphics.drawable.Icon toIcon(Uri uri) {
        android.graphics.drawable.Icon createWithContentUri;
        createWithContentUri = android.graphics.drawable.Icon.createWithContentUri(uri);
        return createWithContentUri;
    }

    public static final android.graphics.drawable.Icon toIcon(byte[] bArr) {
        android.graphics.drawable.Icon createWithData;
        createWithData = android.graphics.drawable.Icon.createWithData(bArr, 0, bArr.length);
        return createWithData;
    }
}
