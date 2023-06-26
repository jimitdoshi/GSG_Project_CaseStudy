package com.gsg.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gsg.base.BaseClass;
import com.gsg.pageobjects.TelevisionPage;
import com.gsg.utility.Log;

public class TelevisionPageTest extends BaseClass {
	
	private TelevisionPage televisionPage;


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
	public void TelevisionPageTest() throws Throwable {
		Log.startTestCase("TelevisionPageTest");
		televisionPage = new TelevisionPage();
		televisionPage.clickOnTelevisionMenuBtn();
		Assert.assertEquals(televisionPage.getCurrURL(), "https://www.dailymail.co.uk/best-buys/tech/tv/");
		Assert.assertTrue(televisionPage.validateTelevisionPageHeader());
		Assert.assertTrue(televisionPage.validateTelevisionPageDescription());
		Assert.assertTrue(televisionPage.validateTelevisionPageArticles());
		Log.endTestCase("TelevisionPageTest");
	}

}
