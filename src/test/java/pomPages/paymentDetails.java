package pomPages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import Utilities.ExtentTestManager;
import Utilities.Testutilites;
import Utilities.XlsReader;
import Utilities.configFile;
import constants.Constants;
import constants.locators;

public class paymentDetails {
	
	Logger log = Logger.getLogger(getClass().getName());
	XlsReader excelRead;
	Testutilites u = new Testutilites();
	configFile readFile= new configFile();
	public static double totalAmount=0.0;
	
	@FindBy(xpath =locators.REGISTER_LOCATOR )
	private WebElement registerCTA;
	
	@FindBy(xpath =locators.JOINSHARE_LOCATOR )
	private WebElement joinShareCTA;
	
	@FindBy(name=locators.CARDNUMBER_LOCATOR)
	private WebElement cardNumber;
	
	@FindBy(name=locators.EXPIRYDATE)
	private WebElement expiryDate;
	
	@FindBy(name=locators.CVV)
	private WebElement CVV;
	
	@FindBy(id=locators.CARDNUMBER_IFRAME)
	private WebElement cardiFrame;
	
	@FindBy(id=locators.EXPIRY_iFRAME_LOCATOR)
	private WebElement expiryiFrame;
	
	@FindBy(id=locators.CVV_iFRAME)
	private WebElement cvviFrame;
	
	@FindBy(xpath=locators.PAY_BUTTON_LOCATOR)
	private WebElement pay;
	
	@FindBy(name=locators.AUTHENTICATION_iFRAME)
	private WebElement authentication;
	
	@FindBy(xpath = locators.PASSWORD)
	private WebElement checkoutPassword;
	
	@FindBy(id = locators.CONTINUE_LOCATOR)
	private WebElement continueCTA;
	
	@FindBy(xpath =locators.TOTALAMT_AFTER_SHARE)
	private WebElement totalAmountAfterShare;
	
	@FindBy(xpath = locators.TOTAL_AMOUNT_BEFORE_CHECKOUT)
	private WebElement TotalAmount;
	
	@FindBy(xpath = locators.SHARE_ENABLE_LOCATOR)
	private WebElement shareToggleSwitch;
	
	@FindBy(xpath =locators.SHAREPOINT_FIELD_LOCATOR)
	private WebElement sharePointField;
	
	@FindBy(xpath = locators.SHARE_APPLY_LOCATOR)
	private WebElement applyCTA;
	
	@FindBy(xpath=locators.USE_ALL_SHARE_POINT_LOCATOR)
	private WebElement use_allpoints;
	
	public paymentDetails(WebDriver driver, XlsReader excelReader) 
	{
		PageFactory.initElements(driver, this);
		this.excelRead = excelReader;
	}
	
	public void shareUserRegister() 
	{
		try 
		{
			registerCTA.isDisplayed();
			ExtentTestManager.test.log(Status.PASS, "Register button is displayed for guest user");
			registerCTA.click();
		}
		catch (Exception e) 
		{
			try 
			{
				joinShareCTA.isDisplayed();
				
				ExtentTestManager.test.log(Status.PASS, "Join share is displayed for exisiting maf user");

				joinShareCTA.click();
			}
			catch(Exception e2) 
			{
				ExtentTestManager.test.log(Status.FAIL, e2.getMessage());
			}
		}
	}
	
	public void Validcredit_DebitCard(WebDriver driver) throws IOException 
	{
		try
		{
			ExtentTestManager.test.log(Status.INFO, "Reading card derails from file");

			excelRead.validcardDetails();
			driver.switchTo().frame(cardiFrame);
			cardNumber.sendKeys(XlsReader.cardNumber);
			ExtentTestManager.test.log(Status.INFO, "Entering card number");

			driver.switchTo().defaultContent();

			driver.switchTo().frame(expiryiFrame);
			expiryDate.sendKeys(XlsReader.expiry);
			ExtentTestManager.test.log(Status.INFO, "Entering Expiry date");

			driver.switchTo().defaultContent();

			driver.switchTo().frame(cvviFrame);
			CVV.sendKeys(XlsReader.cvv);
			ExtentTestManager.test.log(Status.INFO, "Entering Cvv number ");

			driver.switchTo().defaultContent();
			pay.click();

			ExtentTestManager.test.log(Status.PASS, "Clicking on Pay");
			Thread.sleep(Constants.SHORT_WAIT);
			
			if(new configFile().cardType().equalsIgnoreCase("Visa")) 
			{
				authentication(driver);
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void InValidcredit_DebitCard(WebDriver driver) throws IOException 
	{
		try
		{
		
			ExtentTestManager.test.log(Status.INFO, "Reading card derails from file");

			excelRead.InvalidcardDetails();
			driver.switchTo().frame(cardiFrame);
			cardNumber.sendKeys(XlsReader.cardNumber);
			ExtentTestManager.test.log(Status.INFO, "Entering card number");

			driver.switchTo().defaultContent();

			driver.switchTo().frame(expiryiFrame);
			expiryDate.sendKeys(XlsReader.expiry);
			ExtentTestManager.test.log(Status.INFO, "Entering Expiry date");

			driver.switchTo().defaultContent();

			driver.switchTo().frame(cvviFrame);
			CVV.sendKeys(XlsReader.cvv);
			ExtentTestManager.test.log(Status.INFO, "Entering Cvv number ");
			
			driver.switchTo().defaultContent();
			ExtentTestManager.test.log(Status.PASS, "Clicking on Pay");

			pay.click();
			
			if(new configFile().cardType().equalsIgnoreCase("Visa")) 
			{
				authentication(driver);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	//ONLY FOR VISA CARD	
	public void authentication(WebDriver driver) throws InterruptedException, IOException 
	{
		Thread.sleep(Constants.SHORT_WAIT);
		driver.switchTo().frame(0);
	//	u.waitUntilVisibilityOfElement(driver, form);
		log.info("Switching to frame");
		//driver.switchTo().frame(form);
		//u.waitUntilVisibilityOfElement(driver, checkoutPassword);
		Thread.sleep(Constants.SHORT_WAIT);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Checkout1!'", checkoutPassword);

		//js.executeScript("arguments[0].setAttribute('value', 'Checkout1!')", checkoutPassword);
		//checkoutPassword.sendKeys("Checkout1!");
		log.info("Entering secure password");

		continueCTA.click();
		log.info("Clicking on Continue CTA");
	
	}
	
	public void checkoutDetails() 
	{
		String[] totalAmount = TotalAmount.getText().split("AED");
		
		log.info(totalAmount[1]);
				
		if(pay.isEnabled()) 
		{
			pay.click();
		}

	}
	
	public void shareUtilization() 
	{
		shareToggleSwitch.click();
		//need to add validaiton here for share point is greated than balance
		sharePointField.sendKeys(readFile.sharepoint());
		applyCTA.click();
		
	}
	
	public void fullShareUtilization() 
	{
		shareToggleSwitch.click();
		use_allpoints.click();
		applyCTA.click();
	}
	
	public void paymentvalidation(WebDriver driver) throws IOException, InterruptedException 
	{
		
		if(BaseClass.reponseCode!=200||BaseClass.reponseCode!=201)
		{
			log.info("Retrying payment");
			//Need to add implement retry logic here
			Validcredit_DebitCard(driver);
		}
	}
}
