package com.mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonLibs.implementation.Driver;
import commonLibs.implementation.TakeScreenshot;

public class BaseScenario extends ReportScenario {

	protected Driver cmnDriver;
	protected MercuryTravelHomePage homepage;
	protected WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		logger = report.createTest("Setup :: Invoke Browser");
		String browserType = configProperty.getProperty("browserType");

		logger.info("Browser type :: " + browserType);
		cmnDriver = new Driver(browserType);

		int pageLoadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		logger.info("Page load Time out ::" + pageLoadTimeout);

		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		logger.info("Element Detection Time out ::" + elementDetectionTimeout);

		String url = configProperty.getProperty("baseUrl");
		logger.info("Navigating to Url :: " + url);
		cmnDriver.navigateToFirstUrl(url);

		driver = cmnDriver.getDriver();

		camera = new TakeScreenshot(driver);
		homepage = new MercuryTravelHomePage(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void afterAMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test case Failed :: " + result.getName());

			String fileName = currentProjectDirectory + "\\screenshots\\" + result.getName() + testExecutionStartTime
					+ ".png";

			String resultPath = camera.captureAndSaveScreenshot(fileName);

			
			logger.addScreenCaptureFromPath(resultPath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			logger.skip("Test case Skipped :: " + result.getName());
		} else {
			logger.pass("Test case passed :: " + result.getName());
		}

	}

	@AfterTest
	public void cleanUp() throws Exception {

		cmnDriver.closeAllBrowsers();

	}
}
