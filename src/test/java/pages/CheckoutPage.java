package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CheckoutPage extends CommonMethods {



    @FindBy(xpath = "//li[contains(@class, 'breadcrumb-item') and contains(@class, 'active') and text()='Checkout']")
    public WebElement breadCrumbs;

    @FindBy(xpath ="//input[@id='input-payment-firstname']")
    public WebElement firstNameField ;

    @FindBy(xpath ="//input[@id='input-payment-lastname']")
    public WebElement lastNameField ;

    @FindBy(xpath ="//input[@id='input-payment-email']")
    public WebElement emailField ;

    @FindBy(xpath ="//input[@id='input-payment-telephone']")
    public WebElement phoneNumberField ;

    @FindBy(xpath ="//input[@id='input-payment-password']")
    public WebElement passwordField ;

    @FindBy(xpath ="//input[@id='input-payment-confirm']")
    public WebElement confirmPasswordField ;

    @FindBy(xpath ="//input[@id='input-payment-company']")
    public WebElement companyField ;

    @FindBy(xpath ="//input[@id='input-payment-address-1']")
    public WebElement addressField ;

    @FindBy(xpath ="//input[@id='input-payment-city']")
    public WebElement cityField ;

    @FindBy(xpath ="//input[@id='input-payment-postcode']")
    public WebElement postCodeField ;

    @FindBy(xpath ="//select[@id='input-payment-country']")
    public WebElement countryField ;

    @FindBy(xpath ="//select[@id='input-payment-zone']")
    public WebElement stateField ;

    @FindBy(css ="label[for='input-newsletter']")
    public WebElement newsLetterCheckbox ;

    @FindBy(css ="label[for='input-account-agree']")
    public WebElement privacyPolicyCheckbox ;

    @FindBy(css ="label[for='input-agree']")
    public WebElement termsAndConditionCheckbox ;



    // Constructor to initialize all elements
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }


}
