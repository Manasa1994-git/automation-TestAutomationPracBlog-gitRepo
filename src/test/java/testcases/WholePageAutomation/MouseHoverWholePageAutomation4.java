package testcases.WholePageAutomation;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

public class MouseHoverWholePageAutomation4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//Mouse Hover drop down button 
		
		WebElement dropbutton=driver.findElement(By.className("dropbtn"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(dropbutton).perform();
		
		
		 //options are displayed
		WebElement dropOptions=driver.findElement(By.xpath("//*[text()='Mobiles']"));
		actions.moveToElement(dropOptions).click().perform();
	
		
		
		driver.quit();
		
		
		

	}

}
