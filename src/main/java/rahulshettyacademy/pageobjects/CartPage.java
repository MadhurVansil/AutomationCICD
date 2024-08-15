package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	
	@FindBy(css="li[class='totalRow'] button")
	WebElement checkoutEle;
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifyProductDisplay(String productName)
	
	{
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
		
	}
	
	
//	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	public CheckoutPage goToCheckout()
	{
		
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
	
	
	
}
