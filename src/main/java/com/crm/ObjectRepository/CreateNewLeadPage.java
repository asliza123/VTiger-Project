package com.crm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.ExcelUtility;
import com.crm.GenricUtility.JavaUtility;

public class CreateNewLeadPage {
	
	public  CreateNewLeadPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="lastname")
	private WebElement leadlastname;
	
	@FindBy(name="company")
	private WebElement leadcompany;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;

	public WebElement getLeadlastname() {
		return leadlastname;
	}

	public WebElement getLeadcompany() {
		return leadcompany;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createLead() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		String leadname=eLib.getDataFromExcel("Sheet1", 7, 3)+jLib.getRandomNumber();
		String comp=eLib.getDataFromExcel("Sheet1", 7, 4)+jLib.getRandomNumber();
		leadlastname.sendKeys(leadname);
		leadcompany.sendKeys(comp);
		savebtn.click();
		
	}
	

}
