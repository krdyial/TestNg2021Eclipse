package com.eclipsetestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class ScrollUpDown extends TestBase{
//	Create a class: ActionClass4
//	Create test method : scrollUpDown()
//	Go to amazon
//	Scroll the page down
//	Scroll the page up
	
	@Test
	public void scrollUpDown() {
		driver.get("https://www.amazon.com");
		Actions action= new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform(); //moves less than PAGE_DOWN
		
		
	}
}
