package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	
	
	WebDriver driver;
	public ConfirmationPage (WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// driver.findElement(By.cssSelector(".hero-primary")
	
	@FindBy(css=".hero-primary")
	WebElement comfirmationMessage;
	
	public String getConfirmationMessage()
	{
		
		return comfirmationMessage.getText();
	}
}
