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

    /**
     * Click proceed to checkout button.
     *
     * @return the shopping cart summary page
     */
    @Step("Click button 'Proceed to checkout'")
    public ShoppingCartSummaryPage clickProceedToCheckoutButton() {
        waitForElementLocated(buttonContainer, SHORT_TIMEOUT);
        log.info("Click button 'Proceed to checkout'.");
        proceedToCheckoutButton.click();
        return new ShoppingCartSummaryPage(driver);
    }

    /**
     * Click close modal cross button.
     *
     * @return the header page
     */
    @Step("Click close modal cross button")
    public HeaderPage clickCloseModalCrossButton() {
        waitForElementLocated(closeModalCrossButton, SHORT_TIMEOUT);
        log.info("Click close modal cross button.");
        closeModalCrossButton.click();
        return new HeaderPage(driver);
    }
}