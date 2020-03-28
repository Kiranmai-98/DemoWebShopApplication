package com.cts.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersPage 
{
	private  By orderDetailsLoc = By.linkText("Click here for order details.");
	private WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void clickForOrderDetails()
	{
		driver.findElement(orderDetailsLoc).click();
	}
	
	public  void toPrintDetailsOfOrder()
	{
	    WebElement orderDetails = driver.findElement(By.className("data-table"));
	    List<WebElement> allDetails = orderDetails.findElements(By.tagName("tr"));
	    for(WebElement details : allDetails)
	    {
		   System.out.println(details.getText());
	    }
	}

}
