package tests;

import constants.ITestConstants;
import objects.Address;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.PropertyReader;
import utils.Retry;

public class AddressTest extends BaseTest implements ITestData, ITestConstants {

    /**
     * Check that address can be updated.
     *
     * @param address      the address
     * @param city         the city
     * @param state        the state
     * @param zipCode      the zip code
     * @param country      the country
     * @param mobilePhone  the mobile phone
     * @param addressAlias the address alias
     */
    @Test(description = "Check that address can be updated", retryAnalyzer = Retry.class,
            dataProvider = "Update address", dataProviderClass = ITestData.class)
    public void checkAddressUpdatedTest(String address, String city, String state, String zipCode, String country,
                                        String mobilePhone, String addressAlias) {
        Address changingAddress = new Address(address, city, state, zipCode, country, mobilePhone, addressAlias);
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        myAddressesSteps
                .updateAddress(changingAddress.getAddressAlias(), changingAddress);
        Assert.assertEquals(myAddressesSteps.getAddress(changingAddress.getAddressAlias()), changingAddress.getAddress());
        Assert.assertEquals(myAddressesSteps.getMobilePhone(changingAddress.getAddressAlias()), changingAddress.getMobilePhone());
    }

    /**
     * Check new address can be selected as delivery address.
     */
    @Test(description = "Check that created address can be selected as delivery address", retryAnalyzer = Retry.class)
    public void checkNewAddressCanBeSelectedAsDeliveryAddressTest() {
        Address newAddress = new Address(ADDRESS, CITY, STATE, ZIP_CODE, COUNTRY, MOBILE_PHONE, getRandomChar());
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        myAddressesSteps
                .createNewAddress(newAddress);
        homeSteps
                .addProductToCart(PRINTED_CHIFFON_DRESS_PRODUCT);
        shoppingCartAddressSteps
                .goToShoppingCartAddressPageAndSelectDeliveryAddress(newAddress.getAddressAlias());
        Assert.assertEquals(shoppingCartAddressSteps.getSelectedDeliveryAddress(), newAddress.getAddressAlias());
    }
}