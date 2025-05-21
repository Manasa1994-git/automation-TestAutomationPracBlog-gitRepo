package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private static String reportFilePath;

    // Get ExtentReports instance (create if null)
    public static ExtentReports getReporterInstance() {
        if (extentReports == null) {
            try {
                // Ensure the reports folder exists
                File reportsDir = new File(System.getProperty("user.dir") + "/reports");
                if (!reportsDir.exists()) {
                    reportsDir.mkdirs();
                    System.out.println("Created reports directory: " + reportsDir.getAbsolutePath());
                }

                // Create timestamped report file
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                reportFilePath = reportsDir.getAbsolutePath() + "/ExtentReports_" + timestamp + ".html";

                // Set up reporter
                sparkReporter = new ExtentSparkReporter(reportFilePath);
                sparkReporter.config().setReportName("Test Automation Report");
                sparkReporter.config().setDocumentTitle("Test Results");

                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);

                // Add system info
                extentReports.setSystemInfo("OS", System.getProperty("os.name"));
                extentReports.setSystemInfo("Tester", "Manasa");
                extentReports.setSystemInfo("Environment", "QA");

                System.out.println("ExtentReports initialized at: " + reportFilePath);
            } catch (Exception e) {
                System.out.println("Error initializing ExtentReports: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return extentReports;
    }

    // Create test and store in ThreadLocal
    public static ExtentTest createTest(String testName) {
        ExtentTest test = getReporterInstance().createTest(testName);
        extentTest.set(test);
        return test;
    }

    // Get current test
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Attach screenshot with proper try-catch for IOException
    public static void addScreenshot(WebDriver driver, String testName) {
        
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testName);
            getTest().addScreenCaptureFromPath(screenshotPath);
        
    }

    // Flush report
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
            System.out.println("Extent report flushed: " + reportFilePath);
        } else {
            System.out.println("ExtentReports not initialized.");
        }
    }

    // Open report in system browser
    public static void openReport() {
        try {
            File reportFile = new File(reportFilePath);
            if (reportFile.exists()) {
                String os = System.getProperty("os.name").toLowerCase();
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(reportFile);
                    System.out.println("Report opened in browser: " + reportFile.getAbsolutePath());
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec("open " + reportFile.getAbsolutePath());
                } else if (os.contains("nix") || os.contains("nux")) {
                    Runtime.getRuntime().exec("xdg-open " + reportFile.getAbsolutePath());
                } else if (os.contains("win")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + reportFile.getAbsolutePath());
                } else {
                    System.out.println("Cannot determine OS to open file. Manually open: " + reportFile.getAbsolutePath());
                }
            } else {
                System.out.println("Report file not found: " + reportFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Failed to open report: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
