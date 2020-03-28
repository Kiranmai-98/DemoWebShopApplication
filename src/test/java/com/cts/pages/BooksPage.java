package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage 
{
	private  By fictionLoc = By.xpath("//a[text()='Computing and Internet']");
	private WebDriver driver;
	
	public BooksPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickOnFictionBook() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(fictionLoc).click();
	}

}
