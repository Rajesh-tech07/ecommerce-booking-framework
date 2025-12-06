package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager{

    static configFile readfile = new configFile();
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkreport;
    public static ExtentTest test;
    static Logger log = Logger.getLogger(ExtentReportManager.class);

    static Date date = new Date();
    static String newDate = new SimpleDateFormat("EEEE, MMMM dd, yyyy, hh-mm a (z)").format(date);
    static String fileName = "Test Report " + newDate + " .html";
    static String filepath = System.getProperty("user.dir") + "\\Reports\\";

    public static ExtentReports createInstance()  {
        File reportDir = new File(filepath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        extent = new ExtentReports();
        sparkreport = new ExtentSparkReporter(filepath + fileName);
        sparkreport.config().setTheme(Theme.DARK);
        sparkreport.config().setDocumentTitle("OBS Automation Report");
        sparkreport.config().setReportName("OBS Booking System Testing Report");
        sparkreport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a (z)");
        sparkreport.config().setEncoding("UTF-8");
        sparkreport.config().setProtocol(Protocol.HTTPS);

        extent.attachReporter(sparkreport);

        extent.setSystemInfo("Project Name", "One Booking System");
        extent.setSystemInfo("Application URL", readfile.applicationURL());
        extent.setSystemInfo("OS version", System.getProperty("os.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        
        return extent;
    }
//
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getName());
//        log.info("[Running Test ] :- " + result.getMethod().getDescription());
//        test.log(Status.INFO, "Test started: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        log.info("[Test Passed] :- " + result.getMethod().getDescription());
//        test.log(Status.PASS, result.getMethod().getDescription());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        log.error("[Test Failed] :- " + result.getMethod().getDescription());
//        log.error("Error:", result.getThrowable());
//        test.log(Status.FAIL, result.getMethod().getDescription());
//        test.log(Status.INFO, result.getThrowable().getMessage());
//
//        try {
//            String image = new TakeScreenshot().getScreenshot(driver, result.getName());
//            test.addScreenCaptureFromPath(image);
//        } catch (IOException e) {
//            log.info(e.getStackTrace());
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        log.warn("[Test Skipped] :- " + result.getMethod().getDescription());
//        test.log(Status.SKIP, result.getMethod().getDescription());
//    }
//
//    public void onFinish(ITestContext context) {
//        log.info("Test execution completed");
//        extent.flush();
//        System.out.println("Report generated at: " + filepath + "\\" + fileName);
//    }
//    
//    public static void logInfo(String message) {
//        test.log(Status.INFO, message);
//        log.info(message);
//    }
//
//    public static void logPass(String message) {
//        test.log(Status.PASS, message);
//        log.info(message);
//    }
//
//    public static void logFail(String message) {
//        test.log(Status.FAIL, message);
//        log.error(message);
//    }
//
//    public static void logWarn(String message) {
//        test.log(Status.WARNING, message);
//        log.warn(message);
//    }


}
