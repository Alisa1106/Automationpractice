package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

@Log4j2
public class HomePage extends HeaderPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='product-container']";
    public static final String MORE_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'button lnk_view')]";
    public static final String ADD_TO_CART_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'ajax_add_to_cart_button')]";

    /**
     * Open home page.
     *
     * @return the home page
     */
    @Step("Open home page")
    public HomePage openPage() {
        super.openPage(AUTOMATIONPRACTICE_HOME_PAGE_URL);
        return this;
    }

    /**
     * Move to product item.
     *
     * @param productName the product name
     * @return the home page
     */
    public HomePage moveToProductItem(String productName) {
        String productItem = String.format(PRODUCT_ITEM_XPATH, productName);
        waitForElementLocated(By.xpath(productItem), LONG_TIMEOUT);
        WebDriverUtils.moveToElement(driver, productItem);
        return this;
    }

    /**
     * Click more button.
     *
     * @param productName the product name
     * @return the product details page
     */
    @Step("Move to product {productName} and click its button 'More'")
    public ProductDetailsPage clickMoreButton(String productName) {
        log.info(String.format("Move to product '%s'.", productName));
        moveToProductItem(productName);
        log.info(String.format("Click button 'More' for product '%s'.", productName));
        driver.findElement(By.xpath(String.format(MORE_BUTTON_XPATH, productName))).click();
        return new ProductDetailsPage(driver);
    }

    /**
     * Click add to cart button.
     *
     * @param productName the product name
     * @return the product added to cart modal
     */
    @Step("Move to product {productName} and click its button 'Add to cart'")
    public ProductAddedToCartModal clickAddToCartButton(String productName) {
        log.info(String.format("Move to product '%s'.", productName));
        moveToProductItem(productName);
        log.info(String.format("Click button 'Add to cart' for product '%s'.", productName));
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, productName))).click();
        return new ProductAddedToCartModal(driver);
    }
}