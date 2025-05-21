package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object Model class for form elements on testautomationpractice.blogspot.com.
 */
public class RefFormElementsPage {
    WebDriver driver;

    // Constructor to initialize WebDriver
    public RefFormElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========== LOCATORS ==========

    // Basic form fields
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By addressField = By.id("textarea");

    // Gender radio buttons
    private By maleRadio = By.id("male");
    private By femaleRadio = By.id("female");

    // Days checkboxes
    private By sundayCheckbox = By.id("sunday");
    private By mondayCheckbox = By.id("monday");
    private By tuesdayCheckbox = By.id("tuesday");
    private By wednesdayCheckbox = By.id("wednesday");
    private By thursdayCheckbox = By.id("thursday");
    private By fridayCheckbox = By.id("friday");
    private By saturdayCheckbox = By.id("saturday");

    // Country dropdown (works like a select box)
    private By countryDropdown = By.id("country");

    // Submit button
    private By submitButton = By.id("submit");

    // Success message after form submission
    private By successMessage = By.id("successMessage");

    // ========== ACTION METHODS ==========

    /**
     * Fills the basic form fields (Name, Email, Phone, Address)
     */
    public void fillBasicForm(String name, String email, String phone, String address) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    /**
     * Selects the gender radio button based on input ("male" or "female")
     */
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleRadio).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(femaleRadio).click();
        }
    }

    /**
     * Selects multiple days (checkboxes) by matching text
     */
    public void selectDays(String... days) {
        for (String day : days) {
            switch (day.toLowerCase()) {
                case "sunday":
                    driver.findElement(sundayCheckbox).click(); break;
                case "monday":
                    driver.findElement(mondayCheckbox).click(); break;
                case "tuesday":
                    driver.findElement(tuesdayCheckbox).click(); break;
                case "wednesday":
                    driver.findElement(wednesdayCheckbox).click(); break;
                case "thursday":
                    driver.findElement(thursdayCheckbox).click(); break;
                case "friday":
                    driver.findElement(fridayCheckbox).click(); break;
                case "saturday":
                    driver.findElement(saturdayCheckbox).click(); break;
            }
        }
    }

    /**
     * Selects a country from the dropdown (by visible text)
     */
    public void selectCountry(String country) {
        driver.findElement(countryDropdown).sendKeys(country); // type in the dropdown
    }

    /**
     * Clicks the submit button
     */
    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    /**
     * Gets the success message after form submission
     */
    public String getSuccessMessage() {
        WebElement successMessageElement = driver.findElement(successMessage);
        return successMessageElement != null ? successMessageElement.getText() : null;
    }
}
