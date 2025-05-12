package utils;

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


}
