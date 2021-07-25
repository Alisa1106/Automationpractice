package tests;

import constants.ITestConstants;
import objects.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.PropertyReader;
import utils.Retry;

public class ShoppingCartTest extends BaseTest implements ITestConstants, ITestData {

    /**
     * Check that chosed product parameters display at Shopping cart payment page correctly.
     */
    @Test(description = "Check that chosed product parameters display at Shopping cart payment page correctly", retryAnalyzer = Retry.class)
    public void checkProductParameterAtShoppingCartPaymentPageTest() {
        Product product = new Product(BLOUSE_PRODUCT, "2", M_PRODUCT_SIZE, WHITE_PRODUCT_COLOR, BLOUSE_PRICE);
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        homeSteps
                .addProductToCartWithConditionsThenGoToCart(product.getName(), product.getQuantity(), product.getSize(), product.getColor());
        shoppingCartSummarySteps
                .goToPayment();
        Assert.assertEquals(shoppingCartPaymentSteps.getProductColorAndSize(product.getName()), "Color : "
                + product.getColor() + ", Size : " + product.getSize());
        Assert.assertEquals(shoppingCartPaymentSteps.getProductQuantity(product.getName()), product.getQuantity());
        Assert.assertEquals(shoppingCartPaymentSteps.getUnitProductPrice(product.getName()), product.getPrice());
    }

    /**
     * Check that chosed product parameters display at Shopping cart dropdown correctly.
     */
    @Test(description = "Check that chosed product parameters display at Shopping cart dropdown correctly", retryAnalyzer = Retry.class)
    public void checkProductParameterAtShoppingCartDropdownTest() {
        Product product = new Product(BLOUSE_PRODUCT, "2", M_PRODUCT_SIZE, WHITE_PRODUCT_COLOR, BLOUSE_PRICE);
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        homeSteps
                .addProductToCartWithConditionsThenCloseAddedToCartModal(product.getName(), product.getQuantity(), product.getSize(), product.getColor());
        cartDropdownSteps
                .moveToCartHeader();
        Assert.assertEquals(cartDropdownSteps.getProductColorAndSize(product.getName()), product.getColor() + ", " + product.getSize());
        Assert.assertEquals(cartDropdownSteps.getProductQuantity(product.getName()), product.getQuantity());
        Assert.assertEquals(cartDropdownSteps.getProductPriceForOneItem(product.getName()), product.getPrice());
    }
}