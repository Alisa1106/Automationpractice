package steps;

import org.openqa.selenium.WebDriver;
import pages.CartDropdown;
import pages.HeaderPage;
import pages.HomePage;

public class CartDropdownSteps {

    private final CartDropdown cartDropdown;
    private final HomePage homePage;

    public CartDropdownSteps(WebDriver driver) {
        cartDropdown = new CartDropdown(driver);
        homePage = new HomePage(driver);
    }

    public CartDropdownSteps moveToCartHeader() {
        homePage
                .moveToCartDropdownHeader();
        return this;
    }

    public String getProductPriceForOnePiece(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductPriceForOnePiece(productName);
    }

    public String getProductColorAndSize(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductColorAndSize(productName);
    }

    public String getProductQuantity(String productName) {
        return cartDropdown
                .waitForPageOpened()
                .getProductQuantity(productName);
    }
}