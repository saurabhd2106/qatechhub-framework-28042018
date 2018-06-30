package com.mercuryTravel;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import commonLibs.implementation.Driver;

public class BaseScenario {
	
	protected Driver cmnDriver;
	protected MercuryTravelHomePage homepage;
	protected WebDriver driver;
	
	public Properties configProperty;
	private String filename = System.getProperty("user.dir") + "/config/config.properties";
	
	@BeforeSuite
	public void initialization() throws Exception{
		configProperty = commonLibs.utils.ReadConfigFileUtils.readProperties(filename);
	}
	
	@BeforeClass
	public void setup() throws Exception{
		String browserType = configProperty.getProperty("browserType");
		cmnDriver = new Driver(browserType);
		
		int pageLoadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		
		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		
		cmnDriver.navigateToFirstUrl(configProperty.getProperty("baseUrl"));
		
		driver = cmnDriver.getDriver();
		
		homepage = new MercuryTravelHomePage(driver);
		
		}
	@AfterClass
	public void cleanUp() throws Exception{
		
		cmnDriver.closeAllBrowsers();
		
	}
}
