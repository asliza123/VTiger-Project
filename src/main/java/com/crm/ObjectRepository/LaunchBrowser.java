package com.crm.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenricUtility.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
		public WebDriver launchBrowser() throws IOException {
		FileUtility fLib=new FileUtility();
			String Browser=fLib.getValueFromPropertyFile("browser");
			
			if(Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				return driver;
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver=new FirefoxDriver();
				return driver;
			}
			else {
				System.out.println("Invalid Browser");
				return null;
			}
		
			}
			
			
	}
	
	
