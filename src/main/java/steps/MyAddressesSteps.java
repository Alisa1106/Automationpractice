package steps;

import io.qameta.allure.Step;
import objects.Address;
import org.openqa.selenium.WebDriver;
import pages.MyAddressesPage;

public class MyAddressesSteps {

    private final MyAddressesPage myAddressesPage;

    public MyAddressesSteps(WebDriver driver) {
        myAddressesPage = new MyAddressesPage(driver);
    }

    @Step("Update address with address alias: {addressAlias}")
    public MyAddressesSteps updateAddress(String addressAlias, Address address) {
        myAddressesPage
                .openPage()
                .waitForPageOpened()
                .clickUpdateAddressButton(addressAlias)
                .waitForPageOpened()
                .clearAddressInputFields()
                .fillAddressField(address)
                .clickSaveAddressButton();
        return this;
    }

    @Step("Create new address")
    public MyAddressesSteps createNewAddress(Address address) {
        myAddressesPage
                .openPage()
                .waitForPageOpened()
                .clickAddNewAddressButton()
                .waitForPageOpened()
                .clearAddressAliasField()
                .fillAddressField(address)
                .clickSaveAddressButton();
        return this;
    }

    @Step("Get address from address: {addressAlias}")
    public String getAddress(String addressAlias) {
        return myAddressesPage
                .getAddressLineText(addressAlias);
    }

    @Step("Get mobile phone from address: {addressAlias}")
    public String getMobilePhone(String addressAlias) {
        return myAddressesPage
                .getMobilePhoneLineText(addressAlias);
    }
}