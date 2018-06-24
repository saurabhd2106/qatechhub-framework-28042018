package com.mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.implementation.Driver;

public class BaseScenario {
	
	protected Driver cmnDriver;
	protected MercuryTravelHomePage homepage;
	protected WebDriver driver;
	
	@BeforeClass
	public void setup() throws Exception{
		
		cmnDriver = new Driver("chrome");
		cmnDriver.setPageLoadTimeout(20);
		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl("https://www.mercurytravels.co.in");
		
		driver = cmnDriver.getDriver();
		
		homepage = new MercuryTravelHomePage(driver);
		
		}
	@AfterClass
	public void cleanUp() throws Exception{
		
		cmnDriver.closeAllBrowsers();
		
	}
}
