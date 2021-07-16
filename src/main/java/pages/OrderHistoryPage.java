package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends HeaderPage {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "block-center")
    WebElement ordersTable;

    @FindBy(className = "color-myaccount")
    WebElement orderReference;

    public OrderHistoryPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_ORDER_HISTORY_PAGE_URL);
        return this;
    }

    public OrderHistoryPage waitForPageOpened() {
        waitForElementLocated(ordersTable, SHORT_TIMEOUT);
        return this;
    }

    public String getLastOrderReference() {
        return orderReference.getText();
    }
}