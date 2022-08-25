package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.GenricUtility.WebDriverUtility;

public class CampaignsPage {
	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignbutton;
	
	@FindBy(name="search_text")
	private WebElement searchtb;
	
	@FindBy(name="search_field")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/tbody/tr/td[@class='small']")
	private WebElement showingrecords;
	

	public WebElement getCreatecampaignbutton() {
		return createcampaignbutton;
	}
	
	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getShowingrecords() {
		return showingrecords;
	}


}
