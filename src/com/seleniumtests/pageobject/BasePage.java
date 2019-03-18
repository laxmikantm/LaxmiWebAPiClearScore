/**
 * Author: Laxmi Somni
 */
package com.seleniumtests.pageobject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.concurrent.TimeUnit;
public class BasePage {

    protected WebDriver driver;
    protected AppiumDriver appiumDriver;
    protected WebDriverWait myWait;


    //More Suitable for Android, and Hybrid Mobile app.
    public void customClick(By by) {
        appiumDriver.findElement(by).click();
    }

    //Here we just provide value ,so default is taken as Seconds
    public void customWait(int time) {
        appiumDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    //Here we provide both value of wait & timeUnit variants i.e. - Miliseconds, Seconds, Minutes etc..
    public void customWait(int time, TimeUnit timeUnit) {
        appiumDriver.manage().timeouts().implicitlyWait(time, timeUnit);
    }


    public String getPageURL(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }


    public String getPageTitle(WebDriver driver) {
        return driver
                .getTitle();

    }

    public WebDriver getWebDriver() {
        return driver;
    }

}