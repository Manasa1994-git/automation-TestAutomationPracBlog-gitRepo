package testcases.WholePageAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WholePageAutomation.SliderPage;

public class SliderPageTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(SliderPageTest.class);
	
	@Test
	public void sliderTest() {
		
	SliderPage sliderPage=new SliderPage(getDriver());//// 'driver' comes from BaseTest,ad webDriver is private and has getter method, we are using getDriver() method
	sliderPage.moveSlider();
	String price=sliderPage.getPriceAmount();
	Assert.assertTrue(price.equals("$224 - $274"),"price is not displayed as expected");
	
	
	   
	}

}
