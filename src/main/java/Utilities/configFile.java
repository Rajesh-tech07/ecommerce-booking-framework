package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configFile  {

	Properties readconfigFile;
	public  configFile() 
	{
		try {
			FileInputStream dataFile=  new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\application.properties");
			readconfigFile = new Properties();
			readconfigFile.load(dataFile);
		}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				throw new RuntimeException("Configuration file not found"+e.getMessage());
			}
			catch(IOException e)
		{
				throw new RuntimeException("Error loading file"+e.getMessage());
		}
			
	}
	
	public String browserControl() 
	{
		String Browser= readconfigFile.getProperty("browser");
		return Browser;
	}
	
	public String applicationURL() 
	{
		String application_Staging_URL = readconfigFile.getProperty("staging_URL");
		String application_Prod_URL = readconfigFile.getProperty("Prod_URL");
		
		String urlName = readconfigFile.getProperty("URLName");
	    if (urlName == null) {
	        throw new RuntimeException("URLName not specified in application.properties");
	    }
	    
		if("Prod_URL".equalsIgnoreCase(urlName) && application_Prod_URL!=null)
		return application_Prod_URL;
		
		else if("staging_URL".equalsIgnoreCase(urlName) && application_Staging_URL!=null)
			return application_Staging_URL;
		
		else
			throw new RuntimeException( "URL is not specifed in Application.Properites file");
				
	}
	
	
	public String getSlots() 
	{
		String slots = readconfigFile.getProperty("Slot");
		return slots;
	}
	
	public int  guestAdultCount() 
	{
		
		String AdultCount = readconfigFile.getProperty("Adult");
		int adult = Integer.parseInt(AdultCount);
		return adult;
	}
	
	public int  getChildcount() 
	{
		String ChildCount = readconfigFile.getProperty("Child");
		int child =Integer.parseInt(ChildCount);
		return child;
	}
	
	public int getGameDate() 
	{
		String date = readconfigFile.getProperty("Date");
		int gameDate = Integer.parseInt(date);
		return gameDate;
	}
	
	public String getTime() 
	{
		String time = readconfigFile.getProperty("Time");
		return time;
	}
	
	public String firstName() 
	{
		String firstName = readconfigFile.getProperty("firstName");
		return firstName;
	}
	public String lastName() 
	{
		String lastName = readconfigFile.getProperty("lastName");
		return lastName;
	}
	public String country() 
	{
		String country = readconfigFile.getProperty("country");
		return country;
	}
	public String mobile() 
	{
		String mobile = readconfigFile.getProperty("mobile");
		return mobile;
	}
	public String email() 
	{
		String email = readconfigFile.getProperty("Guestemail");
		return email;
	}

	public String getUserEmail() {
		// TODO Auto-generated method stub
		
		String UserEmail = readconfigFile.getProperty("UserEmail");
		return UserEmail;
	}
	
	public String getUserPass() {
		// TODO Auto-generated method stub
		
		String UserPass = readconfigFile.getProperty("password");
		return UserPass;
	}
	
//	public String getCardNumber() 
//	{
//		String cardNumber = readconfigFile.getProperty("cardNumber");
//		return cardNumber;
//	}
//	
//	public String getExpiryDate() 
//	{
//		String Expiry = readconfigFile.getProperty("ExpiryDate");
//		return Expiry;
//	}
//	
//	public String getCVV() 
//	{
//		String CVV = readconfigFile.getProperty("CVV");
//		return CVV;
//	}
//	
	public String getUserType() 
	{
		String usertype =readconfigFile.getProperty("usertype");
		return usertype;
	}
	public String getshareUserType() 
	{
		String shareType= readconfigFile.getProperty("Share");
		return shareType;
	}
	
	public String cardType() 
	{
		String card = readconfigFile.getProperty("card");
		return card;
	}
	
	public String sharepoint() 
	{
		String points= readconfigFile.getProperty("sharepoints");
		return points;
	}
}
