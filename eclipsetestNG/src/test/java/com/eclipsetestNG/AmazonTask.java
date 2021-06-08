package com.eclipsetestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTask {
	WebDriver driver;
	
	//Go to https://www.amazon.com
	//Find the first selected option from the search box dropdown
	//Select the 4th option by index
	//Print all dropdownoptions
	// Print the total number of the options
	// Check, if Appliances is a drop down option. 
	//Print True if "Appliances" is an option, otherwise Print "False"
	
	@Test
	public void amazonTask() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement dropDown= driver.findElement(By.id("searchDropdownBox"));
		Select select= new Select(dropDown);
		String firstSelected =select.getFirstSelectedOption().getText();
		System.out.println("First Selected Option of Dropdown Menu: "+firstSelected);
		//Select the 4th option by index
		select.selectByIndex(4);
		//Print all dropdownoptions
		//List<WebElement> dropDownMenu = driver.findElements(By.id("searchDropdownBox"));
		for (WebElement webElement : select.getOptions()) {
			System.out.println(webElement.getText());
		}
		
		// Print the total number of the options
		System.out.println("Total Elements of Dropdown Menu: "+ select.getOptions().size());
		
		//// Check, if Appliances is a drop down option.
		String appliances="Appliances";
		String resultOfAppliances= select.getOptions().contains(appliances) ? "True": "False";
		System.out.println("Verify if Appliances is on the Dropdown Menu: "+resultOfAppliances);
	}
	

}
