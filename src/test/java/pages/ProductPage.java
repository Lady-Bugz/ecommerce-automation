package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProductPage extends CommonMethods {


    @FindBy(xpath = "(//button[contains(@class, 'btn-cart') and @title='Add to Cart'])[2]")
    public WebElement addToCartButton;


    // Constructor to initialize all elements
    public ProductPage(){
        PageFactory.initElements(driver, this);
    }


}

