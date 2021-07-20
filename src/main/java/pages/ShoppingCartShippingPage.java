package pages;

import elements.Button;
import elements.Checkbox;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Mark agree term of service checkbox")
    public ShoppingCartShippingPage markAgreeTermsOfServiceCheckbox() {
        new Checkbox(driver, "cgv").mark();
        return this;
    }

    @Step("Click button 'Proceed to checkout' at shipping page")
    public ShoppingCartPaymentPage clickProceedToCheckoutButton() {
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartPaymentPage(driver);
    }
}