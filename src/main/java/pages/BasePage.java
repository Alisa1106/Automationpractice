package pages;

import actions.Actions;
import constants.IElementConstants;
import constants.ITimeoutConstants;
import constants.IUrlConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage implements IUrlConstants, ITimeoutConstants, IElementConstants {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url) {
        log.info(String.format("Open URL: '%s'", url));
        driver.get(url);
    }

    /**
     * Wait for element located.
     *
     * @param element the element
     * @param timeout the timeout
     */
    public void waitForElementLocated(WebElement element, int timeout) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            log.error("Element: " + element + " isn't found after " + timeout + e.getLocalizedMessage());
        }
    }

    /**
     * Wait for element located.
     *
     * @param element the element
     * @param timeout the timeout
     */
    public void waitForElementLocated(By element, int timeout) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            log.error("Element: " + element + " isn't found after " + timeout + e.getLocalizedMessage());
        }
    }
}