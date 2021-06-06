package com.eclipsetestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

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
       driver.get("https://www.google.com");
	
	
	
	
	
	
	
	
	
	
	
	
}
