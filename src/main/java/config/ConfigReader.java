package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {
        try (InputStream input =
             ConfigReader.class.getClassLoader()
                 .getResourceAsStream("config.properties")) {

            properties = new Properties();
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
