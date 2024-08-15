package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

	 LandingPage landingPage;
	 ProductCatalogue productCatalogue;
	 ConfirmationPage confirmationPage;
	 @Given("I landed on Ecommerce Page")
	 public void I_landed_on_Ecommerce_Page() throws IOException
	 {
		  landingPage= launchApplication();
		  
	 }
	 
	 
	 
	 @Given("^Logged in with username (.+) and password (.+)$")
	 public void Logged_in_with_username_and_password(String username,String password)
	 {
		 
		productCatalogue=landingPage.loginToApplication(username,password);
		 
	 }
	 
	 
	 @When("^I add product (.+) to Cart$")
	 public void I_add_product_to_Cart(String productName)
	 {
		 
		 productCatalogue.AddtoCart(productName);
		 
	 }
	 
	 @When("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_the_order(String productName)
	 {
		 
		 CartPage cartPage = productCatalogue.goTocartPage();
		 boolean match = cartPage.verifyProductDisplay(productName);
			
		 AssertJUnit.assertTrue(match);
		 CheckoutPage checkoutPage=cartPage.goToCheckout();
			
		 checkoutPage.selectCountry("India");
		 confirmationPage=checkoutPage.submitOrder();
		 
	 }
	 
	 @Then("{string} message is displayed on ConfirmationPage")
	 public void message_is_displayed_on_ConfirmationPage(String string)
	 {
	 
		String confirmMessage = confirmationPage.getConfirmationMessage();
			
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase(string));
		tearDown();
		 	 
    }
	 
	 @Then("{string} message is displayed")
	 public void something_message_is_displayed(String string)
	 {
		 
		    AssertJUnit.assertEquals(landingPage.getErrorMessage(), string);
		    driver.close();
		 
	 }
}
