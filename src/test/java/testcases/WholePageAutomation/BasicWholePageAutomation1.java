package testcases.WholePageAutomation;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pages.WholePageAutomation.FormFillPage;



public class BasicWholePageAutomation1 {
	private static final Logger logger = LogManager.getLogger(BasicWholePageAutomation1.class); //you can put this in basetest using protected keyword and use in classes , as thi is independent class, iam using

	
	public static void main(String args[]) {
		 System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.id("female")).click();
        
        driver.findElement(By.id("sunday")).click();
        driver.findElement(By.id("wednesday")).click();
        driver.findElement(By.id("saturday")).click();
        
        
        //select single option in dropdown
       WebElement countryDropdown=driver.findElement(By.id("country"));
      Select selectCountry=new Select(countryDropdown);
      //select.selectByValue("germany");
      //select.selectByIndex(1);
      selectCountry.selectByVisibleText("United Kingdom");
      
      
      //select multiple options in drop down
      WebElement colorDropdown =driver.findElement(By.id("colors"));
    	        
      Select selectColor=new Select(colorDropdown);
      selectColor.selectByVisibleText("White");
      selectColor.selectByVisibleText("Green");
      selectColor.selectByVisibleText("Red");
      selectColor.selectByVisibleText("Blue");
     
      
      //deselect Red,Blue options from colorDropdown
      selectColor.deselectByVisibleText("Red");
      selectColor.deselectByVisibleText("Blue");
      
     //
      
      //Get all the options of 'Sorted List' in dropdown 
      WebElement animalList=driver.findElement(By.id("animals"));
      Select mulAnimals=new Select(animalList);
      List<WebElement> animals=mulAnimals.getOptions();
      
      ArrayList<String> arrayAnimals1=new ArrayList<>();
      
      for(WebElement animal:animals) {
    	  System.out.println(animal.getText());
    	  arrayAnimals1.add(animal.getText().trim());
    	  
      }
     // check if 'Sorted List' is sorted 
      
      ArrayList<String> arrayAnimals2=new ArrayList<>(arrayAnimals1);
      Collections.sort(arrayAnimals2);
      if(arrayAnimals1.equals(arrayAnimals2)) {
    	  System.out.println("Animals are sorted");
      }
      else {
    	  System.out.println("Animals are not sorted");
      }
      
      //datepicker1
      
     driver.findElement(By.id("datepicker")).click();
     
      driver.findElement(By.xpath("//a[text()='15']")).click();
      
      //can do both ways
      //driver.findElement(By.id("datepicker")).sendKeys("17/05/2025");
      
      //datepicker2 is read only cannot send date in the field
      driver.findElement(By.name("SelectedDate")).click();
      driver.findElement(By.xpath("//a[@data-date='21']")).click();
      driver.findElement(By.xpath("//input[@id='start-date']")).click();
      
      //datepicker3: here is no calendar popup HTML at all behind Date Picker #3 and
      //For type="date", browsers expect YYYY-MM-DD(eventhough it shows dd/mm/yyyy, you only should give format YYYY-MM-DD
      //,selenium interactions like sendkeys() dont work, only 
      //JavascriptExecutor works for this
     
       WebElement dateInput1 = driver.findElement(By.id("start-date"));
       WebElement dateInput2 = driver.findElement(By.id("end-date"));

      // Desired date in correct format for input[type="date"]
      String formattedDate1 = "2025-06-13"; // YYYY-MM-DD
      String formattedDate2 = "2025-07-21"; 

      // Set the value using JavaScriptExecutor
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].value = arguments[1];", dateInput1, formattedDate1);
      js.executeScript("arguments[0].value = arguments[1]", dateInput2,formattedDate2);
      
      
   driver.findElement(By.xpath("//button[@class='submit-btn']")).click();
   
   
   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
  WebElement elemwaitforTextCal= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'selected a range')]")));
  
  if(elemwaitforTextCal.isDisplayed()) {
	  logger.info("Date is picked in the range");
  }
  else {
	  logger.error("End date must be after start date.");
  }
     
  

      
        driver.quit();
        
        
        
	}
		

	}


