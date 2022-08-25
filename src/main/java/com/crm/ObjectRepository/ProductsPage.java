package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.GenricUtility.WebDriverUtility;

public class ProductsPage extends WebDriverUtility{
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproductbtn;
	
	
	@FindBy(name="search_text")
	private WebElement searchbox;
	
	@FindBy(name="search_field")
	private WebElement searchboxdropdown;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	@FindBy(name="search")
	private WebElement searchnowbtn;
//	dynamic xpath for search box and table

	public WebElement getCreateproductbtn() {
		return createproductbtn;
	}
	
	public WebElement getSearchbox() {
		return searchbox;
	}
	
	public WebElement getSearchboxdropdown() {
		return searchboxdropdown;
	}
	

	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public void getProductinsalesPage(String productname) {
		
		searchbox.sendKeys(productname);
		searchnowbtn.click();
		
		WebElement name=driver.findElement(By.xpath("//td/a[text()='"+productname+"']"));
		
		name.click();
		
	}
	
	
	

}
