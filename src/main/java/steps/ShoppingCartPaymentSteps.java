package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPaymentPage;

public class ShoppingCartPaymentSteps {

    private final ShoppingCartPaymentPage shoppingCartPaymentPage;

    public ShoppingCartPaymentSteps(WebDriver driver) {
        shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
    }

    /**
     * Gets unit product price.
     *
     * @param productName the product name
     * @return the unit product price
     */
    @Step("Get unit product price for product: {productName}")
    public String getUnitProductPrice(String productName) {
        return shoppingCartPaymentPage
                .getUnitProductPrice(productName);
    }

    /**
     * Gets product quantity.
     *
     * @param productName the product name
     * @return the product quantity
     */
    @Step("Get product quantity for product: {productName}")
    public String getProductQuantity(String productName) {
        return shoppingCartPaymentPage
                .getProductQuantity(productName);
    }

    /**
     * Gets product color and size.
     *
     * @param productName the product name
     * @return the product color and size
     */
    @Step("Get product color and size for product: {productName}")
    public String getProductColorAndSize(String productName) {
        return shoppingCartPaymentPage
                .getProductColorAndSize(productName);
    }

    /**
     * Go to pay by bank wire.
     *
     * @return the shopping cart payment steps
     */
    @Step("Go to bank wire")
    public ShoppingCartPaymentSteps goToPayByBankWire() {
        shoppingCartPaymentPage
                .waitForPageOpened()
                .clickPayByBankWireButton();
        return this;
    }

    /**
     * Go to pay by check.
     *
     * @return the shopping cart payment steps
     */
    @Step("Go to pay by check")
    public ShoppingCartPaymentSteps goToPayByCheck() {
        shoppingCartPaymentPage
                .waitForPageOpened()
                .clickPayByCheckButton();
        return this;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    @Step("Get total price")
    public String getTotalPrice() {
        return shoppingCartPaymentPage
                .waitForPageOpened()
                .getTotalPrice();
    }
}