package com.mercuryTravel;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.TestDataProvider;

public class MercuryTravelTestcases extends BaseScenario {
	
	/*	@Test(dataProvider="getData", dataProviderClass=TestDataProvider.class)
	public void verifyUserLoginWithCorrectCredentials(String userEmailId, String password) throws Exception{
		String userEmailId = configProperty.getProperty("userEmailId");
		String password = configProperty.getProperty("userPassword");
		
		homepage.userLogin(userEmailId, password);
		
		String actualWelcomeText = homepage.getWelcomeText();
		String expectedWelcomeText = configProperty.getProperty("welcomeText");
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}*/
	
	@Test()
	public void verifyUserLoginWithCorrectCredentials() throws Exception{
		
		logger = report.createTest("TC Id - 98874 :: Verify Login with Correct credentials");
		String userEmailId = configProperty.getProperty("userEmailId");
		String password = configProperty.getProperty("userPassword");
		logger.info("loggin in with username and password");
		homepage.userLogin(userEmailId, password);
		
		String actualWelcomeText = homepage.getWelcomeText();
		String expectedWelcomeText = configProperty.getProperty("welcomeText");
		
		logger.info("comparing actual and expected welcome Text");
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
	
	@Test(enabled=false,dependsOnMethods="verifyUserLoginWithCorrectCredentials")
	public void logoutFromMercuryTravel(){
		
	}
	
}
