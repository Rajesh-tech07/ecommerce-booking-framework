package Utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public String getScreenshot(WebDriver driver, String testName) throws IOException 
	{
		Date CurrentDate = new Date();
//		String formatted_date= CurrentDate.toGMTString().replaceAll(":", "-");
		String  formatted_date =  new SimpleDateFormat("EEEE, MMMM dd, yyyy, hh-mm a (z)").format(CurrentDate);
				String fileName = testName+"_"+formatted_date+".png";
		String filePath = System.getProperty("user.dir")+"\\FailedScreenShots\\"+fileName;
		TakesScreenshot screenshot =(TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath); 
		FileUtils.copyFile(source, destination);
		
		return filePath;
	}

	
}
