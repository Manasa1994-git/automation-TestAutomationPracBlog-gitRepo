package testcases.WholePageAutomation;

import java.time.Duration;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowOrTabWholePageAutomation3 {

    private static final Logger logger = LogManager.getLogger(WindowOrTabWholePageAutomation3.class);

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        
        logger.info("New Tab-  windows handling");
        String parentWindow = driver.getWindowHandle();

        // Window Handle logic
        driver.findElement(By.xpath("//button[text()='New Tab']")).click();

        

        Set<String> allWindows1 = driver.getWindowHandles();

        // Switch to the new tab/window
        for (String window : allWindows1) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Software Testing & Automation Tutorials')]")));

        wait.until(ExpectedConditions.titleContains("SDET-QA Blog"));
        // Print the title of the new tab
        System.out.println("Title of new tab: " + driver.getTitle());
        driver.close();

        // Switch back to the parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Title of parent: " + driver.getTitle());
        
        
        logger.info("Popup Windows - Window handling");
        //popupwindow handling
        
        driver.findElement(By.id("PopUp")).click();
        Set<String> allWindows2=driver.getWindowHandles();
        System.out.println("Popup windows button: Total windows opened: "+allWindows2.size());
        int i=0;
        
        for(String window:allWindows2) {
        	if(!window.equals(parentWindow)) {
        		driver.switchTo().window(window);
        		
        	        System.out.println("Title of popup window : " +i+" window:"+ driver.getTitle());
        		driver.close();
        		i++;
        	}
        }
        
     
        driver.switchTo().window(parentWindow);
        System.out.println("Title of parent: " + driver.getTitle());
        
        
        driver.quit();
    }
}


//if you want to switch to particular window

/*
 * 
 * if (driver.getTitle().contains("Selenium - Wikipedia")) {
        // Found the window you wanted
        break;
    }
    
    or
     if (driver.getCurrentUrl().contains("selenium.dev")) {
        break; // This is the desired window
    }
    or (didnt understand below, need to check next time
    List<WebElement> elements = driver.findElements(By.id("some-unique-id"));
    if (!elements.isEmpty()) {
        break; // This window contains the unique element
    }
    */
