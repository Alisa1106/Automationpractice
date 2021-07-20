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

    @Step("Move to 'Cart dropdown'")
    public CartDropdownSteps moveToCartHeader() {
        homePage
                .moveToCartDropdown();
        return this;
    }

    @Step("Get product price for one item product: {productName}")
    public String getProductPriceForOneItem(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductPriceForOneItem(productName);
    }

    @Step("Get product color and size for product: {productName}")
    public String getProductColorAndSize(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductColorAndSize(productName);
    }

    @Step("Get product quantity for product: {productName}")
    public String getProductQuantity(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductQuantity(productName);
    }
}