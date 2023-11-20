package com.core_product.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.core.pageobjects.BasePage;

public class CPHomePage extends BasePage{
	
	@FindBy(xpath="//button[@id=\"onetrust-accept-btn-handler\"]")
	private WebElement acceptCookieBtn;
	
	private String currentWindow;
	
	private WebDriver driver;
	
	
	public CPHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void getCurrentWindowHandle() {
		currentWindow = driver.getWindowHandle();
	}
	
	private void switchDriverContextToShopWindow() {
		Set<String> openedWindows = driver.getWindowHandles();
		
		for(String handle : openedWindows) {

			if(! handle.equalsIgnoreCase(currentWindow)) {
				this.SwitchDriverWindowContext(driver, handle);
			}
		}
	}
	
	public void AcceptCookies() {
		this.waitForElement(driver, acceptCookieBtn, ExpectedConditions.visibilityOf(acceptCookieBtn));
		this.clickElement(driver, acceptCookieBtn);
		driver.navigate().refresh();
	}
	
	public void HoverOnMenuOption(String option) {
		this.getCurrentWindowHandle();
		WebElement menu = driver.findElement(By.xpath("//span[text() = '" + option + "']"));
		this.waitForElement(driver, menu, ExpectedConditions.visibilityOf(menu));
		this.HoverOnElement(driver, menu);
	}

	
	public void selectCategory(String category) {
		WebElement categorySelected = driver.findElement(By.xpath("//a[@title=\"" + category + "\"]"));
		this.waitForElement(driver, categorySelected, ExpectedConditions.visibilityOf(categorySelected));
		this.clickElement(driver, categorySelected);	
		this.switchDriverContextToShopWindow();
	}
	
	
	

}
