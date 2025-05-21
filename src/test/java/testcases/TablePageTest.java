package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TablePage;
import org.testng.Assert;

public class TablePageTest extends BaseTest {

    @Test
    public void testTableRows() {
        TablePage tablePage = new TablePage(getDriver());

        // Get the table rows and check if there are any rows
        int rowCount = tablePage.getTableRows().size();
        
        Assert.assertTrue(rowCount > 0, "No rows found in the table.");
    }
}
