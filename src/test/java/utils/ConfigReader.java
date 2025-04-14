package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static Properties readProperties(String filePath) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return prop;

    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);

    }

     // Create a Logger instance for this class
//    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
//
//    public static Properties loadConfig(String filePath) throws IOException {
//        Properties properties = new Properties();
//        try (FileInputStream input = new FileInputStream(filePath)) {
//            properties.load(input);
//        } catch (IOException e) {
//            // Log the error with different levels of severity
//            logger.error("Error loading the configuration file: {}", filePath, e);
//            throw e; // rethrow the exception to handle it upstream
//        }
//        return properties;
//    }
//
//    public static void main(String[] args) {
//        try {
//            Properties config = loadConfig("resources/config/config.properties");
//            String url = config.getProperty("url");
//            System.out.println("URL: " + url);
//        } catch (IOException e) {
//            // Log the error at the error level
//            logger.error("Failed to read configuration", e);
//        }
//    }
}
