/**
 * 
 */
package com.gsg.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsg.actiondrivers.Action;
import com.gsg.base.BaseClass;

public class TelevisionPage extends BaseClass {
	
	Action action= new Action();
	
	//WebElements
	@FindBy(xpath="//h1[text()='Televisions']")
	private WebElement televisionPageHeaderElement;
	
	@FindBy(xpath="//div[text()='Tech']")
	private WebElement techMenuBtn;
	
	@FindBy(xpath = "//span[text()='Televisions']")
	private WebElement televisionMenuBtn;
	
	@FindBy(xpath = "//h1[text()='Televisions']//following::span//p")
	private WebElement televisionDescriptionElement;
	
	@FindBy(xpath = "//h1[text()='Televisions']//following::div[@data-testid='articles-content']//a")
	private List<WebElement> televisionArticleList;
	
	
	//Constructor to initialize the elements and driver
	public TelevisionPage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	//Required methods
	public void clickOnTelevisionMenuBtn() throws Throwable {
		action.mouseHoverByJavaScript(techMenuBtn);
		action.explicitWait(getDriver(), televisionMenuBtn, 20);
		action.click(getDriver(), televisionMenuBtn);
	}
	
	public boolean validateTelevisionPageHeader() throws Throwable {
		action.fluentWait(getDriver(), televisionPageHeaderElement, 20);
		return action.isDisplayed(getDriver(), televisionPageHeaderElement);
	}
	
	public boolean validateTelevisionPageDescription() throws Throwable {
		action.fluentWait(getDriver(), televisionDescriptionElement, 20);
		action.explicitWait(getDriver(), televisionDescriptionElement, 20);
		return action.isDisplayed(getDriver(), televisionDescriptionElement);
	}
	
	public boolean validateTelevisionPageArticles() throws Throwable {
		int size_of_articleList = televisionArticleList.size();
		int count = 0;
		for(int i = 0 ; i < size_of_articleList ; i++) {
			System.out.println(televisionArticleList.get(i).getText());
			count++;
		}
		if(count == size_of_articleList) {
			return true;
		}
		return false;		
	}
	
	public String getCurrURL() throws Throwable {
		String televisionPageURL=action.getCurrentURL(getDriver());
		return televisionPageURL;
	}
	
}
