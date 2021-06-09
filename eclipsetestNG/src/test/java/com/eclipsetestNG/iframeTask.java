package com.eclipsetestNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class iframeTask extends TestBase {
//	Go to https://the-internet.herokuapp.com/iframe
//	Verify the Bolded text contains “Editor”
//	Locate the text box
//	Delete the text in the text box
//	Type “This text box is inside the iframe”
//	Verify the text Elemental Selenium text is displayed on the page

	@Test
	public void iframeTask() {
		driver.get("https://the-internet.herokuapp.com/iframe");
		String header = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(header);
		String expectedText = "Editor";
		Assert.assertTrue(header.contains(expectedText), header + " Text does not contain " + expectedText);

//		Locate the text box
		// driver.switchTo().frame("mce_0_ifr");// using id is slower than index
		// driver.switchTo().frame(0); //faster way than id
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//		Delete the text in the text box
		driver.switchTo().frame(iframeElement); // First create a webElement and switch
		WebElement textBox = driver.findElement(By.xpath("//p"));
		textBox.clear();
//		Type “This text box is inside the iframe”
		textBox.sendKeys("This text box is inside the iframe");
		
//		Verify the text Elemental Selenium text is displayed on the page
		
		//driver.switchTo().parentFrame(); // one step parent
		//---->
		driver.switchTo().defaultContent();// the first page you see kern 
		WebElement elementSelenium= driver.findElement(By.linkText("Elemental Selenium"));
		Assert.assertTrue(elementSelenium.isDisplayed(),elementSelenium+" is not displayed");
		
		
		
		
	}

}
