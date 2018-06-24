package test;

import commonLibs.implementation.Driver;

public class DemoDriver {

	public static void main(String[] args) {
		
		try {
			Driver cmnDriver = new Driver("chrome");
			
			cmnDriver.setPageLoadTimeout(20);
			cmnDriver.setElementDetectionTimeout(5);
			
			cmnDriver.navigateToFirstUrl("http://qatechhub.com");
			
			cmnDriver.getTitle();
			
			cmnDriver.closeAllBrowsers();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
