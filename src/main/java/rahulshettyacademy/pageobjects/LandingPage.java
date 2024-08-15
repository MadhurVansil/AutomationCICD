package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
	WebDriver driver;
	
	public LandingPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	
	@FindBy(id="userPassword")
	WebElement passwordEl;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginToApplication(String username,String password)
	{
		userEmail.sendKeys(username);
		passwordEl.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	
	public String getErrorMessage()
	{
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
