package testcases;

import base.BaseTest;
import pages.RefFormElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefFormElementsTest extends BaseTest {

    @Test
    public void testFormSubmission() {
        log.info("=== Starting Form Elements Test ===");

        // Create an instance of FormElementsPage
        RefFormElementsPage formElementsPage = new RefFormElementsPage(getDriver());

        // Fill the basic form fields
        formElementsPage.fillBasicForm("John Doe", "johndoe@example.com", "1234567890", "123 Main St");

        // Select gender (Male)
        formElementsPage.selectGender("male");

        // Select multiple days (e.g., Sunday, Monday, Wednesday)
        formElementsPage.selectDays("sunday", "monday", "wednesday");

        // Select country (e.g., India)
        formElementsPage.selectCountry("India");

        // Submit the form
        formElementsPage.submitForm();

        // Validate success message after form submission
        String successMessage = formElementsPage.getSuccessMessage();
        Assert.assertNotNull(successMessage, "Success message is null");
        Assert.assertTrue(successMessage.contains("Form submitted successfully"), "Form submission failed!");

        log.info("=== Form Elements Test Completed ===");
    }
}
