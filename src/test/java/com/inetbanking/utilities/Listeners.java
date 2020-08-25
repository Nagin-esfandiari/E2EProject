

package com.inetbanking.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetbanking.testCases.BaseClass;

public class Listeners extends BaseClass implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentreportsDEMO.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	 public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			test= extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
			
		}
	 public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			extentTest.get().log(Status.PASS, "Test Passed");
		}
	public void onTestFailure(ITestResult result) {
	
		extentTest.get().fail(result.getThrowable());
		
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(result.getMethod().getMethodName(),getScreenshot(driver,testMethodName));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestFinish(ITestResult result) {
		extent.flush();
		driver.quit();
	
	}

}
