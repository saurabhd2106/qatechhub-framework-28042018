package com.mercuryTravel;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementControl;
import commonLibs.implementation.MouseControl;
import commonLibs.implementation.TextboxControl;

public class BaseSetup {
	
	public MouseControl mouseControl;
	public TextboxControl textboxControl;
	public ElementControl elementControl;
	
	public BaseSetup(WebDriver driver) {
		mouseControl = new MouseControl(driver);
		textboxControl = new TextboxControl();
		elementControl = new ElementControl();
	}
	

}
