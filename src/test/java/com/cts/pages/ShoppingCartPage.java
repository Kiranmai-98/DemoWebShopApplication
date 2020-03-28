package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage 
{
	private  By tosLoc = By.id("termsofservice");
	private  By checkoutLoc = By.xpath("//button[contains(text(),'Checkout')]");
	private  By newAddressLoc = By.id("billing-address-select");
	private  By fnLoc = By.id("BillingNewAddress_FirstName");
	private  By countryLoc = By.id("BillingNewAddress_CountryId");
	private  By cityLoc = By.id("BillingNewAddress_City");
	private  By addressLoc = By.id("BillingNewAddress_Address1");
	private  By postCodeLoc = By.id("BillingNewAddress_ZipPostalCode");
	private  By numberLoc = By.id("BillingNewAddress_PhoneNumber");
	private  By continue1Loc = By.xpath("(//input[@title='Continue'])[1]");
	private  By continue2Loc = By.xpath("(//input[@title='Continue'])[2]");
	private  By continue3Loc = By.xpath("(//input[@value='Continue'])[3]");
	private  By continue4Loc = By.xpath("(//input[@value='Continue'])[4]");
	private  By continue5Loc = By.xpath("(//input[@value='Continue'])[5]");
	private  By confirmLoc = By.xpath("//input[@value='Confirm']");
	//private  By shippingLoc = By.xpath("(//input[@name='shippingoption'])[1]");
	private WebDriver driver;
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void acceptTermsOfService()
	{
	driver.findElement(tosLoc).click();
	}
	public  void clickOnCheckOut()
	{
    driver.findElement(checkoutLoc).click();
	}
    public  void clickOnAddress()
    {
    WebElement addressEle = driver.findElement(newAddressLoc);
    Select select1 = new Select(addressEle);
    select1.selectByVisibleText("New Address");
    }
    
    public  void enterFirstName()
    {
    WebElement fnEle = driver.findElement(fnLoc);
    fnEle.clear();fnEle.sendKeys("Kiranmai");
    }
    
    public  void selectCountry()
    {
    WebElement countryEle = driver.findElement(countryLoc);
    Select select2 = new Select(countryEle);
    select2.selectByVisibleText("India");
    }
    public  void enterCity()
    {
    driver.findElement(cityLoc).sendKeys("Andhra");
    }
    public  void enterAddress()
    {
    driver.findElement(addressLoc).sendKeys("Guntur");
    }
    public  void enterPostCode()
    {
    driver.findElement(postCodeLoc).sendKeys("123456");
    }
    public  void enterPhoneNumber()
    {
    driver.findElement(numberLoc).sendKeys("9876543219");
    }
    public  void clickOnContinues()
    {
    driver.findElement(continue1Loc).click();
    driver.findElement(continue2Loc).click();
    //driver.findElement(shippingLoc).click();
    driver.findElement(continue3Loc).click();
    driver.findElement(continue4Loc).click();
    driver.findElement(continue5Loc).click(); 
    }
    public  void clickOnConfirm()
    {
    driver.findElement(confirmLoc).click(); 
    }

}
