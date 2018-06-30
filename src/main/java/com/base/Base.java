package com.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {
	
	public static WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest test;
	
	public void takeScreenshot(){
		
		//filename of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		//store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void takeScreenshots(String methodName){
	
	//filename of the screenshot
	//Date d=new Date();
	//String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	//store screenshot in that file
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+methodName+"_"+".png"));
		} catch (IOException e) {
		e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Screenshot->"+test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+methodName+"_"+".png"));

	}
	
	public void startextentReport() {
		extent = new ExtentReports(System.getProperty("user.dir")+"//extent-reports//myreport.html",true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Prasanta");
		extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
	}
}
