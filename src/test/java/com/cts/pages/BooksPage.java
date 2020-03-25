package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage 
{
	private static By fictionLoc = By.xpath("//a[text()='Computing and Internet']");
	
	public static void clickOnFictionBook(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(fictionLoc).click();
	}

}
