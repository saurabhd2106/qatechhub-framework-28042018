package com.mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryTravelHomePage extends BaseSetup {

	@FindBy(linkText = "International Holidays")
	private WebElement internationHolidayLink;

	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidayLink;

	@FindBy(linkText = "Flights")
	private WebElement flightLink;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	// TO DO: Please update other links

	@FindBy(linkText = "Customer Login")
	private WebElement customerLogin;

	@FindBy(linkText = "User Login")
	private WebElement userLogin;

	@FindBy(linkText = "Register")
	private WebElement RegisterLink;

	@FindBy(id = "sign_user_email")
	private WebElement userEmailId;

	@FindBy(id = "sign_user_password")
	private WebElement userPassword;

	@FindBy(xpath = "//div[@id='modalLogin']//form[@class='form-signin']//button")
	private WebElement loginButton;

	@FindBy(partialLinkText = "Welcome,")
	private WebElement welcomeText;

	public MercuryTravelHomePage(WebDriver driver) {

		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void userLogin(String sUserEmailId, String password) throws Exception {
		mouseControl.moveToElement(customerLogin);
		mouseControl.moveToElementAndClick(userLogin);

		textboxControl.setText(userEmailId, sUserEmailId);
		textboxControl.setText(userPassword, password);

		elementControl.click(loginButton);
	}

	public String getWelcomeText() throws Exception {
		return elementControl.getText(welcomeText);
	}
}
