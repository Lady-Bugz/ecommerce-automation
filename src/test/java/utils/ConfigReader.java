package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Create a Logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    public static Properties loadConfig(String filePath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            // Log the error with different levels of severity
            logger.error("Error loading the configuration file: {}", filePath, e);
            throw e; // rethrow the exception to handle it upstream
        }
        return properties;
    }

    public static void main(String[] args) {
        try {
            Properties config = loadConfig("resources/config/config.properties");
            String baseUrl = config.getProperty("baseUrl");
            System.out.println("Base URL: " + baseUrl);
        } catch (IOException e) {
            // Log the error at the error level
            logger.error("Failed to read configuration", e);
        }
    }
}
