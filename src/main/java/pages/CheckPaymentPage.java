package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CheckPaymentPage extends HeaderPage {

    public CheckPaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    /**
     * Wait for check payment page opened.
     *
     * @return the check payment page
     */
    public CheckPaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Click confirm order button.
     *
     * @return the order confirmation by check page
     */
    @Step("Click button 'I confirm my order'")
    public OrderConfirmationByCheckPage clickConfirmOrderButton() {
        actions.clickButton(CONFIRM_ORDER_BUTTON);
        return new OrderConfirmationByCheckPage(driver);
    }
}