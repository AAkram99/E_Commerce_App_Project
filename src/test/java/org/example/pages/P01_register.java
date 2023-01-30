package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {
    public P01_register(){ PageFactory.initElements(Hooks.driver, this); }

    @FindBy(className = "ico-register")
    public WebElement registerLink;

    @FindBy(id="gender-male")
    public WebElement maleRadioBtn;

    @FindBy(id="FirstName")
    public WebElement firstNameField;

    @FindBy(id="LastName")
    public WebElement lastNameField;

    @FindBy(name="DateOfBirthDay")
    public WebElement birthDayList;

    @FindBy(name="DateOfBirthMonth")
    public WebElement birthMonthList;

    @FindBy(name="DateOfBirthYear")
    public WebElement birthYearList;

    @FindBy(id="Email")
    public WebElement emailField;

    @FindBy(id="Password")
    public WebElement passwordField;

    @FindBy(id="ConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(id="register-button")
    public WebElement registerBtn;

    @FindBy(className="result")
    public WebElement successMessage;
}
