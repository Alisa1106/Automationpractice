package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ShoppingCartSummaryPage extends HeaderPage {

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    /**
     * Wait for shopping cart summary page opened.
     *
     * @return the shopping cart summary page
     */
    public ShoppingCartSummaryPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Click proceed to checkout button.
     *
     * @return the shopping cart address page
     */
    @Step("Click button 'Proceed to checkout' at summary page")
    public ShoppingCartAddressPage clickProceedToCheckoutButton() {
        actions.clickButton(PROCEED_TO_CHECKOUT_BUTTON);
        return new ShoppingCartAddressPage(driver);
    }
}