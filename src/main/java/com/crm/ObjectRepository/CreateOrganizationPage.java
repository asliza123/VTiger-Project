package com.crm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.ExcelUtility;
import com.crm.GenricUtility.JavaUtility;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	}
	
	@FindBy (xpath="//input[@name='accountname']")
	private WebElement organizationname;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;

	public WebElement getOrganizationname() {
		return organizationname;
	}
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}



	public String createOrganization() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		String orgname = eLib.getDataFromExcel("Sheet1", 7, 2)+jLib.getRandomNumber();
		organizationname.sendKeys(orgname);
		savebtn.click();
		
		return orgname;
	}
	
	



}
