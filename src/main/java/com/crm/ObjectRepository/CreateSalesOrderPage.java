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

public class CreateSalesOrderPage {
WebDriver driver;
	public CreateSalesOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="subject")
	private WebElement salessubject;

	@FindBy(name="sostatus")
	private WebElement salestatusdd;

	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement addorganizationbtn;

	@FindBy(name="invoicestatus")
	private WebElement invoicestatusdd;

	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingaddresstb;

	@FindBy(xpath="//b[text()='Copy Billing address']/preceding-sibling::input")
	private WebElement copybillingaddressbtn;

	@FindBy(id="searchIcon1")
	private WebElement producticon;

	@FindBy(id="qty1")
	private WebElement qtytb;

	@FindBy(id="listPrice1")
	private WebElement listpricebtn;

	@FindBy(xpath="(//input[@value='  Save  '])[2] ")
	private WebElement savebtn;

	public WebElement getSalessubject() {
		return salessubject;
	}

	public WebElement getSalestatusdd() {
		return salestatusdd;
	}

	public WebElement getAddorganizationbtn() {
		return addorganizationbtn;
	}

	public WebElement getInvoicestatusdd() {
		return invoicestatusdd;
	}

	public WebElement getBillingaddresstb() {
		return billingaddresstb;
	}

	public WebElement getCopybillingaddressbtn() {
		return copybillingaddressbtn;
	}

	public WebElement getProducticon() {
		return producticon;
	}

	public WebElement getQtytb() {
		return qtytb;
	}

	public WebElement getListpricebtn() {
		return listpricebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public String createSalesOrder(String orgname, String productname) throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String subject = eLib.getDataFromExcel("Sheet1", 7, 5)+jLib.getRandomNumber();
		String billingadd = eLib.getDataFromExcel("Sheet1", 7, 6);
		String qty = eLib.getDataFromExcel("Sheet1", 7, 7);
		String listprice = eLib.getDataFromExcel("Sheet1", 7, 8);
		
		salessubject.sendKeys(subject);
		wLib.selectByValue(driver, salestatusdd, "Approved");
		
		addorganizationbtn.click();
		
		wLib.switchToWindow(driver, "Accounts");
		OrganizationPage op=new OrganizationPage(driver);
		op.selectorgnamefrompopupinsales(orgname);
		wLib.switchToWindow(driver, "index.php?module=SalesOrder&action=EditView&return_action=DetailView&parenttab=Sales");
		
		wLib.selectByValue(driver, invoicestatusdd, "Sent" );
		
		billingaddresstb.sendKeys(billingadd);
		copybillingaddressbtn.click();
		
		producticon.click();
		wLib.switchToWindow(driver, "Products");
		ProductsPage prod=new ProductsPage(driver);
		prod.getProductinsalesPage(productname);
		wLib.switchToWindow(driver, "index.php?module=SalesOrder&action=EditView&return_action=DetailView&parenttab=Sales");
		
		qtytb.sendKeys(qty);
		
		listpricebtn.sendKeys(listprice);
		
		savebtn.click();
		return subject;

	}




}
