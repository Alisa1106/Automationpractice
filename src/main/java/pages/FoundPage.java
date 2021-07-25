package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FoundPage extends HeaderPage {

    public FoundPage(WebDriver driver) {
        super(driver);
    }

    public static final By SEARCH_RESULTS_XPATH = By.xpath("//*[contains(@class,'product_list')]//*[@class='product-name']");

    @FindBy(id = "//*[@id='center_column']")
    WebElement centerColumn;

    /**
     * Wait for found page opened.
     *
     * @return the found page
     */
    public FoundPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Is search result not empty.
     *
     * @return the boolean
     */
    public boolean isSearchResultNotEmpty() {
        List<WebElement> searchResult = driver.findElements(SEARCH_RESULTS_XPATH);
        return !searchResult.isEmpty();
    }
}