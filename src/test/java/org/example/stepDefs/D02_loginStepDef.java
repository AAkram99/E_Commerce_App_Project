package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goLoginPage(){
        login.loginLink.click();
    }

    @When("user login with {string} {string} and {string} as email and password")
    public void userLoginWithAndAsEmailAndPassword(String arg0, String arg1, String arg2) {
        login.emailField.sendKeys(arg1);
        login.passwordField.sendKeys(arg2);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();

        String actualUrl = Hooks.driver.getCurrentUrl();
        soft.assertTrue(actualUrl.equals("https://demo.nopcommerce.com/"));

        soft.assertTrue(login.myAccountTab.isDisplayed());

        soft.assertAll();

    }


    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.errorMessage.getText().toLowerCase().contains("login was unsuccessful"));

        String actualColor = login.errorMessage.getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor, "#e4434b");

        soft.assertAll();
    }


}
