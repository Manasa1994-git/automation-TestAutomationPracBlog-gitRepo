package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.HomePage;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtil;

public class HomePageTest extends BaseTest {

    @Test
    public void testAlertButtonClick() {
        try {
            ExtentReportManager.createTest("HomePage Test");
            ExtentReportManager.getTest().log(Status.INFO, "Navigating to the Home Page.");

            HomePage home = new HomePage(getDriver()); // Use driver from BaseTest
            home.clickAlertButton();
            getDriver().switchTo().alert().accept();

            ExtentReportManager.getTest().log(Status.PASS, "Alert Button clicked and alert accepted successfully.");
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(getDriver(), "testAlertButtonClick");
            ExtentReportManager.getTest().log(Status.FAIL, "Test failed due to: " + e.getMessage());
            ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
        }
    }
}
