package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class P03_homePage {
    private Random rand = new Random();
    private int generatedInt1 = rand.nextInt(1, 4);
    private int generatedInt2 = rand.nextInt(1,4);
    String random1 = String.valueOf(generatedInt1);
    String random2 = String.valueOf(generatedInt2);

    public P03_homePage(){PageFactory.initElements(Hooks.driver, this);}

    @FindBy(css = "span[class=\"price actual-price\"]")
    public List <WebElement> productPrice;

    @FindBy(id="customerCurrency")
    public WebElement currencyDropBox;

    @FindBy(css = "input[name=\"q\"]")
    public WebElement searchField;

    @FindBy(css = "button[class=\"button-1 search-box-button\"]")
    public WebElement searchBtn;

    @FindBy(css = "h2[class=\"product-title\"] a")
    public List <WebElement> resultProductsTitle;

    @FindBy(css = "div[class=\"sku\"] span[class=\"value\"]")
    public WebElement skuValue;

    public WebElement mainCategoriesMenu()
    {
        WebElement mainCategoriesMenu =  Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+random1+"]"));
        return  mainCategoriesMenu;
    }

    public WebElement subCategoriesMenu(){
        WebElement subCategoriesMenu = Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+random1+"]/ul[@class=\"sublist first-level\"]/li["+random2+"]/a"));
        return subCategoriesMenu;
    }

    @FindBy(css = "div[class=\"page-title\"] h1")
    public WebElement pageTitle;

    @FindBy(xpath = "//div[@id=\"nivo-slider\"]/a[@class=\"nivo-imageLink\"]")
    public List <WebElement> slidersAtHome;

    @FindBy(css = "li[class=\"facebook\"] a")
    public WebElement facebookLink;

    @FindBy(css = "li[class=\"twitter\"] a")
    public WebElement twitterLink;

    @FindBy(css = "li[class=\"rss\"] a")
    public WebElement rssLink;

    @FindBy(css = "li[class=\"youtube\"] a")
    public WebElement youtubeLink;

    @FindBy(xpath = "//div[@class=\"item-grid\"]/div[3]/div/div/div/div[2]/button[3]")
    public WebElement addToWishListBtn;

    @FindBy(css = "span[class=\"wishlist-label\"]")
    public WebElement wishListLink;

    @FindBy(css = "div[class=\"bar-notification success\"] p")
    public WebElement successWishlistMessage;
    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement successWishlistMessageBackground;

    @FindBy(css = "input[class=\"qty-input\"]")
    public WebElement wishlistQtyField;



}
