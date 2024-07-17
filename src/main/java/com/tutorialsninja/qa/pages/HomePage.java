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
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDrodownMenu.click();
	}
	
	public void selectLoginOption() {
		loginOption.click();
	}

}
