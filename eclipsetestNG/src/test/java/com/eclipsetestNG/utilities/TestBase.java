package com.eclipsetestNG.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
	//TestBase has only @BeforeMethod and @AfterMethod
	// This class will not have any Test Class!!!
	// abstract class
	protected WebDriver driver; //we should make it public or protected.
								//Because it is in another package.
								// to use that driver obj in other extended classes
	//public also works but it is not a good idea. 
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	

}
