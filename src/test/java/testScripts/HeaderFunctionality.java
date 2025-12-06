package testScripts;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.LandingPage;

public class HeaderFunctionality  extends BaseClass{
	@Test(testName = "Valdiation of Header functionality", description = "This test validates the header menu, CTA functionlities")
	 public void LP_TC_03() throws InterruptedException 
	 {
		LandingPage lp =new LandingPage(driver);
		lp.logo(driver);
		lp.LangSwitcher(driver);
		lp.bookNow(driver);
	 }
}
