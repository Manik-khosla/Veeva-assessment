package com.veeva_automation_framework.setup;

import com.veeva_automation_framework.configurations.AppConfig;
import com.veeva_automation_framework.manager.DriverManager;
import com.veeva_automation_framework.manager.Manager;

public class BaseSetup {

	public Manager manager;
	public DriverManager driverManager;
	
	public void setupDriver() {
		manager = new Manager();
		driverManager = manager.getDriverManager(AppConfig.getConfiguration().getString("conf.browser.name"), AppConfig.getConfiguration().getInt("conf.browser.timeout"));
	}

	public void tearDown() {
		driverManager.getDriver().quit();
		manager.clear();
	}

}
