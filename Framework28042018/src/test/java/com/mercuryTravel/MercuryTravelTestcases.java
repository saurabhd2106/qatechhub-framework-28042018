package com.mercuryTravel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestcases extends BaseScenario {
	
	@Test
	public void verifyUserLoginWithCorrectCredentials() throws Exception{
		String userEmailId = configProperty.getProperty("userEmailId");
		String password = configProperty.getProperty("userPassword");
		
		homepage.userLogin(userEmailId, password);
		
		String actualWelcomeText = homepage.getWelcomeText();
		String expectedWelcomeText = configProperty.getProperty("welcomeText");
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}

	
}
