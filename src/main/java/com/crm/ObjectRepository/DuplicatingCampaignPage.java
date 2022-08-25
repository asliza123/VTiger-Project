package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.WebDriverUtility;

public class DuplicatingCampaignPage {
	
	WebDriver driver=null;

	public DuplicatingCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignstatus")
	private WebElement campaignstatusdd;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td/div/input[@value='  Save  ']")
	private WebElement savebtn;
	
	
	public WebElement getCampaignstatusdd() {
		return campaignstatusdd;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void editDuplicateCampaign() {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.selectByValue(driver, campaignstatusdd, "Completed");	
		savebtn.click();
	}
}
