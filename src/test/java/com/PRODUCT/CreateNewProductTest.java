package com.PRODUCT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenricUtility.BaseClass;
import com.crm.GenricUtility.ExcelUtility;
import com.crm.GenricUtility.JavaUtility;
import com.crm.GenricUtility.WebDriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInformationPage;
import com.crm.ObjectRepository.ProductsPage;

public class CreateNewProductTest extends BaseClass{
    WebDriverUtility wLib=new WebDriverUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	
	@Test(groups = "Smoke")
	public void createNewProduct() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		
		ProductsPage product=new ProductsPage(driver);
		product.getCreateproductbtn().click();
		
		
		CreateProductPage cp=new CreateProductPage(driver);
		 String productname=cp.createProduct();
		
		ProductInformationPage pi=new ProductInformationPage(driver);
		
	    String createdproductname=pi.getProductnameinproductinfopg().getText();
	    
	    Assert.assertEquals(productname, createdproductname);
		driver.navigate().refresh();
		
		hp.getProductslink().click();
		product.getSearchbox().sendKeys(productname);
		wLib.selectByVisibleText(driver, product.getSearchboxdropdown(), "Product Name" );
		product.getSearchbtn().click();	
		WebElement dynamic = driver.findElement(By.xpath("//input[@value='&query=true&search_field=productname&search_text="+productname+"&searchtype=BasicSearch']"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(dynamic, productname));
		String res= driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::td[contains(text(),'Showing Records')]")).getText();
		
		System.out.println(res);
		
	}

}
