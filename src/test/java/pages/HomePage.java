package pages;

import Scripts.Commons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class HomePage {
    private final static String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private final static String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    private final static String ADD_TO_CART_BUTTON =  "//button[@id='add-to-cart-sauce-labs-backpack']";
    private final static String CART_BUTTON = "//a[@class='shopping_cart_link']";
    private static String addCartGenericXpath = "//div[@class='inventory_item_label'][contains(.,'%s')]/following-sibling::div/button";
    private static String verifyPopUp2 = "//span[@class='shopping_cart_badge']";

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
    public static void addProductToCart(String product){
        Commons.click(Commons.findElementByXpath(String.format(addCartGenericXpath,product)));
    }

    /*
    public static boolean verifyPopUpNumber(int quantity){
        return(Commons.getText(Commons.findElementByXpath(popUpSpan)).matches(String.valueOf(quantity)));
    }
     */

    public static String getProductsPopUpCart(){
        return Commons.getText(Commons.findElementByXpath(verifyPopUp2));
    }

    public static boolean getTitleButtonRemove(String product){
        return Commons.getText(Commons.findElementByXpath(String.format(addCartGenericXpath, product))).matches("Remove");
    }

    public static boolean getColorButtonRemove(String product){
        WebElement buttonRemove = Commons.findElementByXpath(String.format(addCartGenericXpath, product));
        String colorRBGA = buttonRemove.getCssValue("color");
        String colorHEX = Color.fromString(colorRBGA).asHex();
        return colorHEX.equals("#e2231a");
    }
}