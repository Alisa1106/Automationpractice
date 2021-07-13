package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;
    String label;
    public static final String CHECKBOX_XPATH = "//*[contains(@class,'checker')]//*[@id='%s']";

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void mark() {
        driver.findElement(By.xpath(String.format(CHECKBOX_XPATH, label))).click();
    }
}