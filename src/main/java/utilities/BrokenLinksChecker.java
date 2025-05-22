package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksChecker {

    private static final Logger logger = LogManager.getLogger(BrokenLinksChecker.class);

    // Check all links on the page and log their status
    public static void checkAllLinks(WebDriver driver) {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        logger.info("Total links found on page: " + allLinks.size());

        for (WebElement linkElement : allLinks) {
            String url = linkElement.getAttribute("href");

            // Skip if href is empty or null
            if (url == null || url.isEmpty()) {
                logger.warn("Skipped empty or null href.");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    logger.error("Broken link: " + url + " | Status Code: " + responseCode);
                } else {
                    logger.info("Valid link: " + url + " | Status Code: " + responseCode);
                }

            } catch (IOException e) {
                logger.error("Exception while checking link: " + url, e);
            }
        }
    }

    // Check if a single link is valid (returns true if status code < 400)
    public static boolean isLinkValid(String url) {
        if (url == null || url.isEmpty()) {
            logger.warn("URL is null or empty");
            return false;
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                logger.error("Broken link: " + url + " | Status Code: " + responseCode);
                return false;
            } else {
                logger.info("Valid link: " + url + " | Status Code: " + responseCode);
                return true;
            }
        } catch (IOException e) {
            logger.error("Exception while checking link: " + url, e);
            return false;
        }
    }
}
