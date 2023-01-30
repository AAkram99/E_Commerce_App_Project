package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage(){
        register.registerLink.click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.maleRadioBtn.click();
    }

    @And("user enter first name {string} and last name {string} as first and last names")
    public void userEnterFirstNameAndLastNameAsFirstAndLastNames(String arg0, String arg1) {
        register.firstNameField.sendKeys(arg0);
        register.lastNameField.sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay = new Select(register.birthDayList);
        selectDay.selectByValue("26");

        Select selectMonth = new Select(register.birthMonthList);
        selectMonth.selectByValue("6");

        Select selectYear = new Select(register.birthYearList);
        selectYear.selectByValue("1999");
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.emailField.sendKeys(arg0);
    }

    @And("user fills Password fields {string} as password and confirmation password")
    public void userFillsPasswordFieldsAsPasswordAndConfirmationPassword(String arg0) {
        register.passwordField.sendKeys(arg0);
        register.confirmPasswordField.sendKeys(arg0);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerBtn.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successMessage.getText().toLowerCase().contains("registration completed"));

        String actualColor = register.successMessage.getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertTrue(actualColor.equals("#4cb17c"));

        soft.assertAll();
    }
}
