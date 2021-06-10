package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class ContextClick extends TestBase {
	/*
	 * Context click means right click
	 Create a class: ActionsClass1
	Create a test method : contextClickMethod() and test the following scenario:
	Given user is on the https://the-internet.herokuapp.com/context_menu
	When use Right clicks on the box
	Then verify the alert message is “You selected a context menu”
	Then accept the alert
	 */
	
	@Test
	public void contextClickMethod() {
		//Given user is on the https://the-internet.herokuapp.com/context_menu
		driver.get("https://the-internet.herokuapp.com/context_menu");
		//When use Right clicks on the box
		Actions action = new Actions(driver);
		WebElement box= driver.findElement(By.xpath("//div[@id='hot-spot']"));
		action.contextClick(box).perform();
		//Then verify the alert message is “You selected a context menu”
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println("Actual Alert Message: "+ alertMessage);
		String expected= "You selected a context menu";
		Assert.assertEquals(alertMessage, expected);
		
		//Then accept the alert
		driver.switchTo().alert().accept();
		
		
	}
	
	

}
