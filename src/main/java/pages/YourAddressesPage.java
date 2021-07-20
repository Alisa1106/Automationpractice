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
        new Input(driver, "Address").clear();
        new Input(driver, "City").clear();
        new Input(driver, "Zip/Postal Code").clear();
        new Input(driver, "Mobile phone").clear();
        new Input(driver, "for future reference.").clear();
        return this;
    }

    @Step("Clear address alias field")
    public YourAddressesPage clearAddressAliasField() {
        new Input(driver, "for future reference.").clear();
        return this;
    }

    @Step("Fill address field: {address}")
    public YourAddressesPage fillAddressField(Address address) {
        new Input(driver, "Address").writeText(address.getAddress());
        new Input(driver, "City").writeText(address.getCity());
        new DropDown(driver, "State").select(address.getState());
        new Input(driver, "Zip/Postal Code").writeText(address.getZipCode());
        new DropDown(driver, "Country").select(address.getCountry());
        new Input(driver, "Mobile phone").writeText(address.getMobilePhone());
        new Input(driver, "for future reference").writeText(address.getAddressAlias());
        return this;
    }

    @Step("Click button 'Save'")
    public MyAddressesPage clickSaveAddressButton() {
        new Button(driver, "Save").click();
        return new MyAddressesPage(driver);
    }
}