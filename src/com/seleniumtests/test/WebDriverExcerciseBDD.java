/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.HomePage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Laxmi.Somni
 *
 */
public class WebDriverExcerciseBDD extends SelTestCase {
	HomePage homePage;


	@Before
	public void beforeScenario() throws IOException, AWTException {
		initalisation("Chrome");
	}

    @Given("^I am visiting the Clear Score website for first time$")
    public void firstTimeVisit() {
        homePage = new HomePage(driver);
    }

    @When("^I visit the Clear Score site for first time$")
    public void iVisitTheClearScoreSiteForFirstTime() {
	    homePage.navigateTo();

    }

    @Then("^Cookie mandate message should be shown$")
    public void cookieMandateMessageShouldBeShown()  {
        Assert.assertThat("Error Cookie manadate not shown",
                homePage.cookieMsgDisplayed(), is(equalTo(true)));
    }


    @And("^I accept cookie mandate message$")
    public void iAcceptCookieMandateMessage() {
        homePage.acceptCookies();
    }

    @Then("^cookie mandate cookie is set$")
    public void cookieMandateCookieIsSet()  {
        Assert.assertThat("Error in validating Cookie mandate cookie set in browser",
                homePage.isCookieSet(), is(equalTo(true)));
    }

    @And("^Cookie mandate message is no longer shown$")
    public void cookieMandateMessageIsNoLongerShown() throws Throwable {
        Assert.assertThat("Error Cookie manadate still shown",
                homePage.cookieMsgDisplayed(), is(equalTo(false)));
    }

    @After
    public void afterScenario() throws IOException {
	    super.closeBrowser();
    }
}
