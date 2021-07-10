package steps;

import org.openqa.selenium.WebDriver;
import pages.BankWirePaymentPage;

public class BankWirePaymentSteps {

    private final BankWirePaymentPage bankWirePaymentPage;

    public BankWirePaymentSteps(WebDriver driver) {
        bankWirePaymentPage = new BankWirePaymentPage(driver);
    }

    public String getTotalAmountOfOrder() {
        return bankWirePaymentPage
                .waitForPageOpened()
                .getTotalAmountOfOrder();
    }
}