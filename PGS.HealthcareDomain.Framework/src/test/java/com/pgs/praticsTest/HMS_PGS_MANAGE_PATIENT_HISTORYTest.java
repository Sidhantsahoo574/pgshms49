package com.pgs.praticsTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pgs.genericutility.BaseClass;
import com.pgs.genericutility.FileUtility;
import com.pgs.genericutility.WebActionUtility;
import com.pgs.pom.DoctorAndDashboardPage;
import com.pgs.pom.LoginPage;

public class HMS_PGS_MANAGE_PATIENT_HISTORYTest extends BaseClass {
	@Test

	public void managePatientHistory() throws Throwable {
		

		/*FileInputStream fis=new FileInputStream("./src/main/resources/data/PGS.commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("Url");
		String un = p.getProperty("Username");
		String pw = p.getProperty("Password");*/
		//Open the Chrome Browser
		FileUtility fLib=new FileUtility();
		String Project_path = fLib.getFilePathFromPropertiesFile("projectConfigFilePath");
		String URL = fLib.getDataFromProperties(Project_path,"Url");
		String UN = fLib.getDataFromProperties(Project_path,"Username");
		String PW = fLib.getDataFromProperties(Project_path,"Password");
		
		
		
		WebActionUtility wLib=new WebActionUtility();
		//get the actual result not exceptions
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wLib.waitForElementInDOM(driver);
		
		//Enter the URL
		driver.get(URL);
		DoctorAndDashboardPage ref=new DoctorAndDashboardPage(driver);
		//Click on Doctor Module
		ref.docModule();
		l.loginPage(UN, PW);
		//driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
		/*Enter the username
		driver.findElement(By.name("username")).sendKeys(un);
		//Enter the Password
		driver.findElement(By.name("password")).sendKeys(pw);
		//click on login button
		driver.findElement(By.name("submit")).click();*/
		
		//Click on Patients Dropdown 
		
		
		//driver.findElement(By.xpath("//span[normalize-space()='Patients']")).click();
		ref.patientDropDown();
		//Click on the add paitent link
		//driver.findElement(By.xpath("//span[normalize-space()='Add Patient']")).click();
		ref.getAddPatientLinkBtn();
		//Fill all the Details
		/*driver.findElement(By.name("patname")).sendKeys("Rocky");
		driver.findElement(By.name("patcontact")).sendKeys("6574839237");
		int random=new Random().nextInt();
		driver.findElement(By.id("patemail")).sendKeys("rocky"+random+"@gmail.com");
		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		driver.findElement(By.name("pataddress")).sendKeys("Mumbai");
		driver.findElement(By.name("patage")).sendKeys("21");
		driver.findElement(By.name("medhis")).sendKeys("Sugar");
		driver.findElement(By.id("submit")).click();*/
		ref.patientDetails("Rocky", "6574839237", "rocky", "Mumbai", "21", "Sugar");
		//Click on Patients Dropdown 
		//driver.findElement(By.xpath("//span[normalize-space()='Patients']")).click();
		ref.patientDropDown();
		//Click on the Manage Patient link
		//driver.findElement(By.xpath("//span[normalize-space()='Manage Patient']")).click();
		ref.managePatient();
		//Click on view icon
		//driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=173']")).click();
		
		//Click on add medical History
		//driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light w-lg']")).click();
		//Enter valid Details
		/*driver.findElement(By.name("bp")).sendKeys("High");
		driver.findElement(By.name("bs")).sendKeys("NA");
		driver.findElement(By.name("weight")).sendKeys("60");
		driver.findElement(By.name("temp")).sendKeys("101");
		driver.findElement(By.name("pres")).sendKeys("Sleep Well,Drink Water");
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();*/
		String s[]= {"Sleep Well","Drink Water"};
		ref.addMedicalHistory("High", "NA", "60", "101", s);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//Alert ele = wait.until(ExpectedConditions.alertIsPresent());
		//wLib.waitForElement(driver, null);
		//web.waitForElement(driver, null);
		//Alert a = driver.switchTo().alert();
		//a.accept();
	      wLib.swithToAlertWindowAndAccpect(driver);
		//Logout the application
		/*driver.findElement(By.xpath("//span[contains(text(),'Simon')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();*/
	     ref.logOutBtn();
		
		
		


	} 

}
