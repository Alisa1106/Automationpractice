package steps;

import org.openqa.selenium.WebDriver;
import pages.OrderHistoryPage;

public class OrderHistorySteps {

    private final OrderHistoryPage orderHistoryPage;

    public OrderHistorySteps(WebDriver driver) {
        orderHistoryPage = new OrderHistoryPage(driver);
    }

    public String getLastOrderReference() {
        return orderHistoryPage
                .openPage()
                .waitForPageOpened()
                .getLastOrderReference();
    }
}