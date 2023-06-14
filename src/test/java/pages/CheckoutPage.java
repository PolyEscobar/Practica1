package pages;

import Scripts.Commons;

public class CheckoutPage {
    private final static String FIRST_NAME_INPUT = "//input[@id='first-name']";
    private final static String LAST_NAME_INPUT = "//input[@id='last-name']";
    private final static String POST_CODE_INPUT = "//input[@id='postal-code']";
    private final static String CONTINUE_BUTTON = "//input[@id='continue']";
    private final static String FINISH_BUTTON = "//button[@id='finish']";

    public static boolean enterFistLastPostal(String firstName, String lastName, String postal){
        Commons.setText(Commons.findElementByXpath(FIRST_NAME_INPUT), firstName);
        Commons.setText(Commons.findElementByXpath(LAST_NAME_INPUT), lastName);
        Commons.setText(Commons.findElementByXpath(POST_CODE_INPUT), postal);

        // Verificar si los datos se ingresaron correctamente
        boolean enteredSuccessfully = !firstName.isEmpty() && !lastName.isEmpty() && !postal.isEmpty();

        return enteredSuccessfully;
    }
    public static void clickOnContinueButton(){
        Commons.click(Commons.findElementByXpath(CONTINUE_BUTTON));
    }
    public static void clickOnFinishButton(){
        Commons.click(Commons.findElementByXpath(FINISH_BUTTON));
    }
}
