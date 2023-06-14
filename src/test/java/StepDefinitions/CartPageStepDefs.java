package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;

public class CartPageStepDefs {
    @And("The user click on checkout button")
    public void clickCheckoutButton(){
        CartPage.clickOnCheckoutButton();
    }

    @And("The user type his personal data")
    public void enterUserData(DataTable dt){
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        for(Map<String, String> columns : rows) {
            String firstName = columns.get("firstName");
            String lastName = columns.get("lastName");
            String postal = columns.get("postal");
            Assert.assertTrue("Error: there is fields empty", CheckoutPage.enterFistLastPostal(firstName, lastName, postal));
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
}
