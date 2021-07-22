package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartDropdown;
import pages.HomePage;

public class CartDropdownSteps {

    private final CartDropdown cartDropdown;
    private final HomePage homePage;

    public CartDropdownSteps(WebDriver driver) {
        cartDropdown = new CartDropdown(driver);
        homePage = new HomePage(driver);
    }

    /**
     * Move to cart header.
     *
     * @return the cart dropdown steps
     */
    @Step("Move to 'Cart dropdown'")
    public CartDropdownSteps moveToCartHeader() {
        homePage
                .moveToCartDropdown();
        return this;
    }

    /**
     * Gets product price for one item.
     *
     * @param productName the product name
     * @return the product price for one item
     */
    @Step("Get product price for one item product: {productName}")
    public String getProductPriceForOneItem(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductPriceForOneItem(productName);
    }

    /**
     * Gets product color and size.
     *
     * @param productName the product name
     * @return the product color and size
     */
    @Step("Get product color and size for product: {productName}")
    public String getProductColorAndSize(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductColorAndSize(productName);
    }

    /**
     * Gets product quantity.
     *
     * @param productName the product name
     * @return the product quantity
     */
    @Step("Get product quantity for product: {productName}")
    public String getProductQuantity(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductQuantity(productName);
    }
}