package com.eclipsetestNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class WindowHandleExercise02 extends TestBase {
	/*
	 1- User go to the "https://demoqa.com/browser-windows"
	 2- User gets title
	 3- USer verifies the title if "ToolsQA"
	 4- USer clicks New Tab Button
	 5- User switch to new tab
	 6- User verifies new windows header if "This is a sample page"
	 7-User returns to the default page
	 8- User verifies the title if "ToolsQA"
	 */
	
	@Test
	public void demoTest() {
		//User go to the "https://demoqa.com/browser-windows"
		driver.get("https://demoqa.com/browser-windows");
		 //User gets title
		String defaultTitle = driver.getTitle();
		System.out.println("Actual Title of Default Page: "+ defaultTitle);
		// USer verifies the title if "ToolsQA"
		String expectedTitle= "ToolsQA";
		Assert.assertEquals(defaultTitle, expectedTitle);
		String defaultPage= driver.getWindowHandle(); //default Page
		
		driver.findElement(By.id("tabButton")).click();
		
		Set<String> allWindows= driver.getWindowHandles();
		
		for (String string : allWindows) {
			if(!string.equals(defaultPage)) {
				driver.switchTo().window(string);
			}
		}
		//User verifies new windows header if "This is a sample page"
		String actualHeader = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println("Actual Header in new Tab: "+ actualHeader);
		String expectedHeader="This is a sample page";
		Assert.assertEquals(actualHeader, expectedHeader);
		
		//User returns to the default page
		driver.switchTo().window(defaultPage);
		Assert.assertTrue(driver.getTitle().equals(defaultTitle));
		
		
	}

}
