package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class KeysUpDown extends TestBase {

	@Test
	public void keysUpDown() {
//		Go to google
		driver.get("http://www.google.com");
		try {
			driver.findElement(By.xpath("//*[text()='I agree']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
//		Send iPhone X prices => convert small letter capital vice versa.
		WebElement textBox= driver.findElement(By.name("q"));
		Actions action = new Actions(driver);
		action.keyDown(textBox,Keys.SHIFT).
			   sendKeys("iPhone X prices").
			   keyUp(textBox,Keys.SHIFT).
			   perform();
		
//		Highlight the search box by double clicking
		
		
	}
}
