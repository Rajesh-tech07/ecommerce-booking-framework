package pomPages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.ExtentTestManager;
import Utilities.Testutilites;
import Utilities.XlsReader;
import Utilities.configFile;
import constants.Constants;
import constants.locators;

public class UserDetailsPage {

	Logger log = Logger.getLogger(this.getClass().getName());
	configFile readFile = new configFile();
	Testutilites u = new Testutilites();
	XlsReader excelRead;

	
	@FindBy(xpath =locators.DATE_XPATH)
	private WebElement Selected_Date;
	
	@FindBy(xpath =locators.TIME_XPATH)
	private WebElement selected_Time;
	
	@FindBy(xpath = locators.REMOVE_CTA_XPATH)
	private WebElement removeCTA;
	
	@FindBy(xpath = locators.DETAILS_PAGE_EDIT_XATH)
	private WebElement editCTA;
	
	@FindBy(xpath = locators.DETAILS_PAGE_CONFIRM_XPATH)
	private WebElement confirmCTA;
	
	@FindBy(name =locators.FIRST_NAME)
	private WebElement FirstName;
	
	@FindBy(name =locators.LAST_NAME)
	private WebElement LastName;
	
	@FindBy(name =locators.MOBILENUMBER)
	private WebElement mobileNumber;
	
	@FindBy(xpath = locators.COUNTRYCODE)
	private WebElement countryCode;
	
	@FindBy(name =locators.EMAIL)
	private WebElement email;
	
	@FindBy(xpath = locators.CHECKBOX)
	private WebElement checkBox;
	
	@FindBy(xpath = locators.SINGIN)
	private WebElement signin;
	
	@FindBy(xpath = locators.CREATE_ACCOUNT)
	private WebElement createAccount;
	
	@FindBy(xpath = locators.TOTAL_AMOUNT_BEFORE_CHECKOUT)
	private WebElement totalCheckoutammount;
	
	@FindBy(xpath= locators.SHARE_POINTS_YOU_EARN)
	private WebElement SharePoints;
	
	@FindBy(xpath = locators.YES_REMOVE)
	private WebElement Yes_remove;
	
	@FindBy(xpath = locators.CANCEL_REMOVE)
	private WebElement cancel;
	
	@FindBy(xpath =locators.USEREMAIL)
	private WebElement userEmail;
	
	@FindBy(xpath=locators.EDITPROFILE)
	private WebElement editProfile;
	
