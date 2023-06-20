package pages;

import Scripts.Commons;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private final static String FIRST_NAME_INPUT = "//input[@id='first-name']";
    private final static String LAST_NAME_INPUT = "//input[@id='last-name']";
    private final static String POST_CODE_INPUT = "//input[@id='postal-code']";
    private final static String USER_DATA_GENERIC_XPATH = "//input[@id='%s']";
    private final static String CONTINUE_BUTTON = "//input[@id='continue']";
    private final static String FINISH_BUTTON = "//button[@id='finish']";
    private final static String MESSAGE_ERROR = "//h3[@data-test='error']";
    private final static String PRODUCT_NAME = "//div[@class='inventory_item_name']";

    public static void fieldsCamps(String id, String value){
        Commons.setText(Commons.findElementByXpath(String.format(USER_DATA_GENERIC_XPATH, id)), value);
    }
    public static void clickOnContinueButton(){
        Commons.click(Commons.findElementByXpath(CONTINUE_BUTTON));
    }
    public static void clickOnFinishButton(){
        Commons.click(Commons.findElementByXpath(FINISH_BUTTON));
    }

    public static void enterFistLastPostal(String firstName, String lastName, String postal){
        Commons.setText(Commons.findElementByXpath(FIRST_NAME_INPUT), firstName);
        Commons.setText(Commons.findElementByXpath(LAST_NAME_INPUT), lastName);
        Commons.setText(Commons.findElementByXpath(POST_CODE_INPUT), postal);
    }

    public static boolean showErrorMessage(String errorMessage){
        return(Commons.getText(Commons.findElementByXpath(MESSAGE_ERROR)).matches(errorMessage));
    }

    public static boolean checkProductName(String product){
        return(Commons.getText(Commons.findElementByXpath(PRODUCT_NAME)).matches(product));
    }

    public static boolean checkTheNames(String firstProduct){
        //Commons.getText(Commons.findElementByXpath(String.format(PRODUCT_NAME, firstProduct)));
        List<WebElement> lista = Commons.findElementsByXpath(PRODUCT_NAME);
        for(WebElement nameProducts : lista){
            String name = nameProducts.getText();
            if(name.matches(firstProduct)){
                return true;
            }
        }
        return false;
    }
}
