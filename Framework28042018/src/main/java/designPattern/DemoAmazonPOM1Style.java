package designPattern;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.Driver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.TextboxControl;

public class DemoAmazonPOM1Style {

	public static void main(String[] args) {

		try {
			Driver cmnDriver = new Driver("chrome");
			cmnDriver.setPageLoadTimeout(20);
			cmnDriver.setElementDetectionTimeout(10);

			cmnDriver.navigateToFirstUrl("https://www.amazon.in/");

			WebDriver driver = cmnDriver.getDriver();

			AmazonPOM1Style homepage = new AmazonPOM1Style(driver);

			DropdownControl dropdown = new DropdownControl();
			ElementControl element = new ElementControl();
			TextboxControl textbox = new TextboxControl();

			dropdown.selectViaVisibleText(homepage.catDropdown, "Watches");
			textbox.setText(homepage.searchBox, "Apple watch");

			element.click(homepage.searchButton);

			cmnDriver.closeAllBrowsers();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
