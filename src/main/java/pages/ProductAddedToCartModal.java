package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Click button 'Proceed to checkout'")
    public ShoppingCartSummaryPage clickProceedToCheckoutButton() {
        waitForElementLocated(buttonContainer, SHORT_TIMEOUT);
        log.info("Click button 'Proceed to checkout'.");
        proceedToCheckoutButton.click();
        return new ShoppingCartSummaryPage(driver);
    }

    @Step("Click close modal cross button")
    public HeaderPage clickCloseModalCrossButton() {
        waitForElementLocated(closeModalCrossButton, SHORT_TIMEOUT);
        log.info("Click close modal cross button.");
        closeModalCrossButton.click();
        return new HeaderPage(driver);
    }
}