package BaseClass;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;
import Utilities.ExtentTestManager;
import Utilities.TakeScreenshot;
import Utilities.TestListners;
import Utilities.Testutilites;
import Utilities.configFile;
import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({TestListners.class}) // Add the TestNG listeners here
public class BaseClass {

    public static WebDriver driver; // declaring driver
    public static Logger log; // Logger for log4j
    configFile readFile = new configFile();
    String browser = readFile.browserControl(); // Getting browser properties
    Testutilites utilities = new Testutilites();
    String url = readFile.applicationURL();
	public static Integer reponseCode = -1;
   
    @BeforeTest
    public void Initialization() throws IOException {

        log = Logger.getLogger(BaseClass.class);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\log4j.properties");
        
        try {
        	DevTools devTools = null;
        //	ExtentTestManager.test.log(Status.INFO, "Initializing Driver");
            if (browser.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
                WebDriverManager.chromedriver().setup();
                
                ChromeOptions options = new ChromeOptions();
                //Disabling notification popup
                options.addArguments("--disable-notifications");
           //     options.addArguments("--incognito");
               log.info("Initializing Chrome Browser");
                driver = new ChromeDriver(options);//passing chromeoption instance to chromedrive to target and close
                devTools = ((ChromeDriver) driver).getDevTools();
                devTools.createSession();
                
            } else if (browser.equalsIgnoreCase(Constants.EDGE_BROWSER)) {
                WebDriverManager.edgedriver().setup();
                 devTools = ((EdgeDriver) driver).getDevTools();

                log.info("Initializing Chrome Browser");                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
                WebDriverManager.firefoxdriver().setup();
                log.info("Initializing Chrome Browser");                driver = new FirefoxDriver();
            } else {
                log.error("Browser not supported " + browser);
                throw new IllegalArgumentException("Browser not supported " + browser);
            }
       //caputuring status code of payment here using cdp devtools     
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            devTools.addListener(Network.responseReceived(), Response->
            {
            	String url = Response.getResponse().getUrl();
            	
            	//remove and add capture payment later this is share api
            	if(url.contains("get-share-simulation")) 
            	{
            		reponseCode = Response.getResponse().getStatus();
            		log.info(Response.getResponse().getStatus());
            		log.info(Response.getResponse().getStatusText());
            	}
            });
        } catch (Exception e) {
            log.error("Error while initializing WebDriver " + e.getMessage(), e);
            throw new RuntimeException("WebDriver initializing failed", e);
        }
   
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);

       
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie getCookies : cookies) {
            log.info("Cookie Name: " + getCookies);
        }
        
      //  driver.manage().deleteAllCookies();

        URL currentUrl = new URL(url);
        HttpsURLConnection connectURL = (HttpsURLConnection) currentUrl.openConnection();
        connectURL.connect();

        if (connectURL.getResponseCode() >= 400) {
//        	ExtentTestManager.test.log(Status.FAIL,"Page Not Found: " + connectURL.getResponseCode());
        } else {
//        	ExtentTestManager.test.log(Status.INFO,"Landing Page is displayed");
            utilities.assertion(driver.getCurrentUrl(), url);
        }
    }

    @AfterMethod
    public void Testresult(ITestResult result) throws IOException {
        int status = result.getStatus();
        String name = result.getName();

//        if (status == ITestResult.FAILURE) {
////            TakeScreenshot ts = new TakeScreenshot();
////            ts.getScreenshot(driver, name);
////            ExtentTestManager.test.log(Status.FAIL,"Taking screenshot of failed test case " + getClass().getName());
//        }
//        
//        ExtentTestManager.test.log(Status.INFO,"Closing Application");
      
     
        
    }
    
    @AfterTest
    public void TeadDown() 
    {
    	  if(driver!=null) 
          {
    		  log.info("Closing browser");
    		  ExtentTestManager.test.log(Status.PASS, "Closing Browser");
//          	  driver.close();
   //      	 driver.quit();
          }
    }
}
