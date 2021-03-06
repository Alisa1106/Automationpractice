package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BankWirePaymentPage;

public class BankWirePaymentSteps {

    private final BankWirePaymentPage bankWirePaymentPage;

    public BankWirePaymentSteps(WebDriver driver) {
        bankWirePaymentPage = new BankWirePaymentPage(driver);
    }

    /**
     * Gets total amount of order.
     *
     * @return the total amount of order
     */
    @Step("Open bank wire payment Page and get total amount of order")
    public String getTotalAmountOfOrder() {
        return bankWirePaymentPage
                .waitForPageOpened()
                .getTotalAmountOfOrder();
    }
}