package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.Retry;

public class PaymentTest extends BaseTest implements ITestConstants {

    /**
     * Check total amount of order by bank wire pay.
     */
    @Test(description = "Check total amount of order at Bank wire payment page by bank wire pay", retryAnalyzer = Retry.class)
    public void checkTotalAmountOfOrderByBankWirePayTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
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