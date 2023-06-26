/**
 * 
 */
package com.gsg.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsg.actiondrivers.Action;
import com.gsg.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	
	//WebElements
	@FindBy(xpath="//div[text()='Tech']")
	private WebElement techMenuBtn;
	
	@FindBy(xpath = "//span[text()='Televisions']")
	private WebElement televisionMenuBtn;
	
	
	//Constructor to initialize the elements and driver
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	//Required methods
	public boolean validateTechMenuBtn() throws Throwable {
		action.fluentWait(getDriver(), techMenuBtn, 20);
		action.explicitWait(getDriver(), techMenuBtn, 20);
		return action.isDisplayed(getDriver(), techMenuBtn);
	}
	
	public boolean validateTelevisionMenuBtn() throws Throwable {
		action.mouseHoverByJavaScript(techMenuBtn);
		action.fluentWait(getDriver(), televisionMenuBtn, 20);
		action.explicitWait(getDriver(), televisionMenuBtn, 20);
		return action.isDisplayed(getDriver(), televisionMenuBtn);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
}
