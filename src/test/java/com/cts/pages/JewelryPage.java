package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JewelryPage 
{
	private  By locketLoc = By.linkText("Black & White Diamond Heart");
	private  By atcLoc = By.xpath("(//input[@value='Add to cart'])[1]");
	private WebDriver driver;
	public JewelryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void clickOnOneItem()
	{
	    driver.findElement(locketLoc).click();
	}
	public  void clickOnAddToCart()
	{
	    driver.findElement(atcLoc).click();
	}

}
