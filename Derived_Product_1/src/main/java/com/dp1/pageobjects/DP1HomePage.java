package com.dp1.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DP1HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@role='tablist']//child::button/span[1]")
	List<WebElement> slides;
	
	public DP1HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateSlideTitleAndDuration(String slideTitle, String duration) {	
		
		for(WebElement slide : slides) {
			Assert.assertEquals(slide.getText(), slideTitle);
		}
	}
	
}
