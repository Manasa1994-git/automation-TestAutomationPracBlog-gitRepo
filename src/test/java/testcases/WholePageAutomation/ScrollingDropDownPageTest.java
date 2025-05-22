package testcases.WholePageAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WholePageAutomation.FormFillPage;
import pages.WholePageAutomation.ScrollingDropDownPage;

public class ScrollingDropDownPageTest extends BaseTest{
			
	private static final Logger logger = LogManager.getLogger(ScrollingDropDownPageTest.class);
	
	
	@Test
	public void scrolldropdownTest() {
		logger.info("Scroll Test class: Test started");
		ScrollingDropDownPage scrollingDropDownPage=new ScrollingDropDownPage(getDriver());
		scrollingDropDownPage.scrollDropdownList();
		
		String itemVal=scrollingDropDownPage.getItemValue();
		Assert.assertEquals(itemVal,"Item 50","Item 50 is not selected from dropdown");
		logger.info("Scroll Test class: Test Completed");
		
	}
			
	
	

}
