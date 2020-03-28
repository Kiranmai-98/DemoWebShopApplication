package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage
{	
	private  By firstNameLoc = By.xpath("//input[@id='FirstName']");
	private  By saveLoc = By.xpath("//input[@value='Save']");
	private WebDriver driver;
	public MyInfoPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public  void clearingFirstName()
	{
		driver.findElement(firstNameLoc).clear();
	}
	public  void editingFirstName(String editedName)
	{	  
        driver.findElement(firstNameLoc).sendKeys(editedName);
	}
	public  void clickOnSave()
	{
        driver.findElement(saveLoc).click();
	}
	public  String toGetEditedName()
	{
		  WebElement firstName = driver.findElement(firstNameLoc);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  String fName = js.executeScript("return arguments[0].value;", firstName).toString();
		  return fName;
	}

}
