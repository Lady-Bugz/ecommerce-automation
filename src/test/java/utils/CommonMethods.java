package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;


    public static void openBrowserAndLaunchApplication() {
        try {
            ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");//in case i mistakenly type an invalid browser

        }
        //to launch the application
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

    }
}
