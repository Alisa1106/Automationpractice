package pages;

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

    @FindBy(xpath = "//*[contains(@class,'standard-checkout')]//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    public ShoppingCartShippingPage waitForPageOpened() {
        waitForElementLocated(pageForm, 10);
        return this;
    }

    public ShoppingCartShippingPage markAgreeTermsOfServiceCheckbox() {
        new Checkbox(driver, "cgv").mark();
        return this;
    }

    public ShoppingCartPaymentPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new ShoppingCartPaymentPage(driver);
    }
}