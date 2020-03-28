package com.cts.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
//import org.openqa.selenium.WebDriver;

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
import com.cts.utils.ReadExcel;

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
		//Creating object for the dashBoard page
		DashboardPage dashBoard = new DashboardPage(LaunchBrowser.driver);
		//Click on Login
		dashBoard.clickOnLogin();
		//Creating object for the login page
		LoginPage login = new LoginPage(LaunchBrowser.driver);
		//Enter user name
		login.enteringUserName(userName);
		//Enter password
		login.enteringpassword(password);
		//click on log in
		login.clickOnLogin();
	}
	
	//Scenario: Adding Items to cart
	
	@When("I recently viewed some items")
	public void i_recently_viewed_some_items() throws InterruptedException 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//Click on books
		home.clickOnBooks();
		//Creating object for the books page
		BooksPage books = new BooksPage(LaunchBrowser.driver);
		//clicking on any one book(fiction for example)
	    books.clickOnFictionBook();
	}

	@When("click on the recently viewed products")
	public void click_on_the_recently_viewed_products() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		 //click on recently viewed products
		 home.clickOnRecentlyViewedProducts();
	}

	@When("click on an item")
	public void click_on_an_item() 
	{
		//creating object for the recently viewed products page
		RecentlyViewedProductsPage rvp = new RecentlyViewedProductsPage(LaunchBrowser.driver);
		//clicking on the fiction book which was recently viewed
		rvp.clickOnFiction();
	}

	@When("click on add to cart")
	public void click_on_add_to_cart() 
	{
		//creating object for the recently viewed products page
		RecentlyViewedProductsPage rvp = new RecentlyViewedProductsPage(LaunchBrowser.driver);
		//click on add to cart from the recently viewed products
		rvp.clickOnAddTOCart();
	}

	@Then("The added item should be in the shopping cart")
	public void the_added_item_should_be_in_the_shopping_cart() throws InterruptedException 
	{
		//creating object for the recently viewed products page
		RecentlyViewedProductsPage rvp = new RecentlyViewedProductsPage(LaunchBrowser.driver);
		//Getting actual message of adding to cart
		String actualMsgOfAddedCart = rvp.getActualMsgOfCarting();
    	//Print message
	    System.out.println(actualMsgOfAddedCart);
	    //Assertion of actual and message of adding to acrt from the recently viewed products
	    Assert.assertEquals(actualMsgOfAddedCart,"The product has been added to your shopping cart");
	    Thread.sleep(5000);
	    //creating object for the home page
	  	HomePage home = new HomePage(LaunchBrowser.driver);
	  	//click on logout
	    home.clickOnLogOut();
	    LaunchBrowser.tearDown();
	}
	
	//Scenario: Comparision of products cost

	@When("I click on add to compare page")
	public void i_click_on_add_to_compare_page() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on computers
		home.clickOnComputers();
		//creating object for the computers page
		ComputersPage computers = new ComputersPage(LaunchBrowser.driver);
		//click on desktop
	    computers.clickOnDesktop();	
	    //Click  one one of the computers (example: cheap costed desktop)
	    computers.clickOncheapComputer();
	    //click on add to compare list
	    computers.clickToAddToCompareList();
	    //click on computers
	    home.clickOnComputers();
	    //click on desktop 
	    computers.clickOnDesktop();
	    //click on expensive computer to compare two computers
	    computers.clickOnExpensiveComputer();
	    //click on add to compare list
	    computers.clickToAddToCompareList();
	   
	}

	@Then("They should appear on the compare page")
	public void they_should_appear_on_the_compare_page() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on compare products
        home.clickOnCompareProducts();
		//To assert whether the added products to compare produs are in the compare products list or not
		if(LaunchBrowser.driver.getPageSource().toLowerCase().contains("build your own cheap computer") &&
			   LaunchBrowser.driver.getPageSource().toLowerCase().contains("build your own expensive computer"))
		{
			//If the products added are present then it  prints as the test is passed
			System.out.println("Test Passed");
		}
		else
		{
			//If the products added are not present then it  prints as the test is failed
			System.out.println("Test failed");
		}
		//creating object for the computers page
		ComputersPage computers = new ComputersPage(LaunchBrowser.driver);
		//Getting cost of bth the computers to compare
		String text1 = computers.costOfCheapComp();		
		String text2 = computers.costOfExpComp();				
		text1 = text1.replace(".00", "");
		text2 = text2.replace(".00", "");
		int value1 = Integer.parseInt(text1);
		int value2 = Integer.parseInt(text2);
		//Asserting for the costs of computers and printing the higher cost
		if(value1>value2)
		{
			System.out.println(value1+" is greater");
		}
		else
		{
			System.out.println(value2+" is greater");
		}
		//Click on log out
		home.clickOnLogOut();
		//quit from the browser
		LaunchBrowser.tearDown();
	
	}
	
	//Scenario: Editing the information

	@When("Click on my account")
	public void click_on_my_account() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on my account
		home.clickOnMyAccount();
	}

	@Then("I should be able to edit my information as name as {string}")
	public void i_should_be_able_to_edit_my_information_as_name_as(String editedName) 
	{
		//creating object the my information page
		MyInfoPage myInfo = new MyInfoPage(LaunchBrowser.driver);
		//to edit clear the already pesent data
		//clearing the first name field
		 myInfo.clearingFirstName();
		 //entering the edited name
		 myInfo.editingFirstName(editedName);
		 //click on save to save the edited information
		 myInfo.clickOnSave();
		 //To get edited name for assertion
		 String fName = myInfo.toGetEditedName();
		 //print the edited name
		 System.out.println(fName);
		 //assertion if the name changed successfully or not  
		 Assert.assertEquals("Name changed successfully","Bindu",fName);
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on log out
		 home.clickOnLogOut();
		 //quit from the browser
		 LaunchBrowser.tearDown();  
	}
	
	//Scenario: Submitting an enquiry

	@When("I click on contact as")
	public void i_click_on_contact_as() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//Click on contact us
		 home.clickOnContactUs();
	}

	@When("I enter my name as {string} and email as {string}")
	public void i_enter_my_name_as_and_email_as(String myName, String myMail) 
	{
		//create object for the enquiry page
		EnquiryPage enquiry = new EnquiryPage(LaunchBrowser.driver);
		//enter full name
		enquiry.enteringFullName(myName);
		//enter mail ID
	    enquiry.enteringEmail(myMail);	   
	}

	@Then("I can be able to submit an Enquiry as {string}")
	public void i_can_be_able_to_submit_an_Enquiry_as(String enquiryQn) 
	{
		//create object for the query page
		EnquiryPage enquiry = new EnquiryPage(LaunchBrowser.driver);
		//Enter query in the queries field
		 enquiry.enterQuery(enquiryQn);
		 //click on submit
		 enquiry.clickOnSubmit();
		 //Getting enquiry submitted message    
		 String actEnqSubMsg = enquiry.getActualSubmittedMsg();
		 //Print that message
		 System.out.println(actEnqSubMsg);
		  //Expected message  
		 String expEnqSubMsg = "Your enquiry has been successfully sent to the store owner.";
		 //Assertion the actual and expected message of submission of query
		 Assert.assertEquals("Enquiry submitted assertion", expEnqSubMsg, actEnqSubMsg);
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on log out
		home.clickOnLogOut();
		//quit from the browser
		LaunchBrowser.tearDown();
		
	}
	
	//Scenario: For using excels to send multiple queries
	
	@When("Make a click on contact us")
	public void make_a_click_on_contact_us()
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//Click on contact us
		 home.clickOnContactUs(); 
	}

	@When("Enter details from the excel {string} with sheetname {string}")
	public void enter_details_from_the_excel_with_sheetname(String string, String string2) throws IOException 
	{
		//calling Read Excel class
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/DemoExcel.xlsx",
			               	"SomeCredentials");
		// object for enquiry page
		EnquiryPage enquiry = new EnquiryPage(LaunchBrowser.driver);
		// enter FullName
		enquiry.enteringFullName(str[0][0]);
		// enter Email
		enquiry.enteringEmail(str[0][1]);
		// enter Enquiry
		enquiry.enterQuery(str[0][2]);
		// click on submit
		enquiry.clickOnSubmit();
	}

	@Then("All the queries should be submitted")
	public void all_the_queries_should_be_submitted() 
	{
		// object for enquiry page
		EnquiryPage enquiry = new EnquiryPage(LaunchBrowser.driver);
		//for getting actual message of query submitted
		String actEnqSubMsg = enquiry.getActualSubmittedMsg();
		//Print that message
		System.out.println(actEnqSubMsg);
		//Expected message  
		String expEnqSubMsg = "Your enquiry has been successfully sent to the store owner.";
		//Assertion the actual and expected message of submission of query
		Assert.assertEquals("Enquiry submitted assertion", expEnqSubMsg, actEnqSubMsg);
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on log out
		home.clickOnLogOut();
		//quit from the browser
		LaunchBrowser.tearDown();
			
	
	}
	
	//Scenario: To get details of the order

	@When("I order anything")
	public void i_order_anything() 
	{
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//Click on jewelry
		 home.clickOnJewelry();
		//creating object for the Jewelry page
		 JewelryPage jewelry = new JewelryPage(LaunchBrowser.driver);
		 //Click on any item for adding to cart
		    jewelry.clickOnOneItem();
		  //click on add to cart
		    jewelry.clickOnAddToCart();
		   //click on shopping cart
		    home.clickOnShoppingCart();
		    //creating object for the shopping cart page
		    ShoppingCartPage cart = new ShoppingCartPage(LaunchBrowser.driver);
		    //Accept terms of service by clicking on the check box
		    cart.acceptTermsOfService();
		    //click on check out
		    cart.clickOnCheckOut();
		    //click on address
		    cart.clickOnAddress();
		    //enter name in the name field
		    cart.enterFirstName();
		    //Select country from the list
		    cart.selectCountry();
		    //Enter city name in city field
		    cart.enterCity();
		    //enter address in the address field
		    cart.enterAddress();
		    //enter post code in the post code field
		    cart.enterPostCode();
		    //Enter phone number in the phone number field 
		    cart.enterPhoneNumber();
		    //Click on continue to accept the order
		    cart.clickOnContinues();
		    //click on confirm order
		    cart.clickOnConfirm();
	}

	@Then("I can be able to get details of the order")
	public void i_can_be_able_to_get_details_of_the_order() 
	{
		//creating object for the orders page
		OrdersPage orders = new OrdersPage(LaunchBrowser.driver);
		//Click on click for order details
		orders.clickForOrderDetails();
		//Print the oder details
		orders.toPrintDetailsOfOrder();
		//creating object for the home page
		HomePage home = new HomePage(LaunchBrowser.driver);
		//click on log out
		home.clickOnLogOut();
		//quit from the browser
		LaunchBrowser.tearDown();
		
	}
}
