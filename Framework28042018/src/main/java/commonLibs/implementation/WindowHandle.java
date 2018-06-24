package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindows;

public class WindowHandle implements IWindows {
	private WebDriver driver;

	public WindowHandle(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToChildWindow() throws Exception {
		String childWindow = driver.getWindowHandles().toArray()[1].toString();

		driver.switchTo().window(childWindow);

	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {

		driver.switchTo().window(windowhandle);

	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		String childWindow = driver.getWindowHandles().toArray()[childWindowIndex].toString();

		driver.switchTo().window(childWindow);

	}

	@Override
	public String getWindowHandle() throws Exception {

		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {

		return driver.getWindowHandles();
	}

}
