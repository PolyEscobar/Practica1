package pages;

import Scripts.Commons;

public class CartPage {
    private final static String REMOVE_BUTTON = "//button[@id='remove-sauce-labs-backpack']";

    public static void clickOnRemoveButton(){
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON));
    }
}
