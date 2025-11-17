package com.doda25.team11.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class VersionUtil {

    private static final String UNKNOWN = "UNKNOWN";
    private static final String RESOURCE_FILE = "/version.properties";
    private static final String POM_PROPERTIES_FILE =
            "/META-INF/maven/com.doda25.team11/lib-version/pom.properties";

    private static String cachedVersion;

    private VersionUtil() {
        // utility class
    }

    public static String getVersion() {
        if (cachedVersion == null) {
            cachedVersion = resolveVersion();
        }
        return cachedVersion;
    }

    private static String resolveVersion() {
        // 1) Try version.properties
        String v = loadFromResource(RESOURCE_FILE, "version");
        if (v != null && !v.isBlank()) {
            return v;
        }

        // 2) Fallback: try pom.properties (only available once jar is built)
        v = loadFromResource(POM_PROPERTIES_FILE, "version");
        if (v != null && !v.isBlank()) {
            return v;
        }

        // 3) If all else fails
        return UNKNOWN;
    }

    private static String loadFromResource(String path, String key) {
        Properties props = new Properties();
        try (InputStream in = VersionUtil.class.getResourceAsStream(path)) {
            if (in == null) {
                return null;
            }
            props.load(in);
            return props.getProperty(key);
        } catch (IOException e) {
            return null;
        }
    }
}
