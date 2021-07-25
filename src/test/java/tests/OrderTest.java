package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.Retry;

public class OrderTest extends BaseTest implements ITestConstants {

    /**
     * Check that when order made its order reference displayed at my order page.
     */
    @Test(description = "Check that when order made its reference displayed at My order page", retryAnalyzer = Retry.class)
    public void checkOrderReferenceAtMyOrderPageTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
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