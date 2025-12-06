package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	public static ExtentReports extent = ExtentReportManager.createInstance();
	public static ExtentTest test;
	
	public static ExtentTest startTest(String testName) 
	{
		return test =extent.createTest(testName);
	}
	
	
	public static void endTest() 
	{
	//	test.log(Status.INFO, "Test Execution completed");
		  extent.flush();
	}

}
