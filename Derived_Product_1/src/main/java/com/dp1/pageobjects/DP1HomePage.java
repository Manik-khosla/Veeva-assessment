package com.dp1.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.Assert;
import com.core.configurations.AppConfig;
import com.core.pageobjects.BasePage;
import com.google.common.base.Function;

public class DP1HomePage extends BasePage{
	
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@role='tablist']//child::button/span[1]")
	List<WebElement> slides;
	
	@FindBy(xpath = "//div[@class=\"TileImageOverlay_tileImageOverlay__DZ9FJ\"]/following::a[1]")
	WebElement SlideTitle;
	
	String currentHref;
	
	String expectedHref;
	
	public DP1HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private int getSlideCount() {
		return slides.size();
	}
	
	public void validateSlideTitleAndDuration(String slideTitle, String href, String duration) {	
		
		System.out.println("Slides count: " + slides.size());
		
		
		currentHref = SlideTitle.getAttribute("href");
		expectedHref = href;
		this.waitForHrefValueToBe();
		long start = System.nanoTime();    		
		this.waitForHrefChange();
		long elapsedTime = System.nanoTime() - start;
		System.out.println(TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
	}
	
	private void waitForHrefValueToBe() {
		Boolean  wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofNanos(250))
				.withTimeout(Duration.ofSeconds(AppConfig.getConfiguration().getInt("conf.browser.timeout"))).until(waitForHrefSet);	
	}
	
	Function<WebDriver, Boolean> waitForHrefSet = new Function<WebDriver, Boolean>()
	{
		public Boolean apply(WebDriver arg0) {
			if(currentHref.contentEquals(expectedHref))
			{
				return true;
			}
			return false;
		}
	};
	
	
	private void waitForHrefChange() {
		
		Boolean  wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofNanos(250))
				.withTimeout(Duration.ofSeconds(AppConfig.getConfiguration().getInt("conf.browser.timeout"))).until(waitForHrefSet);				
	}
	
	Function<WebDriver, Boolean> waitForHrefChange = new Function<WebDriver, Boolean>()
	{
		public Boolean apply(WebDriver arg0) {
			if(SlideTitle.getAttribute("href").contentEquals(expectedHref))
			{
				System.out.println(SlideTitle.getAttribute("href"));
				return false;
			}
			System.out.println(SlideTitle.getAttribute("href"));
			return true;
		}
	};
	
}
