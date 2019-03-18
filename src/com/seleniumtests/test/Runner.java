/**
 *
 */
package com.seleniumtests.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Laxmi.Somni
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/com/seleniumtests/resources"}
        , format = {"pretty", "html:target/cucumber-html-report"}
        , glue = {"com.seleniumtests.test"}
        , tags = {"@cookieTest"}
)
public class Runner {
}
