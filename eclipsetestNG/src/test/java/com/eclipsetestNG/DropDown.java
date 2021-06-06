package com.eclipsetestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	 //Create a class name : DropDown
    //Go to https://the-internet.herokuapp.com/dropdown
    //1.Select and Print Option 1 using index
    //2.Select and Print Option 2 by value
    //3.Select and Print default value by visible text
    //4.Print all dropdown values
    //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        //select.selectByIndex(1);  // to select option1
        select.selectByValue("1");  // to select option1
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       
        
   }
    @Test
    public void test2() {
    	 WebElement dropDown = driver.findElement(By.id("dropdown"));
         Select select = new Select(dropDown);
         //select.selectByVisibleText("Option 2"); // to select option2
         //select.selectByIndex(2); // to select option2
         select.selectByValue("2");
    }
    
  //4.Print all dropdown values
    
    @Test
    public void allValues() {
    	WebElement dropDown = driver.findElement(By.id("dropdown"));
    	Select select = new Select(dropDown);
    	List<WebElement> listOfOptions=  select.getOptions();
    	for (WebElement webElement : listOfOptions) {
			System.out.println(webElement.getText());
		}
    	
    	
    }
    
    @Test
    public void dropDownSize() {
    	WebElement dropDown = driver.findElement(By.id("dropdown"));
    	Select select = new Select(dropDown);
    	int actualSizeDropdown= select.getOptions().size(); //3
    	int expectedSizeDropdown=4;
    	Assert.assertEquals(actualSizeDropdown, expectedSizeDropdown, "Expected is not equal to Actual");
    }
    
    @Test //(dependsOnMethods = "dropDownSize")
    public void getFirstSelectedOptionTest() {
    	WebElement dropDown = driver.findElement(By.id("dropdown"));
    	Select select = new Select(dropDown);
    	WebElement firstSelected= select.getFirstSelectedOption();
    	System.out.println("First Selected Option: "+ firstSelected.getText());
    
   }
    
    
    
    
    @AfterMethod
    public void tearDown() {
    	driver.close();
    }
    
    
    
    
}
