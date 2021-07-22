package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankWirePaymentPage extends HeaderPage {

    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "amount")
    WebElement totalAmountOfOrder;

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    /**
     * Wait for bank wire payment page opened.
     *
     * @return the bank wire payment page
     */
    public BankWirePaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Gets total amount of order.
     *
     * @return the total amount of order
     */
    public String getTotalAmountOfOrder() {
        return totalAmountOfOrder.getText();
    }
}