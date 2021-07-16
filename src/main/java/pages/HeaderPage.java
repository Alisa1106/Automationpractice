package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverUtils;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final String CART_DROPDOWN_HEADER_XPATH = "//*[@class='shopping_cart']//*[contains(@title,'shopping')]";

    @FindBy(className = "account")
    WebElement myCustomerAccountNameField;

    @FindBy(id = "search_query_top")
    WebElement searchInputField;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    public String getCustomerNameText() {
        waitForElementLocated(myCustomerAccountNameField, SHORT_TIMEOUT);
        return myCustomerAccountNameField.getText();
    }

    public CartDropdown moveToCartDropdown() {
        WebDriverUtils.moveToElement(driver, CART_DROPDOWN_HEADER_XPATH);
        return new CartDropdown(driver);
    }

    public FoundPage searchProduct(String productName) {
        waitForElementLocated(searchInputField, SHORT_TIMEOUT);
        searchInputField.sendKeys(productName);
        searchButton.click();
        return new FoundPage(driver);
    }
}