package com.pgs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewPatientsPage {

	//Declaration
	
	@FindBy(xpath="//a[@href='patient-search.php']//div[@class='item-content']//div[@class='item-inner']")
	private WebElement patientSearchLink;
	
	
	@FindBy(id="searchdata")
	private WebElement patientNameOrPatientContactNo;

	@FindBy(xpath="//i[@class='fa fa-eye']")
	private WebElement viewActionPage;

	@FindBy(xpath="//h1[normalize-space()='Doctor | Manage Patients']")
	private WebElement docAndManagePatientPage;
	
	@FindBy(id="submit")
	private WebElement submitBTN;

	//Initialization
	public AdminViewPatientsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPatientSearchLink() {
		return patientSearchLink;
	}

	public WebElement getPatientNameOrPatientContactNo() {
		return patientNameOrPatientContactNo;
	}

	public WebElement getViewActionPage() {
		return viewActionPage;
	}
	
	public WebElement getSubmitBTN() {
		return submitBTN;
	}

	public void adminviewpatientpages(String NameOrPhNo)
	{
		patientNameOrPatientContactNo.sendKeys(NameOrPhNo);
		submitBTN.click();
	}
	
	
	public void adminviewPatientPage()
	{
		patientSearchLink.click();
		
	}
	
	public void viewActionPage()
	{
		viewActionPage.click();
		
	}
	public String docAndmanagepatientPage()
	{
		String m = docAndManagePatientPage.getText();
		return m;
	}

	

}
