package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;

public class ProductPurchaseSteps extends CommonMethods {


    @Given("user is navigated to the application")
    public void user_is_navigated_to_the_application() {
        openBrowserAndLaunchApplication();
    }
    
}
