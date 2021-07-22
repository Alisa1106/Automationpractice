package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {
    private static String propertiesPath = "/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;

    private PropertyReader() {
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }

    /**
     * Read properties.
     *
     * @return the properties
     */
    public static Properties readProperties() {
        properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (properties.getProperty("config_file") != null) {
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties loadProperties() {
        return properties != null ? properties : readProperties();
    }

    /**
     * Gets properties.
     *
     * @param path the path
     * @return the properties
     */
    public static Properties getProperties(String path) {
        propertiesPath = path;
        return readProperties();
    }

    /**
     * Gets property.
     *
     * @param propertyName the property name
     * @return the property
     */
    public static String getProperty(String propertyName) {
        return loadProperties().getProperty(propertyName);
    }
}