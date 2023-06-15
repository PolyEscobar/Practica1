package StepDefinitions;

import Scripts.Configuration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CartPageStepDefs {
    private final static Properties KEY_PROPERTIES = Configuration.KEY_PROPERTIES_FILE;
    @And("The user click on checkout button")
    public void clickCheckoutButton(){
        CartPage.clickOnCheckoutButton();
    }

    @And("The user type his personal data")
    public void enterUserData(DataTable dt){
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
//        for(Map<String, String> columns : rows) {
//            String firstName = columns.get("firstName");
//            String lastName = columns.get("lastName");
//            String postal = columns.get("postal");
//            Assert.assertTrue("Error: there is fields empty", CheckoutPage.enterFistLastPostal(firstName, lastName, postal));
//        }
        for (Map<String, String> columns : rows) {
            String field = columns.get("fields");
            String userData = columns.get("user1");
            CheckoutPage.fieldsCamps(field, userData);
        }
    }

    @And("The user click on continue button")
    public void clickContinueButton(){
        CheckoutPage.clickOnContinueButton();
    }

    @Then("The user click on finish button")
    public void clickFinishButton(){
        CheckoutPage.clickOnFinishButton();
    }

    @And("^The user type his personal data '(.*)', '(.*)', '(.*)'$")
    public void enterUserData(String firstName, String lastName, String postal){
        CheckoutPage.enterFistLastPostal(firstName, lastName, postal);
    }

    @Then("^message is displayed with the text '(.*)'$")
    public void errorMessageDisplayed(String errorMessage){
        String message = KEY_PROPERTIES.getProperty(errorMessage);
        Assert.assertTrue("The message is not correct",CheckoutPage.showErrorMessage(message));
    }

    @Then("^The user check if the product name is '(.*)'$")
    public void checkProductName(String product){
        Assert.assertTrue("The product is not the desired", CheckoutPage.checkProductName(product));
    }
}
