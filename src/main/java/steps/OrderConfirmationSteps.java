package steps;

import org.openqa.selenium.WebDriver;
import pages.OrderConfirmationByCheckPage;

public class OrderConfirmationSteps {

    private final OrderConfirmationByCheckPage orderConfirmationByCheckPage;

    public OrderConfirmationSteps(WebDriver driver) {
        orderConfirmationByCheckPage = new OrderConfirmationByCheckPage(driver);
    }

    public String getOrderReference() {
        return orderConfirmationByCheckPage
                .getOrderReference();
    }
}