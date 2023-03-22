package com.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.factory.DriverFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(DriverFactory.inst().getDriver(),this);
	}
	
	//----------------------------------------------
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText = "Login")
	private WebElement clicklogin;
	
	public void getMyAccount() {
		BaseClass.inst().elementclick(myAccount);
	}
	public LoginPage getclicklogin() {
		BaseClass.inst().elementclick(clicklogin);
		return new LoginPage(driver);
	}
	
	
	
	


}
