package pomPages;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import Utilities.ExtentTestManager;
import Utilities.Testutilites;
import Utilities.configFile;
import constants.Constants;
import constants.locators;

public  class LandingPage {

	
	Logger log = Logger.getLogger(this.getClass().getName());
	Testutilites u = new Testutilites();
	configFile readfile = new configFile();
	String Total_Value;
	public static String cachedDate =null;
	public static String cachedTotalamount = null;
	
	@FindBy(xpath =locators.ADULT_INCREMENT_XPATH)
	private WebElement AdultIncrement;
	
	@FindBy(xpath=locators.ADULT_DECREMENT_XPATH)
	private WebElement AdultDecrement;
	
	@FindBy(xpath=locators.CHILD_DECREMENT_XPATH)
	private WebElement ChildDecremet;
	
	@FindBy(xpath=locators.CHILD_INCREMENT_XPATH)
	private WebElement ChildIncrement;
	
	@FindBy(xpath =locators.TEAMSIZE_NEXT_BUTTON_XPATH)
	private WebElement TeamSize_Next_CTA;
	
	@FindBy(xpath =locators.DATE_SELECTOR_XPATH)
	private List<WebElement> datePicker;
	
	@FindBy(xpath=locators.SAFETY_RULE_CHECK_XPATH)
	private WebElement SafetyCheckBox;
	
	@FindBy(xpath =locators.SET_DATE_XPATH)
	private WebElement setDate;
	
	@FindBy(id = locators.MORNING_SLOT_ID)
	private WebElement MorningTab;
	
	@FindBy(id = locators.AFTERNOON_SLOT_ID)
	private WebElement AfternonTab;
	
	@FindBy(id = locators.EVENING_SLOT_ID)
	private WebElement EveningTab;
	
	@FindBy(xpath = locators.GANE_SESSION_XPATH)
	private List<WebElement> sessions;
	
	@FindBy(xpath = locators.TIME_SLOTS_XPATH)
	private List<WebElement> timeSlots;
	
	@FindBy(xpath = locators.CONFIRM_CTA_XPATH)
	private WebElement confirm;
	
	@FindBy(xpath =locators.COOKIE_XPATH)
	private WebElement AcceptCookie;
	
	@FindBy(xpath = locators.ORDER_SUMMARY_XPATH)
	private WebElement orderSummary;
	
	@FindBy(xpath = locators.CHECKOUT_XPATH)
	private WebElement checkout;
	
	@FindBy(xpath = locators.LOGO_XPATH)
	private WebElement logo;
	
	@FindBy(xpath = locators.LANG_SWITCHER_XPATH)
	private WebElement land_switcher;
	
	@FindBy(xpath = locators.BOOKNOW_XPATH)
	private WebElement bookNowCTA;
	
	@FindBy(xpath=locators.CHILD_VALUE_XPATH)
	private WebElement childValue;
	
	@FindBy(xpath=locators.ADULT_VALUE_XPATH)
	private WebElement AdultValue;
	
	@FindBy(xpath =locators.BOOKING_DATE_XPATH)
	private WebElement getActualDate; 
	
	@FindBy(xpath = locators.TOTAL_AMOUNT_XPATH)
	private WebElement totalAmount;
	
	@FindBy(xpath = locators.ADULT_TOTAL_AMOUNT)
	private WebElement A_totalAmount;
	
	@FindBy(xpath = locators.TOTAL_AMOUNT)
	private WebElement C_totalAmount;
	
	
	@FindBy(xpath = locators.EXPERIENCE_NAME)
	private WebElement experienceName;
	
	@FindBy(xpath=locators.SUMMARY_AUDLTCOUNT)
	private WebElement adultCountText;
	
	@FindBy(xpath=locators.SUMMARY_CHILDCOUNT)
	private WebElement child1countText;
	
	@FindBy(xpath= locators.SUMMARY_VAT)
	private WebElement vat;
		
	@FindBy(xpath= locators.ADULT_SUMMARY_VAT)
	private WebElement vat2;
	
	@FindBy(xpath =locators.EDIT)
	private List <WebElement> edit;
	
