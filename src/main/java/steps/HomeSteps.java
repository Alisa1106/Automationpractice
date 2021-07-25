package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    /**
     * Add product to cart with conditions then go to cart.
     *
     * @param productName     the product name
     * @param productQuantity the product quantity
     * @param size            the size
     * @param color           the color
     * @return the home steps
     */
    @Step("Choose product parameter, add product to cart and proceed to checkout")
    public HomeSteps addProductToCartWithConditionsThenGoToCart(String productName, String productQuantity,
                                                                String size, String color) {
        homePage
                .openPage()
                .clickMoreButton(productName)
                .waitForPageOpened()
                .chooseProductQuantity(productQuantity)
                .selectProductSize(size)
                .choseProductColor(color)
                .clickAddToCartButton()
                .clickProceedToCheckoutButton();
        return this;
    }

    /**
     * Add product to cart with conditions then close added to cart modal.
     *
     * @param productName     the product name
     * @param productQuantity the product quantity
     * @param size            the size
     * @param color           the color
     * @return the home steps
     */
    @Step("Choose product parameter, add product to cart and close added to cart modal")
    public HomeSteps addProductToCartWithConditionsThenCloseAddedToCartModal(String productName, String productQuantity,
                                                                             String size, String color) {
        homePage
                .openPage()
                .clickMoreButton(productName)
                .waitForPageOpened()
                .chooseProductQuantity(productQuantity)
                .selectProductSize(size)
                .choseProductColor(color)
                .clickAddToCartButton()
                .clickCloseModalCrossButton();
        return this;
    }

    /**
     * Add product to cart.
     *
     * @param productName the product name
     * @return the home steps
     */
    @Step("Add product to cart and proceed to checkout")
    public HomeSteps addProductToCart(String productName) {
        homePage
                .openPage()
                .clickAddToCartButton(productName)
                .clickProceedToCheckoutButton();
        return this;
    }
}