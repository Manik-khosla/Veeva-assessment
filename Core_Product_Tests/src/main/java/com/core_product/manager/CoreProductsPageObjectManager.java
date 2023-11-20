package com.core_product.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.core_product.pageobjects.CPHomePage;
import com.core_product.pageobjects.NewsPage;
import com.core_product.pageobjects.ProductsPage;

public class CoreProductsPageObjectManager {
	
	private WebDriver driver;
	private CPHomePage cpHomePage;
	private ProductsPage productsPage;
	private NewsPage newsPage;
		
	public CoreProductsPageObjectManager(WebDriver driver) {
		this.driver = driver;
		this.initializePageElements();
	}

	private void initializePageElements() {
		cpHomePage = PageFactory.initElements(driver, CPHomePage.class);
		productsPage = PageFactory.initElements(driver, ProductsPage.class);
		newsPage = PageFactory.initElements(driver, NewsPage.class);		
	}
	
	public CPHomePage getCPPage() {
		cpHomePage = cpHomePage == null ? new CPHomePage(driver)  : cpHomePage;
		return cpHomePage;
	}
	
	public ProductsPage getProductsPage() {
		productsPage = productsPage == null ? new ProductsPage(driver)  : productsPage;
		return productsPage;
	}
	
	public NewsPage getNewsPage() {
		newsPage = newsPage == null ? new NewsPage(driver) : newsPage;
		return newsPage;
	}


}
