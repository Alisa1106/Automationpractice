package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class YourAddressesPage extends HeaderPage {

    public YourAddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add_address")
    WebElement addressTable;

    /**
     * Wait for your addresses page opened.
     *
     * @return the your addresses page
     */
    public YourAddressesPage waitForPageOpened() {
        waitForElementLocated(addressTable, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Clear address input fields.
     *
     * @return the your addresses page
     */
    @Step("Clear address input fields")
    public YourAddressesPage clearAddressInputFields() {
        actions.clearInputField(ADDRESS);
        actions.clearInputField(CITY);
        actions.clearInputField(ZIP_CODE);
        actions.clearInputField(MOBILE_PHONE);
        actions.clearInputField(ADDRESS_ALIAS);
        return this;
    }

    /**
     * Clear address alias field.
     *
     * @return the your addresses page
     */
    @Step("Clear address alias field")
    public YourAddressesPage clearAddressAliasField() {
        actions.clearInputField(ADDRESS_ALIAS);
        return this;
    }

    /**
     * Fill address field.
     *
     * @param address the address
     * @return the your addresses page
     */
    @Step("Fill address field: {address}")
    public YourAddressesPage fillAddressFields(Address address) {
        actions.fillInputField(ADDRESS, address.getAddress());
        actions.fillInputField(CITY, address.getCity());
        actions.selectOption(STATE, address.getState());
        actions.fillInputField(ZIP_CODE, address.getZipCode());
        actions.selectOption(COUNTRY, address.getCountry());
        actions.fillInputField(MOBILE_PHONE, address.getMobilePhone());
        actions.fillInputField(ADDRESS_ALIAS, address.getAddressAlias());
        return this;
    }

    /**
     * Click save address button.
     *
     * @return the my addresses page
     */
    @Step("Click button 'Save'")
    public MyAddressesPage clickSaveAddressButton() {
        actions.clickButton(SAVE_BUTTON);
        return new MyAddressesPage(driver);
    }
}