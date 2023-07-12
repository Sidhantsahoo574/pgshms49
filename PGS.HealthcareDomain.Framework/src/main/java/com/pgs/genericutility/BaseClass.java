package com.pgs.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pgs.pom.DoctorAndDashboardPage;
import com.pgs.pom.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage l=new LoginPage(driver);
	public String browser="chrome";

	//@Parameters("browser")
	@BeforeClass
	public void openBrowser(/*String browser*/) throws Throwable
	{
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
//		Reporter.log("openBrowser",true);
//		driver=new ChromeDriver();
//		
//		WebActionUtility wLib=new WebActionUtility();
//		wLib.waitForElementInDOM(driver);
	}
	@BeforeMethod
	public void login() throws Throwable
	{
		Reporter.log("login",true);
		System.out.println("Sucessfully loggedIn");
		
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout",true);
		System.out.println("Sucessfully loggedOut");
		
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("closeBrowser",true);
		driver.close();
	}
}
