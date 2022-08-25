package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastnameincontactinfopg;

	public WebElement getLastnameincontactinfopg() {
		return lastnameincontactinfopg;
	}
	

}
