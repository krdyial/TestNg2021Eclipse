package com.eclipsetestNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class WindowHandleExample extends TestBase{

	@Test
	public void windowHandle() {
//		Create a new Class Tests package: WindowHandleExample
//		Given user is on the https://the-internet.herokuapp.com/windows
		driver.get("https://the-internet.herokuapp.com/windows");
//		Then user verifies the text : “Opening a new window”
		String header= driver.findElement(By.xpath("//h3")).getText();
		String expectedText= "Opening a new window";
		Assert.assertTrue(header.contains(expectedText),header+"does not contain"+expectedText);
//		Then user verifies the title of the page is “The Internet”
		String titleOfPage= driver.getTitle();
		String expectedTitle="The Internet";
		Assert.assertEquals(titleOfPage, expectedTitle);
		
		String window1=driver.getWindowHandle();
		System.out.println("Default window Handle: "+ window1);
//		When user clicks on the “Click Here” button
		driver.findElement(By.linkText("Click Here")).click();
//		Then user verifies the new window title is “New Window”
		//We have to switch to the new window to get new pages title
		//We will get all open window handles and put them in a set
		Set <String> allWindowsHandle= driver.getWindowHandles();
		//Using for each loop we can switch to the window
		for(String e:allWindowsHandle) {
			if (!e.equals(window1)) {
			driver.switchTo().window(e);	
			}
		}
				
		 
//		Then user verifies the text: “New Window”
		String actualTitle=driver.getTitle();
		System.out.println("Actual Title: "+actualTitle);
		String  expectedTitle1= "New Window";
		Assert.assertTrue(actualTitle.equals(expectedTitle1));
//		When user goes back to the previous window and then verifies the title : “The Internet”
		driver.switchTo().window(window1);
		System.out.println("Default window : "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("The Internet"));
	}
	
}
