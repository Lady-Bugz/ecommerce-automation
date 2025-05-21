package steps;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

public class PageInitializer {

    public static HomePage homepage;
    public static CheckoutPage checkoutpage;
    public static ProductPage productpage;

    public static void initializePageObjects(){
        homepage = new HomePage();
        checkoutpage = new CheckoutPage();
        productpage =new ProductPage();
    }
}
