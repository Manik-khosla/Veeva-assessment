package com.dp1.stepdefinitions;

import com.core.configurations.AppConfig;
import com.dp1.setup.DP1BaseSetup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DP1HomePageStepDefinitions extends DP1BaseSetup{
	
	String url;
	
	@Before
	public void init() {
		super.initTestSetup();
	}
	
	@Given("Dp1Home page url")
	public void dp1home_page_url() {
	    url = AppConfig.getConfiguration().getString("conf.url");
	}

	@When("user goes to Dp1 home page")
	public void user_goes_to_page() {
	    driver.get(url);
	}

	@Then("Slides containing title {string} are displayed for duration {string}")
	public void slides_containing_title_are_displayed_for_duration(String title, String duration) {
	    dp1HomePage.validateSlideTitleAndDuration(title,duration);
	}
	
	@After
	public void teardown() {
		super.tearDown();
	}

}
