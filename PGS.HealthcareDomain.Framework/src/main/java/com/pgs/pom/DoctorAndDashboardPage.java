package com.pgs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorAndDashboardPage {
	
	//Declaration
	@FindBy(xpath="//a[.='Click Here' and @href='hms/doctor/']")
	private WebElement docModuleLink;
	
	@FindBy(xpath="//span[normalize-space()='Patients']")
	private WebElement patDropdown;
	
	@FindBy(xpath="//span[normalize-space()='Add Patient']")
	private WebElement addPatientLinkBtn;
	
	@FindBy(name="patname")
	private WebElement patNameTbx;
	
	@FindBy(name="patcontact")
	private WebElement patContactTbx;
	
	@FindBy(id="patemail")
	private WebElement patEmailTbx;
	
	@FindBy(name="pataddress")
	private WebElement patAddressTbx;
	
	@FindBy(name="patage")
	private WebElement patAgeTbx;
	
	@FindBy(name="medhis")
	private WebElement medcalHistoryTbx;
	
	@FindBy(id="submit")
	private WebElement updateBtn;
	
	@FindBy(name="bp")
	private WebElement bpTbx;
	
	
	@FindBy(xpath="//span[normalize-space()='Manage Patient']")
	private WebElement managePatLink;
	
	@FindBy(xpath="//a[@href='view-patient.php?viewid=173']")
	private WebElement viewIconLink;
	
	@FindBy(xpath="//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement addMedHisBtn;
	
	@FindBy(name="bs")
	private WebElement bsTbx;
	
	@FindBy(name="weight")
	private WebElement weightTbx;
	
	@FindBy(name="temp")
	private WebElement tempTbx;
	
	@FindBy(name="pres")
	private WebElement prescriptionTbx;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'Simon')]")
	private WebElement simonDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Log Out']")
	private WebElement lgBtn;
	
	//Initialization
	public DoctorAndDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getDocModuleLink() {
		return docModuleLink;
	}

	public WebElement getPatDropdown() {
		return patDropdown;
	}

	public WebElement getAddPatientLinkBtn() {
		return addPatientLinkBtn;
	}

	public WebElement getPatNameTbx() {
		return patNameTbx;
	}

	public WebElement getPatContactTbx() {
		return patContactTbx;
	}

	public WebElement getPatEmailTbx() {
		return patEmailTbx;
	}

	public WebElement getPatAddressTbx() {
		return patAddressTbx;
	}

	public WebElement getPatAgeTbx() {
		return patAgeTbx;
	}

	public WebElement getMedcalHistoryTbx() {
		return medcalHistoryTbx;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public WebElement getManagePatLink() {
		return managePatLink;
	}

	public WebElement getViewIconLink() {
		return viewIconLink;
	}

	public WebElement getAddMedHisBtn() {
		return addMedHisBtn;
	}

	public WebElement getBpTbx() {
		return bpTbx;
	}

	public WebElement getBsTbx() {
		return bsTbx;
	}

	public WebElement getWeightTbx() {
		return weightTbx;
	}

	public WebElement getTempTbx() {
		return tempTbx;
	}

	public WebElement getPrescriptionTbx() {
		return prescriptionTbx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getSimonDropdown() {
		return simonDropdown;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	
	//Business libraries
	public void docModule()
	{
		docModuleLink.click();
	}
	public void patientDropDown()
	{
		patDropdown.click();
		addPatientLinkBtn.click();
	}
	public void patientDetails(String name,String contact,String email,String address,String age,String medicalHistory)
	{
		patNameTbx.sendKeys(name);
		patContactTbx.sendKeys(contact);
		patEmailTbx.sendKeys(email);
		patAddressTbx.sendKeys(address);
		patAgeTbx.sendKeys(age);
		medcalHistoryTbx.sendKeys(medicalHistory);
		updateBtn.click();
		
	}
	public void managePatient()
	{
		patDropdown.click();
		managePatLink.click();
		viewIconLink.click();
		addMedHisBtn.click();	
	}
	public void addMedicalHistory(String Bp,String Bs,String Weight,String temp,String str[])
	{
		bpTbx.sendKeys(Bp);
		bsTbx.sendKeys(Bs);
		weightTbx.sendKeys(Weight);
		tempTbx.sendKeys(temp);
		prescriptionTbx.sendKeys(str);
		submitBtn.click();
	}
	
	public void logOutBtn()
	{
		simonDropdown.click();
		lgBtn.click();
	}
	

}
