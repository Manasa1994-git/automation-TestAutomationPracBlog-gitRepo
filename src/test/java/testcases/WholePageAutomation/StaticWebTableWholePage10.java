package testcases.WholePageAutomation;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StaticWebTableWholePage10 {
	private static final Logger logger = LogManager.getLogger(StaticWebTableWholePage10.class);

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String title=driver.getTitle();
		
	logger.info(title);
	
	//Static web table
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@name='BookTable']")));
	
	WebElement staticTable=driver.findElement(By.xpath("//table[@name='BookTable']"));
	
	List<WebElement> listOfRows=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
	
	List<WebElement> listOfCols=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
	
	
	
	int rowCount=listOfRows.size();
	int colCount=listOfCols.size();
	
	//first row is header ,so starting from 2nd
	
	logger.info("static web table");
	
	logger.info("print all data from table");
     List<WebElement> headerNames=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
	
	logger.info("printing Header names");
	
	for(WebElement header:headerNames) {
		System.out.print(header.getText()+"|   ");
	}
	
	for(int i=2;i<=rowCount;i++) {
		
		for(int j=1;j<=colCount;j++) {
			WebElement readCellElem=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]"));
			String val=readCellElem.getText();
			System.out.print(val+"|  ");
			
		}
		System.out.println();
	}
	
	logger.info("Extract books written by Author:Mukesh");
	
	for(int i=2;i<=rowCount;i++) {
			
			WebElement readCellElem=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[2]"));
			String val=readCellElem.getText();
			
			if(val.equals("Mukesh")) {
				WebElement readCellElem1=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[1]"));
				
				String authBookName=readCellElem1.getText();
				System.out.println("Book by Mukesh: "+authBookName);
				
			}
		}
	
	logger.info("Validate Specific Cell Data Using Assert-find if price of 'Master In Selenium' is 3000");
	
	for(int i=2;i<=rowCount;i++) {
		
		WebElement readCellElem=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[1]"));
		String val=readCellElem.getText();

		if(val.equals("Master In Selenium")) {
			WebElement readCellElem1=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[4]"));	
			String priceOfBook=readCellElem1.getText();
			Assert.assertEquals(priceOfBook,"3000","The price of 'Master In Selenium' is not 3000");
			
			
		}
	}
	
	logger.info("Count how many books are of a specific subject");
	int count=0;
	
	for(int i=2;i<=rowCount;i++) {
		WebElement readCellElem=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[3]"));
		String val=readCellElem.getText();
		if(val.equalsIgnoreCase("Selenium")) {
			count++;
		}
	}
	System.out.println("Count of books that is specific to Selenium is "+count);
	
	driver.quit();

	}

}
