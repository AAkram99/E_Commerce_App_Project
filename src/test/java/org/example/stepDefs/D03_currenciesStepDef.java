package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();

    @When("select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrencyFromTheDropdownListOnTheTopLeftOfHomePage() {
        Select currencyList = new Select(home.currencyDropBox);
        currencyList.selectByVisibleText("Euro");
    }


    @Then("verify Euro Symbol \\(€) is shown on the four products displayed in Home page")
    public void useHardAssertionToVerifyEuroSymbol€IsShownOnTheProductsDisplayedInHomePage() {

        for(int i = 0 ; i < home.productPrice.size() ; i++){
            String visiblePrice =  home.productPrice.get(i).getText();
            //System.out.println(visiblePrice);
            Assert.assertTrue(visiblePrice.contains("€"));
        }

    }
}
