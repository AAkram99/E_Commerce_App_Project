package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage followUs = new P03_homePage();

    @When("user opens facebook link")
    public void userOpensFacebookLink() {
        followUs.facebookLink.click();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String expectedNewTabLink) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList <String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));

        Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedNewTabLink);

    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        followUs.twitterLink.click();

    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        followUs.rssLink.click();

    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        followUs.youtubeLink.click();

    }


}
