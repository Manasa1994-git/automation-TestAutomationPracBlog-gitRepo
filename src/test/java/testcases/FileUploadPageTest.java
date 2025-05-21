package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import org.openqa.selenium.By;
import org.testng.Assert;

public class FileUploadPageTest extends BaseTest {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());

        // Provide a valid file path and upload
        String filePath = "/path/to/your/file.txt"; // Update this path
        fileUploadPage.uploadFile(filePath);
        
        // Verify file upload by checking file input field (simple assertion)
        String uploadedFile = getDriver().findElement(By.id("uploadfile_0")).getAttribute("value");
        
        Assert.assertTrue(uploadedFile.contains("file.txt"), "File upload failed.");
    }
}
