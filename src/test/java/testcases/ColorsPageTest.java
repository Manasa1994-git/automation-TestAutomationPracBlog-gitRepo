package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ColorsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ColorsPageTest extends BaseTest {

    @Test
    public void testMultiSelectColors() {
        // Create an instance of ColorsPage
        ColorsPage colorsPage = new ColorsPage(getDriver()); // Use the thread-local driver

        // Select multiple colors
        colorsPage.selectColors("Red", "Green", "Blue");

        // Verify selected options
        List<WebElement> selectedOptions = colorsPage.getSelectedColors();
        Assert.assertEquals(selectedOptions.size(), 3, "Should select 3 colors");

        // Assert that each selected color is indeed selected
        Assert.assertTrue(selectedOptions.stream().anyMatch(e -> e.getText().equals("Red")), "color red ,Red should be selected");
        Assert.assertTrue(selectedOptions.stream().anyMatch(e -> e.getText().equals("Green")), "Green should be selected");
        Assert.assertTrue(selectedOptions.stream().anyMatch(e -> e.getText().equals("Blue")), "Blue should be selected");

        // Deselect all colors
        colorsPage.deselectAllColors();
        
        // Assert that no colors are selected after deselecting
        Assert.assertEquals(colorsPage.getSelectedColors().size(), 0, "All colors should be deselected");
    }
}
