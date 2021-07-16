package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

public class HomePage extends HeaderPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='product-container']";
    public static final String MORE_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'button lnk_view')]";
    public static final String ADD_TO_CART_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'ajax_add_to_cart_button')]";

    public HomePage openPage() {
        super.openPage(AUTOMATIONPRACTICE_HOME_PAGE_URL);
        return this;
    }

    public HomePage moveToProductItem(String productName) {
        String productItem = String.format(PRODUCT_ITEM_XPATH, productName);
        waitForElementLocated(By.xpath(productItem), LONG_TIMEOUT);
        WebDriverUtils.moveToElement(driver, productItem);
        return this;
    }

    public ProductDetailsPage clickMoreButton(String productName) {
        moveToProductItem(productName);
        driver.findElement(By.xpath(String.format(MORE_BUTTON_XPATH, productName))).click();
        return new ProductDetailsPage(driver);
    }

    public ProductAddedToCartModal clickAddToCartButton(String productName) {
        moveToProductItem(productName);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, productName))).click();
        return new ProductAddedToCartModal(driver);
    }
}