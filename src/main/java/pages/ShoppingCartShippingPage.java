package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ShoppingCartShippingPage extends HeaderPage {

    public ShoppingCartShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='form']")
    WebElement pageForm;

    /**
     * Wait for shopping cart shipping page opened.
     *
     * @return the shopping cart shipping page
     */
    public ShoppingCartShippingPage waitForPageOpened() {
        waitForElementLocated(pageForm, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Mark agree terms of service checkbox.
     *
     * @return the shopping cart shipping page
     */
    @Step("Mark agree term of service checkbox")
    public ShoppingCartShippingPage markAgreeTermsOfServiceCheckbox() {
        actions.markCheckbox(TERM_OF_SERVICE_CHECKBOX_NAME);
        return this;
    }

    /**
     * Click proceed to checkout button.
     *
     * @return the shopping cart payment page
     */
    @Step("Click button 'Proceed to checkout' at shipping page")
    public ShoppingCartPaymentPage clickProceedToCheckoutButton() {
        actions.clickButton(PROCEED_TO_CHECKOUT_BUTTON);
        return new ShoppingCartPaymentPage(driver);
    }
}