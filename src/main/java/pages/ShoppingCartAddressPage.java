package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartAddressPage extends HeaderPage {

    public ShoppingCartAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    @FindBy(xpath = "//*[@name='processAddress']//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    public ShoppingCartAddressPage waitForPageOpened() {
        waitForElementLocated(centerColumn, 10);
        return this;
    }

    public ShoppingCartShippingPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new ShoppingCartShippingPage(driver);
    }
}