package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

   WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//img[@title='Create Contact...']")
	private WebElement createcontactbtn;

	@FindBy(name="search_text")
	private WebElement searchboxtb;
	
	@FindBy(name="search_field")
	private WebElement searchdropdown;
	
	@FindBy(name="submit")
	private WebElement searchbutton;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement selectcontact;
	
	@FindBy(name="search")
	private WebElement searchbuttonincontactpagefromorg;
	
	
	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}

	public WebElement getSearchboxtb() {
		return searchboxtb;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}
	
	
	public WebElement getSelectcontact() {
		return selectcontact;
	}

	public void searchContactInContactMainPage(String contactlastname) {
		searchboxtb.sendKeys(contactlastname);
		selectByValue(driver, searchdropdown, "lastname");
		searchbutton.click();
		selectcontact.click();
		
	}
	
	public void searchContactFromOrganizationPage(String contactlastname) {
		
		searchboxtb.sendKeys(contactlastname);
		selectByValue(driver, searchdropdown, "lastname");
		searchbuttonincontactpagefromorg.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+contactlastname+"')]")).click();
		
	}
	
	
	
	
	
	
}
