package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CheckoutPage extends CommonMethods {



    @FindBy(xpath = "//li[contains(@class, 'breadcrumb-item') and contains(@class, 'active') and text()='Checkout']")
    public WebElement breadCrumbs;


    public boolean isCheckoutBreadcrumbDisplayed() {
        return breadCrumbs.isDisplayed() && breadCrumbs.getText().equals("Checkout");
    }


    // Constructor to initialize all elements
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }


}
