package com.pgs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(xpath="//input[@name='username']")
	private WebElement untbx;
	@FindBy(name="password")
	private WebElement pwtbx;
	@FindBy(name="submit")
	private WebElement lgbtn;

	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}

	//Utilization
	public void loginPage(String un,String pw)
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgbtn.click();
	}

}
