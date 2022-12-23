package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage extends BasePO{
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	
	@FindBy(name="pass")
	private WebElement password;
	
	@FindBy(xpath="//button[@name=\"login\"]")
	WebElement loginButton;
	public FBLoginPage(WebDriver driver) {
		
		super(driver);
	
	}

	public void enterUserName()
	{
		userName.sendKeys("rajrams104@gmail.com");
	}
	
	
	
	
	public void enterPassword()
	{
		password.sendKeys("ilikeher");
	}

	public void clickLogin()
	{
		loginButton.click();
	}
}
