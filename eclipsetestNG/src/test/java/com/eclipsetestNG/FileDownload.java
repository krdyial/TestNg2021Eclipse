package com.eclipsetestNG;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class FileDownload extends TestBase{


//	downloadTest()
//	In the downloadTest() method, do the following test:
//	Go to https://the-internet.herokuapp.com/download
//	Download FLOWER.JPG file
//	Then verify if the file downloaded successfully
	
	@Test
	public void downloadTest() {
//		Go to https://the-internet.herokuapp.com/download
		driver.get("https://the-internet.herokuapp.com/download");
//		Download FLOWER.JPG file
		driver.findElement(By.linkText("flower.jpg")).click();
//		Then verify if the file downloaded successfully
		String pathOfDownloadedFile="C:\\Users\\Karadayi\\Downloads\\flower.jpg";
		boolean isExist= Files.exists(Paths.get(pathOfDownloadedFile));
		Assert.assertTrue(isExist);
		
		//
		
		}
	
	@Test
	public void userFolder() {
		//dynamic user folder. 
		String userFolder= System.getProperty("user.home");
		System.out.println("UserFolder:"+ userFolder);
	}

}
