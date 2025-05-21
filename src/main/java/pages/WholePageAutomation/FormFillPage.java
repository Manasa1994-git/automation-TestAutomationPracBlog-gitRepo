package pages.WholePageAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.WaitUtil;

public class FormFillPage {
	private static final Logger logger = LogManager.getLogger(FormFillPage.class);
	private WebDriver driver;
	
	public FormFillPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By nameField=By.id("name");
	private By emailField=By.id("email");
	private By phoneField=By.id("phone");
	private By addressField=By.id("textarea");
	
	
	
	public void formFilling(String name,String email,String phone,String address) {
		WebElement nameElem= WaitUtil.waitForElementToBeVisible(driver, nameField);
		WebElement emailElem= driver.findElement(emailField);
		WebElement phoneElem= driver.findElement(phoneField);
		WebElement addressElem= driver.findElement(addressField);
		 logger.info("page Class:filling the fields in the page");
		nameElem.sendKeys(name);
		emailElem.sendKeys(email);
		phoneElem.sendKeys(phone);
		addressElem.sendKeys(address);
		 logger.info("Page class:Completed filling the forms");
		
		
	}
	public String getname() {
		
		String nameVal=driver.findElement(nameField).getAttribute("value");
		return nameVal;
		
		
	}

}
