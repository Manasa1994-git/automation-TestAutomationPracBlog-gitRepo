package testcases.WholePageAutomation;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class TabsWikipediaWholePageAuto7 {

	 private static final Logger logger = LogManager.getLogger(WindowOrTabWholePageAutomation3.class);

	    public static void main(String[] args) {

	        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://testautomationpractice.blogspot.com/");
	        
	        logger.info("Wikipedia icon click");
	        
	        String parentWindow=driver.getWindowHandle();
	        
	        WebElement wikiIconElem=driver.findElement(By.xpath("//*[@class='wikipedia-icon']"));
	        wikiIconElem.click();
	        
	        
	      
	        
	        Set<String> allWindowsWithWiki=driver.getWindowHandles();
	        
	        for(String window:allWindowsWithWiki) {
	        	if(!window.equals(parentWindow)) {
	        		driver.switchTo().window(window);
	        		break;
	        	}
	        }
	        
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	        
	       wait.until(ExpectedConditions.titleContains("Wikipedia, the free encyclopedia")); 
	        driver.close();
	         
	        
	         driver.switchTo().window(parentWindow);
		        //wait.until(ExpectedConditions.titleContains("Automation Testing Practice"));
		       Assert.assertEquals(driver.getTitle(),"Automation Testing Practice", "page title did not match");
		       
		       
		       logger.info("Wikipedia-Search field");
		       
		       driver.findElement(By.className("wikipedia-search-input")).sendKeys("Selenium");
		       driver.findElement(By.className("wikipedia-search-button")).click();
		       
		       
		     //"wikipedia-search-results"
		       
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wikipedia-search-results']/div"))); 
		       
		     List<WebElement> wikiSearchResults=driver.findElements(By.xpath("//div[@class='wikipedia-search-results']/div"));
		     
		     int countRes=wikiSearchResults.size();
		     System.out.println("Results count: "+countRes);
		     
		     for(WebElement result:wikiSearchResults) {
		    	 System.out.println(result.getText());
		    	 
		     }
		     
		     WebElement seleniumLink=driver.findElement(By.xpath("//div[@class='wikipedia-search-results']//a[text()='Selenium']"));
		     
		   
		     
		     seleniumLink.click();
		      
		     
		     logger.info("opening the Selenium tab from search results");
		     
		     Set<String> allWindowsWithSel=driver.getWindowHandles();
		     
		     for(String window:allWindowsWithSel) {
		        	if(!window.equals(parentWindow)) {
		        		driver.switchTo().window(window);
		        		break;
		        	}
		        }
		     
		     
		       wait.until(ExpectedConditions.titleContains("Selenium - Wikipedia"));  
		     driver.close();
		     
		     driver.switchTo().window(parentWindow);
		     Assert.assertEquals(driver.getTitle(),"Automation Testing Practice", "page title did not match");
		     
		     
		     
		     
		       
		        
	       driver.quit();

	}

}
