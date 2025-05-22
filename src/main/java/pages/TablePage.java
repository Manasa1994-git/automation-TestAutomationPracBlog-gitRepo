package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TablePage {

    private WebDriver driver;

    // Locator for the table rows (assuming it's a static table)
    private By tableRows = By.xpath("//table[@id='table_id']/tbody/tr");

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get all table rows
    public List<WebElement> getTableRows() {
        return driver.findElements(tableRows);
    }
}