	public LandingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logo(WebDriver driver) throws InterruptedException 
	{
		logo.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Applicaiton logo");
		log.info("Clicking on Applicaiton logo");
		u.shortWait();
		try 
		{
			
			u.assertion(driver.getCurrentUrl(), Constants.STAGING_HOME_REDIRECTION_URL);
			ExtentTestManager.test.log(Status.PASS, "Redirected to " + driver.getCurrentUrl());
		}
		catch(Exception e) 
		{
			try 
			{
				u.assertion(driver.getCurrentUrl(), Constants.PROD_HOME_REDIRECTION_URL);
				ExtentTestManager.test.log(Status.PASS, "Redirected to " +driver.getCurrentUrl());
			}
			catch (Exception e2) {
				ExtentTestManager.test.log(Status.FAIL
						, "Clicking on Logo not working as expected");
				throw new RuntimeException("Clicking on Logo not working as expected"+ e2.getMessage());

			}
			
		}
		u.nagivateBack(driver);
	}
	
	public void bookNow(WebDriver driver) throws InterruptedException 
	{
		bookNowCTA.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Book Now CTA");
		log.info("Clicking on Book Now CTA");
		u.shortWait();
		try 
		{
			
			u.assertion(driver.getCurrentUrl(), Constants.STAGING_BOOK_NOW_REDIRECTION_URL);
			ExtentTestManager.test.log(Status.PASS, "Redirected to " +driver.getCurrentUrl());
		}
		catch(Exception e) 
		{
			try {
			u.assertion(driver.getCurrentUrl(), Constants.PROD_BOOK_NOW_REDIRECTION_URL);
			ExtentTestManager.test.log(Status.PASS, "Redirected to " +driver.getCurrentUrl());
			}
			catch (Exception e2) {
				ExtentTestManager.test.log(Status.FAIL
						, "Book Now CTA functionality is not working");
				throw new RuntimeException("Clicking on Book Now not working as expected"+ e2.getMessage());

			}
		
			}
		u.nagivateBack(driver);
	}
	
	public void LangSwitcher(WebDriver driver) throws InterruptedException 
	{
		land_switcher.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Language Switcher");
		u.shortWait();
		try 
		{
			
			u.assertion(driver.getCurrentUrl(), Constants.STAGING_ARABIC_URL);
			ExtentTestManager.test.log(Status.PASS, "Arabic page is displayed" );
		}
		catch(Exception e) 
		{
			try {
			u.assertion(driver.getCurrentUrl(), Constants.PROD_ARABIC_URL);
			ExtentTestManager.test.log(Status.PASS, "Arabic page is displayed");
			}
			catch(Exception e2)
			{
				ExtentTestManager.test.log(Status.FAIL
						, "Language switcher functionality is not working");
				throw new RuntimeException("Clicking on Language switcher not working as expected"+ e2.getMessage());

			}
		}
		u.nagivateBack(driver);
	}
	
	public void adultCount() 
	{
		 int desiredCount = readfile.guestAdultCount();
	        int currentCount = Integer.parseInt(AdultValue.getAttribute("value"));

	        // Increment or decrement to match the desired count
	        while (currentCount < desiredCount) {
	            AdultIncrement.click();
	            ExtentTestManager.test.log(Status.PASS, "Clicking on Adult increment button");
	            log.info("Incrementing Adult count to match desired count.");
	            currentCount++;
	        }
	        
	        while (currentCount > desiredCount) {
	            AdultDecrement.click();
	            ExtentTestManager.test.log(Status.PASS, "Clicking on Adult decrement button");
	            log.info("Decrementing Adult count to match desired count.");
	            break;
	        }
//		for(int i =0; i<readfile.guestAdultCount();i++) 
//		{
//			if(Integer.parseInt(AdultValue.getAttribute("value"))<readfile.guestAdultCount()&&i>2)//2<4
//			{
//				
//					AdultIncrement.click();
//					ExtentTestManager.test.log(Status.PASS, "Clicking on Adult Increment button ");
//					log.info("Clicking on Adult Increment button ");
//			
//			}
//			else if(Integer.parseInt(AdultValue.getAttribute("value"))>readfile.guestAdultCount()&&i<2)
//			{
//				AdultDecrement.click();
//				ExtentTestManager.test.log(Status.PASS, "Clicking on Adult Decrement button ");
//				log.info("Clicking on Adult Decrement button ");
//			}
//			else
//			{
//				ExtentTestManager.test.log(Status.PASS, "Default Adult count is  "+AdultValue.getAttribute("value"));
//				log.info("Clicking on Adult Decrement button ");
//			}
			
		}
		
	
	
	
//	public void adultDecrement() 
//	{
//		
//		AdultDecrement.click();
//		ExtentTestManager.test.log(Status.PASS, "Clicking on Adult Decrement button ");
//		log.info("Clicking on Adult Decrement button ");
//	}
//	public void childDecrement()
//	{
//		
//		ChildDecremet.click();
//		ExtentTestManager.test.log(Status.PASS, "Clicking on Child Increment button ");
//		log.info("Clicking on Child Increment button ");
//	}
	public void childCount() 
	{
		int desiredCount = readfile.getChildcount();
		int currentCount = Integer.parseInt(childValue.getAttribute("value"));
		
		while(currentCount>desiredCount){
			ChildDecremet.click();
			ExtentTestManager.test.log(Status.PASS, "Clicking on Child Increment button ");
			log.info("Clicking on Child Increment button ");
			currentCount--;
		}
		
		while(currentCount<desiredCount) 
		{
			ChildIncrement.click();
			ExtentTestManager.test.log(Status.PASS, "Clicking on Child Increment button ");
			log.info("Clicking on Child Increment button ");
			currentCount++;
			
		}
//		for(int i=0; i<readfile.getChildcount();i++) 
//		{
//			if(Integer.parseInt(childValue.getAttribute("value"))>i) 
//			{
//				ChildIncrement.click();
//				ExtentTestManager.test.log(Status.PASS, "Clicking on Child Increment button ");
//				log.info("Clicking on Child Increment button ");
//			}
//			else if(Integer.parseInt(childValue.getAttribute("value"))==i)
//			{
//				ChildDecremet.click();
//				ExtentTestManager.test.log(Status.PASS, "Clicking on Child Increment button ");
//				log.info("Clicking on Child Increment button ");
//			}
//				
//		}
		
	}
	public void teamSizeNextCTA() 
	{
		
		TeamSize_Next_CTA.click();
		ExtentTestManager.test.log(Status.PASS, "Clicking on Next Step button ");
		log.info("Clicking on Next Step button ");
	}
	
