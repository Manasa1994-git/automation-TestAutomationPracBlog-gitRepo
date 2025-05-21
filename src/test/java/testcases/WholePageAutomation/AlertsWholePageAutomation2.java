package testcases.WholePageAutomation;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertsWholePageAutomation2 {
	private static final Logger logger = LogManager.getLogger(AlertsWholePageAutomation2.class);
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String title=driver.getTitle();
		
	logger.info(title);
	
	//ALERTS & POPUPS
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement elem1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Alerts & Popups']")));

	
	// Handling a simple Alert
    WebElement simpleAlert=driver.findElement(By.id("alertBtn"));
    simpleAlert.click();
    
    Alert alert1=driver.switchTo().alert();
    System.out.println(alert1.getText());
    alert1.accept();
    
  //Handling a Confirmation Alert
       //a) accepting 
    
    WebElement confirmAlert=driver.findElement(By.id("confirmBtn"));
    confirmAlert.click();
    Alert alert2=driver.switchTo().alert();
    System.out.println(alert2.getText());
    alert2.accept();
    
     //b) dismiss the alert
    confirmAlert.click();
   driver.switchTo().alert();
   System.out.println(alert2.getText());
   
    alert2.dismiss();
    
    
       
  //Handling a prompt Alert
    
   WebElement promptAlert=driver.findElement(By.id("promptBtn"));
   promptAlert.click();
   Alert alert3=driver.switchTo().alert();
  System.out.println("question in prompt alert: "+alert3.getText());
  
  alert3.sendKeys("HarryHermoine");
  alert3.accept();
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello HarryHermoine! How are you today?']")));
  
  logger.info("Hello HarryHermoine! How are you today?");
   
    
	//this is to count no of frames on a page
  List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	System.out.println("Number of iframes: " + frames.size());
	
	driver.quit();
	
	
		
		
		
				
	}

}
