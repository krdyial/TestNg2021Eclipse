package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class ExplicitWaitTest extends TestBase{
//	Create a class:ExplicitWaitTest. Create a method: explicitWait
//	Go to https://the-internet.herokuapp.com/dynamic_controls
//	Click on remove button
//	And verify the message is equal to “It's gone!”
//	Then click on Add button
//	And verify the message is equal to “It's back!”
	
	@Test
	public void explicitWait() {
		WebDriverWait wait= new WebDriverWait(driver, 10);
//		Go to https://the-internet.herokuapp.com/dynamic_controls	
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//		Click on remove button
		
		 //WebElement removeButton= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@type='button'])[1]"))));
		WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		removeButton.click();
		
//		And verify the message is equal to “It's gone!”
		WebElement messageGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		String message1= driver.findElement(By.xpath("//p[@id='message']")).getText();
		String expectedMessage="It's gone!";
		Assert.assertEquals(message1,expectedMessage);
		
	}
}
