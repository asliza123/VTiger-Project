package com.LEAD;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenricUtility.BaseClass;
import com.crm.ObjectRepository.CreateNewLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;

public class CreateNewLeadTest extends BaseClass{
	
	@Test(groups="Smoke")
	public void createLead() throws EncryptedDocumentException, IOException {
		HomePage hp= new HomePage(driver);
		hp.clickOnLeadsLink();
		SoftAssert sa=new SoftAssert();
		//sa.assertEquals(false, true);
		sa.assertAll();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLead();
		
		CreateNewLeadPage lead= new CreateNewLeadPage(driver);
		lead.createLead();
		
	}
}
