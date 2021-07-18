package pages;

import elements.Button;
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

    public ShoppingCartAddressPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    @Step("Click button 'Proceed to checkout' at address page")
    public ShoppingCartShippingPage clickProceedToCheckoutButton() {
        log.info("Click button 'Proceed to checkout'.");
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartShippingPage(driver);
    }

    @Step("Select address: {addressAlias} as delivery address")
    public ShoppingCartAddressPage selectDeliveryAddress(String addressAlias) {
        select = new Select(deliveryAddressSelect);
        log.info(String.format("Select address: '%s' as delivery address.", addressAlias));
        select.selectByVisibleText(addressAlias);
        return this;
    }

    public String getSelectedDeliveryAddress() {
        select = new Select(deliveryAddressSelect);
        return select.getFirstSelectedOption().getText().trim();
    }
}