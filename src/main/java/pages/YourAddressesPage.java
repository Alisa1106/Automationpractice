package pages;

import elements.Button;
import elements.DropDown;
import elements.Input;
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

    public YourAddressesPage waitForPageOpened() {
        waitForElementLocated(addressTable, SHORT_TIMEOUT);
        return this;
    }

    @Step("Clear address input fields")
    public YourAddressesPage clearAddressInputFields() {
        log.info("Clear address field.");
        new Input(driver, "Address").clear();
        log.info("Clear city field.");
        new Input(driver, "City").clear();
        log.info("Clear zip-code field.");
        new Input(driver, "Zip/Postal Code").clear();
        log.info("Clear mobile phone field.");
        new Input(driver, "Mobile phone").clear();
        log.info("Clear address alias field.");
        new Input(driver, "for future reference.").clear();
        return this;
    }

    @Step("Clear address alias field")
    public YourAddressesPage clearAddressAliasField() {
        log.info("Clear address alias field.");
        new Input(driver, "for future reference.").clear();
        return this;
    }

    @Step("Fill address field: {address}")
    public YourAddressesPage fillAddressField(Address address) {
        log.info(String.format("Fill in address: '%s' in address field.", address.getAddress()));
        new Input(driver, "Address").writeText(address.getAddress());
        log.info(String.format("Fill in city: '%s' in city field.", address.getCity()));
        new Input(driver, "City").writeText(address.getCity());
        log.info(String.format("Select state: '%s' in state dropdown.", address.getState()));
        new DropDown(driver, "State").select(address.getState());
        log.info(String.format("Fill in zip-code: '%s' in zip-code field.", address.getZipCode()));
        new Input(driver, "Zip/Postal Code").writeText(address.getZipCode());
        log.info(String.format("Select country: '%s' in country dropdown.", address.getCountry()));
        new DropDown(driver, "Country").select(address.getCountry());
        log.info(String.format("Fill in mobile phone: '%s' in mobile phone field.", address.getMobilePhone()));
        new Input(driver, "Mobile phone").writeText(address.getMobilePhone());
        log.info(String.format("Fill in address alias: '%s' in address alias field.", address.getAddressAlias()));
        new Input(driver, "for future reference.").writeText(address.getAddressAlias());
        return this;
    }

    @Step("Click button 'Save'")
    public MyAddressesPage clickSaveAddressButton() {
        log.info("Click button 'Save'.");
        new Button(driver, "Save").click();
        return new MyAddressesPage(driver);
    }
}