package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class SortedListPage {

    private WebDriver driver;

    // Locator for the sorted list
    private By sortedListItems = By.xpath("//ul[@id='sortable']/li");

    public SortedListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get the list items
    public List<WebElement> getSortedListItems() {
        return driver.findElements(sortedListItems);
    }

    // Get the text of the sorted list items
    public List<String> getSortedListText() {
        return getSortedListItems().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
