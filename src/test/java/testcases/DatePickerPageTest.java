package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DatePickerPage;

import org.openqa.selenium.By;
import org.testng.Assert;

public class DatePickerPageTest extends BaseTest {

    @Test
    public void testDatePicker() {
        DatePickerPage datePickerPage = new DatePickerPage(getDriver());
        
        // Set the date and verify it
        datePickerPage.setDate("12/12/2025");
        String selectedDate = getDriver().findElement(By.id("datepicker")).getAttribute("value");
        
        Assert.assertEquals(selectedDate, "12/12/2025", "The date was not set correctly.");
    }
}
