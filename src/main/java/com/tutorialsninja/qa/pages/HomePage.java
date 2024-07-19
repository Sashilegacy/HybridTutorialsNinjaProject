package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Options
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDrodownMenu;
	
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDrodownMenu.click();
	}
	
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDrodownMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchAProduct(String productText) {
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public void enterProductNameToSearchBox(String productText) {
		searchBoxField.sendKeys(productText);
	}
	
	
	
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDrodownMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
		
		
	}
	

}
