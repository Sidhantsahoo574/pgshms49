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

import com.pgs.genericutility.FileUtility;
import com.pgs.genericutility.WebActionUtility;
import com.pgs.pom.AdminDashboardPage;
import com.pgs.pom.AdminViewPatientsPage;
import com.pgs.pom.DoctorAndDashboardPage;
import com.pgs.pom.DoctorModuleDropDown;
import com.pgs.pom.LoginPage;

public class HMS_PGS_ADDING_DOCTOR_AND_SEARCH_PATIENTTest {
	@Test(enabled = true)

	//sahoo
	public void addingDoctorandSearchPatient() throws Throwable {
		FileUtility fLib=new FileUtility();
		String Project_path = fLib.getFilePathFromPropertiesFile("projectConfigFilePath");
		String URL = fLib.getDataFromProperties(Project_path,"url1");
		String UN = fLib.getDataFromProperties(Project_path,"username1");
		String PW = fLib.getDataFromProperties(Project_path,"password1");
		
		
		//Get the data from property file
		/*FileInputStream fis=new FileInputStream("./src/main/resources/data/PGS.commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url1");
		String un = p.getProperty("username1");
		String pw = p.getProperty("password1");*/
		
		//Open the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		WebActionUtility wLib=new WebActionUtility();
		//get the actual result not exceptions
		//WebactionUtility wLib=new WebactionUtility();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wLib.waitForElementInDOM(driver);
				//Enter the URL
		driver.get(URL);
		//Click Admin Module
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.adminModule();
		//driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
		//Enter username and password
		/*driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		//Click on login button
		driver.findElement(By.name("submit")).click();*/
		LoginPage l=new LoginPage(driver);
		l.loginPage(UN,PW);
		//On the left-hand navigation, click on "Doctor's Dropdown" and select "Add Doctors."
		DoctorModuleDropDown dmd=new DoctorModuleDropDown(driver);
		/*driver.findElement(By.xpath("//li[2]//a[1]//div[1]//div[2]")).click();
		driver.findElement(By.xpath("//a[@href='add-doctor.php']")).click();*/
		dmd.doctorDropDown();
		//select doctor specialization from Doctor Specialization DropDown
		WebElement e = driver.findElement(By.name("Doctorspecialization"));
		Select s=new Select(e);
		s.selectByIndex(2);
		//enter doctor name
		/*driver.findElement(By.name("docname")).clear();
		driver.findElement(By.name("docname")).sendKeys("Simon");
		//enter the address
		driver.findElement(By.name("clinicaddress")).clear();
		driver.findElement(By.name("clinicaddress")).sendKeys("Ohio");
		//enter doctor consultancy fee
		driver.findElement(By.name("docfees")).clear();
		driver.findElement(By.name("docfees")).sendKeys("500.0");
		//enter doctor contact no
		driver.findElement(By.name("doccontact")).clear();
		driver.findElement(By.name("doccontact")).sendKeys("6969696969");
		//enter doctor email
		//driver.findElement(By.xpath("//input[@name='docemail']")).clear();*/
		int str=new Random().nextInt();
		/*driver.findElement(By.name("docemail")).sendKeys("test"+str+"@gmail.com");
		//Enter new Password
		driver.findElement(By.name("npass")).sendKeys("Simon@123");
		//Enter your Confirm Password
		driver.findElement(By.name("cfpass")).sendKeys("Simon@123");
		//Click Submit Button
		driver.findElement(By.name("submit")).click();*/
		dmd.addDocDetails("Simon", "Ohio", "500.0", "6969696969", "test"+str+"@gmail.com", "Simon@123", "Simon@123");
		/*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();*/
		wLib.swithToAlertWindowAndAccpect(driver);
		//Click on Patient Search link
		AdminViewPatientsPage avp=new AdminViewPatientsPage(driver);
		/*89driver.findElement(By.xpath("//a[@href='patient-search.php']//div[@class='item-content']//div[@class='item-inner']")).click();
		//Click on Search bar Enter Patient name or Patient ph no 
		driver.findElement(By.id("searchdata")).sendKeys("John");
		driver.findElement(By.id("submit")).click();*/
		avp.adminviewPatientPage();
		avp.adminviewpatientpages("John");
		//Click on view action page
		//driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		//verify the 
		//WebElement m=driver.findElement(By.xpath("//h1[normalize-space()='Doctor | Manage Patients']"));
		avp.viewActionPage();
		String m=avp.docAndmanagepatientPage();
		if(m.equals("Doctor | Manage Patients"))
		{
			System.out.println("Successful and passed");
		}
		//Click on Reports module dropdown
		adp.reportModuleLink();
		/*driver.findElement(By.xpath("//li[9]//a[1]//div[1]//div[2]")).click();
		//Click on B/W dates reports link
		driver.findElement(By.xpath("//span[normalize-space()='B/w dates reports']")).click();
		//Enter valid dates
		driver.findElement(By.id("fromdate")).sendKeys("01/01/2023");
		driver.findElement(By.id("todate")).sendKeys("01/20/2023");
		driver.findElement(By.id("submit")).click();*/
		adp.BWDatesReport("01/01/2023", "01/20/2023");
		driver.close();

	}

}
