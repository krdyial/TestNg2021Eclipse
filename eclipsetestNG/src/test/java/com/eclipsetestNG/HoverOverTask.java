package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class HoverOverTask extends TestBase {

//	Given user is on the https://www.amazon.com/
//	When use click on “Your Account” link
//	Then verify the page title contains “Your Account”
//	Create another method: imageTest()
//	Hover over the Language
//	And change the language 
	
	@Test
	public void hoverOverPractice() {
		driver.get("https://www.amazon.com/");
//		When use click on “Your Account” link
		WebElement userButton= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		Actions action = new Actions(driver);
		action.moveToElement(userButton).perform();
		driver.findElement(By.linkText("Account")).click();
		String accountTitle= driver.getTitle();
		String expectedTitle= "Your Account";
//		Then verify the page title contains “Your Account”
		Assert.assertTrue(accountTitle.contains(expectedTitle));
		
		
	}
//	Create another method: changeLanguageTest()
	@Test
	public void changeLanguageTest() {
//		Hover over the Try Prime
		driver.get("https://www.amazon.com/");
		Actions action = new Actions(driver);
		WebElement language= driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));
		action.moveToElement(language).perform();
		WebElement espanolButton=driver.findElement(By.xpath("(//i[@class='icp-radio'])[1]"));
		espanolButton.click();
		
		
		
	}

}
