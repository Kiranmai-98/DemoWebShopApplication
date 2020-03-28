package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	private  By booksLoc = By.linkText("Books");
	private  By rvpLoc = By.xpath("//a[text()='Recently viewed products']");
	private  By computersLoc = By.linkText("Computers");
	private  By compareLoc = By.linkText("Compare products list");
	private  By myAccLoc = By.xpath("//a[text()='My account']");
	private  By contactLoc = By.linkText("Contact us");
	private  By jewelryLoc = By.xpath("//a[contains(text(),'Jewelry')]");
	private  By shoppingCartLoc = By.xpath("//span[text()='Shopping cart']");
	private  By logoutLoc = By.linkText("Log out");
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public  void clickOnBooks()
	{
	  driver.findElement(booksLoc).click();
	}
		
	public  void clickOnRecentlyViewedProducts()
	{
		driver.findElement(rvpLoc).click();
	}
	
	public  void clickOnComputers()
	{
		driver.findElement(computersLoc).click();
	}
	
	public  void clickOnCompareProducts()
	{
		driver.findElement(compareLoc).click();
	}
	
	public  void clickOnMyAccount() 
	{
	    driver.findElement(myAccLoc).click();
	}
	
	public  void clickOnContactUs()
	{
		 driver.findElement(contactLoc).click();
	}
	
	public  void clickOnJewelry()
	{
		 driver.findElement(jewelryLoc).click();
	}
	
	public  void clickOnShoppingCart()
	{
		 driver.findElement(shoppingCartLoc).click();
	}
	
	public  void clickOnLogOut()
	{
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLoc));
		driver.findElement(logoutLoc).click();
	}

}
