package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();
    
    @When("user enter {string} as search parameter")
    public void userEnterAsSearchParameter(String arg0) {
        search.searchField.sendKeys(arg0);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        search.searchBtn.click();
    }

    @Then("verify that the search page is opened and result contains the {string} word")
    public void verifyThatTheSearchPageIsOpenedAndResultContainsTheSearchWord(String arg0) {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));

        for(int i = 0 ; i < search.resultProductsTitle.size() ; i++){
            String productName = search.resultProductsTitle.get(i).getText().toLowerCase();
            soft.assertTrue(productName.contains(arg0),"parameter ("+i+") does not has "+arg0);
        }

        soft.assertAll();
        
    }

    @And("user clicks on the product in search page")
    public void userClicksOnTheProductInSearchPage() {
        search.resultProductsTitle.get(0).click();
    }

    @Then("verify that the sku in the product page is the same {string} you entered")
    public void verifyThatTheSkuInTheProductPageIsTheSameYouEntered(String arg0) {
        Assert.assertEquals(arg0, search.skuValue.getText());
    }
}
