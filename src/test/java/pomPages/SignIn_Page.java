package pomPages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import Utilities.ExtentTestManager;
import Utilities.Testutilites;
import Utilities.XlsReader;
import constants.Constants;
import constants.locators;

public class SignIn_Page {
	
	Logger log = Logger.getLogger(getClass().getName());
//	configFile readfile =new configFile();
	XlsReader excelRead ;
	Testutilites u =new Testutilites();
	
	@FindBy(id=locators.EMAIL_LOCATOR)
	private WebElement email_id;
	
	@FindBy(id= locators.PASSWORD_LOCATOR)
	private WebElement password;
	
	@FindBy(xpath = locators.LOGIN_LOCATOR)
	private WebElement login;
	
	@FindBy(xpath =locators.RECAPTCH_IFRMAE_LOCATOR)
//	@FindBy(id=locators.RECAPTCH_LOCATOR)
	private WebElement recpatch;
	
	@FindBy(id =locators.IFRAME_PRESENECE)
	private WebElement tokenFinderlocator;

	public SignIn_Page(WebDriver driver, XlsReader excelRead) 
	{
		PageFactory.initElements(driver, this);
		this.excelRead = excelRead;
	}
	
	
	public void loginDetails(WebDriver driver) throws IOException, InterruptedException 
	{
			
		Thread.sleep(Constants.SHORT_WAIT);
		excelRead.registeredUserData();

		email_id.sendKeys(excelRead.email);
		ExtentTestManager.test.log(Status.PASS	, "Entering user Email Address");

		password.sendKeys(excelRead.password);
		ExtentTestManager.test.log(Status.PASS	, "Entering user Password");
	
		log.info("Resolve Recaptach manually");
		
		Thread.sleep(Constants.LONG_WAIT);
		
		login.click();
		
		ExtentTestManager.test.log(Status.PASS	, "Clicking on login button");

		
	}
	
	
	
}
