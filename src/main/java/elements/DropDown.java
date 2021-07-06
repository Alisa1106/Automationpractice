package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    WebDriver driver;
    String label;
    public static final String DROPDOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'required')]";
    public static final String SELECT_OPTION_XPATH = "//*[contains(@class,'form-control')]/descendant::*[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }
}