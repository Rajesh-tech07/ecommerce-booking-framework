package Utilities;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class XlsReader {
	configFile read= new configFile();

	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet userDatasheet = null;
	private XSSFSheet cardDataSheet= null;
	public static String firsname=null;
	public static String lastname=null;
	public static String countryCode=null;
	public static String country=null;
	public static String mobileNumber=null;
	public static String email=null;
	public static String password = null;
	public static String cardNumber =null;
	public static String cvv= null;
	public static String expiry =null;
	

	public  XlsReader() throws IOException 
	{
		try 
		{
            // First check system property -Dxls.path=... (recommended for flexibility)
            String configuredPath = System.getProperty("xls.path");
            String filePath;
            if (configuredPath != null && !configuredPath.trim().isEmpty()) {
                filePath = configuredPath.trim();
            } else {
                // Fallback to workspace-relative path: ${user.dir}/demo_UserDetails.xlsx or .csv
                filePath = System.getProperty("user.dir") + File.separator + "demo_UserDetails.xlsx";
            }

            System.out.println("Loading data from: " + filePath);
            File dataFile = new File(filePath);

            if (dataFile.exists()) {
                if (filePath.toLowerCase().endsWith(".csv")) {
                    // Read CSV and populate in-memory workbook
                    workbook = new XSSFWorkbook();
                    userDatasheet = workbook.createSheet("userdetails");
                    cardDataSheet = workbook.createSheet("cardDetails");

                    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(dataFile))) {
                        String header = br.readLine();
                        if (header == null) return; // empty file
                        String[] cols = header.split(",");
                        // determine type by header columns; assume userdetails CSV if header contains 'firstName'
                        if (header.toLowerCase().contains("firstname") || header.toLowerCase().contains("first_name")) {
                            // write header to sheet
                            XSSFRow h = userDatasheet.createRow(0);
                            for (int c = 0; c < cols.length; c++) h.createCell(c).setCellValue(cols[c]);
                            int r = 1;
                            String line;
                            while ((line = br.readLine()) != null) {
                                XSSFRow row = userDatasheet.createRow(r++);
                                String[] vals = line.split(",");
                                for (int c = 0; c < vals.length; c++) row.createCell(c).setCellValue(vals[c]);
                            }
                        } else {
                            // treat as cardDetails CSV
                            XSSFRow h = cardDataSheet.createRow(0);
                            for (int c = 0; c < cols.length; c++) h.createCell(c).setCellValue(cols[c]);
                            int r = 1;
                            String line;
                            while ((line = br.readLine()) != null) {
                                XSSFRow row = cardDataSheet.createRow(r++);
                                String[] vals = line.split(",");
                                for (int c = 0; c < vals.length; c++) row.createCell(c).setCellValue(vals[c]);
                            }
                        }
                    }
                } else {
                    // existing XLSX loading
                    fis = new FileInputStream(dataFile);
                    workbook = new XSSFWorkbook(fis);
                    userDatasheet = workbook.getSheet("userdetails");
                    cardDataSheet = workbook.getSheet("cardDetails");
                }
            } else {
                // Create an in-memory workbook with sanitized demo data so code can run without the real file
                System.out.println("Data file not found at " + filePath + ". Falling back to in-memory sanitized data.");
                workbook = new XSSFWorkbook();

                // Create userdetails sheet with header and one demo row
                userDatasheet = workbook.createSheet("userdetails");
                XSSFRow header = userDatasheet.createRow(0);
                header.createCell(0).setCellValue("type");
                header.createCell(1).setCellValue("email");
                header.createCell(2).setCellValue("firstName");
                header.createCell(3).setCellValue("lastName");
                header.createCell(4).setCellValue("countryCode");
                header.createCell(5).setCellValue("mobile");
                header.createCell(6).setCellValue("password");
                header.createCell(7).setCellValue("share");

                XSSFRow demo = userDatasheet.createRow(1);
                demo.createCell(0).setCellValue("Guest");
                demo.createCell(1).setCellValue("demo.user@example.com");
                demo.createCell(2).setCellValue("Demo");
                demo.createCell(3).setCellValue("User");
                demo.createCell(4).setCellValue("+971");
                demo.createCell(5).setCellValue("0123456789");
                demo.createCell(6).setCellValue("Test@1234");
                demo.createCell(7).setCellValue("No");

                // Create cardDetails sheet with header and demo card rows
                cardDataSheet = workbook.createSheet("cardDetails");
                XSSFRow cardHeader = cardDataSheet.createRow(0);
                cardHeader.createCell(0).setCellValue("cardType");
                cardHeader.createCell(1).setCellValue("validity");
                cardHeader.createCell(2).setCellValue("cardNumber");
                cardHeader.createCell(3).setCellValue("expiry");
                cardHeader.createCell(4).setCellValue("cvv");

                XSSFRow cardDemo = cardDataSheet.createRow(1);
                cardDemo.createCell(0).setCellValue("Visa");
                cardDemo.createCell(1).setCellValue("valid");
                cardDemo.createCell(2).setCellValue("4242424242424242");
                cardDemo.createCell(3).setCellValue("12/30");
                cardDemo.createCell(4).setCellValue("123");
            }
        }
		
		catch(Exception e) 
		{
			 e.printStackTrace();
			
		}
		
		
	}
	
	public void GuestUserData() throws IOException 
	{
		
			int userRow = userDatasheet.getLastRowNum();
		//	userDatasheet.getRow(1).getLastCellNum();
			for(int i =1;i<=userRow;i++) 
			{
				XSSFRow row = userDatasheet.getRow(i);
				String usertype = row.getCell(0).getStringCellValue();
				//	row.getCell(7).getStringCellValue();
					if(usertype.equalsIgnoreCase("Guest")) 
					{
					 firsname = row.getCell(2).getStringCellValue();
					 lastname = row.getCell(3).getStringCellValue();
					 countryCode= row.getCell(4).getStringCellValue();
					 mobileNumber = row.getCell(5).getStringCellValue();
					 email = row.getCell(1).getStringCellValue();
					 break;
					}
					
			}
			
			
			workbook.close();
			fis.close();
	}
	
	public void registeredUserData() throws IOException 
	{
		
			int userRow = userDatasheet.getLastRowNum();
		//	userDatasheet.getRow(1).getLastCellNum();
			for(int i =1;i<=userRow;i++) 
			{
				XSSFRow row = userDatasheet.getRow(i);
				String usertype = row.getCell(0).getStringCellValue().trim();
					String shareType = row.getCell(7).getStringCellValue().trim();
					if(usertype.equalsIgnoreCase("Signed") && shareType.equalsIgnoreCase("yes")) 
				//	if(usertype.equalsIgnoreCase("Signed"))
					{
					 email = row.getCell(1).getStringCellValue();
					 System.out.println(email);
					 password =row.getCell(6).getStringCellValue();
					 System.out.println(password);
					 break;
					}
		}
			
			workbook.close();
			fis.close();
	}

	public  void sharedUserData() throws IOException 
	{
		
			int userRow = userDatasheet.getLastRowNum();
	//		userDatasheet.getRow(1).getLastCellNum();
			for(int i =1;i<=userRow;i++) 
			{
				XSSFRow row = userDatasheet.getRow(i);
				String usertype = row.getCell(0).getStringCellValue();
					String shareType = row.getCell(7).getStringCellValue();
				//	if(usertype.equalsIgnoreCase("signed")&&shareType.equalsIgnoreCase("No")) 
					if(shareType.equalsIgnoreCase("Yes"))
					{
					 email = row.getCell(1).getStringCellValue();
					 password =row.getCell(6).getStringCellValue();
					 
					}
		}
			
			workbook.close();
			fis.close();
	}
	

	
	public void validcardDetails() throws IOException 
	{
		int row = cardDataSheet.getLastRowNum();
		cardDataSheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=row;i++) 
		{
			XSSFRow currentrow = cardDataSheet.getRow(i);
			String cellvalue= currentrow.getCell(0).getStringCellValue();
			String validType=currentrow.getCell(1).getStringCellValue();
			if(cellvalue.equalsIgnoreCase(read.cardType())&&validType.equalsIgnoreCase("valid")) 
			{
				cardNumber= currentrow.getCell(2).getStringCellValue();
				System.out.println(cardNumber);
			//	cvv =String.valueOf(currentrow.getCell(4).getNumericCellValue());
				cvv = currentrow.getCell(4).getStringCellValue();
				System.out.println(cvv);
				expiry = currentrow.getCell(3).getStringCellValue();
				System.out.println(expiry);
			}
		}
		workbook.close();
		fis.close();
	}
	
	public void InvalidcardDetails() throws IOException 
	{
		int row = cardDataSheet.getLastRowNum();
		cardDataSheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=row;i++) 
		{
			XSSFRow currentrow = cardDataSheet.getRow(i);
			String cellvalue= currentrow.getCell(0).getStringCellValue();
			String validType=currentrow.getCell(1).getStringCellValue();
			if(cellvalue.equalsIgnoreCase(read.cardType())&&validType.equalsIgnoreCase("invalid")) 
			{
				cardNumber= currentrow.getCell(2).getStringCellValue();
				System.out.println(cardNumber);
			//	cvv =String.valueOf(currentrow.getCell(4).getNumericCellValue());
				cvv = currentrow.getCell(4).getStringCellValue();
				System.out.println(cvv);
				expiry = currentrow.getCell(3).getStringCellValue();
				System.out.println(expiry);
			}
		}
		workbook.close();
		fis.close();
	}
	
}