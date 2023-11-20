package com.veeva_automation_framework.manager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private WebDriver driver;

	public DriverManager(String browser, int timeout) {

		browser = browser.toLowerCase();
		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			this.driver = new SafariDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		}

		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public WebDriver getDriver() {
		if (this.driver == null) {
			new DriverManager("Chrome", 30);
			return driver;
		} else {
			return driver;
		}
		}

}
