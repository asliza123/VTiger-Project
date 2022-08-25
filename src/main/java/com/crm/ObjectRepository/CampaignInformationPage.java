package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='dvtTabCacheBottom']/input[@title='Duplicate [Alt+U]']")
	private WebElement duplicatebtn;

	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement campaignlink;
	
	public WebElement getDuplicatebtn() {
		return duplicatebtn;
	}
	
	
	public WebElement getCampaignlink() {
		return campaignlink;
	}


	public void clickOnDuplicateCampaign() {
		duplicatebtn.click();
	}
	
	public void clickOnCampaignLink() {
		campaignlink.click();
	}
	
	

}
