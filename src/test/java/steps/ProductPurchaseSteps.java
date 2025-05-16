package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;


import java.time.Duration;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class ProductPurchaseSteps extends CommonMethods {


    @Given("user is navigated to the application")
    public void user_is_navigated_to_the_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user searches for a product")
    public void user_searches_for_a_product() {
        String searchTerm = ConfigReader.getPropertyValue("product");

        // Perform the search action
        sendText(homepage.searchBar, searchTerm);
        click(homepage.searchButton);

        // Use the EXPLICIT_WAIT constant from Constants
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(homepage.productGrid));
        wait.until(ExpectedConditions.visibilityOfAllElements(homepage.products));

        // Assert that the product grid is displayed
        assertTrue("Product grid is not visible", homepage.productGrid.isDisplayed());

        // Assert that the product grid has at least 4 products
        assertTrue("Product grid does not contain enough products", homepage.products.size() >= 4);

    }

    @When("user hovers over the product and clicks add to cart")
    public void user_hovers_over_the_product_and_clicks_add_to_cart() {
        try {
            if (homepage.products.size() >= 4) {
                // Get the 4th product (index 3)
                WebElement fourthProduct = homepage.products.get(3);
                hoverOverElement(driver, fourthProduct);

                // Find the cart icon inside the 4th product and click on it
                WebElement cartIcon = fourthProduct.findElement(By.cssSelector("button.btn.btn-cart.cart-75"));
                click(cartIcon);

                System.out.println("Hovered over the 4th product and clicked the cart icon.");
            } else {
                System.out.println("There are fewer than 4 products in the grid.");
            }
        } catch (NoSuchElementException e) {
            fail("Element not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Error interacting with the 4th product: " + e.getMessage());
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




