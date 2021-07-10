package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends HeaderPage {

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    @FindBy(xpath = "//*[contains(@class,'standard-checkout')]//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    public ShoppingCartSummaryPage waitForPageOpened() {
        waitForElementLocated(centerColumn, 10);
        return this;
    }

    public ShoppingCartAddressPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new ShoppingCartAddressPage(driver);
    }
}