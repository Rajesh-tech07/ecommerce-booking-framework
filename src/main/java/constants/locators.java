package constants;

public class locators {

	//Header 
	
	public static final String LOGO_XPATH="(//a[contains(@class,\"relative inline-flex\")])[1]";
	public static final String LANG_SWITCHER_XPATH="(//a[contains(@class,\"relative inline-flex\")])[2]";
	public static final String BOOKNOW_XPATH="//a[contains(text(),\"BOOK NOW\")]";

//Landing Page Xpaths
	
	public static final String COOKIE_XPATH= "//button[text()='Accept All']";
	public static final String EDIT="//button[text()=\"Edit\"]";
	
	
	//Select Activate team size
	public static final String ADULT_INCREMENT_XPATH="(//div[@class=\"flex items-center\"]//button)[2]";
	public static final String ADULT_DECREMENT_XPATH="(//div[@class=\"flex items-center\"]//button)[1]";
	public static final String CHILD_INCREMENT_XPATH="(//div[@class=\"flex items-center\"]//button)[4]";
	public static final String CHILD_DECREMENT_XPATH="(//div[@class=\"flex items-center\"]//button)[3]";
	public static final String ADULT_COUNT_XPATH="(//div[@class=\"flex items-center\"]//input)[1]";
	public static final String CHILD_COUNT_XPAHT="(//div[@class=\"flex items-center\"]//input)[2]";
	public static final String ADULT_VALUE_XPATH ="(//div[@class=\"flex items-center\"]//input)[1]";
	public static final String CHILD_VALUE_XPATH ="(//div[@class=\"flex items-center\"]//input)[2]";
	

	public static final String TEAMSIZE_NEXT_BUTTON_XPATH ="//button[contains(text(),'NEXT STEP')]";
	public static final String SAFETY_RULE_CHECK_XPATH="//span[text()='I UNDERSTAND']";

	
	//Set your Activate game date
	public  final static String DATE_SELECTOR_XPATH ="//div[@class=\"react-calendar__month-view__days\"]//button//abbr";
	public static final String SET_DATE_XPATH= "//button[text()='SET DATE']";
	
	//Select your timings
	
	public static final String MORNING_SLOT_ID="morning";
	public static final String AFTERNOON_SLOT_ID="afternoon";
	public static final String EVENING_SLOT_ID="evening";
	
	public static final String 	GANE_SESSION_XPATH= "//div//h3[@class=\"text-sm font-bold md:text-xl\"]";
	
	public static final String TIME_SLOTS_XPATH ="//button[contains(@class,\"group text-center\")]//span";
	public static final String CONFIRM_CTA_XPATH="//button[contains(text(),'CONFIRM')]";
	
	//Order summary
//	public static final String ORDER_SUMMARY_XPATH ="(//div[contains(@class,\"flex flex-col \")])[4]";
	public static final String ORDER_SUMMARY_XPATH = "(//div[contains(@class,\"flex flex-col \")]//h3)[1]";
	public static final String EXPERIENCE_NAME ="(//div[contains(@class,\"flex flex-col \")]//h3)[2]";
	public static final String CHECKOUT_XPATH= "//button[contains(text(),\"PROCEED TO CHECKOUT\")]";
	public static final String SUMMARY_CHILDCOUNT="(//div[contains(@class,\"flex flex-row justify\")])[2]";
	public static final String SUMMARY_AUDLTCOUNT="(//div[contains(@class,\"flex flex-row justify\")])[1]";
	public static final String SUMMARY_VAT="(//div[contains(@class,\"flex flex-row justify\")])[3]";
	public static final String TOTAL_AMOUNT="(//div[contains(@class,\"flex flex-row justify\")])[4]";

	public static final String ADULT_SUMMARY_VAT="(//div[contains(@class,\"flex flex-row justify\")])[2]";
	public static final String ADULT_TOTAL_AMOUNT="(//div[contains(@class,\"flex flex-row justify\")])[3]";


	public static final String TOTAL_AMOUNT_XPATH="(//div[contains(@class,'flex flex-row justify-between')]//strong)[2]";
	public static final String BOOKING_DATE_XPATH="//p[@class=\"mb-2 text-order-summary-500\"]";
	
//Personal details page
	
