package testcases.WholePageAutomation;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WholePageAutomation.FormFillPage;



public class FormFillPageTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(FormFillPage.class);
	@Test
	public void formTesting() {
		
		
       FormFillPage formFillPage=new FormFillPage(getDriver());
       logger.info("Test class:Starting formTesting test");
       
       formFillPage.formFilling("Manasa", "jdhfdhs@gmail.com", "0123456789", "123 main st");
       
       Assert.assertEquals(formFillPage.getname(),"Manasa","Name is not Manasa");
       logger.info("Test Class:formTesting test completed successfully");
       
	}
	
       
		

	}


