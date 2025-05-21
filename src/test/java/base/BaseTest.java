package base;

import config.ConfigReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.DriverFactory;
import utilities.ExtentReportManager;
import utilities.LoggerUtil;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    // ThreadLocal to hold WebDriver instances for thread safety in parallel execution
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    // List to keep track of all driver instances to quit them in AfterSuite
    private static final List<WebDriver> allDrivers = new ArrayList<>();

    protected ConfigReader config;
    protected Logger log = LoggerUtil.getLogger(BaseTest.class);

    // Getter for the current thread's WebDriver instance
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("") String browser, Method method) {
        log.info("=== Starting test setup ===");

        config = new ConfigReader();

        if (browser.isEmpty()) {
            browser = config.getBrowser();
            log.info("Browser not passed from XML. Using from config.properties: " + browser);
        } else {
            log.info("Browser received from XML: " + browser);
        }

        // Create a new WebDriver instance based on the browser parameter
        WebDriver localDriver = DriverFactory.createDriver(browser);

        // Setup driver settings
        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));
        localDriver.get(config.getBaseUrl());
        log.info("Navigated to " + config.getBaseUrl());

        // Store driver instance in ThreadLocal for thread safety
        threadDriver.set(localDriver);

        // Add to list of all drivers in thread-safe manner for cleanup after suite
        synchronized (allDrivers) {
            allDrivers.add(localDriver);
        }

        // Initialize ExtentReports and create a test instance for reporting
        ExtentReportManager.getReporterInstance();
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();

        // Log test result to Extent report
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());

            // Capture and add screenshot on failure
            ExtentReportManager.addScreenshot(getDriver(), result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        }

        log.info("=== Flushing Extent report ===");
        ExtentReportManager.flushReport();

        // Quit the WebDriver instance for this test
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            log.info("Closed browser for test: " + result.getName());
        }

        // Remove the WebDriver instance from ThreadLocal to avoid memory leaks
        threadDriver.remove();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        log.info("=== Suite complete. Closing all remaining drivers ===");

        // Close all drivers that might not have been closed properly
        synchronized (allDrivers) {
            for (WebDriver driver : allDrivers) {
                try {
                    if (driver != null) {
                        driver.quit();
                        log.info("Closed browser");
                    }
                } catch (Exception e) {
                    log.error("Error during driver quit: " + e.getMessage());
                }
            }
            allDrivers.clear();
        }

        // Clear ThreadLocal just in case
        threadDriver.remove();

        log.info("Opening final Extent report");
        ExtentReportManager.openReport();
    }
}
