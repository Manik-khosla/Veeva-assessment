package com.veeva_automation_framework.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.veeva_automation_framework.pageobjects.CPHomePage;
import com.veeva_automation_framework.pageobjects.NewsPage;
import com.veeva_automation_framework.pageobjects.ProductsPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private CPHomePage cpHomePage;
	private ProductsPage productsPage;
	private NewsPage newsPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
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
