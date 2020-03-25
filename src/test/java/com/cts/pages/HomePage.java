package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	private static By booksLoc = By.linkText("Books");
	private static By rvpLoc = By.xpath("//a[text()='Recently viewed products']");
	private static By computersLoc = By.linkText("Computers");
	private static By compareLoc = By.linkText("Compare products list");
	private static By myAccLoc = By.xpath("//a[text()='My account']");
	private static By contactLoc = By.linkText("Contact us");
	private static By jewelryLoc = By.xpath("//a[contains(text(),'Jewelry')]");
	private static By shoppingCartLoc = By.xpath("//span[text()='Shopping cart']");
	private static By logoutLoc = By.linkText("Log out");
	
	
	public static void clickOnBooks(WebDriver driver)
	{
	  driver.findElement(booksLoc).click();
	}
		
	public static void clickOnRecentlyViewedProducts(WebDriver driver)
	{
		driver.findElement(rvpLoc).click();
	}
	
	public static void clickOnComputers(WebDriver driver)
	{
		driver.findElement(computersLoc).click();
	}
	
	public static void clickOnCompareProducts(WebDriver driver)
	{
		driver.findElement(compareLoc).click();
	}
	
	public static void clickOnMyAccount(WebDriver driver) 
	{
	    driver.findElement(myAccLoc).click();
	}
	
	public static void clickOnContactUs(WebDriver driver)
	{
		 driver.findElement(contactLoc).click();
	}
	
	public static void clickOnJewelry(WebDriver driver)
	{
		 driver.findElement(jewelryLoc).click();
	}
	
	public static void clickOnShoppingCart(WebDriver driver)
	{
		 driver.findElement(shoppingCartLoc).click();
	}
	
	public static void clickOnLogOut(WebDriver driver)
	{
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLoc));
		driver.findElement(logoutLoc).click();
	}

}
