package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    // Capture screenshot and return the file path
    public static String captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        File destFile = new File(filePath);

        try {
            // Copy the screenshot to the desired location
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;  // Return the path of the saved screenshot
    }
}
