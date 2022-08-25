package com.crm.GenricUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.GetLoginPageAndLogin;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LaunchBrowser;

public class BaseClass{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public LaunchBrowser lb=new LaunchBrowser();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	
	@BeforeSuite (groups = {"Smoke", "Regression"})
	public void connectDB() throws SQLException {
		dLib.connectDB();
		System.out.println("Before Suite executed");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke", "Regression"})
	public void launchBrowser() throws IOException {
		driver=lb.launchBrowser();
		wLib.implicitWaitForElementsInDOM(driver);
		System.out.println("Before Class executed");	
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void loginToApplication() throws IOException {
		GetLoginPageAndLogin login=new GetLoginPageAndLogin(driver);
		login.loginToApp();	
		System.out.println("Before Method executed");
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void logOutFromApplication() {
		 HomePage hp=new HomePage(driver);
		 hp.mouseHoverOnAdminIcon();
		hp.clickOnSignOutLink();
		System.out.println("After Method Executed");
	}
	
	@AfterClass(groups = {"Smoke", "Regression"})
	public void closeBrowser() {
		driver.close();
		System.out.println("After Class Executed");
	}
	
	@AfterSuite(groups = {"Smoke", "Regression"})
	public void closeDB() throws SQLException {
		dLib.closeDB();
		System.out.println("After Suite Executed");
	}
	
}
