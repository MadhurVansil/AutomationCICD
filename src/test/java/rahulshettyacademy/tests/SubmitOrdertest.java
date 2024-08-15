package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


//@Listeners(rahulshettyacademy.TestComponents.Listeners.class)//
public class SubmitOrdertest extends BaseTest{

	
	 String productName = "ZARA COAT 3";
	
	@Test (dataProvider="getData",groups={"Purchase"})
	 public void submitOrder(HashMap<String,String> input) throws IOException
	 {
		
	
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		ProductCatalogue productCatalogue = landingPage.loginToApplication(input.get("email"),input.get("password"));
		
		
		// ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	//	List<WebElement> products = productCatalogue.getProducList();
				
		productCatalogue.AddtoCart(input.get("product"));
		

		CartPage cartPage = productCatalogue.goTocartPage();
		
		// CartPage cartPage=new CartPage(driver);
		
		boolean match = cartPage.verifyProductDisplay(input.get("product"));
		
		AssertJUnit.assertTrue(match);
		
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		// driver.close();
		
	}
	
	
	@Test (dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		
		ProductCatalogue productCatalogue = landingPage.loginToApplication("palakv@gmail.com","Madhur2024#");
		
		
		OrderPage orderPage = productCatalogue.goToOrderPage();
		
		AssertJUnit.assertTrue(orderPage.verifyOrderDisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
	/*	HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "palakv@gmail.com");
		map.put("password", "Madhur2024#");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "madhurv@gmail.com");
		map1.put("password", "MadhurV2024#");
		map1.put("product", "ADIDAS ORIGINAL");  */
		
		List<HashMap<String, String>> data = getJsonDataToMap("D:\\EclipseWorkspace\\SeleniumFrameworkDesign\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)} , {data.get(1)}};
		
		
	}
	
	//@DataProvider
	//public Object[][] getData()
	//{
		
	//	return new Object[][] {{"palakv@gmail.com", "Madhur2024#" , "ZARA COAT 3"} , {"madhurv@gmail.com","MadhurV2024#", "ADIDAS ORIGINAL"}};
		
		
	//}
	

}
