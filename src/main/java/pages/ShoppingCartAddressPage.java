package pages;

import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
        waitForElementLocated(centerColumn, 10);
        return this;
    }

    public ShoppingCartShippingPage clickProceedToCheckoutButton() {
        new Button(driver, "Proceed to checkout").click();
        return new ShoppingCartShippingPage(driver);
    }

    public ShoppingCartAddressPage selectDeliveryAddress(String addressAlias) {
        select = new Select(deliveryAddressSelect);
        select.selectByVisibleText(addressAlias);
        return this;
    }

    public String getSelectedDeliveryAddress() {
        select = new Select(deliveryAddressSelect);
        return select.getFirstSelectedOption().getText();
    }
}