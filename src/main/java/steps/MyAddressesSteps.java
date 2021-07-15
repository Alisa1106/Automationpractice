package steps;

import objects.Address;
import org.openqa.selenium.WebDriver;
import pages.MyAddressesPage;

public class MyAddressesSteps {

    private final MyAddressesPage myAddressesPage;

    public MyAddressesSteps(WebDriver driver) {
        myAddressesPage = new MyAddressesPage(driver);
    }

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

    public String getAddress(String addressAlias) {
        return myAddressesPage
                .getAddressLineText(addressAlias);
    }

    public String getMobilePhone(String addressAlias) {
        return myAddressesPage
                .getMobilePhoneLineText(addressAlias);
    }
}