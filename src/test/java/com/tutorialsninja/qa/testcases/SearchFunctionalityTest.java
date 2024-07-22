package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;


//Updated Comment

public class SearchFunctionalityTest extends BaseClass{
	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;
	
	public SearchFunctionalityTest() {
		super();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		//HomePage homePage=new HomePage(driver);
		searchPage=homePage.searchAProduct(dataProp.getProperty("validProduct"));
		
		//homePage.enterProductNameToSearchBox(dataProp.getProperty("validProduct"));
		//SearchPage searchPage = homePage.clickOnSearchButton();
		
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(searchPage.displayStatusOfHpvalidProduct(),"Search Result is not Displayed!");
		
		
		
		
	}
	
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		 homePage=new HomePage(driver);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=2)
	public void verifywithInvalidProduct(){
		//HomePage homePage=new HomePage(driver);
		searchPage=homePage.searchAProduct(dataProp.getProperty("inValidProduct"));
	//	homePage.enterProductNameToSearchBox(dataProp.getProperty("inValidProduct"));
		//searchPage=homePage.clickOnSearchButton();
		
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("inValidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//String searchResultMessage=searchPage.retrieveNoProductMessageText();
		//Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"),"No Product in Search Result is not Displayed!");
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), "abcd","No Product in Search Result is not Displayed!");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"verifySearchWithValidProduct","verifywithInvalidProduct"})
	public void verifySearchWithoutAnyProduct() {
		
		searchPage=homePage.clickOnSearchButton(); 
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		//String searchResultMessage=searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"),"No Product in Search Result is not Displayed!");
		
	}

}
