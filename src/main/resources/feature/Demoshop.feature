Feature: feature description
	In order to use the DemoShopWebsite
	As a customer
	I want to get access to the portal
	
Background:
Given I have the browser with DemoWebShopPage
When I Login to my account using 'bindu.tummala98@gmail.com' and 'Bindu@98'

Scenario: Adding Items to cart
When I recently viewed some items
And click on the recently viewed products
And click on an item
And click on add to cart
Then The added item should be in the shopping cart

Scenario: Comparision of products cost
When I click on add to compare page
Then They should appear on the compare page

Scenario: Editing the information
When Click on my account
Then I should be able to edit my information as name as 'Bindu'

Scenario: Submitting an enquiry
When I click on contact as
And I enter my name as 'Bindu Tummala' and email as 'bindu.tummala98@gmail.com'
Then I can be able to submit an Enquiry as 'Please tell these details........'

Scenario: For using excels to send multiple queries
When Make a click on contact us
And Enter details from the excel "src/test/resources/excel/DemoExcel.xlsx" with sheetname "SomeCredentials"
Then All the queries should be submitted
@valid
Scenario: To get details of the order
When I order anything
Then I can be able to get details of the order

