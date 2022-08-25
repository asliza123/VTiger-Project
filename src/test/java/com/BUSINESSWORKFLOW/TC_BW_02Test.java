package com.BUSINESSWORKFLOW;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenricUtility.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreateSalesOrderPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.ProductsPage;
import com.crm.ObjectRepository.SalesOrderInformationPage;
import com.crm.ObjectRepository.SalesOrderPage;
@Listeners(com.crm.GenricUtility.ListenerImplementationClass.class)
public class TC_BW_02Test extends BaseClass{
	HomePage hp;
	ProductsPage prod;
	CreateOrganizationPage cop;
	String orgname;
	String productname;
	
	
	@Test(groups = "Smoke")
	public void createOrg() throws EncryptedDocumentException, IOException{
		hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgbtn();
		cop=new CreateOrganizationPage(driver);
		 orgname=cop.createOrganization();
		 driver.navigate().refresh();
	}
	
	@Test(groups = "Smoke")
	public void createProd() throws EncryptedDocumentException, IOException{
		hp=new HomePage(driver);
		hp.getProductslink().click();
		prod=new ProductsPage(driver);
		prod.getCreateproductbtn().click();
		CreateProductPage pr=new CreateProductPage(driver);
		productname=pr.createProduct();
		driver.navigate().refresh();
	}
	
	@Test(dependsOnMethods = {"createOrg","createProd"} )
	public void createSales() throws EncryptedDocumentException, IOException{
		hp=new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickonSalesOrderLink();
		SalesOrderPage sp=new SalesOrderPage(driver);
		sp.clickOnCreateSalesOrderBtn();
		CreateSalesOrderPage sale=new CreateSalesOrderPage(driver);
		String salessubject=sale.createSalesOrder(orgname, productname);
		
		SalesOrderInformationPage info=new SalesOrderInformationPage(driver);
		info.clickOnSalesOrderLink();
		sp.searchSalesOrder(salessubject);
		String sub=driver.findElement(By.xpath("//a[@title='Sales Order' and text()='"+salessubject+"']")).getText();
		
		System.out.println(salessubject);
		System.out.println(sub);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(salessubject, sub);
		
		sa.assertAll();
	}

}
