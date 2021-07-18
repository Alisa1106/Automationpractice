package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPaymentPage;

public class ShoppingCartPaymentSteps {

    private final ShoppingCartPaymentPage shoppingCartPaymentPage;

    public ShoppingCartPaymentSteps(WebDriver driver) {
        shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
    }

    @Step("Get unit product price for product: {productName}")
    public String getUnitProductPrice(String productName) {
        return shoppingCartPaymentPage
                .getUnitProductPrice(productName);
    }

    @Step("Get product quantity for product: {productName}")
    public String getProductQuantity(String productName) {
        return shoppingCartPaymentPage
                .getProductQuantity(productName);
    }

    @Step("Get product color and size for product: {productName}")
    public String getProductColorAndSize(String productName) {
        return shoppingCartPaymentPage
                .getProductColorAndSize(productName);
    }

    @Step("Go to bank wire")
    public ShoppingCartPaymentSteps goToPayByBankWire() {
        shoppingCartPaymentPage
                .waitForPageOpened()
                .clickPayByBankWireButton();
        return this;
    }

    @Step("Go to pay by check")
    public ShoppingCartPaymentSteps goToPayByCheck() {
        shoppingCartPaymentPage
                .waitForPageOpened()
                .clickPayByCheckButton();
        return this;
    }

    @Step("Get total price")
    public String getTotalPrice() {
        return shoppingCartPaymentPage
                .waitForPageOpened()
                .getTotalPrice();
    }
}