	public String SelectgameDate(WebDriver driver) 
	{
		
//		Random Number = new Random();
//		int date = Number.nextInt(datePicker.size());
//		WebElement SelectDate = datePicker.get(date);
		
		
	    // Check if the element is enabled and clickable
		try {
//		if(SelectDate.isEnabled()) 
//		{
			u.waitUntilVisibilityOfElement(driver, datePicker.getLast());
			ExtentTestManager.test.log(Status.INFO,"Checking date Availablitiy");
			datePicker.get(readfile.getGameDate()-1).click();// reducing index value by 1 to select exact date
			ExtentTestManager.test.log(Status.PASS,"Selecting Game date : "+datePicker.get(readfile.getGameDate()-1).getAttribute(Constants.DATE_LABEL));
			cachedDate = datePicker.get(readfile.getGameDate()-1).getAttribute(Constants.DATE_LABEL);

		}
//		else 
		catch(ElementClickInterceptedException e)
		{
			ExtentTestManager.test.log(Status.FAIL
					,"Selected Date "+ datePicker.get(readfile.getGameDate()-1).getAttribute(Constants.DATE_LABEL)+" is unavailable");
			SelectgameDate(driver);//calling same method to generate another date to select
		}
		return cachedDate;
		}
		
	
	
	
	public void checkbox() 
	{
		ExtentTestManager.test.log(Status.INFO,"Checking for Safety Rules dialogue box displayed or not");
		try 
		{
			SafetyCheckBox.click();
			Thread.sleep(Constants.SHORT_WAIT);
			ExtentTestManager.test.log(Status.PASS,"Clicking on safety check box");
		}
		catch(Exception e) {
			throw new RuntimeException("Safety rule Dialogue box is not displayed");
		}
	}
	
