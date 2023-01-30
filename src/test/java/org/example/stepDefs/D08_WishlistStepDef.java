package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage wishList = new P03_homePage();

    @When("user clicks on heart button of product")
    public void userClicksOnHeartButtonOfProduct() {
        wishList.addToWishListBtn.click();
    }

    @Then("success message is displayed with green background")
    public void successMessageIsDisplayedWithGreenBackground() {
        SoftAssert soft = new SoftAssert();

        String actualMessage = wishList.successWishlistMessage.getText().toLowerCase();
        String expectedMessage = "has been added";
        soft.assertTrue(actualMessage.contains(expectedMessage));

        String actualColor = wishList.successWishlistMessageBackground.getCssValue("background-color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor, "#4bb07a");
        soft.assertAll();
    }

    @And("user clicks on wishlist button on top of home page")
    public void userClicksOnWishlistButtonOnTopOfHomePage() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(wishList.successWishlistMessage));

        wishList.wishListLink.click();
    }

    @Then("the added product should be found in the wishlist")
    public void theAddedProductShouldBeFoundInTheWishlist() {
        int actualValue = Integer.parseInt(wishList.wishlistQtyField.getAttribute("value"));

        Assert.assertTrue(actualValue > 0);

    }


}
