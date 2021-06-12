package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class ExplicitWait02 extends TestBase {

//	Go to https://the-internet.herokuapp.com/dynamic_controls
//	Click enable Button
//	And verify the message is equal to “It's enabled!”
//	And verify the textbox is enabled (I can type in the box)
//	And click on Disable button
//	And verify the message is equal to “It's disabled!”
//	And verify the textbox is disabled (I cannot type in the box)
	
	@Test
	public void enableButton() {
		WebDriverWait wait= new WebDriverWait(driver, 10);
//		Go to https://the-internet.herokuapp.com/dynamic_controls
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//		Click enable Button
		WebElement enableButton= driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
		enableButton.click();
//		And verify the message is equal to “It's enabled!”
		WebElement actualMessageWait= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		String actualMessage=driver.findElement(By.xpath("//p[@id='message']")).getText();
		String expectedMessage= "It's enabled!";
		Assert.assertEquals(actualMessage, expectedMessage);
//		And verify the textbox is enabled (I can type in the box)
		
		WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
		Assert.assertTrue(textBox.isEnabled());
		
		//	And click on Disable button
		
		WebElement disableButton=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		disableButton.click();
//		And verify the message is equal to “It's disabled!”
		WebElement disabledMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		String disabledMessageText= disabledMessage.getText();
		String expectedMessageText="It's disabled!";
		Assert.assertEquals(disabledMessageText, expectedMessageText);
//		And verify the textbox is disabled (I cannot type in the box)
		Assert.assertTrue(!textBox.isEnabled());
	
	}
	
	
	

}
