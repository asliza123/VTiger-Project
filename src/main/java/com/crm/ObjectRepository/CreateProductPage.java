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

public class CreateProductPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@name='productname']")
	private WebElement productnametb;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td[1]/div/input[@type='submit']")
	private WebElement savebtn;

	public WebElement getProductnametb() {
		return productnametb;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

	public String createProduct() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		String productname=eLib.getDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		getProductnametb().sendKeys(productname);
		getSavebtn().click();
		return productname;
		
	}
}
