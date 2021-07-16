package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class FoundPage extends HeaderPage {

    public FoundPage(WebDriver driver) {
        super(driver);
    }

    public static final By SEARCH_RESULTS_XPATH = By.xpath("//*[contains(@class,'product_list')]//*[@class='product-name']");

    public boolean isSearchResultNotEmpty() {
        List<WebElement> searchResult = driver.findElements(SEARCH_RESULTS_XPATH);
        return !searchResult.isEmpty();
    }
}