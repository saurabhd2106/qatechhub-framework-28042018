package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.contracts.IFrames;

public class FrameHandle implements IFrames{
	
	private WebDriver driver;
	
	public FrameHandle(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToFrame(String frameId) throws Exception {
		
		driver.switchTo().frame(frameId);
	}

	@Override
	public void switchToFrame(WebElement element) throws Exception {
		
		driver.switchTo().frame(element);
	}

	@Override
	public void switchToFrame(int index) throws Exception {
		driver.switchTo().frame(index);
		
	}

	@Override
	public void switchToDefaultContent() throws Exception {
		driver.switchTo().defaultContent();
		
	}
	
	

}
