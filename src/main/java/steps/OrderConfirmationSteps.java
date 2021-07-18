package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.OrderConfirmationByCheckPage;

public class OrderConfirmationSteps {

    private final OrderConfirmationByCheckPage orderConfirmationByCheckPage;

    public OrderConfirmationSteps(WebDriver driver) {
        orderConfirmationByCheckPage = new OrderConfirmationByCheckPage(driver);
    }

    @Step("Get order reference")
    public String getOrderReference() {
        return orderConfirmationByCheckPage
                .getOrderReference();
    }
}