package testScripts;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Utilities.Testutilites;
import pomPages.LandingPage;

public class landingPageTestScript extends BaseClass {

	Testutilites u = new Testutilites();
	 
	@Test(enabled = true,testName= "Validation of Checkout in landing page as 'Adult'" ,description=" This tests and validates the adult functionlity, selects date, time and proceeds checkout")
	public void LP_TC_01() throws InterruptedException 
	{
		LandingPage lp =new LandingPage(driver);
		lp.adultCount();
		lp.teamSizeNextCTA();
		lp.acceptCookies();
		lp.SelectgameDate(driver);
		lp.setDate();
		lp.SelectTimeSlotSelection(driver);
		lp.proceedToCheckout();
		
	}
	
	@Test(enabled = true,testName= "Validation of Checkout in landing page as 'Child'" ,description=" Validates child safety popup functionality")
	public void LP_TC_02() 
	{
		LandingPage lp =new LandingPage(driver);
		lp.adultCount();
		lp.childCount();
		lp.teamSizeNextCTA();
		lp.checkbox();
		lp.SelectgameDate(driver);
		lp.setDate();
		lp.SelectTimeSlotSelection(driver);
		lp.proceedToCheckout();
	}

}
