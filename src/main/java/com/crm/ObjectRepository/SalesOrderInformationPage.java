package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderInformationPage {
	
	public SalesOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement salesorderlinkinsalesorderinfopage;

	public WebElement getSalesorderlinkinsalesorderinfopage() {
		return salesorderlinkinsalesorderinfopage;
	}
	
	public void clickOnSalesOrderLink() {
		salesorderlinkinsalesorderinfopage.click();
		
	}

}
