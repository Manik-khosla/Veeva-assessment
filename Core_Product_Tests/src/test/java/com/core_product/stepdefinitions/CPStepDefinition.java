package com.core_product.stepdefinitions;

import com.core_product.setup.CPBaseSetup;
import com.veeva_automation_framework.configurations.AppConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CPStepDefinition extends CPBaseSetup{
	
	@Before
	public void init() {
		super.initTestSetup();
	}
	
	@Given("user is on core product home page")
	public void user_is_on_core_product_home_page() {
    driver.get(AppConfig.getConfiguration().getString("conf.url"));
	}
	
	@When("user selects {string} from  NavigationBar")
	public void user_selects_from_navigation_bar(String menuOption) {
		cpHomePage.AcceptCookies();
		cpHomePage.HoverOnMenuOption(menuOption);    
	}
	
	@When("select {string} Category")
	public void select_category(String category) {
		cpHomePage.selectCategory(category);	    
	}
	
	@When("Filters By {string}")
	public void filters_by(String department) {
	   productPage.FilterProducts(department);
	}

	@Then("All {string} are displayed")
	public void all_are_displayed(String department) {
	productPage.getInfoOf(department); 	                   
	}
	
	@Then("All {string} upto {string} are displayed")
	public void all_videos_upto_are_displayed(String type, String days) {
	  newsPage.getVideoInfo(days);
	}
	   

	@After
	public void teardown() {
		super.tearDown();
	}
}
