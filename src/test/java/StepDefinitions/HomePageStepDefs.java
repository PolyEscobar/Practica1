package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;

public class HomePageStepDefs {
    @Then("The user click on add to cart button")
    public void addToCart() throws InterruptedException {
        HomePage.clickOnAddToCartButton();
        Thread.sleep(1000);
    }

    @Then("The user click on cart button")
    public void cartButton() throws InterruptedException {
        HomePage.clickOnCartButton();
        Thread.sleep(500);
    }

    @Then("The user click on remove button")
    public void removeButton() throws InterruptedException {
        CartPage.clickOnRemoveButton();
        Thread.sleep(500);
    }

    @When("^The user add the product '(.*)' to cart$")
    public void addProduct(String product){
        HomePage.addProductToCart(product);
    }

    @Then("^the user verifies that there are '(.*)' pop up products in the cart$")
    public void verifyThePopUpCart(String quantity){
    //Assert.assertTrue("Error: the pop up don't have the correct value", HomePage.verifyPopUpCart(quantity));
        String actualValue = HomePage.getProductsPopUpCart();
        String expectedValue = quantity;
        Assert.assertTrue("Error: the pop up don't have the correct value. \n Actual Value:" + actualValue + "\n Expected Value:" +expectedValue, actualValue.equals(expectedValue));
    }

    @Then("^the user verifies if the button of '(.*)' have been changed to remove button$")
    public void verifyRemoveButton(String product){
        Assert.assertTrue("Error: The text is not as expected", HomePage.getTitleButtonRemove(product));
    }

    @Then("^the user verifies if the button of '(.*)' have been changed to remove color$")
    public void verifyButtonColor(String product){
        Assert.assertTrue("Error: The color is not the expected", HomePage.getColorButtonRemove(product));
    }
}
