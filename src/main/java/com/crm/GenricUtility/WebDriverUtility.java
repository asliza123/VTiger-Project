package com.crm.GenricUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Meghana
 *
 */
public class WebDriverUtility {
	/**
	 * @author Asmita
	 * it's for maximizing the browser
	 * @param driver 
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
/**
 * used for implicitly wait of elements in Document Object Model(DOM) page
 * @param driver
 */
	public void implicitWaitForElementsInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * used for explicitly wait for page until expected url appears
	 * @param driver
	 * @param PageURL
	 */
	
	public void explicitWaitForPage(WebDriver driver, String PageURL) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains(PageURL));	
	}
	/**
	 * used for explicit wait for visibility of element
	 */
	
	public void explicitWaitForVisibilityOfElements(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	/**
	 * used to switch between windows
	 */
	
	public void switchToWindow(WebDriver driver, String PartialUrl) {
		//String ParentUrl = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i=s.iterator();
		String expectedwindow="null";
		while(i.hasNext()) {
			expectedwindow=i.next();
		driver.switchTo().window(expectedwindow);
		String CurrentwindowTitle=driver.getTitle();
		if(CurrentwindowTitle.contains(PartialUrl)) {
			break;
		}
		}
	}


	/**
	 * used to switch for alert popup and accept
	 */
	
	public void switchToAlertPopUpAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch for alert popup and dismiss
	 */
	public void switchToAlertPopUpDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame using frame index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to perform mouse over action
	 */
	public void mouseHoverToElement(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * used to perform right click action on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * used to drag a selected element and drop in targeted area
	 * @param driver
	 * @param dragele
	 * @param targetele
	 */
	public void dragAndDropAElement(WebDriver driver, WebElement dragele, WebElement targetele) {
		Actions a=new Actions(driver);
		a.dragAndDrop(dragele, targetele).perform();
	}
	/**
	 * used to perform drag and drop action
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * used to select element by index from dropdown
	 * @param driver
	 * @param element
	 * @param index
	 */
	
	public void selectByIndex(WebDriver driver, WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select a eleemnt in dropdown through visible text
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebDriver driver, WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * used to select a element in dropdown by value
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebDriver driver, WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}

	}

