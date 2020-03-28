package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecentlyViewedProductsPage 
{
	private  By fictionLoc = By.xpath("//a[text()='Computing and Internet']");
	private  By atcLoc1 = By.xpath("(//input[@value='Add to cart'])[1]");
	private  By actualMsgOfAddedCartLoc = By.xpath("//p[@class='content']");
	private WebDriver driver;
	public RecentlyViewedProductsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void clickOnFiction()
	{
	   driver.findElement(fictionLoc).click();
	}
	
	public  void clickOnAddTOCart()
	{
		driver.findElement(atcLoc1).click();
	}
	
	public  String  getActualMsgOfCarting()
	{
	    WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.presenceOfElementLocated(actualMsgOfAddedCartLoc));
	    String actualMsgOfAddedCart = driver.findElement(actualMsgOfAddedCartLoc).getText();
	    return actualMsgOfAddedCart;
	}

}
