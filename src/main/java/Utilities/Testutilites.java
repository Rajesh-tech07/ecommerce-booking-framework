package Utilities;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.Constants;


public class Testutilites {

	public WebDriver driver ;
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public void assertion(String actual, String expected) 
	{
		//SoftAssert s = new SoftAssert();
		//s.assertEquals(actual, expected);
		assertEquals(actual, expected);
	}
	
	public void alert(WebDriver driver) 
	{
		try 
		{
			
			driver.switchTo().alert().dismiss();
			log.info("Closing Alert ");
			
		}
		catch(NoAlertPresentException e)
		{
			log.info("No Alert present");
		}
		
		
	}
	
	public  void shortWait() throws InterruptedException 
	{
		Thread.sleep(Constants.SHORT_WAIT);
	}
	
	public  void longWait() throws InterruptedException 
	{
		Thread.sleep(Constants.LONG_WAIT);
	}
	
	public  void mediumWait() throws InterruptedException 
	{
		Thread.sleep(Constants.MEDIUM_WAIT);
	}
	
	public void waitUntilVisibilityOfElement(WebDriver driver ,WebElement locator) 
	{
		
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(locator));
		
	}
	
	
	public void nagivateBack(WebDriver driver) 
	{
		driver.navigate().back();
	}
	
	public void nagivatefront(WebDriver driver) 
	{
		driver.navigate().forward();
	}
	
	
	
	
}
