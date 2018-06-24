package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.TextboxControl;

public class AmazonPageFatory {
	
	@CacheLookup
	@FindBy(id="searchDropdownBox")
	private WebElement catDropdown;
	
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
	
	@FindBy(id="s-result-count")
	private WebElement result;
	
	private TextboxControl textbox;
	private ElementControl element;
	private DropdownControl dropdown;
	
	public AmazonPageFatory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		textbox = new TextboxControl();
		dropdown = new DropdownControl();
		element = new ElementControl();
	}
	
	public void searchProduct(String product, String category) throws Exception{
		textbox.setText(searchBox, product);
		dropdown.selectViaVisibleText(catDropdown, category);
		element.click(searchButton);
		String searchResult = element.getText(result);
		
		System.out.println(searchResult);
	}

}
