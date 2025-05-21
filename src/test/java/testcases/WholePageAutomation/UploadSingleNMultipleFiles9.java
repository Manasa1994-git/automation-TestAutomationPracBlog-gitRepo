package testcases.WholePageAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

public class UploadSingleNMultipleFiles9 {
	private static final Logger logger = LogManager.getLogger(AlertsWholePageAutomation2.class);

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		logger.info("Uploading Single File");
		
		WebElement singlefileUpload=driver.findElement(By.id("singleFileInput"));
		singlefileUpload.sendKeys("/Users/Manasa/Documents/ExcelTestData.xlsx");
		
		WebElement uploadSingleButton=driver.findElement(By.xpath("//button[text()='Upload Single File']"));
		uploadSingleButton.click();
		
		String singleStatus=driver.findElement(By.id("singleFileStatus")).getText();
		
		Assert.assertTrue(singleStatus.contains("ExcelTestData.xlsx"),"File name not found in upload status");
		
		logger.info("Uploading Multiple Files");
		
		WebElement multipleFileUpload=driver.findElement(By.id("multipleFilesInput"));
		
		String file1="/Users/Manasa/Documents/ExcelTestData.xlsx";
		String file2="/Users/Manasa/Documents/employee.sql";
		
		String multipleFiles=file1+"\n"+file2;
		
		multipleFileUpload.sendKeys(multipleFiles);
		
		WebElement uploadMultipleButton=driver.findElement(By.xpath("//button[text()='Upload Multiple Files']"));
		uploadMultipleButton.click();
		
		String multipleStatus=driver.findElement(By.id("multipleFilesStatus")).getText();
		Assert.assertTrue(multipleStatus.contains("employee.sql"),"file not found in upload status");
		Assert.assertTrue(multipleStatus.contains("ExcelTestData.xlsx"),"file not found in upload status");
		
		/*can use asserttrue statement in both below ways too
		 * Assert.assertTrue(
    multipleStatus.contains("employee.sql") && multipleStatus.contains("ExcelTestData.xlsx"),
    "One or both files not found in upload status"
);
		 */
		
		//or
		/*
		 * boolean hasFile1 = multipleStatus.contains("employee.sql");
boolean hasFile2 = multipleStatus.contains("ExcelTestData.xlsx");

Assert.assertTrue(hasFile1 && hasFile2, 
    "Missing file(s): " + 
    (!hasFile1 ? "employee.sql " : "") + 
    (!hasFile2 ? "ExcelTestData.xlsx" : "")
);
		 */
	
		driver.quit();
		
		
		
		

	}

}
