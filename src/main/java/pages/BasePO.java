package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	
	public BasePO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
