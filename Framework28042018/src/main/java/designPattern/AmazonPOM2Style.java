package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.TextboxControl;

public class AmazonPOM2Style {
	
	private WebElement catDropdown;
	
	private WebElement searchBox;
	
	private WebElement searchButton;
	
	private WebElement result;
	
	private TextboxControl textbox;
	private ElementControl element;
	private DropdownControl dropdown;
	
	public AmazonPOM2Style(WebDriver driver) {
		
		catDropdown = driver.findElement(By.id("searchDropdownBox"));
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		result = driver.findElement(By.id("s-result-count"));
		
		textbox = new TextboxControl();
		dropdown = new DropdownControl();
		element = new ElementControl();
	}
	
	public void searchProduct(String product, String category) throws Exception{
		textbox.setText(searchBox, product);
		dropdown.selectViaVisibleText(catDropdown, category);
		element.click(searchButton);
		
	}

}
