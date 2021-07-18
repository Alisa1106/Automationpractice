package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartSummaryPage;

public class ShoppingCartSummarySteps {

    private final ShoppingCartSummaryPage shoppingCartSummaryPage;

    public ShoppingCartSummarySteps(WebDriver driver) {
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    }

    @Step("Go to payment")
    public ShoppingCartSummarySteps goToPayment() {
        shoppingCartSummaryPage
                .waitForPageOpened()
                .clickProceedToCheckoutButton()
                .waitForPageOpened()
                .clickProceedToCheckoutButton()
                .waitForPageOpened()
                .markAgreeTermsOfServiceCheckbox()
                .clickProceedToCheckoutButton();
        return this;
    }
}