	public void setDate() 
	{
		
		setDate.click();
		ExtentTestManager.test.log(Status.PASS,"Clicking on Set Date Button");
		log.info("Clicking on Set Date Button");
	}
	
	
	public void SelectTimeSlotSelection(WebDriver driver) 
	{
		
		
//		List<WebElement> timingsTabs = Arrays.asList(MorningTab,AfternonTab,EveningTab);
//		log.info(timingsTabs.size());
//		log.info(timingsTabs.getFirst().getText());
		for(int i =0; i<sessions.size();i++)
		{
			
			try 
			{
				
			//	log.info(sessions.size());
			//	log.info(sessions.get(i).getText());
				if(sessions.get(i).getText().trim().equalsIgnoreCase(readfile.getSlots())) 
				{	
					
					log.info(sessions.get(i).getText());
					sessions.get(i).click();
					ExtentTestManager.test.log(Status.PASS,"Clicking on "+ sessions.get(i).getText()+" Slot TAB");
					log.info("Clicking on "+ sessions.get(i).getText()+" Slot TAB");
					ExtentTestManager.test.log(Status.INFO,"Checking for "+ sessions.get(i).getText()+" Time Slots");
					log.info("Checking for "+ sessions.get(i).getText()+" Time Slots");
					
					u.waitUntilVisibilityOfElement(driver,timeSlots.getLast());
					
					for(WebElement gameTime: timeSlots) 
					{
						if(gameTime.getText().equalsIgnoreCase(readfile.getTime())&&gameTime.isEnabled()&&gameTime.isDisplayed()) 
						{
							gameTime.click();
							ExtentTestManager.test.log(Status.PASS, "Selecting "+gameTime.getText()+" time slot");
							log.info("Selecting "+gameTime.getText());
							confirm();
							return;
						}
//						else 
//						{
//							ExtentTestManager.test.log(Status.FAIL, "Selected Time slot "+gameTime.getText()+" is unavailable");
//
//							log.info("No time slot available");
//						}
						
					}
					
					
//					Random randNumber = new Random();
//					int timeindex = randNumber.nextInt(timeSlots.size());
//					WebElement Timeslot = timeSlots.get(timeindex);
//					u.waitUntilVisibilityOfElement(driver,Timeslot);
//					if(Timeslot.isEnabled()&&Timeslot.isDisplayed()) 
//					{
//						log.info(Timeslot.getText());
//						Timeslot.click();
//						ExtentTestManager.test.log(Status.PASS, "Selecting "+Timeslot.getText());
//						log.info("Selecting "+Timeslot.getText());
//						confirm();
//						return;
//					}
//					else 
//					{
//
//						log.info("No time slot available");
//					}
				}
			}
			catch(NoSuchElementException e)
			{
				ExtentTestManager.test.log(Status.FAIL,"All time slots are unavailable." +e.getMessage());
			}
			catch(Exception e)
			{
				ExtentTestManager.test.log(Status.FAIL,"Error while selecting" +e.getMessage());
			}
			
		}
//		
//		try {
//			
//		    if(MorningTab.getText().equalsIgnoreCase( readfile.getProperty("Slot"))) 
//		    	{
//		    	MorningTab.click();
//			    ExtentTestManager.test.log(Status.PASS,"Clicking on Morning slots");
//			    ExtentTestManager.test.log(Status.INFO,"Checking for morning slots");
//			    Timeslot.click();
//			    ExtentTestManager.test.log(Status.PASS, "Selecting "+Timeslot.getText());
//		   	}
//		} catch(Exception e) 
//			{
//			ExtentTestManager.test.log(Status.FAIL,"Morning slots are unavailable");
//		    try {
//		    	 if(AfternonTab.getText().equalsIgnoreCase( readfile.getProperty("Slot"))) 
//			    	{
//				        AfternonTab.click();
//				        ExtentTestManager.test.log(Status.PASS,"Clicking on Afternoon slots");
//				        log.info("Clicking on Afternoon slots");
//				        ExtentTestManager.test.log(Status.INFO,"Checking for Afternoon slots");
//				        Timeslot.click();
//					    ExtentTestManager.test.log(Status.PASS, "Selecting "+Timeslot.getText() );
//			    	}
//		    	 
//		    	 else{
//			    		 ExtentTestManager.test.log(Status.FAIL,"Afternoon slots are unavailable");
//			       
//			            EveningTab.click();
//			            ExtentTestManager.test.log(Status.PASS,"Clicking on Evening slots");
//			            log.info("Clicking on Evening slots");
//			            ExtentTestManager.test.log(Status.INFO,"Checking for Evening slots");
//			            Timeslot.click();
//					    ExtentTestManager.test.log(Status.PASS, "Selecting "+Timeslot.getText() );
//		    	 }
//
//		       
//		    } catch(Exception e3) {
//	        	ExtentTestManager.test.log(Status.FAIL,"All time slots are unavailable." +e3.getMessage());
//	        }
//		}
		
	}
	
	public void confirm() 
	{
		confirm.click();
		ExtentTestManager.test.log(Status.PASS,"Clicking on Confirm CTA");
		log.info("Clicking on Confirm CTA");
	}
	
