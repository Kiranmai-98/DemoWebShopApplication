package com.cts.stepdefinitions;

import org.junit.Assert;

import com.cts.base.LaunchBrowser;
import com.cts.pages.BooksPage;
import com.cts.pages.ComputersPage;
import com.cts.pages.DashboardPage;
import com.cts.pages.EnquiryPage;
import com.cts.pages.HomePage;
import com.cts.pages.JewelryPage;
import com.cts.pages.LoginPage;
import com.cts.pages.MyInfoPage;
import com.cts.pages.OrdersPage;
import com.cts.pages.RecentlyViewedProductsPage;
import com.cts.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinionNumbers 
{
	@Given("I have the browser with DemoWebShopPage")
	public void i_have_the_browser_with_DemoWebShopPage() 
	{
		LaunchBrowser.setUp();
	}

	@When("I Login to my account using {string} and {string}")
	public void i_Login_to_my_account_using_and(String userName, String password) 
	{
		DashboardPage.clickOnLogin(LaunchBrowser.driver);		
		LoginPage.enteringUserName(LaunchBrowser.driver, userName);
		LoginPage.enteringpassword(LaunchBrowser.driver, password);
		LoginPage.clickOnLogin(LaunchBrowser.driver);
	}

	@When("I recently viewed some items")
	public void i_recently_viewed_some_items() throws InterruptedException 
	{
		HomePage.clickOnBooks(LaunchBrowser.driver);
	    BooksPage.clickOnFictionBook(LaunchBrowser.driver);
	}

	@When("click on the recently viewed products")
	public void click_on_the_recently_viewed_products() 
	{
		 HomePage.clickOnRecentlyViewedProducts(LaunchBrowser.driver);
	}

	@When("click on an item")
	public void click_on_an_item() 
	{
		RecentlyViewedProductsPage.clickOnFiction(LaunchBrowser.driver);
	}

	@When("click on add to cart")
	public void click_on_add_to_cart() 
	{
		RecentlyViewedProductsPage.clickOnAddTOCart(LaunchBrowser.driver);
	}

	@Then("The added item should be in the shopping cart")
	public void the_added_item_should_be_in_the_shopping_cart() throws InterruptedException 
	{
		String actualMsgOfAddedCart = RecentlyViewedProductsPage.getActualMsgOfCarting(LaunchBrowser.driver);
    	
	    System.out.println(actualMsgOfAddedCart);
	    
	    Assert.assertEquals(actualMsgOfAddedCart,"The product has been added to your shopping cart");
	    Thread.sleep(5000);
	    HomePage.clickOnLogOut(LaunchBrowser.driver);
	    LaunchBrowser.tearDown();
	}

	@When("I click on add to compare page")
	public void i_click_on_add_to_compare_page() 
	{
		HomePage.clickOnComputers(LaunchBrowser.driver);	    
	    ComputersPage.clickOnDesktop(LaunchBrowser.driver);	    
	    ComputersPage.clickOncheapComputer(LaunchBrowser.driver);
	    ComputersPage.clickToAddToCompareList(LaunchBrowser.driver);
	   
	    HomePage.clickOnComputers(LaunchBrowser.driver);
	    ComputersPage.clickOnDesktop(LaunchBrowser.driver);
	    ComputersPage.clickOnExpensiveComputer(LaunchBrowser.driver);
	    ComputersPage.clickToAddToCompareList(LaunchBrowser.driver);
	   
	}

	@Then("They should appear on the compare page")
	public void they_should_appear_on_the_compare_page() 
	{
        HomePage.clickOnCompareProducts(LaunchBrowser.driver);
		
		if(LaunchBrowser.driver.getPageSource().toLowerCase().contains("build your own cheap computer") &&
			   LaunchBrowser.driver.getPageSource().toLowerCase().contains("build your own expensive computer"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		String text1 = ComputersPage.costOfCheapComp(LaunchBrowser.driver);		
		String text2 = ComputersPage.costOfExpComp(LaunchBrowser.driver);				
		text1 = text1.replace(".00", "");
		text2 = text2.replace(".00", "");
		int value1 = Integer.parseInt(text1);
		int value2 = Integer.parseInt(text2);
		if(value1>value2)
		{
			System.out.println(value1+" is greater");
		}
		else
		{
			System.out.println(value2+" is greater");
		}
		HomePage.clickOnLogOut(LaunchBrowser.driver);
		LaunchBrowser.tearDown();
	
	}

	@When("Click on my account")
	public void click_on_my_account() 
	{
		HomePage.clickOnMyAccount(LaunchBrowser.driver);
	}

	@Then("I should be able to edit my information as name as {string}")
	public void i_should_be_able_to_edit_my_information_as_name_as(String editedName) 
	{
		 MyInfoPage.clearingFirstName(LaunchBrowser.driver);
		 MyInfoPage.editingFirstName(LaunchBrowser.driver, editedName);
		 MyInfoPage.clickOnSave(LaunchBrowser.driver);
		    	    
		 String fName = MyInfoPage.toGetEditedName(LaunchBrowser.driver);
		 System.out.println(fName);
		   
		 Assert.assertEquals("Name changed successfully","Bindu",fName);
		 HomePage.clickOnLogOut(LaunchBrowser.driver);
		 LaunchBrowser.tearDown();  
	}

	@When("I click on contact as")
	public void i_click_on_contact_as() 
	{
		 HomePage.clickOnContactUs(LaunchBrowser.driver);
	}

	@When("I enter my name as {string} and email as {string}")
	public void i_enter_my_name_as_and_email_as(String myName, String myMail) 
	{
		EnquiryPage.enteringFullName(LaunchBrowser.driver, myName);
	    EnquiryPage.enteringEmail(LaunchBrowser.driver, myMail);	   
	}

	@Then("I can be able to submit an Enquiry as {string}")
	public void i_can_be_able_to_submit_an_Enquiry_as(String enquiryQn) 
	{
		 EnquiryPage.enterQuery(LaunchBrowser.driver, enquiryQn);
		 EnquiryPage.clickOnSubmit(LaunchBrowser.driver);
		    
		 String actEnqSubMsg = EnquiryPage.getActualSubmittedMsg(LaunchBrowser.driver);
		 System.out.println(actEnqSubMsg);
		    
		 String expEnqSubMsg = "Your enquiry has been successfully sent to the store owner.";
		 Assert.assertEquals("Enquiry submitted assertion", expEnqSubMsg, actEnqSubMsg);
		 HomePage.clickOnLogOut(LaunchBrowser.driver);
		 LaunchBrowser.tearDown();
	}

	@When("I order anything")
	public void i_order_anything() 
	{
		 HomePage.clickOnJewelry(LaunchBrowser.driver);
		    
		    JewelryPage.clickOnOneItem(LaunchBrowser.driver);
		    JewelryPage.clickOnAddToCart(LaunchBrowser.driver);
		    
		    HomePage.clickOnShoppingCart(LaunchBrowser.driver);
		    
		    ShoppingCartPage.acceptTermsOfService(LaunchBrowser.driver);
		    ShoppingCartPage.clickOnCheckOut(LaunchBrowser.driver);
		    ShoppingCartPage.clickOnAddress(LaunchBrowser.driver);
		    ShoppingCartPage.enterFirstName(LaunchBrowser.driver);
		    ShoppingCartPage.selectCountry(LaunchBrowser.driver);
		    ShoppingCartPage.enterCity(LaunchBrowser.driver);
		    ShoppingCartPage.enterAddress(LaunchBrowser.driver);
		    ShoppingCartPage.enterPostCode(LaunchBrowser.driver);
		    ShoppingCartPage.enterPhoneNumber(LaunchBrowser.driver);
		    ShoppingCartPage.clickOnContinues(LaunchBrowser.driver);
		    //ShoppingCartPage.acceptTermsOfService(LaunchBrowser.driver);
		    ShoppingCartPage.clickOnConfirm(LaunchBrowser.driver);
		   
	}

	@Then("I can be able to get details of the order")
	public void i_can_be_able_to_get_details_of_the_order() 
	{
		OrdersPage.clickForOrderDetails(LaunchBrowser.driver);
		OrdersPage.toPrintDetailsOfOrder(LaunchBrowser.driver);
		HomePage.clickOnLogOut(LaunchBrowser.driver);
		LaunchBrowser.tearDown();
	}
}
