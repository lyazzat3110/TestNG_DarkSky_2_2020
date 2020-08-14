package com.qa.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.pages.HomePage;
import com.qa.darksky.util.AppConstant;
import com.qa.speakBetter.base.BasePage;



public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp()  {
		
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {

		String title = homePage.getHomePageTitle();
		System.out.println("home page title is" + title);
		Assert.assertEquals(title, AppConstant.HOME_PAGE_TITLE);

	}

	@Test(priority = 2)

	public void Get_Information() throws InterruptedException  {

	  
		homePage.expandToday();
		homePage.findTodaysTemperature();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
	
	
}
