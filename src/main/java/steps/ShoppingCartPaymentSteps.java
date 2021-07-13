package steps;

import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPaymentPage;

public class ShoppingCartPaymentSteps {

    private final ShoppingCartPaymentPage shoppingCartPaymentPage;

    public ShoppingCartPaymentSteps(WebDriver driver) {
        shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
    }

    public String getUnitProductPrice(String productName) {
        return shoppingCartPaymentPage
                .getUnitProductPrice(productName);
    }

    public String getProductQuantity(String productName) {
        return shoppingCartPaymentPage
                .getProductQuantity(productName);
    }

    public String getProductColorAndSize(String productName) {
        return shoppingCartPaymentPage
                .getProductColorAndSize(productName);
    }

    public ShoppingCartPaymentSteps goToPayByBankWire() {
        shoppingCartPaymentPage
                .waitForPageOpened()
                .clickPayByBankWireButton();
        return this;
    }

    public String getTotalPrice() {
        return shoppingCartPaymentPage
                .waitForPageOpened()
                .getTotalPrice();
    }
}