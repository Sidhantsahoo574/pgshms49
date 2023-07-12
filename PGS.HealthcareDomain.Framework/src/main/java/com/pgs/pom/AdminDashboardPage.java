package com.pgs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	
	//Declaration
	@FindBy(xpath="//a[@href='hms/admin']")
	private WebElement adminModuleLink;
	
	@FindBy(xpath="//li[9]//a[1]//div[1]//div[2]")
	private WebElement reportModuleDropDown;
	
	@FindBy(xpath="//span[normalize-space()='B/w dates reports']")
	private WebElement BWdatesreports;
	
	@FindBy(id="fromdate")
	private WebElement fromDate;
	
	@FindBy(id="todate")
	private WebElement toDate;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Admin | View Patients']")
	private WebElement page;
	
	@FindBy(xpath="//h5[normalize-space()='Report from 2023-01-01 to 2023-06-01']")
	private WebElement dates;
	
	//Initialization
	public AdminDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getAdminModuleLink() {
		return adminModuleLink;
	}

	public WebElement getReportModuleDropDown() {
		return reportModuleDropDown;
	}

	public WebElement getBWdatesreports() {
		return BWdatesreports;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getDates() {
		return dates;
	}
	
	public void adminModule()
	{
		adminModuleLink.click();
	}
	
	public void reportModuleLink()
	{
		reportModuleDropDown.click();
		BWdatesreports.click();
	}
	public void BWDatesReport(String fromDates,String toDates)
	{
		fromDate.sendKeys(fromDates);
		toDate.sendKeys(toDates);
		submitBtn.click();
	}
	
	public String Page()
	{
		String pg = page.getText();
		
		return pg;
	}

	public String Date()
	{
		String dt=dates.getText();
		return dt;
	}

}
