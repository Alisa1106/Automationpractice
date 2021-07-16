package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }

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

    public HomeSteps addProductToCart(String productName) {
        homePage
                .openPage()
                .clickAddToCartButton(productName)
                .clickProceedToCheckoutButton();
        return this;
    }
}