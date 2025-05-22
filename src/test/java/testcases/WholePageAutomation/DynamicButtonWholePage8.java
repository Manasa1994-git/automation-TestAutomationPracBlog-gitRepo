package testcases.WholePageAutomation;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicButtonWholePage8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(),"Automation Testing Practice", "Title is not correct");
		
		//Dynamic Button Automation
		
		WebElement dynamicButtonStart=driver.findElement(By.xpath("//button[@name='start']"));
		
		dynamicButtonStart.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='stop']")));
		
		
		
		
		WebElement dynamicButtonStop=driver.findElement(By.xpath("//button[@name='stop']"));
		
		String buttonTextStop=dynamicButtonStop.getText();
		Assert.assertEquals(buttonTextStop, "STOP", "Button text did not change to Stop");
		
				
		dynamicButtonStop.click();
		
		String buttonTextStart=dynamicButtonStop.getText();
		Assert.assertEquals(buttonTextStart, "START", "Button text did not change to START");
		
		
		driver.quit();

	}

}
