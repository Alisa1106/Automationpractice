package pages;

import elements.Button;
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

    public ShoppingCartSummaryPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    @Step("Click button 'Proceed to checkout' at summary page")
    public ShoppingCartAddressPage clickProceedToCheckoutButton() {
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartAddressPage(driver);
    }
}