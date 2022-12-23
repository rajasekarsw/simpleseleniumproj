package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBLogoutPage extends BasePO{

	public FBLogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//div[@aria-label='Account controls and settings']/span")
	private WebElement profileButton;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logout;
	
	public void clickProfile()
	{
		profileButton.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
