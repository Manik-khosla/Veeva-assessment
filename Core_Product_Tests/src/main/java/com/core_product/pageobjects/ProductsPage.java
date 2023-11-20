package com.core_product.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.core.pageobjects.BasePage;
import com.core_product.fileHandler.fileHandler;
import com.core_product_pojo.JacketInfo;



public class ProductsPage extends BasePage {

	@FindBy(xpath = "//div[@class=\"paginator\"]//li[@class=\"show-for-large\"]")
	private  List<WebElement> pagination;

	@FindBy(xpath = "//i[@aria-label=\"Close Pop-Up\"]")
	private  WebElement salePopup;

	@FindBy(xpath = "//div[@class=\"product-card-title\"]/a")
	private  List<WebElement> JacketTitles;

	@FindBy(xpath = "//div[@class=\"price-card\"]//div[@class=\"price-row\"][1]//span[@class=\"sr-only\"]")
	private  List<WebElement> JacketPrices;

	@FindBy(xpath = "//div[@class=\"product-card row\"]/div[2]")
	private  List<WebElement> topSeller;
	
	private WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	private void dismissPopup() {
		this.waitForElement(driver, salePopup, ExpectedConditions.invisibilityOf(salePopup));
	}

	public void FilterProducts(String department) {
		this.dismissPopup();
		WebElement filter = driver.findElement(By.xpath("//span[text()='" + department + "']"));
		this.clickElement(driver, filter);
	}

	public int getNumberOfPages() {
		return pagination.size()+1;
	}

	public void getInfoOf(String product) {
		List<JacketInfo> jacketList = new ArrayList<JacketInfo>();
		WebElement nextPage = null;
		
		for(int numberOfPages =1 ; numberOfPages <= getNumberOfPages(); numberOfPages++) 
		{
		if(numberOfPages + 1 <= getNumberOfPages()) {
		nextPage = driver.findElement(By.xpath("//div[@class=\"paginator\"]//a[@aria-label=\"page " + (numberOfPages + 1) + "\"]"));	
		}
		int index = 0;
		for(WebElement jacket : JacketTitles) {		
		JacketInfo info = new JacketInfo();
		info.setTitle(jacket.getText());
		info.setPrice(JacketPrices.get(index).getText());
        String topSellerMessage;
		if(topSeller.get(index).findElements(By.xpath("./*")).size() == 4)
		{		
			topSellerMessage = topSeller.get(index).findElement(By.xpath(".//span[@class=\"top-seller-vibrancy-message\"]/span[1]")).getText()
				+ topSeller.get(index).findElement(By.xpath(".//span[@class=\"top-seller-vibrancy-message\"]/span[2]")).getText();
		}
		else {
			topSellerMessage = "NULL";
		}
		info.setTopSeller(topSellerMessage);
		jacketList.add(info);
		index++;
		}
		
		if(numberOfPages + 1 <= getNumberOfPages()) {
		this.clickElement(driver, nextPage);
		}
		
		}
		
		fileHandler.generateFile(jacketList);				
	}

}
