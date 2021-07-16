package pages;

import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends HeaderPage {

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    public ShoppingCartSummaryPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public ShoppingCartAddressPage clickProceedToCheckoutButton() {
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartAddressPage(driver);
    }
}