package testcases.WholePageAutomation;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DoubleClickWholePageAutomation5 {
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://testautomationpractice.blogspot.com/");
	        
	        
	        //Double click and see if field1 value is copied in field2
	        WebElement doubleClickelem=driver.findElement(By.xpath("//button[text()='Copy Text']"));
	        Actions actions=new Actions(driver);
	        actions.doubleClick(doubleClickelem).perform();
	        
	        
	        WebElement fieldCopied=driver.findElement(By.id("field2"));
	        
	        String valueofield2=fieldCopied.getAttribute("value");
	        Assert.assertEquals(valueofield2, "Hello World!","Field1 value is not copied in field2");
	        
	        
	        
	}

}
