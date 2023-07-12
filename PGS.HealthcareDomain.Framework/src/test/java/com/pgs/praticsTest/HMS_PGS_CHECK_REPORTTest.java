package com.pgs.praticsTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pgs.genericutility.FileUtility;
import com.pgs.genericutility.WebActionUtility;
import com.pgs.pom.AdminDashboardPage;
import com.pgs.pom.LoginPage;

public class HMS_PGS_CHECK_REPORTTest {

	@Test
	public void CheckReport() throws Throwable {
		//WebactionUtility web=new WebactionUtility();
		
		/*FileInputStream fis=new FileInputStream("./src/main/resources/data/PGS.commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url1");
		String un = p.getProperty("username1");
		String pw = p.getProperty("password1");*/
		
		FileUtility fLib=new FileUtility();
		String Project_path = fLib.getFilePathFromPropertiesFile("projectConfigFilePath");
		String URL = fLib.getDataFromProperties(Project_path,"url1");
		String UN = fLib.getDataFromProperties(Project_path,"username1");
		String PW = fLib.getDataFromProperties(Project_path,"password1");
		
		
		
		//Open the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

		
		WebDriver driver=new ChromeDriver();

		WebActionUtility wLib=new WebActionUtility();
		//get the actual result not exceptions
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wLib.waitForElementInDOM(driver);
		//web.waitForElementInDOM(driver);
		//Enter the URL
		driver.get(URL);
		//Click Admin Module
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		//driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
		adp.adminModule();
		//Enter username and password
		/*driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		//Click on login button
		driver.findElement(By.name("submit")).click();
		//Click on Reports module dropdown*/
		LoginPage l=new LoginPage(driver);
		l.loginPage(UN, PW);
		//driver.findElement(By.xpath("//li[9]//a[1]//div[1]//div[2]")).click();
		adp.reportModuleLink();
		//Click on B/W dates reports link
		//driver.findElement(By.xpath("//span[normalize-space()='B/w dates reports']")).click();
		//Check for last 6 Months Report by selecting "From Date" and "TO Date" and click on "Submit"
		/*driver.findElement(By.id("fromdate")).sendKeys("01/01/2023");
		driver.findElement(By.id("todate")).sendKeys("06/01/2023");
		driver.findElement(By.id("submit")).click();*/
		adp.BWDatesReport("01/01/2023", "06/01/2023");
		//String pg = driver.findElement(By.xpath("//h1[normalize-space()='Admin | View Patients']")).getText();
		
		if(adp.Page().equals("Admin | View Patients"))
		{
			System.out.println("Between dates reports page should displayed in Admin | View Patients page and passed ");
		}
		//String dates = driver.findElement(By.xpath("//h5[normalize-space()='Report from 2023-01-01 to 2023-06-01']")).getText();
		//Verify the date 
		if(adp.Date().equals("Report from 2023-01-01 to 2023-06-01"))
		{
			System.out.println("6 months report should displayed and passed");
		}
		driver.close();
		
		

	}

}
