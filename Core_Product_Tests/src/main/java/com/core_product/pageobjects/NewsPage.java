package com.core_product.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.veeva_automation_framework.pageobjects.BasePage;

public class NewsPage extends BasePage {

	@FindBy(xpath = "//h3[text()='VIDEOS']//following::ul[@class=\"ContentGrid_contentGridArticles__Lk_4g\"]/child::li")
	private List<WebElement> videoFeeds;
	
	private WebDriver driver;
	
	public NewsPage(WebDriver driver) {
		this.driver = driver;
	}

	private int getTotalNumberOfVideoFeeds() {

		return videoFeeds.size();
	}
	
	
	private int getVideoFeedsUpTo(String time) {
		
		return driver.findElements(By.xpath("//h3[text()='VIDEOS']//following::ul[@class=\"ContentGrid_contentGridArticles__Lk_4g\"]/child::li//time/child::span[text()='" + time + "']")).size();
	}
	
	
	public void getVideoInfo(String time) {
		
		System.out.println("Total Video Feeds:" + getTotalNumberOfVideoFeeds() + "\n" +
				"Total Video Feed Equal To" + time + ":" + getVideoFeedsUpTo(time));
		
	}

}