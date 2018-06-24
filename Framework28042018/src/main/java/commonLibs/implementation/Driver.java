package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;

public class Driver implements IDriver {
	private WebDriver driver;

	private int pageLoadTimeout;

	private int elementDetectionTimeout;

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public Driver(String browserType) throws Exception {

		pageLoadTimeout = 10;
		elementDetectionTimeout = 5;

		browserType = browserType.trim();

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\chromeDriver36\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\MicrosoftWebDriver.exe");

			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser type : " + browserType);
		}

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

	}
	
	public WebDriver getDriver(){
		return driver;
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		url = url.trim();

		if (url.isEmpty()) {
			throw new Exception("Empty url");
		}

		driver.get(url);
	}

	@Override
	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {

		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {

		url = url.trim();
		driver.navigate().to(url);

	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	@Override
	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();
		}

	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
