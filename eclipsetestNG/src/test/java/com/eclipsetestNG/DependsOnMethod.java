package com.eclipsetestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	public void logIn() {
		System.out.println("Log in TEST");
	}
	
	@Test
	public void homePage() {
		System.out.println("Homepage TEST");
		Assert.fail("Homepage fails");
	}
	
	@Test(dependsOnMethods = "homePage")
	public void searchTest() {
		System.out.println("Search TEST");
	}
	
	@Test
	public void verifyResults() {
		System.out.println("Verify TEST");
	}
	
	
	
	

}
