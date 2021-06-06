package com.eclipsetestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {
	
	WebDriver driver;
	
	@BeforeMethod
	 public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        try {
			driver.findElement(By.xpath("//*[text()='I agree']")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
	
	@Test
	public void hardAssertTest() {
		WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
		//assert if the email link text is equal "Gmail"
		String expectedGmailText="Gmail";
		String actualGmailText= gmailLink.getText();
		Assert.assertEquals(actualGmailText, expectedGmailText);
		
		
		WebElement imagesLink= driver.findElement(By.linkText("Images"));
		//assert if the email link text is equal "Images"
		
		String expectedImagesText= "Images";
		String actualImagesText= imagesLink.getText();
		Assert.assertEquals(actualImagesText, expectedImagesText);
		
		
		WebElement singInLink= driver.findElement(By.linkText("Sign in"));
		
		
		
	}
	
	@Test
	public void softAssertionTest() {
		
		SoftAssert softassert= new SoftAssert();
		
		WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
		//assert if the email link text is equal "Gmail"
		String expectedGmailText="gmail";
		String actualGmailText= gmailLink.getText();
		softassert.assertEquals(actualGmailText, expectedGmailText);
		
		
		WebElement imagesLink= driver.findElement(By.linkText("Images"));
		//assert if the email link text is equal "Images"
		
		String expectedImagesText= "Images";
		String actualImagesText= imagesLink.getText();
		softassert.assertEquals(actualImagesText, expectedImagesText);
		
		
		WebElement singInLink= driver.findElement(By.linkText("Sign in"));
		String actualSignInLink= singInLink.getText();
		String  expectedSingInLink= "sign in";
		softassert.assertEquals(actualSignInLink, expectedSingInLink);
		
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

	
	
	

}