	public static final String DATE_XPATH ="(//input[contains(@class,\"w-full font-normal\")])[6]";
	public static final String TIME_XPATH ="(//input[contains(@class,\"w-full font-normal\")])[7]";
	public static final String REMOVE_CTA_XPATH ="//button[text()=\"Remove\"]";
	public static final String DETAILS_PAGE_EDIT_XATH = "//button[text()=\"Edit\"]";
	public static final String DETAILS_PAGE_CONFIRM_XPATH ="//button[text()=\"CONFIRM \"]";
	public static final String FIRST_NAME ="firstName";
	public static final String LAST_NAME ="lastName";
	public static final String COUNTRYCODE = "(//input[contains(@class,\"w-full font-normal\")])[3]";
	public static final String MOBILENUMBER="phone";
	public static final String EMAIL ="email";
	public static final String CHECKBOX= "//div[@class=\"flex items-start mb-2\"]";
	public static final String SINGIN="//button[text()=\"SIGN IN\"]";
	public static final String CREATE_ACCOUNT ="//button[text()=\"CREATE ACCOUNT\"]";
	public static final String TOTAL_AMOUNT_BEFORE_CHECKOUT="(//div[contains(@class,\"flex flex-row justify\")]//strong)[4]";
	public static final String SHARE_POINTS_YOU_EARN ="(//div[contains(@class,\"flex flex-row justify\")])[5]";
	public static final String YES_REMOVE="//button[text()=\"Yes, remove\"]";
	public static final String CANCEL_REMOVE="//button[text()=\"Yes, remove\"]";
	public static final String USEREMAIL="//div[@class=\"text-start\"]/child::div//p[2]";
	public static final String EDITPROFILE ="//button[text()='Edit Profile']";
	public static final String FIRSTNAME_ERRORMESSAGE ="(//div[@class=\"text-tiny text-danger\"])[1]";
	public static final String LASTNAME_ERRORMESSAGE ="(//div[@class=\"text-tiny text-danger\"])[2]";
	public static final String MOBILE_ERRORMESSAGE ="(//div[@class=\"text-tiny text-danger\"])[3]";
	public static final String EMAIL_ERRORMESSAGE ="(//div[@class=\"text-tiny text-danger\"])[4]";

	
	//maf site sign in 
	
	public static final String EMAIL_LOCATOR ="email";
	public static final String PASSWORD_LOCATOR ="password";
	public static final String LOGIN_LOCATOR="//button[text()=\"Log in\"]";
	public static final String RECAPTCH_IFRMAE_LOCATOR ="//iframe[@title='reCAPTCHA']";
//	public static final String RECAPTCH_LOCATOR ="recaptcha-anchor";
//	public static final String RECAPTCH_LOCATOR ="//div[@class='rc-anchor-content']";
	public static final String CONSENT_LOCATOR="//p[@class=\"text-danger text-sm\"]"; 
	public static final String IFRAME_PRESENECE="recaptcha-token";
	
	//payment page
	public static final String REGISTER_LOCATOR ="//button[text()='Register']";
	public static final String JOINSHARE_LOCATOR ="//button[text()='Join SHARE']";
	public static final String CARDNUMBER_LOCATOR ="cardnumber";
	public static final String CARDNUMBER_IFRAME= "cardNumber";
	public static final String EXPIRYDATE="exp-date";
	public static final String CVV="cvc";
	public static final String CVV_iFRAME="cvv";

	public static final String EXPIRY_iFRAME_LOCATOR ="expiryDate";
	public static final String PAY_BUTTON_LOCATOR="//button[text()='PAY'] ";
	
	//share utilization
	
	public static final String SHARE_ENABLE_LOCATOR ="(//label[contains(@class,\"group relative\")])[1]";
	public static final String SHAREPOINT_FIELD_LOCATOR ="(//input[@type=\"text\"])[1]";
	public static final String SHARE_APPLY_LOCATOR="(//button[text()='Apply'])[1]";
	public static final String USE_ALL_SHARE_POINT_LOCATOR="(//input[@type=\"checkbox\"])[2]";
	public static final String SHAREREMOVE_LOCATOR ="(//button[text()='Remove'])[1]";
	public static final String TOTALAMT_AFTER_SHARE ="(//div[contains(@class,\"flex flex-row justify\")])[5]";
	
	
	
	//authentication staging payment
	public static final String AUTHENTICATION_iFRAME ="cko-3ds2-iframe";
	public static final String PASSWORD="//div[@class=\"input-wrap\"]//input";
	public static final String CONTINUE_LOCATOR ="txtButton";
	
}
