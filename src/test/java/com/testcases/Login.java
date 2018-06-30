package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.listeners.CustomListener;


@Listeners(CustomListener.class)
public class Login extends Base{
	
	@BeforeTest
	public void openBrowser() {
		
		startextentReport();
		
		test = extent.startTest("Opening Chrome Browser");
		
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse_workspace\\Common Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void launchSite() {
		test = extent.startTest("Launching site https://mail.rediff.com/cgi-bin/login.cgi");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@Test(priority=2, dependsOnMethods="launchSite")
	public void login() {
		
		test = extent.startTest("Logging into rediff mail account");
		
		driver.findElement(By.xpath("//*[@id=\'login1\']")).sendKeys("prashant.ganguly");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("BIGsmall123");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
	}
	
	@Test(priority=3, dependsOnMethods= {"launchSite", "login"})
	public void logout() {
		test = extent.startTest("Logging Out from mail account");
		
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/a[2]")).click();
		
		Assert.assertEquals(true, false);
	}
	
	@AfterTest
	public void endReport() {
		extent.endTest(test);
		extent.flush();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
