package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonPOM1Style {
	
	public WebElement catDropdown;
	
	public WebElement searchBox;
	
	public WebElement searchButton;
	
	
	
	public Select selCategory;
	
	public AmazonPOM1Style(WebDriver driver) {
		
		catDropdown = driver.findElement(By.id("searchDropdownBox"));
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
		selCategory = new Select(catDropdown);
	}

}
