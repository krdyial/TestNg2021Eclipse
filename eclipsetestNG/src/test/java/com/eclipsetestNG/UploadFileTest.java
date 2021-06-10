package com.eclipsetestNG;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class UploadFileTest extends TestBase {
	
	
	
	@Test
	public void uploadFileTest() {
//			When user goes to https://the-internet.herokuapp.com/upload
		driver.get("https://the-internet.herokuapp.com/upload");
		//And click on the chooseFile button
//		And selects an image from the computer
		String pathOfFile="C:\\Users\\Karadayi\\Desktop\\Upload1.txt";
		driver.findElement(By.id("file-upload")).sendKeys(pathOfFile);			

//			And click on the upload button
		driver.findElement(By.id("file-submit")).click();
//			Then verify the File uploaded! Message displayed
		String actualUploadText=driver.findElement(By.xpath("//h3")).getText();
		String expectedUploadText="File Uploaded!";
		Assert.assertEquals(actualUploadText, expectedUploadText);
		
		boolean isExist= Files.exists(Paths.get(pathOfFile));
		Assert.assertTrue(isExist);
//	
		
	}

}
