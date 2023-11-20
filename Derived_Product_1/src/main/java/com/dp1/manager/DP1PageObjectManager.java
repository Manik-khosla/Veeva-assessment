package com.dp1.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dp1.pageobjects.DP1HomePage;

public class DP1PageObjectManager {
	
	private WebDriver driver;
	private DP1HomePage dp1HomePage;
	
	
	public DP1PageObjectManager(WebDriver driver) {
		this.driver = driver;
		this.initializePageElements();
	}

	private void initializePageElements() {
		dp1HomePage = PageFactory.initElements(driver, DP1HomePage.class);	
	}
	
	public DP1HomePage getDP1Homeage() {
		dp1HomePage = dp1HomePage == null ? new DP1HomePage(driver)  : dp1HomePage;
		return dp1HomePage;
	}

}
