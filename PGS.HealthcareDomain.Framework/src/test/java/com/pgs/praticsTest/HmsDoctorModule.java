package com.pgs.praticsTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.pgs.pom.LoginPage;

public class HmsDoctorModule {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {

		JSONParser j=new JSONParser();
		Object ob = j.parse(new FileReader("C:\\Users\\hp\\Desktop\\Pgshms.json"));

		JSONObject map=(JSONObject) ob;
		Object u = map.get("url");
		Object un = map.get("username");
		Object pw = map.get("password");
		String s1=(String) u;
		String s2=(String) un;
		String s3=(String) pw;

		//open the chrome browser
		WebDriver driver=new ChromeDriver();
		//get the actual result not exceptions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter the url
		driver.get(s1);
		//Enter the username
		/*driver.findElement(By.name("username")).sendKeys(s2);
		//Enter the Password
		driver.findElement(By.name("password")).sendKeys(s3);
		//click on login button
		driver.findElement(By.name("submit")).click();
		//click on dashboard module*/
		LoginPage l=new LoginPage(driver);
		l.loginPage(s2, s3);
		driver.findElement(By.xpath("//a[@href='dashboard.php']")).click();
		//click on update profile
		driver.findElement(By.xpath("//a[normalize-space()='Update Profile']")).click();
		//select doctor specialization from Doctor Specialization DropDown
		WebElement e = driver.findElement(By.name("Doctorspecialization"));
		Select s=new Select(e);
		s.selectByIndex(2);
		//enter doctor name
		driver.findElement(By.name("docname")).clear();
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
		//driver.findElement(By.xpath("//input[@name='docemail']")).clear();
		driver.findElement(By.name("docemail")).sendKeys("test@gmail.com");
		//click on update button
		driver.findElement(By.name("submit")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		//Logout the application
		driver.findElement(By.xpath("//span[contains(text(),'Simon')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		Thread.sleep(5000);
		//close the Browser
		driver.quit();

		//click on Appointment History module
		//driver.findElement(By.xpath("//a[@href='appointment-history.php']//div[@class='item-content']//div[@class='item-inner']")).click();
		Date d=new Date();
	    SimpleDateFormat simple=new SimpleDateFormat("MM-dd-yyyy");
	    String ss=simple.format(d);
	    System.out.println(ss);
	    
	    Calendar c=Calendar.getInstance();
	    c.add(Calendar.DATE,2);
	    Date d1=c.getTime();
	    System.out.println(d1);
	    String str	=simple.format(d1);

	}

}