	@FindBy(xpath =locators.FIRSTNAME_ERRORMESSAGE)
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath =locators.LASTNAME_ERRORMESSAGE)
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath =locators.MOBILE_ERRORMESSAGE)
	private WebElement mobileErrorMessage;
	
	@FindBy(xpath =locators.EMAIL_ERRORMESSAGE)
	private WebElement emailErrorMessage;
	
	@FindBy(xpath= locators.CONSENT_LOCATOR)
	private WebElement consentMessage;
	
	public UserDetailsPage(WebDriver driver, XlsReader excelreader) 
	{
		PageFactory.initElements(driver, this);
		this.excelRead = excelreader;
		
	}
		
	public void edit(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(Constants.SHORT_WAIT);
		editCTA.click();
		log.info("Clicking on Edit");
		ExtentTestManager.test.log(Status.INFO, "Clicking Edit CTA");
		Thread.sleep(Constants.SHORT_WAIT);
		u.assertion(Constants.STAGING_URL, driver.getCurrentUrl());
		
	}
	
	public void signin() 
	{
		signin.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Sign In CTA");
		
	}
	
	public void createAccount() 
	{
		createAccount.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Create Account ");
	}
	
	
	public void guestUserDetails() throws IOException 
	{
		excelRead.GuestUserData();
		//FirstName.sendKeys(readFile.firstName());
		//ExtentTestManager.test.log(Status.PASS, "Entering first name "+ readFile.firstName());

		FirstName.sendKeys(XlsReader.firsname);
		ExtentTestManager.test.log(Status.PASS, "Entering first name"+ XlsReader.firsname);

		//	LastName.sendKeys(readFile.lastName());
		LastName.sendKeys(XlsReader.lastname);
	//	ExtentTestManager.test.log(Status.PASS, "Entering Last name "+ readFile.lastName());
		ExtentTestManager.test.log(Status.PASS, "Entering Last name "+ XlsReader.lastname);

		
	//	countryCode.sendKeys(readFile.country());
		countryCode.sendKeys(XlsReader.countryCode);
		//ExtentTestManager.test.log(Status.PASS, "Entering country name "+ readFile.country());
		ExtentTestManager.test.log(Status.PASS, "Entering country name "+ XlsReader.countryCode);

	//	mobileNumber.sendKeys(readFile.mobile());
		mobileNumber.sendKeys(XlsReader.mobileNumber);
		//ExtentTestManager.test.log(Status.PASS, "Entering mobile number "+ readFile.mobile());
		ExtentTestManager.test.log(Status.PASS, "Entering mobile number "+ XlsReader.mobileNumber);

		//email.sendKeys(readFile.email());
		email.sendKeys(XlsReader.email);
	//	ExtentTestManager.test.log(Status.PASS, "Entering email address "+ readFile.email());

		ExtentTestManager.test.log(Status.PASS, "Entering email address "+ XlsReader.email);

	}
	 
	public void checkbox() 
	{
		if(checkBox.isSelected()) 
		{
			ExtentTestManager.test.log(Status.PASS, "Terms and condition is already selected");
		}
		else {
			checkBox.click();
			ExtentTestManager.test.log(Status.PASS, "Clicking on T&C check box");

		}
	}
	
	public void confrim() 
	{
		confirmCTA.click();
		log.info("Clciking on confirm button");
		ExtentTestManager.test.log(Status.PASS, "Clciking on confirm button");

	}
	
	public void paymentSummry() 
	{
	
		try 
		{
			//u.assertion(LandingPage.cachedDate, Selected_Date.getText());
		
			u.assertion(LandingPage.cachedTotalamount,totalCheckoutammount.getText());
			ExtentTestManager.test.log(Status.INFO, SharePoints.getText());
		}
		catch (AssertionError e) {
			log.info(e.getMessage());
		}
	
	}
	
	public void Yesremove() throws InterruptedException 
	{
		removeCTA.click();
		log.info("Clciking on Remove CTA");
		ExtentTestManager.test.log(Status.INFO, "Clciking on Remove CTA");

		Yes_remove.click();
		log.info("Clciking on YES Remove CTA");
		ExtentTestManager.test.log(Status.PASS, "Clciking on YES Remove CTA");
		
		Thread.sleep(Constants.SHORT_WAIT);

	}
	
	public void cancel() 
	{
		removeCTA.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Remove button");
		cancel.click();
		ExtentTestManager.test.log(Status.PASS, "Clciking on Cancel button");

	}
	
	public void verifyUserDetails() 
	{
		u.assertion(userEmail.getText(), XlsReader.email);
	}
	
	public void editprofile(WebDriver driver) 
	{
		u.assertion(driver.getCurrentUrl(), Constants.EDIT_PROFILE_URL);
	}
	
	public void verifyConsentMessage() 
	{
		
		u.assertion(consentMessage.getText(), Constants.CONSENT_MESSAGE);
		ExtentTestManager.test.log(Status.PASS, "Consent message is displayed");
	}
	
	public void validatioOfErrorMessages(WebDriver driver) throws IOException 
	{
		guestUserDetails();
	
		try 
		{
			
//			email.clear();
			email.sendKeys(Keys.CONTROL+"a");
			email.sendKeys(Keys.DELETE);
			
			log.info("Email id "+email.getText());
			confrim();
//			mobileNumber.clear();
	
			mobileNumber.sendKeys(Keys.CONTROL+"a");
			mobileNumber.sendKeys(Keys.DELETE);
			Thread.sleep(Constants.SHORT_WAIT);
			
			FirstName.sendKeys(Keys.CONTROL+"a");
			FirstName.sendKeys(Keys.DELETE);
	//		FirstName.clear();
			Thread.sleep(Constants.SHORT_WAIT);

			LastName.sendKeys(Keys.CONTROL+"a");
			LastName.sendKeys(Keys.DELETE);
	//		LastName.clear();
			Thread.sleep(Constants.SHORT_WAIT);

			u.waitUntilVisibilityOfElement(driver, firstNameErrorMessage);
			u.assertion(firstNameErrorMessage.getText(), Constants.FIRSTNAME_ERRORTEXT);
			ExtentTestManager.test.log(Status.PASS, firstNameErrorMessage.getText() +" validation message is diplayed");
			
			
			u.waitUntilVisibilityOfElement(driver, lastNameErrorMessage);

			u.assertion(lastNameErrorMessage.getText(), Constants.LASTNAME_ERRORTEXT);
			ExtentTestManager.test.log(Status.PASS, lastNameErrorMessage.getText() +" validation message is diplayed");
			
			
			u.waitUntilVisibilityOfElement(driver, mobileErrorMessage);

			u.assertion(mobileErrorMessage.getText(), Constants.MOBILE_ERRORTEXT);
			ExtentTestManager.test.log(Status.PASS, mobileErrorMessage.getText() +" validation message is diplayed");
			
			
			u.waitUntilVisibilityOfElement(driver, emailErrorMessage);

			u.assertion(emailErrorMessage.getText(), Constants.EMAIL_ERRORTEXT);
			ExtentTestManager.test.log(Status.PASS, emailErrorMessage.getText() +" is diplayed");
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());

		}
			
	}
}
