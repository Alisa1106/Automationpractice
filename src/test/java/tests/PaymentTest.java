package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class PaymentTest extends BaseTest implements ITestConstants {

    @Test
    public void checkTotalAmountOfOrderByBankWirePayTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        homeSteps
                .addProductToCart(BLOUSE_PRODUCT);
        shoppingCartSummarySteps
                .goToPayment();
        String totalPrice = shoppingCartPaymentSteps.getTotalPrice();
        shoppingCartPaymentSteps
                .goToPayByBankWire();
        Assert.assertEquals(bankWirePaymentSteps.getTotalAmountOfOrder(), totalPrice);
    }
}