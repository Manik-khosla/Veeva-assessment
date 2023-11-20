package com.veeva_automation_framework.setup;

import org.openqa.selenium.WebDriver;

import com.veeva_automation_framework.configurations.AppConfig;
import com.veeva_automation_framework.manager.DriverManager;
import com.veeva_automation_framework.manager.Manager;
import com.veeva_automation_framework.manager.PageObjectManager;
import com.veeva_automation_framework.pageobjects.CPHomePage;
import com.veeva_automation_framework.pageobjects.NewsPage;
import com.veeva_automation_framework.pageobjects.ProductsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSetup {

	private Manager manager;
	private DriverManager dm;
	private PageObjectManager pm;
	public WebDriver driver;
	public CPHomePage cpHomePage;
	public ProductsPage productPage;
	public NewsPage newsPage;
	
	private void setupDriver() {
		manager = new Manager();
		dm = manager.getDriverManager(AppConfig.getConfiguration().getString("conf.browser.name"), AppConfig.getConfiguration().getInt("conf.browser.timeout"));
		driver = dm.getDriver();
	}

	private void initPageElements() {
		pm = manager.getPageObjectManager();
		cpHomePage = pm.getCPPage();
		productPage = pm.getProductsPage();
		newsPage = pm.getNewsPage();
	}
	
	public void initTestSetup() {
		this.setupDriver();
		this.initPageElements();
	}

	public void tearDown() {
		dm.getDriver().quit();
		manager.clear();
	}

}
