package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class HomePage extends CommonMethods {

    @FindBy(xpath = "(//input[@name=\"search\"])[1]")
    public WebElement searchBar;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;

    @FindBy(css = "div[data-grid=\"product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6\"]")
    public WebElement productGrid;

    @FindBy(css = "div.product-layout")
    public WebElement product;


    @FindBy(css = "button.btn.btn-cart.cart-75")
    public WebElement cartIcon;

    public HomePage(){
        PageFactory.initElements(driver,this);

    }



}
