package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Base {
	
	
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public ExtentSparkReporter extentSparkReporter;
	public static ExtentTest extentTest;
	public static Properties prop;
	public static  WebDriver getDriver()
	{
		
		Map<String,Integer> mappref =new HashMap<>();
		
		mappref.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions option=new ChromeOptions();
		
		
		option.setExperimentalOption("prefs", mappref);
		
		driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeSuite
	public void initDriver() throws FileNotFoundException, IOException
	{
		driver=getDriver();
		
		prop=new Properties();
		prop.load(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config\\property.properties")));
	   
	}
	
	
	
	@BeforeTest
	public void beforeTest()
	{
		extentReports=new ExtentReports();
		
		extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"automationreport.html");
		
		extentSparkReporter.config().setDocumentTitle("Automation report");
		extentSparkReporter.config().setEncoding("UTF-8");
		extentSparkReporter.config().setReportName("Automation test results");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Automation tester", "Rajasekar.S");
		
	}
	@AfterTest
	public void afterTest()
	{
		extentReports.flush();
	}
	@AfterSuite
	public void tearDown()
	{
	 driver.close();
	}

}
