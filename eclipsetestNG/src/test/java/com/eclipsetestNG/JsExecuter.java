package com.eclipsetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExecuter {
	
	@Test
	public void jsExecution() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("hulaaaa@yahoo.com");
		Thread.sleep(3000);
		WebElement checkbox= driver.findElement(By.id("persistent"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('persistent').click()");
		Thread.sleep(3000);
		Assert.assertTrue(!checkbox.isSelected());
		driver.close();
		
	}

}
