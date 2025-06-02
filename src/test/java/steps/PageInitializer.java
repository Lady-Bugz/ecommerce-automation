package steps;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderConfirmationPage;

public class PageInitializer {

    public static HomePage homePage;
    public static CheckoutPage checkoutPage;
    public static OrderConfirmationPage orderConfirmationPage;


    public static void initializePageObjects(){
        homePage = new HomePage();
        checkoutPage = new CheckoutPage();
        orderConfirmationPage =new OrderConfirmationPage();

    }
}
