package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPage {

    private WebDriver driver;

    // Locator for the date picker
    private By datePickerField = By.id("datepicker");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Set a date in the date picker
    public void setDate(String date) {
        WebElement dateField = driver.findElement(datePickerField);
        dateField.clear();
        dateField.sendKeys(date);
    }
}
