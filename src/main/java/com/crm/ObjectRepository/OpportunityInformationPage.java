package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Contacts']")
	private WebElement contactnameinopportunityinfopg;
	

	public WebElement getContactnameinopportunityinfopg() {
		return contactnameinopportunityinfopg;
	}


}
