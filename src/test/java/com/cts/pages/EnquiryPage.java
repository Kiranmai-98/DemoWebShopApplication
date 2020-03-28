package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnquiryPage 
{
	private  By fullNameLoc = By.id("FullName");
	private  By mailLoc = By.xpath("//input[@placeholder='Enter your email address']");
	private  By submitLoc = By.xpath("//input[@value='Submit']");
	private  By msgLoc = By.xpath("//div[@class='result']");
	private WebDriver driver;
	public EnquiryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void enteringFullName(String myName)
	{
	  WebElement fullNameEle = driver.findElement(fullNameLoc);
      fullNameEle.clear();
      fullNameEle.sendKeys(myName);
	}
    
	public  void enteringEmail(String myMail)
	{
        WebElement emailEle = driver.findElement(mailLoc);
        emailEle.clear();
        emailEle.sendKeys(myMail);
	}
    
	public  void enterQuery(String enquiryQn)
	{
        driver.findElement(By.id("Enquiry")).sendKeys(enquiryQn);
              
	}
	public  void clickOnSubmit()
	{
		driver.findElement(submitLoc).click(); 
	}
	public  String getActualSubmittedMsg()
	{
		String actEnqSubMsg = driver.findElement(msgLoc).getText();
		return actEnqSubMsg;
	}

}
