package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Utilities.XlsReader;
import pomPages.UserDetailsPage;

public class GuestUser extends BaseClass {

	@Test(enabled = true , testName = "Valdiation of Guest user flow", description ="This test validates the guest user flow")
	public void GU_01() throws IOException 
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage userflow = new UserDetailsPage(driver, excelRead);
		userflow.guestUserDetails();
		userflow.checkbox();
	//	userflow.paymentSummry();
		userflow.confrim();
		
	}
	
	
	@Test(enabled = false,testName = "Validation of Edit Ticket flow", description = "This test case vaidated the edit ticket flow")
	public void GU_02() throws InterruptedException, IOException 
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage userflow = new UserDetailsPage(driver, excelRead);

		userflow.edit(driver);
	}
	
	
	@Test(enabled = false ,testName = "Validation of Remove ticket flow", description = "This test case vaidated the remove ticket flow")
	public void GU_03() throws InterruptedException, IOException 
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage userflow = new UserDetailsPage(driver, excelRead);

		userflow.Yesremove();
	}
	
	
	@Test(testName="Validation of consent message", description = "This test check whether consent message is displayed or not when user clicks confirm without accepting terms and conditions")
	public void GU_04() throws IOException 
	
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage userflow = new UserDetailsPage(driver, excelRead);
		userflow.guestUserDetails();
		userflow.confrim();
		userflow.verifyConsentMessage();
	}
	
	
	
	@Test(testName="Validation of Error message", description = "This test validates the guest form error messages")
	public void GU_05() throws IOException 
	
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage userflow = new UserDetailsPage(driver, excelRead);
		userflow.validatioOfErrorMessages(driver);
	}
	
}
