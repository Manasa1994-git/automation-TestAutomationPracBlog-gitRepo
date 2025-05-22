package pages.WholePageAutomation;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtil;

public class SliderPage {

	private static final Logger logger = LogManager.getLogger(SliderPage.class);
	
	private WebDriver driver;
	
	public SliderPage(WebDriver driver){
		this.driver = driver;
	}
	
	// Locators for slider handles and amount display
	private By sliderTrack = By.id("slider-range");
	private By sliderHandle1 = By.xpath("//div[@id='slider-range']/span[1]");
	private By sliderHandle2 = By.xpath("//div[@id='slider-range']/span[2]");
	private By amount = By.id("amount");
	
	public void moveSlider() {
		WebElement handle1 = driver.findElement(sliderHandle1);
		WebElement handle2 = driver.findElement(sliderHandle2);
		WebElement track = driver.findElement(sliderTrack);
		
		Actions action = new Actions(driver);

		// Get width of the slider track
		int trackWidth = track.getSize().getWidth();
		logger.info("Slider track width: " + trackWidth);

		// Estimate offset (adjust these values after trial for your specific needs)
		// Example: move handle1 right by 30% of the slider width
		int offsetHandle1 = (int)(trackWidth * 0.30);  // Move 30% to the right
		int offsetHandle2 = (int)(trackWidth * -0.05); // Move 5% to the left

		logger.info("Moving handle1 by offset: " + offsetHandle1);
		action.clickAndHold(handle1).moveByOffset(offsetHandle1, 0).release().perform();

		logger.info("Moving handle2 by offset: " + offsetHandle2);
		action.clickAndHold(handle2).moveByOffset(offsetHandle2, 0).release().perform();
	}
	
	public String getPriceAmount() {
		 
		    
		    WebElement priceElement = WaitUtil.waitForElementToBeVisible(driver, amount);
		    
		    String priceAmount = driver.findElement(amount).getAttribute("value");
		    
		logger.info("Current Price Range:"+priceAmount);
		return priceAmount;
	}
}
