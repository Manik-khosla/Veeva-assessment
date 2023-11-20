package com.dp1.setup;

import org.openqa.selenium.WebDriver;


import com.dp1.manager.DP1PageObjectManager;
import com.dp1.pageobjects.DP1HomePage;
import com.veeva_automation_framework.setup.BaseSetup;

public class DP1BaseSetup extends BaseSetup{
	
	public WebDriver driver;
	public DP1PageObjectManager pageManager;
	public DP1HomePage dp1HomePage;
	
	private void setup() {
		super.setupDriver();
		driver = driverManager.getDriver();
	}

	private void initPageElements() {
		pageManager = new DP1PageObjectManager(driver);
		dp1HomePage = pageManager.getDP1Homeage();
	}
	
	public void initTestSetup() {
      this.setup();
      this.initPageElements();
	}

	public void tearDown() {
		driverManager.getDriver().quit();
		manager.clear();
	}

}
