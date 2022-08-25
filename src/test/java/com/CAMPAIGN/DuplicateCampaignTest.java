package com.CAMPAIGN;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenricUtility.BaseClass;
import com.crm.GenricUtility.WebDriverUtility;
import com.crm.ObjectRepository.CampaignInformationPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.DuplicatingCampaignPage;
import com.crm.ObjectRepository.HomePage;

public class DuplicateCampaignTest extends BaseClass {
	WebDriverUtility wLib=new WebDriverUtility();

	@Test
	public void duplicateCampaignTest() throws EncryptedDocumentException, IOException {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnCampaigns();
		
		CampaignsPage camp=new CampaignsPage(driver);
		camp.getCreatecampaignbutton().click();
		
		CreateCampaignPage c=new CreateCampaignPage(driver);
		
		String campaignname=c.createCampaign();
		
		System.out.println(campaignname);
		
		CampaignInformationPage info=new CampaignInformationPage(driver);
		info.clickOnDuplicateCampaign();
		
		DuplicatingCampaignPage dup=new DuplicatingCampaignPage(driver);
		dup.editDuplicateCampaign();
		
		info.clickOnCampaignLink();
		
		camp.getSearchtb().sendKeys(campaignname);
//		String camp = campaignname.replace(" ", "+");
		wLib.selectByValue(driver, camp.getSearchdd(), "campaignname");

		camp.getSearchbtn().click();
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement xpath= driver.findElement(By.xpath("//input[contains(@value,'"+campaignname+"')]"));
		wait.until(ExpectedConditions.textToBePresentInElementValue(xpath, campaignname));
		
//		WebElement xpath= driver.findElement(By.xpath("//input[@value='"
//				+ "&query=true&search_field=campaignname&search_text="+camp+"&searchtype=BasicSearch']"));
//		wait.until(ExpectedConditions.textToBePresentInElementValue(xpath, camp));
//		
		String message=camp.getShowingrecords().getText();
		
		SoftAssert as=new SoftAssert();
		as.assertEquals(campaignname, campaignname, message);
		
		
	}
}
