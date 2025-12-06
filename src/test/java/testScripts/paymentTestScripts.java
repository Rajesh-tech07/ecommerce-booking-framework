package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Utilities.XlsReader;
import pomPages.paymentDetails;

public class paymentTestScripts  extends BaseClass{

	@Test(testName ="Valdiation of payment using credit/debit card", description ="This test validated the payment functionlaity using valid credit card")
	public void PTS_01() throws IOException, InterruptedException 
	{
		XlsReader excelRead = new XlsReader(); 

		paymentDetails pay = new paymentDetails(driver, excelRead);
			pay.Validcredit_DebitCard(driver);
			
			pay.paymentvalidation(driver);

	}
	
	@Test(testName ="Valdiation of payment using invalid credit/debit card", description ="This test validated the payment functionlaity using invalid credit card")
	public void PTS_02() throws IOException, InterruptedException 
	{
		XlsReader excelRead = new XlsReader();  

		paymentDetails pay = new paymentDetails(driver ,excelRead);
		pay.InValidcredit_DebitCard(driver);
		
			pay.paymentvalidation(driver);
		
	}
	
	@Test(testName="Validaiton of share utilization", description="This test verifys the share points utilization")
	public void PTS_03() 
	{
		paymentDetails pay = new paymentDetails(driver ,null);
		pay.shareUtilization();
		pay.checkoutDetails();
	}
}
