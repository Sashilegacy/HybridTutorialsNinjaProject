package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;

public class SearchFunctionality extends BaseClass{
	WebDriver driver;
	
	public SearchFunctionality() {
		super();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Search Result is not Displayed!");
		
		
		
		
	}
	
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=2)
	public void verifywithInvalidProduct(){
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("inValidProduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String searchResultMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(searchResultMessage, dataProp.getProperty("noProductTextInSearchResults"),"No Product in Search Result is not Displayed!");
		
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct() {
		
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String searchResultMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(searchResultMessage, dataProp.getProperty("noProductTextInSearchResults"),"No Product in Search Result is not Displayed!");
		
	}

}
