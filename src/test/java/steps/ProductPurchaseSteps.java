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
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class ProductPurchaseSteps extends CommonMethods {


    @Given("user is navigated to the application")
    public void user_is_navigated_to_the_application() {
        openBrowserAndLaunchApplication();

        assertTrue("Home Page is visible",homePage.homePageText.isDisplayed());
    }

    @When("user searches for a product")
    public void user_searches_for_a_product() {
        String searchTerm = ConfigReader.getPropertyValue("product");

        // Perform the search action
        sendText(homePage.searchBar, searchTerm);
        click(homePage.searchButton);

        // Use the EXPLICIT_WAIT constant from Constants
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(homePage.productGrid));
        wait.until(ExpectedConditions.visibilityOfAllElements(homePage.products));

        // Assert that the product grid is displayed
        assertTrue("Product grid is not visible", homePage.productGrid.isDisplayed());

        // Assert that the product grid has at least 4 products
        assertTrue("Product grid does not contain enough products", homePage.products.size() >= 4);

    }


    @When("user adds a product to cart")
    public void user_adds_a_product_to_cart() {
        try {
            if (homePage.products.size() >= 4) {
                // Get the 4th product (index 3)
                WebElement fourthProduct = homePage.products.get(3);
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

    @Then("verify cart contains product")
    public void verify_cart_contains_product() {

        String productName = ConfigReader.getPropertyValue("product");

        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(homePage.cartPopUp));

        String popUpText = homePage.cartPopUp.getText();
        if (!popUpText.contains(productName)) {
            throw new AssertionError("Pop-up did not contain product name: " + productName);
        }
        assertTrue("Cart pop-up is not displayed", homePage.cartPopUp.isDisplayed());

    }

    @When("user navigates to the checkout page")
    public void user_navigates_to_the_checkout_page() {
        jsClick(homePage.checkoutButton);

        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.urlContains("checkout"));

        boolean isDisplayed = checkoutPage.breadCrumbs.isDisplayed();
        boolean isTextCorrect = checkoutPage.breadCrumbs.getText().equals("Checkout");

        assertTrue("Checkout breadcrumb not displayed or incorrect", isDisplayed && isTextCorrect);
    }


    @When("user fills in checkout details")
    public void user_fills_in_checkout_details() {
        sendText(checkoutPage.firstNameField, ConfigReader.getPropertyValue("firstName"));

        sendText(checkoutPage.lastNameField, ConfigReader.getPropertyValue("lastName"));

        sendText(checkoutPage.emailField, ConfigReader.getPropertyValue("emailAddress"));

        sendText(checkoutPage.phoneNumberField, ConfigReader.getPropertyValue("phone"));

        sendText(checkoutPage.passwordField, ConfigReader.getPropertyValue("password"));

        sendText(checkoutPage.confirmPasswordField, ConfigReader.getPropertyValue("confirmPassword"));

        sendText(checkoutPage.companyField, ConfigReader.getPropertyValue("company"));

        sendText(checkoutPage.addressField, ConfigReader.getPropertyValue("address"));

        sendText(checkoutPage.cityField, ConfigReader.getPropertyValue("city"));

        sendText(checkoutPage.postCodeField, ConfigReader.getPropertyValue("postCode"));

       String countryName = ConfigReader.getPropertyValue("country");
       selectDropdown(checkoutPage.countryField, countryName);

        String stateName = ConfigReader.getPropertyValue("state");
       selectDropdown(checkoutPage.stateField, stateName);

    }
    @When("user unchecks and checkmarks boxes")
    public void user_unchecks_and_checkmarks_boxes() {
        WebDriverWait wait = getWait();


        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.newsLetterCheckbox));
        click(checkoutPage.newsLetterCheckbox);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.privacyPolicyCheckbox));
        click(checkoutPage.privacyPolicyCheckbox);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.termsAndConditionCheckbox));
        click(checkoutPage.termsAndConditionCheckbox);

    }

    @Then("user submits order")
        public void user_submits_order () {

        click(orderConfirmationPage.continueButton);

        click(orderConfirmationPage.confirmOrderButton);

        click(orderConfirmationPage.continueButn);

        }


}




