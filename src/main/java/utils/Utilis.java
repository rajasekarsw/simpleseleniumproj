package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Utilis extends Base{
	

	public static int getWindowHandlesCount()
	{
		return driver.getWindowHandles().size();
		
	}
	
	
	public static void dismissAlert()
	{
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}
	
	public static void verifyTitle()
	{
		driver.getTitle().equals("Facebook");
	}

}
