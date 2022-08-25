package com.crm.GenricUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {
	
	  public void onTestFailure(ITestResult result) {
		  JavaUtility jLib=new JavaUtility();
		  String testName= result.getMethod().getMethodName();
		  
		  EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		  File src=edriver.getScreenshotAs(OutputType.FILE);
		  File dest=new File("./screenshot/"+testName+jLib.getDateNormalFormat()+".png") ;
				  try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}    
	  }
}
