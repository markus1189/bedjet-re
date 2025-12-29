package org.koin.core.registry;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.koin.core.Koin;
import org.koin.core.error.NoPropertyFileFoundException;

/* compiled from: PropertyRegistryExt.kt */
@Metadata(m942d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, m943d2 = {"readDataFromFile", "Ljava/util/Properties;", FirebaseAnalytics.Param.CONTENT, "", "loadEnvironmentProperties", "", "Lorg/koin/core/registry/PropertyRegistry;", "loadPropertiesFromFile", "fileName", "saveProperties", "properties", "koin-core"}, m944k = 2, m945mv = {1, 9, 0}, m947xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: org.koin.core.registry.PropertyRegistryExtKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PropertyRegistryExt {
    public static final void saveProperties(PropertyRegistry propertyRegistry, Properties properties) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        propertyRegistry.get_koin().getLogger().debug("load " + properties.size() + " properties");
        Map map = MapsKt.toMap(properties);
        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        for (Map.Entry entry : map.entrySet()) {
            propertyRegistry.saveProperty$koin_core((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static final void loadPropertiesFromFile(PropertyRegistry propertyRegistry, String fileName) {
        String str;
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        propertyRegistry.get_koin().getLogger().debug("load properties from " + fileName);
        URL resource = Koin.class.getResource(fileName);
        if (resource != null) {
            str = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        } else {
            str = null;
        }
        if (str != null) {
            propertyRegistry.get_koin().getLogger().info("loaded properties from file:'" + fileName + '\'');
            saveProperties(propertyRegistry, readDataFromFile(str));
            return;
        }
        throw new NoPropertyFileFoundException("No properties found for file '" + fileName + '\'');
    }

    private static final Properties readDataFromFile(String str) {
        Properties properties = new Properties();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        properties.load(new ByteArrayInputStream(bytes));
        return properties;
    }

    public static final void loadEnvironmentProperties(PropertyRegistry propertyRegistry) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        propertyRegistry.get_koin().getLogger().debug("load properties from environment");
        Properties properties = System.getProperties();
        Intrinsics.checkNotNull(properties);
        saveProperties(propertyRegistry, properties);
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNullExpressionValue(map, "getenv(...)");
        Properties properties2 = new Properties();
        properties2.putAll(map);
        saveProperties(propertyRegistry, properties2);
    }
}
