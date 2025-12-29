package com.bedjet.bedjet.utils;

/* loaded from: classes.dex */
public class Logger {
    /* renamed from: e */
    public static void m517e(Object obj, String str) {
    }

    /* renamed from: e */
    public static void m518e(Object obj, String str, Exception exc) {
    }

    /* renamed from: i */
    public static void m519i(Object obj, String str) {
    }

    /* renamed from: v */
    public static void m520v(Object obj, String str) {
    }

    /* renamed from: w */
    public static void m521w(Object obj, String str) {
    }

    /* renamed from: w */
    public static void m522w(Object obj, String str, Exception exc) {
    }

    private static String getClassName(Object obj) {
        String name = obj.getClass().getName();
        int lastIndexOf = name.lastIndexOf(".") + 1;
        if (lastIndexOf < 0) {
            lastIndexOf = 0;
        }
        String substring = name.substring(lastIndexOf);
        int lastIndexOf2 = substring.lastIndexOf("$");
        return lastIndexOf2 > 0 ? substring.substring(0, lastIndexOf2) : substring;
    }
}
