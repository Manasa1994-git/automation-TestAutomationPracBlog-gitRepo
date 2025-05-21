package testcases.WholePageAutomation;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.BrokenLinksChecker;

public class BrokenLinksTest extends BaseTest {

    @Test(description = "Check al links on page for broken links")
    public void testBrokenLinks() {
        // driver is available via BaseTest.getDriver()
        BrokenLinksChecker.checkAllLinks(getDriver());
    }
}


/*
1)Finding All Links:
2)HTTP HEAD Requests to Each Link:
3)Logging Results:If the response code is 400 or above, it logs as a broken link with error level.

If the response code is below 400 (e.g., 200 OK), it logs as a valid link.

If a link’s href is empty or malformed, it skips with a warning.
4)The log file (your configured log4j output) 
will contain the results for all links checked, showing 
which links were valid and which were broken.
*/