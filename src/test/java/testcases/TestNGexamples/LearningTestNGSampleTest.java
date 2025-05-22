package testcases.TestNGexamples;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.Reporter;

public class LearningTestNGSampleTest {

    // 1) @BeforeSuite - Runs once before entire suite
    @BeforeSuite
    public void beforeSuite() {
        Reporter.log("Before Suite: Setup DB connection or report config", true);
    }

    // 2) @BeforeTest - Runs before <test> in testng XML
    @BeforeTest
    public void beforeTest() {
        Reporter.log("Before Test: Launch browser", true);
    }

    // 3) @BeforeClass - Runs before first @Test in the class
    @BeforeClass
    public void beforeClass() {
        Reporter.log("Before Class: Login or test-level setup", true);
    }

    // 4) @BeforeMethod - Runs before each @Test method
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Before Method: Navigate to base URL or reset test state", true);
    }

    // 5) Basic Test
    @Test
    public void testBasic() {
        Reporter.log("Running Basic Test", true);
        Assert.assertTrue(true);
    }

    // 6) Priority, DependsOn, and Groups
    @Test(priority = 1, groups = {"smoke"})
    public void loginTest() {
        Reporter.log("Login Test", true);
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = "loginTest", groups = {"smoke", "regression"})
    public void dashboardTest() {
        Reporter.log("Dashboard Test - depends on loginTest", true);
        Assert.assertEquals("Dashboard", "Dashboard");
    }

    // 7) DataProvider example
    @Test(dataProvider = "loginData")
    public void loginWithMultipleUsers(String username, String password) {
        Reporter.log("Testing login with user: " + username, true);
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"}
        };
    }

    // 8) Parameter from testng.xml
    @Test
    @Parameters({"browser"})
    public void browserTest(String browserName) {
        Reporter.log("Browser received from testng.xml: " + browserName, true);
        Assert.assertNotNull(browserName);
    }

    // 9) SoftAssert Example
    @Test
    public void softAssertExample() {
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        Reporter.log("SoftAssert Example Test", true);
        softAssert.assertEquals("Hello", "hello", "Case mismatch");
        softAssert.assertTrue(false, "Expected condition failed");
        softAssert.assertAll(); // Required to collect all failures
    }

    // 10) Skipping a test
    @Test(enabled = true)
    public void skippedTest() {
        Reporter.log("This test will be skipped manually", true);
        throw new SkipException("Skipping this test intentionally.");
    }

    // 11) AlwaysRun example
    @Test(alwaysRun = true)
    public void alwaysRunExample() {
        Reporter.log("This test always runs even if dependent methods fail", true);
        Assert.assertTrue(true);
    }

    // 12) @AfterMethod - Runs after each test
    @AfterMethod
    public void afterMethod() {
        Reporter.log("After Method: Logout or cleanup", true);
    }

    // 13) @AfterClass - Runs after all test methods in the class
    @AfterClass
    public void afterClass() {
        Reporter.log("After Class: Close browser or session", true);
    }

    // 14) @AfterTest - Runs after <test> in XML
    @AfterTest
    public void afterTest() {
        Reporter.log("After Test: Archive logs", true);
    }

    // 15) @AfterSuite - Runs once after all tests in suite
    @AfterSuite
    public void afterSuite() {
        Reporter.log("After Suite: Tear down DB connection or send email", true);
    }
}




/*What This Class Covers:
@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod

@Test with:

priority

groups

dependsOnMethods

enabled

alwaysRun

@DataProvider

@Parameters (from XML)

SoftAssert

SkipException

Reporter.log() to show output in reports

@AfterMethod, @AfterClass, @AfterTest, @AfterSuite
*/