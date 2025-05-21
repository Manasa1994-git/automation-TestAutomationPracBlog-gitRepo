package pages.WholePageAutomation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtil;

//I have mentioned ianother way in comments after this: please check as even after selecting item 50 
// from dropdown, DOM is not updating with Item 50 value. o manually updating
//using js.executeScript("arguments[0].value = arguments[1];", driver.findElement(scrollLoc), "Item 50");
//you can directly us secod in comments, but for understanding in future 
//i have written this

public class ScrollingDropDownPage {
	private static final Logger logger = LogManager.getLogger(ScrollingDropDownPage.class);

	private WebDriver driver;

	public ScrollingDropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	private By scrollLoc = By.id("comboBox");
	private By dropdownlistLoc = By.xpath("//div[@id='dropdown']/div[@class='option']");

	private String selectedItemvalue = "";

	public void scrollDropdownList() {
		logger.info("Scroll Page class: assigning item value to the dropdown");
		driver.findElement(scrollLoc).click();

		// Use JavaScript to scroll into view
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> itemList = driver.findElements(dropdownlistLoc);

		for (WebElement item : itemList) {
			if (item.getText().trim().equals("Item 50")) {
				js.executeScript("arguments[0].scrollIntoView(true);", item);
				WaitUtil.waitForElementToBeClickable(driver, item);
				item.click();
				js.executeScript("arguments[0].value = arguments[1];", driver.findElement(scrollLoc), "Item 50");

	            break;
			}
	}
	}

	public String getItemValue() {
		String displayedText = driver.findElement(scrollLoc).getAttribute("value").trim();
	    logger.info("Displayed selected item text: " + displayedText);
	    return displayedText;
	}
}



/*
 * package pages.WholePageAutomation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtil;

public class ScrollingDropDownPage {
	private static final Logger logger = LogManager.getLogger(ScrollingDropDownPage.class);

	private WebDriver driver;

	public ScrollingDropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	private By scrollLoc = By.id("comboBox");
	private By dropdownlistLoc = By.xpath("//div[@id='dropdown']/div[@class='option']");

	private String selectedItemvalue = "";

	public void scrollDropdownList() {
		logger.info("Scroll Page class: assigning item value to the dropdown");
		driver.findElement(scrollLoc).click();

		// Use JavaScript to scroll into view
		JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].value = arguments[1];", driver.findElement(scrollLoc), "Item 50");

	          
	}
	}

	public String getItemValue() {
		String displayedText = driver.findElement(scrollLoc).getAttribute("value").trim();
	    logger.info("Displayed selected item text: " + displayedText);
	    return displayedText;
	}
}





       
	


 */



       
	

