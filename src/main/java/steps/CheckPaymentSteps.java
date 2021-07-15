package steps;

import org.openqa.selenium.WebDriver;
import pages.CheckPaymentPage;

public class CheckPaymentSteps {

    private final CheckPaymentPage checkPaymentPage;

    public CheckPaymentSteps(WebDriver driver) {
        checkPaymentPage = new CheckPaymentPage(driver);
    }

    public CheckPaymentSteps confirmOrder() {
        checkPaymentPage
                .waitForPageOpened()
                .clickConfirmOrderButton();
        return this;
    }
}