// HomePageTest.java
package testcases.TestNGexamples;

import org.testng.annotations.Test;

public class RegressionTestExample {

    @Test(groups = "regression")
    public void verifyTitle() {
        System.out.println("regression: verifyTitle");
    }

    @Test(groups = "regression")
    public void verifyLinks() {
        System.out.println("Regression: verifyLinks");
    }

    @Test(groups = "sanity")
    public void verifyLogo() {
        System.out.println("Sanity: verifyLogo");
    }
}
