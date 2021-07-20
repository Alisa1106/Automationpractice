package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class OrderHistoryPage extends HeaderPage {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "block-center")
    WebElement ordersTable;

    @FindBy(className = "color-myaccount")
    WebElement orderReference;

    @Step("Open order history page")
    public OrderHistoryPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_ORDER_HISTORY_PAGE_URL);
        return this;
    }

    public OrderHistoryPage waitForPageOpened() {
        waitForElementLocated(ordersTable, SHORT_TIMEOUT);
        return this;
    }

    @Step("Get last order reference")
    public String getLastOrderReference() {
        return orderReference.getText();
    }
}