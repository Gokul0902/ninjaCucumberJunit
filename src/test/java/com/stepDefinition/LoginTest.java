 package com.stepDefinition;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.pageobjects.AccountPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import io.cucumber.java.en.*;
import utility.TimeStamp;

public class LoginTest {
	
	WebDriver driver;
	private LoginPage loginpage ;
	private AccountPage accountpage;
	
	@Given("User has to navigate to login page")
	public void user_has_to_navigate_to_login_page() {
		driver=DriverFactory.inst().getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.getMyAccount();
		loginpage = homepage.getclicklogin();
	}
	 @When("^User has enter valid email Adress (.+) in the email field$")
	    public void user_has_enter_valid_email_adress_in_the_email_field(String username){
	    	loginpage.getUserEmail(username);
	    }

	    @And("^User has enter valid password (.+) in the password field$")
	    public void user_has_enter_valid_password_in_the_password_field(String password)  {
	    	loginpage.getUserPassword(password);
	    }
	    
    @When("User has enter valid email Adress in the email field")
    public void user_has_enter_valid_email_adress_in_the_email_field(){
    	loginpage.getUserEmail("gokula.chander1@gmail.com");
    }

    @And("User has enter valid password in the password field")
    public void user_has_enter_valid_password_in_the_password_field()  {
    	loginpage.getUserPassword("12345");
    }

	@And("user has to click on Login button")
	public void user_has_to_click_on_login_button() {
		accountpage = loginpage.getClickLogin();
			}

	@Then("user should successfully logged in")
	public void user_should_successfully_logged_in() {
			Assert.assertTrue(accountpage.verifyaccountPageWarningMessage());
	}

	@When("User has enter invalid password in the password field")
	public void user_has_enter_invalid_password_in_the_password_field() {
		loginpage.getUserPassword("123456");
	}

	@Then("user should get warning message if credentials doesnt match")
	public void user_should_get_warning_message_if_credentials_doesnt_match() {
		
			Assert.assertEquals(loginpage.verifyLoginPageWarningMessage(),"Warning: No match for E-Mail Address and/or Password.");
	}
	@When("User has enter invalid email Adress in the email field")
	public void user_has_enter_invalid_email_adress_in_the_email_field() {
	
		loginpage.getUserEmail(TimeStamp.getTimeStampEmailText());
		
	}
	@When("User doesnt enter in the email field")
	public void user_doesnt_enter_in_the_email_field() {
		loginpage.getUserEmail("");
		
	}

	@When("User doesnt not enter in the password filed")
	public void user_doesnt_not_enter_in_the_password_filed() {
		loginpage.getUserPassword("");
		
	}
	
	

}
