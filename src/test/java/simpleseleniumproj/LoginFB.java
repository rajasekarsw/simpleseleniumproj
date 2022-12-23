package simpleseleniumproj;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Base;
import io.opentelemetry.api.internal.Utils;
import pages.FBLoginPage;
import utils.Utilis;

public class LoginFB extends Base
{
	
	public String url="";
	//public WebDriver driver;
	FBLoginPage fbLoginPage=null;
	
	
	
	
	@BeforeClass
	public void init()
	{
		fbLoginPage= new FBLoginPage(driver);
	}
	@BeforeMethod
	public void beforeMethod(Method testMethod)
	{
		extentTest=extentReports.createTest(testMethod.getName());
	}
	
	@Test(priority=1)
	public void openFBLoginPage() 
	{
		 url=(String) prop.get("url");
		 driver.get(url);
	}
	
	@Test(priority=2)
	public void loginFBPage()
	{
		
		
		fbLoginPage.enterUserName();
		fbLoginPage.enterPassword();
		fbLoginPage.clickLogin();
		
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		String methodName=result.getMethod().getMethodName();
		
		String logText="Testcase "+methodName+" Passed";
		
		Markup markup=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.log(Status.PASS, markup);
	}
	}
	

}
