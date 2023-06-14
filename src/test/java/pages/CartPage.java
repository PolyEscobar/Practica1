package pages;

import Scripts.Commons;

public class CartPage {
    private final static String REMOVE_BUTTON = "//button[@id='remove-sauce-labs-backpack']";
    private final static String CHECKOUT_BUTTON = "//button[@id='checkout']";


    public static void clickOnRemoveButton(){
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON));
    }
    public static void clickOnCheckoutButton(){
        Commons.click(Commons.findElementByXpath(CHECKOUT_BUTTON));
    }

}
