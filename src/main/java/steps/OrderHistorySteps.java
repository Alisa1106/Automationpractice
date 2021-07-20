package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.OrderHistoryPage;

public class OrderHistorySteps {

    private final OrderHistoryPage orderHistoryPage;

    public OrderHistorySteps(WebDriver driver) {
        orderHistoryPage = new OrderHistoryPage(driver);
    }

    @Step("Open order history page and get last order reference")
    public String getLastOrderReference() {
        return orderHistoryPage
                .openPage()
                .waitForPageOpened()
                .getLastOrderReference();
    }
}