package Utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BaseClass.BaseClass;

public class TestListners extends BaseClass implements ITestListener  {

    private static final Logger log = Logger.getLogger(TestListners.class);

    public void onStart(ITestContext context) {
    	
      log.info("[Running Test ] :- " + context.getName());
     // ExtentTestManager.startTest((String) context.getAttribute("testName"));
      ExtentTestManager.startTest(context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
    	ExtentTestManager.test.log(Status.INFO, "Running Test: " + result.getMethod().getDescription());
        log.info("[Running Test] :- " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	ExtentTestManager.test.log(Status.PASS, "Test Paased: " + result.getMethod().getDescription());
    //to print label given in string by markup helper and selecting colour
    	ExtentTestManager.test.log(Status.PASS, MarkupHelper.createLabel("Test Passed" , ExtentColor.GREEN));
    	log.info("[Test Passed] :- " + result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result) {
    	ExtentTestManager.test.log(Status.FAIL, "Test Failed: " + result.getMethod().getDescription());
    	ExtentTestManager.test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed" , ExtentColor.RED));
    	ExtentTestManager.test.log(Status.INFO, result.getThrowable().getMessage());

        log.error("[Test Failed] :- " + result.getMethod().getDescription());
        log.error("Error:", result.getThrowable());
        try {
        	if(driver!=null) 
        	{
        		TakeScreenshot ts =new TakeScreenshot();
                String imagePath = ts.getScreenshot(driver, result.getName());
                ExtentTestManager.test.addScreenCaptureFromPath(imagePath);
        	}
        
      } catch (IOException e) {
         log.error("Error capturing screeshot");
      }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	
    	ExtentTestManager.test.log(Status.SKIP, "Test Skipped: " + result.getName());
    	ExtentTestManager.test.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped" , ExtentColor.YELLOW));
    	log.warn("[Test Skipped] :- " + result.getMethod().getDescription());
    }

    public void onFinish(ITestContext context) {
    	ExtentTestManager.endTest();
    
    }
}
