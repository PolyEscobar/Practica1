package pages;

import Scripts.Commons;

public class HomePage {
    private final static String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private final static String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    private final static String ADD_TO_CART_BUTTON =  "//button[@id='add-to-cart-sauce-labs-backpack']";
    private final static String CART_BUTTON = "//a[@class='shopping_cart_link']";

    public static void clickOnMenuButton(){
        Commons.click(Commons.findElementByXpath(BURGER_BUTTON));
    }
    public static boolean verifyLogOutButton(){
        return Commons.findElementIsDisplayed(
                Commons.findElementByXpath(LOGOUT_BUTTON)
        );
    }

    public static void clickOnAddToCartButton(){
        Commons.click(Commons.findElementByXpath(ADD_TO_CART_BUTTON));
    }

    public static void clickOnCartButton(){
        Commons.click(Commons.findElementByXpath(CART_BUTTON));
    }

}