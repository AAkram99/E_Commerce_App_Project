package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;


public class D05_hoverCategoriesStepDef {
    P03_homePage hoverCategories = new P03_homePage();
    private String subText;

    @When("user hovers on random main category")
    public void testing() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(hoverCategories.mainCategoriesMenu()).perform();

    }

    @And("user hovers on random sub category")
    public void userHoversOnRandomSubCategory() {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(hoverCategories.subCategoriesMenu()).perform();
    }

    @And("get text of the subCategory")
    public void getTextOfTheSubCategory() {
        subText = hoverCategories.subCategoriesMenu().getText().toLowerCase().trim();
    }

    @And("click on it")
    public void clickOnIt() {
        Actions action = new Actions(Hooks.driver);
        action.click(hoverCategories.subCategoriesMenu()).perform();

    }

    @Then("Assert that the page title is the same text you get from subCategory")
    public void assertThatThePageTitleIsTheSameTextYouGetFromSubCategory() {
        String actualText = hoverCategories.pageTitle.getText().toLowerCase().trim();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualText, subText);
        soft.assertAll();
    }
}
