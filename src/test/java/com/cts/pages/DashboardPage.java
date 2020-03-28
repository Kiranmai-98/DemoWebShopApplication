package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage 
{
	private  By loginLoc = By.linkText("Log in");
	private WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public  void clickOnLogin()
	{
		driver.findElement(loginLoc).click();
	}

}