	public void acceptCookies() throws InterruptedException 
	{
		if(AcceptCookie.isDisplayed()) 
		{
			AcceptCookie.click();
			Thread.sleep(Constants.SHORT_WAIT);
			log.info("Accepting cookies");
		}
	}
	
//	public String proceedToCheckout() 
//	{
//		
//		String actualText = getActualDate.getText();
////		log.info(actualText);
//		String[] splitText = actualText.split(",|\\sat");
//		
////		if(splitText.length==3) 
////		{
//			String date = splitText[1].trim();
//			String time = splitText[2].trim();
//			log.info("Time : "+time);
//			log.info("Date : " +date);
//			log.info("cached Date : "+cachedDate);
//			if(cachedDate!=null && date.equalsIgnoreCase(cachedDate))
//			{
//		//		log.info("cached Date 2"+cachedDate);
//				if(time.equalsIgnoreCase(readfile.getTime())) 
//					{
//						ExtentTestManager.test.log(Status.PASS, "Proceeding to checkout");
//						String order_Summary;
//						try {
//							
//							order_Summary= String.join("<br>", orderSummary.getText(),experienceName.getText(),getActualDate.getText(),adultCountText.getText(),child1countText.getText(),vat.getText(),C_totalAmount.getText());
////							ExtentTestManager.test.log(Status.INFO, orderSummary.getText()+"<br>"+ experienceName.getText()+"<br>"
////									+getActualDate.getText()+"<br>"+adultCountText.getText()+"<br>"+child1countText.getText()+"<br>"+vat.getText()+"<br>"+C_totalAmount.getText());
//
//						ExtentTestManager.test.log(Status.PASS, order_Summary);			
//						}	
//						
//						catch(Exception e)
//						{
//							order_Summary= String.join("<br>", orderSummary.getText(),experienceName.getText(),getActualDate.getText(),adultCountText.getText(),vat2.getText(),A_totalAmount.getText());
//
////							ExtentTestManager.test.log(Status.INFO, orderSummary.getText()+"<br>"+ experienceName.getText()+"<br>"
////								+getActualDate.getText()+"<br>"+adultCountText.getText()+"<br>"+vat2.getText()+"<br>"+A_totalAmount.getText());
//							ExtentTestManager.test.log(Status.PASS, order_Summary);			
//
//						}
//						log.info("Getting order summary : " +orderSummary.getText());
//								checkout.click();
//								
//						ExtentTestManager.test.log(Status.PASS, "Clicking on Checkout");
//						log.info("Clicking on Checkout");
//					}else
//					{
//		        	ExtentTestManager.test.log(Status.FAIL,"Unable to proceed to check as date and time not available" );
//					}
//				
//			}else 
//			{
//	        	ExtentTestManager.test.log(Status.FAIL,"Pls check you property file and update the data");
//
//			}
//			log.info(totalAmount.getText());
////			String total_Amount = totalAmount.getText();
////			log.info(total_Amount);
////		//	String split = total_Amount.split("")
//			return cachedTotalamount = totalAmount.getText();
//			
//		}
	
	public String proceedToCheckout() {
	    String actualText = getActualDate.getText();
	    String[] splitText = actualText.split(",|\\sat");

	    String date = splitText[1].trim();
	    String time = splitText[2].trim();
	    
	    if (cachedDate == null || !date.equalsIgnoreCase(cachedDate)) {
	        ExtentTestManager.test.log(Status.FAIL, "Please check your property file and update the data");
	        return null;
	    }

	    if (!time.equalsIgnoreCase(readfile.getTime())) {
	        ExtentTestManager.test.log(Status.FAIL, "Unable to proceed to checkout as date and time are not available");
	        return null;
	    }

	    ExtentTestManager.test.log(Status.PASS, "Proceeding to checkout");

	    // Store text values to avoid multiple DOM accesses
//	    String orderSummaryText = orderSummary.getText();
//	    String experienceNameText = experienceName.getText();
//	    String actualDateText = getActualDate.getText();
//	    String adultCountTextVal = adultCountText.getText();
//	    String vatText, totalAmountText;
//
//	    try {
//	        vatText = vat.getText();
//	        totalAmountText = C_totalAmount.getText();
//	    } catch (Exception e) {
//	        vatText = vat2.getText();
//	        totalAmountText = A_totalAmount.getText();
//	    }
//
//	    // Optimized String concatenation using StringBuilder
//	    StringBuilder orderSummaryBuilder = new StringBuilder();
//	    orderSummaryBuilder.append(orderSummaryText).append("<br>")
//	            .append(experienceNameText).append("<br>")
//	            .append(actualDateText).append("<br>")
//	            .append(adultCountTextVal).append("<br>")
//	            .append(vatText).append("<br>")
//	            .append(totalAmountText);
//
//	    ExtentTestManager.test.log(Status.PASS, orderSummaryBuilder.toString());

	    checkout.click();
	    ExtentTestManager.test.log(Status.PASS, "Clicking on Checkout");

	    return cachedTotalamount = totalAmount.getText();
	}
	
}
//	}
