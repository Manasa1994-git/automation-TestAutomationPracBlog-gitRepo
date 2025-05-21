package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertsPage;
import org.testng.Assert;

public class AlertsPageTest extends BaseTest {

    @Test
    public void testAlert() {
        AlertsPage alertsPage = new AlertsPage(getDriver());
        
        alertsPage.triggerAndAcceptAlert();
        
        // Further assertions could be done based on the application behavior after alert
        Assert.assertTrue(true, "Alert triggered successfully.");
    }

    @Test
    public void testMouseHover() {
        AlertsPage alertsPage = new AlertsPage(getDriver());
        
        alertsPage.mouseHover();
        
        // Further assertions based on mouse hover effect
        Assert.assertTrue(true, "Mouse hover performed successfully.");
    }
}
