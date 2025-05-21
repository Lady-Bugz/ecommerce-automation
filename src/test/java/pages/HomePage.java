package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class HomePage extends CommonMethods {


    @FindBy(xpath = "//strong[contains(text(),'This is a dummy website for Web Automation Testing')]\n")
    public WebElement homePageText;

    @FindBy(xpath = "//a[@class='d-block' and @title='MPOW H12 RC Headphone']")
    public WebElement homePageProduct;

    @FindBy(xpath = "(//input[@name=\"search\"])[1]")
    public WebElement searchBar;

    // Search button element
    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;

    // Product grid container element
    @FindBy(css = "div[data-grid=\"product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6\"]")
    public WebElement productGrid;

    // List of individual products inside the product grid
    @FindBy(css = "div.product-layout")
    public List<WebElement> products;  // List of product elements

    // Since I look for the cart icon dynamically inside each product i don't need a single cartIcon locator here

    @FindBy(xpath = "//div[contains(@class, 'toast-body')]" )
    public WebElement cartPopUp;

    @FindBy(xpath = "//a[@class='btn btn-secondary btn-block']" )
    public WebElement checkoutButton;



    // Constructor to initialize all elements
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
