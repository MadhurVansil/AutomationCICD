package rahulshettyacademy.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


//@Listeners(rahulshettyacademy.TestComponents.Listeners.class)
public class ErrorValidationstest extends BaseTest{

	@Test (groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	 public void LoginErrorValidations() throws IOException
	 {
		
		// String productName = "ZARA COAT 3";

		
		
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		 landingPage.loginToApplication("palakv@gmail.com","Madhur12222024#");
		
		
		AssertJUnit.assertEquals(landingPage.getErrorMessage(), "Incorrect email  password.");
		

		
	}
	
	@Test
	 public void ProductErrorValidation() throws IOException
	 {
		
		String productName = "ZARA COAT 3";

		
		
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		ProductCatalogue productCatalogue = landingPage.loginToApplication("palakv@gmail.com","Madhur2024#");
		
		
		// ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProducList();
				
		productCatalogue.AddtoCart(productName);
		

		CartPage cartPage = productCatalogue.goTocartPage();
		
		// CartPage cartPage=new CartPage(driver);
		
		boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		
		AssertJUnit.assertFalse(match);
		
		
		
		// driver.close();
		
	}

}
