package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.ExcelUtility;
import com.crm.GenricUtility.JavaUtility;

public class CreateContactPage {
	
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement contactlastnametb;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td[1]/div/input[@type='submit']")
	private WebElement contactsavebtn;

	public WebElement getContactlastnametb() {
		return contactlastnametb;
	}
	
	public WebElement getContactsavebtn() {
		return contactsavebtn;
	}
	
	

	public void createContact(String contactlastname) {
		getContactlastnametb().sendKeys(contactlastname);
		getContactsavebtn().click();
	}
}
