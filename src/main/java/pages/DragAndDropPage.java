package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

    private WebDriver driver;

    // Locators for draggable and drop target
    private By dragElement = By.id("dragElement");
    private By dropTarget = By.id("dropTarget");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Perform drag and drop action
    public void dragAndDrop() {
        WebElement from = driver.findElement(dragElement);
        WebElement to = driver.findElement(dropTarget);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).perform();
    }
}
