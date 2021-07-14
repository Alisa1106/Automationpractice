package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    WebDriver driver;
    String label;

    public static final String BUTTON_XPATH = "//*[@id='center_column']//*[contains(text(),'%s')]";

    public Button(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void click() {
        driver.findElement(By.xpath(String.format(BUTTON_XPATH, label))).click();
    }
}