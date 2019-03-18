package com.seleniumtests.pageobject;

import com.seleniumtests.support.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage extends BasePage {

    private WebDriver driver;
    protected JavascriptExecutor jse;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory aFactory = new AjaxElementLocatorFactory(driver, 20);
        PageFactory.initElements(aFactory, this);
        jse = (JavascriptExecutor) driver;
    }

    public String getPageURL() {
        return super
                .getPageURL(driver);
    }

    public void navigateTo() {
        driver.get(Helper.BaseURL);
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public String getInnerHTML() {
        return driver.findElement(By.xpath("//body//noscript")).getAttribute("innerHTML");
    }

    public String returnTextSuggestion() {
//        return searchBox.getAttribute("placeholder");
        return "";
    }

    public boolean cookieMsgDisplayed() {
        return driver.findElements(Locators.COOKIE_MSG).size() > 0;
    }

    public void acceptCookies() {
        driver.findElement(Locators.ACCEPT_COOKIE).click();
    }

    public boolean isCookieSet() {
        return driver.manage().getCookieNamed("CS_ACCEPT_COOKIES").getValue().equalsIgnoreCase("true");
    }

    public static class Locators {
        private static final By COOKIE_MSG = By.cssSelector(".cs-cookie.show");
        private static final By ACCEPT_COOKIE = By.xpath("//span[contains(@class, 'accept-cookies')][text()='No problem']");
    }

}
