package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SortedListPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

public class SortedListPageTest extends BaseTest {

    @Test
    public void testSortedList() {
        SortedListPage sortedListPage = new SortedListPage(getDriver());

        // Get the sorted list items and verify they are in correct order
        List<String> listItems = sortedListPage.getSortedListText();
        List<String> sortedList = new ArrayList<>(listItems);
        Collections.sort(sortedList); // Sorting the list for comparison

        Assert.assertEquals(listItems, sortedList, "The list is not sorted correctly.");
    }
}
