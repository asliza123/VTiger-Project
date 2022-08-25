package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.JavaUtility;
import com.crm.GenricUtility.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public CreateOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement opportunitynametb;
	
	@FindBy(id="related_to_type")
	private WebElement relatetodropdown;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement relatetoaddbutton;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement assignedtouserradiobtn;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignedtogroupradiobtn;
	
	@FindBy(name="closingdate")
	private WebElement calendarbtn;
	
	@FindBy(name="sales_stage")
	private WebElement salesstagedropdown;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td[1]/div/input[@value='  Save  ']")
	private WebElement savebtn;

	public WebElement getOpportunitynametb() {
		return opportunitynametb;
	}

	public WebElement getRelatetodropdown() {
		return relatetodropdown;
	}
	
	public WebElement getRelatetoaddbutton() {
		return relatetoaddbutton;
	}

	public WebElement getAssignedtouserradiobtn() {
		return assignedtouserradiobtn;
	}

	public WebElement getAssignedtogroupradiobtn() {
		return assignedtogroupradiobtn;
	}

	public WebElement getCalendarbtn() {
		return calendarbtn;
	}

	public WebElement getSalesstagedropdown() {
		return salesstagedropdown;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createOpportunity(String opportunityname, String contactlastname) {
		opportunitynametb.sendKeys(opportunityname);
		selectByValue(driver, relatetodropdown, "Contacts");
		relatetoaddbutton.click();
		switchToWindow(driver, "Contacts");
		ContactsPage cont=new ContactsPage(driver);
		cont.searchContactFromOrganizationPage(contactlastname);
		switchToWindow(driver, "Potentials");
		assignedtogroupradiobtn.click();
		JavaUtility jLib=new JavaUtility();
		calendarbtn.sendKeys(jLib.getDate());
		selectByValue(driver, salesstagedropdown, "Needs Analysis");
		savebtn.click();
			
	}
	
	
	
	
	

}
