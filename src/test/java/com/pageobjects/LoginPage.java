package com.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;



public class LoginPage {
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


//-----------------------------------------------------------
	
	@FindBy(id ="input-email")
	private WebElement userEmail;
	
	@FindBy(id ="input-password")
	private WebElement userPassword;
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement clickLogin;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginPageWariningMessege; 
	
	public void getUserEmail(String emailText) {
		BaseClass.inst().elementwithsendKey(userEmail, emailText);
	}
	public void getUserPassword(String passwordText) {
		BaseClass.inst().elementwithsendKey(userPassword, passwordText);
	}
	public AccountPage getClickLogin() {
		BaseClass.inst().elementclick(clickLogin);
		return new AccountPage(driver);
	}
	public String verifyLoginPageWarningMessage() {
		return BaseClass.inst().getTextElement(loginPageWariningMessege);
	}
	
	
}
