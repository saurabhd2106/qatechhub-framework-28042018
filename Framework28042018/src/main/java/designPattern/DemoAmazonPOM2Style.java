package designPattern;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.Driver;

public class DemoAmazonPOM2Style {
	
	public static void main(String[] args) throws Exception {
		Driver cmnDriver = new Driver("chrome");
		cmnDriver.setPageLoadTimeout(20);
		cmnDriver.setElementDetectionTimeout(10);

		cmnDriver.navigateToFirstUrl("https://www.amazon.in/");

		WebDriver driver = cmnDriver.getDriver();
		
		AmazonPOM2Style homepage = new AmazonPOM2Style(driver);
		
		homepage.searchProduct("Apple watch", "Watches");
		
		cmnDriver.closeAllBrowsers();

	}

}
