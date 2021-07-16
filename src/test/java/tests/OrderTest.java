package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class OrderTest extends BaseTest implements ITestConstants {

    @Test(description = "Check that when order made its reference displayed at My order page")
    public void checkOrderReferenceAtMyOrderPage() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        homeSteps
                .addProductToCart(BLOUSE_PRODUCT);
        shoppingCartSummarySteps
                .goToPayment();
        shoppingCartPaymentSteps
                .goToPayByCheck();
        checkPaymentSteps
                .confirmOrder();
        String orderReference = orderConfirmationSteps.getOrderReference();
        Assert.assertEquals(orderHistorySteps.getLastOrderReference(), orderReference);
    }
}