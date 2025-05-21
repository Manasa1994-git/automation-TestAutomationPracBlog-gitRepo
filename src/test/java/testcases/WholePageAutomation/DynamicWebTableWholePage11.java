package testcases.WholePageAutomation;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWholePage11 {

	
		private static final Logger logger = LogManager.getLogger(DynamicWebTableWholePage11.class);
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://testautomationpractice.blogspot.com/");
			
		
		driver.manage().window().maximize();
		
		
		List<WebElement> listOfRows=driver.findElements(By.xpath("//table[@id=\"taskTable\"]/tbody/tr"));
		List<WebElement> listOfCols=driver.findElements(By.xpath("//table[@id=\"taskTable\"]/thead/tr/th"));
		
		int rowCount=listOfRows.size();
		int colCount=listOfCols.size();
		
		logger.info("print all the data of a table");
		
		for(WebElement header:listOfCols) {
			System.out.print(header.getText()+"|  ");
		}
		System.out.println();
		
		for(int i=2;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				String readVal=driver.findElement(By.xpath("//table[@id=\"taskTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(readVal+"|  ");
			}
			System.out.println();
		}
		
		
		logger.info("Write 2D array data into Excel");
		
		String[][] dataTable=new String[rowCount][colCount];
		
		
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				String readVal=driver.findElement(By.xpath("//table[@id=\"taskTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				dataTable[i-1][j-1]=readVal;
				System.out.print(dataTable[i-1][j-1]+"|  ");
				
			}
			System.out.println();
		}
		
		utilities.WriteExcelUtil.write2DArrayToExcelUtil(dataTable,"/Users/Manasa/Documents/newFile.xlsx","Dynamicdata");
		
		
		
		driver.quit();
		
		

	}

}
