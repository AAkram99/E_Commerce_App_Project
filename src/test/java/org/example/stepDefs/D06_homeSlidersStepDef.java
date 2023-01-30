package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage homeSliders = new P03_homePage();

    @When("user clicks on slider {int}")
    public void user_clicks_on_slider(Integer sliderNumber) {
        homeSliders.slidersAtHome.get(sliderNumber).click();
    }

    @Then("assert that the page link is equal to {string} as actual link")
    public void assert_that_the_page_link_is_equal_to_as_actual_link(String expectedLink) {
        SoftAssert soft = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(WebDriver::getCurrentUrl);

        String actualLink = Hooks.driver.getCurrentUrl();
        soft.assertEquals(actualLink, expectedLink);
        soft.assertAll();
    }
}
