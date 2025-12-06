package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Utilities.XlsReader;
import pomPages.SignIn_Page;
import pomPages.UserDetailsPage;

public class signedUserTestScript extends BaseClass {

	@Test(testName= "Valdiation of already registered user by sign in flow", description ="This validates the flow of existing user ")
	public void SU_01() throws IOException, InterruptedException 
	{
		XlsReader excelRead = new XlsReader(); 

		UserDetailsPage Userflow = new UserDetailsPage(driver, excelRead);
		
		Userflow.signin();
		
		SignIn_Page signedUser = new SignIn_Page(driver, excelRead);

		signedUser.loginDetails(driver);
		Userflow.verifyUserDetails();
		Userflow.confrim();
		
	}

	
}

