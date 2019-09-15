package com.qa.runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/qa/features/DealMap.feature",
		glue = {"com/qa/stepdefinitions"},
		monochrome = true,
		dryRun = false,
		tags = {"@Reg"},
		plugin = {"pretty","html:target/HTMLReport"}
		)

public class TestRunner {

}
