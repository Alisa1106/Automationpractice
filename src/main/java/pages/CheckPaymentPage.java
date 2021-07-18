package pages;

import elements.Button;
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

    public CheckPaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    @Step("Click button 'I confirm my order'")
    public OrderConfirmationByCheckPage clickConfirmOrderButton() {
        log.info("Click button 'I confirm my order'.");
        new Button(driver, "I confirm my order").click();
        return new OrderConfirmationByCheckPage(driver);
    }
}