package androidx.core.graphics;

import android.graphics.ColorSpace;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Color.kt */
@Metadata(m942d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, m943d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, m944k = 2, m945mv = {1, 8, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.core.graphics.ColorKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Color {
    public static final int component1(int i) {
        return (i >> 24) & 255;
    }

    public static final int component2(int i) {
        return (i >> 16) & 255;
    }

    public static final int component3(int i) {
        return (i >> 8) & 255;
    }

    public static final int component4(int i) {
        return i & 255;
    }

    public static final int getAlpha(int i) {
        return (i >> 24) & 255;
    }

    public static final int getBlue(int i) {
        return i & 255;
    }

    public static final int getGreen(int i) {
        return (i >> 8) & 255;
    }

    public static final int getRed(int i) {
        return (i >> 16) & 255;
    }

    public static final float component1(android.graphics.Color color) {
        float component;
        component = color.getComponent(0);
        return component;
    }

    public static final float component2(android.graphics.Color color) {
        float component;
        component = color.getComponent(1);
        return component;
    }

    public static final float component3(android.graphics.Color color) {
        float component;
        component = color.getComponent(2);
        return component;
    }

    public static final float component4(android.graphics.Color color) {
        float component;
        component = color.getComponent(3);
        return component;
    }

    public static final android.graphics.Color plus(android.graphics.Color color, android.graphics.Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    public static final float getLuminance(int i) {
        float luminance;
        luminance = android.graphics.Color.luminance(i);
        return luminance;
    }

    public static final android.graphics.Color toColor(int i) {
        android.graphics.Color valueOf;
        valueOf = android.graphics.Color.valueOf(i);
        return valueOf;
    }

    public static final long toColorLong(int i) {
        long pack;
        pack = android.graphics.Color.pack(i);
        return pack;
    }

    public static final float component1(long j) {
        float red;
        red = android.graphics.Color.red(j);
        return red;
    }

    public static final float component2(long j) {
        float green;
        green = android.graphics.Color.green(j);
        return green;
    }

    public static final float component3(long j) {
        float blue;
        blue = android.graphics.Color.blue(j);
        return blue;
    }

    public static final float component4(long j) {
        float alpha;
        alpha = android.graphics.Color.alpha(j);
        return alpha;
    }

    public static final float getAlpha(long j) {
        float alpha;
        alpha = android.graphics.Color.alpha(j);
        return alpha;
    }

    public static final float getRed(long j) {
        float red;
        red = android.graphics.Color.red(j);
        return red;
    }

    public static final float getGreen(long j) {
        float green;
        green = android.graphics.Color.green(j);
        return green;
    }

    public static final float getBlue(long j) {
        float blue;
        blue = android.graphics.Color.blue(j);
        return blue;
    }

    public static final float getLuminance(long j) {
        float luminance;
        luminance = android.graphics.Color.luminance(j);
        return luminance;
    }

    public static final android.graphics.Color toColor(long j) {
        android.graphics.Color valueOf;
        valueOf = android.graphics.Color.valueOf(j);
        return valueOf;
    }

    public static final int toColorInt(long j) {
        int argb;
        argb = android.graphics.Color.toArgb(j);
        return argb;
    }

    public static final boolean isSrgb(long j) {
        boolean isSrgb;
        isSrgb = android.graphics.Color.isSrgb(j);
        return isSrgb;
    }

    public static final boolean isWideGamut(long j) {
        boolean isWideGamut;
        isWideGamut = android.graphics.Color.isWideGamut(j);
        return isWideGamut;
    }

    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace;
        colorSpace = android.graphics.Color.colorSpace(j);
        return colorSpace;
    }

    public static final long convertTo(int i, ColorSpace.Named named) {
        ColorSpace colorSpace;
        long convert;
        colorSpace = ColorSpace.get(named);
        convert = android.graphics.Color.convert(i, colorSpace);
        return convert;
    }

    public static final long convertTo(int i, ColorSpace colorSpace) {
        long convert;
        convert = android.graphics.Color.convert(i, colorSpace);
        return convert;
    }

    public static final long convertTo(long j, ColorSpace.Named named) {
        ColorSpace colorSpace;
        long convert;
        colorSpace = ColorSpace.get(named);
        convert = android.graphics.Color.convert(j, colorSpace);
        return convert;
    }

    public static final long convertTo(long j, ColorSpace colorSpace) {
        long convert;
        convert = android.graphics.Color.convert(j, colorSpace);
        return convert;
    }

    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace.Named named) {
        ColorSpace colorSpace;
        android.graphics.Color convert;
        colorSpace = ColorSpace.get(named);
        convert = color.convert(colorSpace);
        return convert;
    }

    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace colorSpace) {
        android.graphics.Color convert;
        convert = color.convert(colorSpace);
        return convert;
    }

    public static final int toColorInt(String str) {
        return android.graphics.Color.parseColor(str);
    }
}
