package testcases.WholePageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragandDropWholePageAutn6 {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();
        
        WebElement source=driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement destination=driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source, destination).perform();
        
        //this is manual way for JS heavy scripts
        //actions.clickAndHold(source).moveToElement(destination).release().build().perform();
         
        
        //dropped! message after dropping into the target
        WebElement droppedTextElem=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(droppedTextElem.isDisplayed(), "Dropped text not displayed ");
        
        driver.quit();
        
	}

}
