package com.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class BaseClass {
	
private static BaseClass base_inst;
	
	WebDriver driver;
	private BaseClass() {
		PageFactory.initElements(driver,this);
	}
	public static BaseClass inst() {
		if (base_inst==null) 
			base_inst=new BaseClass();
		return base_inst;
	}
	//-------------------------------------------------
	
	public WebElement elementwithsendKey(WebElement element,String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
		return element;
	}
	public WebElement elementclick(WebElement element) {
		element.click();
		return element;
	}
	public WebElement elementIsDisplayed(WebElement element) {
		element.isDisplayed();
		return element;
	}
	public String getTextElement(WebElement element) {
		return element.getText();
	}
	
}
