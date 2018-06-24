package com.mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.Driver;

public class MercuryTravelTestcases extends BaseScenario {
	
	@Test
	public void verifyUserLoginWithCorrectCredentials() throws Exception{
		String userEmailId = "saurabh.d2106@gmail.com";
		String password = "Pro@1234";
		
		homepage.userLogin(userEmailId, password);
		
		String actualWelcomeText = homepage.getWelcomeText();
		String expectedWelcomeText = "Welcome, Saurabh";
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}

	
}
