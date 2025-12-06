package constants;

import java.time.Duration;

public class Constants {

	//Browsers 
	public static final String CHROME_BROWSER = "Chrome";
	public static final String EDGE_BROWSER = "Edge";
	public static final String FIREFOX_BROWSER = "firefox";
	
	//Wait in seconds
	public static final long IMPLICIT_WAIT = 30;
	public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(30);
	//Wait in milliseconds
	public static final int SHORT_WAIT =3000;
	public static final int LONG_WAIT=10000;
	public static final int MEDIUM_WAIT=6000;
	
	// Environment endpoints (REDACTED for safe sharing)
	public static final String PROD_URL ="REDACTED_PROD_URL";
	public static final String STAGING_URL ="REDACTED_STAGING_URL";
	public static final String PROD_ARABIC_URL ="REDACTED_PROD_ARABIC_URL";
	public static final String STAGING_ARABIC_URL ="REDACTED_STAGING_ARABIC_URL";

	public static final String DATE_LABEL ="aria-label";
	
	public static final String STAGING_HOME_REDIRECTION_URL ="REDACTED_STAGING_HOME_REDIRECTION_URL";
	public static final String PROD_HOME_REDIRECTION_URL = "REDACTED_PROD_HOME_REDIRECTION_URL";
	public static final String STAGING_BOOK_NOW_REDIRECTION_URL="REDACTED_STAGING_BOOK_NOW_REDIRECTION_URL";
	public static final String PROD_BOOK_NOW_REDIRECTION_URL ="REDACTED_PROD_BOOK_NOW_REDIRECTION_URL";
	
	// API / profile endpoint removed for privacy
	public static final String EDIT_PROFILE_URL ="REDACTED_EDIT_PROFILE_URL";
	public static final String CONSENT_MESSAGE ="You must agree to the consent";
	
	public static final String FIRSTNAME_ERRORTEXT="First name is required";
	public static final String LASTNAME_ERRORTEXT ="Last name is required";
	public static final String MOBILE_ERRORTEXT= "Mobile number is required";
	public static final String EMAIL_ERRORTEXT="Email is required";

	public static final String SHARE_POINTS_ERROR="Not enough points available";
	public static final String TOKEN ="REDACTED_TOKEN";
}