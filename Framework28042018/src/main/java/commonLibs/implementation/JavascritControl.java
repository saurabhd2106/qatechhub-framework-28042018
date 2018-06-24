package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScript;

public class JavascritControl implements IJavaScript{
	WebDriver driver;
	
	public JavascritControl(WebDriver driver) {
		this.driver = driver;
	}

	private JavascriptExecutor getJsEngine(){
		JavascriptExecutor jsEngine = (JavascriptExecutor) driver;
		return jsEngine;
	}
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		
		
		getJsEngine().executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		
		getJsEngine().executeScript(jsCommand);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return getJsEngine().executeScript(scriptToExecute).toString();
	}

}
