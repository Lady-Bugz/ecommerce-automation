package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

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
        String value = prop.getProperty(key);

        // Check if the requested property is an email, if so, generate a dynamic one
        if ("emailAddress".equals(key)) {
            value = generateUniqueEmail();
        }

        return value;
    }

    // Generate a unique email for each test run using UUID
    private static String generateUniqueEmail() {
        String baseEmail = "jay6@test.com";  // Use a base email address
        String uniqueId = UUID.randomUUID().toString();  // Generate a unique UUID
        return baseEmail.replace("@", "+" + uniqueId + "@");  // Insert the unique ID into the email address
    }
}
