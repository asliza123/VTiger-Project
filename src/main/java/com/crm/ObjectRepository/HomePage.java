package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement morelink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[text()='Products']")
	private WebElement productslink;
	
	@FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[text()='Contacts']")
	private WebElement contactslink;
	
	@FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[text()='Opportunities']")
	private WebElement opportunitieslink;
	
	@FindBy(xpath="//table[@class='small']/descendant::img[@src='themes/softed/images/user.PNG']")
	private WebElement adminicon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	@FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[text()='Leads']")
	private WebElement leadslink;
	
	@FindBy(name="Sales Order")
	private WebElement salesorderlink;
	
	@FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[text()='Organizations']")
	private WebElement organizationslink;
	
	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getSalesorderlink() {
		return salesorderlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	
	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}
	
	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	public WebElement getAdminicon() {
		return adminicon;
	}
	
	
	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public void clickOnMoreLink() {
		morelink.click();
	}
	
	public void clickOnCampaigns() {
		campaignslink.click();
	}
	
	public void mouseHoverOnAdminIcon() {
		mouseHoverToElement(driver, adminicon);
		
	}
	public void clickOnSignOutLink() {
		signout.click();
	}

	public void clickOnLeadsLink() {
		leadslink.click();
	}

	public void clickonSalesOrderLink() {
		salesorderlink.click();
	}
	
	public void clickOnOrganizationLink() {
		organizationslink.click();
	}




	
	
	
	

}
