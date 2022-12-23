package listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.Base;

public class Suitelistener implements ITestListener, IAnnotationTransformer{
	
	public void onTestFailure(ITestResult result) {
		
	
		String fileName=System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		
		File sfile=((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
		
        try {
			FileUtils.copyFile(sfile, new File(fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
	
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   annotation.setRetryAnalyzer(RetryAnalyzerClass.class);
		  }

}
