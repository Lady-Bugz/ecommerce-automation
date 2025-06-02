package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class OrderConfirmationPage extends CommonMethods {

    @FindBy(id = "button-save")
    public WebElement continueButton;

    @FindBy(id = "button-confirm")
    public WebElement confirmOrderButton;

    @FindBy(id = "//a[normalize-space()='Continue']")
    public WebElement continueButn;


    public OrderConfirmationPage(){
        PageFactory.initElements(driver, this);
    }
}
