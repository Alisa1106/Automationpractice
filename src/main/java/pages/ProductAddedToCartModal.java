package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductAddedToCartModal extends BasePage {

    public ProductAddedToCartModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(className = "button-container")
    WebElement buttonContainer;

    @FindBy(xpath = "//*[@class='cross']")
    WebElement closeModalCrossButton;

    public ShoppingCartSummaryPage clickProceedToCheckoutButton() {
        waitForElementLocated(buttonContainer, SHORT_TIMEOUT);
        proceedToCheckoutButton.click();
        return new ShoppingCartSummaryPage(driver);
    }

    public HeaderPage clickCloseModalCrossButton() {
        waitForElementLocated(closeModalCrossButton, SHORT_TIMEOUT);
        closeModalCrossButton.click();
        return new HeaderPage(driver);
    }
}