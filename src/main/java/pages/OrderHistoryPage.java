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

    /**
     * Open order history page.
     *
     * @return the order history page
     */
    @Step("Open order history page")
    public OrderHistoryPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_ORDER_HISTORY_PAGE_URL);
        return this;
    }

    /**
     * Wait for order history page opened.
     *
     * @return the order history page
     */
    public OrderHistoryPage waitForPageOpened() {
        waitForElementLocated(ordersTable, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Gets last order reference.
     *
     * @return the last order reference
     */
    @Step("Get last order reference")
    public String getLastOrderReference() {
        return orderReference.getText();
    }
}