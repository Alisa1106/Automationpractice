package actions;

import elements.Button;
import elements.Checkbox;
import elements.DropDown;
import elements.Input;
import org.openqa.selenium.WebDriver;

public class Actions {

    WebDriver driver;

    public Actions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click button.
     *
     * @param buttonName the button name
     */
    public void clickButton(String buttonName) {
        new Button(driver, buttonName).click();
    }

    /**
     * Clear input field.
     *
     * @param fieldName the field name
     */
    public void clearInputField(String fieldName) {
        new Input(driver, fieldName).clear();
    }

    /**
     * Fill input field.
     *
     * @param fieldName the field name
     * @param text      the text
     */
    public void fillInputField(String fieldName, String text) {
        new Input(driver, fieldName).writeText(text);
    }

    /**
     * Select option.
     *
     * @param fieldName the field name
     * @param option    the option
     */
    public void selectOption(String fieldName, String option) {
        new DropDown(driver, fieldName).select(option);
    }

    /**
     * Mark checkbox.
     *
     * @param checkboxName the checkbox name
     */
    public void markCheckbox(String checkboxName) {
        new Checkbox(driver, checkboxName).mark();
    }
}