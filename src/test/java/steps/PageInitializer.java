package steps;

import pages.HomePage;

public class PageInitializer {

    public static HomePage homepage;

    public static void initializePageObjects(){
        homepage = new HomePage();
    }
}
