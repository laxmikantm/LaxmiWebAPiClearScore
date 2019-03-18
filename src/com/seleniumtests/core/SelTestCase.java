package com.seleniumtests.core;
/* Laxmi Somni 2019 */

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniumtests.support.Helper;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class SelTestCase {

    protected WebDriver driver;
    public SoftAssert softAssert;
    protected ScreenRecorder src;

    public ExtentReports extent;
    public ExtentTest extentTest;

    @BeforeSuite
    @Parameters("browser")
    public void initalisation(@Optional("Chrome") String browser) throws IOException, AWTException {

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("FF")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Cloud")) {
            /*Connecting to BrowserStack*/
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "android");
            caps.setCapability("platform", "ANDROID");
            caps.setCapability("device", "Google Nexus 7");
            caps.setCapability("browserstack.debug", "true");

            driver = new RemoteWebDriver(
                    //TODO Note: Kindly replace below URL with the your team's Browserstack account key.
                    new URL("http://yyyyy:xxxxxxxxxxxxxx@hub.browserstack.com/wd/hub"),
                    caps
            );

        }

        softAssert = new SoftAssert();
        src = Helper.screenRecorderSetup();
        src.start();

    }

    @AfterSuite
    public void closeBrowser() throws IOException {
        src.stop();
        driver.close();
        driver.quit();
        softAssert.assertAll();
    }
}
