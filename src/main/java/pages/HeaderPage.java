package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverUtils;

@Log4j2
public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final String CART_DROPDOWN_XPATH = "//*[@class='shopping_cart']//*[contains(@title,'shopping')]";

    @FindBy(className = "account")
    WebElement myCustomerAccountNameField;

    @FindBy(id = "search_query_top")
    WebElement searchInputField;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    /**
     * Gets customer name text.
     *
     * @return the customer name text
     */
    public String getCustomerNameText() {
        waitForElementLocated(myCustomerAccountNameField, SHORT_TIMEOUT);
        return myCustomerAccountNameField.getText();
    }

    /**
     * Move to cart dropdown.
     *
     * @return the cart dropdown
     */
    public CartDropdown moveToCartDropdown() {
        log.info("Move to cart dropdown");
        WebDriverUtils.moveToElement(driver, CART_DROPDOWN_XPATH);
        return new CartDropdown(driver);
    }

    /**
     * Search product.
     *
     * @param productName the product name
     * @return the found page
     */
    @Step("Fill in {productName} in search input field and click search button")
    public FoundPage searchProduct(String productName) {
        waitForElementLocated(searchInputField, SHORT_TIMEOUT);
        log.info(String.format("Fill in product name: '%s' in search field.", productName));
        searchInputField.sendKeys(productName);
        log.info("Click search button.");
        searchButton.click();
        return new FoundPage(driver);
    }
}