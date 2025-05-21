package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    private WebDriver driver;

    // Locator for file input field
    private By uploadInput = By.id("uploadfile_0");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Upload file by providing the file path
    public void uploadFile(String filePath) {
        WebElement uploadField = driver.findElement(uploadInput);
        uploadField.sendKeys(filePath);
    }
}
