package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class ProductPurchaseSteps extends CommonMethods {


    @Given("user is navigated to the application")
    public void user_is_navigated_to_the_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user searches for a product")
    public void user_searches_for_a_product() {
        HomePage homepage = new HomePage();

        sendText(homepage.searchBar, ConfigReader.getPropertyValue("product"));
        click(homepage.searchButton);

    }
    @When("user hovers over the product and clicks add to cart")
    public void user_hovers_over_the_product_and_clicks_add_to_cart() {
        //locate the grid
        WebElement productGrid= driver.findElement(By.cssSelector("div[data-grid=\"product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6\"]"));
        // Get all the products elements
        List<WebElement> products = productGrid.findElements(By.cssSelector("div.product-layout"));

        // Check if there are at least 4 products
        if (products.size() >= 4) {
            try {
                // Get the 4th product (index 3)
                WebElement fourthProduct = products.get(3);

                hoverOverElement(driver, fourthProduct);

               WebElement cartIcon = fourthProduct.findElement(By.cssSelector("button.btn.btn-cart.cart-75"));
                click(cartIcon);

                System.out.println("Hovered over the 4th product");
            } catch (Exception e) {
                System.out.println("Error hovering over the 4th product: " + e.getMessage());
            }
        } else {
            System.out.println("There are less than 4 products in the grid.");
        }
    }

    @When("user proceeds to checkout from the pop-up displayed")
    public void user_proceeds_to_checkout_from_the_pop_up_displayed() {
        WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn btn-secondary btn-block']"));
                jsClick(checkOut);
    }
    @When("user fills in details")
    public void user_fills_in_details() {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-payment-firstname']"));
        sendText(firstName, ConfigReader.getPropertyValue("firstName"));

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-payment-lastname']"));
        sendText(lastName, ConfigReader.getPropertyValue("lastName"));

        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='input-payment-email']"));
        sendText(emailAddress, ConfigReader.getPropertyValue("emailAddress"));

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-payment-telephone']"));
        sendText(phone, ConfigReader.getPropertyValue("phone"));

        WebElement password = driver.findElement(By.xpath("//input[@id='input-payment-password']"));
        sendText(password,ConfigReader.getPropertyValue("password"));

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-payment-confirm']"));
        sendText(confirmPassword,ConfigReader.getPropertyValue("confirmPassword"));

        WebElement company = driver.findElement(By.xpath("//input[@id='input-payment-company']"));
        sendText(company,ConfigReader.getPropertyValue("company"));

        WebElement address = driver.findElement(By.xpath("//input[@id='input-payment-address-1']"));
        sendText(address,ConfigReader.getPropertyValue("address"));

        WebElement city = driver.findElement(By.xpath("//input[@id='input-payment-city']"));
        sendText(city,ConfigReader.getPropertyValue("city"));

        WebElement postcode = driver.findElement(By.xpath("//input[@id='input-payment-postcode']"));
        sendText(postcode,ConfigReader.getPropertyValue("postCode"));

       WebElement country = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
       String countryName = ConfigReader.getPropertyValue("country");
       selectDropdown(country,countryName);

        WebElement state = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        String stateName = ConfigReader.getPropertyValue("state");
       selectDropdown(state, stateName);

    }
    @When("user unchecks and checkmarks boxes")
    public void user_unchecks_and_checkmarks_boxes() {
        WebDriverWait wait = getWait();

        WebElement newsLetter = driver.findElement(By.cssSelector("label[for='input-newsletter']"));
        wait.until(ExpectedConditions.elementToBeClickable(newsLetter));
        click(newsLetter);

        WebElement privacyPolicy = driver.findElement(By.cssSelector("label[for='input-account-agree']"));
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy));
        click(privacyPolicy);

        WebElement termsAndConditions = driver.findElement(By.cssSelector("label[for='input-agree']"));
        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditions));
        click(termsAndConditions);

    }

    @Then("user completes the checkout process")
        public void user_can_complete_the_checkout_process () {
        WebElement continueButton = driver.findElement(By.id("button-save"));
        click(continueButton);

        WebElement confirmOrderButton = driver.findElement(By.id("button-confirm"));
        click(confirmOrderButton);

        WebElement continueBtn = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        click(continueBtn);

        }


}




