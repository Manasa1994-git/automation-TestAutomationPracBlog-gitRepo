package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ColorsPage {

    private WebDriver driver;
    

    // Locator for the multi-select dropdown (Colors)
    @FindBy(id = "colors") // Make sure the locator matches your HTML
    private WebElement colorDropdown;

    // Constructor to initialize WebElements
    public ColorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    /**
     * Selects multiple colors from the dropdown by visible text
     * @param colorNames one or more colors to be selected
     */
    public void selectColors(String... colorNames) {
        Select select = new Select(colorDropdown); // Create a Select object to interact with the dropdown
        for (String color : colorNames) {
            select.selectByVisibleText(color); // Select each color by visible text
        }
    }

    /**
     * Deselects all selected colors
     */
    public void deselectAllColors() {
        Select select = new Select(colorDropdown); // Interact with the dropdown
        select.deselectAll(); // Deselect all selected colors
    }

    /**
     * Get a list of all selected color options
     * @return List of selected options
     */
    public List<WebElement> getSelectedColors() {
        Select select = new Select(colorDropdown); // Interact with the dropdown
        return select.getAllSelectedOptions(); // Return a list of selected color options
    }
}
