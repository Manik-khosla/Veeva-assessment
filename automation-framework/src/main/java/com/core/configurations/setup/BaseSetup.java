package com.core.configurations.setup;

import com.core.configurations.AppConfig;
import com.core.manager.DriverManager;
import com.core.manager.Manager;

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
