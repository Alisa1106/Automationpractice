package pages;

import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPaymentPage extends HeaderPage {

    public CheckPaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    public CheckPaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public OrderConfirmationByCheckPage clickConfirmOrderButton() {
        new Button(driver, "I confirm my order").click();
        return new OrderConfirmationByCheckPage(driver);
    }
}