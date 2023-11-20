package com.veeva_automation_framework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public <T> WebElement waitForElement(WebDriver driver, WebElement element, ExpectedCondition<T> condition) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(condition);
		return element;
	}

	public void clickElement(WebDriver driver, WebElement element) {
        WebElement clickableElement = this.waitForElement(driver, element, ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
	}

	public void HoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void SwitchDriverWindowContext(WebDriver driver, String handle) {
		driver.switchTo().window(handle);
	}

	public void switchDriverToDefaultContext(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void scrollElementIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
