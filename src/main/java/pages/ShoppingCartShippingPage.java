package pages;

import elements.Button;
import elements.Checkbox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartShippingPage extends BasePage {

    public ShoppingCartShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='form']")
    WebElement pageForm;

    public ShoppingCartShippingPage waitForPageOpened() {
        waitForElementLocated(pageForm, SHORT_TIMEOUT);
        return this;
    }

    public ShoppingCartShippingPage markAgreeTermsOfServiceCheckbox() {
        new Checkbox(driver, "cgv").mark();
        return this;
    }

    public ShoppingCartPaymentPage clickProceedToCheckoutButton() {
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartPaymentPage(driver);
    }
}