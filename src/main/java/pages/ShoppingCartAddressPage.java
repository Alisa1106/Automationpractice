package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ShoppingCartAddressPage extends HeaderPage {

    public ShoppingCartAddressPage(WebDriver driver) {
        super(driver);
    }

    Select select;

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    @FindBy(id = "id_address_delivery")
    WebElement deliveryAddressSelect;

    /**
     * Wait for shopping cart address page opened.
     *
     * @return the shopping cart address page
     */
    public ShoppingCartAddressPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Click proceed to checkout button.
     *
     * @return the shopping cart shipping page
     */
    @Step("Click button 'Proceed to checkout' at address page")
    public ShoppingCartShippingPage clickProceedToCheckoutButton() {
        actions.clickButton(PROCEED_TO_CHECKOUT_BUTTON);
        return new ShoppingCartShippingPage(driver);
    }

    /**
     * Select delivery address.
     *
     * @param addressAlias the address alias
     * @return the shopping cart address page
     */
    @Step("Select address: {addressAlias} as delivery address")
    public ShoppingCartAddressPage selectDeliveryAddress(String addressAlias) {
        select = new Select(deliveryAddressSelect);
        log.info(String.format("Select address: '%s' as delivery address.", addressAlias));
        select.selectByVisibleText(addressAlias);
        return this;
    }

    /**
     * Gets selected delivery address.
     *
     * @return the selected delivery address
     */
    public String getSelectedDeliveryAddress() {
        select = new Select(deliveryAddressSelect);
        return select.getFirstSelectedOption().getText().trim();
    }
}