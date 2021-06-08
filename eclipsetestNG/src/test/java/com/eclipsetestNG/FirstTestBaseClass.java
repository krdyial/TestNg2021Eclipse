package com.eclipsetestNG;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.eclipsetestNG.utilities.TestBase;

public class FirstTestBaseClass extends TestBase {
	
	
	@Test
	public void test1() {
		driver.get("https://www.google.com");
		try {
			driver.findElement(By.)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
