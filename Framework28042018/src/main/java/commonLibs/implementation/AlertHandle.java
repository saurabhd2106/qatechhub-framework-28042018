package commonLibs.implementation;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;

public class AlertHandle implements IAlert {

	private WebDriver driver;

	public AlertHandle(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void acceptAlert() throws Exception {
		driver.switchTo().alert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		driver.switchTo().alert().dismiss();

	}

	@Override
	public String getMessageFromAlert() throws Exception {
		
		return driver.switchTo().alert().getText();
	}

	@Override
	public boolean isAlertPresent(int timeoutInSeconds) throws Exception {

		return false;
	}

}
