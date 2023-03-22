package com.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	public WebDriver driver;
	
	private static DriverFactory driver_int=null;
	
	private DriverFactory() {
	}
	
	public static DriverFactory inst() {
		if(driver_int==null) {
			driver_int=new DriverFactory();
		}
		return driver_int;
	}
	//--------------------------------------------------------------------
	
	public WebDriver driverInstallation(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else if (browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
