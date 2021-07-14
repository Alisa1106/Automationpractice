package pages;

import elements.Button;
import elements.DropDown;
import elements.Input;
import objects.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAddressesPage extends HeaderPage {

    public YourAddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add_address")
    WebElement addressTable;

    public YourAddressesPage waitForPageOpened() {
        waitForElementLocated(addressTable, 10);
        return this;
    }

    public YourAddressesPage clearAddressInputFields() {
        new Input(driver, "Address").clear();
        new Input(driver, "City").clear();
        new Input(driver, "Zip/Postal Code").clear();
        new Input(driver, "Mobile phone").clear();
        new Input(driver, "for future reference.").clear();
        return this;
    }

    public YourAddressesPage clearAddressAliasField() {
        new Input(driver, "for future reference.").clear();
        return this;
    }

    public YourAddressesPage fillAddressField(Address address) {
        new Input(driver, "Address").writeText(address.getAddress());
        new Input(driver, "City").writeText(address.getCity());
        new DropDown(driver, "State").select(address.getState());
        new Input(driver, "Zip/Postal Code").writeText(address.getZipCode());
        new DropDown(driver, "Country").select(address.getCountry());
        new Input(driver, "Mobile phone").writeText(address.getMobilePhone());
        new Input(driver, "for future reference.").writeText(address.getAddressAlias());
        return this;
    }

    public MyAddressesPage clickSaveAddressButton() {
        new Button(driver, "Save").click();
        return new MyAddressesPage(driver);
    }
}