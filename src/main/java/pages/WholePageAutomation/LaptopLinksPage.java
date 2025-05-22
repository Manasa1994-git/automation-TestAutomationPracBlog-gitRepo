package pages.WholePageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrokenLinksChecker;

import java.util.HashMap;
import java.util.Map;

public class LaptopLinksPage {

    private WebDriver driver;

    public LaptopLinksPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the three laptop links (update locators if needed)
    private By appleLink = By.linkText("Apple");
    private By lenovoLink = By.linkText("Lenovo");
    private By dellLink = By.linkText("Dell");

    // Return Map of link names and their locators
    public Map<String, By> getLaptopLinks() {
        Map<String, By> linksMap = new HashMap<>();
        linksMap.put("Apple", appleLink);
        linksMap.put("Lenovo", lenovoLink);
        linksMap.put("Dell", dellLink);
        return linksMap;
    }

    // Get href URL for a given link name
    public String getLinkUrl(String linkName) {
        By locator = getLaptopLinks().get(linkName);
        if (locator == null) return null;
        WebElement linkElement = driver.findElement(locator);
        return linkElement.getAttribute("href");
    }

    // Check if link is valid (using utility method)
    public boolean isLinkValid(String linkName) {
        String url = getLinkUrl(linkName);
        return BrokenLinksChecker.isLinkValid(url);
    }

    // Click link by name and return the page title after navigation
    public String clickLinkAndGetTitle(String linkName) {
        By locator = getLaptopLinks().get(linkName);
        if (locator == null) return null;
        driver.findElement(locator).click();

        // Wait a bit for page load - ideally explicit wait can be used here
        try {
            Thread.sleep(2000); // simple wait, replace with WebDriverWait if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    // Navigate back to previous page
    public void navigateBack() {
        driver.navigate().back();

        try {
            Thread.sleep(1500);  // simple wait for page to load after back
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
