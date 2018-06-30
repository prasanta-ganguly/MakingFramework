package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener extends Base implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" - Test Passed");
		test.log(LogStatus.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" - Test Failed");
		test.log(LogStatus.FAIL, "Test failed");
		takeScreenshots(result.getMethod().getMethodName());
		test.log(LogStatus.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" - Test Skipped");
		test.log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
			}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	

}
