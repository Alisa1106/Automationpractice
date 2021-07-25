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

    /**
     * Update address.
     *
     * @param addressAlias the address alias
     * @param address      the address
     * @return the my addresses steps
     */
    @Step("Update address with address alias: {addressAlias}")
    public MyAddressesSteps updateAddress(String addressAlias, Address address) {
        myAddressesPage
                .openPage()
                .waitForPageOpened()
                .clickUpdateAddressButton(addressAlias)
                .waitForPageOpened()
                .clearAddressInputFields()
                .fillAddressFields(address)
                .clickSaveAddressButton();
        return this;
    }

    /**
     * Create new address.
     *
     * @param address the address
     * @return the my addresses steps
     */
    @Step("Create new address")
    public MyAddressesSteps createNewAddress(Address address) {
        myAddressesPage
                .openPage()
                .waitForPageOpened()
                .clickAddNewAddressButton()
                .waitForPageOpened()
                .clearAddressAliasField()
                .fillAddressFields(address)
                .clickSaveAddressButton();
        return this;
    }

    /**
     * Gets address.
     *
     * @param addressAlias the address alias
     * @return the address
     */
    @Step("Get address from address: {addressAlias}")
    public String getAddress(String addressAlias) {
        return myAddressesPage
                .getAddressLineText(addressAlias);
    }

    /**
     * Gets mobile phone.
     *
     * @param addressAlias the address alias
     * @return the mobile phone
     */
    @Step("Get mobile phone from address: {addressAlias}")
    public String getMobilePhone(String addressAlias) {
        return myAddressesPage
                .getMobilePhoneLineText(addressAlias);
    }
}