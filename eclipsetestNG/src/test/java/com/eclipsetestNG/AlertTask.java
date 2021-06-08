package com.eclipsetestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTask {
	
//Go to https://the-internet.herokuapp.com/javascript_alerts
//Create setUp method
//Create 3 test methods:
//acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly	clicked an alert”
//
//dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked:Cancel”
//sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
	WebDriver driver;
	
	@BeforeMethod
	 public void setUp() {
       WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       
      }
	
	@Test
	public void acceptAlert() {
		//acceptAlert() => click on the first alert, 
		//verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		String actualAlertText= driver.switchTo().alert().getText();
		String expectedAlertText= "I am a JS Alert";
		Assert.assertEquals(actualAlertText, expectedAlertText, "Expected and actual Text are not same");
		driver.switchTo().alert().accept();	
		String actualResult= driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("actual Result: "+actualResult);
		String expectedResult= "You successfully clicked an alert";
		Assert.assertTrue(actualResult.equals(expectedResult));
		
	}
	
	@Test
	public void dismissAlert() {
		
		//dismissAlert()=> click on the second alert, 
		//verify text "I am a JS Confirm”, click cancel, and Verify “You clicked:Cancel”
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();
		String actualDismissResult= driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Actual TExt:"+ actualDismissResult);
		String expectedDismissResult= "You clicked: Cancel";
		Assert.assertEquals(actualDismissResult, expectedDismissResult);
	}
	
	@Test
	public void sendKeysAlert() {
		//sendKeysAlert()=> 
		//click on the third alert,
		// verify text “I am a JS prompt”, 
		//type “Hello Word”, click OK, 
		//and Verify “You entered: Hello Word”
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Hello World");
		driver.switchTo().alert().accept();
		String actualResultText= driver.findElement(By.id("result")).getText();
		System.out.println("Actual Text: "+actualResultText);
		String expectedResultText="You entered: Hello World";
		Assert.assertEquals(actualResultText, expectedResultText);
		
	}
	
	
	
	
	
	
	
	
	
	
}
