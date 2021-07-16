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

    public BankWirePaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public String getTotalAmountOfOrder() {
        return totalAmountOfOrder.getText();
    }
}