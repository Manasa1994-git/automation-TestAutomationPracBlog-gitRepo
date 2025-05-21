package testcases.WholePageAutomation;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WholePageAutomation.LaptopLinksPage;

import java.util.Map;

public class LaptopLinksTest extends BaseTest {

    @Test(description = "Check laptop brand links are not broken, then click and verify page title")
    public void testLaptopLinks() throws InterruptedException {
        LaptopLinksPage laptopLinksPage = new LaptopLinksPage(getDriver());

        // Get map of laptop links (name -> locator)
        Map<String, ?> laptopLinks = laptopLinksPage.getLaptopLinks();

        for (String linkName : laptopLinks.keySet()) {
            // Check if link is valid
            if (laptopLinksPage.isLinkValid(linkName)) {
                // Click the link and get the page title
                String pageTitle = laptopLinksPage.clickLinkAndGetTitle(linkName);
                log.info("Clicked link: " + linkName + ", Page title: " + pageTitle);

                // Assert that title is not empty
                Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty for link: " + linkName);

                // Navigate back to the main page
                laptopLinksPage.navigateBack();

                // Optional wait after back navigation
                Thread.sleep(1000);
            } else {
                log.warn("Skipping broken link: (Note:small change to see github build trigger)" + linkName);
            }
        }
    }
}
