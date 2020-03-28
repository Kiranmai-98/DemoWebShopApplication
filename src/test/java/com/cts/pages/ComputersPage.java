package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputersPage 
{
	private  By desktopLoc = By.linkText("Desktops");
	private   By cheapCompLoc = By.linkText("Build your own cheap computer");
	private   By expCompLoc = By.linkText("Build your own expensive computer");
	private   By atclLoc = By.xpath("//input[@value='Add to compare list']");
	private   By cheapCompCostLoc = By.xpath("(//td[contains(text(),'800.00')])[1]");
	private   By expCompCostLoc = By.xpath("(//td[contains(text(),'800.00')])[2]");
	
	private WebDriver driver;
	
	public ComputersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public   void clickOnDesktop()
	{
	  driver.findElement(desktopLoc).click();
	}
	
	public   void clickOncheapComputer()
	{
	    WebElement cheapComputerEle = driver.findElement(cheapCompLoc);
	    cheapComputerEle.click();
	}
	public   String costOfCheapComp()
	{
		String text1 = driver.findElement(cheapCompCostLoc).getText();
		return text1;
	}
	public   void clickOnExpensiveComputer()
	{
	    WebElement ExpComputerEle = driver.findElement(expCompLoc);
	    ExpComputerEle.click();
	}
	public   String costOfExpComp()
	{
		String text2 = driver.findElement(expCompCostLoc).getText();
		return text2;
	}
	public  void clickToAddToCompareList()
	{
	    driver.findElement(atclLoc).click();
	}

}
