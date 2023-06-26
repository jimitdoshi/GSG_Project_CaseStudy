package com.gsg.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gsg.base.BaseClass;
import com.gsg.pageobjects.HomePage;
import com.gsg.utility.Log;

public class HomePageTest extends BaseClass {
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser) throws Exception {
		launchApp(browser); 
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test()
	public void homePageTest() throws Throwable {
		Log.startTestCase("homePageTest");
		homePage = new HomePage();
		Assert.assertTrue(homePage.validateTechMenuBtn());
		Assert.assertTrue(homePage.validateTelevisionMenuBtn());
		Assert.assertEquals(homePage.getCurrURL(), "https://www.dailymail.co.uk/best-buys/");
		Log.endTestCase("homePageTest");
	}
	
}
