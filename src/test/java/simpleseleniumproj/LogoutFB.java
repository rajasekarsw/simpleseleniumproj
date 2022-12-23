package simpleseleniumproj;



import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Base;
import pages.FBLogoutPage;
import utils.Utilis;

public class LogoutFB extends Base
{
	
	FBLogoutPage fbLogoutPage=null;

	@BeforeClass
	public void initLogoutPage()
	{
		fbLogoutPage=new FBLogoutPage(driver);
	}
	@BeforeMethod
	public void beforeMethod(Method testMethod)
	{
		extentTest=extentReports.createTest(testMethod.getName());
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
	@Test(priority=3)
	public void validateTitle()
	{
		Utilis.verifyTitle();
	}
	
	@Test(priority=4)
	public void logout()
	{
		fbLogoutPage.clickProfile();
		fbLogoutPage.clickLogout();
		
	}
	

}
