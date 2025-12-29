package net.danlew.android.joda;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ResUtils {
    private static final String TZDATA_PREFIX = "joda_";
    private static Map<Class<?>, Map<String, Integer>> sIdentifierCache = new ConcurrentHashMap();

    private static String convertPathToResource(String path) {
        File file = new File(path);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("_");
            }
            stringBuffer.append((String) arrayList.get(size));
        }
        return stringBuffer.toString().replace('-', '_').replace("+", "plus").toLowerCase(Locale.US);
    }

    public static String getTzResource(String tzFile) {
        return TZDATA_PREFIX + convertPathToResource(tzFile);
    }

    public static String getZoneInfoMapResource() {
        return TZDATA_PREFIX + convertPathToResource("ZoneInfoMap");
    }

    public static int getIdentifier(Class<?> type, String name) {
        Map<String, Integer> map;
        if (!sIdentifierCache.containsKey(type)) {
            map = new ConcurrentHashMap<>();
            sIdentifierCache.put(type, map);
        } else {
            map = sIdentifierCache.get(type);
        }
        if (map.containsKey(name)) {
            return map.get(name).intValue();
        }
        try {
            int i = type.getField(name).getInt(null);
            if (i != 0) {
                map.put(name, Integer.valueOf(i));
            }
            return i;
        } catch (Exception e) {
            Log.e("JodaTimeAndroid", "Failed to retrieve identifier: type=" + type + " name=" + name, e);
            return 0;
        }
    }
}
