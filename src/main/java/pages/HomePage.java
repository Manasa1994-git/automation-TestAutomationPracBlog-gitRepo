package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;  // Declared private for encapsulation

    public HomePage(WebDriver driver) {
        this.driver = driver;  // Using the WebDriver instance passed from the BaseTest class
    }

    // Locator for the "Click Me" button (alert button in your case)
    private By alertButton = By.xpath("//button[contains(text(),'Click Me')]");

    // Method to click on the alert button
    public void clickAlertButton() {
        driver.findElement(alertButton).click();  // Click the alert button
    }

    // Optional: Add more methods for interacting with other elements on the HomePage
}
