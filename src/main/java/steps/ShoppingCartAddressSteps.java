package steps;

import org.openqa.selenium.WebDriver;
import pages.ShoppingCartAddressPage;
import pages.ShoppingCartSummaryPage;

public class ShoppingCartAddressSteps {

    private final ShoppingCartAddressPage shoppingCartAddressPage;
    private final ShoppingCartSummaryPage shoppingCartSummaryPage;

    public ShoppingCartAddressSteps(WebDriver driver) {
        shoppingCartAddressPage = new ShoppingCartAddressPage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    }

    public ShoppingCartAddressSteps goToShoppingCartAddressPageAndSelectDeliveryAddress(String addressAlias) {
        shoppingCartSummaryPage
                .waitForPageOpened()
                .clickProceedToCheckoutButton()
                .selectDeliveryAddress(addressAlias);
        return this;
    }

    public String getSelectedDeliveryAddress() {
        return shoppingCartAddressPage
                .getSelectedDeliveryAddress();
    }
}