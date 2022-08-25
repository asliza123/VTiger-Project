package com.PRODUCT;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenricUtility.BaseClass;

public class scrollBy extends BaseClass {

	@Test
	public void sc() {
		
		WebElement loc = driver.findElement(By.id("maincont_row_2"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Point a = loc.getLocation();
		int x = a.getX();
		int y = a.getY();
		
		js.executeScript("window.scrollBy("+x+","+y+")");



	}

}
