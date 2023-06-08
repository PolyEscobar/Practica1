package StepDefinitions;


import Scripts.Commons;
import Scripts.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Properties;


public class LoginStepDefs {
    private final static Properties KEY_PROPERTIES = Configuration.KEY_PROPERTIES_FILE;

    @Given("The user visit the sauce page")
    public void navigateToSauceDemoPage(){
        Commons.navigateTo("https://www.saucedemo.com");
    }

    @When("^The user type username: '(.*)' and password: '(.*)'$")
    public void enterUserPassw(String user, String password){
        LoginPage.enterUserPassw(user, password);
    }

    @When("The user click on login button")
    public void buttonClick(){
        LoginPage.onClickButton();
    }

    @Then("^a message is displayed with the text '(.*)'$")
    public void errorIsDisplayed(String errorMessage){
        String message = KEY_PROPERTIES.getProperty(errorMessage);
        Assert.assertTrue("The message is not correct",LoginPage.showErrorMessage(message));
    }

    @Then("user is logged")
    public void isLogged(){
        HomePage.clickOnMenuButton();
        Assert.assertTrue("The user is not logged", HomePage.verifyLogOutButton());
    }

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
}