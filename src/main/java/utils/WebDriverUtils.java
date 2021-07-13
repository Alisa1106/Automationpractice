package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtils {

    public static void moveToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
    }
}