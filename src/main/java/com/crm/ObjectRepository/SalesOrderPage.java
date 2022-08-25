package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.WebDriverUtility;

public class SalesOrderPage {
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	
	 public SalesOrderPage(WebDriver driver) {
		 this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 
	 @FindBy(xpath="//img[@title='Create Sales Order...']")
	 private WebElement createsalesorderbtn;
	 
	 @FindBy(xpath="//input[@class='txtBox']")
	 private WebElement searchtb;
	 
	 @FindBy(name="search_field")
	 private WebElement searchdd;
	 
	 @FindBy(name="submit")
	 private WebElement searchnowbtn;

	public WebElement getCreatesalesorderbtn() {
		return createsalesorderbtn;
	}
 
	 public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}

	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}

	public void clickOnCreateSalesOrderBtn() {
		 createsalesorderbtn.click();
		
	 }
	
	public void searchSalesOrder(String salessubject) {
		searchtb.sendKeys(salessubject);
		 wLib.selectByValue(driver, searchdd, "subject");
		 searchnowbtn.click();
		
		
	}
	

}
