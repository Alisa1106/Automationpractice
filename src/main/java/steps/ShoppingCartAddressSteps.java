package steps;

import io.qameta.allure.Step;
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

    /**
     * Go to shopping cart address page and select delivery address.
     *
     * @param addressAlias the address alias
     * @return the shopping cart address steps
     */
    @Step("Go to shopping cart address page and select address with address alias: {addressAlias} as a delivery address")
    public ShoppingCartAddressSteps goToShoppingCartAddressPageAndSelectDeliveryAddress(String addressAlias) {
        shoppingCartSummaryPage
                .waitForPageOpened()
                .clickProceedToCheckoutButton()
                .selectDeliveryAddress(addressAlias);
        return this;
    }

    /**
     * Gets selected delivery address.
     *
     * @return the selected delivery address
     */
    @Step("Get selected delivery address")
    public String getSelectedDeliveryAddress() {
        return shoppingCartAddressPage
                .getSelectedDeliveryAddress();
    }
}