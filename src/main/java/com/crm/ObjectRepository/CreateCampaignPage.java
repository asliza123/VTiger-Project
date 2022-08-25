package com.crm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricUtility.ExcelUtility;
import com.crm.GenricUtility.JavaUtility;
import com.crm.GenricUtility.WebDriverUtility;

public class CreateCampaignPage {
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignnametb;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement assignedtouser;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignedtogroup;
	
	@FindBy(name="campaigntype")
	private WebElement campaigntypedd;
	
	@FindBy(name="campaignstatus")
	private WebElement campaignstatusdd;
	
	@FindBy(name="closingdate")
	private WebElement expecteddate;
	
	@FindBy(xpath="//input[@value='  Save  ']  ")
	private WebElement savebtn;
	public WebElement getCampaignnametb() {
		return campaignnametb;
	}

	public WebElement getAssignedtouser() {
		return assignedtouser;
	}

	public WebElement getAssignedtogroup() {
		return assignedtogroup;
	}

	public WebElement getCampaigntypedd() {
		return campaigntypedd;
	}

	public WebElement getCampaignstatusdd() {
		return campaignstatusdd;
	}

	public WebElement getExpecteddate() {
		return expecteddate;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public String createCampaign() throws EncryptedDocumentException, IOException {
		
		String campaignname=eLib.getDataFromExcel("Sheet1", 5, 2)+jLib.getRandomNumber();
		campaignnametb.sendKeys(campaignname);
		assignedtogroup.click();
		wLib.selectByValue(driver, campaigntypedd, "Advertisement");
		wLib.selectByValue(driver, campaignstatusdd, "Active");
		expecteddate.sendKeys(jLib.getDate());
		savebtn.click();
		
		return campaignname;
	}
	

}
