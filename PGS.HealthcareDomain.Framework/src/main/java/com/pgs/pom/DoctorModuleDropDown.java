package com.pgs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorModuleDropDown {
	
	//Declaration
	@FindBy(xpath="//li[2]//a[1]//div[1]//div[2]")
	private WebElement doctorDropDown;
	
	@FindBy(xpath="//a[@href='add-doctor.php']")
	private WebElement addDoctorModule;
	
	@FindBy(name="Doctorspecialization")
	private WebElement DoctorSpecializationDropDown;
	
	@FindBy(name="docname")
	private WebElement docName;
	
	@FindBy(name="clinicaddress")
	private WebElement clinicAddress;
	
	@FindBy(name="docfees")
	private WebElement docFees;
	
	@FindBy(name="doccontact")
	private WebElement docContact;
	
	@FindBy(name="docemail")
	private WebElement docEmail;
	
	@FindBy(name="npass")
	private WebElement newPassword;
	
	@FindBy(name="cfpass")
	private WebElement cfPassword;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	
	
	
	//Initialization
	public DoctorModuleDropDown(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilaization
	
	public WebElement getDoctorDropDown() {
		return doctorDropDown;
	}

	public WebElement getAddDoctorModule() {
		return addDoctorModule;
	}

	public WebElement getDoctorSpecializationDropDown() {
		return DoctorSpecializationDropDown;
	}

	public WebElement getDocName() {
		return docName;
	}

	public WebElement getClinicAddress() {
		return clinicAddress;
	}

	public WebElement getDocFees() {
		return docFees;
	}

	public WebElement getDocContact() {
		return docContact;
	}

	public WebElement getDocEmail() {
		return docEmail;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getCfPassword() {
		return cfPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void doctorDropDown()
	{
		doctorDropDown.click();
		addDoctorModule.click();
	}
	
	public void addDocDetails(String name,String address,String fees,String contact,String email,String newpassword,String confirmPassword)
	{
		docName.clear();
		docName.sendKeys(name);
		clinicAddress.clear();
		clinicAddress.sendKeys(address);
		docFees.clear();
		docFees.sendKeys(fees);
		docContact.clear();
		docContact.sendKeys(contact);
		docEmail.sendKeys(email);
		newPassword.sendKeys(newpassword);
		cfPassword.sendKeys(confirmPassword);
		submitBtn.click();
	}
	
	
	
	

}
