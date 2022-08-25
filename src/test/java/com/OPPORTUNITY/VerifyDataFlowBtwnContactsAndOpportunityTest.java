package com.OPPORTUNITY;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenricUtility.BaseClass;
import com.crm.ObjectRepository.ContactInformationPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportunityInformationPage;

public class VerifyDataFlowBtwnContactsAndOpportunityTest extends BaseClass{
	HomePage hp;
	String contactlastname;
	
	@Test(groups = "Smoke")
	public void preconditionCreateContact() throws EncryptedDocumentException, IOException  {

		hp =new HomePage(driver);
		hp.getContactslink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreatecontactbtn().click();
		contactlastname = eLib.getDataFromExcel("Sheet1", 3, 2)+jLib.getRandomNumber();
		CreateContactPage con=new CreateContactPage(driver);
		con.createContact(contactlastname);
		ContactInformationPage info=new ContactInformationPage(driver);
		
	    String lastname=info.getLastnameincontactinfopg().getText().trim();
	    
	    Assert.assertEquals(contactlastname,lastname);
	   
	}
	
		@Test (dependsOnMethods = "preconditionCreateContact", groups="Regression")
		public void verifyDataFlowBtwnContactAndOpportuniy() throws EncryptedDocumentException, IOException {
			hp.getOpportunitieslink().click();

			OpportunitiesPage op=new OpportunitiesPage(driver);
			op.getCreateopportunitybtn().click();
			String opportunityname=eLib.getDataFromExcel("Sheet1", 3, 3)+jLib.getRandomNumber();
			CreateOpportunityPage opp=new CreateOpportunityPage(driver);
			opp.createOpportunity(opportunityname, contactlastname);
			OpportunityInformationPage oppo=new OpportunityInformationPage(driver);
			
			String cname = oppo.getContactnameinopportunityinfopg().getText();
			
			SoftAssert as=new SoftAssert();
			as.assertEquals(opportunityname, cname);

		}
}
