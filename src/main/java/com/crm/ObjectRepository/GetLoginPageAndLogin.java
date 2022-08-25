package com.crm.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.FileUtility;

public class GetLoginPageAndLogin {
	WebDriver driver;
	public GetLoginPageAndLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernametb;
	
	@FindBy(name="user_password")
	private WebElement passwordtb;
	
	@FindBy(id="submitButton")
	private WebElement submitbtn;

	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void loginToApp() throws IOException {
		
		FileUtility fLib=new FileUtility();
		String url=fLib.getValueFromPropertyFile("url");
		String user=fLib.getValueFromPropertyFile("username");
		String pass=fLib.getValueFromPropertyFile("password");
		driver.get(url);
		usernametb.sendKeys(user);
		passwordtb.sendKeys(pass);
		submitbtn.click();
	}
	
	
	

}