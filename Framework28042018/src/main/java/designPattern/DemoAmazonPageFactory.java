package designPattern;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.Driver;

public class DemoAmazonPageFactory {

	public static void main(String[] args) throws Exception {
		Driver cmnDriver = new Driver("chrome");
		cmnDriver.setPageLoadTimeout(20);
		cmnDriver.setElementDetectionTimeout(10);

		cmnDriver.navigateToFirstUrl("https://www.amazon.in/");

		WebDriver driver = cmnDriver.getDriver();
		
		AmazonPageFatory homepage = new AmazonPageFatory(driver);
		
		homepage.searchProduct("Apple watch", "Watches");
		
		cmnDriver.closeAllBrowsers();

	}

}
