package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility{
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorganizationbtn;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtbfromsalespg;
	
	@FindBy(name="search")
	private WebElement searchbtnfrmsalespg;
	
	@FindBy(id="id=1")
	private WebElement orgnamefrmpopup;
	
	public WebElement getCreateorganizationbtn() {
		return createorganizationbtn;
	}
	
	
	public WebElement getSearchtbfromsalespg() {
		return searchtbfromsalespg;
	}


	public WebElement getSearchbtnfrmsalespg() {
		return searchbtnfrmsalespg;
	}


	public WebElement getOrgnamefrmpopup() {
		return orgnamefrmpopup;
	}


	public void clickOnCreateOrgbtn() {
		createorganizationbtn.click();
		
	}
	
	public void selectorgnamefrompopupinsales(String organizationname) {
		searchtbfromsalespg.sendKeys(organizationname);
		searchbtnfrmsalespg.click();
		
		driver.findElement(By.xpath("//td/a[text()='"+organizationname+"']")).click();
        switchToAlertPopUpAccept(driver);
		
	}

}
