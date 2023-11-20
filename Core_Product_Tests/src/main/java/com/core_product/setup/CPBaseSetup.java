package com.core_product.setup;

import org.openqa.selenium.WebDriver;

import com.core.configurations.setup.BaseSetup;
import com.core_product.manager.CoreProductsPageObjectManager;
import com.core_product.pageobjects.CPHomePage;
import com.core_product.pageobjects.NewsPage;
import com.core_product.pageobjects.ProductsPage;

public class CPBaseSetup extends BaseSetup{
	
	public WebDriver driver;
	public CoreProductsPageObjectManager pageManager;
	public CPHomePage cpHomePage;
	public ProductsPage productPage;
	public NewsPage newsPage;
	
	private void setup() {
		super.setupDriver();
		driver = driverManager.getDriver();
	}

	private void initPageElements() {
		pageManager = new CoreProductsPageObjectManager(driver);
		cpHomePage = pageManager.getCPPage();
		productPage = pageManager.getProductsPage();
		newsPage = pageManager.getNewsPage();
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
