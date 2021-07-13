package tests;

import constants.ITestConstants;
import objects.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class ShoppingCartTest extends BaseTest implements ITestConstants {

    @Test
    public void checkProductParameterAtShoppingCartPaymentPageTest() {
        Product product = new Product(BLOUSE_PRODUCT, "2", M_PRODUCT_SIZE, WHITE_PRODUCT_COLOR, BLOUSE_PRICE);
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        homeSteps
                .addProductToCartWithConditionsThenGoToCart(product.getName(), product.getQuantity(), product.getSize(), product.getColor());
        shoppingCartSummarySteps
                .goToPayment();
        Assert.assertEquals(shoppingCartPaymentSteps.getProductColorAndSize(product.getName()), "Color : "
                + product.getColor() + ", Size : " + product.getSize());
        Assert.assertEquals(shoppingCartPaymentSteps.getProductQuantity(product.getName()), product.getQuantity());
        Assert.assertEquals(shoppingCartPaymentSteps.getUnitProductPrice(product.getName()), product.getPrice());
    }
}