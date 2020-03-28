package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private  By userNameLoc = By.xpath("//input[@id='Email']");
	private  By passwordLoc = By.xpath("//input[@id='Password']");
	private  By loginLoc = By.xpath("//input[@value='Log in']");
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void enteringUserName(String userName)
	{
	 driver.findElement(userNameLoc).sendKeys(userName);
	}
	public  void enteringpassword(String password)
	{
	 driver.findElement(passwordLoc).sendKeys(password);
	}
	public  void clickOnLogin()
	{
	 driver.findElement(loginLoc).click();
	}

}
