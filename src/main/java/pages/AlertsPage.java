package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    private WebDriver driver;

    // Locator for the alert button
    private By alertButton = By.id("alertButton");
    private By mouseHoverButton = By.id("mouseHoverButton");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    
    }

    // Trigger and accept alert
    public void triggerAndAcceptAlert() {
        WebElement alertButtonElement = driver.findElement(alertButton);
        alertButtonElement.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Perform mouse hover action
    public void mouseHover() {
        WebElement element = driver.findElement(mouseHoverButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
