package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICheckbox;

public class CheckboxControl implements ICheckbox{

	@Override
	public void changeCheckBoxStatus(WebElement element, boolean status) throws Exception {
		
		if((element.isSelected() && !status) || (!element.isSelected() && status)){
			element.click();
		}
		
	}

}
